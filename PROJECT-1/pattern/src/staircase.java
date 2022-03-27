import java.time.LocalDate;
import java.util.Date;

public class staircase {
    public static int libraryFine(int d1, int m1, int y1, int d2, int m2, int y2) {

        LocalDate d = LocalDate.of(y1, m1, d1);
        LocalDate d5 = LocalDate.of(y2, m2, d2);
        System.out.println((d1 - d2) * 15);
        return ((d1 - d2) * 15);
    }


    public static void main(String[] args) {
        libraryFine(9, 6, 2015, 6, 6, 2015);


    }


}