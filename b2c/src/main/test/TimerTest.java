import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.*;

/**
 * @author: xiaohoo
 * @date: 2018/12/12 11:24
 * @email: 1126457667@qq.com
 */
public class TimerTest extends TimerTask {

    @Test
    public void test(){
        Timer timer = new Timer();
        TimerTest timerTest = new TimerTest();
        timer.schedule(timerTest,0,1000);
    }

    /*public static void main(String[] args) {
        Timer timer = new Timer();
        TimerTest timerTest = new TimerTest();
        timer.schedule(timerTest,0,1000);
    }*/

    @Override
    public void run() {
        System.out.println("调用数据库方法。。。");
    }

    @Test
    public void insert(){
        while (true){
            Calendar calendar = Calendar.getInstance(TimeZone.getTimeZone("GMT+08:00"));
            System.out.println(calendar.getTime());
        }
    }

    public static void main(String[] args) {

    }
}
