import java.io.FileInputStream;
import java.util.Scanner;
import PeakFinder.*;

class App {
    public static void main(String[] args) {
        try (
            FileInputStream is = new FileInputStream(args[0]);
            Scanner sc = new Scanner(is, "UTF-8");
        ) {
            int[] peak = PeakFinder.run(sc);
            System.out.format(
                "The peak for this call log is %d simultaneous calls, that occured between %d and %d.\n", 
                peak[0], 
                peak[1], 
                peak[2]
            );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}