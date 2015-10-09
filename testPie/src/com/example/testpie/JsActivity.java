package com.example.testpie;


import  com.example.testpie.R;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.Gson;

import android.support.v7.app.ActionBarActivity;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

@SuppressLint("JavascriptInterface")
public class JsActivity extends Activity {
	 
	 WebView myBrowser;
	 EditText Msg;
	 Button btnSendMsg;
	 String in =" raja";
	 
	 /** Called when the activity is first created. ****/
	   @Override
	   public void onCreate(Bundle savedInstanceState) {
	       super.onCreate(savedInstanceState);
	       setContentView(R.layout.activity_js);
	       myBrowser = (WebView)findViewById(R.id.mybrowser);
	      
	       final MyJavaScriptInterface myJavaScriptInterface
	        = new MyJavaScriptInterface(this);
	       myBrowser.addJavascriptInterface(myJavaScriptInterface, "AndroidFunction");
	      
	       myBrowser.getSettings().setJavaScriptEnabled(true); 
	       myBrowser.getSettings().setLoadWithOverviewMode(true);
	       myBrowser.getSettings().setUseWideViewPort(true);
	       myBrowser.setInitialScale(40);
	       myBrowser.loadUrl("file:///android_asset/mypage.html");
	      
	       
	       
	       //data();
	      // Msg = (EditText)findViewById(R.id.msg);
	       
	    btnSendMsg = (Button)findViewById(R.id.sendmsg);
	    btnSendMsg.setOnClickListener(new Button.OnClickListener(){

	   @Override
	   public void onClick(View arg0) {
	    // TODO Auto-generated method stub
	   // myBrowser.loadUrl("javascript:callFromActivity(\""+msgToSend+"\")");
	    myBrowser.loadUrl("javascript:callme(\""+in+"\")");
	   }});
	    
	       
	   }
	   
	   private String data(){
		   
		   Gson json = new Gson();
		   
		   
		  List<com.example.model.data> me = new ArrayList<>();
		  me.add(new com.example.model.data("Czech Republic","301.90"));
		  me.add(new com.example.model.data("Ireland","201.10"));
		  me.add(new com.example.model.data("Germany","165.80"));
		  me.add(new com.example.model.data("Australia","139.90"));
		  
		   Log.e(">>> ",json.toJson(me));
		   return "cicin"; //json.toJson(me);
	   }
	  
	 public class MyJavaScriptInterface {
	  Context mContext;

	     MyJavaScriptInterface(Context c) {
	         mContext = c;
	     }
	    
	     public void showToast(String toast){
	         Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
	     }
	    
	     public void openAndroidDialog(){
	      AlertDialog.Builder myDialog
	      = new AlertDialog.Builder(JsActivity.this);
	      myDialog.setTitle("DANGER!");
	      myDialog.setMessage("You can do what you want!");
	      myDialog.setPositiveButton("ON", null);
	      myDialog.show();
	     }
	     
	     public String data(){
			   
			   Gson json = new Gson();
			   
			   
			  List<com.example.model.data> me = new ArrayList<>();
			  me.add(new com.example.model.data("Czech Republic","301.90"));
			  me.add(new com.example.model.data("Ireland","201.10"));
			  me.add(new com.example.model.data("Germany","165.80"));
			  me.add(new com.example.model.data("Australia","139.90"));
			  me.add(new com.example.model.data("Czech ","15"));
			  me.add(new com.example.model.data("yyy","120"));
			  me.add(new com.example.model.data("dfb","44"));
			  me.add(new com.example.model.data("dfd","12"));
			  
			   Log.e(">>> ",json.toJson(me));
			   return json.toJson(me);
		   }

	 }
	}