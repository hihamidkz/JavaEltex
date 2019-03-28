package ru.eltex;

import java.lang.reflect.Field;

public class Application {
    public static void main(String[] args) {
        Class cl1 = PhysUser.class;
        Class cl2 = UrUser.class;
        System.out.println(cl1.getName());
        System.out.println(cl2.getName());

        Field[] fields1 = cl1.getDeclaredFields();
        Field[] fields2 = cl2.getDeclaredFields();

        System.out.println("PhysUser fields:");
        for (Field f : fields1) {
            System.out.println(f.getType() + " " + f.getName());
        }

        System.out.println("UrUser fields:");
        for (Field f : fields2) {
            System.out.println(f.getType() + " " + f.getName());
        }
    }
}
