package com.lubanBio;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class BioServerHandler implements Runnable {

    //负责客户端通信

    private Socket socket;
    public BioServerHandler(Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {

        InputStream  inputStream = null;
        OutputStream outputStream = null;
        try {
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            int count = 0;
            String content = null;
            byte[] bytes = new byte[1024];
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
