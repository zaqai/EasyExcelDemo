package com.zaqai.EasyExcelDemo.mock;



import com.zaqai.EasyExcelDemo.data.PlayerData;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class PlayerMock {
    public static List<PlayerData> data() {
        return Arrays.asList(
                new PlayerData("C罗", new Date(), new BigDecimal("0.07")),
                new PlayerData("乔丹", new Date(), new BigDecimal("0.03"))
        );
    }
}
