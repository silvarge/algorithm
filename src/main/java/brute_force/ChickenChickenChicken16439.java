package brute_force;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class ChickenChickenChicken16439 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken());
    int M = Integer.parseInt(st.nextToken());

    int maxSum = -1;
    int[][] preference = new int[N][M];

    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      for (int j = 0; j < M; j++) {
        preference[i][j] = Integer.parseInt(st.nextToken());
      }
    }

    for (int i = 0; i < M; i++) {
      for (int j = i + 1; j < M; j++) {
        for (int k = j + 1; k < M; k++) {
          int sum = 0;
          for (int member = 0; member < N; member++) {
            int best = Math.max(preference[member][i],
                Math.max(preference[member][j], preference[member][k]));
            sum += best;
          }
          maxSum = Math.max(maxSum, sum);
        }
      }
    }

    System.out.println(maxSum);
  }

}
