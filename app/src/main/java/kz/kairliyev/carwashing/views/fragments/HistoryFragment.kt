package kz.kairliyev.carwashing.views.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_history.*

import kz.kairliyev.carwashing.R
import kz.kairliyev.carwashing.adapter.HistoryNewsAdapter
import kz.kairliyev.carwashing.models.HistoryNews

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class HistoryFragment : Fragment() {

    lateinit var mContext: Context
    var newsss: List<HistoryNews> = listOf()
    private val adapterr by lazy { HistoryNewsAdapter(ArrayList()) }


    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_history, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = view.context

        val ll = arrayListOf<HistoryNews>(
            HistoryNews("https://photos-mt.kcdn.kz/bd/bd6396f6-4c57-4d08-8376-b12bd49e9c21/6-760x450.jpg", "AutoService Fast", "Позавчера 10:00", "1500tg" ),
            HistoryNews("https://biznesua.com.ua/wp-content/uploads/2017/02/STO.jpg", "СТО Шевченко", "Вчера 12:00", "2000tg" ))
        adapterr.addHistoryNews(ll)

        history_recycler_view.apply {
            layoutManager = LinearLayoutManager(mContext)
            adapter = adapterr
        }

    }


    companion object {
        fun newInstance(): HistoryFragment = HistoryFragment()
    }

}
