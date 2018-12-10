package com.enation.app.shop.core.other.service;

import com.enation.app.shop.core.other.model.Repaircat;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/9 21:20
 * @email: 1126457667@qq.com
 */
public interface IRepaircatManager {

    /**
     * 添加维修分类
     */
    public void addPrepairCat(Repaircat repaircat);

    /**
     * 根据维修分类id删除分类
     * @param repaircat_id 分类id
     */
    public void deleteRepairCat(Integer repaircat_id);

    /**
     * 根据维修分类id获取维修分类
     * @param repaircat_id 分类id
     * @return
     */
    public Repaircat getRepaircatById(Integer repaircat_id);

    /**
     * 获取所有维修分类
     * @return
     */
    public List<Repaircat> getAllRepaircat();
}
