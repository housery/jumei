package com.enation.app.shop.core.other.service.impl;

import com.enation.app.shop.core.other.model.Repaircat2;
import com.enation.app.shop.core.other.service.IRepaircat2Manager;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.database.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/10 22:42
 * @email: 1126457667@qq.com
 */
@Service
@Transactional
public class Repaircat2Manager implements IRepaircat2Manager {

    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public void add(Repaircat2 repaircat2) {
        daoSupport.insert("es_repaircat2",repaircat2);
    }

    @Override
    public void delete(Integer repaircat2_id) {
        String sql = "delete from es_repaircat2 where repaircat2_id = ?";
        daoSupport.execute(sql,repaircat2_id);
    }

    @Override
    public void edit(Repaircat2 repaircat2) {
        daoSupport.update("es_repaircat2",repaircat2,"repaircat2_id = "+repaircat2.getRepaircat2_id());
    }

    @Override
    public Repaircat2 getRepaircat2ById(Integer repaircat2_id) {
        String sql = "select * from es_repaircat2 where repaircat2_id = ?";
        Repaircat2 repaircat2 = this.daoSupport.queryForObject(sql,Repaircat2.class, repaircat2_id);
        return repaircat2;
    }

    @Override
    public Page getAllRepaircat2ForPage(Integer pageFirst, Integer pageSize) {
        String sql = "select * from es_repaircat2";
        Page repaircat2 = this.daoSupport.queryForPage(sql,pageFirst,pageSize);
        return repaircat2;
    }

    @Override
    public List<Repaircat2> getAllRepaircat2() {
        String sql = "select * from es_repaircat2";
        return daoSupport.queryForList(sql,Repaircat2.class);
    }

    @Override
    public List<Repaircat2> getRepaircat2ListByCat1Id(Integer repaircat1_id) {
        String sql = "select * from es_repaircat2 where repaircat_id = ?";
        return daoSupport.queryForList(sql,Repaircat2.class,repaircat1_id);
    }
}
