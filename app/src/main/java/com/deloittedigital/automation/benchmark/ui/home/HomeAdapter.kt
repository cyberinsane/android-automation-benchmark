package com.deloittedigital.automation.benchmark.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deloittedigital.automation.benchmark.R
import com.deloittedigital.automation.benchmark.ui.Movies

class HomeAdapter : RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {
    private var movieList: List<Movies> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.movies_list, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {

        holder.tvMovieName.text = movieList[position].title
        holder.image.text = movieList[position].body

    }

    fun setMovieListItems(movieList: List<Movies>) {
        this.movieList = movieList;
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMovieName: TextView = itemView.findViewById(R.id.title)
        val image: TextView = itemView.findViewById(R.id.image)

    }
}