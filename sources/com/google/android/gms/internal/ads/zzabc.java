package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public class zzabc implements zzaba {
    private final zzaba zza;

    public zzabc(zzaba zzabaVar) {
        this.zza = zzabaVar;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof zzabc) {
            return this.zza.equals(((zzabc) obj).zza);
        }
        return false;
    }

    public int hashCode() {
        return this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public zzbg zza() {
        return this.zza.zza();
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public zzv zzb(int i3) {
        return this.zza.zzb(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public zzv zzc() {
        return this.zza.zzc();
    }

    public final zzaba zzd() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final int zze() {
        return this.zza.zze();
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final int zzf(int i3) {
        return this.zza.zzf(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzabf
    public final int zzg(int i3) {
        return this.zza.zzg(i3);
    }

    @Override // com.google.android.gms.internal.ads.zzaba
    public final int zzh() {
        return this.zza.zzh();
    }
}
