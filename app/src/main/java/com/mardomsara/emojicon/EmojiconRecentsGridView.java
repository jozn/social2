/*
 * Copyright 2014 Ankush Sachdeva
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.mardomsara.emojicon;

import android.content.Context;
import android.widget.GridView;

import com.mardomsara.emojicon.emoji.Emojicon;
import com.mardomsara.social.R;
//
//import github.ankushsachdeva.emojicon.EmojiconRecents;
//import github.ankushsachdeva.emojicon.EmojiconRecentsManager;
//import github.ankushsachdeva.emojicon.EmojiconsPopup;
//import github.ankushsachdeva.emojicon.emoji.Emojicon;

//import github.ankushsachdeva.emojicon.R;

/**
 * @author Daniele Ricci
 * @author 	Ankush Sachdeva (sankush@yahoo.co.in)
 */
public class EmojiconRecentsGridView extends EmojiconGridView implements EmojiconRecents {
	EmojiAdapter mAdapter;

	public EmojiconRecentsGridView(Context context, Emojicon[] emojicons,
			EmojiconRecents recents,OnEmojiconClickedListener _onEmojiconClickedListener) {
		super(context, emojicons, recents, _onEmojiconClickedListener);
		EmojiconRecentsManager recents1 = EmojiconRecentsManager
	            .getInstance(rootView.getContext());
		mAdapter = new EmojiAdapter(rootView.getContext(),  recents1);
		mAdapter.setEmojiClickListener(new OnEmojiconClickedListener() {

			@Override
			public void onEmojiconClicked(Emojicon emojicon) {
				if (onEmojiconClickedListener != null) {
		            onEmojiconClickedListener.onEmojiconClicked(emojicon);
		        }
		    }
		});
        GridView gridView = (GridView) rootView.findViewById(R.id.Emoji_GridView);
        gridView.setAdapter(mAdapter);
    }

    @Override
    public void addRecentEmoji(Context context, Emojicon emojicon) {
        EmojiconRecentsManager recents = EmojiconRecentsManager
            .getInstance(context);
        recents.push(emojicon);

        // notify dataset changed
        if (mAdapter != null)
            mAdapter.notifyDataSetChanged();
    }

}
