package com.enation.app.shop.core.other.controller;

import com.enation.app.shop.core.other.model.Repair;
import com.enation.app.shop.core.other.service.impl.RepairManager;
import com.enation.framework.action.GridController;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.database.Page;
import com.enation.framework.util.JsonMessageUtil;
import com.enation.framework.util.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/11/20 12:36
 * @email: 1126457667@qq.com
 */
@Controller
@Transactional
@RequestMapping("/repair")
public class RepairController extends GridController {

    @Autowired
    private RepairManager repairManager;

    /**
     * 根据会员id和状态获取维修订单
     * @param member_id id
     * @param status 状态
     * @return json格式列表
     */
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

    /**
     * 根据会员id获取维修订单,分页显示
     * @param member_id id
     * @return json格式列表
     */
    @ResponseBody
    @RequestMapping(value = "/getRepairByMemberId",produces = MediaType.APPLICATION_JSON_VALUE)
    public GridJsonResult getRepairByMemberID(int member_id){
        Page repairList = null;
        try {
            repairList = repairManager.getRepairByMemberID(member_id, this.getPage(), this.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getGridJson(repairList);
    }

    @ResponseBody
    @RequestMapping(value = "/getRepairById",produces = MediaType.APPLICATION_JSON_VALUE)
    public String getRepairById(int repair_id){
        try {
            Repair repair = repairManager.getRepair(repair_id);
            return JsonMessageUtil.getObjectJson(repair);
        } catch (Exception e) {
            this.logger.error("获取维修列表失败");
            e.printStackTrace();
            return JsonMessageUtil.getErrorJson("获取维修列表失败 "+ e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/deleteRepairById",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteRepairByID(Integer repair_id){
        try {
            repairManager.deleteRepairByID(repair_id);
            return JsonMessageUtil.getSuccessJson("删除维修订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonMessageUtil.getErrorJson("删除维修订单失败 "+ e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/editRepair")
    public String editRepair(Repair repair){
        try {
            repair.setUpdateDate(new Date());
            repair.setStatus(1);
            repairManager.editRepair(repair);
            return JsonMessageUtil.getSuccessJson("编辑维修订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonMessageUtil.getErrorJson("编辑维修订单失败 "+ e.getMessage());
        }
    }

    @ResponseBody
    @RequestMapping(value = "/addRepair")
    public String addRepair(Repair repair){
        try {
            if (repair.getRepairType() == 1){ // 维修类型为1公修
                repair.setPaymoney(0.00);  // 公共维修则支付为0
            }
            repairManager.addRepair(repair);
            return JsonMessageUtil.getSuccessJson("添加维修订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonMessageUtil.getErrorJson("添加维修订单失败 "+ e.getMessage());
        }
    }
}
