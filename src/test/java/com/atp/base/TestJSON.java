package com.atp.base;

import net.sf.json.JSONArray;

import java.util.*;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/7/2 11 07
 */
public class TestJSON {
        public static void main(String[] args) {

            /*String url = "<p><span style=\"color: rgb(33, 33, 33); font-family: &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, 微软雅黑, SimSun, 宋体, sans-serif; font-size: 15px;\">尊敬的报表用户，您好！</span><br style=\"color: rgb(33, 33, 33); font-family: &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, 微软雅黑, SimSun, 宋体, sans-serif; font-size: 15px;\"><br style=\"color: rgb(33, 33, 33); font-family: &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, 微软雅黑, SimSun, 宋体, sans-serif; font-size: 15px;\"><font color=\"#212121\" face=\"Microsoft YaHei UI, Microsoft YaHei, 微软雅黑, SimSun, 宋体, sans-serif\"><span style=\"font-size: 15px;\">&nbsp; {{reportName}}的截止日期为{{endDate}}，截至{{nowDate}}贵单位尚未完成上报，请尽快登录法务管理系统完成上报。如已完成上报，请忽略此邮件提醒。</span></font><br style=\"color: rgb(33, 33, 33); font-family: &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, 微软雅黑, SimSun, 宋体, sans-serif; font-size: 15px;\"><span style=\"color: rgb(33, 33, 33); font-family: &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, 微软雅黑, SimSun, 宋体, sans-serif; font-size: 15px;\">&nbsp;&nbsp;</span><span style=\"color: rgb(33, 33, 33); font-family: &quot;Microsoft YaHei UI&quot;, &quot;Microsoft YaHei&quot;, 微软雅黑, SimSun, 宋体, sans-serif; font-size: 12px;\">详细信息可通过<a href=\"http://%7Burl%7D/\" target=\"_blank\">点击此链接查看</a>。如不能打开链接，请把下面链接内容拷贝到浏览器地址栏中打开：{url}<br>&nbsp;&nbsp;此信由法务管理系统发出，系统不接收回信，因此请勿直接回复。</span><br></p>";
            System.out.println(url.replace("112","").replace("{{reportName}}","报告名称").replace("{{endDate}}","2018-09-03").replace("{{nowDate}}","2018-07-04"));
            Boolean a = Boolean.TRUE;
            Boolean b = Boolean.FALSE;
            System.out.println(a);
            System.out.println(Objects.equals(a,'0'));
            System.out.println(Objects.equals(b,'1'));*/
            String ccc = "http://http://www.baidu.com";
            //ccc = ccc.replace("http://","");
            System.out.println(ccc.indexOf("http://"));
           /* Map<String,Object> testMap = new HashMap<String,Object>();
            Map<String,Object> testMap2 = new HashMap<String,Object>();
            List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
            testMap.put("ID","这是测试");
            testMap.put("record","测试^lms");
            testMap2.put("ID","这是测试11");
            testMap2.put("record","测试^lms11");
            testMap2.put("time","2018-09-07");
            list.add(testMap);list.add(testMap2);
            System.out.println(JSONArray.fromObject(list).toString());*/
    }
}
