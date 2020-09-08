/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jeesite.common.entity.Page;
import com.jeesite.common.service.CrudService;
import com.jeesite.modules.market.entity.MarketSupplier;
import com.jeesite.modules.market.dao.MarketSupplierDao;

/**
 * 供应商管理Service
 * @author zg
 * @version 2020-09-02
 */
@Service
@Transactional(readOnly=true)
public class MarketSupplierService extends CrudService<MarketSupplierDao, MarketSupplier> {
	
	/**
	 * 获取单条数据
	 * @param marketSupplier
	 * @return
	 */
	@Override
	public MarketSupplier get(MarketSupplier marketSupplier) {
		return super.get(marketSupplier);
	}

	public List<MarketSupplier> findList() {
		return super.findList(new MarketSupplier());
	}
	/**
	 * 查询分页数据
	 * @param marketSupplier 查询条件
	 * @param marketSupplier.page 分页对象
	 * @return
	 */
	@Override
	public Page<MarketSupplier> findPage(MarketSupplier marketSupplier) {
		return super.findPage(marketSupplier);
	}
	
	/**
	 * 保存数据（插入或更新）
	 * @param marketSupplier
	 */
	@Override
	@Transactional(readOnly=false)
	public void save(MarketSupplier marketSupplier) {
		super.save(marketSupplier);
	}
	
	/**
	 * 更新状态
	 * @param marketSupplier
	 */
	@Override
	@Transactional(readOnly=false)
	public void updateStatus(MarketSupplier marketSupplier) {
		super.updateStatus(marketSupplier);
	}
	
	/**
	 * 删除数据
	 * @param marketSupplier
	 */
	@Override
	@Transactional(readOnly=false)
	public void delete(MarketSupplier marketSupplier) {
		super.delete(marketSupplier);
	}
	
}