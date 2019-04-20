package kz.kairliyev.carwashing.adapter

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.post_list_item.view.*
import kz.kairliyev.carwashing.R
import kz.kairliyev.carwashing.models.News
import kz.kairliyev.carwashing.views.activities.ActivityNewsItem

class NewsAdapter(val items: ArrayList<News>) : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {


    fun addNews(itemss: List<News>) {
        items.addAll(itemss)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): NewsViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.post_list_item, p0, false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: NewsViewHolder, p1: Int) {
        p0.postTitle.text = items.get(p1).title
        Picasso.get().load(items.get(p1).image).into(p0.newsImage)
        p0.cardView.setOnClickListener {
            //            p0.intent.launchUrl( it.context, Uri.parse(items.get(p1).form))
            val intent = Intent(it.context, ActivityNewsItem::class.java)
            val extras = Bundle()
            extras.putString("e_name", items.get(p1).title)
            extras.putString("e_des", items.get(p1).desc)
            extras.putString("e_image", items.get(p1).image)
            intent.putExtras(extras)

            p0.itemView.context.startActivity(intent)

        }
    }


    inner class NewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val postTitle = view.post_list_item_tv
        val newsImage = view.news_list_item_iv
        val cardView = view.news_card_view

    }
}