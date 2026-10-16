package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzrx {
    public final zzv zza;

    @Deprecated
    public final int zzb = 0;
    public final zzhaf zzc;

    /* synthetic */ zzrx(zzv zzvVar, int i3, zzhaf zzhafVar, byte[] bArr) {
        this.zza = zzvVar;
        this.zzc = zzhafVar;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzrx)) {
            return false;
        }
        zzrx zzrxVar = (zzrx) obj;
        return this.zza.equals(zzrxVar.zza) && Objects.equals(this.zzc, zzrxVar.zzc);
    }

    public final int hashCode() {
        int iHashCode = this.zza.hashCode() * 961;
        zzhaf zzhafVar = this.zzc;
        return iHashCode + (zzhafVar == null ? 0 : zzhafVar.hashCode());
    }
}
