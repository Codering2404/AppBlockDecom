package com.google.android.gms.internal.ads;

import java.util.Map;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgvr extends zzgvd {
    final /* synthetic */ zzgvt zza;
    private final Object zzb;
    private int zzc;

    zzgvr(zzgvt zzgvtVar, int i3) {
        Objects.requireNonNull(zzgvtVar);
        this.zza = zzgvtVar;
        this.zzb = zzgvtVar.zzo(i3);
        this.zzc = i3;
    }

    private final void zza() {
        int i3 = this.zzc;
        if (i3 != -1) {
            zzgvt zzgvtVar = this.zza;
            if (i3 < zzgvtVar.size() && Objects.equals(this.zzb, zzgvtVar.zzo(this.zzc))) {
                return;
            }
        }
        this.zzc = this.zza.zzi(this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzgvd, java.util.Map.Entry
    public final Object getKey() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgvd, java.util.Map.Entry
    public final Object getValue() {
        zzgvt zzgvtVar = this.zza;
        Map mapZzc = zzgvtVar.zzc();
        if (mapZzc != null) {
            return mapZzc.get(this.zzb);
        }
        zza();
        int i3 = this.zzc;
        if (i3 == -1) {
            return null;
        }
        return zzgvtVar.zzp(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzgvd, java.util.Map.Entry
    public final Object setValue(Object obj) {
        zzgvt zzgvtVar = this.zza;
        Map mapZzc = zzgvtVar.zzc();
        if (mapZzc != null) {
            return mapZzc.put(this.zzb, obj);
        }
        zza();
        int i3 = this.zzc;
        if (i3 == -1) {
            zzgvtVar.put(this.zzb, obj);
            return null;
        }
        Object objZzp = zzgvtVar.zzp(i3);
        zzgvtVar.zzq(this.zzc, obj);
        return objZzp;
    }
}
