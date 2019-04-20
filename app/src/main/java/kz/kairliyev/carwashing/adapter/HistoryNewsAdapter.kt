package kz.kairliyev.carwashing.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.history_item.view.*
import kz.kairliyev.carwashing.R
import kz.kairliyev.carwashing.models.HistoryNews

class HistoryNewsAdapter(val items: ArrayList<HistoryNews>) :
    RecyclerView.Adapter<HistoryNewsAdapter.HistoryNewsViewHolder>() {


    fun addHistoryNews(itemss: List<HistoryNews>) {
        items.addAll(itemss)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): HistoryNewsViewHolder {
        val view = LayoutInflater.from(p0.context).inflate(R.layout.history_item, p0, false)
        return HistoryNewsViewHolder(view)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(p0: HistoryNewsViewHolder, p1: Int) {
        p0.title.text = items[p1].title
        Picasso.get().load(items[p1].image).into(p0.image)
        p0.price.text = items[p1].price
    }


    inner class HistoryNewsViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val title = view.name_cw
        val image = view.history_logo_iv
        val price = view.price_cw
    }
}