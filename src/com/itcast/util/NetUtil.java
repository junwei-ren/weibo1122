package com.itcast.util;

import java.net.HttpURLConnection;
import java.net.URL;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.widget.Toast;

public class NetUtil extends BroadcastReceiver{
	//侦听网络状态的变化
	  public void onReceive( Context context, Intent intent ) 
	  { 
	    ConnectivityManager connectivityManager = (ConnectivityManager)
	        context.getSystemService( Context.CONNECTIVITY_SERVICE ); 
	              NetworkInfo info = connectivityManager.getActiveNetworkInfo(); 
	            if (info != null&& info.isConnected()) { 
	                // 判断当前网络是否已经连接 
	                if (info.getState() == NetworkInfo.State.CONNECTED) { 
	                  Toast.makeText( context, "ok", Toast.LENGTH_SHORT ).show(); 
	                }else
	                {
	                 Toast.makeText( context, "err", Toast.LENGTH_SHORT ).show(); 
	                }
	            }else
	                {
	                  Toast.makeText( context, "err", Toast.LENGTH_SHORT ).show(); 
	                }        
	   } 

	public static boolean checkNet(Context context)
	{// 获取手机所有连接管理对象（包括对wi-fi,net等连接的管理） 
	    try { 
	        ConnectivityManager connectivity = (ConnectivityManager) context 
	                .getSystemService(Context.CONNECTIVITY_SERVICE); 
	        if (connectivity != null) { 
	            // 获取网络连接管理的对象 
	            NetworkInfo info = connectivity.getActiveNetworkInfo(); 
	            if (info != null&& info.isConnected()) { 
	                // 判断当前网络是否已经连接 
	                if (info.getState() == NetworkInfo.State.CONNECTED) { 
	                    return true; 
	                }        }        } 
	    } catch (Exception e) { 
	} 
	      return false; 
	}
	//从一个URL获取图片
	public static BitmapDrawable getImageFromURL(URL url)
	{BitmapDrawable bd=null;
	 try{
	    //创建连接
		 HttpURLConnection hc=(HttpURLConnection)url.openConnection();
		//获取数据 
		bd=new BitmapDrawable(hc.getInputStream()); 
        //关闭连接	
		 hc.disconnect();
		}catch(Exception e){}
	 return bd;
	}

}
