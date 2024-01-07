package com.example.design.patterns.StrategyPattern.factory;

import com.example.design.patterns.StrategyPattern.po.LeaveForm;
import com.example.design.patterns.StrategyPattern.strategy.LeaveAuditStrategy;
import lombok.extern.java.Log;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * LeaveAuditStrategyFactory
 * <p>
 * 请假审批策略工厂
 *
 * @author Panbo
 * @create_time 2024/1/7 21:10
 */
@Log
@Component
public class LeaveAuditStrategyFactory {


    /**
     * 创建唯一的策略实例
     */
    private static final LeaveAuditStrategyFactory INSTANCE = new LeaveAuditStrategyFactory();
    /**
     * 策略集合
     */
    private final List<LeaveAuditStrategy> strategyList = new ArrayList<>();

    @Resource
    private ApplicationContext applicationContext;

    /**
     * 私有化构造函数
     */
    private LeaveAuditStrategyFactory() {
        this.strategyList.addAll(applicationContext.getBeansOfType(LeaveAuditStrategy.class).values());
    }

    /**
     * 获取策略工厂实例
     */
    public static LeaveAuditStrategyFactory getInstance() {
        return INSTANCE;
    }

    /**
     * 获取策略
     */
    public LeaveAuditStrategy getStrategy(LeaveForm form) {
        return strategyList.stream()
                .filter(strategy -> strategy.isSupport(form))
                .max(Comparator.comparingInt(LeaveAuditStrategy::getPriority))
                .map(strategy -> {
                    log.info("当前审批策略：" + strategy.getStrategyName());
                    return strategy;
                })
                .orElseThrow(() -> new RuntimeException("没有找到合适的策略"));
    }
}
