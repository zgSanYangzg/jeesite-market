/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.web;

import com.jeesite.common.config.Global;
import com.jeesite.common.entity.Page;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.market.entity.MarketPurchase;
import com.jeesite.modules.market.entity.MarketSupplier;
import com.jeesite.modules.market.service.MarketPurchaseService;
import com.jeesite.modules.market.service.MarketSupplierService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 进货管理Controller
 * @author zg
 * @version 2020-09-08
 */
@Controller
@RequestMapping(value = "${adminPath}/market/marketPurchase")
public class MarketPurchaseController extends BaseController {

	@Autowired
	private MarketPurchaseService marketPurchaseService;

	@Autowired
	private MarketSupplierService marketSupplierService;


	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MarketPurchase get(String id, boolean isNewRecord) {
		return marketPurchaseService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("market:marketPurchase:view")
	@RequestMapping(value = {"list", ""})
	public String list(MarketPurchase marketPurchase, Model model) {
		model.addAttribute("marketPurchase", marketPurchase);
		return "modules/market/marketPurchaseList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("market:marketPurchase:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MarketPurchase> listData(MarketPurchase marketPurchase, HttpServletRequest request, HttpServletResponse response) {
		marketPurchase.setPage(new Page<>(request, response));
		Page<MarketPurchase> page = marketPurchaseService.findPage(marketPurchase);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("market:marketPurchase:view")
	@RequestMapping(value = "form")
	public String form(MarketPurchase marketPurchase, Model model,HttpServletRequest request, HttpServletResponse response) {
		model.addAttribute("marketPurchase", marketPurchase);
		List<MarketSupplier> suppliers = marketSupplierService.findList();
		model.addAttribute("suppliers", suppliers);
		return "modules/market/marketPurchaseForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("market:marketPurchase:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MarketPurchase marketPurchase) {
		marketPurchaseService.save(marketPurchase);
		return renderResult(Global.TRUE, text("保存进货管理成功！"));
	}
	
}