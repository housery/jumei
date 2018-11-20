package com.enation.app.shop.core.other.service;

import com.enation.app.shop.core.other.model.Repair;
import com.enation.framework.database.Page;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/11/20 11:28
 * @email: 1126457667@qq.com
 */
public interface IRepairManager {

    /**
     * 添加维修订单
     * @param repair
     */
    public void addRepair(Repair repair);

    /**
     * 编辑维修订单
     * @param repair
     */
    public void editRepair(Repair repair);

    /**
     * 通过维修id删除维修订单
     * @param repair_id
     */
    public void deleteRepairByID(Integer repair_id);

    /**
     * 获取维修订单,根据维修id
     * @param repair_id
     * @return
     */
    public Repair getRepair(Integer repair_id);

    /**
     * 根据会员id获取维修订单列表
     * @param member_id
     * @return
     */
    public Page getRepairByMemberID(Integer member_id, int pageNo, int pageSize);

    /**
     * 根据会员id和状态获取维修订单
     * @param member_id 会员id
     * @param status repair表中
     * @return
     */
    public Page getRepairByMemberIDStatus(Integer member_id, Integer status,int pageNo, int pageSize);
}
