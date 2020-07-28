package com.lubanNioDemo;

import java.nio.IntBuffer;
import java.security.SecureRandom;

public class Demo1 {
    public static void main(String[] args) {
        IntBuffer intBuffer = IntBuffer.allocate(8);
        for (int i = 0; i <intBuffer.capacity() ; i++) {
            int nextInt = new SecureRandom().nextInt(20);
            intBuffer.put(nextInt);
        }
        intBuffer.flip();
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }
    }
}
