package com.google.android.gms.internal.gtm;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzsz extends zzst {
    static final zzst zza = new zzsz(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    zzsz(Object[] objArr, int i3) {
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // java.util.List
    public final Object get(int i3) {
        zzsl.zza(i3, this.zzc, "index");
        Object obj = this.zzb[i3];
        obj.getClass();
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzst, com.google.android.gms.internal.gtm.zzsq
    final int zza(Object[] objArr, int i3) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzsq
    final int zzb() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzsq
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.gtm.zzsq
    final Object[] zze() {
        return this.zzb;
    }
}
