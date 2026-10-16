package com.google.android.gms.internal.maps;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzax extends zzau {
    private final zzaz zza;

    zzax(zzaz zzazVar, int i3) {
        super(zzazVar.size(), i3);
        this.zza = zzazVar;
    }

    @Override // com.google.android.gms.internal.maps.zzau
    protected final Object zza(int i3) {
        return this.zza.get(i3);
    }
}
