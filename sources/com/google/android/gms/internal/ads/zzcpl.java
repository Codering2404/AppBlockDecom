package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzcpl implements zzeaw {
    private final Long zza;
    private final String zzb;
    private final zzcox zzc;
    private final zzcpn zzd;

    zzcpl(zzcox zzcoxVar, zzcpn zzcpnVar, Long l3, String str) {
        this.zzc = zzcoxVar;
        this.zzd = zzcpnVar;
        this.zza = l3;
        this.zzb = str;
    }

    @Override // com.google.android.gms.internal.ads.zzeaw
    public final zzebf zza() {
        long jLongValue = this.zza.longValue();
        zzcpn zzcpnVar = this.zzd;
        return zzebg.zza(jLongValue, zzcpnVar.zzd(), zzcpnVar.zza(), this.zzc, this.zzb);
    }

    @Override // com.google.android.gms.internal.ads.zzeaw
    public final zzebj zzb() {
        long jLongValue = this.zza.longValue();
        zzcpn zzcpnVar = this.zzd;
        return zzebk.zza(jLongValue, zzcpnVar.zzd(), zzcpnVar.zza(), this.zzc, this.zzb);
    }
}
