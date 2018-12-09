package com.enation.app.shop.core.property.service;

import com.enation.app.shop.core.property.model.PropertyHouse;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 16:22
 * @email: 1126457667@qq.com
 */
public interface IPropertyHouse {

    /**
     * 添加房屋信息
     * @param house 房屋对象
     */
    public void add(PropertyHouse house);

    /**
     * 删除房屋信息
     * @param house_id 房屋id
     */
    public void delete(Integer house_id);

    /**
     * 获取所有房屋信息
     * @return 房屋列表
     */
    public List<PropertyHouse> getAllHouse();

    /**
     * 根据房屋id获取房屋
     * @param house_id 房屋id
     * @return 单个房屋对象
     */
    public PropertyHouse getHouseById(Integer house_id);

    /**
     * 根据社区id，单元id，门牌号id获取房屋
     * C--community：社区；U--Unit：单元; D--Doornum：门牌号
     * @param community_id 社区id
     * @param unit_id 单元id
     * @param doornum_id 门牌号id
     * @return 房屋对象
     */
    public PropertyHouse getHouseByCUDId(Integer community_id, Integer unit_id, Integer doornum_id);
}
