package com.zycdojar;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Date;


public class infoget extends Thread{
    BufferedReader br = null;
    public infoget(InputStream is){
        br=new BufferedReader(new InputStreamReader(is));
    }
    public void run() {
        try{
            while(true){
                JSONObject jo = new JSONObject(br.readLine());
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
                Date now = new Date();
                String datethis=dateFormat.format(now);
                if(jo.getString("Message").startsWith("@$Admin ")){
                    String message=jo.getString("Message");
                    message.replaceFirst("@$Admin ","");
                    System.out.println("at "+datethis+" "+jo.getString("User")+" "+message);
                }else{
                    System.out.println("at "+datethis+" "+jo.getString("User")+" "+jo.getString("Message"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
