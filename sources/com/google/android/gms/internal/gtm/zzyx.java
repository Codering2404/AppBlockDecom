package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyx implements zzze {
    private final zzze[] zza;

    zzyx(zzze... zzzeVarArr) {
        this.zza = zzzeVarArr;
    }

    @Override // com.google.android.gms.internal.gtm.zzze
    public final zzzd zzb(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            zzze zzzeVar = this.zza[i3];
            if (zzzeVar.zzc(cls)) {
                return zzzeVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.gtm.zzze
    public final boolean zzc(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            if (this.zza[i3].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
