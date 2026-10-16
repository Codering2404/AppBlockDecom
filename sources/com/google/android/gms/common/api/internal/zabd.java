package com.google.android.gms.common.api.internal;

import java.lang.ref.WeakReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
final class zabd extends zabw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WeakReference f71701a;

    zabd(zabe zabeVar) {
        this.f71701a = new WeakReference(zabeVar);
    }

    @Override // com.google.android.gms.common.api.internal.zabw
    public final void a() {
        zabe zabeVar = (zabe) this.f71701a.get();
        if (zabeVar == null) {
            return;
        }
        zabe.y(zabeVar);
    }
}
