package com.ashu.aniket;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.AdapterView.OnItemClickListener;

public class showall extends Activity {
	SQLiteConnector sqlConnect;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.text);
		System.out.println("oye");
	ListView listmpbyname1 = (ListView) findViewById(R.id.listView7);
	sqlConnect = new SQLiteConnector(this);
	
	ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
			android.R.layout.simple_list_item_1, sqlConnect.getall());
	ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, R.layout.color, sqlConnect.getall());
	listmpbyname1.setAdapter(adapter1);
	}
	
	
	
}
