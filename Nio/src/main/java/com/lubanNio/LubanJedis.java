package com.lubanNio;

public class LubanJedis {

    LubanSocket lubanSocket = new LubanSocket("127.0.0.1",6379);


    public String set(String key, String value){


        lubanSocket.send(commandUtils(Resp.command.SET,key.getBytes(),value.getBytes()));
        return lubanSocket.read();
    }

    public String get(String key){

        lubanSocket.send(commandUtils(Resp.command.GRT,key.getBytes()));
        return lubanSocket.read();
    }
    public String incr(String key){

        lubanSocket.send(commandUtils(Resp.command.INCR,key.getBytes()));
        return lubanSocket.read();
    }
    public static String commandUtils(Resp.command command , byte[]... bytes){
        StringBuffer stringBuffer = new StringBuffer();

        stringBuffer.append(Resp.STAR).append(1+bytes.length).append(Resp.LINE);

        stringBuffer.append(Resp.STRING_LENGTH).append(command.toString().length()).append(Resp.LINE);

        stringBuffer.append(command.toString()).append(Resp.LINE);

        for (byte[] aByte : bytes) {
            stringBuffer.append(Resp.STRING_LENGTH).append(aByte.length).append(Resp.LINE);
            stringBuffer.append(new String(aByte)).append(Resp.LINE);
        }
        return stringBuffer.toString();
    }

    public static void main(String[] args) {
        LubanJedis lubanJedis = new LubanJedis();
        System.out.println(lubanJedis.set("key1", "v1"));
    }

}
