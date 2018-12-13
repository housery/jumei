package com.enation.app.shop.core.property.controller;

import com.enation.app.shop.core.property.model.PropertyPaymentRecord;
import com.enation.app.shop.core.property.service.impl.PropertyPayRecordManager;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.util.JsonResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/8 16:53
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/shop/property/payRecord")
public class PayRecordController {

    @Autowired
    private PropertyPayRecordManager payRecordManager;
    private Logger logger = Logger.getLogger(PayRecordController.class);

    /**
     * 添加支付记录
     * @param paymentRecord 支付记录
     * @return
     */
    @RequestMapping("/addPaymentRecord")
    public JsonResult addPaymentRecord(PropertyPaymentRecord paymentRecord){
        try {
            paymentRecord.setPay_year(new Date().getYear());
            paymentRecord.setCreate_date(System.currentTimeMillis());
            payRecordManager.add(paymentRecord);
        } catch (Exception e) {
            e.printStackTrace();
            JsonResultUtil.getErrorJson("添加失败");
        }
        return JsonResultUtil.getSuccessJson("添加成功");
    }

    /**
     * 根据物业缴费记录id 删除缴费记录
     * @param payRecordId id
     * @return
     */
    @RequestMapping("/deletePayRecordById")
    public JsonResult deletePayRecordById(Integer payRecordId){
        try {
            payRecordManager.delete(payRecordId);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("删除出错");
        }
        return JsonResultUtil.getSuccessJson("删除记录成功");
    }

    /**
     * 通过房屋id删除缴费记录
     * @param house_id 房屋id
     * @return
     */
    @RequestMapping("/deletePayRecordByHouseId")
    public JsonResult deletePayRecordByHouseId(Integer house_id){
        try {
            payRecordManager.deleteByHouseId(house_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("删除出错");
        }
        return JsonResultUtil.getSuccessJson("删除成功");
    }

    /**
     * 获取缴费记录
     * @param payRecordId 缴费记录id
     * @return
     */
    @RequestMapping("/getPayRecordById")
    public JsonResult getPayRecordById(Integer payRecordId){
        PropertyPaymentRecord paymentRecord = null;
        try {
            paymentRecord = payRecordManager.getPayRecordById(payRecordId);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("查找缴费记录出错");
        }
        return JsonResultUtil.getObjectJson(paymentRecord);
    }

    /**
     * 根据房屋id获取物业缴费记录
     * @param houseId 房屋id
     * @return
     */
    @RequestMapping("/getPayRecordListByHouseId")
    public GridJsonResult getPayRecordListByHouseId(Integer houseId){
        List<PropertyPaymentRecord> paymentRecordList = null;
        try {
            paymentRecordList = payRecordManager.getPayRecordListByHouseId(houseId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取房屋缴费记录失败" + e.getMessage());
        }
        return JsonResultUtil.getGridJson(paymentRecordList);
    }

    /**
     * 获取房屋缴费记录通过房屋id，和支付状态
     * @param houseId 房屋id
     * @param pay_status 支付状态
     * @return 支付列表
     */
    @RequestMapping("/getPayRecordListByHouseIdPayStatus")
    public GridJsonResult getPayRecordListByHouseIdPayStatus(Integer houseId, Integer pay_status){
        List<PropertyPaymentRecord> recordList = null;
        try {
            recordList = payRecordManager.getPayRecordListByHouseIdPayStatus(houseId,pay_status);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取房屋缴费记录失败" + e.getMessage());
        }
        return JsonResultUtil.getGridJson(recordList);
    }
}
