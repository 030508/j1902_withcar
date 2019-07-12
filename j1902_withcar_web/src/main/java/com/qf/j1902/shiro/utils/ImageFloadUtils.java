package com.qf.j1902.shiro.utils;

import org.springframework.ui.Model;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

public  class ImageFloadUtils {
    public static String imageUpload(MultipartFile mf) {
        String path ="E:\\javaee\\j1902_withcar\\j1902_withcar_web\\src\\main\\resources\\static\\upload";

        String fileName = mf.getOriginalFilename();
        String location = path +"/"+ fileName;
        String regex_img = ".+(.JPEG|.jpeg|.JPG|.jpg|.png|.PNG)$";
        if (fileName == null || fileName=="" || !fileName.matches(regex_img)){
            return "url";
        }
        File f = new File(location);
        try {
            f.createNewFile();
            mf.transferTo(f);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
