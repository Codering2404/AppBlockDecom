package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbcw extends zzbcb implements RandomAccess, zzbdt, zzbfg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final double[] f76036d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private double[] f76037b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f76038c;

    static {
        double[] dArr = new double[0];
        f76036d = dArr;
        new zzbcw(dArr, 0, false);
    }

    zzbcw() {
        this(f76036d, 0, true);
    }

    private static int e(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String f(int i3) {
        return zzbce.b(this.f76038c, i3, Ascii.CR, "Index:", ", Size:");
    }

    private final void zzi(int i3) {
        if (i3 < 0 || i3 >= this.f76038c) {
            throw new IndexOutOfBoundsException(f(i3));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        double dDoubleValue = ((Double) obj).doubleValue();
        a();
        if (i3 < 0 || i3 > (i4 = this.f76038c)) {
            throw new IndexOutOfBoundsException(f(i3));
        }
        int i5 = i3 + 1;
        double[] dArr = this.f76037b;
        int length = dArr.length;
        if (i4 < length) {
            System.arraycopy(dArr, i3, dArr, i5, i4 - i3);
        } else {
            double[] dArr2 = new double[e(length)];
            System.arraycopy(this.f76037b, 0, dArr2, 0, i3);
            System.arraycopy(this.f76037b, i3, dArr2, i5, this.f76038c - i3);
            this.f76037b = dArr2;
        }
        this.f76037b[i3] = dDoubleValue;
        this.f76038c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        byte[] bArr = zzbeb.f76092b;
        collection.getClass();
        if (!(collection instanceof zzbcw)) {
            return super.addAll(collection);
        }
        zzbcw zzbcwVar = (zzbcw) collection;
        int i3 = zzbcwVar.f76038c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f76038c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        double[] dArr = this.f76037b;
        if (i5 > dArr.length) {
            this.f76037b = Arrays.copyOf(dArr, i5);
        }
        System.arraycopy(zzbcwVar.f76037b, 0, this.f76037b, this.f76038c, zzbcwVar.f76038c);
        this.f76038c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final double b(int i3) {
        zzi(i3);
        return this.f76037b[i3];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(double d3) {
        a();
        int i3 = this.f76038c;
        int length = this.f76037b.length;
        if (i3 == length) {
            double[] dArr = new double[e(length)];
            System.arraycopy(this.f76037b, 0, dArr, 0, this.f76038c);
            this.f76037b = dArr;
        }
        double[] dArr2 = this.f76037b;
        int i4 = this.f76038c;
        this.f76038c = i4 + 1;
        dArr2[i4] = d3;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbcw)) {
            return super.equals(obj);
        }
        zzbcw zzbcwVar = (zzbcw) obj;
        if (this.f76038c != zzbcwVar.f76038c) {
            return false;
        }
        double[] dArr = zzbcwVar.f76037b;
        for (int i3 = 0; i3 < this.f76038c; i3++) {
            if (Double.doubleToLongBits(this.f76037b[i3]) != Double.doubleToLongBits(dArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzi(i3);
        return Double.valueOf(this.f76037b[i3]);
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.f76038c; i4++) {
            long jDoubleToLongBits = Double.doubleToLongBits(this.f76037b[i4]);
            byte[] bArr = zzbeb.f76092b;
            i3 = (i3 * 31) + ((int) (jDoubleToLongBits ^ (jDoubleToLongBits >>> 32)));
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Double)) {
            return -1;
        }
        double dDoubleValue = ((Double) obj).doubleValue();
        int i3 = this.f76038c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f76037b[i4] == dDoubleValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        a();
        zzi(i3);
        double[] dArr = this.f76037b;
        double d3 = dArr[i3];
        if (i3 < this.f76038c - 1) {
            System.arraycopy(dArr, i3 + 1, dArr, i3, (r3 - i3) - 1);
        }
        this.f76038c--;
        ((AbstractList) this).modCount++;
        return Double.valueOf(d3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        double[] dArr = this.f76037b;
        System.arraycopy(dArr, i4, dArr, i3, this.f76038c - i4);
        this.f76038c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        double dDoubleValue = ((Double) obj).doubleValue();
        a();
        zzi(i3);
        double[] dArr = this.f76037b;
        double d3 = dArr[i3];
        dArr[i3] = dDoubleValue;
        return Double.valueOf(d3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f76038c;
    }

    @Override // com.google.android.libraries.places.internal.zzbea, com.google.android.libraries.places.internal.zzbds
    /* JADX INFO: renamed from: zzd */
    public final zzbdt zzg(int i3) {
        if (i3 >= this.f76038c) {
            return new zzbcw(i3 == 0 ? f76036d : Arrays.copyOf(this.f76037b, i3), this.f76038c, true);
        }
        throw new IllegalArgumentException();
    }

    private zzbcw(double[] dArr, int i3, boolean z2) {
        super(z2);
        this.f76037b = dArr;
        this.f76038c = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Double) obj).doubleValue());
        return true;
    }
}
