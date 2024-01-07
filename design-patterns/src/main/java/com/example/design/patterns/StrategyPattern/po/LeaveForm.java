package com.example.design.patterns.StrategyPattern.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * LeaveForm  请假单
 *
 * @author Panbo
 * @create_time 2024/1/7 20:24
 */
@Data
@AllArgsConstructor
public class LeaveForm {

    /**
     * 请假单Id
     */
    private Long leaveFormId;
    /**
     * 请假员工
     */
    private Employee employee;
    /**
     * 请假天数
     */
    private Integer leaveDays;
    /**
     * 请假原因
     */
    private String leaveReason;
    /**
     * 请假类型
     */
    private Integer leaveType;
}
