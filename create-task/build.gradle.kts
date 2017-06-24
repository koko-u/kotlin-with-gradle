
// ProjectExtensions.kt に task 拡張関数が定義されている
// fun Project.task(name: String, configuration: Task.() -> Unit): DefaultTask
// DefaultTask ではなく、タスクのタイプを指定したい場合は
// task<Copy>("helloCopy") { ... } のような風に定義できる
task("hello") {
    description = "Simple print Hello World"
    group = "Projects and Tasks"
    
    doLast {
        println("Hello World!")
    }
}

task<Copy>("helloCopy") {

}