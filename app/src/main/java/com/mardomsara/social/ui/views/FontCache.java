package com.mardomsara.social.ui.views;

import android.content.Context;
import android.graphics.Typeface;

import com.mardomsara.social.R;

import java.util.Hashtable;

/**
 * Created by Hamid on 6/5/2016.
 */
public class FontCache {

	static Context context;

    private static Hashtable<String, Typeface> fontCache = new Hashtable<String, Typeface>();
	public static void init(Context context){
		context = context;
	}
    public static Typeface get(String name) {
//        Context context = App.getContext();

        Typeface tf = fontCache.get(name);
        if(tf == null) {
            try {
                tf = Typeface.createFromAsset(context.getAssets(), name);
            }
            catch (Exception e) {
                return null;
            }
            fontCache.put(name, tf);
        }
        return tf;
    }

    public static Typeface getIonic(){
        return get(context.getString(R.string.font_ionic));
    }

    public static Typeface getIran(){
        return get(context.getString(R.string.font_iran));
    }

	public static Typeface getIranMedium(){
		return get(context.getString(R.string.font_iran_medium));
	}

    public static Typeface getIranLight(){
        return get(context.getString(R.string.font_iran_light));
    }

    public static Typeface getLinear(){
        return get(context.getString(R.string.font_linear));
    }
}
