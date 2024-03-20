package com.example.mybatisdemo;

import com.example.mybatisdemo.model.DemoPk;
import org.apache.ibatis.binding.BindingException;
import org.apache.ibatis.reflection.ReflectionException;
import org.junit.jupiter.api.Test;
import org.mybatis.spring.MyBatisSystemException;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.BadSqlGrammarException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@MybatisTest
class DemoMapperTest {

    @Autowired
    DemoMapper mapper;

    @Autowired
    NotFoundMapper notFoundMapper;

    @Test
    void insertとgetが動くことの確認() {
        mapper.insert("a002", "name", 0);
        List<Demo> demo = mapper.get();
        assertEquals("name", demo.get(0).name);

    }

    @Test
    void No01_マッパーXMLが見つからないとBindingException出る() {
        MyTestUtil.myAssertThrows(BindingException.class, ()->notFoundMapper.get());

    }

    @Test
    void No02_01_パラメータのエラーだとMyBatisSystemException() {
        MyTestUtil.myAssertThrows(MyBatisSystemException.class,()-> mapper.wrongBind(new DemoPk("1")));
    }
    @Test
    void No02_02_パラメータのプロパティエラーだとMyBatisSystemException() {
        MyTestUtil.myAssertThrows(MyBatisSystemException.class,()-> mapper.wrongProperty(new DemoPk("1")));
    }

    @Test
    void No02_03_列名ミスマッチだとMyBatisSystemException() {
        mapper.insert("a002", "name", 0);
        MyTestUtil.myAssertThrows(MyBatisSystemException.class,()-> mapper.wrongColumn());
    }

    @Test
    void No04_01_SQL文法誤りだとBadSqlGrammarException() {
        MyTestUtil.myAssertThrows(BadSqlGrammarException.class,()-> mapper.wrongSelect(new DemoPk("1")));
    }

    @Test
    void No04_02_テーブルがないとBadSqlGrammarException() {
        MyTestUtil.myAssertThrows(BadSqlGrammarException.class,()-> mapper.wrongTable());
    }

    @Test
    void No06_先頭項目が当てはまらないコンストラクタしかないとMyBatisSystemException() {
        mapper.insert("a002", "name", 0);
        MyTestUtil.myAssertThrows(org.mybatis.spring.MyBatisSystemException.class,()-> mapper.badConstructor());
    }
/**
 * - データベースに接続する（番外編-起動時 - HikariCP）
 *      - つながらない
 * - Mapファイル探す
 *     - ファイル見つからない
 * - SQL準備する
 *     - 文法エラーここだっけな
 * - パラメタ渡す
 *     - これも準備の一部だっけか
 * - 動的SQL内のJavaエラー
 * - DBにアクセス
 *     - つながらないとここでエラーかな。起動時は別として。
 * - 実行してDBから結果受け取る
 *     - 実行時のSQLエラー
 *     - 実行エラー
 * - 結果をマッピング
 *     - 該当項目見つからない
 *         - クラス名、プロパティ名間違ってる
 * - オブジェクトに値を注入
 *     - インスタンス作れない
 *     - Handlerで値の変換に失敗
 *     - プロパティにアクセスできない
 *         - getなんちゃら、setなんちゃらが変にあるとあかんやつ
 */
}