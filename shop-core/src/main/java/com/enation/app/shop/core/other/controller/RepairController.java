package com.enation.app.shop.core.other.controller;

import com.enation.app.base.core.model.Member;
import com.enation.app.base.core.upload.IUploader;
import com.enation.app.base.core.upload.UploadFacatory;
import com.enation.app.shop.core.other.model.Repair;
import com.enation.app.shop.core.other.service.impl.RepairManager;
import com.enation.eop.sdk.context.UserConext;
import com.enation.framework.action.GridController;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.database.Page;
import com.enation.framework.util.JsonMessageUtil;
import com.enation.framework.util.JsonResultUtil;
import com.enation.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author: xiaohoo
 * @date: 2018/11/20 12:36
 * @email: 1126457667@qq.com
 */
@Controller
@RequestMapping("/api/shop/repair")
public class RepairController extends GridController {

    @Autowired
    private RepairManager repairManager;

    /**
     * 根据维修状态获取当前会员的维修列表
     * @param status 状态
     * @return json格式列表
     */
    @ResponseBody
    @RequestMapping(value = "/getCurrMemberRepairByStatus",produces = MediaType.APPLICATION_JSON_VALUE)
    public GridJsonResult getRepairByMemberIdStatus(int status){
        Page repairList = null;
        try {
            Member member = UserConext.getCurrentMember();
            int member_id = member.getMember_id();
            repairList = repairManager.getRepairByMemberIDStatus(member_id, status, this.getPage(), this.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getGridJson(repairList);
    }

    /**
     * 获取当前登陆用户的所有维修订单,分页显示
     * @return json格式列表
     */
    @ResponseBody
    @RequestMapping(value = "/getRepairByMember",produces = MediaType.APPLICATION_JSON_VALUE)
    public GridJsonResult getRepairByMember(){
        Page repairList = null;
        try {
            Member member = UserConext.getCurrentMember();
            int member_id = member.getMember_id();
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

    /**
     * 删除维修订单
     * @param repair_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRepairById",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteRepairByID(Integer repair_id){
        try {
            // 删除图片
            Repair repair = repairManager.getRepair(repair_id);
            String imgPath1 = repair.getImg_1();
            String imgPath2 = repair.getImg_2();
            String imgPath3 = repair.getImg_3();

            IUploader uploader=UploadFacatory.getUploaer();
            try { // 判断图片并删除
                if (!StringUtil.isEmpty(imgPath1)){
                    uploader.deleteFile(imgPath1);
                }
                if (!StringUtil.isEmpty(imgPath2)){
                    uploader.deleteFile(imgPath2);
                }
                if (!StringUtil.isEmpty(imgPath3)){
                    uploader.deleteFile(imgPath3);
                }
            } catch (Exception e) {
                e.printStackTrace();
                return JsonMessageUtil.getErrorJson("删除维修订单下的图片失败");
            }
            repairManager.deleteRepairByID(repair_id);
            return JsonMessageUtil.getSuccessJson("删除维修订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonMessageUtil.getErrorJson("删除维修订单失败 "+ e.getMessage());
        }
    }

    /**
     * 编辑维修订单，只允许客户修改订单
     * 默认设置更新时间，设置状态为待处理1,
     * @param repair 必须包含id才能编辑
     * @param imgPath1
     * @param imgPath2
     * @param imgPath3
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/editRepair")
    public String editRepair(Repair repair,
                             @RequestParam(value = "imgPath1", required = false) String imgPath1,
                             @RequestParam(value = "imgPath2", required = false) String imgPath2,
                             @RequestParam(value = "imgPath3", required = false) String imgPath3){
        try {
            if (repair.getRepair_type() == 1){ // 维修类型为1公修
                repair.setPaymoney(0.00);  // 公共维修则支付为0
            }
            if (!StringUtil.isEmpty(imgPath1)){
                repair.setImg_1(imgPath1);
            }
            if (!StringUtil.isEmpty(imgPath2)){
                repair.setImg_2(imgPath2);
            }
            if (!StringUtil.isEmpty(imgPath3)){
                repair.setImg_3(imgPath3);
            }
            long updateTime = System.currentTimeMillis();
            repair.setUpdate_date(updateTime);
            repair.setStatus(1);
            repairManager.editRepair(repair);
            return JsonMessageUtil.getSuccessJson("编辑维修订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonMessageUtil.getErrorJson("编辑维修订单失败 "+ e.getMessage());
        }
    }

    /**
     * 关于图片上传，调用UploadController类的/upload-file接口，
     * 将图片的path放在前端，提交数据时候到这里接收
     * @param repair
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addRepair")
    public JsonResult addRepair(Repair repair,
                                @RequestParam(value = "imgPath1", required = false) String imgPath1,
                                @RequestParam(value = "imgPath2", required = false) String imgPath2,
                                @RequestParam(value = "imgPath3", required = false) String imgPath3){
        try {
            Member member = UserConext.getCurrentMember();

            if (repair.getRepair_type() == 1){ // 维修类型为1公修
                repair.setPaymoney(0.00);  // 公共维修则支付为0
            }
            if ("".equals(repair.getPaymoney())){
                repair.setPaymoney(0.00);
            }
            if (!StringUtil.isEmpty(imgPath1)){
                repair.setImg_1(imgPath1);
            }
            if (!StringUtil.isEmpty(imgPath2)){
                repair.setImg_2(imgPath2);
            }
            if (!StringUtil.isEmpty(imgPath3)){
                repair.setImg_3(imgPath3);
            }
            repair.setUpdate_date(System.currentTimeMillis());
            repair.setStatus(1);
            repair.setMember_id(member.getMember_id());
            repair.setPayment_status(0); // 设置支付状态为0 未支付
            repairManager.addRepair(repair);
            return JsonResultUtil.getSuccessJson("添加维修订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("添加维修订单失败 "+ e.getMessage());
        }
    }

    /**
     * 根据维修的支付状态获取当前登陆会员的维修订单
     * @param payment_status 支付状态 0未支付 1已经支付
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRepairByPayStatus")
    public GridJsonResult getRepairByPayStatus(int payment_status){
        Page repairList = null;
        try {
            Member member = UserConext.getCurrentMember();
            int member_id = member.getMember_id();
            repairList = repairManager.getRepairByPayStatus(member_id, payment_status, this.getPage(), this.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getGridJson(repairList);
    }

    /**
     * 根据订单评论状态获取订单
     * @param comment_status 评论状态 0未评论 1已经评论 默认0
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getRepairByCommentStatus")
    public GridJsonResult getRepairByCommentStatus(int comment_status){
        Page repairList = null;
        try {
            Member member = UserConext.getCurrentMember();
            int member_id = member.getMember_id();
            repairList = repairManager.getRepairByCommentStatus(member_id, comment_status, this.getPage(), this.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getGridJson(repairList);
    }

    /**
     * 后台管理员根据维修状态获取维修列表
     * @param status 当前维修状态
     *               1 订单待处理，2 客服已确认订单，
     *               3 客服已经派出相关服务人员，4 维修服务完成
     * @param page 起始页
     * @param length 页大小
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getAllRepairListByStatus")
    public GridJsonResult getRepairListByStatus(Integer status) {
        Page repairList = null;
        try {
            repairList = repairManager.getRepairListByStatus(status, this.getPage(), this.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("后台管理员根据维修状态获取维修列表出现错误");
        }
        return JsonResultUtil.getGridJson(repairList);
    }

    /**
     * 添加评论
     * @param id 维修id
     * @param comment 评论内容
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/addComment")
    public JsonResult addComment(Integer id, String comment){
        try {
            repairManager.addComment(id,comment);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("添加评论失败");
        }
        return JsonResultUtil.getSuccessJson("添加评论成功");
    }

    /**
     * 根据登陆会员，维修订单id获取维修状态
     * @param repairId 维修id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/getReairStatus")
    public JsonResult getReairStatus(Integer repairId){
        int status = 0;
        try {
            Member member = UserConext.getCurrentMember();
            int member_id = member.getMember_id();
            status = repairManager.getReairStatus(repairId,member_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("获取出错");
        }
        return JsonResultUtil.getObjectJson(status);
    }

    /**
     * 修改订单的维修状态
     * @param repairId
     * @param status
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/changeRepairStatus",method = RequestMethod.POST)
    public JsonResult changeRepairStatus(Integer repairId, Integer status){
        try {
            repairManager.changeRepairStatus(repairId,status);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("修改订单维修状态失败");
        }
        return JsonResultUtil.getSuccessJson("修改订单维修状态成功");
    }
}
