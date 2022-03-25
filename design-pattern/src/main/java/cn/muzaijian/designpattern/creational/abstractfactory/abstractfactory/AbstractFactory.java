package cn.muzaijian.designpattern.creational.abstractfactory.abstractfactory;

import cn.muzaijian.designpattern.creational.abstractfactory.color.Color;
import cn.muzaijian.designpattern.creational.abstractfactory.shape.Shape;

/**
 * 抽象工厂
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public abstract class AbstractFactory {

    /**
     * 获取颜色
     *
     * @param colorName 颜色名称
     * @return 颜色
     */
    public abstract Color getColor(String colorName);

    /**
     * 获取形状
     *
     * @param shapeName 形状名称
     * @return 形状
     */
    public abstract Shape getShape(String shapeName);
}
