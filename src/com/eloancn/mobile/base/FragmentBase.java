package com.eloancn.mobile.base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

import com.eloancn.mobile.R;

public abstract class FragmentBase extends Fragment {
	
	protected Context mContext;
	
	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mContext = getActivity();
	}
	
	public boolean onKeyDown(int keyCode) {
		return false;
	}
	
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		
	}
	
	@Override
	public void onResume() {
		super.onResume();
	}
	
	@Override
	public void onPause() {
		super.onPause();
	}
	
	protected void enterActivity(Intent intent) {
		startActivity(intent);
		getActivity().finish();
		getActivity().overridePendingTransition(R.anim.fragment_slide_right_enter,
				R.anim.fragment_slide_left_exit);
	}
	
	protected void enterActivityWithoutFinish(Intent intent) {
		startActivity(intent);
		getActivity().overridePendingTransition(R.anim.fragment_slide_right_enter,
				R.anim.fragment_slide_left_exit);
	}
	
}
