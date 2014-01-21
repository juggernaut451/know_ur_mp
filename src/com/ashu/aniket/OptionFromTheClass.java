package com.ashu.aniket;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;



import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class OptionFromTheClass extends Activity   {
	SQLiteConnector db;
// Spinner element
Spinner spinner;
private final String TAG = "ResponseUpload";
private final String FAILED_MSG = "submitted failed";
private final String SUCCESS_MSG = "submitted successful";
private String pin;
private String part;
private String other;
EditText et;
ProgressDialog pdialog;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.firstrun);
      
	
     et=(EditText)findViewById(R.id.editText2);
    // Spinner element

    
    Log.d("AISI","FIRST BUTTON WAS CLIKED");
     //Loading spinner data from database
    loadSpinnerData();
    
    spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

        public void onItemSelected(AdapterView<?> arg0, View view, int position, long id) {
        	if(position==54){
            	et.setVisibility(View.VISIBLE);
            }
        	else{
        		et.setVisibility(View.INVISIBLE);
        	}

        }
        public void onNothingSelected(AdapterView<?> arg0) { }
    });
    
}

Handler handler = new Handler() {
	@Override
	public void handleMessage(Message msg) {
		Bundle bundle = msg.getData();
		String httpStatus = bundle.getString("httpStatus");

		String prompt = FAILED_MSG;

		if (httpStatus.equalsIgnoreCase("200") == true) {
			prompt = SUCCESS_MSG;
			
		}
		
		try{
	pdialog.dismiss();
		}
		catch (Exception e){
			
		}
		Context context = getApplicationContext();
		int duration = Toast.LENGTH_SHORT;
		Toast toast = Toast.makeText(context, prompt, duration);
		toast.show();
		
		 Intent myintent = new Intent(OptionFromTheClass.this,MainActivity.class);
         startActivity(myintent);
         
        
	}
};



private void loadSpinnerData() {
    // database handler
	spinner = (Spinner) findViewById(R.id.spinner); 
db= new SQLiteConnector(this);
    // Spinner Drop down elements
    List<String> lables = db.partyfirstrun();

    // Creating adapter for spinner
    ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(OptionFromTheClass.this,android.R.layout.simple_spinner_item, db.partyfirstrun());
    
    
    // Drop down layout style - list view with radio button
    dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

    // attaching data adapter to spinner
   
  this.spinner.setAdapter(dataAdapter);
}

public void onSkip(View view) {
	Intent myintent = new Intent(OptionFromTheClass.this,MainActivity.class);
startActivity(myintent);
	
}



public void onSubmit(View view) {
	 EditText pincode = (EditText) findViewById(R.id.editText1);
	pin = pincode.getText().toString();
	part=spinner.getSelectedItem().toString();
	other=et.getText().toString();
	ProgressDialog pdialog=new ProgressDialog(OptionFromTheClass.this);
	pdialog.setCancelable(true);
	 pdialog.setMessage("Loading....");
	 pdialog.show();
	 
	
	Runnable runnable = new Runnable() {
		
		private int submitData() {

			int httpStatus = 400;

			HttpClient client = new DefaultHttpClient();

			HttpPost post = new HttpPost(
					"https://docs.google.com/forms/d/1-m4Ji9omqt7pHQMrML74a_OjU_GduR-WJ6ZUTSkoYus/formResponse");

			List<BasicNameValuePair> results = new ArrayList<BasicNameValuePair>();

			results.add(new BasicNameValuePair("entry.2042174317",
					part+" "+other));
			results.add(new BasicNameValuePair("entry.225218688",
					pin));
			

			try {
				post.setEntity(new UrlEncodedFormEntity(results));

			} catch (UnsupportedEncodingException e) {

				Log.e(TAG, "unsupported encoding exception", e);
			}
			try {

				HttpResponse httpResponse = client.execute(post);

				httpStatus = httpResponse.getStatusLine().getStatusCode();

			} catch (ClientProtocolException e) {

				Log.e(TAG, "client protocol exception", e);

			} catch (IOException e) {

				Log.e(TAG, "io exception", e);
			}

			return httpStatus;
		}

		public void run() {
			int httpStatus = submitData();

			Message msg = handler.obtainMessage();
			Bundle bundle = new Bundle();

			bundle.putString("httpStatus", String.valueOf(httpStatus));
			msg.setData(bundle);
			handler.sendMessage(msg);
			
		}
		
	};
	
	Thread mythread = new Thread(runnable);
	mythread.start();
	
}

}