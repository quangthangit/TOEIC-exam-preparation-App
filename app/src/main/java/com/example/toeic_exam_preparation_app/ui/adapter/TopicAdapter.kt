package com.example.toeic_exam_preparation_app.ui.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toeic_exam_preparation_app.R
import com.example.toeic_exam_preparation_app.data.remote.Topic
import com.example.toeic_exam_preparation_app.ui.activity.ExamDescActivity
import com.example.toeic_exam_preparation_app.ui.activity.SubTopicActivity

class TopicAdapter(private var itemList: List<Topic>) :
    RecyclerView.Adapter<TopicAdapter.TopicViewHolder>() {

    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val des: TextView = itemView.findViewById(R.id.des)
        val totalWord: TextView = itemView.findViewById(R.id.totalWord)
        val totalLesson: TextView = itemView.findViewById(R.id.totalLesson)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_topic, parent, false)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.des.text = itemList[position].des
        holder.totalWord.text = buildString {
            append(" • ")
            append(itemList[position].totalWord.toString())
            append(" Lessons")
        }
        holder.totalLesson.text = buildString {
            append(" • ")
            append(itemList[position].totalLesson.toString())
            append(" Words")
        }
        holder.itemView.setOnClickListener {
            val context = holder.itemView.context
            val intent = Intent(context, ExamDescActivity::class.java)
            intent.putExtra("vocabularyTopicId", itemList[position].vocabularyTopicId)
            intent.putExtra("nameTopic", itemList[position].name)
            intent.putExtra("totalWord", itemList[position].totalWord)
            intent.putExtra("totalLesson", itemList[position].totalLesson)
            context.startActivity(intent)
        }
    }

    fun updateTopics(newTopics: List<Topic>) {
        itemList = newTopics
        notifyDataSetChanged()
    }

    override fun getItemCount() = itemList.size
}