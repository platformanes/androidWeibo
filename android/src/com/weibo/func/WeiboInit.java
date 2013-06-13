package com.weibo.func;

import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.weibo.sdk.android.Weibo;

/**
 * 初始化SDK
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class WeiboInit implements FREFunction {

	private String TAG = "WeiboInit";
	private FREContext _context;
	private   String CONSUMER_KEY = "966056985";// 替换为开发者的appkey，例如"1646212860";
    private   String REDIRECT_URL = "http://www.sina.com";
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		ResHandle.setResourctID(_context, TAG);
		try
		{
			CONSUMER_KEY = arg1[0].getAsString();
			REDIRECT_URL = arg1[1].getAsString();
			WeiboUtil.CONSUMER_KEY = CONSUMER_KEY;
			WeiboUtil.REDIRECT_URL = REDIRECT_URL;
		}
		catch(Exception e)
		{
			callBack(e.getMessage());
			return null;
		}
		//在这里做初始化的操作 我这里直接传回。。
		 WeiboUtil.mWeibo = Weibo.getInstance(CONSUMER_KEY, REDIRECT_URL);
		callBack("success");
		//--------------------------------
		
		return result;
	}

	/**
	 * 初始化回调 把初始化结果传给AS端
	 */
	public void callBack(String status){
		Log.d(TAG, "---------初始化返回-------");
		_context.dispatchStatusEventAsync(TAG, "初始化回调:"+status);
	}

}
