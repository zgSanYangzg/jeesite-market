/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.dao;

import com.jeesite.common.dao.CrudDao;
import com.jeesite.common.mybatis.annotation.MyBatisDao;
import com.jeesite.modules.market.entity.MarketPurchase;

/**
 * 进货管理DAO接口
 * @author zg
 * @version 2020-09-08
 */
@MyBatisDao
public interface MarketPurchaseDao extends CrudDao<MarketPurchase> {
	
}