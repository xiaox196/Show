package com.ming.abc.show.utils;

public class StringTools {

    public static String nullToEmply(String string){
        if("null".equals(string)||"".equals(string)){
            return "-";
        }
        return string.trim();
    }

    public static String lessTenToZero(int num){
        if(num<10){
            return "0"+num;
        }
        return num+"";

    }
}
