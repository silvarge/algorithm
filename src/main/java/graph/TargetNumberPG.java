package graph;

import java.io.IOException;

public class TargetNumberPG {

  int result = 0;

  public void solution(int[] numbers, int target) throws IOException {
    dfs(numbers, 0, 0, target);
    System.out.println(result);
  }

  public void dfs(int[] numbers, int depth, int sum, int target) {

    if (depth == numbers.length) {
      if (sum == target) {
        result++;
      }
      return;
    }

    dfs(numbers, depth + 1, sum + numbers[depth], target);
    dfs(numbers, depth + 1, sum - numbers[depth], target);

  }

}
