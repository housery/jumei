package com.enation.app.shop.front.api.other;

import com.enation.app.shop.core.other.model.Suggestions;
import com.enation.app.shop.core.other.service.impl.SuggestionsManager;
import com.enation.framework.action.GridController;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.database.Page;
import com.enation.framework.util.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: xiaohoo
 * @date: 2018/12/4 12:15
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/api/shop/suggestion")
public class SuggestionsController extends GridController {

    @Autowired
    private SuggestionsManager suggestionsManager;

    /**
     * 添加建议
     * @param suggestion 建议对象
     * @return
     */
    @RequestMapping(value = "/addSuggestion",method = RequestMethod.POST)
    public JsonResult addSuggestion(Suggestions suggestion){
        try {
            suggestion.setCreate_date(System.currentTimeMillis());
            suggestionsManager.addSuggestion(suggestion);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("添加投诉建议失败！");
        }
        return JsonResultUtil.getSuccessJson("添加投诉建议成功！");
    }

    /**
     * 删除建议
     * @param suggestion_id 建议id
     * @return
     */
    @RequestMapping("/deleteSuggestion")
    public JsonResult deleteSuggestion(Integer suggestion_id){
        try {
            suggestionsManager.deleteSuggestion(suggestion_id);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("删除建议失败！");
        }
        return JsonResultUtil.getSuccessJson("删除建议成功！");
    }

    /**
     * 获取建议列表
     * 参数继承自 父类
     * @param page 起始页
     * @param length 页大小
     * @return
     */
    @RequestMapping("/getSuggestions")
    public GridJsonResult getSuggestions(){
        Page webPage = null;
        try {
            webPage = suggestionsManager.getSuggestions(this.getPage(), this.getPageSize());
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("获取投诉列表失败");
        }
        return JsonResultUtil.getGridJson(webPage);
    }
}
