package com.example.mytaskapp

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class TasksAdapter(private var task:List<Task>,context: Context):RecyclerView.Adapter<TasksAdapter.TaskViewHolder>(){

     class TaskViewHolder(itemView: View):RecyclerView.ViewHolder(itemView){
         val titleTextView:TextView =itemView.findViewById(R.id.titleTextview)
         val contentTextView:TextView =itemView.findViewById(R.id.contentTextview)
         val updateButton:ImageView =itemView.findViewById(R.id.updateButton)

     }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
         val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
        return TaskViewHolder(view)

    }

    override fun getItemCount(): Int  = task.size

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        val task = task[position]
        holder.titleTextView.text =task.title
        holder.contentTextView.text = task.content

        holder.updateButton.setOnClickListener {
            val intent = Intent(holder.itemView.context,UpdateTaskActivity::class.java).apply {
                putExtra("task_id",task.id)
            }
            holder.itemView.context.startActivity(intent)
        }


    }

     fun refreshData(newTasks: List<Task>){
         task = newTasks
         notifyDataSetChanged()
     }

}



//import android.content.Context
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import android.widget.TextView
//import androidx.recyclerview.widget.RecyclerView
//
//class NoteAdapter(private var task:List<Task>,context: Context):RecyclerView.Adapter<TasksAdapter.TaskViewHolder>(){
//
//    private val db: TaskDatabaseHelper = TaskDatabaseHelper(context)
//
//    class TaskViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
//        val titleTextView:TextView=itemView.findViewById(R.id.titletextview)
//        val contentTextView:TextView=itemView.findViewById(R.id.contenttextview)
//
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
//        val view = LayoutInflater.from(parent.context).inflate(R.layout.task_item,parent,false)
//        return  TaskViewHolder(view)
//    }
//
//    override fun getItemCount(): Int =task.size
//
//
//    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
//        val note= task[position]
//        holder.titleTextView.text= note.title
//        holder.contentTextView.text= note.content
//
//
//
//    }
//
//    fun refreshData(newNote:List<Task>){
//        task= newNote
//        notifyDataSetChanged()
//    }
//}