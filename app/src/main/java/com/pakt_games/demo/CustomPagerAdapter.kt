package com.pakt_games.demo

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter


class CustomPagerAdapter(manager: FragmentManager): FragmentPagerAdapter(manager) {

    private val fragments = ArrayList<Fragment>()
    private val titles = ArrayList<String>()

    override fun getItem(position: Int) : Fragment = fragments[position]

    override fun getCount(): Int = fragments.size

    override fun getPageTitle(position: Int): CharSequence =titles[position]

    fun addFragment(fragment: Fragment) {
        fragments.add(fragment)
        notifyDataSetChanged()
    }

    fun removeFragment() {
        if(fragments.size==0)
            return
        fragments.removeAt(fragments.size-1)
        titles.removeAt(titles.size-1)
        notifyDataSetChanged()
    }
}