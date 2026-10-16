package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import java.lang.ref.WeakReference;
import java.util.concurrent.CancellationException;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcf extends com.google.android.gms.internal.play_billing.zzaq {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WeakReference f57517a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ResultReceiver f57518b;

    /* synthetic */ zzcf(WeakReference weakReference, ResultReceiver resultReceiver, zzch zzchVar) {
        this.f57517a = weakReference;
        this.f57518b = resultReceiver;
    }

    @Override // com.google.android.gms.internal.play_billing.zzar
    public final void zza(Bundle bundle) {
        ResultReceiver resultReceiver = this.f57518b;
        if (resultReceiver == null) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to send result for in-app messaging");
            return;
        }
        if (bundle == null) {
            resultReceiver.send(0, null);
            return;
        }
        Activity activity = (Activity) this.f57517a.get();
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("KEY_LAUNCH_INTENT");
        if (activity == null || pendingIntent == null) {
            resultReceiver.send(0, null);
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to launch intent for in-app messaging");
            return;
        }
        try {
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivity.class);
            intent.putExtra("in_app_message_result_receiver", resultReceiver);
            intent.putExtra("IN_APP_MESSAGE_INTENT", pendingIntent);
            activity.startActivity(intent);
        } catch (CancellationException e3) {
            this.f57518b.send(0, null);
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Exception caught while launching intent for in-app messaging.", e3);
        }
    }
}
