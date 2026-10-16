package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
public abstract class zzgvz {
    private static final zzgvz zza = new zzgvx();
    private static final zzgvz zzb = new zzgvy(-1);
    private static final zzgvz zzc = new zzgvy(1);

    /* synthetic */ zzgvz(byte[] bArr) {
    }

    public static zzgvz zzg() {
        return zza;
    }

    public abstract zzgvz zza(Object obj, Object obj2, Comparator comparator);

    public abstract zzgvz zzb(int i3, int i4);

    public abstract zzgvz zzc(boolean z2, boolean z3);

    public abstract zzgvz zzd(boolean z2, boolean z3);

    public abstract int zze();
}
