package com.mardomsara.social.ui.views;

import android.graphics.drawable.Animatable;
import android.net.Uri;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.backends.pipeline.PipelineDraweeControllerBuilder;
import com.facebook.drawee.controller.BaseControllerListener;
import com.facebook.imagepipeline.image.ImageInfo;
import com.mardomsara.social.R;
import com.mardomsara.social.activities.MainNewAppActivity;
import com.mardomsara.social.app.App;

import java.io.File;

import me.relex.photodraweeview.OnViewTapListener;
import me.relex.photodraweeview.PhotoDraweeView;

//import com.mardomsara.social.helpers.App;
//import com.mardomsara.social.helpers.AppUtil;
//import butterknife.OnClick;

/**
 * Created by Hamid on 6/22/2016.
 */
public class FullScreenImage_Fresco {
	public String text;
	public Uri imageUri;
	public String imageUrlPath;
	public File imageFile;
	View top_nav;
	View back_btn;
	PhotoDraweeView image_view;
	TextView text_view;
	String TAG = "FullScreenImage";
	PopupWindow attachWindow;
	ViewGroup popupView = (ViewGroup) App.inflate(R.layout.full_screen_image_fresco, MainNewAppActivity.global_window);
	/*Nav_DEP.OnBackPressHandler backHandler = ()->{
		close();
		return true;
	};
*/
	int cliked = 0;

	public FullScreenImage_Fresco() {
		this.attachWindow = new PopupWindow(
			popupView,
			ViewGroup.LayoutParams.MATCH_PARENT,
			ViewGroup.LayoutParams.MATCH_PARENT);

		top_nav = popupView.findViewById(R.id.top_nav);
		back_btn = popupView.findViewById(R.id.back_btn);
		image_view = (PhotoDraweeView) popupView.findViewById(R.id.image_view);
		text_view = (TextView) popupView.findViewById(R.id.text_view);


//        Nav_DEP.addCustomOnBackPressHandler(backHandler);

		back_btn.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				close();
			}
		});


		text_view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggle();
			}
		});

		top_nav.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				toggle();
			}
		});

		image_view.setOnViewTapListener(new OnViewTapListener() {
			@Override
			public void onViewTap(View view, float x, float y) {
				toggle();
			}
		});
	}

	void toggle() {
		if (cliked == 0) {
			top_nav.setVisibility(View.GONE);
			text_view.setVisibility(View.GONE);
			cliked = 1;
		} else {
			top_nav.setVisibility(View.VISIBLE);
			text_view.setVisibility(View.VISIBLE);
			cliked = 0;
		}
	}

	private void close() {
//        Nav_DEP.removeCustomOnBackPressHandler(backHandler);
		attachWindow.dismiss();
	}

//	@OnClick(R.id.back_btn)
	void onBack(View v) {
		Log.d(TAG, "onBack()");
		close();
	}

	public void show() {
		Log.d(TAG, "show()" + imageUrlPath + text);
//        if(imageFile != null){
//            image_view.setImageURI(Uri.fromFile(imageFile));
//        }else {
//            image_view.setImageURI(imageUrlPath);
//        }
		int max_width = (App.getScreenWidth());
//        image_view.setLayoutParams(new RelativeLayout.LayoutParams(max_width, 700));
		text_view.setText(text);
//        image_view.setImageURI(imageUri);
		setFresco();
		attachWindow.showAtLocation(MainNewAppActivity.global_window, Gravity.CENTER, 0, 0);

	}

	void setFresco() {
		PipelineDraweeControllerBuilder controller = Fresco.newDraweeControllerBuilder();
		controller.setUri(imageUri);
		controller.setOldController(image_view.getController());
		controller.setControllerListener(new BaseControllerListener<ImageInfo>() {
			@Override
			public void onFinalImageSet(String id, ImageInfo imageInfo, Animatable animatable) {
				super.onFinalImageSet(id, imageInfo, animatable);
				if (imageInfo == null || image_view == null) {
					return;
				}
				image_view.update(imageInfo.getWidth(), imageInfo.getHeight());
			}
		});
		image_view.setController(controller.build());
	}


}
