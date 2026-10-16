package com.google.android.gms.internal.play_billing;

import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes5.dex */
final class zzgp extends zzeh implements RandomAccess, zzfz {
    private static final long[] zza;
    private long[] zzb;
    private int zzc;

    static {
        long[] jArr = new long[0];
        zza = jArr;
        new zzgp(jArr, 0, false);
    }

    zzgp() {
        this(zza, 0, true);
    }

    private static int zzh(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String zzi(int i3) {
        return "Index:" + i3 + ", Size:" + this.zzc;
    }

    private final void zzj(int i3) {
        if (i3 < 0 || i3 >= this.zzc) {
            throw new IndexOutOfBoundsException(zzi(i3));
        }
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        long jLongValue = ((Long) obj).longValue();
        zza();
        if (i3 < 0 || i3 > (i4 = this.zzc)) {
            throw new IndexOutOfBoundsException(zzi(i3));
        }
        int i5 = i3 + 1;
        long[] jArr = this.zzb;
        int length = jArr.length;
        if (i4 < length) {
            System.arraycopy(jArr, i3, jArr, i5, i4 - i3);
        } else {
            long[] jArr2 = new long[zzh(length)];
            System.arraycopy(this.zzb, 0, jArr2, 0, i3);
            System.arraycopy(this.zzb, i3, jArr2, i5, this.zzc - i3);
            this.zzb = jArr2;
        }
        this.zzb[i3] = jLongValue;
        this.zzc++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        zza();
        byte[] bArr = zzga.zzb;
        collection.getClass();
        if (!(collection instanceof zzgp)) {
            return super.addAll(collection);
        }
        zzgp zzgpVar = (zzgp) collection;
        int i3 = zzgpVar.zzc;
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
        System.arraycopy(zzgpVar.zzb, 0, this.zzb, this.zzc, zzgpVar.zzc);
        this.zzc = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzgp)) {
            return super.equals(obj);
        }
        zzgp zzgpVar = (zzgp) obj;
        if (this.zzc != zzgpVar.zzc) {
            return false;
        }
        long[] jArr = zzgpVar.zzb;
        for (int i3 = 0; i3 < this.zzc; i3++) {
            if (this.zzb[i3] != jArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzj(i3);
        return Long.valueOf(this.zzb[i3]);
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.zzc; i4++) {
            long j3 = this.zzb[i4];
            byte[] bArr = zzga.zzb;
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

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        zza();
        zzj(i3);
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

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        zza();
        zzj(i3);
        long[] jArr = this.zzb;
        long j3 = jArr[i3];
        jArr[i3] = jLongValue;
        return Long.valueOf(j3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzc;
    }

    @Override // com.google.android.gms.internal.play_billing.zzfz
    public final /* bridge */ /* synthetic */ zzfz zzd(int i3) {
        if (i3 >= this.zzc) {
            return new zzgp(i3 == 0 ? zza : Arrays.copyOf(this.zzb, i3), this.zzc, true);
        }
        throw new IllegalArgumentException();
    }

    public final long zze(int i3) {
        zzj(i3);
        return this.zzb[i3];
    }

    public final void zzf(long j3) {
        zza();
        int i3 = this.zzc;
        int length = this.zzb.length;
        if (i3 == length) {
            long[] jArr = new long[zzh(length)];
            System.arraycopy(this.zzb, 0, jArr, 0, this.zzc);
            this.zzb = jArr;
        }
        long[] jArr2 = this.zzb;
        int i4 = this.zzc;
        this.zzc = i4 + 1;
        jArr2[i4] = j3;
    }

    final void zzg(int i3) {
        int length = this.zzb.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.zzb = new long[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzh(length);
        }
        this.zzb = Arrays.copyOf(this.zzb, length);
    }

    private zzgp(long[] jArr, int i3, boolean z2) {
        super(z2);
        this.zzb = jArr;
        this.zzc = i3;
    }

    @Override // com.google.android.gms.internal.play_billing.zzeh, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzf(((Long) obj).longValue());
        return true;
    }
}
