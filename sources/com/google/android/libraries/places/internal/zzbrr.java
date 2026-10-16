package com.google.android.libraries.places.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbrr implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ zzbnp f76729a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzbpm f76730b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzbmg f76731c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ zzbrs f76732d;

    zzbrr(zzbrs zzbrsVar, zzbnp zzbnpVar, zzbpm zzbpmVar, zzbmg zzbmgVar) {
        this.f76729a = zzbnpVar;
        this.f76730b = zzbpmVar;
        this.f76731c = zzbmgVar;
        Objects.requireNonNull(zzbrsVar);
        this.f76732d = zzbrsVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f76732d.e().b(this.f76729a, this.f76730b, this.f76731c);
    }
}
