package com.edwin.cobos.appmessagingfcm.services;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.media.RingtoneManager;
import android.net.Uri;
import android.support.v4.app.NotificationCompat;
import android.support.v4.content.res.ResourcesCompat;
import android.util.Log;

import com.edwin.cobos.appmessagingfcm.R;
import com.edwin.cobos.appmessagingfcm.activities.ResultActivity;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

/**
 * @author edwin.cobos
 * @since 18/04/2017
 */

public class FcmService extends FirebaseMessagingService {

    private static final String TAG = "FcmService";

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        //super.onMessageReceived(remoteMessage);
        Log.d(TAG, "From: " + remoteMessage.getFrom());
        Log.d(TAG, "Notification Message Body: " + remoteMessage.getNotification().getBody());
        createNotification(remoteMessage);
    }

    private void createNotification(RemoteMessage remoteMessage) {
        String messageBody = remoteMessage.getNotification().getBody();

        Map<String, String> map = remoteMessage.getData();
        HashMap<String, String> hMap = (map instanceof HashMap)
                                       ? (HashMap<String, String>) map
                                       : new HashMap<>(map);

        Intent intent = new Intent(this, ResultActivity.class);
        intent.putExtra("dataMap", hMap);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

        PendingIntent resultIntent = PendingIntent.getActivity(this, 0, intent,
                PendingIntent.FLAG_ONE_SHOT);

        Bitmap bmp = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_notification_icon);

        Uri notificationSoundURI = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        NotificationCompat.Builder mNotificationBuilder = new NotificationCompat.Builder(this)
                .setSmallIcon(R.drawable.ic_security)
                .setLargeIcon(bmp)
                .setColor(Color.rgb(255, 72, 72))
                .setContentTitle("FCM message")
                .setPriority(Notification.PRIORITY_MAX)
                .setContentText(messageBody)
                .setAutoCancel(true)
                .setSound(notificationSoundURI)
                .setContentIntent(resultIntent);

        NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify(0, mNotificationBuilder.build());
    }
}
