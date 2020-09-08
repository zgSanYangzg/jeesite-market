package com.jeesite.modules.utils;

import com.jeesite.common.web.http.HttpClientUtils;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
//扩展通过条码查询商品信息
//增强超时限制.默认三次内无法查询,跳过处理. 继承timeoverapi父类.实现子类方法.调用父类deal方法实现限制
@Service
public class ThirdGoodApi extends TimeOverApi{
    @Value("${custData.goodApiurl}")
    private String postUrl;

    @Setter
    private String barCode;
    //此方法没有限制. 调用父类方法才有超时限制.默认3秒
    @Override
    public String process() {
        String url = String.format(postUrl, barCode);
        String backData = HttpClientUtils.get(url);
        return backData;
    }
}
