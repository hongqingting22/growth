package com.lxl.file;

import com.lxl.zhengze.HtmlRegxUtil;
import org.junit.Test;
import org.springframework.web.util.HtmlUtils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFile {

    @Test
    public void test() throws Exception{

        Object[] objects = Files.lines(Paths.get("C:\\Users\\lenovo\\Desktop\\result.txt")).toArray();
//        System.out.println(objects);
        List<String> collect = Arrays.stream(objects).map(e -> (String) e).collect(Collectors.toList());
//        System.out.println(collect);
        List<String> collect1 = collect.stream().filter(e -> Integer.valueOf(e.split("\t")[1]) < 1000).collect(Collectors.toList());
//        System.out.println(collect1);
        List<String> collect2 = collect1.stream().map(e -> e.split("\t")[0]).collect(Collectors.toList());
       collect2.stream().forEach(System.out::println);


    }

    public static String getTagAttr(String source, String element, String attr) {
        String result = "";
        String reg = "<" + element + "[^<>]*?s" + attr
                + "=['\"]?(.*?)['\"]?s.*?>";
        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result += r;
        }
        return result;
    }

    public static List<String> getHtmlAttr(String content, String element, String attr) {
        String ele = "";
        Pattern pattern;
        Matcher matcher;
        List<String> links = new ArrayList<String>();
        String regEx = "<"+element+"([^>]*)>";
        pattern = Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(content);
        while (matcher.find()) {
            ele = matcher.group();
            Matcher m = Pattern.compile(attr + "=\"?(.*?)(\"|>|s+)").matcher(ele);
            while (m.find()) {
                String url = m.group(1).replaceAll("'", "");
                links.add(url);
            }
        }
        return links;
    }
}
