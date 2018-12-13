package com.enation.app.shop.core.property.service;

import com.enation.app.shop.core.property.model.PropertyPaymentRecord;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 17:16
 * @email: 1126457667@qq.com
 *
 * 物业缴费记录
 */
public interface IPropertyPayRecord {

    public void add(PropertyPaymentRecord paymentRecord);

    public void delete(Integer payRecordId);

    public void deleteByHouseId(Integer house_id);

    public PropertyPaymentRecord getPayRecordById(Integer payRecordId);

    public List<PropertyPaymentRecord> getPayRecordListByHouseId(Integer houseId);

    /**
     * 获取物业缴费记录
     * @param houseId 房屋id
     * @param pay_status 支付状态
     * @return 订单列表
     */
    public List<PropertyPaymentRecord> getPayRecordListByHouseIdPayStatus(Integer houseId,Integer pay_status);

    /**
     * 缴费，根据订单id设置订单的支付状态为1
     * @param recordIdList 未缴费的订单id列表
     */
    public void payProperty(List<Integer> recordIdList);

}
