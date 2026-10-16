package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzxx extends zzabc {
    private final zzbg zza;

    public zzxx(zzaba zzabaVar, zzbg zzbgVar) {
        super(zzabaVar);
        this.zza = zzbgVar;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final boolean equals(Object obj) {
        if (super.equals(obj) && (obj instanceof zzxx)) {
            return this.zza.equals(((zzxx) obj).zza);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzabc
    public final int hashCode() {
        return (super.hashCode() * 31) + this.zza.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzabc, com.google.android.gms.internal.ads.zzabf
    public final zzbg zza() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzabc, com.google.android.gms.internal.ads.zzabf
    public final zzv zzb(int i3) {
        return this.zza.zza(zzd().zzf(i3));
    }

    @Override // com.google.android.gms.internal.ads.zzabc, com.google.android.gms.internal.ads.zzaba
    public final zzv zzc() {
        return this.zza.zza(zzd().zzh());
    }
}
