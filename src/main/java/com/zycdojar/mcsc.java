package com.zycdojar;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;

public class mcsc{
    public static void main(String[] args){
        String username = null;
        JSONObject info = new JSONObject();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int messages;
        Socket socket=null;
        PrintWriter pw=null;
        try {
            username = br.readLine();
            socket = new Socket("play.zycdojar.com",5567);

            pw = new PrintWriter(socket.getOutputStream());
            info.append("Password","qwdsfrgfhsf");
            info.append("Message", "@$Admin " + InetAddress.getLocalHost() + " logging");
            pw.print(info);
            while(true){
                JSONObject out = new JSONObject();
                out.append("Password","qwdsfrgfhsf");
                System.out.print("Input Message>");
                String message = br.readLine();
                if(message.startsWith("@Command ")){
                    if(message.equals("@Command stop")){
                        socket.close();
                        break;
                    }
                }else
                if(message.startsWith("@Server ")){
                    message.replaceFirst("@Server ","");
                    out.append("Message","@$any");
                    out.append("Command",message);
                }else{
                    out.append("Message",message);
                    out.append("Command","@$any");
                }

            }
            System.out.println("Author:Zycddj");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Maybe the server is not started");
        }
    }
}