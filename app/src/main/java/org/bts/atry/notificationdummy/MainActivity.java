package org.bts.atry.notificationdummy;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Button btnStandardNotification = (Button) findViewById(R.id.buttonToNotify);
        final Button btnCustomNotification = (Button) findViewById(R.id.buttonToCustomNotify);
        btnStandardNotification.setOnClickListener(this);
        btnCustomNotification.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonToNotify:
                Log.i(MainActivity.TAG, "Notify btn clicked");
                break;
            case R.id.buttonToCustomNotify:
                Log.i(MainActivity.TAG, "Custom Notify btn clicked");
                break;
            default:
                Log.i(MainActivity.TAG, "btn not linked");
                break;
        }
    }
}
