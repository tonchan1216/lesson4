package com.example.lesson4bff.app.web.helper;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

@Component
public class S3DownloadHelper{

    private static final String S3_BUCKET_PREFIX = "s3://";
    private static final String DIRECTORY_DELIMITER = "/";

    @Value("${bucket.name}")
    private String bucketName;

    @Autowired
    ResourceLoader resourceLoader;

    public BufferedImage getImage(String imageFilePath){
        Resource resource = resourceLoader.getResource(
                S3_BUCKET_PREFIX +
                        bucketName +
                        DIRECTORY_DELIMITER +
                        imageFilePath);
        BufferedImage image = null;
        try(InputStream inputStream = resource.getInputStream()){
            image = ImageIO.read(inputStream);
        }catch (IOException e){
            e.printStackTrace();
        }
        return image;
    }

    public String getTextFileBody(String textFilePath){
        Resource resource = resourceLoader.getResource(
                S3_BUCKET_PREFIX +
                        bucketName +
                        DIRECTORY_DELIMITER +
                        textFilePath);
        String textBody = null;
        try(InputStream inputStream = resource.getInputStream()){
            textBody = IOUtils.toString(inputStream, StandardCharsets.UTF_8);
        }catch (IOException e){
            e.printStackTrace();
        }
        return textBody;
    }
}