package com.lubanBio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BioServer {
    ServerSocket serverSocket;
    public BioServer(){
        try {
             serverSocket = new ServerSocket(9090);
             while (true){
                 Socket socket = serverSocket.accept();  //阻塞
                 System.out.println("客户端" + socket.getRemoteSocketAddress().toString()+"来连接了");

//                 new Thread(new BioSe)

             }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void  start(){

    }

    public static void main(String[] args) {
        BioServer bioServer = new BioServer();
    }
}
