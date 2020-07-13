package com.xd.controller;

import com.xd.entity.FileMetaData;
import com.xd.utils.UploadDest;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

@Controller
public class FileUploadController {
    /**
     * 实现文件上传
     */

    //保存上传的文件信息
    public static HashMap<String, FileMetaData> map = new HashMap();

    @PostMapping("/fileUpload")
    @ResponseBody
    public String fileUpload( @RequestParam("fileName") MultipartFile file,HttpSession session) {
        if (file.isEmpty()) {
            return "上传文件为空，上传失败";
        }
        String fileName = file.getOriginalFilename();

        int size = (int) file.getSize();
        System.out.println(fileName + "-->" + size);

        String path = UploadDest.path;
        System.out.println(path);

        File dest = new File(path + "/" + fileName);
        if (!dest.getParentFile().exists()) { //判断文件父目录是否存在
            dest.getParentFile().mkdir();
        }

        File disk = new File(path);
        long freeSpace = disk.getFreeSpace();
        if (freeSpace < size){
            return "磁盘空间不足";
        }

        try {
            file.transferTo(dest); //保存文件

            FileMetaData metaData = new FileMetaData();
            metaData.setAuthor((String) session.getAttribute("username"));
            metaData.setName(fileName);
            metaData.setSize(size);
            SimpleDateFormat sdf = new SimpleDateFormat();
            sdf.applyPattern("yyyy-MM-dd HH:mm:ss a");
            metaData.setUploadDate(sdf.format(new Date()));

            map.put(fileName.substring(0,fileName.lastIndexOf(".")),metaData);

            return "上传成功";
        } catch (IllegalStateException | IOException e) {
            e.printStackTrace();
            return "上传失败";
        }

    }


}