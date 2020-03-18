package com.lxl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zhengze {
    public static void main(String[] args) {

        String refer = "https://test.sobot.cn/cfdsfdsonsole/workOrderCenter/workOrderClass/1001/309?fds";
        String url = getUrl(refer);

    }

    private static String getUrl(String url){
        String regex = "http(s)?:\\/\\/([a-zA-Z\\-0-9\\.]+)\\/?";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(url);
        if(matcher.find()){
            String group = matcher.group(0);
            return group;
        }
        return null;
    }
}
