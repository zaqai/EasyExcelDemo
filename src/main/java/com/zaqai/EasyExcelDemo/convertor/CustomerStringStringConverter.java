package com.zaqai.EasyExcelDemo.convertor;

import com.alibaba.excel.converters.Converter;
import com.alibaba.excel.converters.ReadConverterContext;
import com.alibaba.excel.converters.WriteConverterContext;
import com.alibaba.excel.enums.CellDataTypeEnum;
import com.alibaba.excel.metadata.data.WriteCellData;

public class CustomerStringStringConverter implements Converter<String> {


    // 支持 Java 类型
    @Override
    public Class<?> supportJavaTypeKey() {
        return String.class;
    }

    // 支持 Excle 单元格的类型
    @Override
    public CellDataTypeEnum supportExcelTypeKey() {
        return CellDataTypeEnum.STRING;
    }

    // 当读到数据符合类型，封装的字段也符合类型，按照下面方法转换数据
    // 怎么转换，是由开发者在方法中重写
    @Override
    public String convertToJavaData(ReadConverterContext<?> context) throws Exception {
        String oldValue = context.getReadCellData().getStringValue();
        System.out.println(oldValue);
        return "大神：" + oldValue; // 原本的数据
    }

    // 当写的到数据符合类型，封装的字段也符合类型，按照下面方法转换数据
    // 怎么转换，是由开发者在方法中重写
    @Override
    public WriteCellData<?> convertToExcelData(WriteConverterContext<String> context) throws Exception {
        System.out.println("写入的数据：" + context.getValue());
        return new WriteCellData<>("大神：" + context.getValue());
    }
}
