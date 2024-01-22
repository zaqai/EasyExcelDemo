package com.zaqai.EasyExcelDemo.data;


import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.annotation.format.DateTimeFormat;
import com.alibaba.excel.annotation.format.NumberFormat;
import com.alibaba.excel.annotation.write.style.ColumnWidth;
import com.alibaba.excel.annotation.write.style.ContentRowHeight;
import com.alibaba.excel.annotation.write.style.HeadRowHeight;
import com.zaqai.EasyExcelDemo.convertor.CustomerStringStringConverter;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
@HeadRowHeight(30) // 指定列头行高度
@ContentRowHeight(20) // 指定内容行高度
@ColumnWidth(25) // 指定列宽
public class PlayerData {
    @ExcelProperty(converter = CustomerStringStringConverter.class)
    private String name;
    @DateTimeFormat("yyyy年MM月dd日")
    private Date birthday;
    @NumberFormat("#.##%")
    private BigDecimal bf;

    public PlayerData() {
    }

    public PlayerData(String name, Date birthday, BigDecimal bf) {
        this.name = name;
        this.birthday = birthday;
        this.bf = bf;
    }
}
