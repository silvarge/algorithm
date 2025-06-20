package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class SelectThreeNum1503 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());
    int N = Integer.parseInt(st.nextToken());
    int size = Integer.parseInt(st.nextToken());
    Set<Integer> array = new HashSet<>();

    if (size != 0) {
      array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).boxed().collect(
          Collectors.toSet());
    }

    int[] search = new int[1002];
    for (int i = 1; i < 1002; i++) {
      if(!array.contains(i)) {
        search[i] = 1;
      }
    }

    int result = Integer.MAX_VALUE;
    for (int i = 1; i <= 1000; i++) {
      for (int j = i; j <= 1000; j++) {
        for (int k = j; k <= 1001; k++) {
          if (search[i] * search[j] * search[k] == 0) {
            continue;
          }
          long product = i * j * k;
          int cal = (int) Math.abs(N - product);
          result = Math.min(cal, result);
        }
      }
    }
    System.out.println(result);

  }

}
