package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbqr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76664a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbmg f76665b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbqt f76666c;

    zzbqr(zzbqt zzbqtVar, zzbnp zzbnpVar, zzbmg zzbmgVar) {
        this.f76664a = zzbnpVar;
        this.f76665b = zzbmgVar;
        Objects.requireNonNull(zzbqtVar);
        this.f76666c = zzbqtVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76666c.f().c(this.f76664a, this.f76665b);
    }
}
