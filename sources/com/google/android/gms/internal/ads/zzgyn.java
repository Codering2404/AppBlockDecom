package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgyn extends zzgww {
    static final zzgyn zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzgyn(objArr, 0, objArr, 0, 0);
    }

    zzgyn(Object[] objArr, int i3, Object[] objArr2, int i4, int i5) {
        this.zzb = objArr;
        this.zze = i3;
        this.zzc = objArr2;
        this.zzf = i4;
        this.zzg = i5;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZzb = zzgwf.zzb(obj);
                while (true) {
                    int i3 = iZzb & this.zzf;
                    Object obj2 = objArr[i3];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZzb = i3 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgww, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.ads.zzgww, com.google.android.gms.internal.ads.zzgwi, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zze().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgww, com.google.android.gms.internal.ads.zzgwi
    /* JADX INFO: renamed from: zza */
    public final zzgza iterator() {
        return zze().listIterator(0);
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    final Object[] zzb() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    final int zzd() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzgwi
    final int zzg(Object[] objArr, int i3) {
        Object[] objArr2 = this.zzb;
        int i4 = this.zzg;
        System.arraycopy(objArr2, 0, objArr, i3, i4);
        return i3 + i4;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    final boolean zzr() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzgww
    final zzgwm zzs() {
        return zzgwm.zzt(this.zzb, this.zzg);
    }
}
