package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgs implements zzhm {
    private static final zzgz zza = new zzgq();
    private final zzgz zzb;

    public zzgs() {
        zzfp zzfpVarZza = zzfp.zza();
        int i3 = zzei.zza;
        zzgr zzgrVar = new zzgr(zzfpVarZza, zza);
        byte[] bArr = zzga.zzb;
        this.zzb = zzgrVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzhm
    public final zzhl zza(Class cls) {
        int i3 = zzhn.zza;
        if (!zzfu.class.isAssignableFrom(cls)) {
            int i4 = zzei.zza;
        }
        zzgy zzgyVarZzb = this.zzb.zzb(cls);
        if (zzgyVarZzb.zzb()) {
            int i5 = zzei.zza;
            return zzhf.zzc(zzhn.zzn(), zzfk.zza(), zzgyVarZzb.zza());
        }
        int i6 = zzei.zza;
        return zzhe.zzl(cls, zzgyVarZzb, zzhh.zza(), zzgl.zza(), zzhn.zzn(), zzgyVarZzb.zzc() + (-1) != 1 ? zzfk.zza() : null, zzgx.zza());
    }
}
