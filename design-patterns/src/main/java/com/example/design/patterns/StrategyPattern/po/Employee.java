package com.example.design.patterns.StrategyPattern.po;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * Employee   员工表
 *
 * @author Panbo
 * @create_time 2024/1/7 20:22
 */

@Data
@AllArgsConstructor
public class Employee {

    /**
     * 员工Id
     */
    private Long employeeId;

    /**
     * 员工姓名
     */
    private String employeeName;

    /**
     * 员工级别
     */
    private Integer employeeLevel;

}
