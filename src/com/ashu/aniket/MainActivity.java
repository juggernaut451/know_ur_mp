package com.ashu.aniket;




import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.widget.Button;

public class MainActivity extends Activity 
{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
	}
	//@Override
	public void onClick1(View arg0) {
				final Context context = this;
		  Intent intent = new Intent(context, Statewise.class);
          startActivity(intent);  
          Log.d("AISI","FIRST BUTTON WAS CLIKED");
		}
	public void onClick2(View arg0) {
		final Context context = this;
  Intent intent = new Intent(context, Constituency.class);
  startActivity(intent);  
  Log.d("AISI","Second BUTTON WAS CLIKED");
 
}
	public void onClick3(View arg0) {
		final Context context = this;
  Intent intent = new Intent(context, Mpbyname.class);
  startActivity(intent);  
  Log.d("AISI","THIRD BUTTON WAS CLIKED");
}
	public void onClick4(View arg0) {
		final Context context = this;
  Intent intent = new Intent(context, About.class);
  startActivity(intent);  
  Log.d("AISI","Fourth BUTTON WAS CLIKED");
}
}