package com.android.billingclient.api;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.os.Bundle;
import android.os.ResultReceiver;
import com.google.android.gms.internal.play_billing.zzjd;
import java.lang.ref.WeakReference;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcc extends com.google.android.gms.internal.play_billing.zzah {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WeakReference f57508a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final ResultReceiver f57509b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ BillingClientImpl f57510c;

    /* synthetic */ zzcc(BillingClientImpl billingClientImpl, WeakReference weakReference, LaunchExternalLinkResponseListener launchExternalLinkResponseListener, zzch zzchVar) {
        Objects.requireNonNull(billingClientImpl);
        this.f57510c = billingClientImpl;
        this.f57508a = weakReference;
        this.f57509b = BillingClientImpl.r1(billingClientImpl, launchExternalLinkResponseListener);
    }

    @Override // com.google.android.gms.internal.play_billing.zzai
    public final void zza(Bundle bundle) {
        if (bundle == null) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Response bundle is null.");
            this.f57510c.h1(zzjd.NULL_BUNDLE_RETURNED_BY_PHONESKY, 37, zzdc.f57558h);
            this.f57509b.send(6, null);
            return;
        }
        if (!bundle.containsKey("RESPONSE_CODE")) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Response bundle doesn't contain a response code.");
            this.f57510c.h1(zzjd.MISSING_RESPONSE_CODE_IN_PHONESKY_BUNDLE, 37, zzdc.f57558h);
            this.f57509b.send(6, bundle);
            return;
        }
        int iZzb = com.google.android.gms.internal.play_billing.zzc.zzb(bundle, "BillingClient");
        if (iZzb != 0) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Unable to launch intent for launch external link dialog. Response code: " + iZzb);
            this.f57509b.send(iZzb, bundle);
            return;
        }
        PendingIntent pendingIntent = (PendingIntent) bundle.getParcelable("EXTERNAL_PAYMENT_DIALOG_INTENT");
        if (pendingIntent == null) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingClient", "Pending intent not found in response bundle.");
            Bundle bundle2 = new Bundle();
            bundle2.putInt("RESPONSE_CODE", 6);
            bundle2.putString("DEBUG_MESSAGE", "An internal error occurred.");
            this.f57509b.send(6, bundle);
            return;
        }
        try {
            Activity activity = (Activity) this.f57508a.get();
            Intent intent = new Intent(activity, (Class<?>) ProxyBillingActivityV2.class);
            intent.putExtra("launch_external_link_result_receiver", this.f57509b);
            intent.putExtra("launch_external_link_flow_pending_intent", pendingIntent);
            activity.startActivity(intent);
        } catch (RuntimeException e3) {
            com.google.android.gms.internal.play_billing.zzc.zzp("BillingClient", "Runtime error while launching intent for launch external link dialog.", e3);
            Bundle bundle3 = new Bundle();
            bundle3.putInt("RESPONSE_CODE", 6);
            bundle3.putString("DEBUG_MESSAGE", "An internal error occurred.");
            bundle3.putInt("INTERNAL_LOG_ERROR_REASON", zzjd.RUNTIME_EXCEPTION_ON_LAUNCH_EXTERNAL_LINK_INTENT.zza());
            bundle3.putString("INTERNAL_LOG_ERROR_ADDITIONAL_DETAILS", String.format("%s: %s", e3.getClass().getName(), com.google.android.gms.internal.play_billing.zzbm.zzc(e3.getMessage())));
            this.f57509b.send(6, bundle3);
        }
    }
}
