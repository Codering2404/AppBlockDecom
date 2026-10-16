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
final class zzbz extends com.google.android.gms.internal.play_billing.zzad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WeakReference f57498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ResultReceiver f57499b;

    /* synthetic */ zzbz(WeakReference weakReference, ResultReceiver resultReceiver, zzch zzchVar) {
        this.f57498a = weakReference;
        this.f57499b = resultReceiver;
    }

    @Override // com.google.android.gms.internal.play_billing.zzae
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            this.f57499b.send(6, null);
            return;
        }
        if (!bundle.containsKey("RESPONSE_CODE")) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Response bundle doesn't contain a response code");
            this.f57499b.send(6, bundle);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to launch intent for alternative billing only dialog" + iZzb);
            this.f57499b.send(iZzb, bundle);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT");
        if (pendingIntent == null) {
            com.google.android.gms.internal.play_billing.zzc.zzn("BillingClient", "User has acknowledged the alternative billing only dialog before.");
            this.f57499b.send(0, bundle);
            return;
        }
        try {
            Activity activity = (Activity) this.f57498a.get();
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivityV2.class);
            intent.putExtra("alternative_billing_only_dialog_result_receiver", this.f57499b);
            intent.putExtra("ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT", pendingIntent);
            activity.startActivity(intent);
        } catch (RuntimeException e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Runtime error while launching intent for alternative billing only dialog.", e3);
            Bundle bundle2 = new Bundle();
            bundle2.putInt("RESPONSE_CODE", 6);
            bundle2.putString("DEBUG_MESSAGE", "An internal error occurred.");
            bundle2.putInt("INTERNAL_LOG_ERROR_REASON", zzjd.RUNTIME_EXCEPTION_ON_LAUNCHING_ALTERNATIVE_BILLING_ONLY_DIALOG_INTENT.zza());
            bundle2.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", String.format("%s: %s", e3.getClass().getName(), com.google.android.gms.internal.play_billing.zzbm.zzc(e3.getMessage())));
            this.f57499b.send(6, bundle2);
        }
    }
}
