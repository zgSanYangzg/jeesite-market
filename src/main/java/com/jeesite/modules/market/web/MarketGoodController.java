/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jeesite.modules.utils.ThirdGoodApi;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.market.entity.MarketGood;
import com.jeesite.modules.market.service.MarketGoodService;

/**
 * 商品管理Controller
 * @author zg
 * @version 2020-09-08
 */
@Controller
@RequestMapping(value = "${adminPath}/market/marketGood")
public class MarketGoodController extends BaseController {

	@Autowired
	private MarketGoodService marketGoodService;
	@Autowired
	private ThirdGoodApi goodApi;

	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MarketGood get(String id, boolean isNewRecord) {
		return marketGoodService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("market:marketGood:view")
	@RequestMapping(value = {"list", ""})
	public String list(MarketGood marketGood, Model model) {
		model.addAttribute("marketGood", marketGood);
		return "modules/market/marketGoodList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("market:marketGood:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MarketGood> listData(MarketGood marketGood, HttpServletRequest request, HttpServletResponse response) {
		marketGood.setPage(new Page<>(request, response));
		Page<MarketGood> page = marketGoodService.findPage(marketGood);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("market:marketGood:view")
	@RequestMapping(value = "form")
	public String form(MarketGood marketGood, Model model) {
		model.addAttribute("marketGood", marketGood);
		return "modules/market/marketGoodForm";
	}
	@RequiresPermissions("market:marketGood:view")
	@RequestMapping(value = "getGoodInfoByBarCode")
	@ResponseBody
	public String getGoodInfoByBarCode(String barCode) {
		goodApi.setBarCode(barCode);
		String info = goodApi.deal();
		//{"code":1,"msg":"数据返回成功！","data":{"goodsName":"农夫山泉 饮用天然水550ml","barcode":"6921168509256","price":"1.50","brand":"农夫山泉","supplier":"农夫山泉股份有限公司","standard":"550ml"}}
		System.out.println(info);
		return info;
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("market:marketGood:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MarketGood marketGood) {
		marketGoodService.save(marketGood);
		return renderResult(Global.TRUE, text("保存商品管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("market:marketGood:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MarketGood marketGood) {
		marketGoodService.delete(marketGood);
		return renderResult(Global.TRUE, text("删除商品管理成功！"));
	}
	
}