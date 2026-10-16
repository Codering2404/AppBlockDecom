package com.google.android.gms.internal.consent_sdk;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzrg implements zzro {
    private final zzro[] zza;

    zzrg(zzro... zzroVarArr) {
        this.zza = zzroVarArr;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzro
    public final zzrn zzb(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            zzro zzroVar = this.zza[i3];
            if (zzroVar.zzc(cls)) {
                return zzroVar.zzb(cls);
            }
        }
        throw new UnsupportedOperationException("No factory is available for message type: ".concat(cls.getName()));
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzro
    public final boolean zzc(Class cls) {
        for (int i3 = 0; i3 < 2; i3++) {
            if (this.zza[i3].zzc(cls)) {
                return true;
            }
        }
        return false;
    }
}
