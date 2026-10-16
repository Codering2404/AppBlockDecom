package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzboe implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76525a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbpm f76526b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbmg f76527c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbof f76528d;

    zzboe(zzbof zzbofVar, zzbnp zzbnpVar, zzbpm zzbpmVar, zzbmg zzbmgVar) {
        this.f76525a = zzbnpVar;
        this.f76526b = zzbpmVar;
        this.f76527c = zzbmgVar;
        Objects.requireNonNull(zzbofVar);
        this.f76528d = zzbofVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76528d.A(this.f76525a, this.f76526b, this.f76527c);
    }
}
