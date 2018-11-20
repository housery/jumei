package com.enation.app.shop.front.api.other;

import com.enation.app.shop.core.other.model.Repair;
import com.enation.app.shop.core.other.service.impl.RepairManager;
import com.enation.framework.util.JsonMessageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/11/20 12:36
 * @email: 1126457667@qq.com
 */
@Controller
@Scope("prototype")
@RequestMapping("/api/shop/repair")
public class RepairApiController {

    @Autowired
    private RepairManager repairManager;

    @ResponseBody
    @RequestMapping(value = "/getRepair",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRepairByMemberIDStatus(int member_id, int status){
        List<Repair> repairList = null;
        try {
            repairList = repairManager.getRepairByMemberIDStatus(member_id, status);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonMessageUtil.getListJson(repairList);
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(Integer pars){
        return "test" + pars;
    }
}
