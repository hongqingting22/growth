package com.lxl.string;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.*;
import java.util.Arrays;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringDemo {

//    public static void main(String[] args) {
//        String str = "\"关键词：课程介绍\\n（必填）用户ID：0\\n联系方式：0\\n年级：0\\n学科：0、\\n新老学员：、\\n（选填）课程ID：、\\n课程名称：一年级大语文\\n问题描述：用户咨询一年级的大语文的课程详情，有没有指定课程的售卖\\n问题回复：正常跟用户解释，表示没有用户指定的一年级的大语文标点符号那课有单独售卖的说法。";
//        String s = str.replaceAll("\"", "");
//        System.out.println(s);
//    }

    public static void main(String[] args) throws IOException{
        /*String date1 = "2019-11-23";
        String date2 = "2019-03-01";
        System.out.println(date1.compareTo(date2));*/
//        splitDemo();

//    File file = new File("C:\\Users\\lenovo\\Desktop\\company.txt");

/*        String d = "8) a3db6559c78a4826bb87ec53160d968d";
        String substring = d.substring(d.indexOf(")")+2);
        System.out.println(substring);*/

//        String item = "{\"customerCode\":273,\"flowGroupId\":\"1858fb23fbd4434086d1719af711d90b\"}";
//        PlatformActionVO actionVO = JSONObject.parseObject(item, PlatformActionVO.class);
//        System.out.println(actionVO);

//        splits(",,1,");
//        test();

/*            String msgId = "";
            System.out.println( Optional.ofNullable(msgId).orElse(""));*/

        Long aLong = ipLong("1.204.57.176");
        System.out.println(aLong);
    }

    public static void test(){
        String name = "雷霆游戏服务中心_\uE32E へ风的寂渺ち";
        boolean messyCode = isMessyCode(name);
        System.out.println(messyCode);

    }

    @Test
    public void test1(){
        String domain = "43243.sobot.com";
        String email = domain.substring(0,domain.indexOf(".")) + "@support.sobot.com";
        System.out.println(email);
    }

    @Test
    public void test2(){
        String answer = "fdasfdsafdsafdsf\nfdsafdsfsaf\n";
        if(answer.endsWith("\n"))answer = answer.substring(0,answer.lastIndexOf("\n"));
        System.out.println(answer);
    }
    public static boolean isMessyCode(String strName) {
        Pattern p = Pattern.compile("\\s*|\t*|\r*|\n*");
        Matcher m = p.matcher(strName);
        String after = m.replaceAll("");
        String temp = after.replaceAll("\\p{P}", "");
        char[] ch = temp.trim().toCharArray();
        float chLength = 0 ;
        float count = 0;
        for (int i = 0; i < ch.length; i++) {
            char c = ch[i];
            if (!Character.isLetterOrDigit(c)) {
                if (!isChinese(c)) {
                    count = count + 1;
                }
                chLength++;
            }
        }
        float result = count / chLength ;
        if (result > 0.4) {
            return true;
        } else {
            return false;
        }
    }

    private static Long ipLong(String ip){
        if(null == ip || ip.equals("0.0.0.0"))return null;
        String[] split = ip.split("\\.");
        Long ipLong = (Long.valueOf(split[0]))*(1<<24)+(Long.valueOf(split[1]))*(1<<16)+(Long.valueOf(split[2]))*(1<<8)+(Long.valueOf(split[3]));
        return ipLong;
    }

    private static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }


    public static void splitDemo(){
//        String msg = "sobot|||{\"product_name\":\"周肖222不要动！！\",\"product_image\":\"http://oss.gongzhugou.vip//upload_dev/product/c/5/a/c5a0274d2112fa7470a1652fd5f706cc.jpg?x-oss-process=image/resize,m_fixed,w_512\"}|platformAction={\"customerCode\":\"10761111\",\"flowGroupId\":\"1858fb23fbd4434086d1719af711d90b\"}}";
        String msg = "sobot||";
        String[] split = msg.split("\\|");
        System.out.println("0" + split[0]);
        System.out.println("1" + split[1]);
//        System.out.println("2" + split[2]);
//        System.out.println("3" + split[3]);
//        System.out.println("4" + split[4]);
//        String tmp = "2.8.0".replaceAll("\\.", "");
//        int versionInt = Integer.parseInt(tmp);
//        System.out.println(versionInt >= 190);


    }

    public static void splits(String str) {
        String[] split = str.split(",");
        System.out.println(split.length);
        String s = split[0];
        String s1 = split[1];
        String s2 = split[2];
        String s3 = split[3];
        System.out.println(s + "+" + s1 + "+" + s2 + "+" + s3);
    }

    @Test
    public void testArrays(){
        int[] nums = new int[4];
        nums[0] = 1;
        nums[1] = 0;
        nums[2] = 1;
        nums[3] = 1;
        String s = Arrays.toString(nums);
        System.out.println(s);
        System.out.println(nums.toString());
    }

   static class PlatformActionVO {
        private String customerCode;//子商户code码，cus_company_info表中
        private String flowGroupId;//溢出到主商户的技能组id

        public String getCustomerCode() {
            return customerCode;
        }

        public void setCustomerCode(String customerCode) {
            this.customerCode = customerCode;
        }

        public String getFlowGroupId() {
            return flowGroupId;
        }

        public void setFlowGroupId(String flowGroupId) {
            this.flowGroupId = flowGroupId;
        }

       @Override
       public String toString() {
           return "PlatformActionVO{" +
                   "customerCode='" + customerCode + '\'' +
                   ", flowGroupId='" + flowGroupId + '\'' +
                   '}';
       }
   }





}
