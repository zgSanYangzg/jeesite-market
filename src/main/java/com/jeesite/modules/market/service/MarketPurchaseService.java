/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.service;

import java.util.List;

import com.jeesite.common.lang.DateUtils;
import com.jeesite.common.lang.StringUtils;
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
 * @version 2020-09-05
 */
@Service
@Transactional(readOnly=true)
public class MarketPurchaseService extends CrudService<MarketPurchaseDao, MarketPurchase> {
	
	@Autowired
	private MarketPurchaseGoodDao marketPurchaseGoodDao;
	
	/**
	 * 获取单条数据
	 * @param marketPurchase
	 * @return
	 */
	@Override
	public MarketPurchase get(MarketPurchase marketPurchase) {
		if(StringUtils.isEmpty(marketPurchase.getPurchaseOrderNo()))
			marketPurchase.setPurchaseOrderNo(DateUtils.getDate("yyyyMMddhhss"));
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
		for (MarketPurchaseGood marketPurchaseGood : marketPurchase.getMarketPurchaseGoodList()){
			if (!MarketPurchaseGood.STATUS_DELETE.equals(marketPurchaseGood.getStatus())){
				marketPurchaseGood.setMarketPurchaseId(marketPurchase);
				if (marketPurchaseGood.getIsNewRecord()){
					marketPurchaseGoodDao.insert(marketPurchaseGood);
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