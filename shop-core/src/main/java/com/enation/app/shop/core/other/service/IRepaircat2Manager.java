package com.enation.app.shop.core.other.service;

import com.enation.app.shop.core.other.model.Repaircat2;
import com.enation.framework.database.Page;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/10 22:20
 * @email: 1126457667@qq.com
 */
public interface IRepaircat2Manager {

    /**
     * 添加二级维修分类
     */
    public void add(Repaircat2 repaircat2);

    /**
     * 删除二级分类
     */
    public void delete(Integer repaircat2_id);

    /**
     * 编辑二级分类
     */
    public void edit(Repaircat2 repaircat2);

    /**
     * 根据id获取二级维修分类
     * @param repaircat2_id
     * @return
     */
    public Repaircat2 getRepaircat2ById(Integer repaircat2_id);

    /**
     * 获取所有二级维修分类
     * 后台分页查询
     * @param pageFirst 起始页
     * @param pageSize 页大小
     * @return
     */
    public Page getAllRepaircat2ForPage(Integer pageFirst, Integer pageSize);

    /**
     * 前台获取所有二级维修分类
     * @return
     */
    public List<Repaircat2> getAllRepaircat2();

    /**
     * 根据一级维修分类id获取二级维修分类列表
     * @param repaircat1_id 一级分类id
     * @return
     */
    public List<Repaircat2> getRepaircat2ListByCat1Id(Integer repaircat1_id);
}
