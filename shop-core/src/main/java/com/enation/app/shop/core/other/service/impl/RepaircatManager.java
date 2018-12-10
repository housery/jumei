package com.enation.app.shop.core.other.service.impl;

import com.enation.app.shop.core.other.model.Repaircat;
import com.enation.app.shop.core.other.service.IRepaircatManager;
import com.enation.framework.database.IDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/9 21:27
 * @email: 1126457667@qq.com
 */
@Service
@Transactional
public class RepaircatManager implements IRepaircatManager {

    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public void addPrepairCat(Repaircat repaircat) {
        daoSupport.insert("es_repaircat",repaircat);
    }

    @Override
    public void deleteRepairCat(Integer repaircat_id) {
        String sql = "delete FROM es_repaircat where repaircat_id = ?";
        daoSupport.execute(sql,repaircat_id);
    }

    @Override
    public Repaircat getRepaircatById(Integer repaircat_id) {
        String sql = "select * from es_repaircat where repaircat_id = ?";
        Repaircat repaircat = daoSupport.queryForObject(sql,Repaircat.class,repaircat_id);
        return repaircat;
    }

    @Override
    public List<Repaircat> getAllRepaircat() {
        String sql = "select * from es_repaircat";
        List<Repaircat> repaircatList = daoSupport.queryForList(sql,Repaircat.class);
        return repaircatList;
    }
}
