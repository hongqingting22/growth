package com.lxl.zhengze;

import org.junit.Test;

import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class zhengze {
    public static void main(String[] args) {

        /*String refer = "https://test.sobot.cn/cfdsfdsonsole/workOrderCenter/workOrderClass/1001/309?fds";
        String url = getUrl(refer);*/
//        String content = "<p><img src=\"https://sobot-test.oss-cn-beijing.aliyuncs.com/console/7e20834c439748c780ca9648ca6c0cde/kb/image/0889d9ebd16a4326b2a93230a65b6714.jpg\" title=\"0889d9ebd16a4326b2a93230a65b6714.jpg\" alt=\"1590209139(1).jpg\"></p>";
//        String content = "<a style=\"font-size:12px; color:#0066cc;\" href=\"https://sobot-test.oss-cn-beijing.aliyuncs.com/console/7e20834c439748c780ca9648ca6c0cde/kb/file/ab1c9f68b18049ebb976f2ac0e193c02.pptx\" title=\"2019公有云研发总结.pptx\">2019公有云研发总结.pptx</a><a href=\"https://www.baidu.com\" target=\"_blank\" title=\"百度\">https://www.baidu.com</a>" +
//                "</p>";
//        test(content);
//
//        List<String> htmlAttr = HtmlRegxUtil.getHtmlAttr(content, "a", "href");
//        System.out.println(htmlAttr.size());
//        htmlAttr.forEach(System.out::println);
//
//        content = "<img src=\"https://sobot-test.oss-cn-beijing.aliyuncs.com/console/7e20834c439748c780ca9648ca6c0cde/kb/image/0889d9ebd16a4326b2a93230a65b6714.jpg\" title=\"0889d9ebd16a4326b2a93230a65b6714.jpg\" alt=\"1590209139(1).jpg\"></p>" +
//                "直接发送：" +
//                "<img data-original=\"https://img.sobot.com/chatres/7e20834c439748c780ca9648ca6c0cde/msg/20200608/3238c530e7344309b0ca3baa17209ca6/6f6f22029ed2476793a804ee9b80cc52.jpg\"  src=\"https://img.sobot.com/chatres/7e20834c439748c780ca9648ca6c0cde/msg/20200608/3238c530e7344309b0ca3baa17209ca6/6f6f22029ed2476793a804ee9b80cc52.jpg\" class=\"webchat_img_upload upNowImg uploadedFile\" />";
//        HtmlRegxUtil.getImgStr(content).forEach(System.out::println);
//
//        System.out.println("------------------------------");

//        String content = "<p>rewrewrfdsf</p>";//文本消息
//        String content = "<p>" +
//                "    <a id=\"sd279\" class=\"node\" href=\"http://www.ruijie.com.cn/fw/wd/60762?type=read&url=https://image.ruijie.com.cn/Upload/Article/b693d13e-37d2-4762-abca-fe2a03d666a2/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/44bd3198-f51f-4cc6-b4a0-78ccff656870.htm\" title=\"01 智分加方案简介和产品介绍\" target=\"_black\">01 智分加方案简介和产品介绍</a><br/>" +
//                "</p>" +
//                "<p>" +
//                "    <a id=\"sd280\" class=\"node\" href=\"http://www.ruijie.com.cn/fw/wd/60762?type=read&url=https://image.ruijie.com.cn/Upload/Article/b693d13e-37d2-4762-abca-fe2a03d666a2/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/923a3987-533c-4317-854e-f00ee5855dea.htm\" title=\"02 智分加产品WLAN及射频参数配置\" target=\"_black\">02 智分加产品WLAN及射频参数配置</a><br/>" +
//                "</p>" +
//                "<p>" +
//                "    <a id=\"sd281\" class=\"node\" href=\"http://www.ruijie.com.cn/fw/wd/60762?type=read&url=https://image.ruijie.com.cn/Upload/Article/b693d13e-37d2-4762-abca-fe2a03d666a2/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/810306cc-c273-42b6-998c-d64af19bf704.htm\" title=\"03 智分加产品微AP管理配置\" target=\"_black\">03 智分加产品微AP管理配置</a><br/>" +
//                "</p>" +
//                "<p>" +
//                "    <a id=\"sd282\" class=\"node\" href=\"http://www.ruijie.com.cn/fw/wd/60762?type=read&url=https://image.ruijie.com.cn/Upload/Article/b693d13e-37d2-4762-abca-fe2a03d666a2/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/51e3b3ec-882e-4ac3-967f-9d6ec16555cf.htm\" title=\"04 AP主机三种组网配置\" target=\"_black\">04 AP主机三种组网配置</a><br/>" +
//                "</p>" +
//                "<p>" +
//                "    <a id=\"sd283\" class=\"node\" href=\"http://www.ruijie.com.cn/fw/wd/60762?type=read&url=https://image.ruijie.com.cn/Upload/Article/b693d13e-37d2-4762-abca-fe2a03d666a2/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/c090d4f0-8f67-4610-8e8a-f56fdfeb3f77.htm\" title=\"05 智分加产品升级\" target=\"_black\">05 智分加产品升级</a><br/>" +
//                "</p>" +
//                "<p>" +
//                "    <a id=\"sd284\" class=\"node\" href=\"http://www.ruijie.com.cn/fw/wd/60762?type=read&url=https://image.ruijie.com.cn/Upload/Article/b693d13e-37d2-4762-abca-fe2a03d666a2/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/89871263-d4e4-40d2-859a-56004509a44c.htm\" title=\"06 智分加产品运维管理\" target=\"_black\">06 智分加产品运维管理</a><br/>" +
//                "</p>" +
//                "<p>" +
//                "    <a id=\"sd285\" class=\"node\" href=\"http://www.ruijie.com.cn/fw/wd/60762?type=read&url=https://image.ruijie.com.cn/Upload/Article/b693d13e-37d2-4762-abca-fe2a03d666a2/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/dc9497c0-424e-422d-a821-658574f3d53e.htm\" title=\"07 智分加产品常见问题\" target=\"_black\">07 智分加产品常见问题</a><br/>" +
//                "</p>" +
//                "<p>" +
//                "    <a id=\"sd286\" class=\"node\" href=\"http://www.ruijie.com.cn/fw/wd/60762?type=read&url=https://image.ruijie.com.cn/Upload/Article/b693d13e-37d2-4762-abca-fe2a03d666a2/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/%E9%94%90%E6%8D%B7WLAN%E6%97%A0%E7%BA%BF%E4%BA%A7%E5%93%81%E4%B8%80%E6%9C%AC%E9%80%9AV6.0/476c928b-5878-44c2-9807-a23ebfc6ddea.htm\" title=\"08 智分加产品常见故障\" target=\"_black\">08 智分加产品常见故障</a><br/>" +
//                "</p>";
        //图片
        String content = "<p><img src=\"https://sobot-test.oss-cn-beijing.aliyuncs.com/console/7e20834c439748c780ca9648ca6c0cde/kb/image/0889d9ebd16a4326b2a93230a65b6714.jpg\" title=\"0889d9ebd16a4326b2a93230a65b6714.jpg\" alt=\"1590209139(1).jpg\"></p>3213";
//        String content = "<img data-original=\"https://img.sobot.com/chatres/7e20834c439748c780ca9648ca6c0cde/msg/20200608/3238c530e7344309b0ca3baa17209ca6/6f6f22029ed2476793a804ee9b80cc52.jpg\"  src=\"https://img.sobot.com/chatres/7e20834c439748c780ca9648ca6c0cde/msg/20200608/3238c530e7344309b0ca3baa17209ca6/6f6f22029ed2476793a804ee9b80cc52.jpg\" class=\"webchat_img_upload upNowImg uploadedFile\" />";
       //附件
//        String content = "<p style=\"line-height: 16px;\">    <img style=\"vertical-align: middle; margin-right: 2px;\" src=\"/console/scripts/plugs/ueditor/dialogs/attachment/fileTypeImages/icon_txt.gif\"><a style=\"font-size:12px; color:#0066cc;\" href=\"https://sobot-test.oss-cn-beijing.aliyuncs.com/console/7e20834c439748c780ca9648ca6c0cde/kb/file/3306ffde33a54940bc769b759f2234a3.xlsx\" title=\"风控敏感词-0512 (1).xlsx\">风控敏感词-0512 (1).xlsx</a></p>1";
//        String content = "<img src=\"//img.sobot.com/yun/attachment/fileTypeImages/icon_xls.gif\" style=\"vertical-align: middle; margin-right: 2px;\" class=\"uploadedFile\"><a style=\"font-size:10px;\" target=\"_blank\" href=\"https://img.sobot.com/chatres/7e20834c439748c780ca9648ca6c0cde/msg/20200608/3238c530e7344309b0ca3baa17209ca6/53344601081541c5b58460b8ccc9898f.xlsx\">公有云Q4OKR.xlsx</a>";
        //视频
//        String content = "<p><embed type=\"application/x-shockwave-flash\" class=\"edui-faked-video\" pluginspage=\"http://www.macromedia.com/go/getflashplayer\" src=\"http://player.youku.com/player.php/sid/XMTgxMjAzMTA0OA==/v.swf\" width=\"420\" height=\"280\" wmode=\"transparent\" play=\"true\" loop=\"false\" menu=\"false\" allowscriptaccess=\"never\" allowfullscreen=\"true\"></p>";
//        String content = "<img src=\"//img.sobot.com/yun/attachment/fileTypeImages/icon_mp3.gif\" style=\"vertical-align: middle; margin-right: 2px;\" class=\"uploadedFile\"><a style=\"font-size:10px;\" target=\"_blank\" href=\"https://img.sobot.com/chatres/7e20834c439748c780ca9648ca6c0cde/msg/20200609/3238c530e7344309b0ca3baa17209ca6/aeea474111ac497aa9014716902114ee.mp4\">7d0ce569626c348e17d66f0b67663f0a(1).mp4</a>";
       //富文本
//        String content = "<p>" +
//                "    <img src=\"https://sobot-test.oss-cn-beijing.aliyuncs.com/console/7e20834c439748c780ca9648ca6c0cde/kb/image/04912e4ff1f5401ca5810bb8d241216e.jpg\" title=\"04912e4ff1f5401ca5810bb8d241216e.jpg\" alt=\"QQ发的萨芬.jpg\"/>pen日志查询最后绑定信息是：" +
//                "</p>" +
//                "<p>" +
//                "    2）chat缓存中保存了platformConfigInfo信息，数据库中没有该信息:" +
//                "</p>" +
//                "<p>" +
//                "    微信后台显示绑定成功，会发送消息到微信回调地址--" +
//                "</p>";
        
//        String content = "<p>" +
//                "    <img src=\"https://sobot-test.oss-cn-beijing.aliyuncs.com/console/7e20834c439748c780ca9648ca6c0cde/kb/image/ae99fed6ddcf412abbdb82bb2d55698b.jpg\" style=\"\" title=\"ae99fed6ddcf412abbdb82bb2d55698b.jpg\"/>" +
//                "</p>" +
//                "<p>" +
//                "    <img src=\"https://sobot-test.oss-cn-beijing.aliyuncs.com/console/7e20834c439748c780ca9648ca6c0cde/kb/image/d4c8b70ddc314a1093ffa69e22a801ca.jpg\" style=\"\" title=\"d4c8b70ddc314a1093ffa69e22a801ca.jpg\"/>" +
//                "</p>";
        msgType(content);
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

    public static void test(String content){
//        String content = "<p style=\"line-height: 16px;\">    <img style=\"vertical-align: middle; margin-right: 2px;\" src=\"/console/scripts/plugs/ueditor/dialogs/attachment/fileTypeImages/icon_txt.gif\"><a style=\"font-size:12px; color:#0066cc;\" href=\"https://sobot-test.oss-cn-beijing.aliyuncs.com/console/7e20834c439748c780ca9648ca6c0cde/kb/file/3306ffde33a54940bc769b759f2234a3.xlsx\" title=\"风控敏感词-0512 (1).xlsx\">风控敏感词-0512 (1).xlsx</a></p>";
        content=content.replaceAll("<p([^>]*)>", "").replaceAll("</p>","");
        System.out.println(content);
        content=content.replaceAll("<img .*?attachment/fileTypeImages.*?>", "");
        System.out.println(content);
        if (content.contains("<a ")) {
            String regEx = "\\s+(?i)(class|style|title|target|rel|charset|name|type|media|coords|shape|rev|id|textvalue|_src)\\s*=\".+?\"";
            Pattern pattern = Pattern.compile(regEx);
            Matcher matcher = pattern.matcher(content);
            content = matcher.replaceAll("");
        }
        System.out.println(content);

    }
    public static String bytesToHexString(byte[] bArray)
    {
        StringBuffer sb = new StringBuffer();
        String sTemp;
        for (int i = 0; i < bArray.length; i++)
        {
            sTemp = Integer.toHexString(0xFF & bArray[i]);
            if (sTemp.length() < 2)
                sb.append(0);
            sb.append(sTemp.toUpperCase());
        }
        return sb.toString();
    }
    @Test
    public void sign(byte[] dataBytes) throws Exception {
        byte[] secretByte = "hdjkshsjkab".getBytes("UTF-8");// "UTF-8"
        SecretKey secret = new SecretKeySpec(secretByte, "HmacSHA256");
        Mac mac = Mac.getInstance(secret.getAlgorithm());
        mac.init(secret);
        byte[] signParaB = mac.doFinal(dataBytes);
        String signPara = bytesToHexString(signParaB);
        System.out.println(signPara);
    }


    public static void msgType(String content){
        String answer = HtmlRegxUtil.replaceNewLine(content);
        String clearAllHtml = HtmlRegxUtil.clearNotTextHtml(answer);
        String clearHtml = HtmlRegxUtil.clearHtml(answer);
        if(clearAllHtml.equals(clearHtml)){//文本消息中包含链接
            System.out.println("文本消息");
        }else{
            String[] element = new String[]{"table","a","img","source","video","embed"};
            List<String> strings = Arrays.asList(element);
            long count = strings.stream().filter(e -> HtmlRegxUtil.containElement(HtmlRegxUtil.replaceFileTypeImg(content), e)).count();
            if(count > 1){
                System.out.println("富文本");
                String desc = HtmlRegxUtil.clearAllHtml(content);
                System.out.println(desc);
            }else{
                String elementContain = strings.stream().filter(e -> HtmlRegxUtil.containElement(HtmlRegxUtil.replaceFileTypeImg(content), e)).findFirst().get();
                if(elementContain.equals("table")){
                    System.out.println("富文本");
                }else if(elementContain.equals("a")){
                    List<String> hrefs = HtmlRegxUtil.getHtmlAttr(content, elementContain, "href");
                    int size = hrefs.size();
                    if(size == 1){
                        String desc = HtmlRegxUtil.clearAllHtml(content);
                        System.out.println(desc+ "---------------");
                        String href = hrefs.get(0);
                        System.out.println("附件："+href);
                    }else{
                        System.out.println("富文本");
                    }
                }else{
                    String desc = HtmlRegxUtil.clearAllHtml(content);
                    System.out.println(desc+"*************************");
                    if(desc == ""){
                        String type = "";
                        List<String> srcs = HtmlRegxUtil.getHtmlAttr(content, elementContain, "src");
                        int size = srcs.size();
                        if(size == 1){
                            switch (elementContain){
                                case "img":
                                    type = "图片";
                                    break;
                                case "source":
                                    type = "音频";
                                    break;
                                case "embed":
                                case "video":
                                    type = "视频";
                                    break;
                            }
                            String src = srcs.get(0);
                            System.out.println(type + ":" + src);
                        }else{
                            System.out.println("富文本");
                        }
                    }else{
                        System.out.println("富文本");
                    }

                }
            }
        }


    }
}
