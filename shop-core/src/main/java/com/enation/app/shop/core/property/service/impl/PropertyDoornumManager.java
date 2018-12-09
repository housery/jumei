package com.enation.app.shop.core.property.service.impl;

import com.enation.app.shop.core.property.model.PropertyDoornum;
import com.enation.app.shop.core.property.service.IPropertyDoornum;
import com.enation.framework.database.IDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 14:05
 * @email: 1126457667@qq.com
 */
@Service
@Transactional
public class PropertyDoornumManager implements IPropertyDoornum {

    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public void add(PropertyDoornum doornum) {
        this.daoSupport.insert("es_property_doornum", doornum);
    }

    @Override
    public void delete(Integer dooornum_id) {
        String sql = "delete from es_property_doornum where doornum_id = ?;";
        this.daoSupport.execute(sql, dooornum_id);
    }

    @Override
    public List<PropertyDoornum> getAllDoornum() {
        String sql = "select * from es_property_doornum";
        List<PropertyDoornum> doornumList = this.daoSupport.queryForList(sql,PropertyDoornum.class);
        return doornumList;
    }

    @Override
    public List<PropertyDoornum> getDoornumListByUnitId(Integer unit_id) {
        String sql = "select * from es_property_doornum where unit_id = ?";
        List<PropertyDoornum> doornumList = this.daoSupport.queryForList(sql,PropertyDoornum.class,unit_id);
        return doornumList;
    }

    @Override
    public PropertyDoornum getDoornumById(Integer doornum_id) {
        String sql = "select * from es_property_doornum where doornum_id = ?";
        PropertyDoornum doornum = this.daoSupport.queryForObject(sql,PropertyDoornum.class,doornum_id);
        return doornum;
    }
}
