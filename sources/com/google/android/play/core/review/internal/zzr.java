package com.google.android.play.core.review.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzr implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzt f83122a;

    /* synthetic */ zzr(zzt zztVar, zzs zzsVar) {
        this.f83122a = zztVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f83122a.f83125b.c("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f83122a.c().post(new zzp(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f83122a.f83125b.c("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f83122a.c().post(new zzq(this));
    }
}
