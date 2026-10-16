package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbfi extends zzbcb implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object[] f76146d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final zzbfi f76147f;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f76148b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f76149c;

    static {
        Object[] objArr = new Object[0];
        f76146d = objArr;
        f76147f = new zzbfi(objArr, 0, false);
    }

    zzbfi() {
        this(f76146d, 0, true);
    }

    public static zzbfi b() {
        return f76147f;
    }

    private final String e(int i3) {
        return zzbce.b(this.f76149c, i3, Ascii.CR, "Index:", ", Size:");
    }

    private static int zzf(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final void zzh(int i3) {
        if (i3 < 0 || i3 >= this.f76149c) {
            throw new IndexOutOfBoundsException(e(i3));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final void add(int i3, Object obj) {
        int i4;
        a();
        if (i3 < 0 || i3 > (i4 = this.f76149c)) {
            throw new IndexOutOfBoundsException(e(i3));
        }
        int i5 = i3 + 1;
        Object[] objArr = this.f76148b;
        int length = objArr.length;
        if (i4 < length) {
            System.arraycopy(objArr, i3, objArr, i5, i4 - i3);
        } else {
            Object[] objArr2 = new Object[zzf(length)];
            System.arraycopy(this.f76148b, 0, objArr2, 0, i3);
            System.arraycopy(this.f76148b, i3, objArr2, i5, this.f76149c - i3);
            this.f76148b = objArr2;
        }
        this.f76148b[i3] = obj;
        this.f76149c++;
        ((AbstractList) this).modCount++;
    }

    final void d(int i3) {
        int length = this.f76148b.length;
        if (i3 <= length) {
            return;
        }
        if (length == 0) {
            this.f76148b = new Object[Math.max(i3, 10)];
            return;
        }
        while (length < i3) {
            length = zzf(length);
        }
        this.f76148b = Arrays.copyOf(this.f76148b, length);
    }

    @Override // java.util.AbstractList, java.util.List
    public final Object get(int i3) {
        zzh(i3);
        return this.f76148b[i3];
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final Object remove(int i3) {
        a();
        zzh(i3);
        Object[] objArr = this.f76148b;
        Object obj = objArr[i3];
        if (i3 < this.f76149c - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (r2 - i3) - 1);
        }
        this.f76149c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final Object set(int i3, Object obj) {
        a();
        zzh(i3);
        Object[] objArr = this.f76148b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f76149c;
    }

    @Override // com.google.android.libraries.places.internal.zzbea, com.google.android.libraries.places.internal.zzbds
    public final /* bridge */ /* synthetic */ zzbea zzg(int i3) {
        if (i3 >= this.f76149c) {
            return new zzbfi(i3 == 0 ? f76146d : Arrays.copyOf(this.f76148b, i3), this.f76149c, true);
        }
        throw new IllegalArgumentException();
    }

    private zzbfi(Object[] objArr, int i3, boolean z2) {
        super(z2);
        this.f76148b = objArr;
        this.f76149c = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean add(Object obj) {
        a();
        int i3 = this.f76149c;
        int length = this.f76148b.length;
        if (i3 == length) {
            this.f76148b = Arrays.copyOf(this.f76148b, zzf(length));
        }
        Object[] objArr = this.f76148b;
        int i4 = this.f76149c;
        this.f76149c = i4 + 1;
        objArr[i4] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }
}
