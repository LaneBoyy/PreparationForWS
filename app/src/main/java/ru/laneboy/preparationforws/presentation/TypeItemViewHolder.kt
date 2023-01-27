package ru.laneboy.preparationforws.presentation

import android.view.View
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import ru.laneboy.preparationforws.R

class TypeItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
    val ivTypeImage = view.findViewById<ImageView>(R.id.iv_type_image)
    val flImageContainer = view.findViewById<FrameLayout>(R.id.frameLayout)
    val tvTypesName = view.findViewById<TextView>(R.id.tv_types_name)
}