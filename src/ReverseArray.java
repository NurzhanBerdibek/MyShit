import java.util.Arrays;

public class ReverseArray {
    public static void main(String[] args) {
        // Создаем массив из мнемонической фразы
        String[] mnemonicArray = {"Каждый", "охотник", "желает", "знать,", "где", "сидит", "фазан."};

        // Выводим первоначальный массив
        System.out.println("Первоначальный массив: " + Arrays.toString(mnemonicArray));

        // Меняем порядок элементов на обратный
        reverseArray(mnemonicArray);

        // Выводим массив с элементами в обратном порядке
        System.out.println("Массив с элементами в обратном порядке: " + Arrays.toString(mnemonicArray));
    }

    // Метод для изменения порядка элементов в массиве на обратный
    private static void reverseArray(String[] array) {
        int length = array.length;
        for (int i = 0; i < length / 2; i++) {
            // Обмениваем элементы симметрично относительно середины массива
            String temp = array[i];
            array[i] = array[length - i - 1];
            array[length - i - 1] = temp;
        }
    }
}
