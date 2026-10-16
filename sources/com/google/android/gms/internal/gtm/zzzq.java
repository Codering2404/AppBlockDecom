package com.google.android.gms.internal.gtm;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzzq extends zztn implements RandomAccess {
    private static final zzzq zza = new zzzq(new Object[0], 0, false);
    private Object[] zzb;
    private int zzc;

    zzzq() {
        this(new Object[10], 0, true);
    }

    public static zzzq zze() {
        return zza;
    }

    private final String zzf(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzc;
    }

    private final void zzg(int i3) {
        if (i3 < 0 || i3 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzf(i3));
        }
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i4;
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzf(i3));
        }
        int i5 = i3 + 1;
        Object[] objArr = this.zzb;
        if (i4 < objArr.length) {
            System.arraycopy(objArr, i3, objArr, i5, i4 - i3);
        } else {
            Object[] objArr2 = new Object[((i4 * 3) / 2) + 1];
            System.arraycopy(objArr, 0, objArr2, 0, i3);
            System.arraycopy(this.zzb, i3, objArr2, i5, this.zzc - i3);
            this.zzb = objArr2;
        }
        this.zzb[i3] = obj;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        zzg(i3);
        return this.zzb[i3];
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        zza();
        zzg(i3);
        Object[] objArr = this.zzb;
        Object obj = objArr[i3];
        if (i3 < this.zzc - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (r2 - i3) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        zza();
        zzg(i3);
        Object[] objArr = this.zzb;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzyd
    public final /* bridge */ /* synthetic */ zzyd zzd(int i3) {
        if (i3 >= this.zzc) {
            return new zzzq(Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    private zzzq(Object[] objArr, int i3, boolean z2) {
        super(z2);
        this.zzb = objArr;
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i3 = this.zzc;
        Object[] objArr = this.zzb;
        if (i3 == objArr.length) {
            this.zzb = Arrays.copyOf(objArr, ((i3 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        objArr2[i4] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
