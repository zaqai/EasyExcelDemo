package com.zaqai.EasyExcelDemo.read;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelReader;
import com.alibaba.excel.read.listener.PageReadListener;
import com.alibaba.excel.read.metadata.ReadSheet;
import com.zaqai.EasyExcelDemo.data.PersonData;
import com.zaqai.EasyExcelDemo.data.PlayerData;
import org.junit.Test;

public class ReadTest {

    @Test
    public void test06() {
        EasyExcel.read("excel\\02.xlsx",
                        PlayerData.class, new PageReadListener<>(dataList -> {
                            dataList.forEach(System.out::println);
                        }))
                // .registerConverter(new CustomerStringStringConverter())  // 加注解和这个都行
                .sheet(0)// 设置读取工作簿
                .headRowNumber(2)
                .doRead(); // 根据上面的设置读取 excel 文件内容
    }


    // 从excel 文件读取自己指定工作簿，同时支持多个
    @Test
    public void test04() {
        try (ExcelReader excelReader = EasyExcel.read("excel\\01.xlsx").build();) {
            // 创建读的工作簿对象
            ReadSheet readSheet1 = EasyExcel.readSheet(0)
                    .head(PersonData.class)
                    .registerReadListener(new PageReadListener<>(dataList -> {
                        dataList.forEach(System.out::println);
                    })).build();
            ReadSheet readSheet2 = EasyExcel.readSheet(1)
                    .head(PersonData.class)
                    .registerReadListener(new PageReadListener<>(dataList -> {
                        dataList.forEach(System.out::println);
                    })).build();

            excelReader.read(readSheet1, readSheet2);
        }
    }

    @Test
    public void test03() {
        EasyExcel.read("excel\\01.xlsx",
                        PersonData.class, new PageReadListener<>(dataList -> {
                            dataList.forEach(System.out::println);
                        }))
                .doReadAll();
    }


}
