package com.lxl.string;

import com.alibaba.fastjson.JSONObject;

import java.io.*;

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

        String item = "{\"customerCode\":273,\"flowGroupId\":\"1858fb23fbd4434086d1719af711d90b\"}";
        PlatformActionVO actionVO = JSONObject.parseObject(item, PlatformActionVO.class);
        System.out.println(actionVO);
    }


    public static void splitDemo(){
//        String msg = "sobot|||[object Object]|partnerid=1000001268";
//        String[] split = msg.split("\\|");
//        System.out.println(split[0]);
//        System.out.println(split[1]);
//        System.out.println(split[2]);
//        System.out.println(split[3]);
//        System.out.println(split[4]);
//        String tmp = "2.8.0".replaceAll("\\.", "");
//        int versionInt = Integer.parseInt(tmp);
//        System.out.println(versionInt >= 190);


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


    private static void readFile1(File fin,String target) throws IOException {
        FileInputStream fis = new FileInputStream(fin);

        //Construct BufferedReader from InputStreamReader
        BufferedReader br = new BufferedReader(new InputStreamReader(fis));
        FileOutputStream fos = new FileOutputStream(new File("company1.txt"));

        //Construct BufferedReader from InputStreamReader
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fos));
        String line = null;
        while ((line = br.readLine()) != null) {
//            System.out.println(line);
            if(line != ""&& line != null){
                String substring = line.substring(line.indexOf(")")+2);
                System.out.println(substring);
//                writer.write(substring);
            }
        }

        br.close();
        writer.close();
    }


}
