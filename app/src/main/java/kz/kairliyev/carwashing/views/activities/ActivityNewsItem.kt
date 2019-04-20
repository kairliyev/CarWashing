package kz.kairliyev.carwashing.views.activities

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_news_item.*
import kz.kairliyev.carwashing.R

class ActivityNewsItem : AppCompatActivity() {

    lateinit var mContext: Context

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            android.R.id.home -> {
                onBackPressed()
                return true
            }
        }

        return super.onOptionsItemSelected(item)

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_item)
        mContext = this

        val intent = intent
        val extras = intent.extras
        val name = extras?.getString("e_name")
        val des = extras?.getString("e_des")
        val image = extras?.getString("e_image")

        supportActionBar?.title = ""

        Picasso.get().load(image).into(news_item_titlee_iv)
        news_item_title_tv.text = name
        news_item_des_tv.text = des

    }

}