package com.enation.app.shop.core.property.model;

import com.enation.framework.database.PrimaryKeyField;

public class PropertyUnit {

    private long unit_id;
    private long community_id;
    private String unit_name;

    @PrimaryKeyField
    public long getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(long unit_id) {
        this.unit_id = unit_id;
    }

    public long getCommunity_id() {
        return community_id;
    }

    public void setCommunity_id(long community_id) {
        this.community_id = community_id;
    }

    public String getUnit_name() {
        return unit_name;
    }

    public void setUnit_name(String unit_name) {
        this.unit_name = unit_name;
    }
}
