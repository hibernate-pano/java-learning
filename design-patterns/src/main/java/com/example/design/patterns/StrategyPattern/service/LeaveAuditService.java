package com.example.design.patterns.StrategyPattern.service;

import com.example.design.patterns.StrategyPattern.factory.LeaveAuditStrategyFactory;
import com.example.design.patterns.StrategyPattern.po.LeaveForm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * LeaveAuditService
 *
 * @author Panbo
 * @create_time 2024/1/7 21:09
 */
@Slf4j
@Service
public class LeaveAuditService {

    /**
     * 审核流程
     */
    public void audit(LeaveForm form) {
        LeaveAuditStrategyFactory factory = LeaveAuditStrategyFactory.getInstance();
        try {
            // 获取策略并执行
            factory.getStrategy(form).audit(form);
        } catch (Exception e) {
            log.error("请假审批失败，错误信息 =[{}]", e.getMessage());
        }
    }
}
