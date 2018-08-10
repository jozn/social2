package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.AttributeSet;
import android.widget.FrameLayout;

import com.mardomsara.social.ui.X;

/**
 * Created by Hamid on 2/5/2017.
 */

public class ChatMediaNetworkLoader extends FrameLayout {
	@NonNull
	public X.Msg_MediaNetworkLoader x;

	public ChatMediaNetworkLoader(Context context) {
		super(context);
		init(context);
	}

	public ChatMediaNetworkLoader(Context context, AttributeSet attrs) {
		super(context, attrs);
		init(context);
	}

	public ChatMediaNetworkLoader(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);
		init(context);
	}

	private void init(Context context) {
		x = new X.Msg_MediaNetworkLoader(this);
	}

}
