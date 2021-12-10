package com.example.bookapp_usingroom

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.bookapp_usingroom.data.Books

class BooksAdapter: RecyclerView.Adapter<BooksAdapter.MyViewHolder>() {
    var bookList= emptyList<Books>()

    class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        return  MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.customfile,parent,false))
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem=bookList[position]
        holder.itemView.findViewById<TextView>(R.id.id_txt).text=currentItem.book_id.toString()
        holder.itemView.findViewById<TextView>(R.id.title_txt).text=currentItem.title
        holder.itemView.findViewById<TextView>(R.id.year_txt).text=currentItem.year.toString()
    }

    override fun getItemCount(): Int {
        return bookList.size
    }
    fun setData(books:List<Books>)
    {
        this.bookList=books
        notifyDataSetChanged()
    }
}