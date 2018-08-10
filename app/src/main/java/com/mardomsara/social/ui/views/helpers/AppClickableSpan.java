package com.mardomsara.social.ui.views.helpers;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;

import com.mardomsara.social.app.App;

public class AppClickableSpan extends ClickableSpan {// extend ClickableSpan

    String clicked;
    public AppClickableSpan() {
        super();
    }
    public AppClickableSpan(String string) {
        super();
        clicked = string;
    }

    public void onClick(View tv) {
//       Toast.makeText(AppUtil.getContext(),clicked , Toast.LENGTH_SHORT).show();
		App.showDebugMessage("Clicked AppClickableSpan: "+clicked);
    }

    public void updateDrawState(TextPaint ds) {// override updateDrawState
        ds.setUnderlineText(false); // setOrReplace to false to remove underline
    }
}