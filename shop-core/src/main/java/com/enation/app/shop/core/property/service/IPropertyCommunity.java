package com.enation.app.shop.core.property.service;

import com.enation.app.shop.core.property.model.PropertyCommunity;
import com.enation.framework.database.Page;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 11:11
 * @email: 1126457667@qq.com
 */
public interface IPropertyCommunity {

    /**
     * 添加社区，小区
     * @param community
     */
    public void add(PropertyCommunity community);

    /**
     * 根据社区id删除社区
     * @param community_id
     */
    public void delete(Integer community_id);

    /**
     * 获取所有社区列表，分页显示
     * @return
     */
    public Page getCommunityList(int pageNo, int pageSize);

    /**
     * 获取所有社区列表
     * @return
     */
    public List<PropertyCommunity> getAllCommunity();

    /**
     * 获取社区根据社区id
     * @return
     */
    public PropertyCommunity getCommunityById(Integer community_id);
}


