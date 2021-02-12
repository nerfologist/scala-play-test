package models

case class Task(id: Int, name: String)

object Task {
    private var taskList: List[Task] = List()

    def all: List[Task] = {
        taskList
    }

    def create(taskName: String): Task = {
        val newId: Int = (if (taskList.length > 0) taskList.last.id else 0) + 1
        val newTask = Task(newId, taskName)
        taskList = taskList ++ List(newTask)
        newTask
    }

    def destroy(taskId: Int): Task = {
        val taskToDelete = taskList.find(task => task.id == taskId).get
        taskList = taskList.filterNot(task => task.id == taskId)
        taskToDelete
    }
}