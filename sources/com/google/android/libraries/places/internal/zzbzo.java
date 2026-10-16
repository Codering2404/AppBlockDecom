package com.google.android.libraries.places.internal;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbzo extends zzbzn {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AtomicIntegerFieldUpdater f77293a;

    /* synthetic */ zzbzo(AtomicIntegerFieldUpdater atomicIntegerFieldUpdater, byte[] bArr) {
        super(null);
        this.f77293a = atomicIntegerFieldUpdater;
    }

    @Override // com.google.android.libraries.places.internal.zzbzn
    public final boolean a(zzbzq zzbzqVar, int i3, int i4) {
        return this.f77293a.compareAndSet(zzbzqVar, 0, -1);
    }

    @Override // com.google.android.libraries.places.internal.zzbzn
    public final void b(zzbzq zzbzqVar, int i3) {
        this.f77293a.set(zzbzqVar, 0);
    }
}
