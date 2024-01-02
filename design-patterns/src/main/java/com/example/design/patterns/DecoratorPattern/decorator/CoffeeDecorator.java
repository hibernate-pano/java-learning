package com.example.design.patterns.DecoratorPattern.decorator;

import com.example.design.patterns.DecoratorPattern.component.Coffee;

/**
 * 装饰者抽象类
 *
 * @author pano
 * @date 2024/1/2
 **/
public abstract class CoffeeDecorator extends Coffee {

    /**
     * 被装饰的对象
     */
    protected Coffee coffee;

    /**
     * 构造方法
     *
     * @param coffee 被装饰的对象
     */
    public CoffeeDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    /**
     * 获取价格的抽象接口，后面的具体咖啡类会实现这个接口
     *
     * @return 价格
     */
    @Override
    public double getPrice() {
        return coffee.getPrice();
    }
}
