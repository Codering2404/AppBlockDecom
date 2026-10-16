package com.google.android.gms.internal.ads;

import java.math.BigInteger;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzamn implements zzahb {
    final /* synthetic */ zzamo zza;

    /* synthetic */ zzamn(zzamo zzamoVar, byte[] bArr) {
        Objects.requireNonNull(zzamoVar);
        this.zza = zzamoVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final long zza() {
        zzamo zzamoVar = this.zza;
        return zzamoVar.zzf().zzh(zzamoVar.zzg());
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final boolean zzb() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzahb
    public final zzagz zzc(long j3) {
        zzamo zzamoVar = this.zza;
        long jZzd = zzamoVar.zzd() + BigInteger.valueOf(zzamoVar.zzf().zzi(j3)).multiply(BigInteger.valueOf(zzamoVar.zze() - zzamoVar.zzd())).divide(BigInteger.valueOf(zzamoVar.zzg())).longValue();
        String str = zzfl.zza;
        zzahc zzahcVar = new zzahc(j3, Math.max(zzamoVar.zzd(), Math.min(jZzd - 30000, zzamoVar.zze() - 1)));
        return new zzagz(zzahcVar, zzahcVar);
    }
}
