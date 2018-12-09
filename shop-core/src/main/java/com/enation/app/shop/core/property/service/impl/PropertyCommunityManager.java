package com.enation.app.shop.core.property.service.impl;

import com.enation.app.shop.core.property.model.PropertyCommunity;
import com.enation.app.shop.core.property.service.IPropertyCommunity;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.database.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 11:29
 * @email: 1126457667@qq.com
 */
@Service
@Transactional
public class PropertyCommunityManager implements IPropertyCommunity {

    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public void add(PropertyCommunity community) {
        this.daoSupport.insert("es_property_community", community);
    }

    @Override
    public void delete(Integer community_id) {
        String sql = "delete from es_property_community where community_id = ?";
        this.daoSupport.execute(sql, community_id);
    }

    @Override
    public Page getCommunityList(int pageNo, int pageSize) {
        String sql = "select * from es_property_community order by community_id";
        Page page = this.daoSupport.queryForPage(sql, pageNo, pageSize, PropertyCommunity.class);
        return page;
    }

    @Override
    public List<PropertyCommunity> getAllCommunity() {
        String sql = "select * from es_property_community";
        List<PropertyCommunity> communityList = this.daoSupport.queryForList(sql,PropertyCommunity.class);
        return communityList;
    }

    @Override
    public PropertyCommunity getCommunityById(Integer community_id) {
        String sql = "select * from es_property_community where community_id = ?";
        PropertyCommunity community = this.daoSupport.queryForObject(sql, PropertyCommunity.class, community_id);
        return community;
    }
}
