package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzjd;
import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcb extends com.google.android.gms.internal.play_billing.zzah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WeakReference f57506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ResultReceiver f57507b;

    /* synthetic */ zzcb(WeakReference weakReference, ResultReceiver resultReceiver, zzch zzchVar) {
        this.f57506a = weakReference;
        this.f57507b = resultReceiver;
    }

    @Override // com.google.android.gms.internal.play_billing.zzai
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            this.f57507b.send(6, null);
            return;
        }
        if (!bundle.containsKey("RESPONSE_CODE")) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Response bundle doesn't contain a response code");
            this.f57507b.send(6, bundle);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to launch intent for external offer dialog" + iZzb);
            this.f57507b.send(iZzb, bundle);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("EXTERNAL_PAYMENT_DIALOG_INTENT");
        if (pendingIntent == null) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "The PendingIntent for the external offer dialog is null");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("RESPONSE_CODE", 6);
            bundle2.putString("DEBUG_MESSAGE", "An internal error occurred.");
            this.f57507b.send(6, bundle2);
            return;
        }
        try {
            Activity activity = (Activity) this.f57506a.get();
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivityV2.class);
            intent.putExtra("external_payment_dialog_result_receiver", this.f57507b);
            intent.putExtra("external_payment_dialog_pending_intent", pendingIntent);
            activity.startActivity(intent);
        } catch (RuntimeException e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Runtime error while launching intent for the external offer dialog.", e3);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("RESPONSE_CODE", 6);
            bundle3.putString("DEBUG_MESSAGE", "An internal error occurred.");
            bundle3.putInt("INTERNAL_LOG_ERROR_REASON", zzjd.RUNTIME_EXCEPTION_ON_LAUNCHING_EXTERNAL_PAYMENT_DIALOG_INTENT.zza());
            bundle3.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", String.format("%s: %s", e3.getClass().getName(), com.google.android.gms.internal.play_billing.zzbm.zzc(e3.getMessage())));
            this.f57507b.send(6, bundle3);
        }
    }
}
