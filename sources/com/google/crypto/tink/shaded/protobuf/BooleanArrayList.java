package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class BooleanArrayList extends AbstractProtobufList<Boolean> implements Internal.BooleanList, RandomAccess, PrimitiveNonBoxingCollection {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final BooleanArrayList f86688d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean[] f86689b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f86690c;

    static {
        BooleanArrayList booleanArrayList = new BooleanArrayList(new boolean[0], 0);
        f86688d = booleanArrayList;
        booleanArrayList.j();
    }

    BooleanArrayList() {
        this(new boolean[10], 0);
    }

    private void e(int i3, boolean z2) {
        int i4;
        a();
        if (i3 < 0 || i3 > (i4 = this.f86690c)) {
            throw new IndexOutOfBoundsException(n(i3));
        }
        boolean[] zArr = this.f86689b;
        if (i4 < zArr.length) {
            System.arraycopy(zArr, i3, zArr, i3 + 1, i4 - i3);
        } else {
            boolean[] zArr2 = new boolean[((i4 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            System.arraycopy(this.f86689b, i3, zArr2, i3 + 1, this.f86690c - i3);
            this.f86689b = zArr2;
        }
        this.f86689b[i3] = z2;
        this.f86690c++;
        ((AbstractList) this).modCount++;
    }

    private void g(int i3) {
        if (i3 < 0 || i3 >= this.f86690c) {
            throw new IndexOutOfBoundsException(n(i3));
        }
    }

    private String n(int i3) {
        return "Index:" + i3 + ", Size:" + this.f86690c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof BooleanArrayList)) {
            return super.addAll(collection);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) collection;
        int i3 = booleanArrayList.f86690c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f86690c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        boolean[] zArr = this.f86689b;
        if (i5 > zArr.length) {
            this.f86689b = Arrays.copyOf(zArr, i5);
        }
        System.arraycopy(booleanArrayList.f86689b, 0, this.f86689b, this.f86690c, booleanArrayList.f86690c);
        this.f86690c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Boolean bool) {
        e(i3, bool.booleanValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Boolean bool) {
        f(bool.booleanValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof BooleanArrayList)) {
            return super.equals(obj);
        }
        BooleanArrayList booleanArrayList = (BooleanArrayList) obj;
        if (this.f86690c != booleanArrayList.f86690c) {
            return false;
        }
        boolean[] zArr = booleanArrayList.f86689b;
        for (int i3 = 0; i3 < this.f86690c; i3++) {
            if (this.f86689b[i3] != zArr[i3]) {
                return false;
            }
        }
        return true;
    }

    public void f(boolean z2) {
        a();
        int i3 = this.f86690c;
        boolean[] zArr = this.f86689b;
        if (i3 == zArr.length) {
            boolean[] zArr2 = new boolean[((i3 * 3) / 2) + 1];
            System.arraycopy(zArr, 0, zArr2, 0, i3);
            this.f86689b = zArr2;
        }
        boolean[] zArr3 = this.f86689b;
        int i4 = this.f86690c;
        this.f86690c = i4 + 1;
        zArr3[i4] = z2;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Boolean get(int i3) {
        return Boolean.valueOf(l(i3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iC = 1;
        for (int i3 = 0; i3 < this.f86690c; i3++) {
            iC = (iC * 31) + Internal.c(this.f86689b[i3]);
        }
        return iC;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Boolean)) {
            return -1;
        }
        boolean zBooleanValue = ((Boolean) obj).booleanValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f86689b[i3] == zBooleanValue) {
                return i3;
            }
        }
        return -1;
    }

    public boolean l(int i3) {
        g(i3);
        return this.f86689b[i3];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Boolean remove(int i3) {
        a();
        g(i3);
        boolean[] zArr = this.f86689b;
        boolean z2 = zArr[i3];
        if (i3 < this.f86690c - 1) {
            System.arraycopy(zArr, i3 + 1, zArr, i3, (r2 - i3) - 1);
        }
        this.f86690c--;
        ((AbstractList) this).modCount++;
        return Boolean.valueOf(z2);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Boolean set(int i3, Boolean bool) {
        return Boolean.valueOf(q(i3, bool.booleanValue()));
    }

    public boolean q(int i3, boolean z2) {
        a();
        g(i3);
        boolean[] zArr = this.f86689b;
        boolean z3 = zArr[i3];
        zArr[i3] = z2;
        return z3;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        boolean[] zArr = this.f86689b;
        System.arraycopy(zArr, i4, zArr, i3, this.f86690c - i4);
        this.f86690c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f86690c;
    }

    private BooleanArrayList(boolean[] zArr, int i3) {
        this.f86689b = zArr;
        this.f86690c = i3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public Internal.BooleanList c(int i3) {
        if (i3 >= this.f86690c) {
            return new BooleanArrayList(Arrays.copyOf(this.f86689b, i3), this.f86690c);
        }
        throw new IllegalArgumentException();
    }
}
