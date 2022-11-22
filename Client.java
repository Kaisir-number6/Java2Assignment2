package application;

import application.controller.Controller;

import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.Socket;

public class Client{

    public void client(int player){
        try {
            // 和服务器创建连接
            Socket socket = new Socket("localhost",8088);

            // 要发送给服务器的信息
            OutputStream os = socket.getOutputStream();
            PrintWriter pw = new PrintWriter(os);
            pw.write(player+"号玩家准备");
            pw.flush();

            socket.shutdownOutput();

            // 从服务器接收的信息
            InputStream is = socket.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String info = null;
            while((info = br.readLine())!=null&& Controller.win()==0){
                System.out.println(player+"号玩家就绪："+info);
            }

            while((info = br.readLine())!=null&& Controller.win()!=0&&Controller.win()!=3){
                System.out.println(player+"号玩家胜利");
            }

            while((info = br.readLine())!=null&& Controller.win()==3){
                System.out.println("平局");
            }





            br.close();
            is.close();
            os.close();
            pw.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

}


