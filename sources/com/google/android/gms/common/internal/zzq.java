package com.google.android.gms.common.internal;

import android.content.Context;
import android.content.ServiceConnection;
import android.os.Handler;
import android.os.Looper;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzq extends GmsClientSupervisor {

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final HashMap f72123g = new HashMap();

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final Context f72124h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private volatile Handler f72125i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final zzp f72126j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ConnectionTracker f72127k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final long f72128l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final long f72129m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private volatile Executor f72130n;

    zzq(Context context, Looper looper, Executor executor) {
        zzp zzpVar = new zzp(this, null);
        this.f72126j = zzpVar;
        this.f72124h = context.getApplicationContext();
        this.f72125i = new com.google.android.gms.internal.common.zzg(looper, zzpVar);
        this.f72127k = ConnectionTracker.b();
        this.f72128l = 5000L;
        this.f72129m = 300000L;
        this.f72130n = executor;
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final ConnectionResult d(zzn zznVar, ServiceConnection serviceConnection, String str, Executor executor) {
        ConnectionResult connectionResultJ;
        Preconditions.n(serviceConnection, "ServiceConnection must not be null");
        HashMap map = this.f72123g;
        synchronized (map) {
            try {
                zzo zzoVar = (zzo) map.get(zznVar);
                if (executor == null) {
                    executor = this.f72130n;
                }
                if (zzoVar == null) {
                    zzoVar = new zzo(this, zznVar);
                    zzoVar.b(serviceConnection, serviceConnection, str);
                    connectionResultJ = zzoVar.j(str, executor);
                    map.put(zznVar, zzoVar);
                } else {
                    this.f72125i.removeMessages(0, zznVar);
                    if (zzoVar.f(serviceConnection)) {
                        String string = zznVar.toString();
                        StringBuilder sb = new StringBuilder(string.length() + 81);
                        sb.append("Trying to bind a GmsServiceConnection that was already connected before.  config=");
                        sb.append(string);
                        throw new IllegalStateException(sb.toString());
                    }
                    zzoVar.b(serviceConnection, serviceConnection, str);
                    int iE = zzoVar.e();
                    if (iE == 1) {
                        serviceConnection.onServiceConnected(zzoVar.i(), zzoVar.h());
                    } else if (iE == 2) {
                        connectionResultJ = zzoVar.j(str, executor);
                    }
                    connectionResultJ = null;
                }
                if (zzoVar.d()) {
                    return ConnectionResult.f71433g;
                }
                if (connectionResultJ == null) {
                    connectionResultJ = new ConnectionResult(-1);
                }
                return connectionResultJ;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.GmsClientSupervisor
    protected final void f(zzn zznVar, ServiceConnection serviceConnection, String str) {
        Preconditions.n(serviceConnection, "ServiceConnection must not be null");
        HashMap map = this.f72123g;
        synchronized (map) {
            try {
                zzo zzoVar = (zzo) map.get(zznVar);
                if (zzoVar == null) {
                    String string = zznVar.toString();
                    StringBuilder sb = new StringBuilder(string.length() + 50);
                    sb.append("Nonexistent connection status for service config: ");
                    sb.append(string);
                    throw new IllegalStateException(sb.toString());
                }
                if (!zzoVar.f(serviceConnection)) {
                    String string2 = zznVar.toString();
                    StringBuilder sb2 = new StringBuilder(string2.length() + 76);
                    sb2.append("Trying to unbind a GmsServiceConnection  that was not bound before.  config=");
                    sb2.append(string2);
                    throw new IllegalStateException(sb2.toString());
                }
                zzoVar.c(serviceConnection, str);
                if (zzoVar.g()) {
                    this.f72125i.sendMessageDelayed(this.f72125i.obtainMessage(0, zznVar), this.f72128l);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ HashMap g() {
        return this.f72123g;
    }

    final /* synthetic */ Context h() {
        return this.f72124h;
    }

    final /* synthetic */ Handler i() {
        return this.f72125i;
    }

    final /* synthetic */ ConnectionTracker j() {
        return this.f72127k;
    }

    final /* synthetic */ long k() {
        return this.f72129m;
    }
}
