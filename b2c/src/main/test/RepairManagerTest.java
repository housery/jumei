import com.enation.app.shop.core.other.service.impl.RepairManager;
import com.enation.framework.database.Page;
import com.enation.framework.util.JsonMessageUtil;
import com.enation.framework.util.JsonResultUtil;
import com.enation.framework.util.JsonUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: xiaohoo
 * @date: 2018/11/21 21:08
 * @email: 1126457667@qq.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring_cfg/*.xml")
@WebAppConfiguration
@Rollback
public class RepairManagerTest {
    private static Logger logger = Logger.getLogger(RepairManagerTest.class);

    @Autowired
    private RepairManager repairManager;

    @Test
    public void getRepairByMemberIDTest(){
        Page repairList = repairManager.getRepairByMemberID(1,1,2);
        logger.info(JsonUtil.ObjectToJson(repairList));
    }
}
