package PeakFinder;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;
import PeakFinder.Exception.*;

public class PeakFinder {
    public static int[] run(String file) throws IOException {
        int peakStartTime = 0;
        int peakEndTime = 0;
        int peakNumOfCalls = 0;
        int[] tmp = new int[]{0, 0, 0};

        try (
            FileInputStream is = new FileInputStream(file);
            Scanner data = new Scanner(is, "UTF-8");
        ) {
            if (data.hasNextLine()) {
                List<Integer> fl = parseLine(data.nextLine());
                peakStartTime = fl.get(0);
                peakEndTime = fl.get(1);
                peakNumOfCalls = 1;
    
                while (data.hasNextLine()) {
                    List<Integer> n = parseLine(data.nextLine());
                    int st = n.get(0);
                    int et = n.get(1);
        
                    if (st < peakEndTime) {
                        peakNumOfCalls += 1;
                        peakStartTime = st;
                        peakEndTime = et < peakEndTime ? et : peakEndTime;
                    } else {
                        if (tmp[0] < peakNumOfCalls) {
                            tmp = new int[]{
                                peakNumOfCalls,
                                peakStartTime,
                                peakEndTime
                            };
                        }
                        peakNumOfCalls = 1;
                        peakStartTime = st;
                        peakEndTime = et;
                    }
                }
            }
        }

        return tmp[0] < peakNumOfCalls
            ? new int[] {peakNumOfCalls, peakStartTime, peakEndTime}
            : tmp;
    }

    private static List<Integer> parseLine(String line) {
        List<Integer> nums = Stream.of(line.split(":"))
            .map(Integer::parseInt)
            .collect(Collectors.toList());

        if (nums.size() != 2) {
            throw new MalformedData();
        }

        return nums;
    }
}