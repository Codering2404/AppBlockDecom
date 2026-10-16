package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqq implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f76662a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbqt f76663b;

    zzbqq(zzbqt zzbqtVar, Object obj) {
        this.f76662a = obj;
        Objects.requireNonNull(zzbqtVar);
        this.f76663b = zzbqtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76663b.f().b(this.f76662a);
    }
}
