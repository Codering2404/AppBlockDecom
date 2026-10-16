package com.google.android.play.integrity.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ad implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ ae f83162a;

    /* synthetic */ ad(ae aeVar, ac acVar) {
        this.f83162a = aeVar;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f83162a.f83165b.d("ServiceConnectionImpl.onServiceConnected(%s)", componentName);
        this.f83162a.c().post(new aa(this, iBinder));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f83162a.f83165b.d("ServiceConnectionImpl.onServiceDisconnected(%s)", componentName);
        this.f83162a.c().post(new ab(this));
    }
}
