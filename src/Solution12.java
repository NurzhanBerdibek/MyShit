import java.util.ArrayList;
import java.util.List;

public class Solution12 {
    public static <T> int ElementCount(List<T> list) {
        int sum = 1;

        if (list.isEmpty()) {
            return 0;
        }

        list.remove(0);
        return sum + ElementCount(list);
    }

    public static void main(String[] args) {
        List<String> Names = List.of("Andrew", "Brian", "Clara", "David");
        int Count = ElementCount(Names);
        System.out.println(Count);
    }

}