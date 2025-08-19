package math;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RoomAllocation13300 {

  static class GradeInfo {

    int grade;
    int female = 0;
    int male = 0;

    public GradeInfo(int grade) {
      this.grade = grade;
    }
  }

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringTokenizer st = new StringTokenizer(br.readLine());

    int N = Integer.parseInt(st.nextToken()); // 참가 학생 수
    int K = Integer.parseInt(st.nextToken()); // 배정 최대 인원 수

    GradeInfo[] grades = new GradeInfo[6];
    for (int i = 0; i < 6; i++) {
      grades[i] = new GradeInfo(i + 1);
    }

    int S, Y;
    // 학년 및 성별 나누기
    for (int i = 0; i < N; i++) {
      st = new StringTokenizer(br.readLine());
      S = Integer.parseInt(st.nextToken());
      Y = Integer.parseInt(st.nextToken());

      if (S == 0) {
        grades[Y - 1].female++;
      } else {
        grades[Y - 1].male++;
      }
    }

    int count = 0;
    for (int i = 0; i < 6; i++) {
      // 여자
      count += grades[i].female % K == 0 ? grades[i].female / K : grades[i].female / K + 1;
      // 남자
      count += grades[i].male % K == 0 ? grades[i].male / K : grades[i].male / K + 1;
    }
    System.out.println(count);

  }

}
