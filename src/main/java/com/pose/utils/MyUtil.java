package com.pose.utils;

import com.pose.exception.guidance.HtmlNotFoundException;
import org.apache.commons.io.IOUtils;

import java.io.*;

public class MyUtil {
    public static String getHtml(String htmlPath){

        if (htmlPath == null || htmlPath.isEmpty()){
            return "";
        }

        File file = new File(htmlPath);
        String html = "";
        try (FileInputStream fis = new FileInputStream(file)) {
            html = IOUtils.toString(fis, "UTF-8");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return html;
    }
}
