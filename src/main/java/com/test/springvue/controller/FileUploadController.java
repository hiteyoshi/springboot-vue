package com.test.springvue.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String up(String nickname, MultipartFile photo, HttpServletRequest request) throws IOException{
        System.out.println(nickname);
        //获取图片原始名称
        System.out.println(photo.getOriginalFilename());
        //取文件类型
        System.out.println(photo.getContentType());
        System.out.println(System.getProperty("user.dir"));
        //获取web服务器运行的目录,文件存在此处
        String path=request.getServletContext().getRealPath("/upload/");
        System.out.println(path);
        saveFile(photo,path);
        return "upload success";

    }

    public void saveFile(MultipartFile photo, String path) throws IOException{
        File dir = new File(path);
        if (!dir.exists()){
            dir.mkdir();
        }
        File file = new File(path+photo.getOriginalFilename());
        photo.transferTo(file);
    }

}
