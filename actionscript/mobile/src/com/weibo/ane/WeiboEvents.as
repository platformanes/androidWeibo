package com.weibo.ane 
{ 
	/**
	 * 
	 * @author Rect  2013-5-6 
	 * 
	 */
	public class WeiboEvents 
	{ 
		public function WeiboEvents()
		{
		} 
		/**************************平台通知************************************/
		/**
		 *init 
		 */		
		public static const WEIBO_SDK_STATUS:String = "WeiboInit";
		/**
		 * 
		 */
		public static const WEIBO_OAUTH_LOGIN_STATUS : String = "WeiboOauthLogin";
		
		/**
		 * 
		 */
		public static const WEIBO_SINGLE_LOGIN_STATUS : String = "WeiboSingleLogin";
		
		/**
		 * 
		 */
		public static const WEIBO_EXIT_STATUS : String = "WeiboExit";
	} 
}