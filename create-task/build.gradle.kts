val taskDescription = "Projects and Tasks"
// ProjectExtensions.kt に task 拡張関数が定義されている
// fun Project.task(name: String, configuration: Task.() -> Unit): DefaultTask
// DefaultTask ではなく、タスクのタイプを指定したい場合は
// task<Copy>("helloCopy") { ... } のような風に定義できる
val hello = task("hello") {
    description = "Simple print Hello World"
    group = taskDescription

    doLast {
        println("Hello World!")
    }
}

val intro = task("intro") {
    description = "DependsOn Sample Task"
    group = taskDescription

    dependsOn(hello)

    doLast {
        println("I'm Gradle")
    }
}

