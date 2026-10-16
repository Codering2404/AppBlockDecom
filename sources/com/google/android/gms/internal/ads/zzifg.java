package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzifg {
    private static final zzifn zzb = new zzife();
    private final zzifn zza;

    public zzifg() {
        zzidx zzidxVarZza = zzidx.zza();
        int i3 = zzicn.zza;
        this.zza = new zziff(zzidxVarZza, zzb);
    }

    public final zzigh zza(Class cls) {
        int i3 = zzigi.zza;
        if (!zziee.class.isAssignableFrom(cls)) {
            int i4 = zzicn.zza;
        }
        zzifm zzifmVarZzc = this.zza.zzc(cls);
        if (zzifmVarZzc.zza()) {
            int i5 = zzicn.zza;
            return zzift.zzh(zzigi.zzF(), zzidr.zza(), zzifmVarZzc.zzb());
        }
        int i6 = zzicn.zza;
        return zzifs.zzm(cls, zzifmVarZzc, zzifw.zza(), zzifc.zza(), zzigi.zzF(), zzifmVarZzc.zzc() + (-1) != 1 ? zzidr.zza() : null, zzifl.zza());
    }
}
