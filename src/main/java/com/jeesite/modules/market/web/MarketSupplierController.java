/**
 * Copyright (c) 2013-Now http://jeesite.com All rights reserved.
 */
package com.jeesite.modules.market.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.jeesite.modules.market.entity.MarketSupplier;
import com.jeesite.modules.market.service.MarketSupplierService;

/**
 * 供应商管理Controller
 * @author zg
 * @version 2020-09-02
 */
@Controller
@RequestMapping(value = "${adminPath}/market/marketSupplier")
public class MarketSupplierController extends BaseController {

	@Autowired
	private MarketSupplierService marketSupplierService;
	
	/**
	 * 获取数据
	 */
	@ModelAttribute
	public MarketSupplier get(String id, boolean isNewRecord) {
		return marketSupplierService.get(id, isNewRecord);
	}
	
	/**
	 * 查询列表
	 */
	@RequiresPermissions("market:marketSupplier:view")
	@RequestMapping(value = {"list", ""})
	public String list(MarketSupplier marketSupplier, Model model) {
		model.addAttribute("marketSupplier", marketSupplier);
		return "modules/market/marketSupplierList";
	}
	
	/**
	 * 查询列表数据
	 */
	@RequiresPermissions("market:marketSupplier:view")
	@RequestMapping(value = "listData")
	@ResponseBody
	public Page<MarketSupplier> listData(MarketSupplier marketSupplier, HttpServletRequest request, HttpServletResponse response) {
		marketSupplier.setPage(new Page<>(request, response));
		Page<MarketSupplier> page = marketSupplierService.findPage(marketSupplier);
		return page;
	}

	/**
	 * 查看编辑表单
	 */
	@RequiresPermissions("market:marketSupplier:view")
	@RequestMapping(value = "form")
	public String form(MarketSupplier marketSupplier, Model model) {
		model.addAttribute("marketSupplier", marketSupplier);
		return "modules/market/marketSupplierForm";
	}

	/**
	 * 保存数据
	 */
	@RequiresPermissions("market:marketSupplier:edit")
	@PostMapping(value = "save")
	@ResponseBody
	public String save(@Validated MarketSupplier marketSupplier) {
		marketSupplierService.save(marketSupplier);
		return renderResult(Global.TRUE, text("保存供应商管理成功！"));
	}
	
	/**
	 * 删除数据
	 */
	@RequiresPermissions("market:marketSupplier:edit")
	@RequestMapping(value = "delete")
	@ResponseBody
	public String delete(MarketSupplier marketSupplier) {
		marketSupplierService.delete(marketSupplier);
		return renderResult(Global.TRUE, text("删除供应商管理成功！"));
	}
	
}