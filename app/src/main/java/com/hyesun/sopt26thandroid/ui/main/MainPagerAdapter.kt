package com.hyesun.sopt26thandroid.ui.main

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.hyesun.sopt26thandroid.ui.book.BookFragment
import com.hyesun.sopt26thandroid.ui.home.HomeFragment
import com.hyesun.sopt26thandroid.ui.mypage.MyPageFragment


class MainPagerAdapter(fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    override fun getItem(position: Int): Fragment {
        return when(position){
            0 -> HomeFragment()
            1 -> BookFragment()
            else -> MyPageFragment()
        } }
    override fun getCount() = 3
}