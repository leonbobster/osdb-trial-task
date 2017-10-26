import java.util.Arrays;
import java.util.ArrayList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import PeakFinder.*;

class App {
    public static void main(String[] args) {
        ArrayList<Integer> data = new ArrayList<Integer>();

        try (Stream<String> stream = Files.lines(Paths.get(args[0]))) {
            stream.forEach(line -> {
                String[] nums = line.split(":");
                data.add(Integer.parseInt(nums[0]));
                data.add(Integer.parseInt(nums[1]));
            });
            try {
                int[] peak = PeakFinder.run(data);
                System.out.format(
                    "The peak for this call log is %d simultaneous calls, that occured between %d and %d.\n", 
                    peak[0], 
                    peak[1], 
                    peak[2]
                );
            } catch (RuntimeException e) {
                System.out.println("Error: malformed input data detected");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}