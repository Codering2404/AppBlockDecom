package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzrh implements zzsb {
    private static final zzro zza = new zzrf();
    private final zzro zzb;

    public zzrh() {
        zzqi zzqiVarZza = zzqi.zza();
        int i3 = zzpc.zza;
        zzrg zzrgVar = new zzrg(zzqiVarZza, zza);
        byte[] bArr = zzqs.zzb;
        this.zzb = zzrgVar;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzsb
    public final zzsa zza(Class cls) {
        int i3 = zzsc.zza;
        if (!zzqm.class.isAssignableFrom(cls)) {
            int i4 = zzpc.zza;
        }
        zzrn zzrnVarZzb = this.zzb.zzb(cls);
        if (zzrnVarZzb.zzb()) {
            int i5 = zzpc.zza;
            return zzru.zzi(zzsc.zzn(), zzqd.zza(), zzrnVarZzb.zza());
        }
        int i6 = zzpc.zza;
        return zzrt.zzi(cls, zzrnVarZzb, zzrw.zza(), zzrd.zza(), zzsc.zzn(), zzrnVarZzb.zzc() + (-1) != 1 ? zzqd.zza() : null, zzrm.zza());
    }
}
