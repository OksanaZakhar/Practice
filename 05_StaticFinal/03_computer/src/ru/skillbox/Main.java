package ru.skillbox;

public class Main {

    public static void main(String[] args) {
        CPU cpu = new CPU(4.2, 4, "ASUS", 0.3);
        RAM ram = new RAM("IO2", 1024, 0.45);
        HardDisk hardDisk = new HardDisk(TypeHardDisk.SSD, 100, 0.7);
        Monitor monitor = new Monitor(19, TypeMonitor.VA, 2.7);
        Keyboard keyboard = new Keyboard("Logitec", true, 1.1);
        Computer computer = new Computer("ASUS", "Nitcet", cpu, ram, hardDisk, monitor, keyboard);

        System.out.println(computer);

        System.out.println("Общий вес компьютера " + computer.sumWeightComp() + "кг");


    }
}
