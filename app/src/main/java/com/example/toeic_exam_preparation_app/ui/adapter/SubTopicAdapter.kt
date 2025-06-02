package com.example.toeic_exam_preparation_app.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.toeic_exam_preparation_app.data.remote.SubTopic
import com.example.toeic_exam_preparation_app.R

class SubTopicAdapter(private var itemList: List<SubTopic>) : RecyclerView.Adapter<SubTopicAdapter.TopicViewHolder>() {

    private var inflater: LayoutInflater? = null

    class TopicViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name: TextView = itemView.findViewById(R.id.name)
        val number: TextView = itemView.findViewById(R.id.number)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TopicViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_sub_topic, parent, false)
        inflater = LayoutInflater.from(parent.context)
        return TopicViewHolder(view)
    }

    override fun onBindViewHolder(holder: TopicViewHolder, position: Int) {
        holder.name.text = itemList[position].name
        holder.number.text = (position+1).toString()
    }

    fun updateData(newData : List<SubTopic>) {
        itemList = newData
        notifyDataSetChanged()
    }

    override fun getItemCount() = itemList.size
}