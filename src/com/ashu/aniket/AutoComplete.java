package com.ashu.aniket;

import java.util.List;



import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class AutoComplete extends Activity{
	
	SQLiteConnector sqlConnect;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.autocomplete);
		
        AutoCompleteTextView acTextView = (AutoCompleteTextView)findViewById(R.id.AndroidBooks);
       
      
     //  String[] countries = sqlConnect.auto();
       
       // Print out the values to the log
       ArrayAdapter<String> adapter =new ArrayAdapter<String>(this,
               android.R.layout.simple_dropdown_item_1line, sqlConnect.partyfirstrun());
       
       acTextView.setAdapter(adapter);
  
	
	}
}
