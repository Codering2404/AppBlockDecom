package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzac implements Iterator {
    final /* synthetic */ Iterator zza;
    final /* synthetic */ Iterator zzb;

    zzac(zzae zzaeVar, Iterator it, Iterator it2) {
        this.zza = it;
        this.zzb = it2;
        Objects.requireNonNull(zzaeVar);
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.zza.hasNext()) {
            return true;
        }
        return this.zzb.hasNext();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        Iterator it = this.zza;
        if (it.hasNext()) {
            return new zzas(((Integer) it.next()).toString());
        }
        Iterator it2 = this.zzb;
        if (it2.hasNext()) {
            return new zzas((String) it2.next());
        }
        throw new NoSuchElementException();
    }
}
