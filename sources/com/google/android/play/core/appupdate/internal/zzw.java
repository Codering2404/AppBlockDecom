package com.google.android.play.core.appupdate.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzw implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzx f82880a;

    /* synthetic */ zzw(zzx zzxVar, zzv zzvVar) {
        this.f82880a = zzxVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f82880a.f82883b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        zzx zzxVar = this.f82880a;
        zzxVar.c().post(new zzt(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f82880a.f82883b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        zzx zzxVar = this.f82880a;
        zzxVar.c().post(new zzu(this));
    }
}
