package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgvx extends zzgvz {
    zzgvx() {
        super(null);
    }

    static final zzgvz zzf(int i3) {
        return i3 < 0 ? zzgvz.zzb : i3 > 0 ? zzgvz.zzc : zzgvz.zza;
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final zzgvz zza(Object obj, Object obj2, Comparator comparator) {
        return zzf(comparator.compare(obj, obj2));
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final zzgvz zzb(int i3, int i4) {
        return zzf(Integer.compare(i3, i4));
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final zzgvz zzc(boolean z2, boolean z3) {
        return zzf(Boolean.compare(z3, z2));
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final zzgvz zzd(boolean z2, boolean z3) {
        return zzf(Boolean.compare(z2, z3));
    }

    @Override // com.google.android.gms.internal.ads.zzgvz
    public final int zze() {
        return 0;
    }
}
