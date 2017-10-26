import PeakFinder.*;

class App {
    public static void main(String[] args) {
        try {
            int[] peak = PeakFinder.run(args[0]);
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