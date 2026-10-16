package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzguu extends zzgux implements NavigableSet {
    final /* synthetic */ zzgvc zzb;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzguu(zzgvc zzgvcVar, NavigableMap navigableMap) {
        super(zzgvcVar, navigableMap);
        Objects.requireNonNull(zzgvcVar);
        this.zzb = zzgvcVar;
    }

    @Override // java.util.NavigableSet
    public final Object ceiling(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).ceilingKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Iterator descendingIterator() {
        return descendingSet().iterator();
    }

    @Override // java.util.NavigableSet
    public final NavigableSet descendingSet() {
        return new zzguu(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).descendingMap());
    }

    @Override // java.util.NavigableSet
    public final Object floor(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).floorKey(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzgux, java.util.SortedSet, java.util.NavigableSet
    public final /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    @Override // java.util.NavigableSet
    public final Object higher(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).higherKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object lower(Object obj) {
        return ((NavigableMap) ((SortedMap) this.zzd)).lowerKey(obj);
    }

    @Override // java.util.NavigableSet
    public final Object pollFirst() {
        return zzgxf.zza(iterator());
    }

    @Override // java.util.NavigableSet
    public final Object pollLast() {
        return zzgxf.zza(descendingIterator());
    }

    @Override // com.google.android.gms.internal.ads.zzgux, java.util.SortedSet, java.util.NavigableSet
    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    @Override // com.google.android.gms.internal.ads.zzgux, java.util.SortedSet, java.util.NavigableSet
    public final /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }

    @Override // com.google.android.gms.internal.ads.zzgux
    final /* synthetic */ SortedMap zza() {
        return (NavigableMap) ((SortedMap) this.zzd);
    }

    @Override // java.util.NavigableSet
    public final NavigableSet headSet(Object obj, boolean z2) {
        return new zzguu(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).headMap(obj, z2));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
        return new zzguu(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).subMap(obj, z2, obj2, z3));
    }

    @Override // java.util.NavigableSet
    public final NavigableSet tailSet(Object obj, boolean z2) {
        return new zzguu(this.zzb, ((NavigableMap) ((SortedMap) this.zzd)).tailMap(obj, z2));
    }
}
