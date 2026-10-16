package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbem extends zzbcb implements RandomAccess, zzbdz, zzbfg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final long[] f76112d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzbem f76113f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f76114b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f76115c;

    static {
        long[] jArr = new long[0];
        f76112d = jArr;
        f76113f = new zzbem(jArr, 0, false);
    }

    zzbem() {
        this(f76112d, 0, true);
    }

    public static zzbem b() {
        return f76113f;
    }

    private static int f(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String g(int i3) {
        return zzbce.b(this.f76115c, i3, Ascii.CR, "Index:", ", Size:");
    }

    private final void zzi(int i3) {
        if (i3 < 0 || i3 >= this.f76115c) {
            throw new IndexOutOfBoundsException(g(i3));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        long jLongValue = ((Long) obj).longValue();
        a();
        if (i3 < 0 || i3 > (i4 = this.f76115c)) {
            throw new IndexOutOfBoundsException(g(i3));
        }
        int i5 = i3 + 1;
        long[] jArr = this.f76114b;
        int length = jArr.length;
        if (i4 < length) {
            System.arraycopy(jArr, i3, jArr, i5, i4 - i3);
        } else {
            long[] jArr2 = new long[f(length)];
            System.arraycopy(this.f76114b, 0, jArr2, 0, i3);
            System.arraycopy(this.f76114b, i3, jArr2, i5, this.f76115c - i3);
            this.f76114b = jArr2;
        }
        this.f76114b[i3] = jLongValue;
        this.f76115c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        byte[] bArr = zzbeb.f76092b;
        collection.getClass();
        if (!(collection instanceof zzbem)) {
            return super.addAll(collection);
        }
        zzbem zzbemVar = (zzbem) collection;
        int i3 = zzbemVar.f76115c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f76115c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        long[] jArr = this.f76114b;
        if (i5 > jArr.length) {
            this.f76114b = Arrays.copyOf(jArr, i5);
        }
        System.arraycopy(zzbemVar.f76114b, 0, this.f76114b, this.f76115c, zzbemVar.f76115c);
        this.f76115c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final long d(int i3) {
        zzi(i3);
        return this.f76114b[i3];
    }

    public final void e(long j3) {
        a();
        int i3 = this.f76115c;
        int length = this.f76114b.length;
        if (i3 == length) {
            long[] jArr = new long[f(length)];
            System.arraycopy(this.f76114b, 0, jArr, 0, this.f76115c);
            this.f76114b = jArr;
        }
        long[] jArr2 = this.f76114b;
        int i4 = this.f76115c;
        this.f76115c = i4 + 1;
        jArr2[i4] = j3;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbem)) {
            return super.equals(obj);
        }
        zzbem zzbemVar = (zzbem) obj;
        if (this.f76115c != zzbemVar.f76115c) {
            return false;
        }
        long[] jArr = zzbemVar.f76114b;
        for (int i3 = 0; i3 < this.f76115c; i3++) {
            if (this.f76114b[i3] != jArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzi(i3);
        return Long.valueOf(this.f76114b[i3]);
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.f76115c; i4++) {
            long j3 = this.f76114b[i4];
            byte[] bArr = zzbeb.f76092b;
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
        int i3 = this.f76115c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f76114b[i4] == jLongValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        a();
        zzi(i3);
        long[] jArr = this.f76114b;
        long j3 = jArr[i3];
        if (i3 < this.f76115c - 1) {
            System.arraycopy(jArr, i3 + 1, jArr, i3, (r3 - i3) - 1);
        }
        this.f76115c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f76114b;
        System.arraycopy(jArr, i4, jArr, i3, this.f76115c - i4);
        this.f76115c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        long jLongValue = ((Long) obj).longValue();
        a();
        zzi(i3);
        long[] jArr = this.f76114b;
        long j3 = jArr[i3];
        jArr[i3] = jLongValue;
        return Long.valueOf(j3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f76115c;
    }

    @Override // com.google.android.libraries.places.internal.zzbea, com.google.android.libraries.places.internal.zzbds
    /* JADX INFO: renamed from: zzc */
    public final zzbdz zzg(int i3) {
        if (i3 >= this.f76115c) {
            return new zzbem(i3 == 0 ? f76112d : Arrays.copyOf(this.f76114b, i3), this.f76115c, true);
        }
        throw new IllegalArgumentException();
    }

    private zzbem(long[] jArr, int i3, boolean z2) {
        super(z2);
        this.f76114b = jArr;
        this.f76115c = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        e(((Long) obj).longValue());
        return true;
    }
}
