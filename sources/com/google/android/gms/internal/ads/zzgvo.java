package com.google.android.gms.internal.ads;

import java.util.AbstractSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgvo extends AbstractSet {
    final /* synthetic */ zzgvt zza;

    /* synthetic */ zzgvo(zzgvt zzgvtVar, byte[] bArr) {
        Objects.requireNonNull(zzgvtVar);
        this.zza = zzgvtVar;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final void clear() {
        this.zza.clear();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(Object obj) {
        zzgvt zzgvtVar = this.zza;
        Map mapZzc = zzgvtVar.zzc();
        if (mapZzc != null) {
            return mapZzc.entrySet().contains(obj);
        }
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            int iZzi = zzgvtVar.zzi(entry.getKey());
            if (iZzi != -1 && Objects.equals(zzgvtVar.zzp(iZzi), entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator iterator() {
        zzgvt zzgvtVar = this.zza;
        Map mapZzc = zzgvtVar.zzc();
        return mapZzc != null ? mapZzc.entrySet().iterator() : new zzgvm(zzgvtVar);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean remove(Object obj) {
        int iZzh;
        int iZze;
        zzgvt zzgvtVar = this.zza;
        Map mapZzc = zzgvtVar.zzc();
        if (mapZzc != null) {
            return mapZzc.entrySet().remove(obj);
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (zzgvtVar.zzb() || (iZze = zzgvu.zze(entry.getKey(), entry.getValue(), (iZzh = zzgvtVar.zzh()), zzgvtVar.zzk(), zzgvtVar.zzl(), zzgvtVar.zzm(), zzgvtVar.zzn())) == -1) {
            return false;
        }
        zzgvtVar.zze(iZze, iZzh);
        zzgvtVar.zzu(zzgvtVar.zzt() - 1);
        zzgvtVar.zzd();
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zza.size();
    }
}
