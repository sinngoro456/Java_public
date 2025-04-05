import java.util.*;
import java.util.logging.Logger;

public class test_B162 {
   private static final Logger logger = Logger.getLogger(test_B162.class.getName());

   public static void main(String[] args) {
      List<String> inputLines = new ArrayList<>();

      // 標準入力からすべての行を読み取る
      try (Scanner scanner = new Scanner(System.in)) { // 標準入力を読み取る
         while (scanner.hasNextLine()) {
            inputLines.add(scanner.nextLine());
         }
      }

      try {
         int result = processInput(inputLines);
         System.out.println(result);
      } catch (IllegalArgumentException e) {
         logger.severe("エラー: " + e.getMessage());
      }
   }

   private static int processInput(List<String> inputLines) {
      if (inputLines.size() < 2) {
         throw new IllegalArgumentException("入力データが不足しています。少なくとも2行必要です。");
      }

      String[] Line1 = inputLines.get(0).split(" ");
      int R = Integer.parseInt(Line1[0]); // 行数
      int C = Integer.parseInt(Line1[1]); // 列数

      if (inputLines.size() < R + 1) {
         throw new IllegalArgumentException("入力データが不足しています。指定された行数に対応するデータがありません。");
      }

      // 二次元配列を初期化
      char[][] grid = new char[R][C];

      // 2行目以降を1文字ずつ二次元配列に格納
      for (int i = 0; i < R; i++) {
         String line = inputLines.get(1 + i); // 2行目以降
         if (line.length() != C) {
            throw new IllegalArgumentException("行の長さが指定された列数と一致しません: " + line);
         }
         grid[i] = line.toCharArray(); // 1文字ずつ配列に格納
      }

      // // 二次元配列の内容を確認（デバッグ用）
      // for (char[] row : grid) {
      // System.out.println(Arrays.toString(row));
      // }
      int k_max = 0;
      for (int i = 1; i < R - 1; i++) {
         for (int j = 1; j < C - 1; j++) {
            if (grid[i][j] == '.') {
               int k = 1;
               while (i - k >= 0 && i + k < R && j - k >= 0 && j + k < C) {
                  // 上下左右のマスを確認
                  if (grid[i - k][j - k] == '.' && grid[i - k][j + k] == '.'
                        && grid[i + k][j - k] == '.' && grid[i + k][j + k] == '.' && k > k_max) {
                     k_max = k;
                     k++;
                  } else if (grid[i - k][j - k] == '.' && grid[i - k][j + k] == '.'
                        && grid[i + k][j - k] == '.' && grid[i + k][j + k] == '.' && k <= k_max) {
                     k++;
                  } else {
                     break; // どれかが '#' の場合は終了
                  }
               }
            }
         }
      }

      return k_max;
   }
}