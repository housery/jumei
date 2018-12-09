package com.enation.app.shop.core.property.service.impl;

import com.enation.app.shop.core.property.model.PropertyUnit;
import com.enation.app.shop.core.property.service.IPropertyUnit;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.database.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 12:01
 * @email: 1126457667@qq.com
 */
@Service
@Transactional
public class PropertyUnitManager implements IPropertyUnit {

    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public void add(PropertyUnit unit) {
        this.daoSupport.insert("es_property_unit", unit);
    }

    @Override
    public void delete(Integer unit_id) {
        String sql = "delete from es_property_unit where unit_id = ?;";
        this.daoSupport.execute(sql, unit_id);
    }

    @Override
    public PropertyUnit getUnitById(Integer unit_id) {
        String sql = "select * from es_property_unit where unit_id = ?";
        PropertyUnit unit = this.daoSupport.queryForObject(sql,PropertyUnit.class,unit_id);
        return unit;
    }

    @Override
    public Page getUnitList(int pageNo, int pageSize) {
        String sql = "select * from es_property_unit order by unit_id";
        Page page = this.daoSupport.queryForPage(sql, pageNo, pageSize, PropertyUnit.class);
        return page;
    }

    @Override
    public List<PropertyUnit> getAllUnit() {
        String sql = "select * from es_property_unit";
        List<PropertyUnit> unitList = this.daoSupport.queryForList(sql,PropertyUnit.class);
        return unitList;
    }

    @Override
    public List<PropertyUnit> getUnitListByCommunityId(Integer communityId) {
        String sql = "select * from es_property_unit where community_id = ?";
        List<PropertyUnit> unitList = this.daoSupport.queryForList(sql,PropertyUnit.class,communityId);
        return unitList;
    }
}
