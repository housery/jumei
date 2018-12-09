package com.enation.app.shop.core.property.model;

import com.enation.framework.database.PrimaryKeyField;

public class PropertyCommunity {


    private long community_id;
    private String community_name;

    public long getCommunity_id() {
        return community_id;
    }

    @PrimaryKeyField
    public void setCommunity_id(long community_id) {
        this.community_id = community_id;
    }

    public String getCommunity_name() {
        return community_name;
    }

    public void setCommunity_name(String community_name) {
        this.community_name = community_name;
    }
}
