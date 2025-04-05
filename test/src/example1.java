import java.util.*;
import java.util.logging.Logger;
import java.io.IOException;
import java.nio.file.*;
import java.util.logging.Level;

public class example1 {
    private static final Logger logger = Logger.getLogger(example1.class.getName());

    // public static void main(String[] args) {
    // List<String> inputLines = new ArrayList<>();

    // // 標準入力からすべての行を読み取る
    // try (Scanner scanner = new Scanner(System.in)) { // 標準入力を読み取る
    // while (scanner.hasNextLine()) {
    // inputLines.add(scanner.nextLine());
    // }
    // }

    // try {
    // int result = processInput(inputLines);
    // System.out.println(result);
    // } catch (IllegalArgumentException e) {
    // logger.severe("エラー: " + e.getMessage());
    // }
    // }

    public static void main(String[] args) {
        Path directoryPath = Paths.get("C:\\prog\\Java\\Java_public\\test\\testcase");

        try {
            // ディレクトリ内のすべての .txt ファイルを取得
            try (DirectoryStream<Path> txtFiles = Files.newDirectoryStream(directoryPath,
                    "*.txt")) {
                for (Path filePath : txtFiles) {
                    System.out.println("処理中のファイル: " + filePath);

                    // ファイル内容を読み込む
                    List<String> inputLines = Files.readAllLines(filePath);

                    try {
                        // processInput を実行
                        int result = processInput(inputLines);
                        System.out.println(result);
                    } catch (IllegalArgumentException e) {
                        logger.severe("エラー: " + e.getMessage());
                    }
                }
            }
        } catch (IOException e) {
            logger.log(Level.SEVERE, "ディレクトリまたはファイルの読み込み中にエラーが発生しました", e);
        }
    }

    private static int processInput(List<String> inputLines) {
        String[] Line1 = inputLines.get(0).split(" ");
        int n = Integer.parseInt(Line1[0]); // 行数

        int[] singleArray = { 1, 2, 3 }; // 一次元配列
        int[] singleArray2 = new int[5]; // サイズ指定の一次元配列
        List<Integer> arrayList = new ArrayList<>(); // ArrayList
        int[][] twoDimArray = { { 1, 2 }, { 3, 4 } }; // 二次元配列
        int[][] twoDimArray2 = new int[3][4]; // サイズ指定の二次元配列
        List<List<Integer>> listOfLists = new ArrayList<>(); // List of Lists
        int[][] emptyArray = new int[0][0]; // 空の二次元配列

        // 集合 (Set)
        Set<Integer> integerSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5)); // 整数の集合
        Set<String> stringSet = new TreeSet<>(Arrays.asList("apple", "banana", "cherry")); // 文字列の集合

        // 集合の中のリスト
        Set<List<Integer>> setOfLists = new HashSet<>();
        setOfLists.add(Arrays.asList(1, 2, 3));
        setOfLists.add(Arrays.asList(4, 5, 6));

        // float型の例
        float[] floatArray = { 1.1f, 2.2f, 3.3f }; // 一次元のfloat配列
        float[][] floatTwoDimArray = { { 1.1f, 2.2f }, { 3.3f, 4.4f } }; // 二次元のfloat配列
        List<Float> floatList = new ArrayList<>(Arrays.asList(1.1f, 2.2f, 3.3f)); // floatのリスト

        // if文の例
        if (n > 10) {
            System.out.println("nは10より大きい");
        } else {
            System.out.println("nは10以下");
        }

        // while文の例
        int count = 0;
        while (count < n) {
            System.out.println("カウント: " + count);
            count++;
        }

        // for文の例
        for (int i = 0; i < n; i++) {
            System.out.println("ループ: " + i);
        }

        // switch文の例
        switch (n) {
            case 1:
                System.out.println("nは1です");
                break;
            case 2:
                System.out.println("nは2です");
                break;
            default:
                System.out.println("nは1でも2でもありません");
        }

        // try-catch文の例
        try {
            int result = 10 / n; // nが0の場合、例外が発生
            System.out.println("結果: " + result);
        } catch (ArithmeticException e) {
            System.out.println("エラー: 0で割ることはできません");
        }

        // 型変換
        int m = 1;
        float answer = m;

        double numberDouble = 3.14;
        int numberInt = (int) numberDouble;

        return 5 * n;
    }
}