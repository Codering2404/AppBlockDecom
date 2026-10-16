package com.google.android.gms.internal.consent_sdk;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzry extends zzpb implements RandomAccess {
    private static final Object[] zza;
    private static final zzry zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zzry(objArr, 0, false);
    }

    zzry() {
        this(zza, 0, true);
    }

    public static zzry zze() {
        return zzb;
    }

    private static int zzf(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String zzg(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzd;
    }

    private final void zzh(int i3) {
        if (i3 < 0 || i3 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzg(i3));
        }
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpb, java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i4;
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzg(i3));
        }
        int i5 = i3 + 1;
        Object[] objArr = this.zzc;
        int length = objArr.length;
        if (i4 < length) {
            System.arraycopy(objArr, i3, objArr, i5, i4 - i3);
        } else {
            Object[] objArr2 = new Object[zzf(length)];
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
        zzh(i3);
        return this.zzc[i3];
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpb, java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        zza();
        zzh(i3);
        Object[] objArr = this.zzc;
        Object obj = objArr[i3];
        if (i3 < this.zzd - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (r2 - i3) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpb, java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        zza();
        zzh(i3);
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

    @Override // com.google.android.gms.internal.consent_sdk.zzqr
    public final /* bridge */ /* synthetic */ zzqr zzd(int i3) {
        if (i3 >= this.zzd) {
            return new zzry(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    private zzry(Object[] objArr, int i3, boolean z2) {
        super(z2);
        this.zzc = objArr;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.consent_sdk.zzpb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zza();
        int i3 = this.zzd;
        int length = this.zzc.length;
        if (i3 == length) {
            this.zzc = Arrays.copyOf(this.zzc, zzf(length));
        }
        Object[] objArr = this.zzc;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        objArr[i4] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
