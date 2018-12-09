package com.enation.app.shop.core.property.service.impl;

import com.enation.app.shop.core.property.model.PropertyPaymentRecord;
import com.enation.app.shop.core.property.service.IPropertyPayRecord;
import com.enation.framework.database.IDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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
        String sql = "";
        List<PropertyPaymentRecord> recordList = this.daoSupport.queryForList(sql,PropertyPaymentRecord.class,houseId);
        return recordList;
    }
}
