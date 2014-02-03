package com.egamal.exercise;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class BCBeeb extends BroadcastReceiver {
	NotificationManager notificationManager;
	@Override
	public void onReceive(Context arg0, Intent arg1) {
		Toast.makeText(arg0, "Beeb !",Toast.LENGTH_LONG).show();
//		String svcName = Context.NOTIFICATION_SERVICE;
//		notificationManager = (NotificationManager) arg0.getSystemService(svcName);
//		// Choose a drawable to display as the status bar icon
//		int icon = R.drawable.icon; // Text to display in the status bar when the notification is launched
//		String tickerText = "Notification"; // The extended status bar orders notification in time order
//		long when = System.currentTimeMillis();
//		Notification notification = new Notification(icon, tickerText, when);
//		PendingIntent ben = PendingIntent.getActivity(arg0, 0, new Intent(arg0, register.class), 0);
//		notification.setLatestEventInfo(arg0, "beeb", "Training", ben);
////		notification.defaults |= Notification.DEFAULT_SOUND;
////		notification.vibrate = Notification.DEFAULT_VIBRATE;
////		notification.flags |= Notification.FLAG_AUTO_CANCEL;
//		int notificationID = 0; 
//		notificationManager.notify(notificationID, notification);
	}

}
