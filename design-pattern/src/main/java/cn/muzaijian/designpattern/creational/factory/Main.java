package cn.muzaijian.designpattern.creational.factory;

import cn.muzaijian.designpattern.creational.factory.factory.ShapeFactory;

import java.util.HashMap;

/**
 * 工厂模式
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class Main {
    public static void main(String[] args) {

        ShapeFactory shapeFactory = new ShapeFactory();

        // get an object of Circle and call its draw method.
        shapeFactory.getShape("CIRCLE").draw();

        // get an object of Rectangle and call its draw method.
        shapeFactory.getShape("RECTANGLE").draw();

        // get an object of Square and call its draw method.
        shapeFactory.getShape("SQUARE").draw();

    }
}
