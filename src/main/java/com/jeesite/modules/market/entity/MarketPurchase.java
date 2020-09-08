/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.entity;

import org.hibernate.validator.constraints.Length;
import java.util.Date;
import com.jeesite.common.mybatis.annotation.JoinTable;
import com.jeesite.common.mybatis.annotation.JoinTable.Type;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.List;
import com.jeesite.common.collect.ListUtils;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 进货管理Entity
 * @author zg
 * @version 2020-09-05
 */
@Table(name="market_purchase", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(name="purchase_order_no", attrName="purchaseOrderNo", label="订单编号"),
		@Column(name="purchase_date", attrName="purchaseDate", label="进货日期"),
		@Column(name="supplier_id", attrName="supplierId", label="供应商id", isQuery=false),
		@Column(name="supplier_name", attrName="supplierName", label="供应商名称", isInsert=false, isUpdate=false, isQuery=false),
		@Column(name="purchase_label", attrName="purchaseLabel", label="标签", isQuery=false),
		@Column(includeEntity=DataEntity.class),
		@Column(name="total_money", attrName="totalMoney", label="进货总额", isQuery=false),
		@Column(name="pay_state", attrName="payState", label="付款状态", isQuery=false),
		@Column(name="pay_date", attrName="payDate", label="付款日期", isQuery=false),
		@Column(name="payable_money", attrName="payableMoney", label="应付金额", isQuery=false),
		@Column(name="paid_money", attrName="paidMoney", label="实付金额", isQuery=false),
	}, orderBy="a.update_date DESC"
)
public class MarketPurchase extends DataEntity<MarketPurchase> {
	
	private static final long serialVersionUID = 1L;
	private String purchaseOrderNo;		// 订单编号
	private Date purchaseDate;		// 进货日期
	private String supplierId;		// 供应商id
	private String supplierName;		// 供应商名称
	private String purchaseLabel;		// 标签
	private Double totalMoney;		// 进货总额
	private String payState;		// 付款状态
	private Date payDate;		// 付款日期
	private Double payableMoney;		// 应付金额
	private Double paidMoney;		// 实付金额
	private List<MarketPurchaseGood> marketPurchaseGoodList = ListUtils.newArrayList();		// 子表列表
	
	public MarketPurchase() {
		this(null);
	}

	public MarketPurchase(String id){
		super(id);
	}
	
	@Length(min=0, max=50, message="订单编号长度不能超过 50 个字符")
	public String getPurchaseOrderNo() {
		return purchaseOrderNo;
	}

	public void setPurchaseOrderNo(String purchaseOrderNo) {
		this.purchaseOrderNo = purchaseOrderNo;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	
	@Length(min=0, max=64, message="供应商id长度不能超过 64 个字符")
	public String getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(String supplierId) {
		this.supplierId = supplierId;
	}
	
	@Length(min=0, max=200, message="供应商名称长度不能超过 200 个字符")
	public String getSupplierName() {
		return supplierName;
	}

	public void setSupplierName(String supplierName) {
		this.supplierName = supplierName;
	}
	
	@Length(min=0, max=10, message="标签长度不能超过 10 个字符")
	public String getPurchaseLabel() {
		return purchaseLabel;
	}

	public void setPurchaseLabel(String purchaseLabel) {
		this.purchaseLabel = purchaseLabel;
	}
	
	public Double getTotalMoney() {
		return totalMoney;
	}

	public void setTotalMoney(Double totalMoney) {
		this.totalMoney = totalMoney;
	}
	
	@Length(min=0, max=1, message="付款状态长度不能超过 1 个字符")
	public String getPayState() {
		return payState;
	}

	public void setPayState(String payState) {
		this.payState = payState;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	public Double getPayableMoney() {
		return payableMoney;
	}

	public void setPayableMoney(Double payableMoney) {
		this.payableMoney = payableMoney;
	}
	
	public Double getPaidMoney() {
		return paidMoney;
	}

	public void setPaidMoney(Double paidMoney) {
		this.paidMoney = paidMoney;
	}
	
	public List<MarketPurchaseGood> getMarketPurchaseGoodList() {
		return marketPurchaseGoodList;
	}

	public void setMarketPurchaseGoodList(List<MarketPurchaseGood> marketPurchaseGoodList) {
		this.marketPurchaseGoodList = marketPurchaseGoodList;
	}
	
}