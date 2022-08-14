package no.hik.todoapp.helpers;

import android.content.Context
import no.hik.todoapp.models.Todo
import org.json.JSONArray
import java.io.File

class FileHelper {
    companion object {
        fun fileExist(filename: String): Boolean {
            var file = File(filename)

            return file.exists();
        }

        fun saveFile(fileContents: String, fileName: String, context: Context) {
            context.openFileOutput(fileName, Context.MODE_PRIVATE).use {
                it.write(fileContents.toByteArray())
            }
        }
    }
}
