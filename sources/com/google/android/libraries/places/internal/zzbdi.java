package com.google.android.libraries.places.internal;

import com.applovin.exoplayer2.common.base.Ascii;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class zzbdi extends zzbcb implements RandomAccess, zzbdx, zzbfg {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final float[] f76076d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private float[] f76077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f76078c;

    static {
        float[] fArr = new float[0];
        f76076d = fArr;
        new zzbdi(fArr, 0, false);
    }

    zzbdi() {
        this(f76076d, 0, true);
    }

    private static int e(int i3) {
        return Math.max(((i3 * 3) / 2) + 1, 10);
    }

    private final String f(int i3) {
        return zzbce.b(this.f76078c, i3, Ascii.CR, "Index:", ", Size:");
    }

    private final void zzi(int i3) {
        if (i3 < 0 || i3 >= this.f76078c) {
            throw new IndexOutOfBoundsException(f(i3));
        }
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i3, Object obj) {
        int i4;
        float fFloatValue = ((Float) obj).floatValue();
        a();
        if (i3 < 0 || i3 > (i4 = this.f76078c)) {
            throw new IndexOutOfBoundsException(f(i3));
        }
        int i5 = i3 + 1;
        float[] fArr = this.f76077b;
        int length = fArr.length;
        if (i4 < length) {
            System.arraycopy(fArr, i3, fArr, i5, i4 - i3);
        } else {
            float[] fArr2 = new float[e(length)];
            System.arraycopy(this.f76077b, 0, fArr2, 0, i3);
            System.arraycopy(this.f76077b, i3, fArr2, i5, this.f76078c - i3);
            this.f76077b = fArr2;
        }
        this.f76077b[i3] = fFloatValue;
        this.f76078c++;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection collection) {
        a();
        byte[] bArr = zzbeb.f76092b;
        collection.getClass();
        if (!(collection instanceof zzbdi)) {
            return super.addAll(collection);
        }
        zzbdi zzbdiVar = (zzbdi) collection;
        int i3 = zzbdiVar.f76078c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f76078c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        float[] fArr = this.f76077b;
        if (i5 > fArr.length) {
            this.f76077b = Arrays.copyOf(fArr, i5);
        }
        System.arraycopy(zzbdiVar.f76077b, 0, this.f76077b, this.f76078c, zzbdiVar.f76078c);
        this.f76078c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    public final float b(int i3) {
        zzi(i3);
        return this.f76077b[i3];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    public final void d(float f3) {
        a();
        int i3 = this.f76078c;
        int length = this.f76077b.length;
        if (i3 == length) {
            float[] fArr = new float[e(length)];
            System.arraycopy(this.f76077b, 0, fArr, 0, this.f76078c);
            this.f76077b = fArr;
        }
        float[] fArr2 = this.f76077b;
        int i4 = this.f76078c;
        this.f76078c = i4 + 1;
        fArr2[i4] = f3;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof zzbdi)) {
            return super.equals(obj);
        }
        zzbdi zzbdiVar = (zzbdi) obj;
        if (this.f76078c != zzbdiVar.f76078c) {
            return false;
        }
        float[] fArr = zzbdiVar.f76077b;
        for (int i3 = 0; i3 < this.f76078c; i3++) {
            if (Float.floatToIntBits(this.f76077b[i3]) != Float.floatToIntBits(fArr[i3])) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i3) {
        zzi(i3);
        return Float.valueOf(this.f76077b[i3]);
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.Collection, java.util.List
    public final int hashCode() {
        int iFloatToIntBits = 1;
        for (int i3 = 0; i3 < this.f76078c; i3++) {
            iFloatToIntBits = (iFloatToIntBits * 31) + Float.floatToIntBits(this.f76077b[i3]);
        }
        return iFloatToIntBits;
    }

    @Override // java.util.AbstractList, java.util.List
    public final int indexOf(Object obj) {
        if (!(obj instanceof Float)) {
            return -1;
        }
        float fFloatValue = ((Float) obj).floatValue();
        int i3 = this.f76078c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (this.f76077b[i4] == fFloatValue) {
                return i4;
            }
        }
        return -1;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object remove(int i3) {
        a();
        zzi(i3);
        float[] fArr = this.f76077b;
        float f3 = fArr[i3];
        if (i3 < this.f76078c - 1) {
            System.arraycopy(fArr, i3 + 1, fArr, i3, (r2 - i3) - 1);
        }
        this.f76078c--;
        ((AbstractList) this).modCount++;
        return Float.valueOf(f3);
    }

    @Override // java.util.AbstractList
    protected final void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        float[] fArr = this.f76077b;
        System.arraycopy(fArr, i4, fArr, i3, this.f76078c - i4);
        this.f76078c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.List
    public final /* bridge */ /* synthetic */ Object set(int i3, Object obj) {
        float fFloatValue = ((Float) obj).floatValue();
        a();
        zzi(i3);
        float[] fArr = this.f76077b;
        float f3 = fArr[i3];
        fArr[i3] = fFloatValue;
        return Float.valueOf(f3);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.f76078c;
    }

    @Override // com.google.android.libraries.places.internal.zzbea, com.google.android.libraries.places.internal.zzbds
    /* JADX INFO: renamed from: zzd */
    public final zzbdx zzg(int i3) {
        if (i3 >= this.f76078c) {
            return new zzbdi(i3 == 0 ? f76076d : Arrays.copyOf(this.f76077b, i3), this.f76078c, true);
        }
        throw new IllegalArgumentException();
    }

    private zzbdi(float[] fArr, int i3, boolean z2) {
        super(z2);
        this.f76077b = fArr;
        this.f76078c = i3;
    }

    @Override // com.google.android.libraries.places.internal.zzbcb, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        d(((Float) obj).floatValue());
        return true;
    }
}
