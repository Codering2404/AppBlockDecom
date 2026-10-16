package com.google.android.gms.internal.measurement;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zznv extends zzku implements RandomAccess {
    private static final Object[] zza;
    private static final zznv zzb;
    private Object[] zzc;
    private int zzd;

    static {
        Object[] objArr = new Object[0];
        zza = objArr;
        zzb = new zznv(objArr, 0, false);
    }

    zznv() {
        this(zza, 0, true);
    }

    public static zznv zzd() {
        return zzb;
    }

    private static int zzf(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final void zzh(int i3) {
        if (i3 < 0 || i3 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzi(i3));
        }
    }

    private final String zzi(int i3) {
        return zzkw.zza(this.zzd, i3, Ascii.CR, "Index:", ", Size:");
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i4;
        zzcF();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzi(i3));
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

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        zzcF();
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

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        zzcF();
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

    final void zze(int i3) {
        int length = this.zzc.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new Object[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzf(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    @Override // com.google.android.gms.internal.measurement.zzmo, com.google.android.gms.internal.measurement.zzmh
    public final /* bridge */ /* synthetic */ zzmo zzg(int i3) {
        if (i3 >= this.zzd) {
            return new zznv(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    private zznv(Object[] objArr, int i3, boolean z2) {
        super(z2);
        this.zzc = objArr;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.measurement.zzku, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        zzcF();
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
