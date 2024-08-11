import java.util.Arrays;
import java.util.Random;

public class TemperatureAnalyzer {
    public static final int PATIENT_COUNT = 30;
    public static final float MIN_TEMPERATURE = 32.0f;
    public static final float MAX_TEMPERATURE = 40.0f;
    public static final float MIN_HEALTHY_TEMPERATURE = 36.2f;
    public static final float MAX_HEALTHY_TEMPERATURE = 36.9f;

    public static void main(String[] args) {
        // Создаем массив с температурами пациентов
        float[] temperatures = generateTemperatures();

        // Выводим температуры пациентов
        System.out.println("Температуры пациентов: " + Arrays.toString(temperatures));

        // Рассчитываем среднюю температуру и количество здоровых пациентов
        float averageTemperature = calculateAverageTemperature(temperatures);
        int healthyPatientCount = countHealthyPatients(temperatures);

        // Выводим результаты
        System.out.println("Средняя температура: " + averageTemperature);
        System.out.println("Количество здоровых: " + healthyPatientCount);
    }

    // Метод для генерации массива температур
    private static float[] generateTemperatures() {
        Random random = new Random();
        float[] temperatures = new float[PATIENT_COUNT];
        for (int i = 0; i < PATIENT_COUNT; i++) {
            temperatures[i] = MIN_TEMPERATURE + random.nextFloat() * (MAX_TEMPERATURE - MIN_TEMPERATURE);
        }
        return temperatures;
    }

    // Метод для расчета средней температуры
    private static float calculateAverageTemperature(float[] temperatures) {
        float sum = 0;
        for (float temperature : temperatures) {
            sum += temperature;
        }
        return sum / temperatures.length;
    }

    // Метод для подсчета количества здоровых пациентов
    private static int countHealthyPatients(float[] temperatures) {
        int count = 0;
        for (float temperature : temperatures) {
            if (temperature >= MIN_HEALTHY_TEMPERATURE && temperature <= MAX_HEALTHY_TEMPERATURE) {
                count++;
            }
        }
        return count;
    }
}
