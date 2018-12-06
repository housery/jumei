package com.enation.app.shop.core.other.service;

import com.enation.app.shop.core.other.model.Suggestions;
import com.enation.framework.database.Page;

/**
 * @author: xiaohoo
 * @date: 2018/12/4 10:09
 * @email: 1126457667@qq.com
 */
public interface ISuggestionsManager {

    /**
     * 添加投诉建议
     * @param suggestion
     */
    public void addSuggestion(Suggestions suggestion);

    /**
     * 删除投诉建议
     * @param suggestion_id 建议id
     */
    public void deleteSuggestion(Integer suggestion_id);

    /**
     * 查询所有投诉建议列表
     * @param pageNo 起始页
     * @param pageSize 页大小
     */
    public Page getSuggestions(int pageNo, int pageSize);
}
