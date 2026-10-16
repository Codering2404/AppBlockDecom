package com.google.android.gms.internal.play_billing;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbu extends zzbq {
    private final zzbw zza;

    zzbu(zzbw zzbwVar, int i3) {
        super(zzbwVar.size(), i3);
        this.zza = zzbwVar;
    }

    @Override // com.google.android.gms.internal.play_billing.zzbq
    protected final Object zza(int i3) {
        return this.zza.get(i3);
    }
}
