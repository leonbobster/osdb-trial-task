package PeakFinder;

import java.util.ArrayList;
import PeakFinder.Exception.*;

public class PeakFinder {
    public static int[] run(ArrayList<Integer> data) {
        if (data.size() < 2 || data.size() % 2 != 0) {
            throw new MalformedData();
        }

        int peakStartTime = data.get(0);
        int peakEndTime = data.get(1);
        int peakNumOfCalls = 1;
        int[] tmp = new int[]{0, 0, 0};

        for (int i = 2; i < data.size(); i += 2) {
            int st = data.get(i);
            int et = data.get(i + 1);

            if (st < data.get(i - 2)) {
                throw new MalformedData();
            }

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

        return tmp[0] < peakNumOfCalls
            ? new int[] {peakNumOfCalls, peakStartTime, peakEndTime}
            : tmp;
    }
}