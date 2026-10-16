package com.google.android.gms.internal.play_billing;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzhj extends zzeh implements RandomAccess {
    private static final Object[] zza;
    private static final zzhj zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzhj(objArr, 0, false);
    }

    zzhj() {
        this(zza, 0, true);
    }

    public static zzhj zze() {
        return zzb;
    }

    private static int zzg(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String zzh(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzd;
    }

    private final void zzi(int i3) {
        if (i3 < 0 || i3 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzh(i3));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i4;
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzh(i3));
        }
        int i5 = i3 + 1;
        Object[] objArr = this.zzc;
        int length = objArr.length;
        if (i4 < length) {
            System.arraycopy(objArr, i3, objArr, i5, i4 - i3);
        } else {
            Object[] objArr2 = new Object[zzg(length)];
            System.arraycopy(this.zzc, 0, objArr2, 0, i3);
            System.arraycopy(this.zzc, i3, objArr2, i5, this.zzd - i3);
            this.zzc = objArr2;
        }
        this.zzc[i3] = obj;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        zzi(i3);
        return this.zzc[i3];
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        zza();
        zzi(i3);
        Object[] objArr = this.zzc;
        Object obj = objArr[i3];
        if (i3 < this.zzd - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (r2 - i3) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        zza();
        zzi(i3);
        Object[] objArr = this.zzc;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final /* bridge */ /* synthetic */ zzfz zzd(int i3) {
        if (i3 >= this.zzd) {
            return new zzhj(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    final void zzf(int i3) {
        int length = this.zzc.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new Object[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzg(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzhj(Object[] objArr, int i3, boolean z2) {
        super(z2);
        this.zzc = objArr;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i3 = this.zzd;
        int length = this.zzc.length;
        if (i3 == length) {
            this.zzc = Arrays.copyOf(this.zzc, zzg(length));
        }
        Object[] objArr = this.zzc;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        objArr[i4] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
