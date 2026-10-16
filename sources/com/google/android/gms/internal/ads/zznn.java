package com.google.android.gms.internal.ads;

import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zznn {
    public final long zza;
    public final zzbf zzb;
    public final int zzc;
    public final zzxk zzd;
    public final long zze;
    public final zzbf zzf;
    public final int zzg;
    public final zzxk zzh;
    public final long zzi;
    public final long zzj;

    public zznn(long j3, zzbf zzbfVar, int i3, zzxk zzxkVar, long j4, zzbf zzbfVar2, int i4, zzxk zzxkVar2, long j5, long j6) {
        this.zza = j3;
        this.zzb = zzbfVar;
        this.zzc = i3;
        this.zzd = zzxkVar;
        this.zze = j4;
        this.zzf = zzbfVar2;
        this.zzg = i4;
        this.zzh = zzxkVar2;
        this.zzi = j5;
        this.zzj = j6;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && zznn.class == obj.getClass()) {
            zznn zznnVar = (zznn) obj;
            if (this.zza == zznnVar.zza && this.zzc == zznnVar.zzc && this.zze == zznnVar.zze && this.zzg == zznnVar.zzg && this.zzi == zznnVar.zzi && this.zzj == zznnVar.zzj && Objects.equals(this.zzb, zznnVar.zzb) && Objects.equals(this.zzd, zznnVar.zzd) && Objects.equals(this.zzf, zznnVar.zzf) && Objects.equals(this.zzh, zznnVar.zzh)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return Objects.hash(Long.valueOf(this.zza), this.zzb, Integer.valueOf(this.zzc), this.zzd, Long.valueOf(this.zze), this.zzf, Integer.valueOf(this.zzg), this.zzh, Long.valueOf(this.zzi), Long.valueOf(this.zzj));
    }
}
