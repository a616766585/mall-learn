package cn.muzaijian.designpattern.creational.abstractfactory.factory;

import cn.muzaijian.designpattern.creational.abstractfactory.abstractfactory.AbstractFactory;
import cn.muzaijian.designpattern.creational.abstractfactory.color.Color;
import cn.muzaijian.designpattern.creational.abstractfactory.shape.Shape;
import cn.muzaijian.designpattern.creational.abstractfactory.shape.impl.Circle;
import cn.muzaijian.designpattern.creational.abstractfactory.shape.impl.Rectangle;
import cn.muzaijian.designpattern.creational.abstractfactory.shape.impl.Square;

/**
 * 形状工厂
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class ShapeFactory extends AbstractFactory {

    @Override
    public Color getColor(String colorName) {
        return null;
    }

    /**
     * 获取形状
     *
     * @param shapeName 形状名称
     * @return 形状
     */
    @Override
    public Shape getShape(String shapeName) {
        if (shapeName == null) {
            return null;
        }
        if (shapeName.equalsIgnoreCase("CIRCLE")) {
            return new Circle();
        } else if (shapeName.equalsIgnoreCase("RECTANGLE")) {
            return new Rectangle();
        } else if (shapeName.equalsIgnoreCase("SQUARE")) {
            return new Square();
        }
        return null;
    }
}
