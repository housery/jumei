import com.enation.app.shop.core.other.service.impl.RepairManager;
import com.enation.app.shop.core.property.model.PropertyPaymentRecord;
import com.enation.framework.database.IDaoSupport;
import com.enation.framework.database.Page;
import com.enation.framework.util.JsonMessageUtil;
import com.enation.framework.util.JsonResultUtil;
import com.enation.framework.util.JsonUtil;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.*;

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
    @Autowired
    private IDaoSupport  daoSupport;

    @Test
    public void getRepairByMemberIDTest(){
        Page repairList = repairManager.getRepairByMemberID(1,1,2);
        logger.info(JsonUtil.ObjectToJson(repairList));
    }

    /**
     * 每年定时插入数据
     */
    @Test
    @Scheduled(cron = "* * * * * ?")
    public void erverYearInsert(){
        List<PropertyPaymentRecord> recordList = daoSupport.queryForList("select house_id from es_property_house",
                PropertyPaymentRecord.class);
        List<Long> houseId = new ArrayList<Long>();
        for (PropertyPaymentRecord record: recordList) {
            houseId.add(record.getHouse_id());
        }

        // 东八区当前日历
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        // 向支付记录表插入所有数据
        for (Long id: houseId) {
            Map fields = new HashMap();
            fields.put("house_id",id);
            fields.put("pay_year",calendar.get(Calendar.YEAR));
            fields.put("pay_status",0); // 未支付
            fields.put("create_date",System.currentTimeMillis());
            daoSupport.insert("es_property_payment_record",fields);
        }
    }

    @Test
    public void timer(){
        Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
        Date date = calendar.getTime();
    }

    @Test
    public void changeStatus(){
        repairManager.changePayStatus(1);
    }

}
