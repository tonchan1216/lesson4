package com.example.lesson4bff.app.web;

import com.example.lesson4bff.app.model.FileUploadForm;
import com.example.lesson4bff.app.model.User;
import com.example.lesson4bff.app.web.helper.S3DirectDownloadHelper;
import com.example.lesson4bff.app.web.helper.S3DownloadHelper;
import com.example.lesson4bff.app.web.helper.S3UploadHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestOperations;

import java.awt.image.BufferedImage;

@Controller
public class BackendForFrontendController {

    @Autowired
    RestOperations restOperations;

    @Autowired
    S3DownloadHelper s3DownloadHelper;

    @Autowired
    S3UploadHelper s3UploadHelper;

    @Autowired
    S3DirectDownloadHelper s3DirectDownloadHelper;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/portal")
    public String portal(Model model){
        model.addAttribute("imageUrl",
                s3DirectDownloadHelper.getPresignedUrl("sample2.jpg").toString());
        return "portal";
    }

    @RequestMapping(method = RequestMethod.GET, value = "users")
    public String getUsers(Model model){
        String service = "/backend/api/v1/users";
        model.addAttribute("users",
                restOperations.getForObject(service, User[].class));
        return "users";
    }

    @GetMapping(value = "/image",
            headers = "Accept=image/jpeg, image/jpg, image/png, image/gif",
            produces = {MediaType.IMAGE_JPEG_VALUE, MediaType.IMAGE_PNG_VALUE, MediaType.IMAGE_GIF_VALUE})
    @ResponseBody
    public ResponseEntity<BufferedImage> getImage(){
        return ResponseEntity.ok().body(
                s3DownloadHelper.getImage("sample.jpg"));
    }

    @GetMapping("getTextFileBody")
    @ResponseBody
    public ResponseEntity<String> getTextFileBody(){
        return ResponseEntity.ok().body(
                s3DownloadHelper.getTextFileBody("test.txt"));
    }

    @PostMapping("upload")
    public String upload(FileUploadForm fileUploadModel){
        s3UploadHelper.saveFile(fileUploadModel.getUploadFile());
        return "redirect:/uploadResult.html";
    }

    @GetMapping("downloadFile")
    @ResponseBody
    public ResponseEntity<String> downloadFile(){
        return ResponseEntity.ok().body(
                s3DirectDownloadHelper.getDownloadPresignedUrl("test.txt").toString());
    }

    @GetMapping("/uploadResult.html")
    public String uploadResult(){
        return "uploadResult";
    }
}
