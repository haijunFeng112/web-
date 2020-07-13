package com.xd.controller;

import com.xd.entity.FileMetaData;
import com.xd.utils.UploadDest;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.websocket.server.PathParam;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.http.HttpResponse;

@Controller
public class FileDownloadController {

    @GetMapping("/down")
    public void downloadFiles(@RequestParam("fileName") String fileName, HttpServletRequest request, HttpServletResponse response){

        String filePath = UploadDest.path + "/"+ FileUploadController.map.get(fileName).getName();

        //更新下载数
        FileMetaData fileMetaData = FileUploadController.map.get(fileName);
        Integer count = fileMetaData.getDownloadCount();
        fileMetaData.setDownloadCount(++count);

        FileUploadController.map.replace(fileName,fileMetaData);
        System.out.println(FileUploadController.map.get(fileName));


        File downloadFile = new File(filePath);

        ServletContext context = request.getServletContext();

        String mimeType = context.getMimeType(filePath);
        if (mimeType == null) {
            mimeType = "application/octet-stream";
            System.out.println("context getMimeType is null");
        }

        System.out.println("MIME type: " + mimeType);

        response.setContentType(mimeType);

        response.setContentLength((int) downloadFile.length());

        String headerKey = "Content-Disposition";
        String headerValue = String.format("attachment; filename=\"%s\"",
                downloadFile.getName());
        response.setHeader(headerKey, headerValue);

        try {
            InputStream myStream = new FileInputStream(filePath);
            IOUtils.copy(myStream, response.getOutputStream());
            response.flushBuffer();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
