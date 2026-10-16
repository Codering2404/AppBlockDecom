package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzhj implements ServiceConnection {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final String f73836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzhk f73837b;

    zzhj(zzhk zzhkVar, String str) {
        Objects.requireNonNull(zzhkVar);
        this.f73837b = zzhkVar;
        this.f73836a = str;
    }

    final /* synthetic */ String a() {
        return this.f73836a;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        if (iBinder == null) {
            this.f73837b.f73838a.a().r().a("Install Referrer connection returned with null binder");
            return;
        }
        try {
            com.google.android.gms.internal.measurement.zzbq zzbqVarZzb = com.google.android.gms.internal.measurement.zzbp.zzb(iBinder);
            if (zzbqVarZzb == null) {
                this.f73837b.f73838a.a().r().a("Install Referrer Service implementation was not found");
                return;
            }
            zzic zzicVar = this.f73837b.f73838a;
            zzicVar.a().w().a("Install Referrer Service connected");
            zzicVar.b().t(new zzhi(this, zzbqVarZzb, this));
        } catch (RuntimeException e3) {
            this.f73837b.f73838a.a().r().b("Exception occurred while calling Install Referrer API", e3);
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        this.f73837b.f73838a.a().w().a("Install Referrer Service disconnected");
    }
}
