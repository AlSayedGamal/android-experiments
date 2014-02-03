package com.egamal.Login;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

import android.app.Activity;
import android.content.SharedPreferences;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

public class Next extends Activity {
	SharedPreferences pref;
	
	private String readFileFromInternalStorage() {
		Environment.getExternalStorageState().equals(Environment.MEDIA_MOUNTED);
		File directory = Environment.getExternalStorageDirectory();
		File file = new File(directory + "/article.rss");
		String eol = System.getProperty("line.separator");
		BufferedReader input = null;
		StringBuffer buffer = new StringBuffer();
		try {
			input = new BufferedReader(new InputStreamReader(
					openFileInput("names")));
			String line;
			while ((line = input.readLine()) != null) {
				buffer.append(line + eol);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (input != null) {
				try {
					input.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}
		return buffer.toString();
	}

	protected void onCreate(android.os.Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.second);
		pref = PreferenceManager.getDefaultSharedPreferences(this);
		String username = pref.getString("username", "n/a");
		String password = pref.getString("password", "n/a");
		Toast.makeText(
				getApplicationContext(),
				"Your username is: " + username + " and your password is: "
						+ password, Toast.LENGTH_LONG).show();
		Button changeImage = (Button) findViewById(R.id.chImg);
		Button RdButton = (Button) findViewById(R.id.rdButton);
		Button WrtButton = (Button) findViewById(R.id.wrtButton);

		RdButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String names = readFileFromInternalStorage();
				Toast.makeText(getApplicationContext(), "names are: " + names,
						Toast.LENGTH_LONG).show();
			}
		});

		WrtButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				String sep = System.getProperty("line.separator");
				BufferedWriter wrt = null;
				try {
					wrt = new BufferedWriter(new OutputStreamWriter(
							openFileOutput("names", MODE_WORLD_WRITEABLE)));
					wrt.write("Ahmed" + sep);
					wrt.write("Ali" + sep);
					wrt.write("Osama" + sep);
					wrt.write("Nowair" + sep);
				} catch (FileNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IOException e) {
					try {
						wrt.close();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				} finally {
					try {
						wrt.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}

			}
		});

		changeImage.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				ImageView myImg = (ImageView) findViewById(R.id.sampleImg);
				AssetManager manger = getAssets();
				try {
					InputStream img = manger.open("img.png");
					Bitmap carImg = BitmapFactory.decodeStream(img);
					myImg.setImageBitmap(carImg);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

	};
}