package com.google.android.gms.internal.maps;

import java.util.Iterator;
import javax.annotation.CheckForNull;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzbd extends zzba {
    static final zzbd zza;
    private static final Object[] zzd;
    final transient Object[] zzb;
    final transient Object[] zzc;
    private final transient int zze;
    private final transient int zzf;
    private final transient int zzg;

    static {
        Object[] objArr = new Object[0];
        zzd = objArr;
        zza = new zzbd(objArr, 0, objArr, 0, 0);
    }

    zzbd(Object[] objArr, int i3, Object[] objArr2, int i4, int i5) {
        this.zzb = objArr;
        this.zze = i3;
        this.zzc = objArr2;
        this.zzf = i4;
        this.zzg = i5;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final boolean contains(@CheckForNull Object obj) {
        if (obj != null) {
            Object[] objArr = this.zzc;
            if (objArr.length != 0) {
                int iZza = zzav.zza(obj.hashCode());
                while (true) {
                    int i3 = iZza & this.zzf;
                    Object obj2 = objArr[i3];
                    if (obj2 == null) {
                        return false;
                    }
                    if (obj2.equals(obj)) {
                        return true;
                    }
                    iZza = i3 + 1;
                }
            }
        }
        return false;
    }

    @Override // com.google.android.gms.internal.maps.zzba, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zze;
    }

    @Override // com.google.android.gms.internal.maps.zzba, com.google.android.gms.internal.maps.zzaw, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public final /* synthetic */ Iterator iterator() {
        return zzg().listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    final int zza(Object[] objArr, int i3) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzg);
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    final int zzb() {
        return this.zzg;
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    final int zzc() {
        return 0;
    }

    @Override // com.google.android.gms.internal.maps.zzba, com.google.android.gms.internal.maps.zzaw
    /* JADX INFO: renamed from: zzd */
    public final zzbf iterator() {
        return zzg().listIterator(0);
    }

    @Override // com.google.android.gms.internal.maps.zzaw
    final Object[] zze() {
        return this.zzb;
    }

    @Override // com.google.android.gms.internal.maps.zzba
    final zzaz zzh() {
        return zzaz.zzg(this.zzb, this.zzg);
    }

    @Override // com.google.android.gms.internal.maps.zzba
    final boolean zzj() {
        return true;
    }
}
