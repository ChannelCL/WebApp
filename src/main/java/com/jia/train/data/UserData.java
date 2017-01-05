package com.jia.train.data;

import com.jia.train.po.Passenger;
import java.util.List;

/**
 * Created by jiaxl on 2017/1/5.
 */
public class UserData {
    //常用联系人
    private static List<Passenger>passengers;
    //登录账户姓名
    private static String name;

    public static String getName() {
        return name;
    }

    public static void setName(String name) {
        UserData.name = name;
    }

    public static List<Passenger> getPassengers() {
        return passengers;
    }

    public static void setPassengers(List<Passenger> passengers) {
        UserData.passengers = passengers;
        for(Passenger p:passengers){
            if(p.getIsUserSelf().equals("Y")){
                name=p.getPassenger_name();
            }
        }
    }

}
