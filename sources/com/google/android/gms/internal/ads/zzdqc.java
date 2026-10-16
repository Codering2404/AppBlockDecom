package com.google.android.gms.internal.ads;

import androidx.collection.SimpleArrayMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzdqc {
    zzbnc zza;
    zzbmz zzb;
    zzbnp zzc;
    zzbnm zzd;
    zzbsk zze;
    final SimpleArrayMap zzf = new SimpleArrayMap();
    final SimpleArrayMap zzg = new SimpleArrayMap();

    public final zzdqc zza(zzbnc zzbncVar) {
        this.zza = zzbncVar;
        return this;
    }

    public final zzdqc zzb(zzbmz zzbmzVar) {
        this.zzb = zzbmzVar;
        return this;
    }

    public final zzdqc zzc(zzbnp zzbnpVar) {
        this.zzc = zzbnpVar;
        return this;
    }

    public final zzdqc zzd(zzbnm zzbnmVar) {
        this.zzd = zzbnmVar;
        return this;
    }

    public final zzdqc zze(zzbsk zzbskVar) {
        this.zze = zzbskVar;
        return this;
    }

    public final zzdqc zzf(String str, zzbni zzbniVar, zzbnf zzbnfVar) {
        this.zzf.put(str, zzbniVar);
        if (zzbnfVar != null) {
            this.zzg.put(str, zzbnfVar);
        }
        return this;
    }

    public final zzdqd zzg() {
        return new zzdqd(this, null);
    }
}
