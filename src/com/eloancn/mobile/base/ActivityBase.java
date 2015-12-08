package com.eloancn.mobile.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;

import com.eloancn.mobile.R;
import com.eloancn.mobile.logic.AppActivityManager;
import com.readystatesoftware.systembartint.SystemBarTintManager;

public class ActivityBase extends FragmentActivity {
	
	protected Context mContext;
	
	public ActivityBase() {
		mContext = ActivityBase.this;
	}
	
	private boolean mRenderStatusBar = true;
	private boolean mRenderNavigation = false;

	protected void onCreate(Bundle savedInstanceState, boolean renderStatusBar,
			boolean renderNavigation) {
		super.onCreate(savedInstanceState);
		AppActivityManager.getInstance().pushActivity(this);
		mRenderNavigation = renderNavigation;
		mRenderStatusBar = renderStatusBar;
		initSystemBar();
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppActivityManager.getInstance().pushActivity(this);
		initSystemBar();
	}

	@TargetApi(Build.VERSION_CODES.KITKAT)
	private void initSystemBar() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			if (mRenderNavigation)
				getWindow().addFlags(
						WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			if (mRenderStatusBar) {
				getWindow().addFlags(
						WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				SystemBarTintManager tintManager = new SystemBarTintManager(
						this);
				tintManager.setStatusBarTintEnabled(true);
				tintManager.setStatusBarTintResource(R.color.title_background);
			}
		}
	}

	@Override
	public void finish() {
		super.finish();
		overridePendingTransition(R.anim.fragment_slide_left_enter,
				R.anim.fragment_slide_right_exit);// default animation for
													// finish
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		if (outState == null)
			outState = new Bundle();
		super.onSaveInstanceState(outState);
	}

	@Override
	protected void onResume() {
		super.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT) {
			changeTitlebarToRed();
		}
		if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
			changeTitlebarToTranslute();
		}
	}

	@TargetApi(Build.VERSION_CODES.KITKAT)
	public void changeTitlebarToRed() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
				&& mRenderStatusBar) {
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			SystemBarTintManager tintManager = new SystemBarTintManager(this);
			tintManager.setStatusBarTintEnabled(true);
			tintManager.setStatusBarTintResource(R.color.blue_background);
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			if (mRenderNavigation) {
				getWindow().addFlags(
						WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			} else {
				getWindow().clearFlags(
						WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			}
		}
	}

	@TargetApi(Build.VERSION_CODES.KITKAT)
	public void changeTitlebarToTranslute() {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
				&& mRenderStatusBar) {
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			SystemBarTintManager tintManager = new SystemBarTintManager(this);
			tintManager.setStatusBarTintEnabled(true);
			tintManager.setStatusBarTintResource(R.color.black);
		}
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
			if (mRenderNavigation) {
				getWindow().addFlags(
						WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			} else {
				getWindow().clearFlags(
						WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
			}
		}
	}

	@TargetApi(Build.VERSION_CODES.KITKAT)
	public void changeTitlebarColor(int color) {
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT
				&& mRenderStatusBar) {
			getWindow().addFlags(
					WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
			SystemBarTintManager tintManager = new SystemBarTintManager(this);
			tintManager.setStatusBarTintEnabled(true);
			tintManager.setStatusBarTintResource(color);
		}
	}
	
	
	protected void enterActivityWithoutFinish(Intent intent) {
		startActivity(intent);
		overridePendingTransition(R.anim.fragment_slide_right_enter,
				R.anim.fragment_slide_left_exit);
	}
	
}
