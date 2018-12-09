package com.enation.app.shop.core.property.controller;

import com.enation.app.shop.core.property.model.PropertyCommunity;
import com.enation.app.shop.core.property.service.impl.PropertyCommunityManager;
import com.enation.app.shop.core.property.service.impl.PropertyUnitManager;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.util.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/7 17:54
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/api/shop/property/community")
public class CommunityController {

    @Autowired
    private PropertyCommunityManager communityManager;
    @Autowired
    private PropertyUnitManager unitManager;

    /**
     * 添加小区
     * 只有后台管理员可以添加
     * @param community 小区对象
     * @return json结果
     */
    @RequestMapping(value = "/addCommunity",method = RequestMethod.POST)
    public JsonResult addCommunity(PropertyCommunity community){
        try {
            communityManager.add(community);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("添加小区失败！");
        }
        return JsonResultUtil.getSuccessJson("添加小区成功！");
    }

    /**
     * 根据社区id删除社区
     * 只能后台管理员删除
     * @param community_id 社区id
     * @return json结果
     */
    @RequestMapping("/deleteCommunity")
    public JsonResult delete(Integer community_id){
        try {
            if (community_id == 0){
                return JsonResultUtil.getErrorJson("请输入参数值");
            }
            // 如果获取到小区下边没有单元则可以删除该小区
            if (unitManager.getUnitListByCommunityId(community_id) != null){
                return JsonResultUtil.getErrorJson("该小区下面还有单元，请先删除该小区下所有单元再尝试删除该小区");
            }
            communityManager.delete(community_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("删除小区失败！");
        }
        return JsonResultUtil.getSuccessJson("删除小区成功！");
    }

    /**
     * 获取所有社区
     * @return
     */
    @RequestMapping("/getAllCommunity")
    public GridJsonResult getAllCommunity(){
        List<PropertyCommunity> communityList = null;
        try {
            communityList = communityManager.getAllCommunity();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getGridJson(communityList);
    }
}
