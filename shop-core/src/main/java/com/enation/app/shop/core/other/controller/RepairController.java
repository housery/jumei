package com.enation.app.shop.core.other.controller;

import com.enation.app.base.core.upload.IUploader;
import com.enation.app.base.core.upload.UploadFacatory;
import com.enation.app.shop.core.other.model.Repair;
import com.enation.app.shop.core.other.service.impl.RepairManager;
import com.enation.framework.action.GridController;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.database.Page;
import com.enation.framework.util.FileUtil;
import com.enation.framework.util.JsonMessageUtil;
import com.enation.framework.util.JsonResultUtil;
import com.enation.framework.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/11/20 12:36
 * @email: 1126457667@qq.com
 */
@Controller
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
     * 根据会员id获取维修订单列表,分页显示
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

    /**
     * 删除维修订单
     * @param repair_id
     * @return
     */
    @ResponseBody
    @RequestMapping(value = "/deleteRepairById",produces = MediaType.APPLICATION_JSON_VALUE)
    public String deleteRepairByID(Integer repair_id){
        try {
            repairManager.deleteRepairByID(repair_id);
            // 删除图片
            Repair repair = repairManager.getRepair(repair_id);
            String imgPath1 = repair.getImg1();
            String imgPath2 = repair.getImg2();
            String imgPath3 = repair.getImg3();

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
            return JsonMessageUtil.getSuccessJson("删除维修订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonMessageUtil.getErrorJson("删除维修订单失败 "+ e.getMessage());
        }
    }

    /**
     * 编辑维修订单，
     * 默认设置更新时间，设置状态为待处理1，只有status=1时候才可以编辑
     * @param repair
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
            if (repair.getRepairType() == 1){ // 维修类型为1公修
                repair.setPaymoney(0.00);  // 公共维修则支付为0
            }
            if (!StringUtil.isEmpty(imgPath1)){
                repair.setImg1(imgPath1);
            }
            if (!StringUtil.isEmpty(imgPath2)){
                repair.setImg2(imgPath2);
            }
            if (!StringUtil.isEmpty(imgPath3)){
                repair.setImg3(imgPath3);
            }
            repair.setUpdateDate(new Date());
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
            if (repair.getRepairType() == 1){ // 维修类型为1公修
                repair.setPaymoney(0.00);  // 公共维修则支付为0
            }
            if (!StringUtil.isEmpty(imgPath1)){
                repair.setImg1(imgPath1);
            }
            if (!StringUtil.isEmpty(imgPath2)){
                repair.setImg2(imgPath2);
            }
            if (!StringUtil.isEmpty(imgPath3)){
                repair.setImg3(imgPath3);
            }
            repair.setUpdateDate(new Date());
            repair.setStatus(1);
            repairManager.addRepair(repair);
            return JsonResultUtil.getSuccessJson("添加维修订单成功");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("添加维修订单失败 "+ e.getMessage());
        }
    }
}
