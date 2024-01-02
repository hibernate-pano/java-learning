package com.example.design.patterns.DecoratorPattern.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 咖啡订单选项-枚举类
 *
 * @author pano
 * @date 2024/1/2
 **/
@Getter
@AllArgsConstructor
public enum CoffeeOrderOptionEnum {

    /**
     * 牛奶
     */
    MILK("牛奶", 10.0, "com.example.design.patterns.DecoratorPattern.concrete_decorator.MilkDecorator"),
    /**
     * 奶泡
     */
    MILK_FOAM("奶泡", 2.0, "com.example.design.patterns.DecoratorPattern.concrete_decorator.MilkDecorator"),
    /**
     * 糖浆
     */
    SYRUP("糖浆", 4.0, "com.example.design.patterns.DecoratorPattern.concrete_decorator.SyrupDecorator"),
    /**
     * 豆浆
     */
    SOY("豆浆", 5.0, "com.example.design.patterns.DecoratorPattern.concrete_decorator.SyrupDecorator"),
    /**
     * 奶油
     */
    WHIPPED_CREAM("奶油", 6.0, "com.example.design.patterns.DecoratorPattern.concrete_decorator.SyrupDecorator");

    /**
     * 选项名称
     */
    private final String name;

    /**
     * 选项价格
     */
    private final Double price;

    /**
     * 对应的装饰类
     */
    private final String decoratorClassName;
}
