package com.google.android.gms.internal.gtm;

import java.util.Iterator;
import java.util.Map;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztb extends zzsx {
    private final transient zzsw zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zztb(zzsw zzswVar, Object[] objArr, int i3, int i4) {
        this.zza = zzswVar;
        this.zzb = objArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.gtm.zzsq, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(@CheckForNull Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.gtm.zzsx, com.google.android.gms.internal.gtm.zzsq, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzsq
    final int zza(Object[] objArr, int i3) {
        return zzg().zza(objArr, 0);
    }

    @Override // com.google.android.gms.internal.gtm.zzsx, com.google.android.gms.internal.gtm.zzsq
    /* JADX INFO: renamed from: zzd */
    public final zzti iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.gtm.zzsx
    final zzst zzh() {
        return new zzta(this);
    }
}
