package cn.muzaijian.designpattern.creational.factory.shape.impl;

import cn.muzaijian.designpattern.creational.factory.shape.Shape;

/**
 * 正方形
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("Square");
    }
}
