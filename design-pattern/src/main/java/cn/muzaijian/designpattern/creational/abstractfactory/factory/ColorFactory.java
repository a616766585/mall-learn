package cn.muzaijian.designpattern.creational.abstractfactory.factory;

import cn.muzaijian.designpattern.creational.abstractfactory.abstractfactory.AbstractFactory;
import cn.muzaijian.designpattern.creational.abstractfactory.color.Color;
import cn.muzaijian.designpattern.creational.abstractfactory.color.impl.Blue;
import cn.muzaijian.designpattern.creational.abstractfactory.color.impl.Green;
import cn.muzaijian.designpattern.creational.abstractfactory.color.impl.Red;
import cn.muzaijian.designpattern.creational.abstractfactory.shape.Shape;

/**
 * 颜色工厂
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class ColorFactory extends AbstractFactory {
    @Override
    public Color getColor(String colorName) {
        if (colorName == null) {
            return null;
        }
        if (colorName.equalsIgnoreCase("RED")) {
            return new Red();
        } else if (colorName.equalsIgnoreCase("GREEN")) {
            return new Green();
        } else if (colorName.equalsIgnoreCase("BLUE")) {
            return new Blue();
        }
        return null;
    }

    @Override
    public Shape getShape(String shapeName) {
        return null;
    }
}
