package com.luban.jiantingqi.listener;

import com.luban.jiantingqi.evnt.FileUploadEvent;

public class FileUploadListener implements ApplicationListener<FileUploadEvent> {
    @Override
    public void onEvnt(FileUploadEvent evnt) {
        double i1 = evnt.getFileSize();
        double d = evnt.getReadSize()/i1;
//                map.put("文件ID",d*100);
//                map.remove("文件ID")
        System.out.println("当前文件上传进度百分比:"+d*100+"%");
    }
}
