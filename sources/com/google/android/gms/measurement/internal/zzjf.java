package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzjf extends zzje {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f73998b;

    zzjf(zzic zzicVar) {
        super(zzicVar);
        this.f73997a.k();
    }

    protected abstract boolean i();

    final boolean k() {
        return this.f73998b;
    }

    protected final void l() {
        if (!k()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void m() {
        if (this.f73998b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (i()) {
            return;
        }
        this.f73997a.l();
        this.f73998b = true;
    }

    public final void n() {
        if (this.f73998b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        j();
        this.f73997a.l();
        this.f73998b = true;
    }

    protected void j() {
    }
}
