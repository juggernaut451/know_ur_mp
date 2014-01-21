package com.ashu.aniket;



import android.os.Bundle;
import android.app.Activity;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.widget.TextView;

public class About extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_about);
		
		
		TextView t2 = (TextView) findViewById(R.id.textView2);
		t2.setMovementMethod(LinkMovementMethod.getInstance());
		TextView t3 = (TextView) findViewById(R.id.textView3);
		t3.setMovementMethod(LinkMovementMethod.getInstance());
		TextView t5 = (TextView) findViewById(R.id.textView5);
		t5.setMovementMethod(LinkMovementMethod.getInstance());
		TextView t6 = (TextView) findViewById(R.id.textView6);
		t6.setMovementMethod(LinkMovementMethod.getInstance());
	
	}
	

}
