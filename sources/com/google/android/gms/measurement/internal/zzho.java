package com.google.android.gms.measurement.internal;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzho implements com.google.android.gms.internal.measurement.zzo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ String f73842a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ zzht f73843b;

    zzho(zzht zzhtVar, String str) {
        this.f73842a = str;
        Objects.requireNonNull(zzhtVar);
        this.f73843b = zzhtVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzo
    public final String zza(String str) {
        Map map = (Map) this.f73843b.p().get(this.f73842a);
        if (map == null || !map.containsKey(str)) {
            return null;
        }
        return (String) map.get(str);
    }
}
