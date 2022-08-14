package no.hik.todoapp.helpers

import android.content.Context
import no.hik.todoapp.models.Todo
import no.hik.todoapp.models.DecisionMakerResult
import org.json.JSONArray
import java.io.File
import java.io.FileOutputStream

class TodoHelper : ITodoHelper {
    companion object {
        fun getSavedTodos(context: Context): Array<Todo> {
            val todos = arrayOf(
                Todo(kotlin.math.abs((0..999999999999).random()).toString(),
                    "Take a walk", DecisionMakerResult.Neutral)
            )

            val fileName = "todos.json"
            var file = File(fileName)

            if (FileHelper.fileExist(fileName)) {
                val fileContent = file.inputStream().read()
            } else {
                // If file does not exist, save it
                val fileContents = JSONArray(todos).toString()
                context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
                    it.write(fileContents.toByteArray())
                }
            }

            return todos;
        }

        fun saveTodo(todo: Todo, context: Context) {
            var todos = getSavedTodos(context)
            todos += todo

            val fileContents = JSONArray(todos).toString()
            FileHelper.saveFile(fileContents, "todos.json", context)
        }
    }

}