package cn.muzaijian.designpattern.creational.abstractfactory.producer;

import cn.muzaijian.designpattern.creational.abstractfactory.abstractfactory.AbstractFactory;
import cn.muzaijian.designpattern.creational.abstractfactory.factory.ColorFactory;
import cn.muzaijian.designpattern.creational.abstractfactory.factory.ShapeFactory;

/**
 * 工厂创造器
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class FactoryProducer {
    public static AbstractFactory getFactory(String factoryName) {
        if (factoryName.equalsIgnoreCase("shape")) {
            return new ShapeFactory();
        } else if (factoryName.equalsIgnoreCase("color")) {
            return new ColorFactory();
        }
        return null;
    }
}
