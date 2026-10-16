package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.DeadObjectException;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Looper;
import android.os.RemoteException;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.stats.ConnectionTracker;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznf implements ServiceConnection, BaseGmsClient.BaseConnectionCallbacks, BaseGmsClient.BaseOnConnectionFailedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private volatile boolean f74303a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private volatile zzgo f74304b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zznl f74305c;

    protected zznf(zznl zznlVar) {
        Objects.requireNonNull(zznlVar);
        this.f74305c = zznlVar;
    }

    public final void a(Intent intent) {
        zznl zznlVar = this.f74305c;
        zznlVar.h();
        Context contextD = zznlVar.f73997a.d();
        ConnectionTracker connectionTrackerB = ConnectionTracker.b();
        synchronized (this) {
            try {
                if (this.f74303a) {
                    this.f74305c.f73997a.a().w().a("Connection attempt already in progress");
                    return;
                }
                zznl zznlVar2 = this.f74305c;
                zznlVar2.f73997a.a().w().a("Using local app measurement service");
                this.f74303a = true;
                connectionTrackerB.a(contextD, intent, zznlVar2.M(), 129);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void b() {
        if (this.f74304b != null && (this.f74304b.isConnected() || this.f74304b.isConnecting())) {
            this.f74304b.disconnect();
        }
        this.f74304b = null;
    }

    public final void c() {
        zznl zznlVar = this.f74305c;
        zznlVar.h();
        Context contextD = zznlVar.f73997a.d();
        synchronized (this) {
            try {
                if (this.f74303a) {
                    this.f74305c.f73997a.a().w().a("Connection attempt already in progress");
                    return;
                }
                if (this.f74304b != null && (this.f74304b.isConnecting() || this.f74304b.isConnected())) {
                    this.f74305c.f73997a.a().w().a("Already awaiting connection attempt");
                    return;
                }
                this.f74304b = new zzgo(contextD, Looper.getMainLooper(), this, this);
                this.f74305c.f73997a.a().w().a("Connecting to remote service");
                this.f74303a = true;
                Preconditions.m(this.f74304b);
                this.f74304b.checkAvailabilityAndConnect();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    final /* synthetic */ void d(boolean z2) {
        this.f74303a = false;
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnected(Bundle bundle) {
        this.f74305c.f73997a.b().o();
        synchronized (this) {
            try {
                Preconditions.m(this.f74304b);
                this.f74305c.f73997a.b().t(new zzna(this, (zzgb) this.f74304b.getService()));
            } catch (DeadObjectException | IllegalStateException unused) {
                this.f74304b = null;
                this.f74303a = false;
            }
        }
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseOnConnectionFailedListener
    public final void onConnectionFailed(ConnectionResult connectionResult) {
        zznl zznlVar = this.f74305c;
        zznlVar.f73997a.b().o();
        zzgu zzguVarY = zznlVar.f73997a.y();
        if (zzguVarY != null) {
            zzguVarY.w().b("Service connection failed", connectionResult);
        }
        synchronized (this) {
            this.f74303a = false;
            this.f74304b = null;
        }
        this.f74305c.f73997a.b().t(new zzne(this, connectionResult));
    }

    @Override // com.google.android.gms.common.internal.BaseGmsClient.BaseConnectionCallbacks
    public final void onConnectionSuspended(int i3) {
        zzic zzicVar = this.f74305c.f73997a;
        zzicVar.b().o();
        zzicVar.a().v().a("Service connection suspended");
        zzicVar.b().t(new zznb(this));
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f74305c.f73997a.b().o();
        synchronized (this) {
            if (iBinder == null) {
                this.f74303a = false;
                this.f74305c.f73997a.a().o().a("Service connected with null binder");
                return;
            }
            zzgb zzfzVar = null;
            try {
                String interfaceDescriptor = iBinder.getInterfaceDescriptor();
                if ("com.google.android.gms.measurement.internal.IMeasurementService".equals(interfaceDescriptor)) {
                    IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.measurement.internal.IMeasurementService");
                    zzfzVar = iInterfaceQueryLocalInterface instanceof zzgb ? (zzgb) iInterfaceQueryLocalInterface : new zzfz(iBinder);
                    this.f74305c.f73997a.a().w().a("Bound to IMeasurementService interface");
                } else {
                    this.f74305c.f73997a.a().o().b("Got binder with a wrong descriptor", interfaceDescriptor);
                }
            } catch (RemoteException unused) {
                this.f74305c.f73997a.a().o().a("Service connect failed to get IMeasurementService");
            }
            if (zzfzVar == null) {
                this.f74303a = false;
                try {
                    ConnectionTracker connectionTrackerB = ConnectionTracker.b();
                    zznl zznlVar = this.f74305c;
                    connectionTrackerB.c(zznlVar.f73997a.d(), zznlVar.M());
                } catch (IllegalArgumentException unused2) {
                }
            } else {
                this.f74305c.f73997a.b().t(new zzmy(this, zzfzVar));
            }
        }
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName componentName) {
        zzic zzicVar = this.f74305c.f73997a;
        zzicVar.b().o();
        zzicVar.a().v().a("Service disconnected");
        zzicVar.b().t(new zzmz(this, componentName));
    }
}
