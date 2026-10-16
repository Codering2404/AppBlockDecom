package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyy implements zzzu {
    private static final zzze zza = new zzyw();
    private final zzze zzb;

    public zzyy() {
        zzze zzzeVar;
        zzxo zzxoVarZza = zzxo.zza();
        try {
            zzzeVar = (zzze) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", null).invoke(null, null);
        } catch (Exception unused) {
            zzzeVar = zza;
        }
        zzyx zzyxVar = new zzyx(zzxoVarZza, zzzeVar);
        byte[] bArr = zzye.zzd;
        this.zzb = zzyxVar;
    }

    private static boolean zzb(zzzd zzzdVar) {
        return zzzdVar.zzc() + (-1) != 1;
    }

    @Override // com.google.android.gms.internal.gtm.zzzu
    public final zzzt zza(Class cls) {
        zzzv.zzs(cls);
        zzzd zzzdVarZzb = this.zzb.zzb(cls);
        return zzzdVarZzb.zzb() ? zzxv.class.isAssignableFrom(cls) ? zzzk.zzc(zzzv.zzn(), zzxi.zzb(), zzzdVarZzb.zza()) : zzzk.zzc(zzzv.zzm(), zzxi.zza(), zzzdVarZzb.zza()) : zzxv.class.isAssignableFrom(cls) ? zzb(zzzdVarZzb) ? zzzj.zzl(cls, zzzdVarZzb, zzzn.zzb(), zzyu.zze(), zzzv.zzn(), zzxi.zzb(), zzzc.zzb()) : zzzj.zzl(cls, zzzdVarZzb, zzzn.zzb(), zzyu.zze(), zzzv.zzn(), null, zzzc.zzb()) : zzb(zzzdVarZzb) ? zzzj.zzl(cls, zzzdVarZzb, zzzn.zza(), zzyu.zzd(), zzzv.zzm(), zzxi.zza(), zzzc.zza()) : zzzj.zzl(cls, zzzdVarZzb, zzzn.zza(), zzyu.zzd(), zzzv.zzm(), null, zzzc.zza());
    }
}
