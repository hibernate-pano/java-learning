package com.example.design.patterns.DecoratorPattern.concrete_component;

import com.example.design.patterns.DecoratorPattern.component.Coffee;

/**
 * 具体组件 - 纯咖啡
 * 给出默认值
 *
 * @author pano
 * @date 2024/1/2
 **/
public class SimpleCoffee extends Coffee {

    /**
     * 构造方法
     * 默认咖啡 10 元
     */
    public SimpleCoffee() {
        this.price = 10;
    }

    /**
     * 获取价格的抽象接口，后面的具体咖啡类会实现这个接口
     *
     * @return 价格
     */
    @Override
    public double getPrice() {
        return price;
    }
}
