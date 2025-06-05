import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.example.toeic_exam_preparation_app.R
import com.example.toeic_exam_preparation_app.data.remote.Part
import com.google.android.flexbox.FlexboxLayout

class ExamDescAdapter(private var itemList: List<Part>) :
    RecyclerView.Adapter<ExamDescAdapter.ExamDescViewHolder>() {

    class ExamDescViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val partNumber: TextView = itemView.findViewById(R.id.partNumber)
        val questionNumber: TextView = itemView.findViewById(R.id.questionNumber)
        val tagContainer: FlexboxLayout = itemView.findViewById(R.id.flexBox)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ExamDescViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_part, parent, false)
        return ExamDescViewHolder(view)
    }

    override fun getItemCount() = itemList.size

    override fun onBindViewHolder(holder: ExamDescViewHolder, position: Int) {
        val part = itemList[position]
        holder.partNumber.text = part.name
        holder.questionNumber.text = "${part.questionNumber} questions"
        holder.tagContainer.removeAllViews()

        val inflater = LayoutInflater.from(holder.itemView.context)

        part.tags.forEach { tag ->
            val tagView = TextView(holder.itemView.context).apply {
                text = tag.name
                setPadding(20, 10, 20, 10)
                setTextColor(ContextCompat.getColor(context, R.color.colorPrimary))
                background = ContextCompat.getDrawable(context, R.drawable.border_primary2)
                layoutParams = FlexboxLayout.LayoutParams(
                    ViewGroup.LayoutParams.WRAP_CONTENT,
                    ViewGroup.LayoutParams.WRAP_CONTENT
                ).apply {
                    setMargins(0, 0, 16, 16)
                }
                typeface = Typeface.SERIF
            }
            holder.tagContainer.addView(tagView)
        }
    }

}
