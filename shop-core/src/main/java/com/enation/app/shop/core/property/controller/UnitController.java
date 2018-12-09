package com.enation.app.shop.core.property.controller;

import com.enation.app.shop.core.property.model.PropertyUnit;
import com.enation.app.shop.core.property.service.impl.PropertyDoornumManager;
import com.enation.app.shop.core.property.service.impl.PropertyUnitManager;
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
 * @date: 2018/12/8 14:16
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/api/shop/property/unit")
public class UnitController {

    @Autowired
    private PropertyUnitManager unitManager;
    @Autowired
    private PropertyDoornumManager doornumManager;

    private Logger logger = Logger.getLogger(UnitController.class);

    /**
     * 添加单元
     * @param unit 单元对象
     * @return
     */
    @RequestMapping(value = "/addUnit",method = RequestMethod.POST)
    public JsonResult addUnit(PropertyUnit unit){
        try {
            unitManager.add(unit);
        } catch (Exception e) {
            e.printStackTrace();
            JsonResultUtil.getErrorJson("添加单元失败！");
        }
        return JsonResultUtil.getSuccessJson("添加单元成功");
    }

    /**
     * 删除单元
     * @param unit_id 单元id
     * @return
     */
    @RequestMapping(value = "/deleteUnit")
    public JsonResult deleteUnit(Integer unit_id){
        try {
            if (doornumManager.getAllDoornum() != null){
                return JsonResultUtil.getErrorJson("该单元下还有户号无法删除，请先删除该单元下所有户号");
            }
            unitManager.delete(unit_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("删除单元失败");
        }
        return JsonResultUtil.getSuccessJson("删除成功");
    }

    /**
     * 根据单元id获取单元对象
     * @param unit_id 单元id
     * @return
     */
    @RequestMapping("/getUnitById")
    public JsonResult getUnitById(Integer unit_id){
        PropertyUnit unit = null;
        try {
            unit = unitManager.getUnitById(unit_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("获取单元失败");
        }
        return JsonResultUtil.getObjectJson(unit);
    }

    /**
     * 获取所有单元
     * @return
     */
    @RequestMapping("/getAllUnit")
    public GridJsonResult getAllUnit(){
        List<PropertyUnit> unitList = null;
        try {
            unitList = unitManager.getAllUnit();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取所有单元失败 " + e.getMessage());
        }
        return JsonResultUtil.getGridJson(unitList);
    }

    /**
     * 根据社区id获取单元列表
     * @param communityId 社区id
     * @return
     */
    @RequestMapping("/getUnitListByCommunityId")
    public GridJsonResult getUnitListByCommunityId(Integer communityId){
        List<PropertyUnit> unitList = null;
        try {
            unitList = unitManager.getUnitListByCommunityId(communityId);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取所有单元失败 " + e.getMessage());
        }
        return JsonResultUtil.getGridJson(unitList);
    }
}
