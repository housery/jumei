package com.enation.app.shop.core.property.model;

import com.enation.framework.database.PrimaryKeyField;

public class PropertyPaymentRecord {

    private long payment_record_id;
    private long house_id;
    private int pay_year;
    private long pay_status;
    private long create_date;

    @PrimaryKeyField
    public long getPayment_record_id() {
        return payment_record_id;
    }

    public void setPayment_record_id(long payment_record_id) {
        this.payment_record_id = payment_record_id;
    }

    public long getHouse_id() {
        return house_id;
    }

    public void setHouse_id(long house_id) {
        this.house_id = house_id;
    }

    public int getPay_year() {
        return pay_year;
    }

    public void setPay_year(int pay_year) {
        this.pay_year = pay_year;
    }

    public long getPay_status() {
        return pay_status;
    }

    public void setPay_status(long pay_status) {
        this.pay_status = pay_status;
    }

    public long getCreate_date() {
        return create_date;
    }

    public void setCreate_date(long create_date) {
        this.create_date = create_date;
    }
}
