package com.enation.app.shop.core.other.model;

import com.enation.framework.database.NotDbField;
import com.enation.framework.database.PrimaryKeyField;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Past;
import java.io.Serializable;
import java.util.Date;

public class Repair implements Serializable {

    private Integer id;

    // 维修类型 1公共维修，2私人报修
    private Integer repair_type;

    // 一级报修类目id
    private int category_id;
    // 二级报修类目id
    private int category2_id;

    // 报修标题
    private String title;

    // 报修内容
    private String content;

    // 报修图片路径1，2，3 第一个图片为非空
    private String img_1;
    private String img_2;
    private String img_3;
    private String address;

    // 报修更新时间
    private long update_date;

    // 报修预约时间
    private long scheduled_date;

    // 支付金额，只有repairType=2（私人报修）才会有支付金额
    private Double paymoney;

    // 支付状态
    private int payment_status;

    // 会员id
    private Integer member_id;

    // 维修状态：1待处理2已处理，3待付款4已付款，5带评论6已评论
    private Integer status;

    // 维修评论
    private String comment;

    // 维修评论状态
    private int comment_status;

    // 维修分类名
    private String category;

    // 主键
    @PrimaryKeyField
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRepair_type() {
        return repair_type;
    }

    public void setRepair_type(Integer repair_type) {
        this.repair_type = repair_type;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImg_1() {
        return img_1;
    }

    public void setImg_1(String img_1) {
        this.img_1 = img_1;
    }

    public String getImg_2() {
        return img_2;
    }

    public void setImg_2(String img_2) {
        this.img_2 = img_2;
    }

    public String getImg_3() {
        return img_3;
    }

    public void setImg_3(String img_3) {
        this.img_3 = img_3;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public long getUpdate_date() {
        return update_date;
    }

    public void setUpdate_date(long update_date) {
        this.update_date = update_date;
    }

    public long getScheduled_date() {
        return scheduled_date;
    }

    public void setScheduled_date(long scheduled_date) {
        this.scheduled_date = scheduled_date;
    }

    public Double getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(Double paymoney) {
        this.paymoney = paymoney;
    }

    public int getPayment_status() {
        return payment_status;
    }

    public void setPayment_status(int payment_status) {
        this.payment_status = payment_status;
    }

    public Integer getMember_id() {
        return member_id;
    }

    public void setMember_id(Integer member_id) {
        this.member_id = member_id;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public int getComment_status() {
        return comment_status;
    }

    public void setComment_status(int comment_status) {
        this.comment_status = comment_status;
    }

    @NotDbField
    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getCategory2_id() {
        return category2_id;
    }

    public void setCategory2_id(int category2_id) {
        this.category2_id = category2_id;
    }
}
