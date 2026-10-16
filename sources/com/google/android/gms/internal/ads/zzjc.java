package com.google.android.gms.internal.ads;

import android.text.TextUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzjc {
    public final String zza;
    public final zzv zzb;
    public final zzv zzc;
    public final int zzd;
    public final int zze;

    public zzjc(String str, zzv zzvVar, zzv zzvVar2, int i3, int i4) {
        boolean z2;
        if (i3 != 0) {
            z2 = false;
            if (i4 == 0) {
                i4 = 0;
                z2 = true;
            }
        } else {
            z2 = true;
        }
        zzgtj.zza(z2);
        zzgtj.zza(true ^ TextUtils.isEmpty(str));
        this.zza = str;
        this.zzb = zzvVar;
        zzvVar2.getClass();
        this.zzc = zzvVar2;
        this.zzd = i3;
        this.zze = i4;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzjc.class == obj.getClass()) {
            zzjc zzjcVar = (zzjc) obj;
            if (this.zzd == zzjcVar.zzd && this.zze == zzjcVar.zze && this.zza.equals(zzjcVar.zza) && this.zzb.equals(zzjcVar.zzb) && this.zzc.equals(zzjcVar.zzc)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return ((((((((this.zzd + 527) * 31) + this.zze) * 31) + this.zza.hashCode()) * 31) + this.zzb.hashCode()) * 31) + this.zzc.hashCode();
    }
}
