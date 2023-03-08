package utils;

import com.github.javafaker.Faker;

import java.security.SecureRandom;
import java.util.concurrent.ThreadLocalRandom;

public class RandomUtils {

    public static String[] genders = {"Male", "Female", "Other"},
            hobbiess = {"Reading", "Sports", "Music"},
            subjects = {"Accounting", "Maths", "Arts", "English", "Physics", "Chemistry", "Computer Science", "Economics", "Social Studies", "History", "Civics", "Commerce", "Hindi", "Biology"},
            citys = {"Delhi", "Gurgaon", "Noida"};

    public static String getRandomItemFromArray(String[] values) {
        int index = getRandomInt(0, values.length - 1);

        return values[index];
    }

    public static String getRandomName() {
        return new Faker().name().firstName();
    }

    public static void main(String[] args) {
        System.out.println(getRandomString(10));
        System.out.println(getRandomInt(10, 100));
        System.out.println(getRandomEmail());

        String[] names = {"a", "b", "c", "d", "e"};
      //  System.out.println(getRandomItemFromArray(names));
    }

    public static int getRandomInt(int min, int max) {
        return ThreadLocalRandom.current().nextInt(min, max + 1);
    }

    public static String getRandomString(int length) {
//        String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

        SecureRandom rnd = new SecureRandom();
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++)
            sb.append(AB.charAt(rnd.nextInt(AB.length())));
        return sb.toString();
    }

    public static String getRandomEmail() {
        return getRandomString(10) + "@qa.guru";
    }


}
