package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Warning3029 {
  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String[] inputTime = br.readLine().split(":");
    String[] throwTime = br.readLine().split(":");
    int[] rTime = new int[3];
    int[] tTime = new int[3];
    int[] resultTime = new int[3];

    for (int i = 0; i < 3; i++) {
      rTime[i] = Integer.parseInt(inputTime[i]);
      tTime[i] = Integer.parseInt(throwTime[i]);
    }

    if(rTime[2] > tTime[2]) {
      resultTime[2] = (60 - rTime[2]) + tTime[2];
      rTime[1]++;
    }else {
      resultTime[2] = tTime[2]-rTime[2];
    }

    // 분
    if(rTime[1] > tTime[1]) {
      resultTime[1] = (60 - rTime[1]) + tTime[1];
      rTime[0]++;
    }else {
      resultTime[1] = tTime[1]-rTime[1];
    }

    // 시
    if(tTime[0] < rTime[0]) {
      resultTime[0] = (24 - rTime[0]) + tTime[0];
    }else {
      resultTime[0] = tTime[0]-rTime[0];
    }

    if(resultTime[0] + resultTime[1] + resultTime[2] == 0){
      resultTime[0] = 24;
    }

    if(resultTime[0] >= 24 && resultTime[1]+resultTime[2] > 0){
      resultTime[0] = 24;
      resultTime[1] = 0;
      resultTime[2] = 0;
    }

    System.out.printf("%02d:%02d:%02d%n", resultTime[0], resultTime[1], resultTime[2]);
  }
}
