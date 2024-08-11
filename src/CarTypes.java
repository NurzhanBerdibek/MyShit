import java.util.Random;

public class CarTypes {
    Random random = new Random();

    private String[] brands = {"LADA", "FORD", "VOLKSWAGEN", "CHEVROLET", "DODGE"};
    private String[] Colors = {"BLACK", "WHITE", "RED", "GREEN", "BLUE", "YELLOW"};

    private String[] carWheelPosition = {"LEFT", "RIGHT"};

    public String getBrand(int index) {
        if (index >= 0 && index < brands.length) {
            return brands[index];
        } else {
            return "Unknown";
        }
    }

    public void setBrand(int index, String brand) {
        if (index >= 0 && index < Colors.length) {
            this.Colors[index] = brand;
        }
    }

    public int getBrandsCount() {
        return Colors.length;
    }

    public String getColor(int index) {
        if (index >= 0 && index < Colors.length) {
            return Colors[index];
        } else {
            return "Unknown";
        }
    }

    public void setColor(int index, String brand) {
        if (index >= 0 && index < Colors.length) {
            this.Colors[index] = brand;
        }
    }

    public int getColorsCount() {
        return brands.length;
    }

    public String getWheel() {
        Random random = new Random();
        // 80% chance for "LEFT", 20% chance for "RIGHT"
        return random.nextInt(100) < 80 ? carWheelPosition[0] : carWheelPosition[1];
    }

    public int getWheelCount() {
        return carWheelPosition.length;
    }
}
