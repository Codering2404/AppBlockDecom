package com.google.android.gms.internal.gtm;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzyv extends zztn implements RandomAccess, zzyd, zzzo {
    private static final zzyv zza = new zzyv(new long[0], 0, false);
    private long[] zzb;
    private int zzc;

    zzyv() {
        this(new long[10], 0, true);
    }

    private final String zzg(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzc;
    }

    private final void zzh(int i3) {
        if (i3 < 0 || i3 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzg(i3));
        }
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        long jLongValue = ((Long) obj).longValue();
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzg(i3));
        }
        int i5 = i3 + 1;
        long[] jArr = this.zzb;
        if (i4 < jArr.length) {
            System.arraycopy(jArr, i3, jArr, i5, i4 - i3);
        } else {
            long[] jArr2 = new long[((i4 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            System.arraycopy(this.zzb, i3, jArr2, i5, this.zzc - i3);
            this.zzb = jArr2;
        }
        this.zzb[i3] = jLongValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzye.zzd;
        collection.getClass();
        if (!(collection instanceof zzyv)) {
            return super.addAll(collection);
        }
        zzyv zzyvVar = (zzyv) collection;
        int i3 = zzyvVar.zzc;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzc;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        long[] jArr = this.zzb;
        if (i5 > jArr.length) {
            this.zzb = Arrays.copyOf(jArr, i5);
        }
        System.arraycopy(zzyvVar.zzb, 0, this.zzb, this.zzc, zzyvVar.zzc);
        this.zzc = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzyv)) {
            return super.equals(obj);
        }
        zzyv zzyvVar = (zzyv) obj;
        if (this.zzc != zzyvVar.zzc) {
            return false;
        }
        long[] jArr = zzyvVar.zzb;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            if (this.zzb[i3] != jArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzh(i3);
        return Long.valueOf(this.zzb[i3]);
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            long j3 = this.zzb[i4];
            byte[] bArr = zzye.zzd;
            i3 = (i3 * 31) + ((int) (j3 ^ (j3 >>> 32)));
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int i3 = this.zzc;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzb[i4] == jLongValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        zzh(i3);
        long[] jArr = this.zzb;
        long j3 = jArr[i3];
        if (i3 < this.zzc - 1) {
            System.arraycopy(jArr, i3 + 1, jArr, i3, (r3 - i3) - 1);
        }
        this.zzc--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zza();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzb;
        System.arraycopy(jArr, i4, jArr, i3, this.zzc - i4);
        this.zzc -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zza();
        zzh(i3);
        long[] jArr = this.zzb;
        long j3 = jArr[i3];
        jArr[i3] = jLongValue;
        return Long.valueOf(j3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.gtm.zzyd
    public final /* bridge */ /* synthetic */ zzyd zzd(int i3) {
        if (i3 >= this.zzc) {
            return new zzyv(Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i3) {
        zzh(i3);
        return this.zzb[i3];
    }

    public final void zzf(long j3) {
        zza();
        int i3 = this.zzc;
        long[] jArr = this.zzb;
        if (i3 == jArr.length) {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            this.zzb = jArr2;
        }
        long[] jArr3 = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        jArr3[i4] = j3;
    }

    private zzyv(long[] jArr, int i3, boolean z2) {
        super(z2);
        this.zzb = jArr;
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.gtm.zztn, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
