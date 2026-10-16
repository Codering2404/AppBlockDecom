package com.google.android.libraries.places.internal;

import com.google.common.base.Preconditions;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public abstract class zzboj implements zzbom, zzbwe {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private zzbqe f76547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object f76548b = new Object();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final zzcal f76549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final zzbwh f76550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f76551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f76552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private boolean f76553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final int f76554h;

    protected zzboj(int i3, zzcaa zzcaaVar, zzcal zzcalVar) {
        this.f76549c = (zzcal) Preconditions.u(zzcalVar, "transportTracer");
        zzbwh zzbwhVar = new zzbwh(this, zzbjh.f76278a, i3, zzcaaVar, zzcalVar);
        this.f76550d = zzbwhVar;
        this.f76547a = zzbwhVar;
        this.f76554h = 32768;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public final boolean p() {
        boolean z2;
        synchronized (this.f76548b) {
            try {
                z2 = false;
                if (this.f76552f && this.f76551e < this.f76554h && !this.f76553g) {
                    z2 = true;
                }
            } finally {
            }
        }
        return z2;
    }

    private final void f() {
        boolean zP;
        synchronized (this.f76548b) {
            try {
                zP = p();
                if (!zP) {
                    Logger logger = zzbok.f76555a;
                    Level level = Level.FINEST;
                    if (logger.isLoggable(level)) {
                        zzbok.f76555a.logp(level, "io.grpc.internal.AbstractStream$TransportState", "notifyIfReady", "Stream not ready so skip notifying listener.\ndetails: allocated/deallocated:{0}/{3}, sent queued: {1}, ready thresh: {2}", new Object[]{Boolean.valueOf(this.f76552f), Integer.valueOf(this.f76551e), Integer.valueOf(this.f76554h), Boolean.valueOf(this.f76553g)});
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (zP) {
            g().zzd();
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbwe
    public final void a(zzcac zzcacVar) {
        g().c(zzcacVar);
    }

    protected abstract zzcad g();

    final void h() {
        zzbwh zzbwhVar = this.f76550d;
        zzbwhVar.c(this);
        this.f76547a = zzbwhVar;
    }

    final void i(int i3) {
        this.f76547a.zza(i3);
    }

    protected final void j(boolean z2) {
        if (z2) {
            this.f76547a.close();
        } else {
            this.f76547a.zze();
        }
    }

    protected final void k(zzbxo zzbxoVar) {
        try {
            this.f76547a.a(zzbxoVar);
        } catch (Throwable th) {
            d(th);
        }
    }

    protected final void l(zzbjw zzbjwVar) {
        this.f76547a.b(zzbjwVar);
    }

    protected final void m() {
        Preconditions.z(g() != null);
        synchronized (this.f76548b) {
            Preconditions.A(!this.f76552f, "Already allocated");
            this.f76552f = true;
        }
        f();
    }

    protected final void n() {
        synchronized (this.f76548b) {
            this.f76553g = true;
        }
    }

    protected final zzcal o() {
        return this.f76549c;
    }

    final /* synthetic */ void q(int i3) {
        synchronized (this.f76548b) {
            this.f76551e += i3;
        }
    }

    final /* synthetic */ zzbqe r() {
        return this.f76547a;
    }

    public final void zzt(int i3) {
        boolean z2;
        synchronized (this.f76548b) {
            Preconditions.A(this.f76552f, "onStreamAllocated was not called, but it seems the stream is active");
            int i4 = this.f76551e;
            int i5 = this.f76554h;
            int i6 = i4 - i3;
            this.f76551e = i6;
            z2 = false;
            if (i4 >= i5 && i6 < i5) {
                z2 = true;
            }
        }
        if (z2) {
            f();
        }
    }
}
