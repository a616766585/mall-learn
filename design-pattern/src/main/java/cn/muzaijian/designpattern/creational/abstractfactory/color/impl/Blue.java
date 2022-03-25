package cn.muzaijian.designpattern.creational.abstractfactory.color.impl;

import cn.muzaijian.designpattern.creational.abstractfactory.color.Color;

/**
 * 蓝色
 *
 * @author muzaijian
 * @since 2022-3-18
 */
public class Blue implements Color {

  @Override
  public void fill() {
    System.out.println("Blue");
  }
}
