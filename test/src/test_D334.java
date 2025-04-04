import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class test_D334 {
   private static final Logger logger = Logger.getLogger(test_D334.class.getName());

   public static void main(String[] args) {
      // 自分の得意な言語で
      // Let's チャレンジ！！
      Scanner sc = new Scanner(System.in);
      String line = sc.nextLine();
      System.out.println(line);
   }

   private static int processInput(List<String> inputlines) {
      try {
         // 各行から数値を取得（7行分）
         String[] line1 = inputlines.get(0).split(" ");
         int p_1 = Integer.parseInt(line1[0]);

         String[] line2 = inputlines.get(1).split(" ");
         int p_2 = Integer.parseInt(line2[0]);

         String[] line3 = inputlines.get(2).split(" ");
         int p_3 = Integer.parseInt(line3[0]);

         String[] line4 = inputlines.get(3).split(" ");
         int p_4 = Integer.parseInt(line4[0]);

         String[] line5 = inputlines.get(4).split(" ");
         int p_5 = Integer.parseInt(line5[0]);

         String[] line6 = inputlines.get(5).split(" ");
         int p_6 = Integer.parseInt(line6[0]);

         String[] line7 = inputlines.get(6).split(" ");
         int p_7 = Integer.parseInt(line7[0]);

         return p_1 + p_2 + p_3 + p_4 + p_5 + p_6 + p_7;
      } catch (Exception e) {
         logger.log(Level.SEVERE, "入力データの解析中にエラーが発生しました", e);
         System.err.println("エラーが発生しました: " + e.getMessage());
         return 0;
      }
   }
}