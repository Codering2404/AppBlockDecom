package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzma {
    public final long zza;
    public final float zzb;
    public final long zzc;

    /* synthetic */ zzma(zzlz zzlzVar, byte[] bArr) {
        this.zza = zzlzVar.zze();
        this.zzb = zzlzVar.zzf();
        this.zzc = zzlzVar.zzg();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzma)) {
            return false;
        }
        zzma zzmaVar = (zzma) obj;
        return this.zza == zzmaVar.zza && this.zzb == zzmaVar.zzb && this.zzc == zzmaVar.zzc;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), Float.valueOf(this.zzb), Long.valueOf(this.zzc));
    }

    public final zzlz zza() {
        return new zzlz(this, null);
    }
}
