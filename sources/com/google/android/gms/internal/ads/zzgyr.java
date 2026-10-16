package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyr extends zzgyv {
    final /* synthetic */ Set zza;
    final /* synthetic */ Set zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzgyr(Set set, Set set2) {
        super(null);
        this.zza = set;
        this.zzb = set2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        return this.zza.contains(obj) && this.zzb.contains(obj);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean containsAll(Collection collection) {
        return this.zza.containsAll(collection) && this.zzb.containsAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean isEmpty() {
        return Collections.disjoint(this.zzb, this.zza);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        Iterator it = this.zza.iterator();
        int i3 = 0;
        while (it.hasNext()) {
            if (this.zzb.contains(it.next())) {
                i3++;
            }
        }
        return i3;
    }

    @Override // com.google.android.gms.internal.ads.zzgyv, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    /* JADX INFO: renamed from: zza */
    public final zzgza iterator() {
        return new zzgyq(this, this.zza, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgyv
    final int zzb() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgyv
    final int zzc() {
        return Math.min(zzgyv.zzd(this.zza), zzgyv.zzd(this.zzb));
    }
}
