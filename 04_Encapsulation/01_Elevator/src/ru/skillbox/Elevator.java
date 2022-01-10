package ru.skillbox;

public class Elevator {
    private int currentFloor = 1;
    private int minFloor;
    private int maxFloor;

    public Elevator(int minFloor, int maxFloor) {
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void moveDown() {
        //с учетом того, что нет понятие 0-го этажа
        if (currentFloor > minFloor) {
            if (currentFloor == 1) {
                currentFloor = currentFloor - 2;
            } else {
                currentFloor = currentFloor - 1;
            }
        }
    }

    public void moveUp() {
        //с учетом того, что нет понятие 0-го этажа
        if (currentFloor < maxFloor) {
            if (currentFloor == -1) {
                currentFloor = currentFloor + 2;
            } else {
                currentFloor = currentFloor + 1;
            }
        }
    }

    public void move(int floor) {
        if (floor > maxFloor || floor < minFloor || floor == 0) {
            System.out.println("Неверно задан этаж! Лифт на " + getCurrentFloor() + " этаже");
            return;
        }
        if (floor == currentFloor) {
            System.out.println("Нажмите кнопку, вы находитесь на " + getCurrentFloor() + " этаже");
            return;
        }
        if (floor < currentFloor) {
            int iFloor = currentFloor;
            if (floor < 0 && currentFloor > 0) {
                for (int i = floor; i < iFloor - 1; i = i + 1) {
                    moveDown();
                    System.out.println(getCurrentFloor() + "-й этаж");
                }
            } else {
                for (int i = floor; i < iFloor; i = i + 1) {
                    moveDown();
                    System.out.println(getCurrentFloor() + "-й этаж");
                }
            }
        }
        if (floor > currentFloor) {
            int iFloor = currentFloor;
            if (floor > 0 && currentFloor < 0) {
                for (int i = floor; i > iFloor + 1; i = i - 1) {
                    moveUp();
                    System.out.println(getCurrentFloor() + "-й этаж");
                }
            } else {
                for (int i = floor; i > iFloor; i = i - 1) {
                    moveUp();
                    System.out.println(getCurrentFloor() + "-й этаж");
                }
            }
        }
    }

}
