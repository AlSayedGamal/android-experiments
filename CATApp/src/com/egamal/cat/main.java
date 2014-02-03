package com.egamal.cat;

import android.app.Activity;
import android.content.ContentValues;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button save = (Button) findViewById(R.id.save);
        Button getLastest = (Button) findViewById(R.id.button1);
        final ContentValues cv = new ContentValues();
        final CATAdaptor DbAdaptor = new CATAdaptor(getApplicationContext());
        save.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				cv.clear();
				EditText  FirstNameView = (EditText) findViewById(R.id.first_name);
				EditText  LastNameView = (EditText) findViewById(R.id.last_name);
				String LastName = LastNameView.getText().toString();
				String FirstName = FirstNameView.getText().toString();
				cv.put(DbAdaptor.USER_F_NAME, FirstName);
				cv.put(DbAdaptor.USER_L_NAME, LastName);
				DbAdaptor.open().insert(cv);
				DbAdaptor.close();
			}
		});
        
        getLastest.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				DbAdaptor.open();
				String[] TheUser = DbAdaptor.GetLastUser();
				DbAdaptor.close();
				Toast.makeText(getApplicationContext(), "The lastest name is " + TheUser[1] + TheUser[2], Toast.LENGTH_SHORT);
			}
		});
    }
}