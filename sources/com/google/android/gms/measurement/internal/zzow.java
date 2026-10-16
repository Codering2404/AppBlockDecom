package com.google.android.gms.measurement.internal;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzow implements zzgw {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f74405a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f74406b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ zzpg f74407c;

    zzow(zzpg zzpgVar, String str, List list) {
        this.f74405a = str;
        this.f74406b = list;
        Objects.requireNonNull(zzpgVar);
        this.f74407c = zzpgVar;
    }

    @Override // com.google.android.gms.measurement.internal.zzgw
    public final void a(String str, int i3, Throwable th, byte[] bArr, Map map) {
        this.f74407c.A(true, i3, th, bArr, this.f74405a, this.f74406b);
    }
}
