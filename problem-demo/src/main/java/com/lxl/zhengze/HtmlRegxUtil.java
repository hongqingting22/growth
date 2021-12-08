package com.lxl.zhengze;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HtmlRegxUtil {

    /**
     * 只保留a标签中的href属性
     * @param content
     * @return
     */
    public static String getHref(String content){
        if (content.contains("<a ")) {
            String regEx = "\\s+(?i)(class|style|title|target|rel|charset|name|type|media|coords|shape|rev|id|textvalue|_src|data-size)\\s*=\".+?\"";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll("");
        }
        return content;
    }

    /**
     * 获取图片地址
     * @param msg
     * @return
     */
    public static String getImgSrc(String msg) {
        return getTagAttr(msg, "img", "src");
    }

    /**
     * 获取链接地址
     * @param msg
     * @return
     */
    public static String getHttpHref(String msg) {
        return getTagAttr(msg, "a", "href");
    }

    public static String getEmbedSrc(String msg) {
        return getTagAttr(msg, "embed", "src");
    }
    public static String getVideoSrc(String msg) {
        return getTagAttr(msg, "video", "src");
    }
    public static String getSourceSrc(String msg) {
        return getTagAttr(msg, "source", "src");
    }

    public static String getTagAttr(String source, String element, String attr) {
        String result = "";
        String reg = "<" + element + "[^<>]*?\\s" + attr
                + "=['\"]?(.*?)['\"]?\\s.*?>";
        Matcher m = Pattern.compile(reg).matcher(source);
        while (m.find()) {
            String r = m.group(1);
            result += r;
        }
        return result;
    }

    /**
     *去掉文件类型的图片img标签
     * @param content
     * @return
     */
    public static String replaceFileTypeImg(String content){
        return content.replaceAll("<img .*?attachment/fileTypeImages.*?>", "");
    }

    /**
     * 是否包含文件类型图片
     * @param content
     * @return
     */
    public static boolean containFileTypeImg(String content){
        return content.contains("attachment/fileTypeImages");
    }

    /**
     * 获取所有图片地址
     * @param htmlStr
     * @return
     */
    public static List<String> getImgStr(String htmlStr) {
        String img = "";
        Pattern p_image;
        Matcher m_image;
        List<String> pics = new ArrayList<String>();
        String regEx_img = "<img([^>]*)>"; // 图片链接地址
        p_image = Pattern.compile(regEx_img, Pattern.CASE_INSENSITIVE);
        m_image = p_image.matcher(htmlStr);
        while (m_image.find()) {
            img = m_image.group();
            Matcher m = Pattern.compile("src=\"?(.*?)(\"|>|\\s+)").matcher(img); // 匹配src
            while (m.find()) {
                String url = m.group(1).replaceAll("'", "");
                pics.add(url);
            }
        }
        return pics;
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
            Matcher m = Pattern.compile(attr + "=\"?(.*?)(\"|>|\\s+)").matcher(ele);
            while (m.find()) {
                String url = m.group(1).replaceAll("'", "");
                links.add(url);
            }
        }
        return links;
    }

    //判断是否是table
    public static boolean containElement(String htmlStr,String element) {
        Pattern p_table;
        Matcher m_table;
        String regEx_table = "</?"+element+"[^>]*>"; // 图片链接地址
        p_table = Pattern.compile(regEx_table, Pattern.CASE_INSENSITIVE);
        m_table = p_table.matcher(htmlStr);
        while (m_table.find()) {
            return true;
        }
        return false;
    }

    //保留可用标签，其余标签全部删除
    public static String clearHtml(String content){
        return content.replaceAll("</?(?!/?[img,table,a,video,embed,source])[^>]*>","");
    }
    public static String clearNotTextHtml(String content){
        return content.replaceAll("</?(?!/?[a])[^>]*>","");
    }
    //删除所有标签
    public static String clearAllHtml(String content){
        return content.replaceAll("<[^>]*>","");
    }

    /**
     * 替换换行符
     * @param content
     * @return
     */
    public static String replaceNewLine(String content){
        return content.replaceAll("<br([^>]*)></p>", "\n").replaceAll("</br([^>]*)></p>", "\n")
                .replaceAll("</p>", "\n").replaceAll("<br([^>]*)>", "").replaceAll("<p([^>]*)>", "");
    }

    /**
     * 替换所有的script和on事件为指定字符串
     * @param content
     * @return
     */
    public static String replaceScript(String content, String replacement){
        if (StringUtils.isEmpty(content)) {
            return content;
        }
        // 正则表达式: (?i)标识不区分大小写. 例如:<sCript></scRipt>也会被替换
        // 替换script标签
        String regex1 = "(?i)<[\\s]*?script[^>]*?>[\\s\\S]*?<[\\s]*?/[\\s]*?script[\\s]*?>";
        String regex2 = "(?i)<[\\s]*?script[^>]*?/[\\s]*?>";
        // 替换带有on事件的html标签
        String regex3 = "(?i)<[\\s\\S]*?(on)[a-zA-Z]*?=.*?>[\\s\\S]*?<[\\s]*?/.*>";
        String regex4 = "(?i)<[\\s\\S]*?(on)[a-zA-Z]*?=.*?>";

        String value = content.replaceAll(regex1, replacement)
                .replaceAll(regex2, replacement)
                .replaceAll(regex3, replacement)
                .replaceAll(regex4, replacement);
        return value;
    }

}
