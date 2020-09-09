/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.service;

import java.util.List;

import com.jeesite.modules.market.dao.MarketGoodDao;
import com.jeesite.modules.market.entity.MarketGood;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.market.entity.MarketPurchase;
import com.jeesite.modules.market.dao.MarketPurchaseDao;
import com.jeesite.modules.market.entity.MarketPurchaseGood;
import com.jeesite.modules.market.dao.MarketPurchaseGoodDao;

/**
 * 进货管理Service
 * @author zg
 * @version 2020-09-08
 */
@Service
@Transactional(readOnly=true)
public class MarketPurchaseService extends CrudService<MarketPurchaseDao, MarketPurchase> {
	
	@Autowired
	private MarketPurchaseGoodDao marketPurchaseGoodDao;
	
	@Autowired
	private MarketGoodDao marketGoodDao;

	/**
	 * 获取单条数据
	 * @param marketPurchase
	 * @return
	 */
	@Override
	public MarketPurchase get(MarketPurchase marketPurchase) {
		MarketPurchase entity = super.get(marketPurchase);
		if (entity != null){
			MarketPurchaseGood marketPurchaseGood = new MarketPurchaseGood(entity);
			marketPurchaseGood.setStatus(MarketPurchaseGood.STATUS_NORMAL);
			entity.setMarketPurchaseGoodList(marketPurchaseGoodDao.findList(marketPurchaseGood));
		}
		return entity;
	}
	
	/**
	 * 查询分页数据
	 * @param marketPurchase 查询条件
	 * @param marketPurchase.page 分页对象
	 * @return
	 */
	@Override
	public Page<MarketPurchase> findPage(MarketPurchase marketPurchase) {
		return super.findPage(marketPurchase);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param marketPurchase
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MarketPurchase marketPurchase) {
		super.save(marketPurchase);
		// 保存 MarketPurchase子表

		// todo 存商品 存库存
		for (MarketPurchaseGood marketPurchaseGood : marketPurchase.getMarketPurchaseGoodList()){
			if (!MarketPurchaseGood.STATUS_DELETE.equals(marketPurchaseGood.getStatus())){
				marketPurchaseGood.setMarketPurchaseId(marketPurchase);
				if (marketPurchaseGood.getIsNewRecord()){
					marketPurchaseGoodDao.insert(marketPurchaseGood);
					if (marketPurchaseGood!=null&&marketPurchaseGood.getGoodBarcode()!=null&&
							marketPurchaseGood.getGoodNum()!=null) {
						if(marketGoodDao.findByBarCode(marketPurchaseGood.getGoodBarcode())==null){
							logger.info("不存在商品,需要存储");
							MarketGood marketGood = new MarketGood();
							marketGood.setBarcode(marketPurchaseGood.getGoodBarcode());
							marketGood.setGoodName(marketPurchaseGood.getGoodName());
							marketGood.setStoreCount(marketPurchaseGood.getGoodNum().intValue());
							marketGood.setGoodSuggestPrice(marketPurchaseGood.getSalePrice());
							marketGood.setGoodSalePrice(marketPurchaseGood.getSalePrice());
							marketGoodDao.insert(marketGood);

						}else{//增加库存
							MarketGood marketGood = new MarketGood();
							marketGood.setBarcode(marketPurchaseGood.getGoodBarcode());
							marketGood.setStoreCount(marketPurchaseGood.getGoodNum().intValue());
							marketGoodDao.updateByCustom(marketGood);
						}
					}
				}else{
					marketPurchaseGoodDao.update(marketPurchaseGood);
				}

			}else{
				marketPurchaseGoodDao.delete(marketPurchaseGood);
			}
		}
	}
	
	/**
	 * 更新状态
	 * @param marketPurchase
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MarketPurchase marketPurchase) {
		super.updateStatus(marketPurchase);
	}
	
	/**
	 * 删除数据
	 * @param marketPurchase
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MarketPurchase marketPurchase) {
		super.delete(marketPurchase);
		MarketPurchaseGood marketPurchaseGood = new MarketPurchaseGood();
		marketPurchaseGood.setMarketPurchaseId(marketPurchase);
		marketPurchaseGoodDao.deleteByEntity(marketPurchaseGood);
	}
	
}