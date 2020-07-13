package com.xd.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DispatchController {

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("downloadFile")
    public String downloadFile(Model model) {

        model.addAttribute("files",FileUploadController.map);
        System.out.println("----------------------------------");
        System.out.println(FileUploadController.map);
        System.out.println("----------------------------------");


        return "downloadFile";
    }
}
