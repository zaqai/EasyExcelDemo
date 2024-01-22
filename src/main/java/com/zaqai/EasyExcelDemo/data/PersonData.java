package com.zaqai.EasyExcelDemo.data;

import com.alibaba.excel.annotation.ExcelIgnore;
import lombok.Data;

import java.util.Date;

@Data
public class PersonData {
    private Long id;
    private String name;
    private Date birthday;

    @ExcelIgnore
    private String ignore;

    public PersonData() {
    }

    public PersonData(Long id, Date birthday, String name) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
}
