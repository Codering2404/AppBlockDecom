package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzqs {
    public static final zzqs zza = new zzqr().zzd();
    public final boolean zzb;
    public final boolean zzc;
    public final boolean zzd;

    /* synthetic */ zzqs(zzqr zzqrVar, byte[] bArr) {
        this.zzb = zzqrVar.zze();
        this.zzc = zzqrVar.zzf();
        this.zzd = zzqrVar.zzg();
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zzqs.class == obj.getClass()) {
            zzqs zzqsVar = (zzqs) obj;
            if (this.zzb == zzqsVar.zzb && this.zzc == zzqsVar.zzc && this.zzd == zzqsVar.zzd) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        boolean z2 = this.zzb;
        boolean z3 = this.zzc;
        return ((z2 ? 1 : 0) << 2) + (z3 ? 1 : 0) + (z3 ? 1 : 0) + (this.zzd ? 1 : 0);
    }
}
