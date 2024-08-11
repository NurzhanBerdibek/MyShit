import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class course1dot6 {
    public static void main(String args[]) {
        DateFormat format = new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
        Date date = new Date();
        System.out.println(format.format(date));
    }

}
