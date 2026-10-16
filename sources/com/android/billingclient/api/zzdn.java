package com.android.billingclient.api;

import android.content.Context;
import com.google.android.datatransport.Encoding;
import com.google.android.datatransport.Event;
import com.google.android.datatransport.Transformer;
import com.google.android.datatransport.Transport;
import com.google.android.datatransport.cct.CCTDestination;
import com.google.android.datatransport.runtime.TransportRuntime;
import com.google.android.gms.internal.play_billing.zzkh;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzdn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f57585a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Transport f57586b;

    zzdn(Context context) {
        try {
            TransportRuntime.f(context);
            this.f57586b = TransportRuntime.c().g(CCTDestination.f69065g).a("PLAY_BILLING_LIBRARY", zzkh.class, Encoding.b("proto"), new Transformer() { // from class: com.android.billingclient.api.zzdm
                @Override // com.google.android.datatransport.Transformer
                public final Object apply(Object obj) {
                    return ((zzkh) obj).zzQ();
                }
            });
        } catch (Throwable unused) {
            this.f57585a = true;
        }
    }

    public final void a(zzkh zzkhVar) {
        if (this.f57585a) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "Skipping logging since initialization failed.");
            return;
        }
        try {
            this.f57586b.b(Event.f(zzkhVar));
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingLogger", "logging failed.");
        }
    }
}
