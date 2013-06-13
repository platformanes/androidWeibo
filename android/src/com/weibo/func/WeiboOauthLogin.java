package com.weibo.func;

import java.text.SimpleDateFormat;

import android.os.Bundle;
import android.util.Log;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.weibo.sdk.android.Oauth2AccessToken;
import com.weibo.sdk.android.Weibo;
import com.weibo.sdk.android.WeiboAuthListener;
import com.weibo.sdk.android.WeiboDialogError;
import com.weibo.sdk.android.WeiboException;
import com.weibo.sdk.android.keep.AccessTokenKeeper;

/**
 * 执行登录
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class WeiboOauthLogin implements FREFunction {

	private String TAG = "WeiboOauthLogin";
	public static FREContext _context;
	public static Oauth2AccessToken accessToken;
	
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null;  

		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做登录的操作 我这里直接传回。。
		if(WeiboUtil.mWeibo == null)
			WeiboUtil.mWeibo = Weibo.getInstance(WeiboUtil.CONSUMER_KEY, WeiboUtil.REDIRECT_URL);
		WeiboUtil.mWeibo.authorize(WeiboOauthLogin._context.getActivity(), new AuthDialogListener());
		//--------------------------------

		return result;
	}
	class AuthDialogListener implements WeiboAuthListener {

        @Override
        public void onComplete(Bundle values) {
            String token = values.getString("access_token");
            String expires_in = values.getString("expires_in");   
            WeiboOauthLogin.accessToken = new Oauth2AccessToken(token, expires_in);
            if (WeiboOauthLogin.accessToken.isSessionValid()) {
                String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                        .format(new java.util.Date(WeiboOauthLogin.accessToken
                                .getExpiresTime()));
                
                WeiboOauthLogin._context.dispatchStatusEventAsync(TAG, "认证成功: \r\n access_token: " + token + "\r\n"
                        + "expires_in: " + expires_in + "\r\n有效期：" + date);
                try {
                    Class sso = Class
                            .forName("com.weibo.sdk.android.api.WeiboAPI");// 如果支持weiboapi的话，显示api功能演示入口按钮
                    
                } catch (ClassNotFoundException e) {  
                    // e.printStackTrace(); 
                    Log.i(TAG, "com.weibo.sdk.android.api.WeiboAPI not found");
                    WeiboOauthLogin._context.dispatchStatusEventAsync(TAG,"com.weibo.sdk.android.api.WeiboAPI not found");
                }
                
                AccessTokenKeeper.keepAccessToken(WeiboOauthLogin._context.getActivity(),
                        accessToken);
                
                WeiboOauthLogin._context.dispatchStatusEventAsync(TAG,"认证成功");
            }
        }

        @Override
        public void onError(WeiboDialogError e) {
        	WeiboOauthLogin._context.dispatchStatusEventAsync(TAG,"Auth error : " + e.getMessage());
        }

        @Override
        public void onCancel() {
            WeiboOauthLogin._context.dispatchStatusEventAsync(TAG,"Auth cancel");
        }

        @Override
        public void onWeiboException(WeiboException e) {
        	WeiboOauthLogin._context.dispatchStatusEventAsync(TAG,"WeiboException error : " + e.getMessage());
        }

    }
	/**
	 * 登录回调 把登录结果传给AS端 一般都会把获得的游戏ID传回去  怎么传自己看着办
	 */
	public void callBack(String str){
		Log.d(TAG, "---------Login返回-------");
		_context.dispatchStatusEventAsync(TAG, "accessToken:"+str);
	}
}
