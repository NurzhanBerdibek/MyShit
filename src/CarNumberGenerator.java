import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

public class CarNumberGenerator {

    public static void main(String[] args) {
        List<String> carNumbersList = generateCarNumbers(2000000);
        Set<String> carNumberHashSet = new HashSet<>(carNumbersList);
        Set<String> carNumberTreeSet = new TreeSet<>(carNumbersList);
        Collections.sort(carNumbersList);

        String targetNumber = carNumbersList.get(ThreadLocalRandom.current().nextInt(carNumbersList.size()));
        System.out.println("target is: " + targetNumber);

        long startTime = System.nanoTime();
        Boolean foundByIteration = findByIteration(carNumbersList, targetNumber);
        long duration = System.nanoTime() - startTime;
        printSearchResult("Поиск перебором ", foundByIteration, duration);

        startTime = System.nanoTime();
        Boolean foundByBinary = findByBinarySearch(carNumbersList, targetNumber);
        duration = System.nanoTime() - startTime;
        printSearchResult("Бинарный поиск ", foundByBinary, duration);

        startTime = System.nanoTime();
        Boolean foundByHash = findByHashSet(carNumberHashSet, targetNumber);
        duration = System.nanoTime() - startTime;
        printSearchResult("HashSet поиск ", foundByHash, duration);

        startTime = System.nanoTime();
        Boolean foundByTree = findByTreeSet(carNumberTreeSet, targetNumber);
        duration = System.nanoTime() - startTime;
        printSearchResult("TreeSet поиск ", foundByTree, duration);

    }
    // Генерация общего пула номеров
    private static List<String> generateCarNumbers(int count) {
        List<String> carNumbers = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            String carNumber = generateSingleCarNumber();
            carNumbers.add(carNumber);
        }
        return carNumbers;
    }
    // генерация одного конкретного номера
    private static String generateSingleCarNumber()  {
        char letter1 = (char) ThreadLocalRandom.current().nextInt('A', 'Z' + 1);
        char digit1 = (char) ThreadLocalRandom.current().nextInt('0', '9' + 1);
        char digit2 = (char) ThreadLocalRandom.current().nextInt('0', '9' + 1);
        char digit3 = (char) ThreadLocalRandom.current().nextInt('0', '9' + 1);
        char letter2 = (char) ThreadLocalRandom.current().nextInt('A', 'Z' + 1);
        char letter3 = (char) ThreadLocalRandom.current().nextInt('A', 'Z' + 1);
        String region = String.format("%03d", ThreadLocalRandom.current().nextInt(1, 200));
        return String.valueOf(letter1) + digit1 + digit2 + digit3 + letter2 + letter3 + region;

    }
    //пойск перебором
    private static boolean findByIteration(List<String> list, String target) {
        for (String element : list) {
            if (element.equals(target)) {
                return true;
            }
        }
        return false;
    }
    //Бинарный поиск
    private static boolean findByBinarySearch(List<String> list, String target) {
        int index = Collections.binarySearch(list, target);
        return index >= 0;
    }
    // Поиск в HashSet
    private static boolean findByHashSet(Set<String> set, String target) {
        return set.contains(target);
    }
    // Поиск в treeSet
    private static boolean findByTreeSet(Set<String> set, String target) {
        return set.contains(target);
    }
    // вывод результатов на экран
    private static void printSearchResult(String method, boolean found, long duration) {
        String result = found ? "Founded" : "Not founded";
        System.out.println(method + "number" + result + "Seatch took " + duration + "ns");
    }
}
