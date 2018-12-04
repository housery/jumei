import com.enation.app.shop.core.member.action.MessageFrontController;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.util.JsonMessageUtil;
import com.enation.framework.util.JsonUtil;
import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author: xiaohoo
 * @date: 2018/12/3 14:29
 * @email: 1126457667@qq.com
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring_cfg/*.xml")
@WebAppConfiguration
public class MessageFrontControllerTest {

    private static Logger logger = Logger.getLogger(TestTemplete.class);

    protected MockMvc mockMvc;

    @Autowired
    protected WebApplicationContext wac;

    @Before()
    public void setup()
    {
        mockMvc = MockMvcBuilders.webAppContextSetup(wac).build();  //初始化MockMvc对象
    }

    @Autowired
    private MessageFrontController messageFrontController;

    @Test
    public void getMessageDetailTest(){
        JsonResult result = messageFrontController.getMessageDetail(1);
        System.out.println("信息结果为：" + result.getData());
    }

    @Test
    public void getRecycleMessage() throws Exception{

        String response = mockMvc.perform(
                get("/shop/member/message/getRecycleMessage")   //请求的url,请求的方法是get
                        .contentType( MediaType.APPLICATION_FORM_URLENCODED ) //请求数据的格式是URL
                        .param( "page","1" )    //URL中的参数
                        .param( "length","5" )
        ).andExpect(status().isOk())  //返回的状态是200
                .andDo(print())  //打印出请求和相应的内容
                .andReturn().getResponse().getContentAsString(); //将相应的数据转换为字符串

    }
}
