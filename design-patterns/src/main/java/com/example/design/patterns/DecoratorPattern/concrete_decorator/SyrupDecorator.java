package com.example.design.patterns.DecoratorPattern.concrete_decorator;

import com.example.design.patterns.DecoratorPattern.component.Coffee;
import com.example.design.patterns.DecoratorPattern.decorator.CoffeeDecorator;
import com.example.design.patterns.DecoratorPattern.enums.CoffeeOrderOptionEnum;

/**
 * 具体装饰者 - 加糖浆
 *
 * @author pano
 * @date 2024/1/2
 **/
public class SyrupDecorator extends CoffeeDecorator {

    // 定义糖浆，从枚举中获取
    public static final double SYRUP_PRICE = CoffeeOrderOptionEnum.SYRUP.getPrice();

    public SyrupDecorator(Coffee coffee) {
        super(coffee);
    }

    /**
     * 获取价格的抽象接口，后面的具体咖啡类会实现这个接口
     *
     * @return 价格
     */
    @Override
    public double getPrice() {
        return super.getPrice() + SYRUP_PRICE;
    }
}
