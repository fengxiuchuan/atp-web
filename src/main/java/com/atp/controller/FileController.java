package com.atp.controller;

import com.atp.exception.ATPException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletResponse;
import java.io.*;

/**
 * @Description
 * @Author: Administrator
 * @Date : 2018/8/23 14 51
 */
@Controller
@RequestMapping(value = "/fileCtr")
public class FileController extends BaseController{

    @PostMapping(value = "/testFile.stream")
    public void testFile(HttpServletResponse response) throws ATPException,IOException{
        try {
            String path = ("D:\\BugReport.txt");
            // path是指欲下载的文件的路径。
            File file = new File(path);
            // 取得文件名。
            String filename = file.getName();
            // 取得文件的后缀名。
            String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

            // 以流的形式下载文件。
            InputStream fis = new BufferedInputStream(new FileInputStream(path));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            // 设置response的Header
            response.addHeader("Content-Disposition", "attachment;filename=" + new String(filename.getBytes()));
            response.addHeader("Content-Length", "" + file.length());
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
