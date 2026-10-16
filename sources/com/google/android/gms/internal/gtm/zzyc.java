package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.List;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzyc extends AbstractList {
    private final List zza;
    private final zzyb zzb;

    public zzyc(List list, zzyb zzybVar) {
        this.zza = list;
        this.zzb = zzybVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        return this.zzb.zzb(this.zza.get(i3));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
