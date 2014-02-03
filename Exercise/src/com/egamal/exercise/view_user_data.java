package com.egamal.exercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

public class view_user_data extends Activity {
	/** Called when the activity is first created. */
	private Button BackButton;
	private Button StartButton;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		// get the intent that loaded you
		Intent intent = getIntent();
		// get values from the intent
		String username = intent.getExtras().getString("username");
		String age = intent.getExtras().getString("userage");


		setContentView(R.layout.view_user_data);
		// set the values of the inputs based on the values we got from the
		// intent
		// we placed that line after the layout to be able to load it..
		TextView usernameView = (TextView) findViewById(R.id.userName);
		TextView userageView = (TextView) findViewById(R.id.userAge);
		BackButton = (Button) findViewById(R.id.backBtn);
        StartButton = (Button) findViewById(R.id.startBtn);
		usernameView.setText(username);
		userageView.setText(age);

		// now handle buttons
		BackButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				 Intent delegate = new Intent(view_user_data.this, register.class);
 				startActivity(delegate);
 				finish();
			}
		});
		StartButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				 Intent delegate = new Intent(view_user_data.this, exercise.class);
 				startActivity(delegate);
 				finish();
			}
		});

	}
}