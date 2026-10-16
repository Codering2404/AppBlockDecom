package com.google.android.gms.internal.location;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzev extends zzet {
    private final zzex zza;

    zzev(zzex zzexVar, int i3) {
        super(zzexVar.size(), i3);
        this.zza = zzexVar;
    }

    @Override // com.google.android.gms.internal.location.zzet
    protected final Object zza(int i3) {
        return this.zza.get(i3);
    }
}
