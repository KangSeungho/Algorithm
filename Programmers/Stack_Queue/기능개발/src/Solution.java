import java.util.*;

class Solution {
    public int[] solution(int[] progresses, int[] speeds) {
        int[] jobCount = new int[100];

        int day = 1;
        for(int i=0; i<progresses.length; i++) {
            if(progresses[i] + (day*speeds[i]) < 100)
                day = (int)Math.ceil((100f - progresses[i]) / speeds[i]);

            jobCount[day]++;
        }

        return Arrays.stream(jobCount).filter(value -> value>0).toArray();
    }
}
