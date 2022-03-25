package cn.muzaijian.designpattern.creational.abstractfactory.shape.impl;

import cn.muzaijian.designpattern.creational.abstractfactory.shape.Shape;

/**
 * 圆形
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Circle");
    }
}
