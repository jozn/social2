package com.mardomsara.social.nav;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.mardomsara.social.R;
import com.mardomsara.social.ui.views.wigets.MaterialRippleLayout;

import java.util.HashMap;
import java.util.Map;

public class FooterBarCell {
	View root;
	TextView profile;
	TextView activity;
	TextView search;
	TextView home;
	TextView chat;
	TextView[] cells;
	BranchEnum activeBranch;
	Map<BranchEnum, TextView> cellsMap = new HashMap<>();

	boolean is = false;

	public FooterBarCell(Context context) {
		root = LayoutInflater.from(context).inflate(R.layout.fragment_footer_bar, null);
		profile = (TextView) root.findViewById(R.id.profile);
		activity = (TextView) root.findViewById(R.id.activity);
		search = (TextView) root.findViewById(R.id.search);
		home = (TextView) root.findViewById(R.id.home);
		chat = (TextView) root.findViewById(R.id.chat);

		setUpMaper();
		setUpEvents();
	}

	public View getRoot() {
		return root;
	}

	public void setUpMaper() {
		cellsMap.put(BranchEnum.Profile, profile);
		cellsMap.put(BranchEnum.Activity, activity);
		cellsMap.put(BranchEnum.Search, search);
		cellsMap.put(BranchEnum.Home, home);
		cellsMap.put(BranchEnum.Chat, chat);
	}

	public void setUpEvents() {

		for (final BranchEnum k : cellsMap.keySet()) {
			/*if (!is) {
				MaterialRippleLayout.on(cellsMap.get(k))
					.rippleColor(Color.BLACK)
					.rippleDelayClick(false)

					.create();
			}
*/
			cellsMap.get(k).setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View v) {
//					v.setBackgroundResource(R.drawable.nav_icon_pressed);
					Nav.goToBranch(k);

				}
			});
			cellsMap.get(k).setOnLongClickListener(new View.OnLongClickListener() {
				@Override
				public boolean onLongClick(View v) {
//                    Nav.goToBranch(k);
					Nav.resetBranch(k);
					Nav.goToBranch(k);
					return true;
				}
			});
		}
		is  =true;
	}

	public void activateBranch(BranchEnum bra) {
		for (BranchEnum k : cellsMap.keySet()) {
//			cellsMap.get(k).clic;
//			cellsMap.get(k).setBackgroundColor(getResources().getColor(R.color.navbar_background));
			cellsMap.get(k).setTextColor(getResources().getColor(R.color.navbar_icon_font));
//			cellsMap.get(k).getBackground().setState(new int[]{android.R.attr.state_empty});
			cellsMap.get(k).setSelected(false);
		}
		TextView activeCell = cellsMap.get(bra);
//		activeCell.setBackgroundColor(getResources().getColor(R.color.navbar_background_active));
		activeCell.setTextColor(getResources().getColor(R.color.navbar_icon_font_active));
//		activeCell.getBackground().setState(new int[]{android.R.attr.state_selected});
		activeCell.setSelected(true);

	}

	Resources getResources() {
		return root.getContext().getResources();
	}
}

