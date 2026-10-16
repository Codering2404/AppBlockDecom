package com.google.android.gms.internal.ads;

import java.io.Serializable;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgxl extends AbstractSequentialList implements Serializable {
    final List zza;
    final zzgta zzb;

    zzgxl(List list, zzgta zzgtaVar) {
        list.getClass();
        this.zza = list;
        this.zzb = zzgtaVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean isEmpty() {
        return this.zza.isEmpty();
    }

    @Override // java.util.AbstractSequentialList, java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i3) {
        return new zzgxk(this, this.zza.listIterator(i3));
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        this.zza.subList(i3, i4).clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }
}
