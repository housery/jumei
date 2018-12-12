package com.enation.app.shop.core.property.service.impl;

import com.enation.app.shop.core.property.model.PropertyHouse;
import com.enation.app.shop.core.property.service.IPropertyHouse;
import com.enation.framework.database.IDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 16:41
 * @email: 1126457667@qq.com
 */
@Service
public class PropertyHouseManager implements IPropertyHouse {

    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public void add(PropertyHouse house) {
        this.daoSupport.insert("es_property_house", house);
    }

    @Override
    public void delete(Integer house_id) {
        String sql = "delete from es_property_house where house_id = ?;";
        this.daoSupport.execute(sql, house_id);
    }

    @Override
    public List<PropertyHouse> getAllHouse() {
        String sql = "select * from es_property_house";
        List<PropertyHouse> houseList = this.daoSupport.queryForList(sql,PropertyHouse.class);
        return houseList;
    }

    @Override
    public PropertyHouse getHouseById(Integer house_id) {
        String sql = "select * from es_property_house where house_id = ?";
        PropertyHouse house = this.daoSupport.queryForObject(sql,PropertyHouse.class,house_id);
        return house;
    }

    @Override
    public PropertyHouse getHouseByCUDId(Integer community_id, Integer unit_id, Integer doornum_id) {
        String sql = "select * from es_property_house " +
                "where community_id = ? and unit_id = ? and doornum_id = ?";
        PropertyHouse house = this.daoSupport.queryForObject(sql, PropertyHouse.class,
                community_id, unit_id, doornum_id);
        return house;
    }
}
