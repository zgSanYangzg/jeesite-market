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
 * 进货管理Entity
 * @author zg
 * @version 2020-09-05
 */
@Table(name="market_purchase_good", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="good_name", attrName="goodName", label="商品名称", queryType=QueryType.LIKE),
		@Column(name="product_date", attrName="productDate", label="生产日期", isQuery=false),
		@Column(name="suggested_price", attrName="suggestedPrice", label="建议价格", isQuery=false),
		@Column(name="in_price", attrName="inPrice", label="进价", isQuery=false),
		@Column(name="good_num", attrName="goodNum", label="数量", isQuery=false),
		@Column(name="good_count", attrName="goodCount", label="小计", isQuery=false),
		@Column(name="pay_date", attrName="payDate", label="付款日期", isQuery=false),
		@Column(name="cost_price", attrName="costPrice", label="成本价格", isQuery=false),
		@Column(name="sale_price", attrName="salePrice", label="销售价格", isQuery=false),
		@Column(name="membership_price", attrName="membershipPrice", label="会员价格", isQuery=false),
		@Column(name="good_unit", attrName="goodUnit", label="单位", isQuery=false),
		@Column(name="market_purchase_id", attrName="marketPurchaseId.id", label="父表market_purchase主键", isQuery=false),
		@Column(name="good_barcode", attrName="goodBarcode", label="商品条码", isQuery=false),
	}, orderBy="a.create_date ASC"
)
public class MarketPurchaseGood extends DataEntity<MarketPurchaseGood> {
	
	private static final long serialVersionUID = 1L;
	private String goodName;		// 商品名称
	private Date productDate;		// 生产日期
	private Double suggestedPrice;		// 建议价格
	private Double inPrice;		// 进价
	private Long goodNum;		// 数量
	private Double goodCount;		// 小计
	private Date payDate;		// 付款日期
	private Double costPrice;		// 成本价格
	private Double salePrice;		// 销售价格
	private Double membershipPrice;		// 会员价格
	private String goodUnit;		// 单位
	private MarketPurchase marketPurchaseId;		// 父表market_purchase主键 父类
	private String goodBarcode;		// 商品条码
	
	public MarketPurchaseGood() {
		this(null);
	}


	public MarketPurchaseGood(MarketPurchase marketPurchaseId){
		this.marketPurchaseId = marketPurchaseId;
	}
	
	@Length(min=0, max=200, message="商品名称长度不能超过 200 个字符")
	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getProductDate() {
		return productDate;
	}

	public void setProductDate(Date productDate) {
		this.productDate = productDate;
	}
	
	public Double getSuggestedPrice() {
		return suggestedPrice;
	}

	public void setSuggestedPrice(Double suggestedPrice) {
		this.suggestedPrice = suggestedPrice;
	}
	
	public Double getInPrice() {
		return inPrice;
	}

	public void setInPrice(Double inPrice) {
		this.inPrice = inPrice;
	}
	
	public Long getGoodNum() {
		return goodNum;
	}

	public void setGoodNum(Long goodNum) {
		this.goodNum = goodNum;
	}
	
	public Double getGoodCount() {
		return goodCount;
	}

	public void setGoodCount(Double goodCount) {
		this.goodCount = goodCount;
	}
	
	@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
	public Date getPayDate() {
		return payDate;
	}

	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}
	
	public Double getCostPrice() {
		return costPrice;
	}

	public void setCostPrice(Double costPrice) {
		this.costPrice = costPrice;
	}
	
	public Double getSalePrice() {
		return salePrice;
	}

	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}
	
	public Double getMembershipPrice() {
		return membershipPrice;
	}

	public void setMembershipPrice(Double membershipPrice) {
		this.membershipPrice = membershipPrice;
	}
	
	@Length(min=0, max=1, message="单位长度不能超过 1 个字符")
	public String getGoodUnit() {
		return goodUnit;
	}

	public void setGoodUnit(String goodUnit) {
		this.goodUnit = goodUnit;
	}
	
	@Length(min=0, max=64, message="父表market_purchase主键长度不能超过 64 个字符")
	public MarketPurchase getMarketPurchaseId() {
		return marketPurchaseId;
	}

	public void setMarketPurchaseId(MarketPurchase marketPurchaseId) {
		this.marketPurchaseId = marketPurchaseId;
	}
	
	@Length(min=0, max=50, message="商品条码长度不能超过 50 个字符")
	public String getGoodBarcode() {
		return goodBarcode;
	}

	public void setGoodBarcode(String goodBarcode) {
		this.goodBarcode = goodBarcode;
	}
	
}