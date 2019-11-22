package ml.jaypatel.slwc;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

public class Device_Screen_Off extends BroadcastReceiver {


    // test -  ./adb shell am broadcast -a android.intent.action.ACTION_SCREEN_OFF -c android.intent.category.HOME -n m.jaypatel.slwc/Device_Screen_Off

    public Device_Screen_Off() {
        super();

    }

    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.
        if (intent.getAction().equals(Intent.ACTION_SCREEN_OFF)) {
            // do whatever you need to do here
            Log.d("DEVICESTATUS", "LOCKED");

        } else if (intent.getAction().equals(Intent.ACTION_SCREEN_ON)) {
            // and do whatever you need to do here
            Log.d("DEVICESTATUS", "Unlocked");
        }


    }

    @Override
    public IBinder peekService(Context myContext, Intent service) {
        return super.peekService(myContext, service);
    }
}
