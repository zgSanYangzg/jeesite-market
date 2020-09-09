package com.jeesite.modules.market.web;

import com.jeesite.common.web.BaseController;
import com.jeesite.modules.market.entity.MarketGood;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

//收银
@Controller
@RequestMapping(value = "${adminPath}/market/marketPay")
public class MarketPayController extends BaseController {

    @RequiresPermissions("market:marketPay:view")
    @RequestMapping(value = {"view", ""})
    public String view() {
        return "modules/market/marketPay";
    }
}
