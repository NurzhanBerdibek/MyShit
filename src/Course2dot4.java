import java.lang.Math.*;

public class Course2dot4 {
    int a = 24;
    int b = 22;
    int c = 25;

    int minAge = -1;
    int mediumAge = -1;
    int maxAge = -1;

    public void findMinMaxMedium() {
        findMin();
        findMax();
        findMedium();
    }

    private void findMin() {
        minAge = Math.min(Math.min(a, b), c);
    }

    private void findMax() {
        maxAge = Math.max(Math.max(a, b), c);
    }

    private void findMedium() {
        // Find the medium value among a, b, and c
        mediumAge = a + b + c - minAge - maxAge;
    }

    public static void main(String[] args) {
        Course2dot4 course = new Course2dot4();
        course.findMinMaxMedium();

        System.out.println("Minimum Age: " + course.minAge);
        System.out.println("Maximum Age: " + course.maxAge);
        System.out.println("Medium Age: " + course.mediumAge);
    }
}

