package com.enation.app.shop.core.other.model;

import com.enation.framework.database.PrimaryKeyField;

import java.io.Serializable;
import java.util.Date;

public class Repair implements Serializable {

    private Integer id;

    // 维修类型 1公共维修，2私人报修
    private Integer repairType;

    // 报修类型
    private String category;

    // 报修标题
    private String title;

    // 报修标题
    private String content;

    // 报修图片路径1，2，3 第一个图片为非空
    private String img1;
    private String img2;
    private String img3;
    private String address;

    // 报修更新时间
    private Date updateDate;

    // 报修预约时间
    private Date scheduledDate;

    // 支付金额，只有repairType=2（私人报修）才会有支付金额
    private Double paymoney;

    // 会员id
    private Integer member_id;

    // 维修状态：1待处理2已处理，3待付款4已付款，5带评论6已评论
    private Integer status;

    // 维修评论
    private String comment;

    // 主键
    @PrimaryKeyField
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public Integer getRepairType() {
        return repairType;
    }

    public void setRepairType(Integer repairType) {
        this.repairType = repairType;
    }


    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
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


    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }


    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }


    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }


    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }


    public Date getScheduledDate() {
        return scheduledDate;
    }

    public void setScheduledDate(Date scheduledDate) {
        this.scheduledDate = scheduledDate;
    }


    public double getPaymoney() {
        return paymoney;
    }

    public void setPaymoney(double paymoney) {
        this.paymoney = paymoney;
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
}
