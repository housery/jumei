package com.enation.app.shop.core.property.service;

import com.enation.app.shop.core.property.model.PropertyUnit;
import com.enation.framework.database.Page;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 11:47
 * @email: 1126457667@qq.com
 */
public interface IPropertyUnit {

    /**
     * 添加单元
     * @param unit
     */
    public void add(PropertyUnit unit);

    /**
     * 删除单元
     * @param unit_id
     */
    public void delete(Integer unit_id);

    /**
     * 根据单元id获取单元对象
     * @param unit_id
     * @return
     */
    public PropertyUnit getUnitById(Integer unit_id);

    /**
     * 获取单元列表
     * 分页显示，用于后台显示
     * @param pageNo 起始页
     * @param pageSize 页大小
     * @return
     */
    public Page getUnitList(int pageNo, int pageSize);

    /**
     * 获取所有单元
     * @return
     */
    public List<PropertyUnit> getAllUnit();

    /**
     * 根据社区id获取的单元列表
     * @return
     */
    public List<PropertyUnit> getUnitListByCommunityId(Integer communityId);
}
