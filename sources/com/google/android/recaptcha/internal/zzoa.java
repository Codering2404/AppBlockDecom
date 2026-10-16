package com.google.android.recaptcha.internal;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzoa implements zzox {
    private static final zzog zza = new zzny();
    private final zzog zzb;

    public zzoa() {
        zzmw zzmwVarZza = zzmw.zza();
        int i3 = zzos.zza;
        zznz zznzVar = new zznz(zzmwVarZza, zza);
        byte[] bArr = zznl.zzb;
        this.zzb = zznzVar;
    }

    @Override // com.google.android.recaptcha.internal.zzox
    public final zzow zza(Class cls) {
        int i3 = zzoy.zza;
        if (!zznd.class.isAssignableFrom(cls)) {
            int i4 = zzos.zza;
        }
        zzof zzofVarZzb = this.zzb.zzb(cls);
        if (zzofVarZzb.zzb()) {
            int i5 = zzos.zza;
            return zzom.zzc(zzoy.zzm(), zzmr.zza(), zzofVarZzb.zza());
        }
        int i6 = zzos.zza;
        return zzol.zzm(cls, zzofVarZzb, zzop.zza(), zznw.zza(), zzoy.zzm(), zzofVarZzb.zzc() + (-1) != 1 ? zzmr.zza() : null, zzoe.zza());
    }
}
