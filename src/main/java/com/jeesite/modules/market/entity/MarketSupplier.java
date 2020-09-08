/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 供应商管理Entity
 * @author zg
 * @version 2020-09-02
 */
@Table(name="market_supplier", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="supplier_name", attrName="supplierName", label="名称", queryType=QueryType.LIKE),
		@Column(name="supplier_phone", attrName="supplierPhone", label="电话", queryType=QueryType.RIGHT_LIKE),
		@Column(name="supplier_addr", attrName="supplierAddr", label="地址", isQuery=false),
		@Column(name="supplier_label", attrName="supplierLabel", label="标签"),
		@Column(name="supplier_near_biz_date", attrName="supplierNearBizDate", label="最近业务时间", isInsert=false),
		@Column(includeEntity=DataEntity.class),
	}, orderBy="a.update_date DESC"
)
public class MarketSupplier extends DataEntity<MarketSupplier> {
	
	private static final long serialVersionUID = 1L;
	private String supplierName;		// 名称
	private String supplierPhone;		// 电话
	private String supplierAddr;		// 地址
	private String supplierLabel;		// 标签
	private Date supplierNearBizDate;		// 最近业务时间
	
	public MarketSupplier() {
		this(null);
	}

	public MarketSupplier(String id){
		super(id);
	}
	
	@Length(min=0, max=200, message="名称长度不能超过 200 个字符")
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	@Length(min=0, max=50, message="电话长度不能超过 50 个字符")
	public String getSupplierPhone() {
		return supplierPhone;
	}

	public void setSupplierPhone(String supplierPhone) {
		this.supplierPhone = supplierPhone;
	}
	
	@Length(min=0, max=200, message="地址长度不能超过 200 个字符")
	public String getSupplierAddr() {
		return supplierAddr;
	}

	public void setSupplierAddr(String supplierAddr) {
		this.supplierAddr = supplierAddr;
	}
	
	@Length(min=0, max=10, message="标签长度不能超过 10 个字符")
	public String getSupplierLabel() {
		return supplierLabel;
	}

	public void setSupplierLabel(String supplierLabel) {
		this.supplierLabel = supplierLabel;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getSupplierNearBizDate() {
		return supplierNearBizDate;
	}

	public void setSupplierNearBizDate(Date supplierNearBizDate) {
		this.supplierNearBizDate = supplierNearBizDate;
	}
	
	public Date getSupplierNearBizDate_gte() {
		return sqlMap.getWhere().getValue("supplier_near_biz_date", QueryType.GTE);
	}

	public void setSupplierNearBizDate_gte(Date supplierNearBizDate) {
		sqlMap.getWhere().and("supplier_near_biz_date", QueryType.GTE, supplierNearBizDate);
	}
	
	public Date getSupplierNearBizDate_lte() {
		return sqlMap.getWhere().getValue("supplier_near_biz_date", QueryType.LTE);
	}

	public void setSupplierNearBizDate_lte(Date supplierNearBizDate) {
		sqlMap.getWhere().and("supplier_near_biz_date", QueryType.LTE, supplierNearBizDate);
	}
	
}