package com.example.mvc.util.upload;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

@Controller
@Slf4j
public class UploadController {

    // 첨부파일 저장 루트 경로

    @Value("${file.upload.root-path}")
    private String rootPath;

    @GetMapping("/upload-form")
    public String uploadForm(){

        return "upload/upload-form";
    }


    // MultipartFile = > 파일 받을때 필수, 파라미터에서 name 이 thrumbnail 이라 맞춰야됨
    @PostMapping("/upload-file")
    public String uploadForm(@RequestParam("thumbnail") MultipartFile file){

        log.info("file-name : {}", file.getOriginalFilename());
        log.info("file-size : {}KB", (double)file.getSize());
        log.info("file-type : {}", file.getContentType());

        // 첨부 파일을 스토리지에 저장
        // 1. 루트 디렉토리 생성

        File root = new File(rootPath);

        if(!root.exists()) root.mkdirs();

//        // 2. 파일을 해당 경로에 저장
//        File uploadFile = new File(rootPath, file.getOriginalFilename());
//
//        try {
//            file.transferTo(uploadFile);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


        FileUtil.uploadFile(file, rootPath);
        return "redirect:/upload-form";
    }




}
