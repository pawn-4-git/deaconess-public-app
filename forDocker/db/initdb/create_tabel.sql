create table api_setting(
   env_id integer,
   env_name varchar(1000) not null,
   openai_api_key varchar(1000),
   primary key(env_id)
);

create table response_type(
   response_type integer not null,
   response_system text not null,
   primary key(response_type)
);

create table top_menu(
   top_menu_id integer not null,
   url_path varchar(100) not null,
   menu_name varchar(100) not  null,
   primary key(top_menu_id)
);

create table question_answer_menu_detail(
   url_path varchar(100) not null,
   detail_no integer not null,
   detail_name varchar(100) not null,
   primary key(url_path,detail_no)
);

create table question_answer_menu_detail_answer(
   url_path varchar(100) not null,
   detail_no integer not null,
   answer_no integer not null,
   question_text varchar(400) not null,
   question_type integer not null,
   response_type integer not null,
   primary key(url_path,detail_no,answer_no)
);

insert into top_menu values (1,'/question_and_answer/meeting','ミーティング設定');
insert into top_menu values (2,'/question_and_answer/translate','翻訳');
insert into top_menu values (3,'/question_and_answer/nazenaze','なぜなぜ分析');
insert into question_answer_menu_detail values ('/question_and_answer/meeting',1,'目的の確認');
insert into question_answer_menu_detail_answer values ('/question_and_answer/meeting',1,1,'ミーティングの目的を入力してください。目的が具体的であるかを確認します',1,2);
insert into question_answer_menu_detail values ('/question_and_answer/meeting',2,'ゴールの確認');
insert into question_answer_menu_detail_answer values ('/question_and_answer/meeting',2,1,'ミーティングのゴールを入力してください。目的が具体的であるかを確認します',1,3);
insert into question_answer_menu_detail values ('/question_and_answer/translate',1,'日本語への翻訳');
insert into question_answer_menu_detail_answer values ('/question_and_answer/translate',1,1,'日本語に翻訳する文章を入れてください',1,4);
insert into question_answer_menu_detail values ('/question_and_answer/nazenaze',1,'なぜなぜ分析');
insert into question_answer_menu_detail_answer values ('/question_and_answer/nazenaze',1,1,'入力された問題と原因と思うことを入力してください',2,5);
insert into question_answer_menu_detail_answer values ('/question_and_answer/nazenaze',1,2,'提示された原因もしくは解決案に対する意見を入力してください。これまでに提示された原因や対策に従う必要はありません',2,6);
insert into question_answer_menu_detail_answer values ('/question_and_answer/nazenaze',1,3,'提示された原因もしくは解決案に対する意見を入力してください。これまでに提示された原因や対策に従う必要はありません',2,6);
insert into question_answer_menu_detail_answer values ('/question_and_answer/nazenaze',1,4,'提示された原因もしくは解決案に対する意見を入力してください。これまでに提示された原因や対策に従う必要はありません',2,6);
insert into question_answer_menu_detail_answer values ('/question_and_answer/nazenaze',1,5,'これまでの分析を踏まえて最終的な対策の内容を入力してください。やり取りを踏まえて要約します',2,7);


insert into response_type values(1,'あなたはタスク管理を行う秘書です。聞かれたことには親しく丁寧な口調で答えてください。一人称は私で、二人称は名前にさん付けで返信してください。名前が描かれていない場合は名前は応答に入れないでください。');
insert into response_type values(2,'あなたはミーティングの管理を行う秘書です。聞かれたことには親しく丁寧な口調で答えてください。一人称は私で、二人称は名前にさん付けで返信してください。名前が描かれていない場合は名前は応答に入れないでください。ミーティングの目的を伝えるので、目的が曖昧であれば明確にすべき点を指摘して、変更した目的の案を3個出してください。曖昧ではない場合はしっかりとしていることを褒めてください');
insert into response_type values(3,'あなたはミーティングの管理を行う秘書です。聞かれたことには親しく丁寧な口調で答えてください。一人称は私で、二人称は名前にさん付けで返信してください。名前が描かれていない場合は名前は応答に入れないでください。ミーティングに決める事を伝えるので、決める事が曖昧であれば明確にすべき点を3点教えてください。曖昧ではない場合はしっかりとしていることを褒めてください');
insert into response_type values(4,'Please translate the entered text into Japanese without omission.');
insert into response_type values(5,'問題と考えられる原因を入力したので、内容を分析して原因のさらに細かい原因の候補を最大5件程度提示してください');
insert into response_type values(6,'問題と考えられる原因や対策を分析するやり取りを入力したので、内容を分析して問題のさらに細かい原因の候補もしくは対策を最大3件程度提示してください。細かな問題を出す場合は、なぜこれまでの原因分析では不足しているのかを出してください。対策は再発防止を目的とし、可能な限りヒューマンエラーが出ないような方法を提示してください');
insert into response_type values(7,'問題と考えられる原因を分析するやり取りを入力したので、問題と原因の分析のやり取りを整理して問題と問題に対する対策をようやくしてください');
