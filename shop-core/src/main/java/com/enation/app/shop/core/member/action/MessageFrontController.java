package com.enation.app.shop.core.member.action;

import com.enation.app.base.core.model.Member;
import com.enation.app.shop.core.member.service.impl.MessageFrontManager;
import com.enation.eop.sdk.context.UserConext;
import com.enation.framework.action.GridController;
import com.enation.framework.action.GridJsonResult;
import com.enation.framework.action.JsonResult;
import com.enation.framework.database.Page;
import com.enation.framework.util.JsonResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author: xiaohoo
 * @date: 2018/12/3 11:16
 * @email: 1126457667@qq.com
 */
@RestController
@RequestMapping("/shop/member/message")
public class MessageFrontController extends GridController {

    @Autowired
    private MessageFrontManager messageFrontManager;

    /**
     * 获取站内消息列表
     * @return
     */
    @RequestMapping("/getMessagesFront")
    public GridJsonResult getMessagesFront(int page, int length){
        Page messageFront = null;
        try {
            Member member = UserConext.getCurrentMember();
            int member_id = member.getMember_id();
            messageFront = messageFrontManager.getMessagesFront(this.getPage(), this.getPageSize(), member_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getGridJson(messageFront);
    }

    /**
     * 获取未读取的消息数量
     * @return
     */
    @RequestMapping("/getMessageNoReadCount")
    public JsonResult getMessageNoReadCount(){
        int messageNoReadCount = 0;
        try {
            messageNoReadCount = messageFrontManager.getMessageNoReadCount();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getSuccessJson(String.valueOf(messageNoReadCount));
    }

    /**
     * 回收消息
     * @param messageIds 消息id
     * @return
     */
    @RequestMapping("/editMessageInRecycle")
    public JsonResult editMessageInRecycle(String messageIds){
        try {
            messageFrontManager.editMessageInRecycle(messageIds);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("回收消息失败");
        }
        return JsonResultUtil.getSuccessJson("回收消息成功");
    }

    /**
     * 更新消息为已读
     * @param messageIds 消息id
     */
    @RequestMapping("/editMessageHaveRead")
    public JsonResult editMessageHaveRead(String messageIds){
        try {
            messageFrontManager.editMessageHaveRead(messageIds);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getErrorJson("更新消息已读失败");
        }
        return JsonResultUtil.getSuccessJson("更新消息已读成功");
    }

    /**
     * 获取消息详情
     * @param messageId 消息id
     */
    @RequestMapping("/getMessageDetail")
    public JsonResult getMessageDetail(Integer messageId){
        Map map = null;
        try {
            map = messageFrontManager.getMessageDetail(messageId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getObjectJson(map);
    }

    /**
     * 获取回收站信息列表
     * @return
     */
    @RequestMapping("/getRecycleMessage")
    public GridJsonResult getRecycleMessage(int page, int length){
        Page recycleMessage = null;
        try {
            Member member = UserConext.getCurrentMember();
            int member_id = member.getMember_id();
            recycleMessage = messageFrontManager.getRecycleMessage(this.getPage(), this.getPageSize(), member_id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getGridJson(recycleMessage);
    }

    /**
     * 删除消息
     * @param messageIds 消息id
     * @return
     */
    @RequestMapping("/deleteMessages")
    public JsonResult deleteMessages(String messageIds){
        try {
            messageFrontManager.deleteMessages(messageIds);
        } catch (Exception e) {
            e.printStackTrace();
            return JsonResultUtil.getSuccessJson("删除消息失败");
        }
        return JsonResultUtil.getSuccessJson("删除消息成功");
    }


    /**
     * 根据消息id的列表获取消息
     * @param messageIds ids 1，2，3，4
     * @return
     */
    @RequestMapping("/getCountByIds")
    public JsonResult getCountByIds(String messageIds){
        Integer result = null;
        try {
            result = messageFrontManager.getCountByIds(messageIds);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return JsonResultUtil.getSuccessJson(String.valueOf(result));
    }
}
