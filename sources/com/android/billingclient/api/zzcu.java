package com.android.billingclient.api;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzcu implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzcw f57548a;

    /* synthetic */ zzcu(zzcw zzcwVar, zzcv zzcvVar) {
        Objects.requireNonNull(zzcwVar);
        this.f57548a = zzcwVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        com.google.android.gms.internal.play_billing.zzc.zzn("BillingClientTesting", "Billing Override Service connected.");
        zzcw zzcwVar = this.f57548a;
        zzcwVar.N = com.google.android.gms.internal.play_billing.zzax.zzb(iBinder);
        zzcwVar.M = 2;
        zzcwVar.Z1(26);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        com.google.android.gms.internal.play_billing.zzc.zzo("BillingClientTesting", "Billing Override Service disconnected.");
        zzcw zzcwVar = this.f57548a;
        zzcwVar.N = null;
        zzcwVar.M = 0;
    }
}
