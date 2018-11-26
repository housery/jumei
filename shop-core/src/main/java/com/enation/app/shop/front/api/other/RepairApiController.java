package com.enation.app.shop.front.api.other;

import com.enation.app.shop.core.other.model.Repair;
import com.enation.app.shop.core.other.service.impl.RepairManager;
import com.enation.framework.action.GridController;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.database.Page;
import com.enation.framework.util.JsonMessageUtil;
import com.enation.framework.util.JsonResultUtil;
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
public class RepairApiController extends GridController {

    @Autowired
    private RepairManager repairManager;

    @ResponseBody
    @RequestMapping(value = "/getRepair",produces = MediaType.APPLICATION_JSON_VALUE)
    public GridJsonResult getRepairByMemberIdStatus(int member_id, int status){
        Page repairList = null;
        try {
            repairList = repairManager.getRepairByMemberIDStatus(member_id, status, this.getPage(), this.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getGridJson(repairList);
    }

    @ResponseBody
    @RequestMapping("/test")
    public String test(Integer pars){
        return "test" + pars;
    }
}
