package com.mardomsara.social.ui.pages.tabs

import android.os.Bundle
import android.view.View

import com.mardomsara.social.nav.BranchHolderFragment
import com.mardomsara.social.ui.X

/**
 * Created by Hamid on 1/4/2018.
 */

class HomeTabFragment : BranchHolderFragment() {
    internal var x: X.Framelayout? = null
    internal var instaneaded = false
    internal var instaneaded2 = false

    override fun getView(savedInstanceState: Bundle?): View? {
        /*PostsHomeCell listCell = new PostsHomeCell(getActivity());
		listCell.setLoadingEndPoint(API.BASE_DOMAIN_URL_STR+"/v1/post/stream");
//        viewRoot.addView(listCell.getViewRoot());
		listCell.loadFromServer(1);
		return listCell.getViewRoot();*/

        return X.HelloWorld(context).root
    }

    /*@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		if(!instaneaded){
			x = new X.Framelayout();
		}
		instaneaded = true;
		return x.frame_layout;
	}

	@Override
	public void onActivityCreated(@Nullable Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		if(!instaneaded2){
			PostsHomeCell listCell = new PostsHomeCell(getActivity());
			listCell.setLoadingEndPoint(API.BASE_DOMAIN_URL_STR+"/v1/post/stream");
//        viewRoot.addView(listCell.getViewRoot());
			listCell.loadFromServer(1);

			x.root.addView(listCell.getViewRoot());
		}
		instaneaded2 = true;

	}*/
}
