package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zznc implements zznk {
    private final zznk[] zza;

    zznc(zznk... zznkVarArr) {
        this.zza = zznkVarArr;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final boolean zzb(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            if (this.zza[i3].zzb(cls)) {
                return true;
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zznk
    public final zznj zzc(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            zznk zznkVar = this.zza[i3];
            if (zznkVar.zzb(cls)) {
                return zznkVar.zzc(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }
}
