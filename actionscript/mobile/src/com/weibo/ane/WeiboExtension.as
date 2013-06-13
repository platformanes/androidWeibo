package com.weibo.ane 
{ 
	import flash.events.EventDispatcher;
	import flash.events.IEventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	/**
	 * 
	 * @author Rect  2013-5-6 
	 * 
	 */
	public class WeiboExtension extends EventDispatcher 
	{ 
		public static const WEIBO_FUNCTION_INIT:String = "weibo_function_init";//与java端中Map里的key一致
		public static const WEIBO_FUNCTION_OAUTH_LOGIN:String = "weibo_function_oauth_login";//与java端中Map里的key一致
		public static const WEIBO_FUNCTION_SINGLE_LOGIN:String = "weibo_function_single_login";//与java端中Map里的key一致
		public static const WEIBO_FUNCTION_EXIT:String = "weibo_function_exit";//与java端中Map里的key一致
		
		public static const EXTENSION_ID:String = "com.weibo.ane";//与extension.xml中的id标签一致
		private var extContext:ExtensionContext;
		
		/**单例的实例*/
		private static var _instance:WeiboExtension; 
		public function WeiboExtension(target:IEventDispatcher=null)
		{
			super(target);
			if(extContext == null) {
				extContext = ExtensionContext.createExtensionContext(EXTENSION_ID, "");
				extContext.addEventListener(StatusEvent.STATUS, statusHandler);
			}
			
		} 
		
		//第二个为参数，会传入java代码中的FREExtension的createContext方法
		/**
		 * 获取实例
		 * @return DLExtension 单例
		 */
		public static function getInstance():WeiboExtension
		{
			if(_instance == null) 
				_instance = new WeiboExtension();
			return _instance;
		}
		
		/**
		 * 转抛事件
		 * @param event 事件
		 */
		private function statusHandler(event:StatusEvent):void
		{
			dispatchEvent(event);
		}
		
		/**
		 * 
		 * @param CONSUMER_KEY
		 * @param REDIRECT_URL
		 * @return 
		 * 
		 */			
		public function WeiboInit(CONSUMER_KEY:String,REDIRECT_URL:String):String{
			if(extContext ){
				return extContext.call(WEIBO_FUNCTION_INIT,CONSUMER_KEY,REDIRECT_URL) as String;
			}
			return "call login failed";
		} 
		
		/**
		 *登录发送函数  
		 * @param key 暂时传什么都可以  留着可能要用
		 * @return 
		 * 
		 */		
		public function WeiboOauthLogIn(key:int):String{
			if(extContext ){
				return extContext.call(WEIBO_FUNCTION_OAUTH_LOGIN,key) as String;
			}
			return "call login failed";
		} 
		/**
		 * 发送函数 
		 * @param key 暂时传什么都可以 留着以后可能要用
		 * @return 
		 * 
		 */		 
		public function WeiboSingleLogin(key:int):String{
			if(extContext ){ 
				return extContext.call(WEIBO_FUNCTION_SINGLE_LOGIN,key)as String;
			}
			return "call pay failed";
		}
		
		/**
		 *退出SDK时候调用   这个函数只在退出游戏的时候调用  
		 * @param key
		 * @return 
		 * 
		 */		
		public function WeiboExit(key:int):String{
			if(extContext){ 
				return extContext.call(WEIBO_FUNCTION_EXIT,key) as String;
			}
			return "call exit failed";
		}
	} 
}