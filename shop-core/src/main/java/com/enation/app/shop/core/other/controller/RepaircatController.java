package com.enation.app.shop.core.other.controller;

import com.enation.app.shop.core.other.model.Repaircat;
import com.enation.app.shop.core.other.service.impl.RepaircatManager;
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
 * @date: 2018/12/9 21:44
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/api/shop/repairCat")
public class RepaircatController {

    @Autowired
    private RepaircatManager repaircatManager;
    private Logger logger = Logger.getLogger(RepaircatController.class);

    /**
     * 添加维修分类
     * @param repaircat 分类对象
     * @return
     */
    @RequestMapping(value = "/addPrepairCat",method = RequestMethod.POST)
    public JsonResult addPrepairCat(Repaircat repaircat) {
        try {
            repaircatManager.addPrepairCat(repaircat);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("添加出错");
        }
        return JsonResultUtil.getSuccessJson("添加成功");
    }

    /**
     * 根据分类id删除维修分类
     * @param repaircat_id 分类id
     * @return
     */
    @RequestMapping("/deleteRepairCat")
    public JsonResult deleteRepairCat(Integer repaircat_id) {
        try {
            repaircatManager.deleteRepairCat(repaircat_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("删除失败");
        }
        return JsonResultUtil.getSuccessJson("删除成功");
    }

    /**
     * 根据维修分类id获取维修分类
     * @param repaircat_id 维修分类id
     * @return
     */
    @RequestMapping("/getRepaircatById")
    public JsonResult getRepaircatById(Integer repaircat_id) {
        Repaircat repaircat = null;
        try {
            repaircat = repaircatManager.getRepaircatById(repaircat_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("查询出错");
        }
        return JsonResultUtil.getObjectJson(repaircat);
    }

    /**
     * 获取所有维修分类
     * @return
     */
    @RequestMapping("/getAllRepaircat")
    public GridJsonResult getAllRepaircat() {
        List<Repaircat> repaircatList = null;
        try {
            repaircatList = repaircatManager.getAllRepaircat();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取所有维修分类出错" + e.getMessage());
        }
        return JsonResultUtil.getGridJson(repaircatList);
    }
}
