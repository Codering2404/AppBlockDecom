package com.android.billingclient.api;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import com.google.android.gms.internal.play_billing.zziw;
import com.google.android.gms.internal.play_billing.zzjd;
import com.google.android.gms.internal.play_billing.zzjk;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzaa extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f57367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f57368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzab f57369c;

    zzaa(zzab zzabVar, boolean z2) {
        Objects.requireNonNull(zzabVar);
        this.f57369c = zzabVar;
        this.f57368b = z2;
    }

    private final void d(Bundle bundle, BillingResult billingResult, int i3, zzjk zzjkVar, long j3, boolean z2) {
        try {
            if (bundle.getByteArray("FAILURE_LOGGING_PAYLOAD") != null) {
                this.f57369c.f57375f.c(zziw.zzc(bundle.getByteArray("FAILURE_LOGGING_PAYLOAD")), j3, z2);
            } else {
                this.f57369c.f57375f.c(zzcy.b(zzjd.BILLING_RESULT_RECEIVED_FROM_PHONESKY, i3, billingResult, null, zzjkVar), j3, z2);
            }
        } catch (Throwable unused) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", "Failed parsing Api failure.");
        }
    }

    public final synchronized void a(Context context, IntentFilter intentFilter) {
        try {
            if (this.f57367a) {
                return;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(this, intentFilter, true != this.f57368b ? 4 : 2);
            } else {
                context.registerReceiver(this, intentFilter);
            }
            this.f57367a = true;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void b(Context context, IntentFilter intentFilter, String str) {
        zzaa zzaaVar;
        try {
            try {
                if (this.f57367a) {
                    return;
                }
                if (Build.VERSION.SDK_INT >= 33) {
                    zzaaVar = this;
                    context.registerReceiver(zzaaVar, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null, true != this.f57368b ? 4 : 2);
                } else {
                    zzaaVar = this;
                    context.registerReceiver(this, intentFilter, "com.google.android.finsky.permission.PLAY_BILLING_LIBRARY_BROADCAST", null);
                }
                zzaaVar.f57367a = true;
                return;
            } catch (Throwable th) {
                th = th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
        throw th;
    }

    public final synchronized void c(Context context) {
        if (!this.f57367a) {
            com.google.android.gms.internal.play_billing.zzc.zzo("BillingBroadcastManager", "Receiver is not registered.");
        } else {
            context.unregisterReceiver(this);
            this.f57367a = false;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x003a  */
    @Override // android.content.BroadcastReceiver
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void onReceive(android.content.Context r14, android.content.Intent r15) {
        /*
            Method dump skipped, instruction units count: 581
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.billingclient.api.zzaa.onReceive(android.content.Context, android.content.Intent):void");
    }
}
