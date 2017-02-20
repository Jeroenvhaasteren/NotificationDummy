package org.bts.atry.notificationdummy;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.NotificationCompat;
//import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RemoteViews;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnStandardNotification = (Button) findViewById(R.id.button_to_notify);
        final Button btnCustomNotification = (Button) findViewById(R.id.button_to_custom_notify);
        btnStandardNotification.setOnClickListener(this);
        btnCustomNotification.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.button_to_notify:
                triggerRegularNotification();
                Log.i(MainActivity.TAG, "Notify btn clicked");
                break;
            case R.id.button_to_custom_notify:
                triggerCustomNotification();
                Log.i(MainActivity.TAG, "Custom Notify btn clicked");
                break;
            default:
                Log.i(MainActivity.TAG, "btn not linked");
                break;
        }
    }

    private void triggerCustomNotification() {
        RemoteViews mRemoteViews = new RemoteViews(this.getPackageName(),R.layout.layout_custom_notification);
    }

    private void triggerRegularNotification() {

        android.support.v4.app.NotificationCompat.Builder mBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setContentTitle("My Notification")
                .setContentText("Simple text in my notification")
                .setAutoCancel(true);

        Intent notificationIntent = new Intent(this, MainActivity.class);

        PendingIntent mPendingIntent = PendingIntent
                .getActivity(this, 1, notificationIntent, PendingIntent.FLAG_CANCEL_CURRENT);

        mBuilder.setContentIntent(mPendingIntent);

        NotificationManager mNotifManager = (NotificationManager) this
                .getSystemService(Service.NOTIFICATION_SERVICE);

        mNotifManager.notify(2, mBuilder.build());


    }
}
