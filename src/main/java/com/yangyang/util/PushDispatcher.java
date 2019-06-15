package com.yangyang.util;

import com.gexin.rp.sdk.base.IBatch;
import com.gexin.rp.sdk.base.IIGtPush;
import com.gexin.rp.sdk.base.IPushResult;
import com.gexin.rp.sdk.base.impl.AppMessage;
import com.gexin.rp.sdk.base.impl.SingleMessage;
import com.gexin.rp.sdk.base.impl.Target;
import com.gexin.rp.sdk.http.IGtPush;
import com.gexin.rp.sdk.template.LinkTemplate;
import com.gexin.rp.sdk.template.TransmissionTemplate;
import com.yangyang.entity.User;
import com.yangyang.model.response.UserCard;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

//public class PushDispatcher {
//
//
//}
//    private static final String appId = "Rr51sROK4B8FXbq0TUjAF5";
//    private static final String appKey = "eurxTdqHECAKgc7s4xtUe9";
//    private static final String masterSecret = "2zqRh5hMIY93LBqVlBtsi";
//    private static final String host = "http://sdk.open.api.igexin.com/apiex.htm";
//
//    private final IGtPush pusher;
//    // 要收到消息的人和内容的列表
//    private final List<BatchBean> beans = new ArrayList<>();
//
//    public PushDispatcher() {
//        // 最根本的发送者
//        pusher = new IGtPush(host, appKey, masterSecret);
//    }
//
//    /**
//     * 添加一条消息
//     *
//     * @param receiver 接收者
//     * @param model    接收的推送Model
//     * @return 是否添加成功
//     */
//    public boolean add(String pushId, String pushString) {
//
//        BatchBean bean = buildMessage(pushId,pushString);
//        beans.add(bean);
//        return true;
//    }
//
//    /**
//     * 对要发送的数据进行格式化封装
//     *
//     * @param clientId 接收者的设备Id
//     * @param text     要接收的数据
//     * @return BatchBean
//     */
//    private BatchBean buildMessage(String clientId, String text) {
//        // 透传消息，不是通知栏显示，而是在MessageReceiver收到
//        TransmissionTemplate template = new TransmissionTemplate();
//        template.setAppId(appId);
//        template.setAppkey(appKey);
//        template.setTransmissionContent(text);
//        template.setTransmissionType(0); //这个Type为int型，填写1则自动启动app
//
//        SingleMessage message = new SingleMessage();
//        message.setData(template); // 把透传消息设置到单消息模版中
//        message.setOffline(true); // 是否运行离线发送
//        message.setOfflineExpireTime(24 * 3600 * 1000); // 离线消息时常
//
//        // 设置推送目标，填入appid和clientId
//        Target target = new Target();
//        target.setAppId(appId);
//        target.setClientId(clientId);
//
//        // 返回一个封装
//        return new BatchBean(message, target);
//    }
//
//
//    // 进行消息最终发送
//    public boolean submit() {
//        // 构建打包的工具类
//        IBatch batch = pusher.getBatch();
//
//        // 是否有数据需要发送
//        boolean haveData = false;
//
//        for (BatchBean bean : beans) {
//            try {
//                batch.add(bean.message, bean.target);
//                haveData = true;
//            } catch (Exception e) {
//                e.printStackTrace();
//
//            }
//        }
//
//        // 没有数据就直接返回
//        if (!haveData)
//            return false;
//
//        IPushResult result = null;
//        try {
//            result = batch.submit();
//        } catch (IOException e) {
//            e.printStackTrace();
//
//            // 失败情况下尝试重复发送一次
//            try {
//                batch.retry();
//            } catch (IOException e1) {
//                e1.printStackTrace();
//            }
//
//        }
//
//        if (result != null) {
//            try {
//
//                Logger.getLogger("PushDispatcher")
//                        .log(Level.INFO, (String) result.getResponse().get("result"));
//                return true;
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        Logger.getLogger("PushDispatcher")
//                .log(Level.WARNING, "推送服务器响应异常！！！");
//        return false;
//
//    }
//
//
//    // 给每个人发送消息的一个Bean封装
//    private static class BatchBean {
//        SingleMessage message;
//        Target target;
//
//        BatchBean(SingleMessage message, Target target) {
//            this.message = message;
//            this.target = target;
//        }
//    }
//}

public class PushDispatcher {
    //采用"Java SDK 快速入门"， "第二步 获取访问凭证 "中获得的应用配置，用户可以自行替换
    private static String appId = "WuiWfc6NTuAuqCLVGWWIU4";
    private static String appKey = "zOq9McNtwZ5cRC8bGCI3Y";
    private static String masterSecret = "AEQweP07FGA7GdDwyC2aw1";
    private static String host = "http://sdk.open.api.igexin.com/apiex.htm";

    static String CID_A = "650390bfc1d12c14fd7471e29e04bfb8";
    static String CID_B = "";
    //别名推送方式
    // static String Alias = "";

    public static void main(String[] args) throws IOException {

        IIGtPush push = new IGtPush(host, appKey, masterSecret);
        IBatch batch = push.getBatch();

        try {
            //构建客户a的透传消息a
            constructClientTransMsg(CID_A,"msgA",batch);
            //构建客户B的点击通知打开网页消息b
            //constructClientLinkMsg(CID_B,"msgB",batch);
        } catch (Exception e) {
            e.printStackTrace();
        }
        batch.submit();
    }

    private static void constructClientTransMsg( String cid, String msg ,IBatch batch) throws Exception {

        SingleMessage message = new SingleMessage();
        TransmissionTemplate template = new TransmissionTemplate();
        template.setAppId(appId);
        template.setAppkey(appKey);


        template.setTransmissionContent(msg);
        template.setTransmissionType(1); // 这个Type为int型，填写1则自动启动app

        message.setData(template);
        message.setOffline(true);
        message.setOfflineExpireTime(1 * 1000);

        // 设置推送目标，填入appid和clientId
        Target target = new Target();
        target.setAppId(appId);
        target.setClientId(cid);
        batch.add(message, target);
    }

//    private static void constructClientLinkMsg(String cid, String msg ,IBatch batch) throws Exception {
//
//        SingleMessage message = new SingleMessage();
//        LinkTemplate template = new LinkTemplate();
//        template.setAppId(appId);
//        template.setAppkey(appKey);
//        template.setTitle("title");
//        template.setText("msg");
//        template.setLogo("push.png");
//        template.setLogoUrl("logoUrl");
//        template.setUrl("url");
//
//        message.setData(template);
//        message.setOffline(true);
//        message.setOfflineExpireTime(1 * 1000);
//
//        // 设置推送目标，填入appid和clientId
//        Target target = new Target();
//        target.setAppId(appId);
//        target.setClientId(cid);
//        batch.add(message, target);
//    }



}
