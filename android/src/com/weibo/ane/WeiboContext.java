package com.weibo.ane;

import java.util.HashMap;
import java.util.Map;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.weibo.func.WeiboExit;
import com.weibo.func.WeiboInit;
import com.weibo.func.WeiboOauthLogin;
import com.weibo.func.WeiboSingleLogin;

/**
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class WeiboContext extends FREContext {
	/**
	 * INIT sdk
	 */
	public static final String WEIBO_FUNCTION_INIT = "weibo_function_init";
	/**
	 * 登录Key
	 */
	public static final String WEIBO_FUNCTION_OAUTH_LOGIN = "weibo_function_oauth_login";
	/**
	 * Key
	 */
	public static final String WEIBO_FUNCTION_SINGLE_LOGIN = "weibo_function_single_login";
	/**
	 * 退出Key
	 */
	public static final String WEIBO_FUNCTION_EXIT = "weibo_function_exit";
	@Override
	public void dispose() {
		// TODO Auto-generated method stub

	}

	@Override
	public Map<String, FREFunction> getFunctions() {
		// TODO Auto-generated method stub
		Map<String, FREFunction> map = new HashMap<String, FREFunction>();
//	       //映射
		   map.put(WEIBO_FUNCTION_INIT, new WeiboInit());
	       map.put(WEIBO_FUNCTION_OAUTH_LOGIN, new WeiboOauthLogin());
	       map.put(WEIBO_FUNCTION_SINGLE_LOGIN, new WeiboSingleLogin());
	       map.put(WEIBO_FUNCTION_EXIT, new WeiboExit());
	       return map;
	}

}
