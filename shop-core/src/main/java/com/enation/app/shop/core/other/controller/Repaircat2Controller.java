package com.enation.app.shop.core.other.controller;

import com.enation.app.shop.core.other.model.Repaircat2;
import com.enation.app.shop.core.other.service.impl.Repaircat2Manager;
import com.enation.framework.action.GridController;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.database.Page;
import com.enation.framework.util.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/10 23:31
 * @email: 1126457667@qq.com
 */

@RestController
@RequestMapping("/api/shop/repairCat2")
public class Repaircat2Controller extends GridController {

    @Autowired
    private Repaircat2Manager repaircat2Manager;

    /**
     *  添加二级维修分类
     *  超时费用不填写默认为0，备注不填写默认：自备材料
     * @param repaircat2
     * @return
     */
    @RequestMapping("/addRepaircat2")
    public JsonResult add(Repaircat2 repaircat2){
        try {
            repaircat2Manager.add(repaircat2);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("添加失败");
        }
        return JsonResultUtil.getSuccessJson("添加成功");
    }

    /**
     * 根据二级分类id删除
     * @param repaircat2_id
     * @return
     */
    @RequestMapping("/deleteById")
    public JsonResult delete(Integer repaircat2_id) {
        try {
            repaircat2Manager.delete(repaircat2_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("删除失败");
        }
        return JsonResultUtil.getSuccessJson("删除成功");
    }

    /**
     * 编辑二级分类
     * @param repaircat2
     * @return
     */
    @RequestMapping("/editRepaircat2")
    public JsonResult edit(Repaircat2 repaircat2) {
        try {
            repaircat2Manager.edit(repaircat2);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("编辑完成");
        }
        return JsonResultUtil.getSuccessJson("编辑完成");
    }

    /**
     * 根据二级分类id获取二级分类
     * @param repaircat2_id
     * @return
     */
    @RequestMapping("/getRepaircat2ById")
    public JsonResult getRepaircat2ById(Integer repaircat2_id){
        Repaircat2 repaircat2 = null;
        try {
            repaircat2 = repaircat2Manager.getRepaircat2ById(repaircat2_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("根据id获取二级维修分类出错" + e.getMessage());
        }
        return JsonResultUtil.getObjectJson(repaircat2);
    }
    /**
     * 分页查询所有二级分类
     * @param pageFirst page 起始页
     * @param pageSize length 页大小
     * @return
     */
    @RequestMapping("/getAllRepaircat2ForPage")
    public JsonResult getAllRepaircat2ForPage(Integer pageFirst, Integer pageSize){
        Page webPage = null;
        try {
            webPage = repaircat2Manager.getAllRepaircat2ForPage(this.getPage(), this.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("获取出错");
        }
        return JsonResultUtil.getObjectJson(webPage);
    }

    /**
     * 获取所有二级维修
     * @return
     */
    @RequestMapping("/getAllRepaircat2")
    public GridJsonResult getAllRepaircat2(){
        List<Repaircat2> repaircat2List = null;
        try {
            repaircat2List = repaircat2Manager.getAllRepaircat2();
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取出错" + e.getMessage());
        }
        return JsonResultUtil.getGridJson(repaircat2List);
    }

    /**
     * 根据一级分类id获取二级分类列表
     * @param repaircat1_id
     * @return
     */
    @RequestMapping("/getRepaircat2ListByCat1Id")
    public GridJsonResult getRepaircat2ListByCat1Id(Integer repaircat1_id){
        List<Repaircat2> repaircat2List = null;
        try {
            repaircat2List = repaircat2Manager.getRepaircat2ListByCat1Id(repaircat1_id);
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取出错" + e.getMessage());
        }
        return JsonResultUtil.getGridJson(repaircat2List);
    }
}
