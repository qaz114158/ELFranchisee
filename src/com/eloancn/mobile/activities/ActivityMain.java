package com.eloancn.mobile.activities;

import android.os.Bundle;
import android.widget.Toast;

import com.eloancn.mobile.R;
import com.eloancn.mobile.base.ActivityBase;
import com.eloancn.mobile.logic.AppActivityManager;

public class ActivityMain extends ActivityBase{

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
	}
	
	private long mExitUtcMs = 0;

	@Override
	public void onBackPressed() {
		if (System.currentTimeMillis() - mExitUtcMs > 2000) {
			mExitUtcMs = System.currentTimeMillis();
			Toast.makeText(this, getString(R.string.st_back_notice),
					Toast.LENGTH_SHORT).show();
		} else {
			AppActivityManager.getInstance().popAllActivity();
		}
	}
}
