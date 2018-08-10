package com.mardomsara.social.ui.pages.tabs

import android.os.Bundle
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.view.LayoutInflater
import android.view.View

import com.mardomsara.social.R
import com.mardomsara.social.nav.BranchHolderFragment
import com.mardomsara.social.ui.X
import com.mardomsara.social.ui.adaptors.AppTabFragmentPagerAdaptor
import com.mardomsara.social.ui.pages.samples.PlayFragment

/**
 * Created by Hamid on 5/2/2016.
 */
class ChatTabFragment : BranchHolderFragment() {
    override fun getView(savedInstanceState: Bundle?): View? {
        val x = X.MainBranchChat(activity)

        x.sliding_tabs.setBackgroundColor(0xeeeeee)

        val tabsPager = AppTabFragmentPagerAdaptor(childFragmentManager)
        tabsPager.addTab(AppTabFragmentPagerAdaptor.Tab("کاربران", PlayFragment()))
        tabsPager.addTab(AppTabFragmentPagerAdaptor.Tab("گفتگو ها", PlayFragment()))

        x.viewpager.adapter = tabsPager
        x.sliding_tabs.setupWithViewPager(x.viewpager)
        tabsPager.setTabLayout(x.sliding_tabs)

        x.viewpager.currentItem = 1
        return x.root
    }

}


