package com.lxl.platformAPI;

import com.alibaba.fastjson.JSONObject;
import com.sun.deploy.util.StringUtils;
import sun.net.www.http.HttpClient;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

public class TestDemo {
    public static void main(String[] args) {
        String url = "http://test.sobot.com/api/chat/5/user/chat_send";
        String temp = "2dacb54fdcbd498a8b15d9db5bfaaca0";
        String partnerId = "222";
        String content = "REQUEST:\n" +
                "POST /WebReport/ReportServer?id=7c71d392-0ae2-4fc9-b35d-7065b8d1e803&&op=fs_remote_design&cmd=design_save_report&report_path=三环中化/HR_NEW/三环职业健康体检汇总表.frm&design_prefix=reportlets&__CHARSET__=UTF-8 HTTP/1.1\n" +
                "Content-Type: text/xml;charset=UTF-8\n" +
                "Cache-Control: no-cache\n" +
                "Pragma: no-cache\n" +
                "User-Agent: Java/1.8.0_31\n" +
                "Host: 10.1.2.27\n" +
                "Accept: text/html, image/gif, image/jpeg, *; q=.2, */*; q=.2\n" +
                "Connection: keep-alive\n" +
                "Content-Length: 30922\n" +
                "\n" +
                "{\"op\":\"fs_remote_design\",\"__CONTENT__\":\"<?xml version=\\\"1.0\\\" encoding=\\\"UTF-8\\\"?>\\n<Form xmlVersion=\\\"20170720\\\" releaseVersion=\\\"9.0.0\\\">\\n<TableDataMap>\\n<TableData name=\\\"DATA\\\" class=\\\"com.fr.data.impl.DBTableData\\\">\\n<Parameters>\\n<Parameter>\\n<Attributes name=\\\"检查种类\\\"/>\\n<O>\\n<![CDATA[]]><\\/O>\\n<\\/Parameter>\\n<Parameter>\\n<Attributes name=\\\"接害因素\\\"/>\\n<O>\\n<![CDATA[]]><\\/O>\\n<\\/Parameter>\\n<Parameter>\\n<Attributes name=\\\"部门\\\"/>\\n<O>\\n<![CDATA[]]><\\/O>\\n<\\/Parameter>\\n<Parameter>\\n<Attributes name=\\\"年度\\\"/>\\n<O>\\n<![CDATA[]]><\\/O>\\n<\\/Parameter>\\n<\\/Parameters>\\n<Attributes maxMemRowCount=\\\"-1\\\"/>\\n<Connection class=\\\"com.fr.data.impl.NameDatabaseConnection\\\">\\n<DatabaseName>\\n<![CDATA[三环中化数字工厂]]><\\/DatabaseName>\\n<\\/Connection>\\n<Query>\\n<![CDATA[select employee_number 员工编号,name 姓名,sex 性别,age 年龄,department 部门, post 岗位,DATE_FORMAT(inspection_time,\\\"Y-m-d\\\") 检查时间, inspection_category 检查种类,inspection_bodies 检查机构,contact_factors 接害因素, inspection_results 检查结果 from z_shzh_occupational_health where DATE_FORMAT(i";

//        String content = "aaa";
        Map<String, Object> param = new HashMap<>();
        param.put("partnerid", partnerId);
        param.put("content", content);
        doPost(url, JSONObject.toJSONString(param),temp);
    }


    public static String doPost(String urlPath, String jsonStr,String temp) {
        String result = "";
        BufferedReader reader = null;
        System.out.println("doPost urlPath:"+ urlPath+",jsonStr:"+jsonStr);
        try {
            URL url = new URL(urlPath);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);
            conn.setUseCaches(false);
            conn.setRequestProperty("Connection", "Keep-Alive");
            conn.setRequestProperty("Charset", "UTF-8");
            conn.setRequestProperty("Content-Type", "application/json;charset=UTF-8");
            conn.setRequestProperty("accept", "application/json");
            conn.setRequestProperty("token", temp);
            // 往服务器里面发送数据
            if (null != jsonStr && !jsonStr.equals("")) {
                byte[] writebytes = jsonStr.getBytes();
                conn.setRequestProperty("Content-Length", String.valueOf(writebytes.length));
                OutputStream outwritestream = conn.getOutputStream();
                outwritestream.write(jsonStr.getBytes());
                outwritestream.flush();
                outwritestream.close();
            }

            System.out.println("ResponseCode ："+conn.getResponseCode());
            if (conn.getResponseCode() == 200) {
                reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
                String line;
                while ((line = reader.readLine()) !=null){
                    result+=line;
                }
            }
            System.out.println(result);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        return result;
    }
}
