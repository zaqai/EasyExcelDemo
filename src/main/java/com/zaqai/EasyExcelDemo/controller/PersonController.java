package com.zaqai.EasyExcelDemo.controller;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.read.listener.PageReadListener;
import com.zaqai.EasyExcelDemo.data.PersonData;
import com.zaqai.EasyExcelDemo.mock.PersonMock;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class PersonController {

    // 导出
    @RequestMapping("/export")
    public void export(HttpServletResponse response) throws IOException {
        // 设置响应头，告诉浏览器以下载方式打开，并设置下载文件名
        response.setHeader("Content-disposition", "attachment;filename=person.xlsx");
        EasyExcel.write(response.getOutputStream(), PersonData.class)
            .sheet()
            .doWrite(PersonMock::data);
    }

    // 导入
    @RequestMapping("/importExcel")
    @ResponseBody
    public String importExcel(MultipartFile file) throws IOException {
        EasyExcel.read(file.getInputStream(), PersonData.class, new PageReadListener(list -> {
            System.out.println(list);
        })).sheet().doRead();

        return "success";
    }
}
