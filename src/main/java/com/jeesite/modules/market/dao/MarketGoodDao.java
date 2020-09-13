/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.market.entity.MarketGood;

/**
 * 商品管理DAO接口
 * @author zg
 * @version 2020-09-08
 */
@MyBatisDao
public interface MarketGoodDao extends CrudDao<MarketGood> {
	MarketGood findByBarCode(String barcode);

	void updateByCustom(MarketGood marketGood);

	MarketGood findEntityByParam(String parameter);
}