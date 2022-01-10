public class Hospital {

    public static float[] generatePatientsTemperatures(int patientsCount) {
        float[] temperature = new float[patientsCount];
        for (int i = 0; i < patientsCount; i++) {
            temperature[i] = Math.round((Math.random() * 8f + 32f) * 10f) / 10f;
            System.out.println(i + " " + temperature[i]);
        }
        //TODO: напишите метод генерации массива температур пациентов

        return temperature;
    }

    public static String getReport(float[] temperatureData) {
        /*
        TODO: Напишите код, который выводит среднюю температуру по больнице,количество здоровых пациентов,
            а также температуры всех пациентов.
        */
        String temperaturePeople = "";
        float sumTemperature = 0f;
        int healthyPeople = 0;
        for (int i = 0; i < temperatureData.length; i++) {
            temperaturePeople = temperaturePeople.concat(Float.toString(temperatureData[i])).concat(" ");
            sumTemperature = sumTemperature + temperatureData[i];
            if (35.5f < temperatureData[i] && temperatureData[i] < 37) {
                healthyPeople++;
            }

        }

        String report =
                "Температуры пациентов: " + temperaturePeople.trim() +
                        "\nСредняя температура: " + Math.round(sumTemperature / temperatureData.length * 100f) / 100f +
                        "\nКоличество здоровых: " + healthyPeople;

        return report;
    }
}
