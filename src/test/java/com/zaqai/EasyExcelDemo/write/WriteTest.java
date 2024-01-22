package com.zaqai.EasyExcelDemo.write;


import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.zaqai.EasyExcelDemo.data.PersonData;
import com.zaqai.EasyExcelDemo.data.PlayerData;
import com.zaqai.EasyExcelDemo.mock.PersonMock;
import com.zaqai.EasyExcelDemo.mock.PlayerMock;
import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

public class WriteTest {

    // 往多个工作簿中写入不同的数据
    @Test
    public void test06() {
        try (ExcelWriter excelWriter = EasyExcel.write("excel\\08.xlsx").build()) {

            WriteSheet writeSheet1 = EasyExcel.writerSheet().
                    head(PersonData.class).sheetName("蜀国").build();

            WriteSheet writeSheet2 = EasyExcel.writerSheet().
                    head(PlayerData.class).sheetName("运动员").build();

            excelWriter.write(PersonMock::data, writeSheet1);
            excelWriter.write(PlayerMock::data, writeSheet2);
        }
    }


    // 把数据写到磁盘 excel 文件中
    @Test
    public void test03() {
        // 设置
        EasyExcel.write("excel\\05.xlsx", PersonData.class)
                // .excludeColumnFieldNames(set)
                .sheet() // 设置写到哪个工作簿
                .doWrite(PersonMock.data()); // 真的写
    }


    // 把数据写到磁盘 excel 文件中
    @Test
    public void test01() {
        Set<String> set = new HashSet<>();
        set.add("id");
        set.add("name");

        // 设置
        EasyExcel.write("excel\\03.xlsx", PersonData.class)
                // .excludeColumnFieldNames(set)
                .includeColumnFieldNames(set)
                .sheet() // 设置写到哪个工作簿
                .doWrite(PersonMock.data()); // 真的写
    }
}
