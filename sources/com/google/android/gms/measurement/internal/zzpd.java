package com.google.android.gms.measurement.internal;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzpd {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final String f74426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    long f74427b;

    /* synthetic */ zzpd(zzpg zzpgVar, String str, byte[] bArr) {
        this(zzpgVar, str);
    }

    private zzpd(zzpg zzpgVar, String str) {
        Objects.requireNonNull(zzpgVar);
        this.f74426a = str;
        this.f74427b = zzpgVar.e().a();
    }

    /* synthetic */ zzpd(zzpg zzpgVar, byte[] bArr) {
        this(zzpgVar, zzpgVar.N0().l0());
    }
}
