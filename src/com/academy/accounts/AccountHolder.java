package com.academy.accounts;

import com.google.android.gms.auth.GoogleAuthUtil;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.preference.PreferenceManager;
import android.util.Log;


public class AccountHolder {
	private static String accountEmail = null;
	private static String accountName = null;
	private static String token = null;
	static Context context;
	
	private static final String KEY_ACCOUNT_EMAIL = "account_email";
	private static final String KEY_ACCOUNT_NAME = "account_name";
	
	public static Account getGoogleAccountByEmail(Context c, String email){
		if(email != null)
		{
			AccountManager manager = AccountManager.get(c);
			Account[] accounts = manager.getAccountsByType(GoogleAuthUtil.GOOGLE_ACCOUNT_TYPE);
			for(Account account:accounts)
			{
				if(account.name.equals(email))
					return account;
			}
			
		}
		return null;
			
	}

	public static String getAccountEmail(Context c){
		if(accountEmail != null)
			return accountEmail;
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);
		return prefs.getString(KEY_ACCOUNT_EMAIL, null);
		
	}
	
	public static void setAccountEmail(Context c, String email){
		Editor editor = PreferenceManager.getDefaultSharedPreferences(c).edit();
		editor.putString(KEY_ACCOUNT_EMAIL, email);
		editor.apply();
		
		accountEmail = email;
		context = c;
	}
	
	public static String getAccountName(Context c){
		if(accountName != null)
			return accountName;
		SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(c);
		return prefs.getString(KEY_ACCOUNT_NAME, null);
		
	}
	
	public static void setAccountName(Context c, String name){
		Editor editor = PreferenceManager.getDefaultSharedPreferences(c).edit();
		editor.putString(KEY_ACCOUNT_NAME, name);
		editor.apply();
		
		accountName = name;
	}
	
	public static void removeAccount(Context c){
		Editor editor = PreferenceManager.getDefaultSharedPreferences(c).edit();
		editor.remove(KEY_ACCOUNT_EMAIL);
		editor.apply();
		
		accountEmail = null;
	}
	
	public static void getToken(){
		Log.v("context status", ""+context);
		try{
			Log.v("started gettoken", "started getTok " + accountEmail);
					token = GoogleAuthUtil.getToken(context, accountEmail, "oauth2:https://www.googleapis.com/auth/plus.me");
					Log.v("token", token);
		} catch(Exception e){
			e.printStackTrace();
		}
	}
	
	
}
