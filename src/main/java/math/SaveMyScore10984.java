package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SaveMyScore10984 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st;
    StringBuilder sb = new StringBuilder();

    int T = Integer.parseInt(br.readLine());  // 학기의 수
    int N;  // 과목의 수

    // 반복 시 학점(C)과 성적(G)
    int C, totalC;
    double G, totalG;

    for (int i = 0; i < T; i++) {
      N = Integer.parseInt(br.readLine());
      totalC = 0;
      totalG = 0;
      for (int j = 0; j < N; j++) {
        st = new StringTokenizer(br.readLine());
        C = Integer.parseInt(st.nextToken());
        G = Double.parseDouble(st.nextToken());
        totalC += C;
        totalG += (G * C);
      }
      sb.append(totalC).append(" ").append(totalG / totalC).append("\n");
    }

    System.out.println(sb);
  }

}
