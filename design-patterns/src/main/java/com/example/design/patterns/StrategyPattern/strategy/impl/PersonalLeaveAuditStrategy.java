package com.example.design.patterns.StrategyPattern.strategy.impl;

import com.example.design.patterns.StrategyPattern.enums.LeaveTypeEnum;
import com.example.design.patterns.StrategyPattern.po.LeaveForm;
import com.example.design.patterns.StrategyPattern.strategy.LeaveAuditStrategy;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * PersonalLeaveAuditStrategy
 * <p>
 * 个人请假审批策略
 *
 * @author Panbo
 * @create_time 2024/1/7 20:59
 */
@Slf4j
@Component
public class PersonalLeaveAuditStrategy implements LeaveAuditStrategy {

    @Override
    public boolean isSupport(LeaveForm form) {
        // 个人请假
        assert form.getLeaveType().equals(LeaveTypeEnum.PERSONAL_LEAVE.getLeaveType());
        return form.getLeaveDays() <= 3 && form.getLeaveType() == 1;
    }

    @Override
    public void audit(LeaveForm form) {
        log.info("个人请假审批策略");
    }

    @Override
    public int getPriority() {
        return 0;
    }

    @Override
    public String getStrategyName() {
        return "三天以内的个人请假审批策略";
    }
}
