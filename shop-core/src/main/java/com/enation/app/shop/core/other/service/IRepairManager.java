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

    /**
     * 根据支付状态获取会员的维修订单
     * @param member_id
     * @param payment_status
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page getRepairByPayStatus(Integer member_id, Integer payment_status, int pageNo, int pageSize);

    /**
     * 根据评论状态获取会员维修订单
     * @param member_id
     * @param comment_status
     * @param pageNo
     * @param pageSize
     * @return
     */
    public Page getRepairByCommentStatus(Integer member_id, Integer comment_status, int pageNo, int pageSize);

    /**
     * 后台管理员根据维修状态获取维修订单
     * @param status 维修状态
     * @param pageNo 起始页
     * @param pageSize 页大小
     * @return
     */
    public Page getRepairListByStatus(Integer status, int pageNo, int pageSize);

    /**
     * 添加评论
     * @param id 维修id
     */
    public void addComment(Integer id, String comment);

    /**
     * 获取维修状态
     * @param repairId 维修id
     * @param member_id 会员id
     * @return 返回维修状态
     */
    public int getReairStatus(Integer repairId, Integer member_id);

    /**
     * 修改维修订单为支付状态
     * @param repairId 订单id
     */
    public void changePayStatus(Integer repairId);

    /**
     * 修改维修订单的状态
     * @param repairId
     * @param status
     */
    public void changeRepairStatus(Integer repairId, Integer status);
}
