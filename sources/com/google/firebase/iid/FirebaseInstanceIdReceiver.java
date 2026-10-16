package com.google.firebase.iid;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.google.android.gms.cloudmessaging.CloudMessage;
import com.google.android.gms.cloudmessaging.CloudMessagingReceiver;
import com.google.android.gms.tasks.Tasks;
import com.google.firebase.messaging.FcmBroadcastProcessor;
import com.google.firebase.messaging.MessagingAnalytics;
import java.util.concurrent.ExecutionException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public final class FirebaseInstanceIdReceiver extends CloudMessagingReceiver {
    private static Intent f(Context context, String str, Bundle bundle) {
        return new Intent(str).putExtras(bundle);
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    protected int b(Context context, CloudMessage cloudMessage) {
        try {
            return ((Integer) Tasks.await(new FcmBroadcastProcessor(context).g(cloudMessage.M()))).intValue();
        } catch (InterruptedException | ExecutionException e3) {
            Log.e("FirebaseMessaging", "Failed to send message to service.", e3);
            return 500;
        }
    }

    @Override // com.google.android.gms.cloudmessaging.CloudMessagingReceiver
    protected void c(Context context, Bundle bundle) {
        Intent intentF = f(context, "com.google.firebase.messaging.NOTIFICATION_DISMISS", bundle);
        if (MessagingAnalytics.D(intentF)) {
            MessagingAnalytics.v(intentF);
        }
    }
}
