package com.example.design.patterns.DecoratorPattern;

import com.example.design.patterns.DecoratorPattern.component.Coffee;
import com.example.design.patterns.DecoratorPattern.factory.CoffeeFactory;
import org.springframework.stereotype.Component;

/**
 * 具体执行 - 咖啡店
 *
 * @author pano
 * @date 2024/1/2
 **/
@Component
public class CoffeeShop {


    // public static void main(String[] args) {
    //     /*
    //       来一杯加牛奶加糖浆的咖啡
    //      */
    //     Coffee coffee = new SimpleCoffee();
    //     coffee = new MilkDecorator(coffee);
    //     coffee = new SyrupDecorator(coffee);
    //     System.out.println(coffee.getPrice());
    // }

    /**
     * 上述方法中的创建对象可以使用工厂类优化
     */
    public static void main(String[] args) {

        CoffeeOrderOptions orderOptions = new CoffeeOrderOptions();
        orderOptions.setOptions(new String[]{"MILK", "SYRUP"});

        Coffee coffee = CoffeeFactory.makeCoffee(orderOptions);

        System.out.println(coffee.getPrice());
    }
}
