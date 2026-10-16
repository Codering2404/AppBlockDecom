package com.google.android.gms.measurement.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
abstract class zzos extends zzol {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f74398c;

    zzos(zzpg zzpgVar) {
        super(zzpgVar);
        this.f74388b.e0();
    }

    final boolean i() {
        return this.f74398c;
    }

    protected final void j() {
        if (!i()) {
            throw new IllegalStateException("Not initialized");
        }
    }

    public final void k() {
        if (this.f74398c) {
            throw new IllegalStateException("Can't initialize twice");
        }
        l();
        this.f74388b.f0();
        this.f74398c = true;
    }

    protected abstract boolean l();
}
