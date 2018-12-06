import com.enation.app.shop.core.other.service.impl.SuggestionsManager;
import com.enation.framework.database.Page;
import com.enation.framework.util.JsonUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: xiaohoo
 * @date: 2018/12/4 12:01
 * @email: 1126457667@qq.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring_cfg/*.xml")
@WebAppConfiguration
public class SuggestManagerTest {
    private static Logger logger = Logger.getLogger(SuggestManagerTest.class);

    @Autowired
    private SuggestionsManager suggestionsManager;

    @Test
    public void getSuggestionsTest(){
        Page suggestPage = suggestionsManager.getSuggestions(1, 2);
        logger.info("投诉建议列表" + JsonUtil.ObjectToJson(suggestPage));
    }
}
