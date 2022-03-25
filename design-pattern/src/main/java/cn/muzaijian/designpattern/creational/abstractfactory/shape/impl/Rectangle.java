package cn.muzaijian.designpattern.creational.abstractfactory.shape.impl;

import cn.muzaijian.designpattern.creational.abstractfactory.shape.Shape;

/**
 * 长方形
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Rectangle");
    }
}
