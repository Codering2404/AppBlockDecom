package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzibs extends zzibu {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzibs(zzibt zzibtVar) {
        super(zzibtVar.zza);
        Objects.requireNonNull(zzibtVar);
    }

    @Override // java.util.Iterator
    public final Object next() {
        return zza().zzf;
    }
}
