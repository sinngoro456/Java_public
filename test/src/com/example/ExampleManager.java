
package com.example;

// ExampleManager.java
import java.util.logging.Level;
import java.util.logging.Logger;

public class ExampleManager {
    private static final Logger logger = Logger.getLogger(ExampleManager.class.getName());

    public static void main(String[] args) {
        // ExampleSub クラスのインスタンスを作成
        ExampleSub obj = new ExampleSub("ManagedObject", 100);

        // メソッド呼び出し
        obj.displayInfo();

        // セッターで値を変更
        obj.setName("UpdatedName");
        obj.setValue(200);

        // 変更後の情報を表示
        logger.log(Level.INFO, "Updated Values - Name: {0}, Value: {1}",
                new Object[] { obj.getName(), obj.getValue() });
    }
}