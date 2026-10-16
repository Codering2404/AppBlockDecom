package com.google.android.gms.internal.fido;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public final class zzej implements zzek {
    private final String zza;
    private final zzdn zzb;

    public zzej() {
        zzdo zzdoVar = zzdo.NO_OP;
        this.zza = "";
        this.zzb = zzdoVar;
    }

    @Override // com.google.android.gms.internal.fido.zzek
    public final zzdp zza(String str) {
        return new zzes(this.zza, str, true, this.zzb, true, true);
    }
}
