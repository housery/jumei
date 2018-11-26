import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author: xiaohoo
 * @date: 2018/11/21 21:02
 * @email: 1126457667@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring_cfg/*.xml")
@WebAppConfiguration
public class TestTemplete {

    private static Logger logger = Logger.getLogger(TestTemplete.class);

    @Test
    public void test(){
        logger.info("这是一个测试模板...");
    }
}
