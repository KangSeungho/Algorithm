import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 강승호 2021-10-30
 */
public class Main {
    static class Data {
        String[] genres;
        int[] plays;
        int[] result;
    }

    static List<Data> testCase = new LinkedList<>();

    static {
        Data data;

        data = new Data();
        data.genres = new String[] {"classic", "pop", "classic", "classic", "pop"};
        data.plays = new int[] {500, 600, 150, 800, 2500};
        data.result = new int[] {4, 1, 3, 0};
        testCase.add(data);
    }

    public static void main(String[] args) {
        for(Data data : testCase) {
            Solution sol = new Solution();

            System.out.println();
            System.out.println(Arrays.toString(data.result));
            System.out.println(Arrays.toString(sol.solution(data.genres, data.plays)));
        }
    }
}
