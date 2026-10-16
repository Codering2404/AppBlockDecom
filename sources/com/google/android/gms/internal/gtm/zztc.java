package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztc extends zzsx {
    private final transient zzsw zza;
    private final transient zzst zzb;

    zztc(zzsw zzswVar, zzst zzstVar) {
        this.zza = zzswVar;
        this.zzb = zzstVar;
    }

    @Override // com.google.android.gms.internal.gtm.zzsq, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        return this.zza.get(obj) != null;
    }

    @Override // com.google.android.gms.internal.gtm.zzsx, com.google.android.gms.internal.gtm.zzsq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.gtm.zzsq
    final int zza(Object[] objArr, int i3) {
        return this.zzb.zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.gtm.zzsx, com.google.android.gms.internal.gtm.zzsq
    /* JADX INFO: renamed from: zzd */
    public final zzti iterator() {
        return this.zzb.listIterator(0);
    }
}
