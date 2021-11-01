import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 강승호 2021-11-01
 */
public class Main {
    static class Data {
        int[] progresses;
        int[] speeds;
        int[] result;
    }

    static List<Data> testCase = new LinkedList<>();

    static {
        Data data;

        data = new Data();
        data.progresses = new int[] {93, 30, 55};
        data.speeds = new int[] {1, 30, 5};
        data.result = new int[] {2, 1};
        testCase.add(data);

        data = new Data();
        data.progresses = new int[] {95, 90, 99, 99, 80, 99};
        data.speeds = new int[] {1, 1, 1, 1, 1, 1};
        data.result = new int[] {1, 3, 2};
        testCase.add(data);
    }

    public static void main(String[] args) {
        for(Data data : testCase) {
            Solution sol = new Solution();

            System.out.println();
            System.out.println(Arrays.toString(data.result));
            System.out.println(Arrays.toString(sol.solution(data.progresses, data.speeds)));
        }
    }
}
