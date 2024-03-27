# SpringBoot+MyBatisでの例外サンプル

SpringBoot+MyBatisでマッパーXMLを使ったときにどんなミスによってどんな例外が出るのかを処理の流れとともに整理したサンプル。  
ここに挙げた例外がすべてではないし他の書き方も色々とできるが、
単にSQLを実行してるだけではなく前後でどんなことをしているかを把握することで例外の原因を考えやすくするのが目的。  

# 大まかな処理の流れ
## 1. (アプリ起動時)XMLファイルをロード

## 2. Mapファイルを探す

## 3. 関連クラスの処理

### 3-1. パラメタ
### 3-2. 結果

## 4. SQLを準備

## 5. SQL実行、結果受取

## 6. 結果オブジェクトに値を代入
## 6. 結果オブジェクトに値を代入