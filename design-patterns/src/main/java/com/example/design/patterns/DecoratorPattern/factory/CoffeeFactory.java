package com.example.design.patterns.DecoratorPattern.factory;

import com.example.design.patterns.DecoratorPattern.CoffeeOrderOptions;
import com.example.design.patterns.DecoratorPattern.component.Coffee;
import com.example.design.patterns.DecoratorPattern.concrete_component.SimpleCoffee;
import com.example.design.patterns.DecoratorPattern.decorator.CoffeeDecorator;
import com.example.design.patterns.DecoratorPattern.enums.CoffeeOrderOptionEnum;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author pano
 * @date 2024/1/2
 **/
@Component
@Slf4j
public class CoffeeFactory {

    public static Coffee makeCoffee(CoffeeOrderOptions options) {

        // 1. 选择咖啡豆
        Coffee coffee = new SimpleCoffee();

        // 2. 选择调料
        for (String option : options.getOptions()) {
            // 从枚举中匹配，如果匹配上则实例化对应的装饰器 class 并叠加价格
            for (CoffeeOrderOptionEnum value : CoffeeOrderOptionEnum.values()) {
                if (value.name().equals(option)) {
                    try {
                        coffee = (CoffeeDecorator) Class.forName(value.getDecoratorClassName()).getConstructor(Coffee.class).newInstance(coffee);
                    } catch (Exception e) {
                        log.error("makeCoffee error = {}", e.getMessage());
                    }
                }
            }
        }
        return coffee;
    }
}
