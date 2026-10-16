package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zztd extends zzst {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    zztd(Object[] objArr, int i3, int i4) {
        this.zza = objArr;
        this.zzb = i3;
        this.zzc = i4;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzsl.zza(i3, this.zzc, "index");
        Object obj = this.zza[i3 + i3 + this.zzb];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }
}
