package com.kamarcoding.bubblebottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private var selectFragment : Fragment? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        supportFragmentManager.beginTransaction().replace(R.id.container, HomeFragment()).commit()
        navigation.setNavigationChangeListener { view, position ->
            when(position){
                0 -> selectFragment = HomeFragment()
                1 -> selectFragment = SearchFragment()
                2 -> selectFragment = FavFragment()
                3 -> selectFragment = ShopFragment()
                4 -> selectFragment = UserFragment()

            }

            selectFragment?.let {
                supportFragmentManager.beginTransaction().replace(R.id.container,
                    it
                ).commit()
            }

        }
    }
}