package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzae extends zzz {
    private final zzah zza;

    zzae(zzah zzahVar, int i3) {
        super(zzahVar.size(), i3);
        this.zza = zzahVar;
    }

    @Override // com.google.android.gms.internal.common.zzz
    protected final Object zza(int i3) {
        return this.zza.get(i3);
    }
}
