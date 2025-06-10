package graph;

import java.io.IOException;

public class TargetNumberPG43165 {

  int result = 0;

  public int solution(int[] numbers, int target) throws IOException {
    dfs(numbers, 0, 0, target);
    return result;
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
