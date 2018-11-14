package com.iebook.utils;

public class MailSend {
    //采用单例以提供持久可用的工具类对象
    static MailUtil mu = new MailUtil();
    public static void sendMail(int flag, String name, String email){
            try {
                MailConfig mc = new MailConfig();
                //设置发件人地址
                mc.setSenderAddress("pengjv1220041602@163.com");
                //设置发件人账户名
                mc.setSenderAccount("pengjv1220041602@163.com");
                //设置发件人密码(备注：密码需要用邮箱SMTP客户端授权密码，而非登录密码，此处需注意)
                mc.setSenderPassword("zpt1994");
                //设置邮件主题
                mc.setSubject("电子书平台");
                //设置收件人地址，多个地址可用逗号隔开
                mc.setRecipientAddresses(email);
                //设置抄送人地址，多个地址可用逗号隔开
                mc.setCopyToAddresses("pengjv1220041602@163.com");
                //设置邮件内容
                if (flag == 1) {
                    mc.setContent("你所提交的电子书"+name+"通过啦!");
                } else if (flag == 2) {
                    mc.setContent("你所提交的电子书"+name+"审核不通过!");
                } else if (flag == 3) {
                    mc.setContent("您已成功注册电子书平台");
                }
                //设置附件地址，多个附件地址用逗号隔开
//                String[] s = {"C:/测试附件1.txt","C:/测试附件2.pdf"};
//                mc.setAttachmentPaths(s);
                //邮件信息配置完毕，调用MailUtil发送邮件。
                mu.sendMail(mc);
            } catch (Exception e) {
                    e.printStackTrace();
            }
    }
}