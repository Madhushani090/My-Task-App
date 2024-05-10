package com.example.mytaskapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.InputBinding
import android.widget.Toast
import com.example.mytaskapp.databinding.ActivityAddTaskBinding
import com.example.mytaskapp.databinding.ActivityMainBinding

class AddTaskActivity : AppCompatActivity() {

    private lateinit var  binding: ActivityAddTaskBinding
    private lateinit var db:TaskDatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = TaskDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title =binding.titleEditText.text.toString()
            val content =binding.contentEditText.text.toString()
            val task =Task(0,title,content)
            db.insertTask(task)
            finish()
            Toast.makeText(this,"Task Added",Toast.LENGTH_SHORT).show()
        }
    }
}