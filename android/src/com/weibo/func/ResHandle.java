package com.weibo.func;

import android.util.Log;

import com.adobe.fre.FREContext;

/**
 * R.java ID处理
 * @author Rect
 * @version  Time：2013-5-14 
 */
public class ResHandle {
	public static void setResourctID(FREContext _context,String TAG)
	{
		Log.d(TAG, "---------anim-------"+_context.getResourceId("drawable.bg_btn"));
		com.weibo.sdk.android.R.array.api_types = _context.getResourceId("array.api_types");
        com.weibo.sdk.android.R.array.examples = _context.getResourceId("array.examples");
        
        com.weibo.sdk.android.R.color.weibosdk_dialog_title_blue=_context.getResourceId("color.weibosdk_dialog_title_blue");
        com.weibo.sdk.android.R.color.weibosdk_text_num_gray=_context.getResourceId("color.weibosdk_text_num_gray");
        com.weibo.sdk.android.R.color.weibosdk_transparent=_context.getResourceId("color.weibosdk_transparent");
        
        com.weibo.sdk.android.R.dimen.padding_large=_context.getResourceId("dimen.padding_large");
        com.weibo.sdk.android.R.dimen.padding_medium=_context.getResourceId("dimen.padding_medium");
        com.weibo.sdk.android.R.dimen.padding_small=_context.getResourceId("dimen.padding_small");
        com.weibo.sdk.android.R.dimen.weibosdk_dialog_bottom_margin=_context.getResourceId("dimen.weibosdk_dialog_bottom_margin");
        com.weibo.sdk.android.R.dimen.weibosdk_dialog_left_margin=_context.getResourceId("dimen.weibosdk_dialog_left_margin");
        com.weibo.sdk.android.R.dimen.weibosdk_dialog_right_margin=_context.getResourceId("dimen.weibosdk_dialog_right_margin");
        com.weibo.sdk.android.R.dimen.weibosdk_dialog_top_margin=_context.getResourceId("dimen.weibosdk_dialog_top_margin");
        
        com.weibo.sdk.android.R.drawable.bg_btn = _context.getResourceId("drawable.bg_btn");
        com.weibo.sdk.android.R.drawable.bg_content = _context.getResourceId("drawable.bg_content");
        com.weibo.sdk.android.R.drawable.bg_delwords = _context.getResourceId("drawable.bg_delwords");
        com.weibo.sdk.android.R.drawable.bg_delwords_nor = _context.getResourceId("drawable.bg_delwords_nor");
        com.weibo.sdk.android.R.drawable.bg_delwords_sel = _context.getResourceId("drawable.bg_delwords_sel");
        com.weibo.sdk.android.R.drawable.bg_title = _context.getResourceId("drawable.bg_title");
        com.weibo.sdk.android.R.drawable.close_normal = _context.getResourceId("drawable.close_normal");
        com.weibo.sdk.android.R.drawable.close_press = _context.getResourceId("drawable.close_press");
        com.weibo.sdk.android.R.drawable.close_selector = _context.getResourceId("drawable.close_selector");
        com.weibo.sdk.android.R.drawable.del_pic = _context.getResourceId("drawable.del_pic");
        com.weibo.sdk.android.R.drawable.dialog_bg = _context.getResourceId("drawable.dialog_bg");
        com.weibo.sdk.android.R.drawable.ic_action_search = _context.getResourceId("drawable.ic_action_search");
        com.weibo.sdk.android.R.drawable.ic_launcher = _context.getResourceId("drawable.ic_launcher");
        com.weibo.sdk.android.R.drawable.icon = _context.getResourceId("drawable.icon");
        com.weibo.sdk.android.R.drawable.icon_delwords = _context.getResourceId("drawable.icon_delwords");
        com.weibo.sdk.android.R.drawable.image_background = _context.getResourceId("drawable.image_background");
        com.weibo.sdk.android.R.drawable.title_logo = _context.getResourceId("drawable.title_logo");
        com.weibo.sdk.android.R.drawable.weibosdk_bg_btn = _context.getResourceId("drawable.weibosdk_bg_btn");
        com.weibo.sdk.android.R.drawable.weibosdk_bg_content = _context.getResourceId("drawable.weibosdk_bg_content");
        com.weibo.sdk.android.R.drawable.weibosdk_bg_delwords = _context.getResourceId("drawable.weibosdk_bg_delwords");
        com.weibo.sdk.android.R.drawable.weibosdk_bg_delwords_nor = _context.getResourceId("drawable.weibosdk_bg_delwords_nor");
        com.weibo.sdk.android.R.drawable.weibosdk_bg_delwords_sel = _context.getResourceId("drawable.weibosdk_bg_delwords_sel");
        com.weibo.sdk.android.R.drawable.weibosdk_bg_title = _context.getResourceId("drawable.weibosdk_bg_title");
        com.weibo.sdk.android.R.drawable.weibosdk_close_normal = _context.getResourceId("drawable.weibosdk_close_normal");
        com.weibo.sdk.android.R.drawable.weibosdk_close_press = _context.getResourceId("drawable.weibosdk_close_press");
        com.weibo.sdk.android.R.drawable.weibosdk_close_selector = _context.getResourceId("drawable.weibosdk_close_selector");
        com.weibo.sdk.android.R.drawable.weibosdk_del_pic = _context.getResourceId("drawable.weibosdk_del_pic");
        com.weibo.sdk.android.R.drawable.weibosdk_dialog_bg = _context.getResourceId("drawable.weibosdk_dialog_bg");
        com.weibo.sdk.android.R.drawable.weibosdk_icon_delwords = _context.getResourceId("drawable.weibosdk_icon_delwords");
        com.weibo.sdk.android.R.drawable.weibosdk_image_background = _context.getResourceId("drawable.weibosdk_image_background");
        com.weibo.sdk.android.R.drawable.weibosdk_title_logo = _context.getResourceId("drawable.weibosdk_title_logo");

        com.weibo.sdk.android.R.id.apiCancel = _context.getResourceId("id.apiCancel");
        com.weibo.sdk.android.R.id.auth = _context.getResourceId("id.auth");
        com.weibo.sdk.android.R.id.menu_settings = _context.getResourceId("id.menu_settings");
        com.weibo.sdk.android.R.id.show = _context.getResourceId("id.show");
        com.weibo.sdk.android.R.id.sso = _context.getResourceId("id.sso");

        com.weibo.sdk.android.R.string.app_name = _context.getResourceId("string.app_name");
        com.weibo.sdk.android.R.string.menu_settings = _context.getResourceId("string.menu_settings");
        com.weibo.sdk.android.R.string.testcontent = _context.getResourceId("string.testcontent");
        com.weibo.sdk.android.R.string.title_activity_main = _context.getResourceId("string.title_activity_main");
        com.weibo.sdk.android.R.string.weibosdk_app_name = _context.getResourceId("string.weibosdk_app_name");
        com.weibo.sdk.android.R.string.weibosdk_attention = _context.getResourceId("string.weibosdk_attention");
        com.weibo.sdk.android.R.string.weibosdk_cancel = _context.getResourceId("string.weibosdk_cancel");
        com.weibo.sdk.android.R.string.weibosdk_close = _context.getResourceId("string.weibosdk_close");
        com.weibo.sdk.android.R.string.weibosdk_comment = _context.getResourceId("string.weibosdk_comment");
        com.weibo.sdk.android.R.string.weibosdk_del_pic = _context.getResourceId("string.weibosdk_del_pic");
        com.weibo.sdk.android.R.string.weibosdk_delete_all = _context.getResourceId("string.weibosdk_delete_all");
        com.weibo.sdk.android.R.string.weibosdk_fav = _context.getResourceId("string.weibosdk_fav");
        com.weibo.sdk.android.R.string.weibosdk_forward = _context.getResourceId("string.weibosdk_forward");
        com.weibo.sdk.android.R.string.weibosdk_ok = _context.getResourceId("string.weibosdk_ok");
        com.weibo.sdk.android.R.string.weibosdk_photo = _context.getResourceId("string.weibosdk_photo");
        com.weibo.sdk.android.R.string.weibosdk_please_login = _context.getResourceId("string.weibosdk_please_login");
        com.weibo.sdk.android.R.string.weibosdk_send = _context.getResourceId("string.weibosdk_send");
        com.weibo.sdk.android.R.string.weibosdk_send_failed = _context.getResourceId("string.weibosdk_send_failed");
        com.weibo.sdk.android.R.string.weibosdk_send_sucess = _context.getResourceId("string.weibosdk_send_sucess");
        com.weibo.sdk.android.R.string.weibosdk_share_dialog_title = _context.getResourceId("string.weibosdk_share_dialog_title");

        
        com.weibo.sdk.android.R.style.AppTheme=_context.getResourceId("style.AppTheme");
	}
}
