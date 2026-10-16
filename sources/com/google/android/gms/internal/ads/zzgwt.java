package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgwt extends zzgwi {
    private final transient zzgwu zza;

    zzgwt(zzgwu zzgwuVar) {
        this.zza = zzgwuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.zzr(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return new zzgwr(this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public final int size() {
        return this.zza.size;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    /* JADX INFO: renamed from: zza */
    public final zzgza iterator() {
        return new zzgwr(this.zza);
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    final boolean zzf() {
        throw null;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.google.android.gms.internal.ads.zzgwi
    final int zzg(Object[] objArr, int i3) {
        zzgzb zzgzbVarListIterator = ((zzgwm) this.zza.map.values()).listIterator(0);
        while (zzgzbVarListIterator.hasNext()) {
            i3 = ((zzgwi) zzgzbVarListIterator.next()).zzg(objArr, i3);
        }
        return i3;
    }
}
