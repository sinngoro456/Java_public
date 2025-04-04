import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Stream;

public class Main2 {
    private static final Logger logger = Logger.getLogger(Main.class.getName());

    public static void main(String[] args) throws IOException { // try-catch を削除
        String dirPath = "C:\\prog\\Python\\Python_private\\test\\testcase";
        processAllTextFiles(dirPath);
    }

    private static void processAllTextFiles(String dirPath) {
        try (Stream<Path> paths = Files.list(Paths.get(dirPath))) {
            paths.filter(path -> path.toString().endsWith(".txt"))
                    .forEach(Main2::processSingleFile);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "ディレクトリ処理中にエラーが発生しました", e);
        }
    }

    private static void processSingleFile(Path filePath) {
        try {
            logger.info(() -> "処理開始: " + filePath);
            List<String> inputLines = Files.readAllLines(filePath);
            int result = processInput(inputLines);
            logger.info(() -> "処理完了: " + filePath + " 結果: " + result);
        } catch (IOException e) {
            logger.log(Level.SEVERE, "ファイル処理エラー: " + filePath, e);
        }
    }

    private static int processInput(List<String> inputLines) {
        String[] firstLine = inputLines.get(0).split(" ");
        int H = Integer.parseInt(firstLine[0]);
        int W = Integer.parseInt(firstLine[1]);

        int[][] sArray = new int[H][W];
        for (int i = 0; i < H; i++) {
            String[] line = inputLines.get(i + 1).trim().split(" ");
            for (int j = 0; j < W; j++) {
                sArray[i][j] = Integer.parseInt(line[j]);
            }
        }

        double[] prevDp = new double[W];
        double[] currentDp = new double[W];

        for (int y = 0; y < H; y++) {
            for (int x = 0; x < W; x++) {
                int minK = Math.max(0, x - 1);
                int maxK = Math.min(W - 1, x + 1);

                for (int k = minK; k <= maxK; k++) {
                    if (currentDp[x] < prevDp[k] + sArray[y][x]) {
                        currentDp[x] = prevDp[k] + sArray[y][x];
                    }
                }
            }
            System.arraycopy(currentDp, 0, prevDp, 0, W);
        }

        return (int) Arrays.stream(currentDp).max().orElse(0);
    }
}