package com.enation.app.shop.core.other.model;

import com.enation.framework.database.PrimaryKeyField;

/**
 * 维修二级分类
 */
public class Repaircat2 {

    private long repaircat2_id;
    private long repaircat_id;
    private String category2;
    private long labour_cost;
    private double timeout_charge;
    private String remarks;

    @PrimaryKeyField
    public long getRepaircat2_id() {
        return repaircat2_id;
    }

    public void setRepaircat2_id(long repaircat2_id) {
        this.repaircat2_id = repaircat2_id;
    }

    public long getRepaircat_id() {
        return repaircat_id;
    }

    public void setRepaircat_id(long repaircat_id) {
        this.repaircat_id = repaircat_id;
    }

    public String getCategory2() {
        return category2;
    }

    public void setCategory2(String category2) {
        this.category2 = category2;
    }

    public long getLabour_cost() {
        return labour_cost;
    }

    public void setLabour_cost(long labour_cost) {
        this.labour_cost = labour_cost;
    }

    public double getTimeout_charge() {
        return timeout_charge;
    }

    public void setTimeout_charge(double timeout_charge) {
        this.timeout_charge = timeout_charge;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
