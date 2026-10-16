package com.google.android.libraries.places.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
abstract class zzbqd implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zzbjs f76642a;

    protected zzbqd(zzbjs zzbjsVar) {
        this.f76642a = zzbjsVar;
    }

    public abstract void a();

    @Override // java.lang.Runnable
    public final void run() {
        zzbjs zzbjsVarB = this.f76642a.b();
        try {
            a();
        } finally {
            this.f76642a.c(zzbjsVarB);
        }
    }
}
