package com.google.android.gms.internal.ads;

import java.util.Comparator;
import java.util.Objects;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
class zzguw extends zzgup implements SortedMap {
    SortedSet zzd;
    final /* synthetic */ zzgvc zze;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    zzguw(zzgvc zzgvcVar, SortedMap sortedMap) {
        super(zzgvcVar, sortedMap);
        Objects.requireNonNull(zzgvcVar);
        this.zze = zzgvcVar;
    }

    @Override // java.util.SortedMap
    public final Comparator comparator() {
        return zzg().comparator();
    }

    @Override // java.util.SortedMap
    public final Object firstKey() {
        return zzg().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return new zzguw(this.zze, zzg().headMap(obj));
    }

    @Override // java.util.SortedMap
    public final Object lastKey() {
        return zzg().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new zzguw(this.zze, zzg().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new zzguw(this.zze, zzg().tailMap(obj));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.android.gms.internal.ads.zzgxs
    /* JADX INFO: renamed from: zze */
    public SortedSet zzh() {
        return new zzgux(this.zze, zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzgup, com.google.android.gms.internal.ads.zzgxs, java.util.AbstractMap, java.util.Map
    /* JADX INFO: renamed from: zzf, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.zzd;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet sortedSetZzh = zzh();
        this.zzd = sortedSetZzh;
        return sortedSetZzh;
    }

    SortedMap zzg() {
        return (SortedMap) ((zzgup) this).zza;
    }
}
