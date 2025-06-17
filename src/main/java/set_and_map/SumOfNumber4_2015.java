package set_and_map;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class SumOfNumber4_2015 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int K = Integer.parseInt(st.nextToken());

    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);

    int[] sum = new int[N+1];

    st = new StringTokenizer(br.readLine());
    for (int i = 1; i <= N; i++) {
      sum[i] = sum[i - 1] + Integer.parseInt(st.nextToken());
    }

    int result = 0;
    for (int i = 1; i <= N; i++) {
      result += map.getOrDefault(sum[i] - K, 0);
      map.put(sum[i], map.getOrDefault(sum[i], 0) + 1);
    }

    System.out.println(result);

  }

}
