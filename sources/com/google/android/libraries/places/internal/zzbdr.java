package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbdr extends zzbcb implements RandomAccess, zzbdy, zzbfg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final int[] f76087d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzbdr f76088f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f76089b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f76090c;

    static {
        int[] iArr = new int[0];
        f76087d = iArr;
        f76088f = new zzbdr(iArr, 0, false);
    }

    zzbdr() {
        this(f76087d, 0, true);
    }

    public static zzbdr b() {
        return f76088f;
    }

    private static int d(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final void e(int i3) {
        if (i3 < 0 || i3 >= this.f76090c) {
            throw new IndexOutOfBoundsException(f(i3));
        }
    }

    private final String f(int i3) {
        return zzbce.b(this.f76090c, i3, Ascii.CR, "Index:", ", Size:");
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        int iIntValue = ((Integer) obj).intValue();
        a();
        if (i3 < 0 || i3 > (i4 = this.f76090c)) {
            throw new IndexOutOfBoundsException(f(i3));
        }
        int i5 = i3 + 1;
        int[] iArr = this.f76089b;
        int length = iArr.length;
        if (i4 < length) {
            System.arraycopy(iArr, i3, iArr, i5, i4 - i3);
        } else {
            int[] iArr2 = new int[d(length)];
            System.arraycopy(this.f76089b, 0, iArr2, 0, i3);
            System.arraycopy(this.f76089b, i3, iArr2, i5, this.f76090c - i3);
            this.f76089b = iArr2;
        }
        this.f76089b[i3] = iIntValue;
        this.f76090c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        byte[] bArr = zzbeb.f76092b;
        collection.getClass();
        if (!(collection instanceof zzbdr)) {
            return super.addAll(collection);
        }
        zzbdr zzbdrVar = (zzbdr) collection;
        int i3 = zzbdrVar.f76090c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f76090c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        int[] iArr = this.f76089b;
        if (i5 > iArr.length) {
            this.f76089b = Arrays.copyOf(iArr, i5);
        }
        System.arraycopy(zzbdrVar.f76089b, 0, this.f76089b, this.f76090c, zzbdrVar.f76090c);
        this.f76090c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbdr)) {
            return super.equals(obj);
        }
        zzbdr zzbdrVar = (zzbdr) obj;
        if (this.f76090c != zzbdrVar.f76090c) {
            return false;
        }
        int[] iArr = zzbdrVar.f76089b;
        for (int i3 = 0; i3 < this.f76090c; i3++) {
            if (this.f76089b[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        e(i3);
        return Integer.valueOf(this.f76089b[i3]);
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.f76090c; i4++) {
            i3 = (i3 * 31) + this.f76089b[i4];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int i3 = this.f76090c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f76089b[i4] == iIntValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        a();
        e(i3);
        int[] iArr = this.f76089b;
        int i4 = iArr[i3];
        if (i3 < this.f76090c - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (r2 - i3) - 1);
        }
        this.f76090c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f76089b;
        System.arraycopy(iArr, i4, iArr, i3, this.f76090c - i4);
        this.f76090c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        int iIntValue = ((Integer) obj).intValue();
        a();
        e(i3);
        int[] iArr = this.f76089b;
        int i4 = iArr[i3];
        iArr[i3] = iIntValue;
        return Integer.valueOf(i4);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f76090c;
    }

    @Override // com.google.android.libraries.places.internal.zzbea, com.google.android.libraries.places.internal.zzbds
    /* JADX INFO: renamed from: zze */
    public final zzbdy zzg(int i3) {
        if (i3 >= this.f76090c) {
            return new zzbdr(i3 == 0 ? f76087d : Arrays.copyOf(this.f76089b, i3), this.f76090c, true);
        }
        throw new IllegalArgumentException();
    }

    public final int zzf(int i3) {
        e(i3);
        return this.f76089b[i3];
    }

    @Override // com.google.android.libraries.places.internal.zzbdy
    public final void zzh(int i3) {
        a();
        int i4 = this.f76090c;
        int length = this.f76089b.length;
        if (i4 == length) {
            int[] iArr = new int[d(length)];
            System.arraycopy(this.f76089b, 0, iArr, 0, this.f76090c);
            this.f76089b = iArr;
        }
        int[] iArr2 = this.f76089b;
        int i5 = this.f76090c;
        this.f76090c = i5 + 1;
        iArr2[i5] = i3;
    }

    private zzbdr(int[] iArr, int i3, boolean z2) {
        super(z2);
        this.f76089b = iArr;
        this.f76090c = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        zzh(((Integer) obj).intValue());
        return true;
    }
}
