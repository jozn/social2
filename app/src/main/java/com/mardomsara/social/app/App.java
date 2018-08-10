package com.mardomsara.social.app;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.ColorRes;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//copy all funcs from App and and AppUtil
public class App {
	public static Context context;
	private static ExecutorService _threadPool;
	private static ExecutorService _threadSingle;


	public static void log(String str){
		Log.d(Thread.currentThread().getName(),""+ str);
	}
	public static void log(Object obj){
//		Log.d(Thread.currentThread().getName(),""+ toJson(obj));
		Log.d(Thread.currentThread().getName(),""+ obj.toString());
	}
	public static void error(String str){
		Log.e(Thread.currentThread().getName(), "" + str);
	}

	public static long getTimeMs(){
		return new Date().getTime();
	}

	public static long getTime(){
		return (new Date().getTime())/1000;
	}

	public static void showDebugMessage(final String text) {
		if (!Config.IS_DEBUG) return;
		runInUi(new Runnable() {
			@Override
			public void run() {
				Toast.makeText(context, text, Toast.LENGTH_SHORT).show();
			}
		});
	}

	public static void runInUi(final Runnable r) {
		new Handler(Looper.getMainLooper()).post(new Runnable() {
			@Override
			public void run() {
				r.run();
			}
		});
	}

	public static void runInUiNoPanic(final Runnable r) {
		runInUi(new Runnable() {
			@Override
			public void run() {
				try {
					r.run();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void runInUiWithSleep(final Runnable r, final int sleep)
	{
		new AsyncTask<Void,Void,Void>(){
			@Override
			protected Void doInBackground(Void... params) {
				try {
					Thread.sleep(sleep);
				}catch (Exception e){
				}
				return null;
			}

			@Override
			protected void onPostExecute(Void aVoid) {
				super.onPostExecute(aVoid);
				r.run();
			}
		}.executeOnExecutor(getThreadPool());
	}

	public static void runInBackground(Runnable r){
		getThreadPool().execute(r);
	}

	public static void runInBackgroundNoPanic(final Runnable r){
		Runnable runner = new Runnable() {
			@Override
			public void run() {
				try {
					r.run();
				}catch (Exception e){
					e.printStackTrace();
				}
			}
		};

		getThreadPool().execute(runner);
	}


	public static int getAndroidSdkVersion(){
		return Build.VERSION.SDK_INT;
	}
	public static int getAppVersion(){
		try {
			return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
		} catch (PackageManager.NameNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}


	public static String getString(int id){
		return context.getResources().getString(id);
	}

	public static Drawable getDrawable(int id){
		return context.getResources().getDrawable(id);
	}

	public static Resources getResources(){
		return context.getResources();//
	}


	public static int getColor(@ColorRes int id){
		return context.getResources().getColor(id);//
	}

	public static int dpToPx(int dp) {
		return (int) (dp * Resources.getSystem().getDisplayMetrics().density);
	}

	public static int getScreenWidth() {
//		Context context = getContext();
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		return  width;
	}

	public static int getScreenHeight() {
//		Context context = co;
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;
		return  height;
	}

	public static String getScreenResolution() {
//		Context context= getContext();
		WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
		Display display = wm.getDefaultDisplay();
		DisplayMetrics metrics = new DisplayMetrics();
		display.getMetrics(metrics);
		int width = metrics.widthPixels;
		int height = metrics.heightPixels;

		return "{" + width + "," + height + "}";
	}

	public static int pxToDp(int px) {
		return (int) (px / Resources.getSystem().getDisplayMetrics().density);
	}

	public static float getDensity() {
		return Resources.getSystem().getDisplayMetrics().density;
	}

	public static void showKeyboard(EditText edit_filed){
		if(edit_filed.requestFocus()){
			InputMethodManager imm =(InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
			imm.showSoftInput(edit_filed, InputMethodManager.SHOW_IMPLICIT);
		}
	}

	public static void hideKeyboard(EditText edit_filed){
		InputMethodManager imm =(InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
		imm.hideSoftInputFromWindow(edit_filed.getWindowToken(), 0);
	}

	public static View inflate(int id){
		return LayoutInflater.from(context).inflate(id,null,false);
	}

	public static View inflate(int id, ViewGroup parent){
		return LayoutInflater.from(context).inflate(id,parent,false);
	}

	public static View inflate(int id, ViewGroup parent,boolean attach){
		return LayoutInflater.from(context).inflate(id,parent,attach);
	}

	////////////////////// ThreadPools ///////////
	public static ExecutorService getThreadPool(){
		if(_threadPool == null){
			_threadPool = Executors.newCachedThreadPool();
		}
		return _threadPool;
	}

	public static ExecutorService getSingleThread(){
		if(_threadSingle == null){
			_threadSingle = Executors.newSingleThreadExecutor();
		}
		return _threadSingle;
	}
}
