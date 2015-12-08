package com.eloancn.mobile.action;

import android.content.Intent;

public class EventAction {

	private Intent intent;
	
	private String messageTag;
	
	private int position;

	
	public EventAction() {
		super();
	}
	
	public EventAction (Intent intent, String messageTag) {
		super();
		this.intent = intent;
		this.messageTag = messageTag;
	}
	
	public EventAction (int position, String messageTag) {
		super();
		this.position = position;
		this.messageTag = messageTag;
	}
	
	public Intent getIntent() {
		return intent;
	}

	public void setIntent(Intent intent) {
		this.intent = intent;
	}

	public String getMessageTag() {
		return messageTag;
	}

	public void setMessageTag(String messageTag) {
		this.messageTag = messageTag;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}
	
	
	
}
