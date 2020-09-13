package com.jeesite.modules.market.web;

import com.jeesite.common.entity.Page;
import com.jeesite.common.lang.StringUtils;
import com.jeesite.common.web.BaseController;
import com.jeesite.modules.market.entity.MarketGood;
import com.jeesite.modules.market.service.MarketGoodService;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//收银
@Controller
@RequestMapping(value = "${adminPath}/market/marketPay")
public class MarketPayController extends BaseController {
    @Autowired
    private MarketGoodService marketGoodService;

    @RequiresPermissions("market:marketPay:view")
    @RequestMapping(value = {"view", ""})
    public String view() {
        return "modules/market/marketPay";
    }

    @RequiresPermissions("market:marketPay:view")
    @RequestMapping(value = "listData")
    @ResponseBody
    public MarketGood listData(String parameter) {
        return StringUtils.isEmpty(parameter)?null:marketGoodService.findEntityByParam(parameter);
    }
}
