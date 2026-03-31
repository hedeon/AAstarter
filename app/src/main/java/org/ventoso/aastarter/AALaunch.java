package org.ventoso.aastarter;

import android.content.Context;
import android.content.Intent;

public class AALaunch {

    private static final String PACKAGE_NAME_ANDROID_AUTO_WIRELESS = "com.google.android.projection.gearhead";
    private static final String RECEIVER_CLASS_NAME = "com.google.android.apps.auto.wireless.setup.receiver.WirelessStartupReceiver";
    private static final String ACTION_START = "com.google.android.apps.auto.wireless.setup.receiver.wirelessstartup.START";

    private static final String EXTRA_IP_ADDRESS = "ip_address";
    private static final String EXTRA_PROJECTION_PORT = "projection_port";

    private static final int FIXED_PORT = 5288;

    public static void connect(Context context, String address) {
        Intent intent = new Intent();

        intent.setClassName(PACKAGE_NAME_ANDROID_AUTO_WIRELESS, RECEIVER_CLASS_NAME);
        intent.setAction(ACTION_START);

        intent.putExtra(EXTRA_IP_ADDRESS, address);
        intent.putExtra(EXTRA_PROJECTION_PORT, FIXED_PORT);

        intent.addFlags(Intent.FLAG_RECEIVER_FOREGROUND);

        context.sendBroadcast(intent);
    }
}