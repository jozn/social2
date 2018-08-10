package com.mardomsara.social.ui.adaptors;

import android.support.annotation.NonNull;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.app.App;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hamid on 1/9/2017.
 */

public class AppTabFragmentPagerAdaptor extends FragmentPagerAdapter {
	List<Tab> tabList=new ArrayList<>();

	public AppTabFragmentPagerAdaptor(FragmentManager fm) {
		super(fm);
	}

	@Override
	public Fragment getItem(int position) {
		return tabList.get(position).fragment;
	}


	/*public AppTabFragmentPagerAdaptor(Tab ...tab) {
		for(Tab t: tab){
			tabList.add(t);
		}
	}*/

	public void addTab(@NonNull Tab tab){
		tabList.add(tab);
	}

	//must called after all addTab(...) and setting ViewPager to this
	public void setTabLayout(TabLayout tabLayout){
		tabLayout.setBackgroundColor(0xeeeeee);
		for (int i = 0; i < tabLayout.getTabCount(); i++) {
			TabLayout.Tab t = tabLayout.getTabAt(i);
			t.setCustomView( getTabTitleView(i) );
		}
		tabLayout.setTabMode(TabLayout.MODE_FIXED);
	}

	/*@Override
	public Object instantiateItem(ViewGroup container, int position) {
		Tab tab = tabList.get(position);
		View tabView = tab.getView();
		if(tabView!=null){
			container.addView(tabView);
		}
		return tab;
	}*/

	@Override
	public void destroyItem(ViewGroup container, int position, Object object) {
		container.removeView(((Tab)object).view);
	}

	@Override
	public CharSequence getPageTitle(int position) {
		return tabList.get(position).title;
	}

	@Override
	public int getCount() {
		return tabList.size();
	}

	/*@Override
	public boolean isViewFromObject(View view, Object object) {
		super.isViewFromObject()
		return view == ((Tab)object).getView();
	}*/

	private View getTabTitleView(int position) {
		// Given you have a custom layout in `response/layout/custom_tab.xml` with a TextView and ImageView
		View v = App.inflate(R.layout.tab_cell_general, null);
		TextView tv = (TextView) v.findViewById(R.id.textView);
		tv.setText(tabList.get(position).title);
		return v;
	}

	public static class Tab{
		public String title = "";
		public Fragment fragment ;
		View view;

		public Tab(@NonNull String title, @NonNull Fragment fragment) {
			this.title = title;
			this.fragment = fragment;
		}

		/*public View getView(){
			if(view==null){
				view = getViewRunner.getView();
			}
			return view;
		}*/
	}

	/*public interface GetView{
		View getView();
	}*/
}
