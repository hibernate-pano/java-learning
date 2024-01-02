package com.example.design.patterns.DecoratorPattern.concrete_decorator;

import com.example.design.patterns.DecoratorPattern.component.Coffee;
import com.example.design.patterns.DecoratorPattern.decorator.CoffeeDecorator;
import com.example.design.patterns.DecoratorPattern.enums.CoffeeOrderOptionEnum;
import org.springframework.stereotype.Component;

/**
 * 具体装饰者 - 加牛奶
 *
 * @author pano
 * @date 2024/1/2
 **/
@Component
public class MilkDecorator extends CoffeeDecorator {

    // 牛奶价格，从枚举中获取
    private static final double MILK_PRICE = CoffeeOrderOptionEnum.MILK.getPrice();

    public MilkDecorator(Coffee coffee) {
        super(coffee);
    }

    /**
     * 获取价格的抽象接口，后面的具体咖啡类会实现这个接口
     *
     * @return 价格
     */
    @Override
    public double getPrice() {
        return super.getPrice() + MILK_PRICE;
    }
}
