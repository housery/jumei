import com.enation.app.shop.core.property.service.impl.PropertyPayRecordManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: xiaohoo
 * @date: 2018/12/13 13:22
 * @email: 1126457667@qq.com
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring_cfg/*.xml")
@WebAppConfiguration
public class PropertyTest {
    private static Logger logger = Logger.getLogger(TestTemplete.class);

    @Autowired
    private PropertyPayRecordManager payRecordManager;

    /**
     * 支付成功调用修改订单支付状态
     */
    @Test
    public void payProperty(){
        List<Integer> idList = new ArrayList<>();
        idList.add(1);
        idList.add(7);
        payRecordManager.payProperty(idList);
    }
}
