package com.enation.app.shop.core.property.service.impl;

import com.enation.app.shop.core.property.model.PropertyPaymentRecord;
import com.enation.app.shop.core.property.service.IPropertyPayRecord;
import com.enation.framework.database.IDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 17:23
 * @email: 1126457667@qq.com
 */
@Service
@Transactional
public class PropertyPayRecordManager implements IPropertyPayRecord {

    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public void add(PropertyPaymentRecord paymentRecord) {
        this.daoSupport.insert("es_property_payment_record", paymentRecord);
    }

    @Override
    public void delete(Integer payRecordId) {
        String sql = "delete from es_property_payment_record where payment_record_id = ?";
        this.daoSupport.execute(sql,payRecordId);
    }

    @Override
    public void deleteByHouseId(Integer house_id) {
        String sql = "delete from es_property_payment_record where house_id = ?";
        this.daoSupport.execute(sql,house_id);
    }

    @Override
    public PropertyPaymentRecord getPayRecordById(Integer payRecordId) {
        String sql = "select * from es_property_payment_record where payment_record_id = ?";
        PropertyPaymentRecord record = this.daoSupport.queryForObject(sql,PropertyPaymentRecord.class,payRecordId);
        return record;
    }

    @Override
    public List<PropertyPaymentRecord> getPayRecordListByHouseId(Integer houseId) {
        String sql = "select * from es_property_payment_record where house_id = ?";
        List<PropertyPaymentRecord> recordList = this.daoSupport.queryForList(sql,PropertyPaymentRecord.class,houseId);
        return recordList;
    }

    @Override
    public List<PropertyPaymentRecord> getPayRecordListByHouseIdPayStatus(Integer houseId, Integer pay_status) {
        String sql = "select * from es_property_payment_record where house_id = ? and pay_status = ?";
        List<PropertyPaymentRecord> recordList = this.daoSupport.queryForList(sql,PropertyPaymentRecord.class,houseId,pay_status);
        return recordList;
    }

    /**
     * 修改支付订单未支付状态
     * @param recordIdList 未缴费的id列表
     */
    @Override
    public void payProperty(List<Integer> recordIdList) {
        Map filed = new HashMap();
        filed.put("pay_status",1);  //设置为支付状态
        for (Integer recordId: recordIdList) {
            this.daoSupport.update("es_property_payment_record", filed, "payment_record_id = " + recordId);
        }
    }
}
