package homework;

public class staticTest {
    public static void main(String[] args) throws ClassNotFoundException {
        System.out.println("开始执行");
        new square1();
        System.out.println(shape1.num);
        new shape1();
        System.out.println("shape加载完毕");
        Class.forName("homework.circle1");

    }
}

class shape1 {
    static int num=2;
    static {
        System.out.println("shape loaging");
    }
}

class square1 extends shape1 {
    static {
        System.out.println("square loaging");
    }
}

class circle1 extends shape1 {
    static {
        System.out.println("Circle loaging");
    }
}
