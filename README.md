MyFirstJEEApp
=============


## 最初の一歩
- _Java EE Moduleを作る_
  - _web.xmlが自動で作られるけど，なんでか 2.5 なので，3.0 に直しておく_
  - Java Moduleで作るとfacetを選べるので，そこで Web Application 3.0 とか指定できる
  - JPAやJSF，CDIも追加できるけど，ダウンロードするライブラリがイマイチな感じ。
  - facet追加するときに "Set up library later"（あとで設定する）を選べばいいんだけど，なんでかCDIにはその項目がない
  - そもそもCDIはfacetを追加する必要があるのか？って話もある（単にライブラリの追加でしかないから）
- Project StructureのModule->AddでEJBとかJPAなどのfacetを追加するとJavaEE5のjavaee.jarを取ってくるので，まだやっちゃダメ
  - Module->Dependencies->AddでLibraryをfrom mavenから "javax:javaee-api:6.0" を追加しようも，なんでかダウンロードに失敗する。:-(
  - しかたないので，[このへん](http://mvnrepository.com/artifact/javax/javaee-api/6.0) から javaee-api-6.0.jar をゲット
  - ./lib あたりに配置してライブラリに追加（scopeはprovided）
  - **Module->Dependencies->AddでLibraryをfrom mavenから "javax:javaee-web-api:6.0" を追加するとうまく行く**
    （Web Profileっぽいけど，JSF/EJB3/JPA/CDIを使う分にはこれで十分）
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

## はじめてのEJB3.1
- EJB facetは要らない（EJB3.0だからかな？）
- 普通のクラスを作る感覚で，適当な場所にEJB3のセッションビーンを作る（statelessでいいでしょ）
- それはそうと，@PersistenceContext の unitName って補完効かないのよね。:-(

## はじめてのJSF2.2
- Project StructureのModule->Web->AddでJSFを追加（faceletはEnabledにしとく）
  - 「JSFのライブラリ無いよ」と言われるが javaee-api-6.0.jar を設定済みなので無視して言い（エラーにならない）
- web.xmlにFacesServletなどのJSFの設定を加える
- index.jspを消して，代わりにindex.xhtmlを作る
- まずはJSFの管理ビーンを作ってみる

## はじめてのCDI1.0
- Project StructureのModuleにCDI Facetを追加しなくても良い（javaee-api-6.0.jarに含まれているし，ムリに追加するのが難しい）
  - 要るのかどうかわからないけど，./web/WEB-INF/beans.xml を追加しとく（消したらエラーになったから，要るんだこれ）
- JSFの管理ビーンをCDIに変えていく
  - @ManagedBean を @Model @Name(value="...") に変えていく（@Model を消したら，動いているようで動かなくなった）
  - @EJB を @Inject に変える（@EJBのままでも使えた）
- **CDIって使った方がいいのかよくわからん。(´･ω･`)**

## はじめてのPrimFaces
- Project StructureのModule->Web->AddでPrimFacesを追加（ライブラリのダウンロード先は ./lib でいいや）
  - とってきたPrimFacesのバージョンは 3.4.1 （これが最新なのかどうかは知らない）
  - scopeがcompileで設定されるので，それはそのまま
  - artifactにPrimFacesを加える（FIXボタンを押せば，勝手に ./WEB-INF/lib に放り込まれる）
- コンテンツはNetBeansのサンプルの丸パクリ


## 微調整
- 極論言うと，JSF使ったとしても実はweb.xmlは要らない
  - FaceServletそのものはアノテーションで宣言してあるみたいで，いちいちweb.xmlに宣言しなくても動いた
    （どうやら，/faces/* で設定済みっぽい）
  - ただし，welcome-fileの設定はあったほうがいい（faces/index.xhtmlとか）
- persistence.xmlにプロパティ設定しておくと，JPAがどんなSQL投げたかログで確認できる
  - EclipseLinkの場合は，eclipselink.logging.level.sqlをFINEに，eclipselink.logging.parametersをtrueで良い感じにSQLがログされる
  - [EclipseLink/Examples/JPA/Logging](http://wiki.eclipse.org/EclipseLink/Examples/JPA/Logging)
- glassfishでカバレッジ取る場合は，Coverage Runnerを **JaCoCo** にしないとダメだった


## Glassfishの代わりにTomEEに載せてみる
- TomEEはGlassfishと違い，hsqldbとOpenJPAが含まれているので，メタデータもその辺に合わせる
  - データソースは，META-INF/openejb.xml に記述しておき，warファイルに一緒にアーカイブするだけで良い（楽ちん）
  - persistence.xmlはそのままだとスキーマを生成してくれないので，OpenJPAでEclipseLinkの"ddl-generataion"に相当するプロパティ
    (openjpa.jdbc.SynchronizeMappings) を設定しておく
  - persistence.xmlにEclipseLinkとOpenJPAの設定値が混在していても大丈夫そう。
  - Project StructureのJPA facetにある "Default JPA provider" に大した意味はなさそう（<No Default>でも動いた）

- TomEEのhsqldbの実体は，$TOMEE_HOME/bin にできたっぽい
- TomEEだと，Coverage Runnerが **IDEA** でも平気だった（Samplingだけじゃなく，Tracingもできる）

### Glassfishと比べたTomEEの地味に良いところ
- Setting->Application Servers で登録したときの Libraries が充実している
- TomEEだと以下のライブラリが登録される
  - **javaee-api-6.0.5-tomcat.jar** （これ重要）
  - jsp-api.jar
  - servlet-api.jar
- Glassfishの場合，こうなる（JSFとかCDIとかJPAとか肝心なのが足りない）
  - javax.ejb.jar
  - javax.servlet-api.jar
  - javax.servlet.jsp-api.jar

- ちなみに，NetBeansの「ツール→サーバー」に登録されているGlassfishのライブラリは以下の通り。
  （NetBeans，というかJavaEE SDKか...ライブラリ分割しすぎ）
  - javax.servlet-api.jar
  - javax.servlet.jsp-api.jar
  - javax.persistence.jar
  - webservices-api-osgi.jar
  - javax.servlet.jsp.jstl-api.jar
  - jersey-core.jar
  - javax.security.jacc.jar
  - jaxm-api.jar
  - javax.security.auth.message.jar
  - javax.transaction.jar
  - javax.enterprise.deploy.jar
  - javax.annotation.jar
  - webservices-osgi.jar
  - javax.faces.jar
  - jaxb-osgi.jar
  - javax.resource.jar
  - javax.management.j2ee.jar
  - jaxb-api-osgi.jar
  - javax.ejb.jar
  - javax.el-api.jar
  - weld-osgi-bundle.jar
  - javax.mail.jar
  - javax.jms.jar
  - bean-validator.jar

何が言いたいのかというと，IntelliJでJavaEEプロジェクトを作成したときに，Project Structure->Modules->DependenciesでAdd->Library->Application Server LibrariesでGlassfishを指定しても，いろいろライブラリが足りなくて困る（ホントに欲しいのは，javaee-api-6.0.jarみたいな全部入りのやつ）。

そうゆう意味ではNetBeansは「ワカッテル」...というかズルいｗ

