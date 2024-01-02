package com.example.design.patterns.DecoratorPattern.component;

import org.springframework.stereotype.Component;

/**
 * 抽象组件 - coffee 类
 *
 * @author pano
 * @date 2024/1/2
 **/
@Component(value = "coffee")
public abstract class Coffee {

    /**
     * 价格属性
     */
    protected double price;

    /**
     * 获取价格的抽象接口，后面的具体咖啡类会实现这个接口
     *
     * @return 价格
     */
    public abstract double getPrice();
}
