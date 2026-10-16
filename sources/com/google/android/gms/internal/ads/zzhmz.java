package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhmz implements Iterable {
    final /* synthetic */ List zza;
    final /* synthetic */ List zzb;

    zzhmz(zzhnc zzhncVar, List list, List list2) {
        this.zza = list;
        this.zzb = list2;
        Objects.requireNonNull(zzhncVar);
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        return new zzhnb(this.zza.iterator(), this.zzb.iterator(), null);
    }
}
