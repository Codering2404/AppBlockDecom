package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyq extends zzguk {
    final Iterator zza;
    final /* synthetic */ Set zzb;
    final /* synthetic */ Set zzc;

    zzgyq(zzgyr zzgyrVar, Set set, Set set2) {
        this.zzb = set;
        this.zzc = set2;
        Objects.requireNonNull(zzgyrVar);
        this.zza = set.iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzguk
    protected final Object zza() {
        Set set;
        Object next;
        do {
            Iterator it = this.zza;
            if (!it.hasNext()) {
                zzb();
                return null;
            }
            set = this.zzc;
            next = it.next();
        } while (!set.contains(next));
        return next;
    }
}
