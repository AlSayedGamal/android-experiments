package com.egamal.exercise;

import java.util.Timer;
import java.util.TimerTask;
import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.widget.Toast;

public class BeebService extends Service {
	private TimerTask makeABeeb;
	Timer beebTimer;
	int counter;
	int period;
	@Override
	public IBinder onBind(Intent intent) {
		return null;
	}

	@Override
	public void onStart(Intent intent, int startId) {
		// TODO Auto-generated method stub
		super.onStart(intent, startId);
		beebTimer = new Timer("beebTime");
		Toast.makeText(getApplicationContext(), "service called!", Toast.LENGTH_LONG).show();
		Intent delegate = intent;
		period =delegate.getExtras().getInt("period");
		counter =delegate.getExtras().getInt("counter");
		makeABeeb = new TimerTask() {
			@Override
			public void run() {
				if (counter <= 0){
					beebTimer.cancel();
					return;
				}
				Intent BCReciever = new Intent("com.egamal.exercise.BCBeeb");
				sendBroadcast(BCReciever);
				counter--;
			}
		};
		beebTimer.scheduleAtFixedRate(makeABeeb,(period*60000/counter), (period*60000/counter));
		
	}
}
