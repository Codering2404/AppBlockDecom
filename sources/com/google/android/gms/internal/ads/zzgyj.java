package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyj extends zzgww {
    private final transient zzgwp zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    zzgyj(zzgwp zzgwpVar, Object[] objArr, int i3, int i4) {
        this.zza = zzgwpVar;
        this.zzb = objArr;
        this.zzc = i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
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

    @Override // com.google.android.gms.internal.ads.zzgww, com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.ads.zzgww, com.google.android.gms.internal.ads.zzgwi
    /* JADX INFO: renamed from: zza */
    public final zzgza iterator() {
        return zze().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    final boolean zzf() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    final int zzg(Object[] objArr, int i3) {
        return zze().zzg(objArr, i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    final zzgwm zzs() {
        return new zzgyi(this);
    }

    final /* synthetic */ Object[] zzw() {
        return this.zzb;
    }

    final /* synthetic */ int zzx() {
        return this.zzc;
    }
}
