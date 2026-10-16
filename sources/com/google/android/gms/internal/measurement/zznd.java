package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zznd implements zzny {
    private static final zznk zzb = new zznb();
    private final zznk zza;

    public zznd() {
        zzma zzmaVarZza = zzma.zza();
        int i3 = zznu.zza;
        zznc zzncVar = new zznc(zzmaVarZza, zzb);
        byte[] bArr = zzmp.zzb;
        this.zza = zzncVar;
    }

    @Override // com.google.android.gms.internal.measurement.zzny
    public final zznx zza(Class cls) {
        int i3 = zznz.zza;
        if (!zzmf.class.isAssignableFrom(cls)) {
            int i4 = zznu.zza;
        }
        zznj zznjVarZzc = this.zza.zzc(cls);
        if (zznjVarZzc.zza()) {
            int i5 = zznu.zza;
            return zznq.zzg(zznz.zzA(), zzlu.zza(), zznjVarZzc.zzb());
        }
        int i6 = zznu.zza;
        return zznp.zzl(cls, zznjVarZzc, zzns.zza(), zzmz.zza(), zznz.zzA(), zznjVarZzc.zzc() + (-1) != 1 ? zzlu.zza() : null, zzni.zza());
    }
}
