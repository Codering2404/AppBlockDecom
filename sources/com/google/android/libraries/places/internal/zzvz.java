package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzvz extends zzwd {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final zzvz f78713b = new zzvz(zzwd.b());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicReference f78714a;

    zzvz(zzwd zzwdVar) {
        this.f78714a = new AtomicReference(zzwdVar);
    }

    public static final zzvz c() {
        return f78713b;
    }

    @Override // com.google.android.libraries.places.internal.zzwd
    public final zzut a() {
        return ((zzwd) this.f78714a.get()).a();
    }
}
