package ru.skillbox;

public class Computer {
    private final String vendor;
    private final String name;

    public CPU cpu;
    public RAM ram;
    public HardDisk hardDisk;
    public Monitor monitor;
    public Keyboard keyboard;

    public Computer(String vendor, String name, CPU cpu, RAM ram, HardDisk hardDisk, Monitor monitor, Keyboard keyboard) {
        this.vendor = vendor;
        this.name = name;
        this.cpu = cpu;
        this.ram = ram;
        this.hardDisk = hardDisk;
        this.monitor = monitor;
        this.keyboard = keyboard;

    }

    public double sumWeightComp() {
        return cpu.getWeight() + ram.getWeight() + hardDisk.getWeight() + monitor.getWeight() + keyboard.getWeight();
    }

    public String toString() {
        return "Компьютер " + vendor + "\n" +
                "Имя " + name + "\n" +
                "Процессор: частота " + cpu.getFrequency() + ", количество ядер " + cpu.getNumberOfCores() + ",  производитель " + cpu.getManufacturer() + ", вес " + cpu.getWeight() + "\n" +
                "Оперативная память: тип " + ram.getTypeRAM() + ", объём " + ram.getVolume() + ", вес " + ram.getWeight() + "\n" +
                "Жёсткий диск: тип " + hardDisk.getTypeHardDisk() + ", объём памяти " + hardDisk.getMemory() + "Гб , вес " + hardDisk.getWeight() + "\n" +
                "Экран: диагональ " + monitor.getDiagonal() + ", тип " + monitor.getTypeMonitor() + ", вес " + monitor.getWeight() + "\n" +
                "Клавиатура: тип " + keyboard.getTypeKeyboard() + ", наличие подсветки " + (keyboard.isBacklight() ? "- есть" : "- нет") + ", вес " + keyboard.getWeight();
    }


    public CPU getCpu() {
        return cpu;
    }

    public RAM getRam() {
        return ram;
    }

    public HardDisk getHardDisk() {
        return hardDisk;
    }

    public Monitor getMonitor() {
        return monitor;
    }

    public Keyboard getKeyboard() {
        return keyboard;
    }

    public String getVendor() {
        return vendor;
    }

    public String getName() {
        return name;
    }

    public void setCpu(CPU cpu) {
        this.cpu = cpu;
    }

    public void setRam(RAM ram) {
        this.ram = ram;
    }

    public void setHardDisk(HardDisk hardDisk) {
        this.hardDisk = hardDisk;
    }

    public void setMonitor(Monitor monitor) {
        this.monitor = monitor;
    }

    public void setKeyboard(Keyboard keyboard) {
        this.keyboard = keyboard;
    }
}
