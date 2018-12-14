package com.enation.app.shop.front.api.jumei;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: xiaohoo
 * @date: 2018/12/14 12:43
 * @email: 1126457667@qq.com
 */
@RequestMapping("/api/shop/redirect")
@Controller
public class RedirectPathController {

    @RequestMapping("/gotoMyBonus")
    public String gotoMyBonus(){
        return "/themes/wap/member/my-bonus";
    }

    @RequestMapping("/gotoClassify")
    public String gotoClassify(){
        return "/themes/wap/classify";
    }
}
