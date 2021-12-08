package com.lxl.http;

import java.util.concurrent.TimeUnit;

public class TestHttp {
    public static void main(String[] args) {
//		String companyId = "7e20834c439748c780ca9648ca6c0cde";
		String companyId = "2a1cbdd7bbea4a71b5037dc0f90e359e";//王敏
//        String companyId = "3393d86547c74e4f892118e5696cc743";
		Integer num = 100000;
		String partnerId = "xiaomin";
		add(companyId, num, partnerId);

		/*String adminId = "61673ee8d98d4282a95cdad38ffd5f5b";
		String adminId2 = "5f1829d34d3d4ff7b5ca998236686a89";
		while (true){
			try {
			    new Thread(() ->{
                    go(adminId, companyId, partnerId, num);
                }).start();

				Thread.sleep(60);

				new Thread(() ->{
                    go(adminId2, companyId, partnerId, num);
                }).start();

			} catch (Exception e){

			}
		}*/
        //测试排队一个，邀请一个
        /*String companyId = "7e20834c439748c780ca9648ca6c0cde";
        Integer num = 2;
        String partnerId = "waituser";
//        add(companyId, num, partnerId);
        String adminId = "61673ee8d98d4282a95cdad38ffd5f5b";
        invite(adminId, num);*/

    }

    public static void go(String adminId,String companyId, String partnerId,Integer num){
        try {
            Integer invite = 6;
            invite(adminId, invite);

            Integer addWait = 10;
//            add(companyId, addWait, partnerId + (num += addWait));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void add(String companyId,Integer num,String partnerid){
        String addWaitUrl = "http://test.sobot.com/chat-web/opt/addWaitUser.action?companyId=" + companyId + "&num=" + num + "&partnerid=" + partnerid;
        String s = HttpUtil.sendGet(addWaitUrl);
    }

    public static  void invite(String adminId, Integer num){
        String inviteUrl = "http://test.sobot.com/chat-web/opt/inviteWaitUser.action?adminId=" + adminId + "&num=" + num;
        HttpUtil.sendGet(inviteUrl);
    }
}
