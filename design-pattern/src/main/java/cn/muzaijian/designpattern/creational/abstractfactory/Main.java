package cn.muzaijian.designpattern.creational.abstractfactory;

import cn.muzaijian.designpattern.creational.abstractfactory.abstractfactory.AbstractFactory;
import cn.muzaijian.designpattern.creational.abstractfactory.producer.FactoryProducer;

import java.util.Objects;

/**
 * 抽象工厂模式
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class Main {
    public static void main(String[] args) {

        // 创建一个形状工厂
        AbstractFactory shapeFactory = FactoryProducer.getFactory("shape");

        // get an object of Circle and call its draw method.
        Objects.requireNonNull(shapeFactory).getShape("circle").draw();

        // 创建一个形状工厂
        AbstractFactory colorFactory = FactoryProducer.getFactory("color");

        // get an object of Red and call its fill method.
        Objects.requireNonNull(colorFactory).getColor("red").fill();
    }
}
