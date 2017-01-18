package com.test.net;

import com.alibaba.fastjson.JSONObject;
import com.jia.common.util.HttpClientUtil;
import com.jia.kaoqin.util.DBUtil;
import com.test.liketry.Register;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.util.EntityUtils;

import java.io.*;
import java.net.Socket;
import java.net.URI;
import java.net.URLEncoder;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <dl>
 * <dt>Test</dt>
 * <dd>Description:TODO</dd>
 * <dd>Copyright: Copyright (C) 2016</dd>
 * <dd>Company: 青牛（北京）技术有限公司</dd>
 * <dd>CreateDate: 2016年09月09日</dd>
 * </dl>
 *
 * @author 贾学雷
 */
public class Test {

    public static void main(String[] args) throws Exception {

        NumberFormat f=new DecimalFormat("000000");
        for (int i = 0; i <= 30000; i++) {
            System.out.println(f.format(i));
        }
//        Socket socket = new Socket("jiaxuelei.com", 80);
//        OutputStream dos = socket.getOutputStream();
//        DataInputStream dis = new DataInputStream(socket.getInputStream());
//        dos.write(("GET http://jiaxuelei.com/kaoqin HTTP/1.1\n" +
//                "Host: jiaxuelei.com\n" +
//                "Connection: close\n" +
//                "Upgrade-Insecure-Requests: 1\n" +
//                "User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/53.0.2785.101 Safari/537.36\n" +
//                "Accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8\n" +
//                "Accept-Encoding: gzip, deflate, sdch\n" +
//                "Accept-Language: zh-CN,zh;q=0.8,en;q=0.6\n" +
//                "Cookie: JSESSIONID=263D77573409B01C4C8E4F47F5659A2F\n" +
//                "\n").getBytes("utf-8"));
//        dos.flush();
//        Thread.sleep(1000);
//        System.out.println(dis.available());
//        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
//        byte[]data=new byte[1024];
//        int len=dis.read(data);
//        while (len >0) {
//            byteArrayOutputStream.write(data,0,len);
//            len=dis.read(data);
//            System.out.println(len);
//        }
//        System.out.println(new String(byteArrayOutputStream.toByteArray()));

//        String json= HttpClientUtil.getDataByGet("http://m.10010.com/NumApp/NumberCenter/qryNum?callback=jsonp_queryMoreNums&provinceCode=51&cityCode=530&monthFeeLimit=0&groupKey=30242960&searchCategory=3&net=01&amounts=200&codeTypeCode=&searchValue=&qryType=02&goodsNet=4&_=1482551523639", null);
//        int i=0;
//        while (i++<1000){
//            Thread.sleep(500);
//            String json = HttpClientUtil.getDataByGet("http://m.10010.com/NumApp/NumberCenter/qryNum?callback=jsonp_queryMoreNums&provinceCode=11&cityCode=110&monthFeeLimit=0&groupKey=30242833&searchCategory=3&net=01&amounts=200&codeTypeCode=&searchValue="+i+"&qryType=02&goodsNet=4&_="+System.currentTimeMillis(), null);
//            Pattern p = Pattern.compile("\\d{11}");
//            Matcher m = p.matcher(json);
//            List<String> list = new ArrayList<String>();
//            while (m.find()) {
//                list.add(m.group());
//            }
//            System.out.println("ListSize:"+list.size());
//            DBUtil.insertPhone(list);
//        }

//        HttpClient client= HttpClientUtil.getProxyHttpClient();
//        HttpGet get=new HttpGet("http://www.ps3838.com/zh-cn/sports");
//        get.setHeader("Cookie","visid_incap_917486=WO57XpytTKCMTsRCaZoYdWq6c1gAAAAAQUIPAAAAAAAaoR6MWv5IK5cVVQkeh08X; incap_ses_432_917486=1CFndy/59zimrk0pIcb+BX66c1gAAAAAk9Jby5BTfYF8iJmiHS6UsA==; ___utmvmoluRMMk=QSkHmfQsNlk; ___utmvboluRMMk=HZu XjoOsalq: cte");
//        get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
//     get.setHeader("Cache-Control","max-age=0");
//     get.setHeader("Upgrade-Insecure-Requests","1");
//     get.setHeader("Accept-Language","zh-CN,zh;q=0.8,en;q=0.6");
//     get.setHeader("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8");
//     HttpResponse resp=client.execute(get);
//        String result=EntityUtils.toString(resp.getEntity());
//        String url="";
//        Pattern p=Pattern.compile("/_Incapsula_Resource.*?\"");
//        Matcher m=p.matcher(result);
//        if(m.find()){
//            url="http://www.ps3838.com"+result.substring(m.start(),m.end()-1);
//            System.out.println(url);
//        }
//        url=url.replaceAll(" ","%20");
//        System.out.println(url);
//        get=new HttpGet(url);
//        get.setHeader("Referer","http://www.ps3838.com/zh-cn/sports");
//        get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
//        resp=client.execute(get);
//        System.out.println(EntityUtils.toString(resp.getEntity()));
//
//        get=new HttpGet("http://www.ps3838.com/_Incapsula_Resource?SSATYUBA=error:captcha_"+System.currentTimeMillis());
//        get.setHeader("Host","www.ps3838.com");
//        get.setHeader("Connection","keep-alive");
//        get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
//        get.setHeader("Accept","*/*");
//        get.setHeader("Accept-Language","zh-CN,zh;q=0.8,en;q=0.6");
//        get.setHeader("Accept-Encoding","gzip, deflate, sdch");
//        get.setHeader("Referer",url);
//
//        resp=client.execute(get);
//        System.out.println("Set-Cookie:"+EntityUtils.toString(resp.getEntity()));
//
//        get=new HttpGet("http://www.ps3838.com/zh-cn/sports");
//        get.setHeader("Cache-Control","max-age=0");
//        get.setHeader("Referer","http://www.ps3838.com/dns-dispatcher/service/dispatch?purpose=MemberSite&next=/zh-cn/sports");
//        get.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/45.0.2454.101 Safari/537.36");
//        resp=client.execute(get);
//        System.out.println(EntityUtils.toString(resp.getEntity()));
    }

}