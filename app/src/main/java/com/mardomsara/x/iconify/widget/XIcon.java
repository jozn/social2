package com.mardomsara.x.iconify.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.annotation.ColorInt;
import android.support.v7.widget.AppCompatTextView;
import android.text.style.AbsoluteSizeSpan;
import android.util.AttributeSet;
import android.util.TypedValue;

import com.mardomsara.social.R;
import com.mardomsara.social.app.App;
import com.mardomsara.social.helpers.Spanny;
import com.mardomsara.social.ui.views.FontCache;
import com.mardomsara.social.ui.views.x.IranFonts;
import com.mardomsara.x.iconify.Icon;
import com.mardomsara.x.iconify.XIconify;
import com.mardomsara.x.iconify.internal.CustomTypefaceSpan;
import com.mardomsara.x.iconify.internal.HasOnViewAttachListener;
import com.mardomsara.x.iconify.internal.IconFontDescriptorWrapper;

//import com.mardomsara.social.helpers.App;
//import com.mardomsara.social.lib.Spanny;

//note left and right attrs are for RTL lang for LTR must channge the lib for space support and use  interchange
public class XIcon extends AppCompatTextView implements HasOnViewAttachListener {
	private static String halfSpace = "\u200A\u200A";

	String leftIconStr = null;
	Icon leftIcon = null;
	String rightIconStr = null;
	Icon rightIcon = null;

	String textStr = " ";
	IranFonts iranFonts;
	int iconColor = App.getColor(R.color.text_black_4);
	int textColor = App.getColor(R.color.text_black_4);
	int iconSpacePx = App.dpToPx(2);

	int textSizePx = App.dpToPx(16) ;

	int iconSizePx = -1;

    private HasOnViewAttachListenerDelegate delegate;

    public XIcon(Context context) {
        super(context);
        init(context,null);
    }

    public XIcon(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context,attrs);
    }

    public XIcon(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context,attrs);
    }

	@SuppressWarnings(" styleable ")
    private void init(Context context, AttributeSet attrs) {
        setTransformationMethod(null);
		TypedArray a = getContext().getTheme().obtainStyledAttributes(
			attrs,
			R.styleable.XIcon,
			0, R.style.XIconDef);

		try {
			leftIconStr = a.getString(R.styleable.XIcon_xiconLeft);
			rightIconStr = a.getString(R.styleable.XIcon_xiconRight);
			iconSizePx = a.getDimensionPixelSize(R.styleable.XIcon_xiconSize, App.dpToPx(24));
			iconColor = a.getColor(R.styleable.XIcon_xiconColor, iconColor);
			textStr = a.getString(R.styleable.XIcon_xiconText);
			iconSpacePx = a.getDimensionPixelSize(R.styleable.XIcon_xiconSpace, iconSpacePx);
			//for text size
			textSizePx = a.getDimensionPixelSize(R.styleable.XIcon_android_textSize, textSizePx);
			textColor = a.getColor(R.styleable.XIcon_android_textColor, textColor);

			iranFonts = IranFonts.getIranFontFromAttrs(a,this,R.styleable.XIcon_xFont);
		} finally {
			a.recycle();
		}
		setTextSize(TypedValue.COMPLEX_UNIT_PX, textSizePx);
		setTextColor(textColor);
		setText(getText());
    }

	@Override
	public void setTextColor(@ColorInt int color) {
		textColor = color;
//		iconColor = color;
		super.setTextColor(color);
		setText(getText());
	}

	public void setFullColor(@ColorInt int color) {
		textColor = color;
		iconColor = color;
		super.setTextColor(color);
		setText(getText());
	}

	@Override
    public void setText(CharSequence text, BufferType type) {
		isIcony();
		if( isIcony() == false ){
			super.setText(XIconify.compute(getContext(), text, this), type);
		}else {
			try {
				setAllIcons(text,type);
			}catch (Exception e){
				e.printStackTrace();
			}
		}
    }

    void setAllIcons(CharSequence text, BufferType type){
		// Loop through the descriptors to find a key match
		IconFontDescriptorWrapper leftIconFontDescriptor = null;
		IconFontDescriptorWrapper rightIconFontDescriptor = null;
		for (int i = 0; i < XIconify.iconFontDescriptors.size(); i++) {
			leftIconFontDescriptor = XIconify.iconFontDescriptors.get(i);
			leftIcon = leftIconFontDescriptor.getIcon(leftIconStr);
			if (leftIcon != null) break;
		}
		for (int i = 0; i < XIconify.iconFontDescriptors.size(); i++) {
			rightIconFontDescriptor = XIconify.iconFontDescriptors.get(i);
			rightIcon = rightIconFontDescriptor.getIcon(rightIconStr);
			if (rightIcon != null) break;
		}

//		final SpannableStringBuilder spannableBuilder = new SpannableStringBuilder(text);
		Spanny spanny = new Spanny();

		//right
		if(rightIcon != null){
			CustomTypefaceSpan rightSpan= buildSpan(rightIcon, rightIconFontDescriptor);
			spanny.append(rightIcon.key(),rightSpan);
		}

		//text
		if(textStr != null){
			setTypeface(FontCache.get(iranFonts.path));
			spanny.append(halfSpace, new AbsoluteSizeSpan(iconSizePx));
			spanny.append(textStr);
			spanny.append(halfSpace, new AbsoluteSizeSpan(iconSizePx));
		}

		//left
		if(leftIcon!=null){
			CustomTypefaceSpan leftSpan= buildSpan(leftIcon, leftIconFontDescriptor);
			spanny.append(leftIcon.key(),leftSpan);
		}

		setOnViewAttachListener(null);
		super.setText(spanny,type);
	}

	private CustomTypefaceSpan buildSpan(Icon icon, IconFontDescriptorWrapper iconFontDescriptorWrapper){
		return new CustomTypefaceSpan(icon,
			iconFontDescriptorWrapper.getTypeface(getContext()),
			iconSizePx, -1, iconColor, false, false);
	}

	public void setTextStr(String textStr) {
		this.textStr = textStr;
		setText(getText());
	}

	public boolean isIcony(){
		if( isStrNotEmpt(leftIconStr) || isStrNotEmpt(rightIconStr) ){
			return true;
		}
		return false;
	}

	public boolean isStrNotEmpt(String str){
		if(str != null && (!str.equals(""))){
			return true;
		}
		return false;
	}

	public void setLeftIconStr(String leftIconStr) {
		this.leftIconStr = leftIconStr;
		invalidate();
	}

	public void setRightIconStr(String rightIconStr) {
		this.rightIconStr = rightIconStr;
		invalidate();
	}

	private void setFullText(CharSequence text){

		invalidate();
	}

    @Override
    public void setOnViewAttachListener(OnViewAttachListener listener) {
        if (delegate == null) delegate = new HasOnViewAttachListenerDelegate(this);
        delegate.setOnViewAttachListener(listener);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
		if(delegate != null) delegate.onAttachedToWindow();
	}

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
		if(delegate != null) delegate.onDetachedFromWindow();
    }

}
