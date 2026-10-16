package com.google.android.gms.internal.ads;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzifd extends zzicm implements RandomAccess, zziep, zzify {
    private static final long[] zza;
    private static final zzifd zzb;
    private long[] zzc;
    private int zzd;

    static {
        long[] jArr = new long[0];
        zza = jArr;
        zzb = new zzifd(jArr, 0, false);
    }

    zzifd() {
        this(zza, 0, true);
    }

    public static zzifd zzg() {
        return zzb;
    }

    private static int zzj(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final void zzk(int i3) {
        if (i3 < 0 || i3 >= this.zzd) {
            throw new IndexOutOfBoundsException(zzl(i3));
        }
    }

    private final String zzl(int i3) {
        int i4 = this.zzd;
        StringBuilder sb = new StringBuilder(String.valueOf(i3).length() + 13 + String.valueOf(i4).length());
        sb.append("Index:");
        sb.append(i3);
        sb.append(", Size:");
        sb.append(i4);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        long jLongValue = ((Long) obj).longValue();
        zzdW();
        if (i3 < 0 || i3 > (i4 = this.zzd)) {
            throw new IndexOutOfBoundsException(zzl(i3));
        }
        int i5 = i3 + 1;
        long[] jArr = this.zzc;
        int length = jArr.length;
        if (i4 < length) {
            System.arraycopy(jArr, i3, jArr, i5, i4 - i3);
        } else {
            long[] jArr2 = new long[zzj(length)];
            System.arraycopy(this.zzc, 0, jArr2, 0, i3);
            System.arraycopy(this.zzc, i3, jArr2, i5, this.zzd - i3);
            this.zzc = jArr2;
        }
        this.zzc[i3] = jLongValue;
        this.zzd++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zzdW();
        collection.getClass();
        if (!(collection instanceof zzifd)) {
            return super.addAll(collection);
        }
        zzifd zzifdVar = (zzifd) collection;
        int i3 = zzifdVar.zzd;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.zzd;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        long[] jArr = this.zzc;
        if (i5 > jArr.length) {
            this.zzc = Arrays.copyOf(jArr, i5);
        }
        System.arraycopy(zzifdVar.zzc, 0, this.zzc, this.zzd, zzifdVar.zzd);
        this.zzd = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzifd)) {
            return super.equals(obj);
        }
        zzifd zzifdVar = (zzifd) obj;
        if (this.zzd != zzifdVar.zzd) {
            return false;
        }
        long[] jArr = zzifdVar.zzc;
        for (int i3 = 0; i3 < this.zzd; i3++) {
            if (this.zzc[i3] != jArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzk(i3);
        return Long.valueOf(this.zzc[i3]);
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.zzd; i4++) {
            long j3 = this.zzc[i4];
            byte[] bArr = zzier.zza;
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
        int i3 = this.zzd;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.zzc[i4] == jLongValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zzdW();
        zzk(i3);
        long[] jArr = this.zzc;
        long j3 = jArr[i3];
        if (i3 < this.zzd - 1) {
            System.arraycopy(jArr, i3 + 1, jArr, i3, (r3 - i3) - 1);
        }
        this.zzd--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        zzdW();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.zzc;
        System.arraycopy(jArr, i4, jArr, i3, this.zzd - i4);
        this.zzd -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        return Long.valueOf(zze(i3, ((Long) obj).longValue()));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzd;
    }

    @Override // com.google.android.gms.internal.ads.zziep
    public final long zzc(int i3) {
        zzk(i3);
        return this.zzc[i3];
    }

    @Override // com.google.android.gms.internal.ads.zziep
    public final void zzd(long j3) {
        zzdW();
        int i3 = this.zzd;
        int length = this.zzc.length;
        if (i3 == length) {
            long[] jArr = new long[zzj(length)];
            System.arraycopy(this.zzc, 0, jArr, 0, this.zzd);
            this.zzc = jArr;
        }
        long[] jArr2 = this.zzc;
        int i4 = this.zzd;
        this.zzd = i4 + 1;
        jArr2[i4] = j3;
    }

    @Override // com.google.android.gms.internal.ads.zziep
    public final long zze(int i3, long j3) {
        zzdW();
        zzk(i3);
        long[] jArr = this.zzc;
        long j4 = jArr[i3];
        jArr[i3] = j3;
        return j4;
    }

    @Override // com.google.android.gms.internal.ads.zzieq, com.google.android.gms.internal.ads.zzieg
    /* JADX INFO: renamed from: zzf */
    public final zziep zzh(int i3) {
        if (i3 >= this.zzd) {
            return new zzifd(i3 == 0 ? zza : Arrays.copyOf(this.zzc, i3), this.zzd, true);
        }
        throw new IllegalArgumentException();
    }

    final void zzi(int i3) {
        int length = this.zzc.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzc = new long[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzj(length);
        }
        this.zzc = Arrays.copyOf(this.zzc, length);
    }

    private zzifd(long[] jArr, int i3, boolean z2) {
        super(z2);
        this.zzc = jArr;
        this.zzd = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzicm, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzd(((Long) obj).longValue());
        return true;
    }
}
