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
    //����������㺯��
    //��ʹ������ת��.
    public static void area(square square) {
        square.area(4);
    }

    public static void area(circle circle) {
        circle.area(4);
    }

    //ʹ������ת��
    public static void area(shape shape) {
        System.out.println(shape.area(3));
    }

    public static void main(String[] args) {
        //������������Ƿֿ����Ե�.��Ҫ�����ע������
        RTTI.area(new circle());
        RTTI.area(new square());
    }
}
class shapes{
    public static void main(String[] args) {
        List<shape> list= Arrays.asList(new circle(),new square());//circle��square��shapes������.���ж���һ��area����,����Ĵ�������һ��������
        for (shape s: list) {
            System.out.println(s.area(3));
        }
    }
}