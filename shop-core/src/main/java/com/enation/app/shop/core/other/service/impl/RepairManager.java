package com.enation.app.shop.core.other.service.impl;

import com.enation.app.shop.core.other.model.Repair;
import com.enation.app.shop.core.other.service.IRepairManager;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.database.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/11/20 11:57
 * @email: 1126457667@qq.com
 */
@Service
@Transactional
public class RepairManager implements IRepairManager {

    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public void addRepair(Repair repair) {
        this.daoSupport.insert("es_repair", repair);
    }

    @Override
    public void editRepair(Repair repair) {
        this.daoSupport.update("es_repair", repair, "id="+repair.getId());
    }

    @Override
    public void deleteRepairByID(Integer repair_id) {
        String sql = "delete from es_repair where id = ?";
        this.daoSupport.execute(sql, repair_id);
    }

    @Override
    public Repair getRepair(Integer repair_id) {
        String sql = "select * from es_repair where id = ?";
        Repair repair = this.daoSupport.queryForObject(sql, Repair.class, repair_id);
        return repair;
    }

    @Override
    public Page getRepairByMemberID(Integer member_id,int pageNo, int pageSize) {
        String sql = "select * from es_repair where member_id = ?";
        Page page = this.daoSupport.queryForPage(sql, pageNo, pageSize, Repair.class, member_id);
        return page;
    }

    @Override
    public Page getRepairByMemberIDStatus(Integer member_id, Integer status,int pageNo, int pageSize) {
        String sql = "select * from es_repair where member_id = ? and status = ?";
        Page page = this.daoSupport.queryForPage(sql, pageNo, pageSize,Repair.class, member_id, status);
        return page;
    }

    @Override
    public Page getRepairByPayStatus(Integer member_id, Integer payment_status, int pageNo, int pageSize) {
        String sql = "select * from es_repair where member_id = ? and payment_status = ?";
        Page page = this.daoSupport.queryForPage(sql, pageNo, pageSize,Repair.class, member_id, payment_status);
        return page;
    }

    @Override
    public Page getRepairByCommentStatus(Integer member_id, Integer comment_status, int pageNo, int pageSize) {
        String sql = "select * from es_repair where member_id = ? and comment_status = ?";
        Page page = this.daoSupport.queryForPage(sql, pageNo, pageSize,Repair.class, member_id, comment_status);
        return page;
    }
}
