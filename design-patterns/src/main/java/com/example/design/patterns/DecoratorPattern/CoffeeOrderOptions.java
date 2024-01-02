package com.example.design.patterns.DecoratorPattern;

import lombok.Data;

/**
 * 咖啡订单选项
 *
 * @author pano
 * @date 2024/1/2
 **/
@Data
public class CoffeeOrderOptions {

    /**
     * 用户选择的参数集合
     */
    private String[] options;

}
