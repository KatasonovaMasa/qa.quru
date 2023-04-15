package tests.countTest;


public class Solution {

    public static void main(String[] args) {
        Cat cat1 = new Cat();
        //напишите тут ваш код
        cat1.count(3);

        Cat cat2 = new Cat();
        //напишите тут ваш код
        cat2.count(5);

        System.out.println("Cats count is " + Cat.count);
    }

    public static class Cat {
        public static int count = 0;

        public static void count(int count) {
            Cat.count = Cat.count + count;
        }

    }
}

