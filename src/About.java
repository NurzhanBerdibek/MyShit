import java.util.Random;

public class About extends CarTypes {
    public static void main(String[] args) {
        About about = new About();
        Random random = new Random();

        int RandomBrand = random.nextInt(about.getBrandsCount());
        int RandomColor = random.nextInt(about.getColorsCount());

        System.out.println("Brand name: " + about.getBrand(RandomBrand));
        System.out.println("Colour: " + about.getColor(RandomColor));
        System.out.println("Wheel position: " + about.getWheel());
    }
}
