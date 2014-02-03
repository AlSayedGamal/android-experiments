package com.egamal.exercise;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class splash extends Activity {
    /** Called when the activity is first created. */
	private boolean _active = true;
    private int _splashTime = 3000; // time to display the splash screen in ms 3000 = 3thwane..
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        Thread splashTread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    while(_active && (waited < _splashTime)) {
                        sleep(100);
                        if(_active) {
                            waited += 100;
                        }
                    }
                } catch(InterruptedException e) {
                    // do nothing
                } finally {
                    finish();
                    Intent delegate = new Intent(splash.this, register.class);
    				startActivity(delegate);
                    stop();
                }
            }
        };
        splashTread.start();
        
    }
}