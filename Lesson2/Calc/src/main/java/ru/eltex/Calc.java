package ru.eltex;

import java.util.Scanner;

public class Calc {
    public static final void main(String[] args) {
        Scanner in = new Scanner(System.in);

        float a = 0;
        float b = 0;
        float c = 0;
        String op;

        System.out.println("Введите действие в формате 'число' 'операция' 'число'");

        if (in.hasNextFloat()) {
            a = in.nextFloat();
        } else {
            System.out.println("Вы ввели не число!");
            System.exit(0);
        }
        op = in.next();
        if (in.hasNextFloat()) {
            b = in.nextFloat();
        } else {
            System.out.println("Вы ввели не число!");
            System.exit(0);
        }

        switch (op) {
            case "+":
                c = a + b;
                break;
            case "-":
                c = a - b;
                break;
            case "*":
                c = a * b;
                break;
            case "/":
                c = a / b;
                break;
            default:
                System.out.println("Вы ввели неверный операнд");
                System.exit(0);
        }
        System.out.println(c);

    }
}
