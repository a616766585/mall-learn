package cn.muzaijian.designpattern.creational.singleton;

/**
 * 单例模式
 *
 * @author muzaijian
 * @since 2022-3-23
 */
public class SingleObject {

    private volatile static SingleObject instance;

    private SingleObject() {
    }

    public static SingleObject getInstance() {
        synchronized (SingleObject.class) {
            if (instance == null) {
                instance = new SingleObject();
            }
        }
        return instance;
    }
}
