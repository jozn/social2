package com.mardomsara.social.ui.pages.tabs;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.nav.BranchHolderFragment;
import com.mardomsara.social.ui.adaptors.AppTabFragmentPagerAdaptor;
import com.mardomsara.social.ui.pages.samples.PlayFragment;

/**
 * Created by Hamid on 5/2/2016.
 */
public class ChatTabFragment_bk extends BranchHolderFragment {
	@Override
	public View getView(Bundle savedInstanceState) {
		View l = LayoutInflater.from(getActivity()).inflate(R.layout.main_branch_chat,null);
		ViewPager vp = (ViewPager)l.findViewById(R.id.viewpager);
		TabLayout tabLayout = (TabLayout)l.findViewById(R.id.sliding_tabs);
		tabLayout.setBackgroundColor(0xeeeeee);

		/*AppTabPagerAdaptor tabsPager = new AppTabPagerAdaptor();
		AppTabPagerAdaptor tabsPager = new AppTabPagerAdaptor();
		tabsPager.addTab(new AppTabPagerAdaptor.Tab("کاربران", new AppTabPagerAdaptor.GetView() {
			@Override
			public View getView() {
				return new X.HelloWorld(getContext()).root;
			}
		}));

		tabsPager.addTab(new AppTabPagerAdaptor.Tab("گفتگو ها", new AppTabPagerAdaptor.GetView() {
			@Override
			public View getView() {
				return new X.HelloWorld(getContext()).root;
			}
		}));*/

		AppTabFragmentPagerAdaptor tabsPager = new AppTabFragmentPagerAdaptor(getChildFragmentManager());
		tabsPager.addTab(new AppTabFragmentPagerAdaptor.Tab("کاربران", new PlayFragment()));
		tabsPager.addTab(new AppTabFragmentPagerAdaptor.Tab("گفتگو ها", new PlayFragment()));


//		tabsPager.addTab(new AppTabPagerAdaptor.Tab("گفتگو ها",()-> new InboxChatsListCell().getView()));

//		tabsPager.addTab(new AppTabPagerAdaptor.Tab("کاربران", ()-> new UserAndContactsCell().buildView()));
//		tabsPager.addTab(new AppTabPagerAdaptor.Tab("گفتگو ها",()-> new InboxChatsListCell().getView()));
//		tabsPager.addTab(new AppTabPagerAdaptor.Tab("گفتگو ها",()-> new InboxChatsListCell().getView()));

		vp.setAdapter(tabsPager);
		tabLayout.setupWithViewPager(vp);
		tabsPager.setTabLayout(tabLayout);

		vp.setCurrentItem(1);
		return l;
//		return new X.HelloWorld(getContext()).root;
	}

}


