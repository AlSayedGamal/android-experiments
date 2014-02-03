package com.egamal.exercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class register extends Activity {
	/** Called when the activity is first created. */
	Button CancelButton;
	Button RegisterButton;
	EditText nameText;
	EditText ageText;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.register_form);
		CancelButton = (Button) findViewById(R.id.cnclBtn);
		RegisterButton = (Button) findViewById(R.id.rgstrBtn);
		nameText = (EditText)findViewById(R.id.nameEdtTxt);
		ageText = (EditText)findViewById(R.id.ageEdtTxt);
		
		// if the cancel button is clicked close the application forever.

		CancelButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				finish();
			}
		});
		RegisterButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String username = nameText.getText().toString();
				String userage = ageText.getText().toString();
				Intent delegate = new Intent(register.this,view_user_data.class);
				delegate.putExtra("username", username);
				delegate.putExtra("userage", userage);
				startActivity(delegate);
				finish();
			}
		});

	}
}