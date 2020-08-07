package com.fengfang.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Description TODO
 * @Author liuxh
 * @Date 2020/8/6 11:02
 **/
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class UserInfo {
    private int id;
    private int userId;
    private double aviAmount;

}
