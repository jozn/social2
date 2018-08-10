
package com.mardomsara.social.ui;

import android.widget.*;
import android.view.*;
import android.webkit.WebView;
import android.view.LayoutInflater;
import android.content.Context;


import android.support.constraint.ConstraintLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import com.facebook.drawee.view.SimpleDraweeView;
import com.github.rahatarmanahmed.cpv.CircularProgressView;
import com.mardomsara.social.ui.views.XRawIcon;
import com.mardomsara.social.ui.views.buttons.ButtonPostMultiWayView;
import com.mardomsara.social.ui.views.x.XTextView;
import com.mardomsara.x.iconify.widget.XIcon;

//import com.mardomsara.social.helpers.AppUtil;
import com.mardomsara.social.R;

public class X {
    
    public static class ActivityMainApp {
        public LinearLayout root;
        public LinearLayout global_window;
        public FrameLayout fg1;
        public FrameLayout footerbar_holder;
        public FrameLayout dialog;

        public ActivityMainApp(Context context,ViewGroup parent) {
            this(context,parent, R.layout.activity_main_app );
        }

        public ActivityMainApp(Context context,ViewGroup parent, int layout) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            global_window = (LinearLayout) root.findViewById( R.id.global_window);
            fg1 = (FrameLayout) root.findViewById( R.id.fg1);
            footerbar_holder = (FrameLayout) root.findViewById( R.id.footerbar_holder);
            dialog = (FrameLayout) root.findViewById( R.id.dialog);
        }
        /*public ActivityMainApp() {
            this(AppUtil.getContext(),null);
        }*/

        public ActivityMainApp(Context context) {
            this(context ,null);
        }

