package com.enation.app.shop.core.property.controller;

import com.enation.app.shop.core.property.model.PropertyDoornum;
import com.enation.app.shop.core.property.service.impl.PropertyDoornumManager;
import com.enation.app.shop.core.property.service.impl.PropertyHouseManager;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.util.JsonResultUtil;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/8 14:52
 * @email: 1126457667@qq.com
 */
@RestController("/api/shop/property/doornum")
public class DoornumController {

    @Autowired
    private PropertyDoornumManager doornumManager;
    @Autowired
    private PropertyHouseManager houseManager;
    private Logger logger = Logger.getLogger(UnitController.class);

    /**
     * 添加户号
     *
     * @param doornum 户号
     * @return
     */
    @RequestMapping(value = "/addDoornum", method = RequestMethod.POST)
    public JsonResult addDoornum(PropertyDoornum doornum) {
        try {
            doornumManager.add(doornum);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("添加户号失败！");
        }
        return JsonResultUtil.getSuccessJson("添加户号成功");
    }

    /**
     * 删除户号
     *
     * @param dooornum_id
     * @return
     */
    @RequestMapping(value = "/deleteDooornum")
    public JsonResult deleteDooornum(Integer dooornum_id) {
        try {
            if (houseManager.getAllHouse() != null) {
                return JsonResultUtil.getErrorJson("该户号下面含有房屋信息以及缴费记录,无法删除，请先删除该房屋的信息");
            }
            doornumManager.delete(dooornum_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("删除户号失败");
        }
        return JsonResultUtil.getSuccessJson("删除户号成功");
    }

    /**
     * 获取所有户号
     *
     * @return
     */
    @RequestMapping("/getAllDoornum")
    public GridJsonResult getAllDoornum() {
        List<PropertyDoornum> doornumList = null;
        try {
            doornumList = doornumManager.getAllDoornum();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取户号失败" + e.getMessage());
        }
        return JsonResultUtil.getGridJson(doornumList);
    }

    /**
     * 根据单元id获取户号列表
     *
     * @param unit_id 社区id
     * @return
     */
    @RequestMapping("/getDoornumListByUnitId")
    public GridJsonResult getDoornumListByUnitId(Integer unit_id) {
        List<PropertyDoornum> doornumList = null;
        try {
            doornumList = doornumManager.getDoornumListByUnitId(unit_id);
        } catch (Exception e) {
            e.printStackTrace();
            JsonResultUtil.getErrorJson("根据社区id获取户号失败");
        }
        return JsonResultUtil.getGridJson(doornumList);
    }

    /**
     * 根据户号id获取户号对象
     * @param doornum_id 户号id
     * @return
     */
    @RequestMapping("/getDoornumById")
    public JsonResult getDoornumById(Integer doornum_id) {
        PropertyDoornum doornum = null;
        try {
            doornum = doornumManager.getDoornumById(doornum_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("根据户号id获取户号对象失败");
        }
        return JsonResultUtil.getObjectJson(doornum);
    }
}
