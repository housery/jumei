package com.enation.app.shop.core.other.service.impl;

import com.enation.app.shop.core.other.model.Suggestions;
import com.enation.app.shop.core.other.service.ISuggestionsManager;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.database.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author: xiaohoo
 * @date: 2018/12/4 11:43
 * @email: 1126457667@qq.com
 */
@Service
@Transactional
public class SuggestionsManager implements ISuggestionsManager {

    @Autowired
    private IDaoSupport daoSupport;

    @Override
    public void addSuggestion(Suggestions suggestion) {
        this.daoSupport.insert("es_suggestions", suggestion);
    }

    @Override
    public void deleteSuggestion(Integer suggestion_id) {
        String sql = "delete from es_suggestions where id = ?";
        this.daoSupport.execute(sql, suggestion_id);
    }

    @Override
    public Page getSuggestions(int pageNo, int pageSize) {
        String sql = "select * from es_suggestions order by create_date desc";
        Page page = this.daoSupport.queryForPage(sql, pageNo, pageSize, Suggestions.class);
        return page;
    }
}
