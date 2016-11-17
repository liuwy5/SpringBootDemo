package com.demo.controller.upload;

import com.demo.util.RandomUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.List;

/**
 * Created by lw on 16-11-15.
 * upload file
 */
@RestController
@RequestMapping("/upload")
public class BatchFileUploadController {

    @Value("${upload.path}")
    String uploadPath;

    @RequestMapping(value = "/batch/picture", method = RequestMethod.POST)
    @ResponseBody
    public String handleFileUpload(HttpServletRequest httpServletRequest) {
        List<MultipartFile> files = ((MultipartHttpServletRequest)httpServletRequest).getFiles("file");

        File filePath = new File(uploadPath);
        if (!filePath.exists()) {
            filePath.mkdir();
        }

        for (MultipartFile file : files) {
            String fileName = uploadPath + file.getName() + RandomUtil.getRandomString(5);
            if (!file.isEmpty()) {
                try {
                    File destFile = new File(fileName);
                    file.transferTo(destFile);
                } catch (Exception e) {
                    e.printStackTrace();
                    return "upload file failed";
                }
            } else {
                return "the file is empty";
            }
        }
        return "upload file successful";
    }
}
