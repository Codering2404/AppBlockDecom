package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqk implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f76653a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbqu f76654b;

    zzbqk(zzbqu zzbquVar, Object obj) {
        this.f76653a = obj;
        Objects.requireNonNull(zzbquVar);
        this.f76654b = zzbquVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76654b.k().b(this.f76653a);
    }
}
