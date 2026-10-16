package com.google.android.gms.measurement;

import android.content.Context;
import android.content.Intent;
import androidx.legacy.content.WakefulBroadcastReceiver;
import com.google.android.gms.measurement.internal.zzhl;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class AppMeasurementReceiver extends WakefulBroadcastReceiver implements zzhl.zza {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private zzhl f73360c;

    @Override // com.google.android.gms.measurement.internal.zzhl.zza
    public void a(Context context, Intent intent) {
        WakefulBroadcastReceiver.c(context, intent);
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (this.f73360c == null) {
            this.f73360c = new zzhl(this);
        }
        this.f73360c.a(context, intent);
    }
}
