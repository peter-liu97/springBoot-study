package com.lubanNioDemo;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

public class Demo2 {
    public static void main(String[] args) {
        try {
            FileOutputStream outputStream = new FileOutputStream("demo2");
            FileChannel channel = outputStream.getChannel();
            ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
            while (true){
                int read = channel.read(byteBuffer);
                if(read==-1){
                    break;
                }
                System.out.println(read);
                byteBuffer.flip();
                String  str = new String(byteBuffer.array());
                System.out.println(str);
            }
            outputStream.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
