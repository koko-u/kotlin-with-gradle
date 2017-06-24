import com.dorongold.gradle.tasktree.TaskTreeTask

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

plugins {
    id("com.dorongold.task-tree") version "1.3"
}

tasks.withType<TaskTreeTask> {
    isNoRepeat = true
    impliesSubProjects = true
}

repeat(4) { counter ->
    task("task$counter") {
        description = "Count number $counter task"
        group = taskDescription

        if (counter > 0) {
            dependsOn("task${counter-1}")
        }
        doLast {
            println("I'm task number $counter")
        }
    }
}

task("myTask") {
    ext {
        set("myProperty", 100)
    }
}

task("printTaskProperties") {
    doLast {
        tasks.getByName("myTask") {
            val myProperty: Int by ext
            println(myProperty)
        }
    }
}
