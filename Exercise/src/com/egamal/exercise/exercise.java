package com.egamal.exercise;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class exercise extends Activity {
    /** Called when the activity is first created. */
	Button startExerciseButton = null;
	Button cancelExerciseButton = null;
	EditText counterValue = null;
	EditText periodValue = null;
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exercise_settings);
        startExerciseButton = (Button) findViewById(R.id.startBtn);
        cancelExerciseButton = (Button) findViewById(R.id.cnclBtn);
        counterValue = (EditText) findViewById(R.id.counter);
        periodValue = (EditText) findViewById(R.id.period);
        startExerciseButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Intent BeebService = new Intent(exercise.this, BeebService.class);
				Integer period = Integer.parseInt( periodValue.getText().toString());
				Integer counter = Integer.parseInt( counterValue.getText().toString());
				BeebService.putExtra("period", period);
				BeebService.putExtra("counter", counter);
				startService(BeebService);
			}
		});
        
        cancelExerciseButton.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
        
    }
}