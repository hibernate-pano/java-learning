package com.example.design.patterns.StrategyPattern.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * LeaveTypeEnum
 * 请假类型枚举
 *
 * @author Panbo
 * @create_time 2024/1/7 20:25
 */
@Getter
@AllArgsConstructor
public enum LeaveTypeEnum {

    /**
     * 请假类型枚举
     * 1.事假
     * 2.病假
     * 3.年假
     * 4.婚假
     * 5.产假
     * 6.丧假
     **/
    PERSONAL_LEAVE(1, "事假"),
    SICK_LEAVE(2, "病假"),
    ANNUAL_LEAVE(3, "年假"),
    MARRIAGE_LEAVE(4, "婚假"),
    MATERNITY_LEAVE(5, "产假"),
    FUNERAL_LEAVE(6, "丧假");

    /**
     * 请假类型
     */
    private final Integer leaveType;
    /**
     * 请假类型描述
     */
    private final String leaveTypeDesc;
}
