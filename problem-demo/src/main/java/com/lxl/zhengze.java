package com.lxl;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class zhengze {
    public static void main(String[] args) {

        String refer = "https://test.sobot.cn/cfdsfdsonsole/workOrderCenter/workOrderClass/1001/309";
        String regex = "(\\S*//[^/]*/)";  //
//        Pattern pattern = Pattern.compile(regex);
//        Matcher matcher = pattern.matcher(refer);
        String s = refer.replaceAll(regex, "");
        System.out.println(refer.replaceAll(s,""));

//        if(matcher.matches()){
//            System.out.println(matcher.group());
//            System.out.println(matcher.group(1));
//        }

    }
}
