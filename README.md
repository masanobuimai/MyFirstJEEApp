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
