package cn.muzaijian.javajvm.lambda;

public class LambdaInterfaceDemo {
    public static void main(String[] args) {
        lambdaInterfaceTest1(() -> System.out.println("hello world"));
    }

    public static void lambdaInterfaceTest1(LambdaInterface lambdaInterface) {
        lambdaInterface.test();
    }
}


