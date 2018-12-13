package com.enation.app.shop.core.property.model;

import com.enation.framework.database.NotDbField;
import com.enation.framework.database.PrimaryKeyField;

public class PropertyPaymentRecord {

    private long payment_record_id;
    private long house_id;
    private int year;
    private long pay_status;
    private long create_date;
    private Double paymoney;
    private String paymethod;  //支付方式
    private long serial_num; // 支付流水号

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
        return year;
    }

    public void setPay_year(int year) {
        this.year = year;
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

    public Double getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Double paymoney) {
        this.paymoney = paymoney;
    }

    public String getPaymethod() {
        return paymethod;
    }

    public void setPaymethod(String paymethod) {
        this.paymethod = paymethod;
    }

    @NotDbField
    public long getSerial_num() {
        return serial_num;
    }

    public void setSerial_num(long serial_num) {
        this.serial_num = serial_num;
    }
}
