MyFirstJEEApp
=============


## 最初の一歩
- Java EE Moduleを作る
  - web.xmlが自動で作られるけど，なんでか 2.5 なので，3.0 に直しておく
- Project StructureのModule->AddでEJBとかJPAなどのfacetを追加するとJavaEE5のjavaee.jarを取ってくるので，まだやっちゃダメ
  - Module->Dependencies->AddでLibraryをfrom mavenから "javax:javaee-api:6.0" を追加しようも，なんでかダウンロードに失敗する。:-(
  - しかたないので，[このへん](http://mvnrepository.com/artifact/javax/javaee-api/6.0) から javaee-api-6.0.jar をゲット
  - ./lib あたりに配置してライブラリに追加（scopeはprovided）
- せっかくだから artifact で warファイル作って，glassfish指定して疎通確認しとく

## はじめてのServlet3.0
- WebツールウィンドウからServletを作ると，Servlet2.5由来のサーブレットになるので，普通にクラスを作る

## はじめてのJPA2.0
- Project StructureのModule->AddでJPAを追加
  - JPA Providerは EclipseLink，persistence.xml は ./src/META-INF に作る（放っておくと ./META-INF に作る）
- persistence.xmlは空っぽなので，最低限必要な部分を追加
  - 追加した persistence.xml は artifact でも war ファイルに含めるように設定しておく（忘れがち）
- JPAを使うには，glassfish側にデータソースを定義しないとダメなのだが，管理ツールを使ったり，DBを用意したりとメンドウも多い
  - ...ので，DBは別に用意せず，glassfish内に Embedded Derby を作ってしまう
  - glassfish-resources.xmlに接続プールやデータソースを定義して，asadmin経由でglassfishに登録することができる
  - glassfishに埋め込んだ Embedded Derby の実体は，$GLASSFISH_HOME/glassfish/domains/domain1/config にできあがる
- JPA EntityもJPAツールウィンドウから作るとややこしいことになるので，普通にクラスとして作る
- **そういえば，JPA Entityの単体テストってどうやってやるんだろう？**

## はじめてのEJB3.0
