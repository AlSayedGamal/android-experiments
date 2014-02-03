package com.egamal.c6;

import java.util.ArrayList;

import android.app.Activity;
import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Contacts.People;
import android.provider.ContactsContract;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.Toast;

public class Main extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        Button btn = (Button) findViewById(R.id.cButton);
        registerForContextMenu(btn);
        Button dbtn = (Button) findViewById(R.id.dButton);
          
        dbtn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
//				Intent cIntent = new Intent(Intent.ACTION_PICK, ContactsContract.Contacts.CONTENT_URI);
//				startActivity(cIntent)
				readContact();
//				Dialog d = new Dialog(Main.this);
//				Window window = d.getWindow(); window.setFlags(WindowManager.LayoutParams.FLAG_BLUR_BEHIND,WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL);
//				d.setTitle("Some dialog");
//				d.setContentView(R.layout.sampledialog);
			}
		});
    }
    
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
    		ContextMenuInfo menuInfo) {
    	// TODO Auto-generated method stub
    	super.onCreateContextMenu(menu, v, menuInfo);
    	menu.setHeaderTitle("sample");
    	menu.add(0, v.getId(), 0, "Action 1");
    	menu.add(0, v.getId(), 0, "Action 2");
    }
   
	public void readContact() {    
        ArrayList<String> contactList;
        contactList = new ArrayList<String>();

        
//		String[] columns = new String[] { People.NAME, People.NUMBER };
        String[] columns = new String[] { ContactsContract.Contacts.DISPLAY_NAME, ContactsContract.Contacts.LAST_TIME_CONTACTED };
        
		Uri mContacts = ContactsContract.Contacts.CONTENT_URI;
        
		Cursor mCur = managedQuery(mContacts, columns, null, null, ContactsContract.Contacts.DISPLAY_NAME+ " ASC ");
        if (mCur.moveToFirst()) {
            do {
                contactList.add(mCur.getString(mCur.getColumnIndex(ContactsContract.Contacts.DISPLAY_NAME)));
            } while (mCur.moveToNext());
        }
        Toast.makeText(this, contactList.size() + "", Toast.LENGTH_LONG).show();
    }
    
    @Override
    public boolean onContextItemSelected(MenuItem item) {
    	// TODO Auto-generated method stub
    	Toast.makeText(getApplicationContext(), "I'm hit", Toast.LENGTH_LONG).show();
    	return super.onContextItemSelected(item);
    }
}