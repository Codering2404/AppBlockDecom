package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import com.google.android.material.bottomsheet.lKiE.YznnJpHcAmeoW;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbcd extends zzbcb implements RandomAccess, zzbds, zzbfg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final boolean[] f75987d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean[] f75988b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f75989c;

    static {
        boolean[] zArr = new boolean[0];
        f75987d = zArr;
        new zzbcd(zArr, 0, false);
    }

    zzbcd() {
        this(f75987d, 0, true);
    }

    private static int e(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final void zzi(int i3) {
        if (i3 < 0 || i3 >= this.f75989c) {
            throw new IndexOutOfBoundsException(f(i3));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        a();
        if (i3 < 0 || i3 > (i4 = this.f75989c)) {
            throw new IndexOutOfBoundsException(f(i3));
        }
        int i5 = i3 + 1;
        boolean[] zArr = this.f75988b;
        int length = zArr.length;
        if (i4 < length) {
            System.arraycopy(zArr, i3, zArr, i5, i4 - i3);
        } else {
            boolean[] zArr2 = new boolean[e(length)];
            System.arraycopy(this.f75988b, 0, zArr2, 0, i3);
            System.arraycopy(this.f75988b, i3, zArr2, i5, this.f75989c - i3);
            this.f75988b = zArr2;
        }
        this.f75988b[i3] = zBooleanValue;
        this.f75989c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        byte[] bArr = zzbeb.f76092b;
        collection.getClass();
        if (!(collection instanceof zzbcd)) {
            return super.addAll(collection);
        }
        zzbcd zzbcdVar = (zzbcd) collection;
        int i3 = zzbcdVar.f75989c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f75989c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        boolean[] zArr = this.f75988b;
        if (i5 > zArr.length) {
            this.f75988b = Arrays.copyOf(zArr, i5);
        }
        System.arraycopy(zzbcdVar.f75988b, 0, this.f75988b, this.f75989c, zzbcdVar.f75989c);
        this.f75989c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final boolean b(int i3) {
        zzi(i3);
        return this.f75988b[i3];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(boolean z2) {
        a();
        int i3 = this.f75989c;
        int length = this.f75988b.length;
        if (i3 == length) {
            boolean[] zArr = new boolean[e(length)];
            System.arraycopy(this.f75988b, 0, zArr, 0, this.f75989c);
            this.f75988b = zArr;
        }
        boolean[] zArr2 = this.f75988b;
        int i4 = this.f75989c;
        this.f75989c = i4 + 1;
        zArr2[i4] = z2;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbcd)) {
            return super.equals(obj);
        }
        zzbcd zzbcdVar = (zzbcd) obj;
        if (this.f75989c != zzbcdVar.f75989c) {
            return false;
        }
        boolean[] zArr = zzbcdVar.f75988b;
        for (int i3 = 0; i3 < this.f75989c; i3++) {
            if (this.f75988b[i3] != zArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzi(i3);
        return Boolean.valueOf(this.f75988b[i3]);
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iA = 1;
        for (int i3 = 0; i3 < this.f75989c; i3++) {
            iA = (iA * 31) + zzbeb.a(this.f75988b[i3]);
        }
        return iA;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int i3 = this.f75989c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f75988b[i4] == zBooleanValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        a();
        zzi(i3);
        boolean[] zArr = this.f75988b;
        boolean z2 = zArr[i3];
        if (i3 < this.f75989c - 1) {
            System.arraycopy(zArr, i3 + 1, zArr, i3, (r2 - i3) - 1);
        }
        this.f75989c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f75988b;
        System.arraycopy(zArr, i4, zArr, i3, this.f75989c - i4);
        this.f75989c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        a();
        zzi(i3);
        boolean[] zArr = this.f75988b;
        boolean z2 = zArr[i3];
        zArr[i3] = zBooleanValue;
        return Boolean.valueOf(z2);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f75989c;
    }

    @Override // com.google.android.libraries.places.internal.zzbea, com.google.android.libraries.places.internal.zzbds
    /* JADX INFO: renamed from: zzd */
    public final zzbds zzg(int i3) {
        if (i3 >= this.f75989c) {
            return new zzbcd(i3 == 0 ? f75987d : Arrays.copyOf(this.f75988b, i3), this.f75989c, true);
        }
        throw new IllegalArgumentException();
    }

    private zzbcd(boolean[] zArr, int i3, boolean z2) {
        super(z2);
        this.f75988b = zArr;
        this.f75989c = i3;
    }

    private final String f(int i3) {
        return zzbce.b(this.f75989c, i3, Ascii.CR, "Index:", YznnJpHcAmeoW.ZfN);
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Boolean) obj).booleanValue());
        return true;
    }
}