        public ActivityMainApp(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.activity_main_app;
            public static int global_window = R.id.global_window;
            public static int fg1 = R.id.fg1;
            public static int footerbar_holder = R.id.footerbar_holder;
            public static int dialog = R.id.dialog;
        }
    }

    public static class ActivityNew {
        public LinearLayout root;
        public Button button;
        public Button button2;
        public FrameLayout fg1;
        public LinearLayout fg2;
        public FrameLayout holder_chat;
        public FrameLayout holder_home;
        public FrameLayout holder_search;
        public FrameLayout holder_activity;
        public FrameLayout holder_profile;
        public FrameLayout footerbar_holder;

        public ActivityNew(Context context,ViewGroup parent) {
            this(context,parent, R.layout.activity_new );
        }

        public ActivityNew(Context context,ViewGroup parent, int layout) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            button = (Button) root.findViewById( R.id.button);
            button2 = (Button) root.findViewById( R.id.button2);
            fg1 = (FrameLayout) root.findViewById( R.id.fg1);
            fg2 = (LinearLayout) root.findViewById( R.id.fg2);
            holder_chat = (FrameLayout) root.findViewById( R.id.holder_chat);
            holder_home = (FrameLayout) root.findViewById( R.id.holder_home);
            holder_search = (FrameLayout) root.findViewById( R.id.holder_search);
            holder_activity = (FrameLayout) root.findViewById( R.id.holder_activity);
            holder_profile = (FrameLayout) root.findViewById( R.id.holder_profile);
            footerbar_holder = (FrameLayout) root.findViewById( R.id.footerbar_holder);
        }
        /*public ActivityNew() {
            this(AppUtil.getContext(),null);
        }*/

        public ActivityNew(Context context) {
            this(context ,null);
        }

        public ActivityNew(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.activity_new;
            public static int button = R.id.button;
            public static int button2 = R.id.button2;
            public static int fg1 = R.id.fg1;
            public static int fg2 = R.id.fg2;
            public static int holder_chat = R.id.holder_chat;
            public static int holder_home = R.id.holder_home;
            public static int holder_search = R.id.holder_search;
            public static int holder_activity = R.id.holder_activity;
            public static int holder_profile = R.id.holder_profile;
            public static int footerbar_holder = R.id.footerbar_holder;
        }
    }

    public static class BranchHolder {
        public LinearLayout root;
        public LinearLayout child_frame_deep;
        public FrameLayout default_frame;

        public BranchHolder(Context context,ViewGroup parent) {
            this(context,parent, R.layout.branch_holder );
        }

        public BranchHolder(Context context,ViewGroup parent, int layout) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            child_frame_deep = (LinearLayout) root.findViewById( R.id.child_frame_deep);
            default_frame = (FrameLayout) root.findViewById( R.id.default_frame);
        }
        /*public BranchHolder() {
            this(AppUtil.getContext(),null);
        }*/

        public BranchHolder(Context context) {
            this(context ,null);
        }

        public BranchHolder(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.branch_holder;
            public static int child_frame_deep = R.id.child_frame_deep;
            public static int default_frame = R.id.default_frame;
        }
    }

    public static class ButtonPostMultiway {
        public ButtonPostMultiWayView root;

        public ButtonPostMultiway(Context context,ViewGroup parent) {
            this(context,parent, R.layout.button_post_multiway );
        }

        public ButtonPostMultiway(Context context,ViewGroup parent, int layout) {
            root = (ButtonPostMultiWayView) LayoutInflater.from(context).inflate(layout,parent ,false);
        }
        /*public ButtonPostMultiway() {
            this(AppUtil.getContext(),null);
        }*/

        public ButtonPostMultiway(Context context) {
            this(context ,null);
        }

        public ButtonPostMultiway(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.button_post_multiway;
        }
    }

    public static class FragmentFooterBar {
        public LinearLayout root;
        public XRawIcon profile;
        public XRawIcon activity;
        public XRawIcon search;
        public XRawIcon home;
        public XRawIcon chat;

        public FragmentFooterBar(Context context,ViewGroup parent) {
            this(context,parent, R.layout.fragment_footer_bar );
        }

        public FragmentFooterBar(Context context,ViewGroup parent, int layout) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            profile = (XRawIcon) root.findViewById( R.id.profile);
            activity = (XRawIcon) root.findViewById( R.id.activity);
            search = (XRawIcon) root.findViewById( R.id.search);
            home = (XRawIcon) root.findViewById( R.id.home);
            chat = (XRawIcon) root.findViewById( R.id.chat);
        }
        /*public FragmentFooterBar() {
            this(AppUtil.getContext(),null);
        }*/

        public FragmentFooterBar(Context context) {
            this(context ,null);
        }

        public FragmentFooterBar(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.fragment_footer_bar;
            public static int profile = R.id.profile;
            public static int activity = R.id.activity;
            public static int search = R.id.search;
            public static int home = R.id.home;
            public static int chat = R.id.chat;
        }
    }

    public static class Framelayout {
        public FrameLayout root;
        public FrameLayout frame_layout;

        public Framelayout(Context context,ViewGroup parent) {
            this(context,parent, R.layout.framelayout );
        }

        public Framelayout(Context context,ViewGroup parent, int layout) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            frame_layout = (FrameLayout) root.findViewById( R.id.frame_layout);
        }
        /*public Framelayout() {
            this(AppUtil.getContext(),null);
        }*/

        public Framelayout(Context context) {
            this(context ,null);
        }

        public Framelayout(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.framelayout;
            public static int frame_layout = R.id.frame_layout;
        }
    }

    public static class HelloWorld {
        public ConstraintLayout root;
        public TextView textView;
        public ImageView imageView;

        public HelloWorld(Context context,ViewGroup parent) {
            this(context,parent, R.layout.hello_world );
        }

        public HelloWorld(Context context,ViewGroup parent, int layout) {
            root = (ConstraintLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            textView = (TextView) root.findViewById( R.id.textView);
            imageView = (ImageView) root.findViewById( R.id.imageView);
        }
        /*public HelloWorld() {
            this(AppUtil.getContext(),null);
        }*/

        public HelloWorld(Context context) {
            this(context ,null);
        }

        public HelloWorld(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.hello_world;
            public static int textView = R.id.textView;
            public static int imageView = R.id.imageView;
        }
    }

    public static class Loading {
        public FrameLayout root;
        public CircularProgressView loading;

        public Loading(Context context,ViewGroup parent) {
            this(context,parent, R.layout.loading );
        }

        public Loading(Context context,ViewGroup parent, int layout) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            loading = (CircularProgressView) root.findViewById( R.id.loading);
        }
        /*public Loading() {
            this(AppUtil.getContext(),null);
        }*/

        public Loading(Context context) {
            this(context ,null);
        }

        public Loading(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.loading;
            public static int loading = R.id.loading;
        }
    }

    public static class MainBranchChat {
        public LinearLayout root;
        public TabLayout sliding_tabs;
        public ViewPager viewpager;

        public MainBranchChat(Context context,ViewGroup parent) {
            this(context,parent, R.layout.main_branch_chat );
        }

        public MainBranchChat(Context context,ViewGroup parent, int layout) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            sliding_tabs = (TabLayout) root.findViewById( R.id.sliding_tabs);
            viewpager = (ViewPager) root.findViewById( R.id.viewpager);
        }
        /*public MainBranchChat() {
            this(AppUtil.getContext(),null);
        }*/

        public MainBranchChat(Context context) {
            this(context ,null);
        }

        public MainBranchChat(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.main_branch_chat;
            public static int sliding_tabs = R.id.sliding_tabs;
            public static int viewpager = R.id.viewpager;
        }
    }

    public static class Msg_MediaNetworkLoader {
        public ViewGroup root;
        public SimpleDraweeView msg_image;
        public FrameLayout loading_holder;
        public XRawIcon icon_action_btn;
        public CircularProgressView loading_progress;

        public Msg_MediaNetworkLoader(Context context,ViewGroup parent) {
            this(context,parent, R.layout.msg__media_network_loader );
        }

        public Msg_MediaNetworkLoader(Context context,ViewGroup parent, int layout) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(layout,parent,true);//for Compound Views
            
            msg_image = (SimpleDraweeView) root.findViewById( R.id.msg_image);
            loading_holder = (FrameLayout) root.findViewById( R.id.loading_holder);
            icon_action_btn = (XRawIcon) root.findViewById( R.id.icon_action_btn);
            loading_progress = (CircularProgressView) root.findViewById( R.id.loading_progress);
        }//Compound Views Must have parent otherwise will panic

        public Msg_MediaNetworkLoader(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.msg__media_network_loader;
            public static int msg_image = R.id.msg_image;
            public static int loading_holder = R.id.loading_holder;
            public static int icon_action_btn = R.id.icon_action_btn;
            public static int loading_progress = R.id.loading_progress;
        }
    }

    public static class Nav_IconHolder {
        public FrameLayout root;
        public TextView icon_text;

        public Nav_IconHolder(Context context,ViewGroup parent) {
            this(context,parent, R.layout.nav__icon_holder );
        }

        public Nav_IconHolder(Context context,ViewGroup parent, int layout) {
            root = (FrameLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            icon_text = (TextView) root.findViewById( R.id.icon_text);
        }
        /*public Nav_IconHolder() {
            this(AppUtil.getContext(),null);
        }*/

        public Nav_IconHolder(Context context) {
            this(context ,null);
        }

        public Nav_IconHolder(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.nav__icon_holder;
            public static int icon_text = R.id.icon_text;
        }
    }

    public static class Nav_Simple {
        public ViewGroup root;
        public TextView left_text;
        public XTextView title_text;
        public XIcon back_btn;

        public Nav_Simple(Context context,ViewGroup parent) {
            this(context,parent, R.layout.nav__simple );
        }

        public Nav_Simple(Context context,ViewGroup parent, int layout) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(layout,parent,true);//for Compound Views
            
            left_text = (TextView) root.findViewById( R.id.left_text);
            title_text = (XTextView) root.findViewById( R.id.title_text);
            back_btn = (XIcon) root.findViewById( R.id.back_btn);
        }//Compound Views Must have parent otherwise will panic

        public Nav_Simple(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.nav__simple;
            public static int left_text = R.id.left_text;
            public static int title_text = R.id.title_text;
            public static int back_btn = R.id.back_btn;
        }
    }

    public static class TabCellGeneral {
        public LinearLayout root;
        public TextView textView;
        public ImageView imgView;

        public TabCellGeneral(Context context,ViewGroup parent) {
            this(context,parent, R.layout.tab_cell_general );
        }

        public TabCellGeneral(Context context,ViewGroup parent, int layout) {
            root = (LinearLayout) LayoutInflater.from(context).inflate(layout,parent ,false);
            textView = (TextView) root.findViewById( R.id.textView);
            imgView = (ImageView) root.findViewById( R.id.imgView);
        }
        /*public TabCellGeneral() {
            this(AppUtil.getContext(),null);
        }*/

        public TabCellGeneral(Context context) {
            this(context ,null);
        }

        public TabCellGeneral(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.tab_cell_general;
            public static int textView = R.id.textView;
            public static int imgView = R.id.imgView;
        }
    }

    public static class X_TopNav {
        public ViewGroup root;
        public LinearLayout left_container;
        public XTextView left_text;
        public XTextView title_text;
        public XIcon back_btn;

        public X_TopNav(Context context,ViewGroup parent) {
            this(context,parent, R.layout.x__top_nav_ );
        }

        public X_TopNav(Context context,ViewGroup parent, int layout) {
            root = (ViewGroup) LayoutInflater.from(context).inflate(layout,parent,true);//for Compound Views
            
            left_container = (LinearLayout) root.findViewById( R.id.left_container);
            left_text = (XTextView) root.findViewById( R.id.left_text);
            title_text = (XTextView) root.findViewById( R.id.title_text);
            back_btn = (XIcon) root.findViewById( R.id.back_btn);
        }//Compound Views Must have parent otherwise will panic

        public X_TopNav(ViewGroup parent) {
            this(parent.getContext() ,parent);
        }

        public static class IDS {
            public static int LAYOUT = R.layout.x__top_nav_;
            public static int left_container = R.id.left_container;
            public static int left_text = R.id.left_text;
            public static int title_text = R.id.title_text;
            public static int back_btn = R.id.back_btn;
        }
    }

}

////////////////////////////////
//import android.widget.Button;
//import android.widget.FrameLayout;
//import android.widget.ImageView;
//import android.widget.LinearLayout;
//import android.widget.TextView;
