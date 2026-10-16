package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzox implements zzgw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f74408a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzpj f74409b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzpg f74410c;

    zzox(zzpg zzpgVar, String str, zzpj zzpjVar) {
        this.f74408a = str;
        this.f74409b = zzpjVar;
        Objects.requireNonNull(zzpgVar);
        this.f74410c = zzpgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final void a(String str, int i3, Throwable th, byte[] bArr, Map map) {
        this.f74410c.v(this.f74408a, i3, th, bArr, this.f74409b);
    }
}
