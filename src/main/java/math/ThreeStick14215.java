package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class ThreeStick14215 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int[] array = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();

    // 가장 긴 변이 다른 변의 합보다 클 때 (삼각형 조건을 만족하지 못할 때)
    if ((array[0] + array[1] <= array[2])) {
      // 가장 긴 변을 (두 변의 합 - 1)로 줄여서 삼각형이 되도록 수정
      array[2] = array[0] + array[1] - 1;
    }

    System.out.println(array[0] + array[1] + array[2]);
  }
}
