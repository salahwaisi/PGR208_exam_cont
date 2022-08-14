package no.hik.todoapp.helpers

import android.content.Context

interface ITodoHelper {
    companion object ITodoHelping: ITodoHelper {
        fun getSavedTodos(context: Context): Array<String> {
            val todos = arrayOf(
                "Take a walk"
            )

            return todos;
        }
    }
}