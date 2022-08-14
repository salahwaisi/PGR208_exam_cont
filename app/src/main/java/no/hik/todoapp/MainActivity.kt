package no.hik.todoapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import no.hik.todoapp.helpers.DecisionMakerHelper
import no.hik.todoapp.helpers.TodoHelper
import no.hik.todoapp.models.DecisionMakerResult
import no.hik.todoapp.models.Todo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // use arrayadapter and define an array
        val arrayAdapter: ArrayAdapter<*>

        // Read the file and open the TODOs
        var todos = TodoHelper.getSavedTodos(applicationContext);

        // access the listView from xml file
        var mListView = findViewById<ListView>(R.id.todolist)
        arrayAdapter = ArrayAdapter(
            this,
            android.R.layout.simple_list_item_1, todos
        )
        mListView.adapter = arrayAdapter

        val btnAddTodo = findViewById<Button>(R.id.btnAddTodo)
        btnAddTodo.setOnClickListener {

            addTodo()
            arrayAdapter.notifyDataSetChanged()
        }
    }

    fun addTodo() {
        val todoText = "Take a walk"
        // Get a result from decision maker
        var decision = DecisionMakerHelper.getDecision(todoText, applicationContext)
        //var decision = DecisionMakerResult.Neutral
        val todo = Todo(kotlin.math.abs((0..999999999999).random()).toString(),
            todoText, decision);

        TodoHelper.saveTodo(todo, applicationContext);
    }

    fun moveToNextDay(view: View) {
        val navigateIntent = Intent(this, MoveTodosToNextDay::class.java)
        startActivity(navigateIntent);
    }
}