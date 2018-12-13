package com.enation.app.shop.core.property.service;

import com.enation.app.shop.core.property.model.PropertyHouse;
import com.enation.framework.database.IDaoSupport;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 * 定时任务
 * @author: xiaohoo
 * @date: 2018/12/12 16:47
 * @email: 1126457667@qq.com
 */
@Component
public class TimerTask {

    @Autowired
    private IDaoSupport daoSupport;
    private Logger logger = Logger.getLogger(TimerTask.class);

    /**
     * 每年向es_property_payment_record 表中插入所有房屋未缴费记录
     * Cron表达式
     * {秒数} {分钟} {小时} {日期} {月份} {星期} {年份(可为空)}
     *
     * 0 0 0 1 1 ?   每年的一月一日00：00：00
     */
    @Scheduled(cron = "0 0 0 1 1 ?")    // 每年的一月一日凌晨00:00:00 插入未缴费记录
    public void erverYearInsert(){
        insertPayRecord();
    }

    /**
     * 每年自动添加物业费缴费记录，默认从房屋表中获取所有房屋id，
     * 为每个房屋添加。
     */
    public void insertPayRecord(){
       List<PropertyHouse> houseList = daoSupport.queryForList("select * from es_property_house",
               PropertyHouse.class);

        // 东八区当前日历
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        // 向支付记录表插入所有数据
        for (PropertyHouse house: houseList) {
            Map fields = new HashMap();
            fields.put("house_id",house.getHouse_id());
            fields.put("pay_year",calendar.get(Calendar.YEAR));
            fields.put("pay_status",0); // 未支付
            // 从房屋表中计算：年物业费=房屋面积*月费*12
            double paymoney = (house.getHouse_area() * house.getMonthly_fee())*12;
            fields.put("paymoney",paymoney);
            daoSupport.insert("es_property_payment_record",fields);
            logger.info("id：" + house.getHouse_id() + ",房屋面积：" + house.getHouse_area() + ",月费："
                    + house.getMonthly_fee()+ " 待缴费金额：" + paymoney);
        }
    }
}
