package com.enation.app.shop.core.property.controller;

import com.enation.app.shop.core.property.model.PropertyHouse;
import com.enation.app.shop.core.property.service.impl.PropertyHouseManager;
import com.enation.app.shop.core.property.service.impl.PropertyPayRecordManager;
import com.enation.framework.action.JsonResult;
import com.enation.framework.util.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/8 15:30
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/api/shop/property/house")
public class HouseController {

    @Autowired
    private PropertyHouseManager houseManager;
    @Autowired
    private PropertyPayRecordManager payRecordManager;

    /**
     * 添加房屋信息
     * @param house 房屋对象
     * @return
     */
    @RequestMapping(value = "/addHouse",method = RequestMethod.POST)
    public JsonResult addHouse(PropertyHouse house){
        try {
            house.setCreate_date(System.currentTimeMillis());
            houseManager.add(house);
        } catch (Exception e) {
            e.printStackTrace();
            JsonResultUtil.getErrorJson("添加房屋信息失败");
        }
        return JsonResultUtil.getSuccessJson("添加房屋信息成功");
    }

    /**
     * 根据房屋id删除房屋信息，该操作会一起删掉物业缴费中该房屋的记录
     * @param house_id 房屋id
     * @param isDelRecord 是否删除房屋下边的记录
     * @return
     */
    @RequestMapping("/deleteHouse")
    public JsonResult deleteHouse(Integer house_id, Boolean isDelRecord){
        StringBuffer info = new StringBuffer("删除信息：");
        try {
            if (isDelRecord){ // true 删除对应记录
                payRecordManager.deleteByHouseId(house_id);
                info.append(house_id + "：交易记录删除成功 ");
            }
            houseManager.delete(house_id); // 删除房屋信息
            info.append(house_id + "：房屋删除成功 ");
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("刪除失败");
        }
        return JsonResultUtil.getSuccessJson(info.toString());
    }

    /**
     * 获取所有房屋列表
     * @return
     */
    @RequestMapping("/getAllHouse")
    public JsonResult getAllHouse(){
        List<PropertyHouse> houseList = null;
        try {
            houseList = houseManager.getAllHouse();
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("获取房屋列表出错");
        }
        return JsonResultUtil.getObjectJson(houseList);
    }

    /**
     * 通过房屋id获取房屋对象
     * @param house_id 房屋id
     * @return
     */
    @RequestMapping("/getHouseById")
    public JsonResult getHouseById(Integer house_id){
        PropertyHouse house = null;
        try {
            house = houseManager.getHouseById(house_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("获取房屋出错");
        }
        return JsonResultUtil.getObjectJson(house);
    }

    /**
     * 获取房屋对象
     * @param community_id 社区id
     * @param unit_id 单元id
     * @param doornum_id 户号id
     * @return
     */
    @RequestMapping("/getHouseByCUDId")
    public JsonResult getHouseByCUDId(Integer community_id, Integer unit_id, Integer doornum_id){
        PropertyHouse house = null;
        try {
            house = houseManager.getHouseByCUDId(community_id,unit_id,doornum_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("获取房屋出错");
        }
        return JsonResultUtil.getObjectJson(house);
    }
}
