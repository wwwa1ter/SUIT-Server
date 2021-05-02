package com.pose.utils;

import org.apache.commons.io.IOUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ImageUtil {
    public static byte[] getImage(String imgPath){

        if (imgPath == null || imgPath.isEmpty()){
            return new byte[0];
        }

        File file = new File(imgPath);
        byte[] imgConvert2Byte = new byte[0];
        try (FileInputStream fis = new FileInputStream(file)){
            imgConvert2Byte = IOUtils.toByteArray(fis);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgConvert2Byte;
    }

    public static boolean saveFile(MultipartFile file, String rootPath, String filename){
        File realPath = new File(rootPath);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        if (!file.isEmpty()){
            try {
                file.transferTo(new File(rootPath + filename));
                return true;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return false;
    }
}
