package kz.kairliyev.carwashing.views.fragments


import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_news.*
import kz.kairliyev.carwashing.R
import kz.kairliyev.carwashing.adapter.NewsAdapter
import kz.kairliyev.carwashing.models.News

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 *
 */
class NewsFragment : Fragment() {

    lateinit var mContext: Context
    var newsss: List<News> = listOf()
    private val adapterr by lazy { NewsAdapter(ArrayList()) }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val view = inflater.inflate(R.layout.fragment_news, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mContext = view.context

        val ll = arrayListOf<News>(
            News("Как мыть машину", "Шаг первый: окатываем автомобиль сверху вниз большим количеством воды. Большую часть воды льем на кузов, колеса – это, обычно, самые загрязненные места. Стекла требуют меньшего количества влаги. Таким образом, мы сбиваем с поверхности кузова первый слой грязи – различные органические частицы и силикаты. Шаг второй: «намыливаем» машину автомобильным шампунем – он нужен для снятия второго слоя, состоящего из сажи, гудрона и смеси выхлопных газов с пылью. Для этого используем пористую губку, обильно смачивая ее в разведенной шампунем воде. Вода в ведре должна быть теплая, чтобы моющее средство нормально растворилось, и образовался пригодный для мытья состав. Шаг третий: даем шампуню оказать свое воздействие на грязь (время варьируется в зависимости от степени загрязненности поверхностей). В это время можно при помощи ёршика удалить грязевые отложения с колесных дисков. \n" +
                    "\n" +
                    "Источник: https://avtoexperts.ru/article/kak-pravil-no-my-t-avtomobil/", "Пушкин", "https://zovmarketing.com/wp-content/uploads/2018/02/%D1%80%D0%B5%D0%BA%D0%BB%D0%B0%D0%BC%D0%B0-%D0%A1%D0%A2%D0%9E.jpg"),
            News("Как открыть автосервис СТО с нуля?", "Грамотный подход к тому, как открыть автосервис с нуля, подразумевает определение специализации, составление списка предоставляемых услуг, наличие стартового капитала, разработку рационального бизнес-плана. В него следует включить прогнозируемые риски, расчет финансовых затрат, результаты прибыльности, установочную стоимость техобслуживания, нормо-часов. Перед тем как открыть СТО с нуля, нужно четко определить направленность развития, провести анализ целевой аудитории и специфики работы конкурентов. Это позволит отыскать незанятую нишу, избежать ошибок планирования технико-экономических процессов, спрогнозировать способы увеличения оборота. Стоит рассматривать автосервис как бизнес на предмет перспективности, прибыльности и актуальности.", "Пушкин", "https://fingramm.ru/wp-content/uploads/2016/10/2-4.jpg"))

        adapterr.addNews(ll)

        posts_main_activity_rv.apply {
            layoutManager = LinearLayoutManager(mContext)
            adapter = adapterr
        }

    }
}