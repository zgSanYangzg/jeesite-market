/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.entity;

import org.hibernate.validator.constraints.Length;

import com.jeesite.common.entity.DataEntity;
import com.jeesite.common.mybatis.annotation.Column;
import com.jeesite.common.mybatis.annotation.Table;
import com.jeesite.common.mybatis.mapper.query.QueryType;

/**
 * 商品管理Entity
 * @author zg
 * @version 2020-09-08
 */
@Table(name="market_good", alias="a", columns={
		@Column(name="id", attrName="id", label="编号", isPK=true),
		@Column(includeEntity=DataEntity.class),
		@Column(name="barcode", attrName="barcode", label="条码", isQuery=false),
		@Column(name="good_type", attrName="goodType", label="类型"),
		@Column(name="good_self_code", attrName="goodSelfCode", label="自编码", isQuery=false),
		@Column(name="good_name", attrName="goodName", label="名称", queryType=QueryType.LIKE),
		@Column(name="good_short_name", attrName="goodShortName", label="简称", isQuery=false),
		@Column(name="good_unit", attrName="goodUnit", label="单位", isQuery=false),
		@Column(name="good_label", attrName="goodLabel", label="标签", isQuery=false),
		@Column(name="good_level", attrName="goodLevel", label="等级", isQuery=false),
		@Column(name="good_shelf_no", attrName="goodShelfNo", label="货架号", isQuery=false),
		@Column(name="good_packaging_specs", attrName="goodPackagingSpecs", label="包装规格", isQuery=false),
		@Column(name="good_origin", attrName="goodOrigin", label="产地", isQuery=false),
		@Column(name="good_cost_price", attrName="goodCostPrice", label="成本价", isQuery=false),
		@Column(name="good_sale_price", attrName="goodSalePrice", label="销售价", isQuery=false),
		@Column(name="good_suggest_price", attrName="goodSuggestPrice", label="建议价", isQuery=false),
		@Column(name="store_count", attrName="storeCount", label="库存"),
	}, orderBy="a.update_date DESC"
)
public class MarketGood extends DataEntity<MarketGood> {
	
	private static final long serialVersionUID = 1L;
	private String barcode;		// 条码
	private String goodType;		// 类型
	private String goodSelfCode;		// 自编码
	private String goodName;		// 名称
	private String goodShortName;		// 简称
	private String goodUnit;		// 单位
	private String goodLabel;		// 标签
	private String goodLevel;		// 等级
	private Long goodShelfNo;		// 货架号
	private String goodPackagingSpecs;		// 包装规格
	private String goodOrigin;		// 产地
	private Double goodCostPrice;		// 成本价
	private Double goodSalePrice;		// 销售价
	private Double goodSuggestPrice;		// 建议价
	private Integer storeCount;		// 库存
	
	public MarketGood() {
		this(null);
	}

	public MarketGood(String id){
		super(id);
	}
	
	@Length(min=0, max=20, message="条码长度不能超过 20 个字符")
	public String getBarcode() {
		return barcode;
	}

	public void setBarcode(String barcode) {
		this.barcode = barcode;
	}
	
	@Length(min=0, max=1, message="类型长度不能超过 1 个字符")
	public String getGoodType() {
		return goodType;
	}

	public void setGoodType(String goodType) {
		this.goodType = goodType;
	}
	
	@Length(min=0, max=20, message="自编码长度不能超过 20 个字符")
	public String getGoodSelfCode() {
		return goodSelfCode;
	}

	public void setGoodSelfCode(String goodSelfCode) {
		this.goodSelfCode = goodSelfCode;
	}
	
	@Length(min=0, max=100, message="名称长度不能超过 100 个字符")
	public String getGoodName() {
		return goodName;
	}

	public void setGoodName(String goodName) {
		this.goodName = goodName;
	}
	
	@Length(min=0, max=50, message="简称长度不能超过 50 个字符")
	public String getGoodShortName() {
		return goodShortName;
	}

	public void setGoodShortName(String goodShortName) {
		this.goodShortName = goodShortName;
	}
	
	@Length(min=0, max=1, message="单位长度不能超过 1 个字符")
	public String getGoodUnit() {
		return goodUnit;
	}

	public void setGoodUnit(String goodUnit) {
		this.goodUnit = goodUnit;
	}
	
	@Length(min=0, max=255, message="标签长度不能超过 255 个字符")
	public String getGoodLabel() {
		return goodLabel;
	}

	public void setGoodLabel(String goodLabel) {
		this.goodLabel = goodLabel;
	}
	
	@Length(min=0, max=50, message="等级长度不能超过 50 个字符")
	public String getGoodLevel() {
		return goodLevel;
	}

	public void setGoodLevel(String goodLevel) {
		this.goodLevel = goodLevel;
	}
	
	public Long getGoodShelfNo() {
		return goodShelfNo;
	}

	public void setGoodShelfNo(Long goodShelfNo) {
		this.goodShelfNo = goodShelfNo;
	}
	
	@Length(min=0, max=255, message="包装规格长度不能超过 255 个字符")
	public String getGoodPackagingSpecs() {
		return goodPackagingSpecs;
	}

	public void setGoodPackagingSpecs(String goodPackagingSpecs) {
		this.goodPackagingSpecs = goodPackagingSpecs;
	}
	
	@Length(min=0, max=255, message="产地长度不能超过 255 个字符")
	public String getGoodOrigin() {
		return goodOrigin;
	}

	public void setGoodOrigin(String goodOrigin) {
		this.goodOrigin = goodOrigin;
	}
	
	public Double getGoodCostPrice() {
		return goodCostPrice;
	}

	public void setGoodCostPrice(Double goodCostPrice) {
		this.goodCostPrice = goodCostPrice;
	}
	
	public Double getGoodSalePrice() {
		return goodSalePrice;
	}

	public void setGoodSalePrice(Double goodSalePrice) {
		this.goodSalePrice = goodSalePrice;
	}
	
	public Double getGoodSuggestPrice() {
		return goodSuggestPrice;
	}

	public void setGoodSuggestPrice(Double goodSuggestPrice) {
		this.goodSuggestPrice = goodSuggestPrice;
	}
	
	public Integer getStoreCount() {
		return storeCount;
	}

	public void setStoreCount(Integer storeCount) {
		this.storeCount = storeCount;
	}
	
}