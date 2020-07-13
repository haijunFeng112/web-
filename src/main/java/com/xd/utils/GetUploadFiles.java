package com.xd.utils;

import java.io.File;

/**
 * @author hjfeng
 * @date 2020--07--07  15:20
 */
public class GetUploadFiles {

    public void getUploadFiles(){

        File file = new File(UploadDest.path);
        File[] files = file.listFiles();
        for (File f: files){
            System.out.println(f.getName());
        }

    }

    public static void main(String[] args) {

        GetUploadFiles get = new GetUploadFiles();
        get.getUploadFiles();
    }

}
