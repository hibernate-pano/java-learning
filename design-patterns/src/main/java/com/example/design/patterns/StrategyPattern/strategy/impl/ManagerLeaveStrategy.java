package com.example.design.patterns.StrategyPattern.strategy.impl;

import com.example.design.patterns.StrategyPattern.po.LeaveForm;
import com.example.design.patterns.StrategyPattern.strategy.LeaveAuditStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * ManagerLeaveStrategy
 * <p>
 * 经理审批策略
 *
 * @author Panbo
 * @create_time 2024/1/7 21:06
 */
@Slf4j
@Component
public class ManagerLeaveStrategy implements LeaveAuditStrategy {

    @Override
    public boolean isSupport(LeaveForm form) {
        return form.getEmployee().getEmployeeLevel() == 9;
    }

    @Override
    public void audit(LeaveForm form) {
        log.info("经理审批策略：经理请假无需审批");
    }

    @Override
    public int getPriority() {
        // 优先级，数字越小优先级越低
        return 999;
    }

    @Override
    public String getStrategyName() {
        return "经理审批策略";
    }
}
