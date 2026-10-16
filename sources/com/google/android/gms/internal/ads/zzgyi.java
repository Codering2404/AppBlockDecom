package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyi extends zzgwm {
    final /* synthetic */ zzgyj zza;

    zzgyi(zzgyj zzgyjVar) {
        Objects.requireNonNull(zzgyjVar);
        this.zza = zzgyjVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        zzgyj zzgyjVar = this.zza;
        zzgtj.zzm(i3, zzgyjVar.zzx(), "index");
        int i4 = i3 + i3;
        Object obj = zzgyjVar.zzw()[i4];
        Objects.requireNonNull(obj);
        Object obj2 = zzgyjVar.zzw()[i4 + 1];
        Objects.requireNonNull(obj2);
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzx();
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    public final boolean zzf() {
        return true;
    }
}
