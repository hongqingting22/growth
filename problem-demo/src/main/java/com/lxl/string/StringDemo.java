package com.lxl.string;

public class StringDemo {

    public static void main(String[] args) {
        String str = "\"关键词：课程介绍\\n（必填）用户ID：0\\n联系方式：0\\n年级：0\\n学科：0、\\n新老学员：、\\n（选填）课程ID：、\\n课程名称：一年级大语文\\n问题描述：用户咨询一年级的大语文的课程详情，有没有指定课程的售卖\\n问题回复：正常跟用户解释，表示没有用户指定的一年级的大语文标点符号那课有单独售卖的说法。";
        String s = str.replaceAll("\"", "");
        System.out.println(s);
    }
}
