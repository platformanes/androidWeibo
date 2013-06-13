package com.weibo.func;

import java.text.SimpleDateFormat;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;
import com.weibo.sdk.android.Oauth2AccessToken;
import com.weibo.sdk.android.Weibo;
import com.weibo.sdk.android.WeiboAuthListener;
import com.weibo.sdk.android.WeiboDialogError;
import com.weibo.sdk.android.WeiboException;
import com.weibo.sdk.android.keep.AccessTokenKeeper;
import com.weibo.sdk.android.sso.SsoHandler;

/**
 * 单点登录sso
 * @author Rect
 * @version  Time：2013-5-8 
 */
public class WeiboSingleLogin implements FREFunction {

	private String TAG = "WeiboSingleLogin";
	public static FREContext _context;
	public static Oauth2AccessToken accessToken;
	/**
     * SsoHandler 仅当sdk支持sso时有效，
     */
	private SsoHandler mSsoHandler;
	@Override
	public FREObject call(final FREContext context, FREObject[] arg1) {
		// TODO Auto-generated method stub
		_context = context;
		FREObject result = null; 
		// TODO Auto-generated method stub
		//--------------------------------
		//在这里做付费的操作 我这里直接传回。。
		if(WeiboUtil.mWeibo == null)
			WeiboUtil.mWeibo = Weibo.getInstance(WeiboUtil.CONSUMER_KEY, WeiboUtil.REDIRECT_URL);
		
		try {
            Class sso = Class.forName("com.weibo.sdk.android.sso.SsoHandler");
            _context.dispatchStatusEventAsync(TAG, "com.weibo.sdk.android.sso.SsoHandler");
        } catch (ClassNotFoundException e) {
            Log.i(TAG, "com.weibo.sdk.android.sso.SsoHandler not found");
            _context.dispatchStatusEventAsync(TAG,  "com.weibo.sdk.android.sso.SsoHandler not found");
            return null;
        }
        
        /**
         * 下面两个注释掉的代码，仅当sdk支持sso时有效，
         */

        mSsoHandler = new SsoHandler(this._context.getActivity(), WeiboUtil.mWeibo);
        mSsoHandler.authorize(new AuthDialogListener());
        
		callBack();
		//--------------------------------
		
		return result;
	}
	class AuthDialogListener implements WeiboAuthListener {

        @Override
        public void onComplete(Bundle values) {
            String token = values.getString("access_token");
            String expires_in = values.getString("expires_in");   
            WeiboSingleLogin.accessToken = new Oauth2AccessToken(token, expires_in);
            if (WeiboSingleLogin.accessToken.isSessionValid()) {
                String date = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss")
                        .format(new java.util.Date(WeiboSingleLogin.accessToken
                                .getExpiresTime()));
                
                WeiboSingleLogin._context.dispatchStatusEventAsync(TAG, "认证成功: \r\n access_token: " + token + "\r\n"
                        + "expires_in: " + expires_in + "\r\n有效期：" + date);
                try {
                    Class sso = Class
                            .forName("com.weibo.sdk.android.api.WeiboAPI");// 如果支持weiboapi的话，显示api功能演示入口按钮
                    
                } catch (ClassNotFoundException e) {  
                    // e.printStackTrace(); 
                    Log.i(TAG, "com.weibo.sdk.android.api.WeiboAPI not found");
                    WeiboSingleLogin._context.dispatchStatusEventAsync(TAG,"com.weibo.sdk.android.api.WeiboAPI not found");
                }
                
                AccessTokenKeeper.keepAccessToken(WeiboSingleLogin._context.getActivity(),
                        accessToken);
                
                WeiboSingleLogin._context.dispatchStatusEventAsync(TAG,"认证成功");
            }
        }

        @Override
        public void onError(WeiboDialogError e) {
        	WeiboSingleLogin._context.dispatchStatusEventAsync(TAG,"Auth error : " + e.getMessage());
        }

        @Override
        public void onCancel() {
            WeiboSingleLogin._context.dispatchStatusEventAsync(TAG,"Auth cancel");
        }

        @Override
        public void onWeiboException(WeiboException e) {
        	WeiboSingleLogin._context.dispatchStatusEventAsync(TAG,"WeiboException error : " + e.getMessage());
        }

    }
	/**
	 * 付费回调 把付费结果传给AS端
	 */
	public void callBack(){
		Log.d(TAG, "---------付费返回-------");
		String status = "success";
		_context.dispatchStatusEventAsync(TAG, "付费回调:"+status);
	}
}
