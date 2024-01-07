package com.example.design.patterns.StrategyPattern.strategy;

import com.example.design.patterns.StrategyPattern.po.LeaveForm;

/**
 * LeaveAuditStrategy
 * <p>
 * 员工请假审批策略接口
 *
 * @author Panbo
 * @create_time 2024/1/7 20:30
 */
public interface LeaveAuditStrategy {


    /**
     * 策略是否匹配
     */
    boolean isSupport(LeaveForm form);

    /**
     * 审核业务逻辑
     */
    void audit(LeaveForm form);

    /**
     * 规则冲突的时候的优先级
     */
    int getPriority();

    /**
     * 规则名称
     */
    String getStrategyName();

}
