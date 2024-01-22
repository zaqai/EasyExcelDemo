package com.zaqai.EasyExcelDemo.mock;



import com.zaqai.EasyExcelDemo.data.PersonData;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

// 提供数据的类
public class PersonMock {

    public static List<PersonData> data() {
        return Arrays.asList(
            new PersonData(1L, new Date(), "刘备"),
            new PersonData(2L, new Date(), "关羽"),
            new PersonData(3L, new Date(), "张飞"),
            new PersonData(4L, new Date(), "赵云"),
            new PersonData(5L, new Date(), "诸葛亮"),
            new PersonData(6L, new Date(), "黄忠"),
            new PersonData(7L, new Date(), "魏延"),
            new PersonData(8L, new Date(), "庞统"),
            new PersonData(9L, new Date(), "法正"),
            new PersonData(10L, new Date(), "黄权")
        );
    }
}
