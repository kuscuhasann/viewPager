package com.pakt_games.demo.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager.widget.ViewPager
import com.pakt_games.demo.CustomPagerAdapter
import com.pakt_games.demo.R
import com.pakt_games.demo.model.User
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_home.*


class HomeFragment : Fragment() {

    private var index: Int = 0
    val user1=User("1","Hasan")
    val user2=User("2","Bedri")
    val user3=User("3","Beren")
    val list : ArrayList<User> = arrayListOf(user1,user2,user3)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val adapter = CustomPagerAdapter(childFragmentManager)
        pagerHasan.adapter = adapter

        if (list!=null) {
            for (i in 0..list.size-1) {
                createFragment(i,adapter)
            }
        }
        buttonAdd.setOnClickListener {
            val user4 = User("4","Deneme")
            list.add(user4)
            val fragment = AddFragment.newInstance(list.size-1,list)
            adapter.addFragment(fragment)

        }

        buttonRemove.setOnClickListener {
            index=index.inc()
            adapter.removeFragment()
            index = index.dec()
            pagerHasan.currentItem = index.dec()
        }
    }

    private fun createFragment(i : Int, adapter: CustomPagerAdapter) {
        index=index.inc()
        val fragment = AddFragment.newInstance(i,list)
        adapter.addFragment(fragment)
        pagerHasan.currentItem = index
    }

}