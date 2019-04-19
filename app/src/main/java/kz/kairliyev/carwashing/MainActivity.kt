package kz.kairliyev.carwashing

import android.content.Context
import android.os.Bundle
import android.view.View
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_main.*
import kz.kairliyev.carwashing.views.fragments.HistoryFragment
import kz.kairliyev.carwashing.views.fragments.MapFragment

class MainActivity : AppCompatActivity() {

    internal val fragment1: Fragment = MapFragment()
    internal val fragment2: Fragment = HistoryFragment()
//    internal val fragment3: Fragment = HistoryFragment()
//    internal val fragment4: Fragment = CabinetFragment()
    internal val fm = supportFragmentManager
    internal var active = fragment1

    lateinit var mContext: Context

    lateinit var mAuth: FirebaseAuth


    private val mOnNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_map -> {
                fm.beginTransaction().hide(active).show(fragment1).commit()
                active = fragment1
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_history -> {

                fm.beginTransaction().hide(active).show(fragment2).commit()
                active = fragment2
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_news -> {
//                fm.beginTransaction().hide(active).show(fragment3).commit()
//                active = fragment3
                return@OnNavigationItemSelectedListener true
            }

            R.id.navigation_cabinet -> {
//                fm.beginTransaction().hide(active).show(fragment4).commit()
//                active = fragment4
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        mContext = this
//        val toolbar = findViewById<androidx.appcompat.widget.Toolbar>(R.id.toolbar)
//        setSupportActionBar(toolbar)

        mAuth = FirebaseAuth.getInstance()

        val navigation = findViewById<View>(R.id.bottom_nav) as BottomNavigationView
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
//
//        fm.beginTransaction().add(R.id.container, fragment4, "4").hide(fragment4).commit()
//        fm.beginTransaction().add(R.id.container, fragment3, "3").hide(fragment3).commit()
        fm.beginTransaction().add(R.id.container, fragment2, "2").hide(fragment2).commit()
        fm.beginTransaction().add(R.id.container, fragment1, "1").commit()

    }
}

