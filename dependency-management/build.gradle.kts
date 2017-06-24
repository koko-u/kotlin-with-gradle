group = "jp.co.kokou.sample"
version = "1.0-SNAPSHOT"

description = "Chapter8. Dependency Management Basics"

// javaプラグインの適用方法
// apply は project インスタンスにある普通の関数、一方で、ProjectExtensions.kt にも
// fun Project.apply(crossinline block: ObjectConfigurationAction.() -> Unit): Unit が定義されているので区別はつかない
//
// この例では、plugin も ObjectConfigurationAction にある普通のメソッド
// ObjectConfigurationAction には、文字列として pluginId を渡す以外に
// プラグインのクラスをそのまま渡すメソッドもあるので
// plugin(JavaPlugin::class.java) とも書ける
// kotlin の reified を使った拡張が ObjectConfigurationActionExtensions.kt に定義されているので
// plugin<JavaPlugin>() とも書ける

apply {
    plugin("java")
}

repositories {
    mavenCentral()
}

// 依存関係の設定
// fun Project.dependencies(configuration: DependencyHandlerScope.() -> Unit): Unit
// ここで、DependencyHandlerScope が Kotlin Script として用意されている
//
// configuration を文字列で指定して "compile".invoke(...) とするか、
// compile() コンフィギュレーションなどは用意されているので、それを使う
// ConfigurationExtensions.kt にく使用するものは用意されている
// fun DependencyHandler.compile(dependencyNotation: Any): Dependency など色々な指定ができる
// 実際には、DependencyHandler の持つ、依存として add("compile", ...) のように追加している
//
// groovy の api は group: 'org.hibernate' などの map による DSL だが、kotlin は名前付き引数による DSL になっている
//
dependencies {
    compile(group = "org.hibernate", name = "hibernate-core", version = "3.6.7.Final")
    testCompile("junit:junit:4.+")
}