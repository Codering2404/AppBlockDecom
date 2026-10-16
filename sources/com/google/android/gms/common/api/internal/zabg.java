package com.google.android.gms.common.api.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class zabg {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final zabf f71726a;

    protected zabg(zabf zabfVar) {
        this.f71726a = zabfVar;
    }

    protected abstract void a();

    public final void b(zabi zabiVar) {
        zabiVar.f71728a.lock();
        try {
            if (zabiVar.f71738l == this.f71726a) {
                a();
            }
        } finally {
            zabiVar.f71728a.unlock();
        }
    }
}
