package com.mardomsara.social.ui.pages.tabs;

import android.os.Bundle;
import android.view.View;

import com.mardomsara.social.nav.BranchHolderFragment;

/**
 * Created by Hamid on 8/23/2016.
 */
public class ActivityTabFragment extends BranchHolderFragment {

	@Override
	public View getView(Bundle savedInstanceState) {
		/*View l = AppUtil.inflate(R.layout.nav_header_pager_menu);
		ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
		TabLayout tabLayout = (TabLayout)l.findViewById(R.id.sliding_tabs);
		tabLayout.setBackgroundColor(0xeeeeee);

		AppTabPagerAdaptor tabs = new AppTabPagerAdaptor();
		tabs.addTab(new AppTabPagerAdaptor.Tab("دنبال شدگان",()-> new ActivityCell().buildView() ));
		tabs.addTab(new AppTabPagerAdaptor.Tab("شما", ()-> new NotifyCell().buildView() ));

		vp.setAdapter(tabs);
		tabLayout.setupWithViewPager(vp);

		tabs.setTabLayout(tabLayout);
		vp.setCurrentItem(tabs.getCount()-1);

		//////TEMP/////////////
		View searchBtn = l.findViewById(R.id.search);
//		searchBtn.setOnClickListener((v)-> Nav_DEP.push(new SearchUserAndTagPage()));
		/////////////////

		return l;*/
		return null;
	}

}
