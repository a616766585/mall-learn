package cn.muzaijian.designpattern.creational.factory.factory;

import cn.muzaijian.designpattern.creational.factory.shape.Shape;
import cn.muzaijian.designpattern.creational.factory.shape.impl.Rectangle;
import cn.muzaijian.designpattern.creational.factory.shape.impl.Square;
import cn.muzaijian.designpattern.creational.factory.shape.impl.Circle;

/**
 * 形状工厂
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class ShapeFactory {

    /**
     * 获取形状
     *
     * @param shapeName 形状名称
     * @return 形状
     */
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
