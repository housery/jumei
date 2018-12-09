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
}
