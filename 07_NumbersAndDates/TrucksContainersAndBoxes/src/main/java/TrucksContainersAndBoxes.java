package main.java;

public class TrucksContainersAndBoxes {
    private int boxes;


    public TrucksContainersAndBoxes(String boxes) {
        this.boxes = Integer.parseInt(boxes);
    }

    public void calculateContainersAndBoxes() {
        int numberOfContainers = boxes / 27;
        int numberBoxesOutContainers = boxes % 27;

        if (numberBoxesOutContainers != 0) {
            ++numberOfContainers;
        }
        int allContainers = numberOfContainers;
        int numberOfTrucks = numberOfContainers / 12;
        int numberContainersOutTrucks = numberOfContainers % 12;

        if (numberContainersOutTrucks != 0) {
            ++numberOfTrucks;
        }
        int allBoxes = boxes;
        for (int i = 1; i <= numberOfTrucks; i++) {
            System.out.println("Грузовик: " + i);
            if (numberOfContainers >= 12) {
                for (int j = 1; j <= 12; ++j) {
                    numberOfContainers = numberOfContainers - 1;
                    System.out.println("\t" + "Контейнер: " + (allContainers - numberOfContainers));
                    if (boxes >= 27) {
                        for (int k = 1; k <= 27; ++k) {
                            boxes = boxes - 1;
                            System.out.println("\t" + "\t" + "Ящик: " + (allBoxes - boxes));


                        }
                    } else {
                        int countBox = boxes;
                        for (int k = 1; k <= countBox; ++k) {
                            boxes = boxes - 1;
                            System.out.println("\t" + "\t" + "Ящик: " + (allBoxes - boxes));

                        }
                    }
                }
            } else {
                int n = numberOfContainers;
                for (int j = 1; j <= n; ++j) {
                    numberOfContainers = numberOfContainers - 1;
                    System.out.println("\t" + "Контейнер: " + (allContainers - numberOfContainers));
                    if (boxes >= 27) {
                        for (int k = 1; k <= 27; ++k) {
                            boxes = boxes - 1;
                            System.out.println("\t" + "\t" + "Ящик: " + (allBoxes - boxes));

                        }
                    } else {
                        int countBox = boxes;
                        for (int k = 1; k <= countBox; ++k) {
                            boxes = boxes - 1;
                            System.out.println("\t" + "\t" + "Ящик: " + (allBoxes - boxes));

                        }
                    }

                }
            }


        }
        System.out.print("Необходимо:" + System.lineSeparator() +
                "грузовиков - " + numberOfTrucks + " шт." + System.lineSeparator() +
                "контейнеров - " + allContainers + " шт.");


    }


}

