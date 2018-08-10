package com.mardomsara.social.ui.views.buttons;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

import com.mardomsara.social.app.App;
import com.mardomsara.x.iconify.widget.XIcon;

/**
 * Created by Hamid on 3/29/2017.
 */

public class ButtonPostMultiWayView extends XIcon {
	private static final String ICON_WIDE = "md-crop-din";
	private static final String ICON_COMPACT = "md-crop-16-9";
	private static final String ICON_MINI = "";

	PostWayToShow postWayToShow = PostWayToShow.WIDE;
	OnChangeListener onChangeListener;

	public ButtonPostMultiWayView(Context context) {
		super(context);
		init(context);
	}

	public ButtonPostMultiWayView(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ButtonPostMultiWayView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);
		init(context);
	}

	void init(Context context){
		postWayToShow = PostWayToShow.WIDE;
		setIcon(ICON_WIDE);

		setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View view) {
				onClick(view);
			}
		});
	}

	void onClick(View v){
		switch (postWayToShow){
			case COMPACT:
				postWayToShow = PostWayToShow.WIDE;
				setIcon(ICON_WIDE);
				App.showMessage("حالت نمایش تصویر: تمام صفحه (پیش فرض)");
				break;
			case WIDE:
				postWayToShow = PostWayToShow.COMPACT;
				setIcon(ICON_COMPACT);
				App.showMessage("حالت نمایش تصویر: فشرده - 16:9");
				break;
			case MINI:
				break;
		}

		if (onChangeListener != null){
			onChangeListener.onChange(postWayToShow);
		}
	}

	void setIcon(String icon){
		setRightIconStr(icon);
		setText("");
	}

	public void setOnChangeListener(OnChangeListener onChangeListener) {
		this.onChangeListener = onChangeListener;
	}

	public PostWayToShow getPostWayToShow() {
		return postWayToShow;
	}

	public interface OnChangeListener {
		void onChange(PostWayToShow postWayToShow);
	}

}
