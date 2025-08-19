package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

// 입력한 문자열들이 같은지 여부 확인
// 파일 이름의 길이는 모두 같음
public class CommandPrompt1032 {

  public void solution() throws IOException {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder sb = new StringBuilder();

    int N = Integer.parseInt(br.readLine());

    char[] array = br.readLine().toCharArray();// 맨 처음
    char[] temp;

    for (int i = 0; i < N-1; i++) {
      temp = br.readLine().toCharArray();
      for (int j = 0; j < array.length; j++) {
        if (array[j] != temp[j]) {
          array[j] = '\0';
        }
      }
    }

    for (char c : array) {
      if (c == '\0') {
        sb.append("?");
      }else {
        sb.append(c);
      }
    }
    System.out.println(sb);
  }

}
