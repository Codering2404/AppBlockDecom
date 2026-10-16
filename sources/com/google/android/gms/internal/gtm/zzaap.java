package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
@Deprecated
public final class zzaap extends AbstractList implements RandomAccess, zzyo {
    private final zzyo zza;

    public zzaap(zzyo zzyoVar) {
        this.zza = zzyoVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object get(int i3) {
        return ((zzyn) this.zza).get(i3);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator iterator() {
        return new zzaao(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator listIterator(int i3) {
        return new zzaan(this, i3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zza.size();
    }

    @Override // com.google.android.gms.internal.gtm.zzyo
    public final Object zzf(int i3) {
        return this.zza.zzf(i3);
    }

    @Override // com.google.android.gms.internal.gtm.zzyo
    public final List zzh() {
        return this.zza.zzh();
    }

    @Override // com.google.android.gms.internal.gtm.zzyo
    public final void zzi(zzud zzudVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.gtm.zzyo
    public final zzyo zze() {
        return this;
    }
}
