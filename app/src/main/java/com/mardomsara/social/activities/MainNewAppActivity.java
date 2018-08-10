package com.mardomsara.social.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;

import com.mardomsara.social.R;
import com.mardomsara.social.app.LifeCycle;
import com.mardomsara.social.nav.AppState;
import com.mardomsara.social.nav.Nav;

/**
 * Created by Hamid on 1/31/2016.
 */
public class MainNewAppActivity extends AppBaseActivity {
	public static MainNewAppActivity instance;

	public ViewGroup global_window;
	@Override
	public void onBackPressed() {
		if(!Nav.onBackPressed()){
			finishAfterTransition();
//			super.onBackPressed();
		}
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		instance = this;

		setContentView(R.layout.activity_main_app);
		global_window = (ViewGroup) findViewById(R.id.global_window);
//		AppUtil.global_window = global_window;

		///////// Nav ////////////
		ViewGroup container = (ViewGroup) findViewById(R.id.fg1);
		ViewGroup foooter = (ViewGroup) findViewById(R.id.footerbar_holder);


		LifeCycle.onAppActivityStarted();

		//LATER set
//		EmojiconsPopup.setUpLayoutListnr(global_window);

		///////////// new Nav setup ///////
		AppState.getInstance().mainActivity = this;
		AppState.getInstance().rootView = global_window;
		Nav.setUpDef();
	}

	@Override
	public void onDestroy() {
		super.onDestroy();
	}

	//Fixme Nav.onActivityResult() must be called getDefulat
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		logIt("onActivityResult :" + requestCode + " " + resultCode + " " + data);
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
		outState.putString("K", "klkiopkjh " );
	}


}