package com.ashu.aniket;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;

public class First_run extends Activity {

    SharedPreferences prefs = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Perhaps set content view here

        prefs = getSharedPreferences("com.mycompany.myAppName", MODE_PRIVATE);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (prefs.getBoolean("firstrun", true)) {
            // Do first run stuff here then set 'firstrun' as false
            // using the following line to edit/commit prefs
        	Intent i = new Intent(First_run.this, OptionFromTheClass.class);
            startActivity(i);
            prefs.edit().putBoolean("firstrun", false).commit();
        }
        else
        {Intent i = new Intent(First_run.this, MainActivity.class);
        startActivity(i);
        }
    }
}