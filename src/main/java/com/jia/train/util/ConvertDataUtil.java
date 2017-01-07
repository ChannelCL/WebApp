package com.jia.train.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.jia.train.po.TrainInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Element;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by jiaxl on 2016/12/31.
 */
public class ConvertDataUtil {


    public static <T> T formToObject(String html,Class<T>typeClass) throws  Exception {
        T t=typeClass.newInstance();
        Element form=Jsoup.parse(html).getElementsByTag("form").first();
        for(Element e:form.getElementsByTag("input")){
            Field field=typeClass.getDeclaredField(e.attr("name"));
            field.setAccessible(true);
            field.set(t,e.attr("value"));
        }
        System.out.println(t);
        return t;
    }

    public static List<TrainInfo> getTrainInfos(String json){

        List<TrainInfo>list=new ArrayList<TrainInfo>();
        JSONArray array= JSON.parseArray(json);
        TrainInfo info;
        for (int i=0;i<array.size();i++){
            JSONObject obj1=array.getJSONObject(i);
            JSONObject obj2=obj1.getJSONObject("queryLeftNewDTO");
            info=JSONObject.parseObject(obj2.toString(),TrainInfo.class);
            info.setSecretStr(obj1.getString("secretStr"));
            info.setButtonTextInfo(obj1.getString("buttonTextInfo"));
            list.add(info);
        }
        for (TrainInfo i:list){
            System.out.println(i);
        }
        return list;
    }
    public static void main(String[] args) throws  Exception {


    }
}
