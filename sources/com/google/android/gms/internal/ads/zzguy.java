package com.google.android.gms.internal.ads;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzguy implements Iterator {
    final Iterator zza;
    final Collection zzb;
    final /* synthetic */ zzguz zzc;

    zzguy(zzguz zzguzVar) {
        Objects.requireNonNull(zzguzVar);
        this.zzc = zzguzVar;
        Collection collection = zzguzVar.zzb;
        this.zzb = collection;
        this.zza = collection instanceof List ? ((List) collection).listIterator() : collection.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        zza();
        return this.zza.hasNext();
    }

    @Override // java.util.Iterator
    public final Object next() {
        zza();
        return this.zza.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zza.remove();
        zzguz zzguzVar = this.zzc;
        zzguzVar.zze.zzq(r1.zzp() - 1);
        zzguzVar.zzb();
    }

    final void zza() {
        zzguz zzguzVar = this.zzc;
        zzguzVar.zza();
        if (zzguzVar.zzb != this.zzb) {
            throw new ConcurrentModificationException();
        }
    }

    zzguy(zzguz zzguzVar, Iterator it) {
        Objects.requireNonNull(zzguzVar);
        this.zzc = zzguzVar;
        this.zzb = zzguzVar.zzb;
        this.zza = it;
    }
}
