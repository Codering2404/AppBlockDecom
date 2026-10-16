package com.google.android.gms.common.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.StrictMode;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zzo implements ServiceConnection, zzr {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Map f72115a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f72116b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f72117c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private IBinder f72118d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final zzn f72119f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private ComponentName f72120g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ zzq f72121h;

    public zzo(zzq zzqVar, zzn zznVar) {
        java.util.Objects.requireNonNull(zzqVar);
        this.f72121h = zzqVar;
        this.f72119f = zznVar;
        this.f72115a = new HashMap();
        this.f72116b = 2;
    }

    public final void a(String str) {
        zzn zznVar = this.f72119f;
        zzq zzqVar = this.f72121h;
        zzqVar.i().removeMessages(1, zznVar);
        zzqVar.j().c(zzqVar.h(), this);
        this.f72117c = false;
        this.f72116b = 2;
    }

    public final void b(ServiceConnection serviceConnection, ServiceConnection serviceConnection2, String str) {
        this.f72115a.put(serviceConnection, serviceConnection2);
    }

    public final void c(ServiceConnection serviceConnection, String str) {
        this.f72115a.remove(serviceConnection);
    }

    public final boolean d() {
        return this.f72117c;
    }

    public final int e() {
        return this.f72116b;
    }

    public final boolean f(ServiceConnection serviceConnection) {
        return this.f72115a.containsKey(serviceConnection);
    }

    public final boolean g() {
        return this.f72115a.isEmpty();
    }

    public final IBinder h() {
        return this.f72118d;
    }

    public final ComponentName i() {
        return this.f72120g;
    }

    final /* synthetic */ ConnectionResult j(String str, Executor executor) throws Throwable {
        zzq zzqVar;
        ConnectionTracker connectionTrackerJ;
        Context contextH;
        zzn zznVar;
        try {
            Intent intentA = zzah.a(this.f72121h.h(), this.f72119f);
            this.f72116b = 3;
            StrictMode.VmPolicy vmPolicyA = com.google.android.gms.common.util.zzd.a();
            try {
                zzqVar = this.f72121h;
                connectionTrackerJ = zzqVar.j();
                contextH = zzqVar.h();
                zznVar = this.f72119f;
            } catch (Throwable th) {
                th = th;
            }
            try {
                boolean zD = connectionTrackerJ.d(contextH, str, intentA, this, 4225, executor);
                this.f72117c = zD;
                if (zD) {
                    zzqVar.i().sendMessageDelayed(zzqVar.i().obtainMessage(1, zznVar), zzqVar.k());
                    ConnectionResult connectionResult = ConnectionResult.f71433g;
                    StrictMode.setVmPolicy(vmPolicyA);
                    return connectionResult;
                }
                this.f72116b = 2;
                try {
                    zzqVar.j().c(zzqVar.h(), this);
                } catch (IllegalArgumentException unused) {
                }
                ConnectionResult connectionResult2 = new ConnectionResult(16);
                StrictMode.setVmPolicy(vmPolicyA);
                return connectionResult2;
            } catch (Throwable th2) {
                th = th2;
                Throwable th3 = th;
                StrictMode.setVmPolicy(vmPolicyA);
                throw th3;
            }
        } catch (zzaf e3) {
            return e3.f72091a;
        }
    }

    @Override // android.content.ServiceConnection
    public final void onBindingDied(ComponentName componentName) {
        onServiceDisconnected(componentName);
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        zzq zzqVar = this.f72121h;
        synchronized (zzqVar.g()) {
            try {
                zzqVar.i().removeMessages(1, this.f72119f);
                this.f72118d = iBinder;
                this.f72120g = componentName;
                Iterator it = this.f72115a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceConnected(componentName, iBinder);
                }
                this.f72116b = 1;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzq zzqVar = this.f72121h;
        synchronized (zzqVar.g()) {
            try {
                zzqVar.i().removeMessages(1, this.f72119f);
                this.f72118d = null;
                this.f72120g = componentName;
                Iterator it = this.f72115a.values().iterator();
                while (it.hasNext()) {
                    ((ServiceConnection) it.next()).onServiceDisconnected(componentName);
                }
                this.f72116b = 2;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
