package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;

import com.mardomsara.social.R;
import com.mardomsara.social.app.App;
import com.mardomsara.x.iconify.widget.IconButton;

//import com.joanzapata.iconify.widget.IconButton;
//import com.joanzapata.iconify.widget.IconTextView;
//import com.mardomsara.social.helpers.AndroidUtil;

/**
 * Created by Hamid on 11/10/2016.
 */

public class ButtonGrayView extends IconButton {

	final static int coloer_isFollowing =App.getColor(R.color.white);
	final static int coloer_notFollowing =App.getColor(R.color.following_blue);
	final static int color_white = Color.WHITE;
	final static int background_isWaiting = R.drawable.follow_btn_waiteing;

	public ButtonGrayView(Context context) {
		super(context);
		init();
	}

	public ButtonGrayView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init();
	}

	public ButtonGrayView(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init();
	}

	void init(){
		setMinimumWidth(App.dpToPx(40));
//        setMinimumWidth(App.dpToPx(80));
//		setLayoutParams(new ViewGroup.LayoutParams(App.dpToPx(150),App.dpToPx(20)));
//		setTypeface(FontCache.getIonic(), Typeface.BOLD);
		setTypeface(null, Typeface.BOLD);
		setGravity(Gravity.CENTER);

//		setTextSize(App.dpToPx(12));

//		setText("\uf2d4");
		setText("\uf422");
		setText("{icon-user-follow 18dp } ");
		setText("{icon-envelope 26dp} ");
		setTextColor(coloer_notFollowing);
		setBackgroundColor(Color.WHITE);
		setBackgroundResource(R.drawable.btn_default);
		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				cliker();
			}
		});


		int pad = App.dpToPx(4);
		setPadding(pad,0,pad,0);
	}

	String icon ="";
	Runnable onClick;

	public void setIconAndClicker(String icon,Runnable onClick){
		this.icon = icon;
		this.onClick = onClick;
		setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
		setText(icon);
		setGravity(Gravity.CENTER);
	}

	void cliker(){
		if(onClick!=null){
			onClick.run();
		}
	}




}
