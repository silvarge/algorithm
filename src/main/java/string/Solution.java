package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {

  public int[] solution(int n, String[] words) {
    int[] answer = {0, 0};

    List<String> strings = new ArrayList<>();
    strings.add(words[0]);

    for (int i = 1; i < words.length; i++) {
      if (strings.contains(words[i])
          || words[i - 1].charAt(words[i - 1].length() - 1) != words[i].charAt(0)) {
        answer[0] = i % n + 1;
        answer[1] = i / n + 1;
        return answer;
      }
      strings.add(words[i]);
    }
    return answer;
  }

  public static void main(String[] args) {

    Solution s = new Solution();

    String[] testCase = {"tank", "kick", "know", "wheel", "land", "dream", "mother", "robot",
        "tank"};
    int n = 3;

    System.out.println(Arrays.toString(s.solution(n, testCase)));
  }
}
