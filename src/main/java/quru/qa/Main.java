package quru.qa;

import java.util.ArrayList;
import java.util.List;


public class Main {
    public static void main(String[] args) {

        int a = 10;
        int b = 7;
        int c = a + b;
        int d = 4 + b;
        int e = a - b;
        int f = 4 - a;
        int q = a * b;
        int z = b * 5;
        int w = a / b;
        double s = 22.5 / 4.5;
        double k = 10 / 4;
        double x = 10.0 / 4;
        int r = a % b;  // 3
        int v = 22 % 4;
        a += 10;        // 15
        a -= 3;         // 12
        a *= 2;         // 24
        a /= 6;         // 4
        a <<= 4;      // 64
        a >>= 2;
        int t = 5;
        int y = 7;
        boolean g = t < y;

        boolean expression1 = 3 < 2;
        boolean expression2 = 5 > 4;

        if (expression1) {
            System.out.println("Первое выражение правдивое.");
        } else {
            if (expression2) {
                System.out.println("Первое выражение ложное, а второе — правдивое.");
            } else {
                System.out.println("Оба выражения ложные.");
            }
        }



        // Целочисленные типы данных
        byte aByte = 0; // -128 ... 127 (8 bit)
        aByte = (byte) (aByte + 1);

        short aShort = 0; // -32768 ... 32767 (16 bit)


        int aInt = 0; // 32 bit  2^(bit-1)
        long aLong = 0; // 64 bit

        // Типы данных с плавающей точкой
        float aFloat = 0F; // 32 bit

        double aDouble = 0D; // 64 bit
        char aChar = '0';

        // Операторы
        // 1. Присвоение
        char bChar = 'a';
        // 2. Математические + - * / %
        int result = 5 / 2;
        System.out.println("### result: " + result);
        // 3. Операторы сравнения >, <, >=, <=, !=, ==
        System.out.println("### boolean result: " + (3 == 3));

        String sd = "this is a String";
        List<Integer> aList = new ArrayList<>();

        if (methodOne() | methodAnother()) {
            System.out.println("");
        }
        int value = (methodOne())
                ? 10
                : 20;


        System.out.println("### Value: " + value);
        System.out.println("Hello world!");

        Integer aIntegerWrapper;// int
        Double aDoubleWrapper;
        Character aCharWrapper; // char

        switch (sd) {
            case "dima": {
                System.out.println("Thats Dima");
                break;
            }
            case "vasya": {
                System.out.println("Thats Vasya");
            }
            default: {
                System.out.println("Default");
            }
        }

        if (sd.equals("dima")) {
            System.out.println("Thats Dima");
        } else if (sd.equals("vasya")) {
            System.out.println("Thats Vasya");
        } else {
            System.out.println("Default");
        }
    }

    public static boolean methodOne() {
        System.out.println("methodOne");
        return false;
    }
    public static boolean methodAnother() {
        System.out.println("methodAnother");
        return true;
    }

    public static void printInt(int arg) {
        System.out.println("### printInt: " + arg);
    }
}
