package ru.skillbox;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Elevator elevator = new Elevator(-20, 26); //вдруг это корпорация Амбрелла))

        while (true) {
            System.out.print("Введите номер этажа: ");
            int floor = new Scanner(System.in).nextInt();
            elevator.move(floor);

        }
    }
}
