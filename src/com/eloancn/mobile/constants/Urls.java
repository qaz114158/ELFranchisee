package com.eloancn.mobile.constants;

public class Urls {
	
	//http://192.168.1.116:8000
	public static final String HOST = "http://zc.joygo-dev.com/";
//	public static final String HOST = "http://192.168.1.116:8000/";

	/**
	 * 获取众筹类别接口
	 */
	public static final String URL_ZHONGCHOU_TYPE_LIST = "api-v1-0/get-category";
	
	/**
	 * 获取众筹列表接口
	 */
	public static final String URL_ZHONGCHOU_LIST = "api-v1-0/get-chips";
	
	/**
	 * 获取注资列表接口
	 */
	public static final String URL_ZHUZI_LIST = "api-v1-0/get-capital";
	
	
	/**
	 * 获取秀场列表接口
	 */
	public static final String URL_SHOW_LIST = "api-v1-0/get-show";
	
	/**
	 * 获取艺人众筹阶段信息接口
	 */
	public static final String URL_SHOW_DETAIL_CHIP = "api-v1-0/get-chips-stage";
	
	/**
	 * 判断主播是否有众筹接口
	 */
	public static final String URL_SHOW_DETAIL_CHIP_STATU = "api-v1-0/get-has-chips";
	
	/**
	 * 获取众筹大使星币榜接口
	 */
	public static final String URL_SHOW_DETAIL_CHIP_RANK_LIST = "api-v1-0/get-chips-coinranking";
	
	
	
	/* ---------以前的用户接口-------------- */
	
	public static final String URL_LOGIN = "user/login";

	public static final String URL_THIRD_LOGIN = "user/authcheck";

	public static final String URL_REGISTER = "user/register";

	public static final String URL_FORGOT_PASSWORD = "user/findpassword";

	public static final String URL_CHANGE_PASSWORD = "user/changepassword";

	public static final String URL_SETVAL = "user/setval";

	public static final String URL_SETVALS = "user/setvals";

	public static final String URL_HEADIMG = "user/headimg";

	public static final String URL_USER_INFO = "user/info";

	public static final String URL_USER_NICK_NAME = "user/setval";
	
	/* --------------以前的用户接口-------------- */
}
