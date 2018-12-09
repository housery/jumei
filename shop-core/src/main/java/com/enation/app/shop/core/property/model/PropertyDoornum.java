package com.enation.app.shop.core.property.model;

import com.enation.framework.database.PrimaryKeyField;

public class PropertyDoornum {

    private long doornum_id;
    private long unit_id;
    private long door_num;

    @PrimaryKeyField
    public long getDoornum_id() {
        return doornum_id;
    }

    public void setDoornum_id(long doornum_id) {
        this.doornum_id = doornum_id;
    }

    public long getUnit_id() {
        return unit_id;
    }

    public void setUnit_id(long unit_id) {
        this.unit_id = unit_id;
    }

    public long getDoor_num() {
        return door_num;
    }

    public void setDoor_num(long door_num) {
        this.door_num = door_num;
    }
}
