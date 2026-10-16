package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqp implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbmg f76660a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbqt f76661b;

    zzbqp(zzbqt zzbqtVar, zzbmg zzbmgVar) {
        this.f76660a = zzbmgVar;
        Objects.requireNonNull(zzbqtVar);
        this.f76661b = zzbqtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76661b.f().a(this.f76660a);
    }
}
