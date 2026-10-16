package com.google.android.gms.internal.gtm;

import java.util.AbstractMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzta extends zzst {
    final /* synthetic */ zztb zza;

    zzta(zztb zztbVar) {
        this.zza = zztbVar;
    }

    @Override // java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        zzsl.zza(i3, this.zza.zzc, "index");
        zztb zztbVar = this.zza;
        int i4 = i3 + i3;
        Object obj = zztbVar.zzb[i4];
        obj.getClass();
        Object obj2 = zztbVar.zzb[i4 + 1];
        obj2.getClass();
        return new AbstractMap.SimpleImmutableEntry(obj, obj2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.zzc;
    }
}
