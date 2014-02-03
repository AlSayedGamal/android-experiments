package com.egamal.Login;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.preference.PreferenceCategory;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class home extends Activity {
    /** Called when the activity is first created. */
	SharedPreferences preferences;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String username = preferences.getString("username", "n/a");
		String password = preferences.getString("password", "n/a");
        if(username.equals("Ahmed") && password.equals("123")){
			Intent next = new Intent(home.this, Next.class);
			startActivity(next);
			finish();
		}
        Button LoginButton = (Button) findViewById(R.id.login);
        final EditText Username = (EditText) findViewById(R.id.username);
        final EditText Password = (EditText) findViewById(R.id.password);
        LoginButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				String usernameValue = Username.getText().toString();
				String passwordValue = Password.getText().toString();
				if(usernameValue.equals("Ahmed") && passwordValue.equals("123")){
					Editor psEditor = preferences.edit();
					psEditor.putString("username", "Ahmed");
					psEditor.putString("password", "123");
					psEditor.commit();
					Intent next = new Intent(home.this, Next.class);
					startActivity(next);
					finish();
				}else{
					Toast.makeText(getApplicationContext(), "Wrong username/password", Toast.LENGTH_LONG).show();
				}
				
			}
		});
    }
}