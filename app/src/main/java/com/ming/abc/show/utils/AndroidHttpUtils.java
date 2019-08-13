package com.ming.abc.show.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class AndroidHttpUtils {

    public static  String get(String url){
        HttpURLConnection connection = null;
        BufferedReader reader = null;
        StringBuilder result=null;
        try {
            connection = (HttpURLConnection) new URL(url).openConnection();
            //设置请求方法
            connection.setRequestMethod("GET");
            //设置连接超时时间（毫秒）
            connection.setConnectTimeout(15000);
            //设置读取超时时间（毫秒）
            connection.setReadTimeout(15000);

            //返回输入流
            InputStream in = connection.getInputStream();

            //读取输入流
            reader = new BufferedReader(new InputStreamReader(in));
            result = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                result.append(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (connection != null) {//关闭连接
                connection.disconnect();
            }
        }
        if(result!=null){
            System.out.println("http result:"+result);
            return result.toString();
        }
        return null;
    }

}
