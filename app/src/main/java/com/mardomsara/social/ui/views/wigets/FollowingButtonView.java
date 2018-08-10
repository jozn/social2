package com.mardomsara.social.ui.views.wigets;

import android.content.Context;
import android.support.v7.widget.AppCompatTextView;
import android.util.AttributeSet;

import com.mardomsara.social.R;
import com.mardomsara.social.app.App;

/**
 * Created by Hamid on 6/27/2016.
 */
public class FollowingButtonView extends AppCompatTextView {
    final static String icon_isFollowing = "\uf47d";//"\uf213";//ion-person
//    String icon_isFollowing = "\uf213";//ion-person
    final static String icon_notFollowing = "\uf47f" ;//"\uf211";//ion-person-addStart
    final static String icon_isPravate = "\uf200";//ion-locked
    final static String icon_isWaiting = "\uf403";//ion-ios-clock

    final static int background_isFollowing = R.drawable.follow_btn_following;
    final static int background_notFollowing = R.drawable.follow_btn_not_following;
    final static int background_isPravate = R.drawable.follow_btn_following;
    final static int background_isWaiting = R.drawable.follow_btn_waiteing;

    final static int coloer_isFollowing = App.getColor(R.color.white);
    final static int coloer_notFollowing =App.getColor(R.color.following_blue);
    final static int coloer_inactive =App.getColor(R.color.following_inactive);

//	UserInfoJson userAndMe = null;

    public FollowingButtonView(Context context) {
        super(context);
//        init();
    }

    public FollowingButtonView(Context context, AttributeSet attrs) {
        super(context, attrs);
//        init();
    }

    public FollowingButtonView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
//        init();
    }

    /*private void init() {
        setMinimumWidth(App.dpToPx(80));
//        setMinimumWidth(App.dpToPx(80));
        setLayoutParams(new ViewGroup.LayoutParams(App.dpToPx(150),App.dpToPx(20)));
        uiNotFollowing();
//        uiIsFollowing();
        setTypeface(FontCache.getIonic(), Typeface.BOLD);
        setGravity(Gravity.CENTER);

        setTextSize(App.dpToPx(12));

		setOnClickListener((v)->{
			switchFollowing();
		});
    }

    //deprecate
	@Deprecated
    public void setUser(UserInfoJson user){
        userAndMe = user;
        updateUi();
    }

	public void setUser(JV.UserInlineWithMeView user){
		userAndMe = new UserInfoJson();
		userAndMe.Id = user.UserId;
		userAndMe.FollowingType = user.FollowingType;
		updateUi();
	}

	public void setUser(JV.UserMeView user){
		userAndMe = new UserInfoJson();
		userAndMe.Id = user.UserId;
		userAndMe.FollowingType = user.FollowingType;
		updateUi();
	}

    void updateUi(){
        if(userAndMe == null) return;
        switch (userAndMe.getFollowingType()){
            case 0:
                uiNotFollowing();
                break;
            case 1:
                uiIsFollowing();
                break;
            case 2:
                uiWaiting();
                break;
        }
    }

    void uiIsFollowing(){
        setText(icon_isFollowing);
        setTextColor(coloer_isFollowing);
        setBackgroundResource(background_isFollowing);
    }

    void uiNotFollowing(){
        setText(icon_notFollowing);
        setTextColor(coloer_notFollowing);
        setBackgroundResource(background_notFollowing);
    }

    void uiWaiting(){
        setText(icon_isWaiting);
        setTextColor(0xffffff);
        setBackgroundResource(background_isWaiting);
    }

	void switchFollowing(){
		if(userAndMe == null) return;
		int type =userAndMe.getFollowingType();
		if(type == 0){//not foolowing - > do follow
			userAndMe.FollowingType = 1;
			updateUi();
			Http.postPath("/v1/follow")
				.setFormParam("followed_user_id",""+userAndMe.getUserId())
				.doAsyncUi((result -> {
					if(result.isOk()){
						HttpJson<Integer> res = Result.fromJson(result,Integer.class);
						if(res.isPayloadNoneEmpty()){
							userAndMe.FollowingType = res.Payload;//Payload is FoLlowType
							if(res.Payload == 1){
								UserModel.onFollowedUser(userAndMe);
							}
						}
					}
					else {
						userAndMe.FollowingType = 0;
					}
					updateUi();
				}));

		}else if(type == 1){//following -> unfollow
			userAndMe.FollowingType = 0;
			updateUi();
			Http.postPath("/v1/unfollow")
				.setFormParam("followed_user_id",""+userAndMe.getUserId())
				.doAsyncUi((result -> {
					if(result.isOk()){
						UserModel.onUnFollowedUser(userAndMe);
					}
					else {
						userAndMe.FollowingType = 1;
					}
					updateUi();
				}));


		}else if(type == 2){//requested following

		}
	}

//    public void setForUser(int userId, int followingType){
//        userAndMe = null;
//
//    }*/
}
