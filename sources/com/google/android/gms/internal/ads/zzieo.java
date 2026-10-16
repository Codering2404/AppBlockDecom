package com.google.android.gms.internal.ads;

import java.util.AbstractList;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzieo extends AbstractList {
    private final zziem zza;
    private final zzien zzb;

    public zzieo(zziem zziemVar, zzien zzienVar) {
        this.zza = zziemVar;
        this.zzb = zzienVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        return this.zzb.zzb(this.zza.zzf(i3));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
