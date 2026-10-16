package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzg extends zzf {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f73683b;

    zzg(zzic zzicVar) {
        super(zzicVar);
        this.f73997a.k();
    }

    final boolean i() {
        return this.f73683b;
    }

    protected final void j() {
        if (!i()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void k() {
        if (this.f73683b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        if (m()) {
            return;
        }
        this.f73997a.l();
        this.f73683b = true;
    }

    public final void l() {
        if (this.f73683b) {
            throw new IllegalStateException("Can't initialize twice");
        }
        n();
        this.f73997a.l();
        this.f73683b = true;
    }

    protected abstract boolean m();

    protected void n() {
    }
}
