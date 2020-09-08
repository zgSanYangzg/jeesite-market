/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.market.entity.MarketGood;
import com.jeesite.modules.market.dao.MarketGoodDao;
import com.jeesite.modules.file.utils.FileUploadUtils;

/**
 * 商品管理Service
 * @author zg
 * @version 2020-09-02
 */
@Service
@Transactional(readOnly=true)
public class MarketGoodService extends CrudService<MarketGoodDao, MarketGood> {
	
	/**
	 * 获取单条数据
	 * @param marketGood
	 * @return
	 */
	@Override
	public MarketGood get(MarketGood marketGood) {
		return super.get(marketGood);
	}
	
	/**
	 * 查询分页数据
	 * @param marketGood 查询条件
	 * @param marketGood.page 分页对象
	 * @return
	 */
	@Override
	public Page<MarketGood> findPage(MarketGood marketGood) {
		return super.findPage(marketGood);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param marketGood
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MarketGood marketGood) {
		super.save(marketGood);
		// 保存上传图片
		FileUploadUtils.saveFileUpload(marketGood.getId(), "marketGood_image");
	}
	
	/**
	 * 更新状态
	 * @param marketGood
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MarketGood marketGood) {
		super.updateStatus(marketGood);
	}
	
	/**
	 * 删除数据
	 * @param marketGood
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MarketGood marketGood) {
		super.delete(marketGood);
	}
	
}