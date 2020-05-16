package homework;

import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class shape {
    public double area(int length) {
        return 0;
    }
}

class square extends shape {
    public double area(int length) {
        return length * length;
    }
}

class circle extends shape {
    public double area(int length) {
        return length * length * 3.14;
    }
}

public class RTTI {
    //调用面积计算函数
    //不使用向上转型.
    public static void area(square square) {
        square.area(4);
    }

    public static void area(circle circle) {
        circle.area(4);
    }

    //使用向上转型
    public static void area(shape shape) {
        System.out.println(shape.area(3));
    }

    public static void main(String[] args) {
        //上面两种情况是分开测试的.不要过多关注测试类
        RTTI.area(new circle());
        RTTI.area(new square());
    }
}
class shapes{
    public static void main(String[] args) {
        List<shape> list= Arrays.asList(new circle(),new square());//circle和square是shapes得子类.其中都有一个area方法,具体的代码在下一个例子中
        for (shape s: list) {
            System.out.println(s.area(3));
        }
    }
}