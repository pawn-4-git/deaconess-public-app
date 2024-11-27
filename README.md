# 機能

OpenAIのAPIを使用し壁打ち相手を実現するアプリケーション

# 使い方
## 前提
Dockerでアプリケーションを動かしているので、Dockerが実行できる状態であること

## 1.ソースコードをダウンロード
zipファイルなどでダウンロードする

## 2.zipファイルを解凍する

## 3.build.shを実行する
実行が完了して正常に終わると以下のURLで起動されている

## 4.OpenAIのAPIキーの登録
以下のURLのAPIキーの設定を登録する
※DBに登録でも対応できる

URL: http://localhost:4510/setting

```
{
  envId:1,
  envName:"test",
  openaiApiKey:"APIキー"
}
```

※envNameは任意の文字列で良い
現状はenvIdが1のみ使用される

API実行に便利なChrome拡張機能

Talend API Tester - Free Edition

URL: https://chromewebstore.google.com/detail/talend-api-tester-free-ed/aejoelaoggembcahagimdiliamlcdmfm?hl=ja

<img width="1499" alt="image" src="https://github.com/user-attachments/assets/bf1464eb-5d49-4f3d-bfdb-b6ad2f48efb3">


# 画面

URL: http://localhost:4510
<img width="1156" alt="image" src="https://github.com/user-attachments/assets/f55e6bd4-2ffe-49b5-9ab3-b3400a375b18">

各表示

<img width="514" alt="image" src="https://github.com/user-attachments/assets/e3d66bbf-c9bc-4ab0-b4e0-47480c54bef2">

黄色の部分に質問の回答を入力してメイドちゃんを押すとAPIに問い合わせが行われる


# 仕組み

WEBアプリケーションのフロント　SpringBoot　

　Java22以上で実行で構成
 
DB PostgreSQL

ライブラリ SpringAI https://docs.spring.io/spring-ai/reference/index.html

# DBの構造
## api_setting
APIの設定の登録情報

## response_type
AIへの問い合わせの際に使用される

response_type→管理番号　response_system→プロンプト

## top_menu
最初のページのメニューの一覧に表示される

top_menu_id→表示順序　url_path→リンク先のパス　menu_name→リンクに表示される名前

## question_answer_menu_detail
詳細のページに表示される質問の大グループで、以下の画像の目的の確認やゴールの確認のように一つのまとまりとしたもの

<img width="597" alt="image" src="https://github.com/user-attachments/assets/7bb9c148-a155-4894-a568-895cbfd1b26d">

url_path→画面のパス（top_menuのurl_pathに対応したもの）　detail_no→ページ内で表示される順番　detail_name→まとまりの名前

## question_answer_menu_detail_answer
詳細のページに表示される質問の大グループの中項目で質問と質問に対するプロンプトの紐付けを行う

url_path→画面のパス（question_answer_menu_detailのurl_pathに対応したもの）detail_no→大項目の番号（question_answer_menu_detailのdetail_noに対応したもの）answer_no→大項目の中の質問の表示順　question_text→画面に表示する質問文 question_type→回答をする際の質問の仕方を切り替える（1→その質問だけをAIに聞くタイプでそれまでの質問と回答は無視する 2→それまでの質問と回答のやり取りを全てプロンプトに入れて質問する） response_type→AIへ質問する際のシステムメッセージとの関連付(response_typeのresponse_typeと対応)


## 注意事項
question_typeを2に設定した場合、それまでの質問と回答を全てプロンプトに入れて回答をさせるのでトークン数が増える。

基本は1で単体の質問を行い、それまでのやり取りが必要な場合だけ使用する

今回はミーティング設定や翻訳の質問は単体で質問が完結するのでquestion_typeを1、なぜなぜ分析でそれまでの質問や回答が必要な場合だけ2を設定している









