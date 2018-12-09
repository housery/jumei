package com.enation.app.shop.core.property.service;

import com.enation.app.shop.core.property.model.PropertyDoornum;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 12:59
 * @email: 1126457667@qq.com
 */
public interface IPropertyDoornum {

    /**
     * 添加门牌号，户号
     * @param doornum
     */
    public void add(PropertyDoornum doornum);

    /**
     * 删除门牌号，根据门牌号id
     * @param dooornum_id
     */
    public void delete(Integer dooornum_id);

    /**
     * 获取所有门牌号列表
     * @return
     */
    public List<PropertyDoornum> getAllDoornum();

    /**
     * 根据单元id获取门牌列表
     * @param unit_id 单元id
     * @return
     */
    public List<PropertyDoornum> getDoornumListByUnitId(Integer unit_id);

    /**
     * 根据户号id获取户号对象
     * @param doornum_id 户号id
     * @return
     */
    public PropertyDoornum getDoornumById(Integer doornum_id);
}
