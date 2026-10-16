package com.google.crypto.tink.shaded.protobuf;

import com.google.android.gms.common.api.Api;
import com.google.crypto.tink.shaded.protobuf.Internal;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final LongArrayList f87000d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f87001b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f87002c;

    static {
        LongArrayList longArrayList = new LongArrayList(new long[0], 0);
        f87000d = longArrayList;
        longArrayList.j();
    }

    LongArrayList() {
        this(new long[10], 0);
    }

    private void e(int i3, long j3) {
        int i4;
        a();
        if (i3 < 0 || i3 > (i4 = this.f87002c)) {
            throw new IndexOutOfBoundsException(n(i3));
        }
        long[] jArr = this.f87001b;
        if (i4 < jArr.length) {
            System.arraycopy(jArr, i3, jArr, i3 + 1, i4 - i3);
        } else {
            long[] jArr2 = new long[((i4 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            System.arraycopy(this.f87001b, i3, jArr2, i3 + 1, this.f87002c - i3);
            this.f87001b = jArr2;
        }
        this.f87001b[i3] = j3;
        this.f87002c++;
        ((AbstractList) this).modCount++;
    }

    private void g(int i3) {
        if (i3 < 0 || i3 >= this.f87002c) {
            throw new IndexOutOfBoundsException(n(i3));
        }
    }

    private String n(int i3) {
        return "Index:" + i3 + ", Size:" + this.f87002c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i3 = longArrayList.f87002c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f87002c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        long[] jArr = this.f87001b;
        if (i5 > jArr.length) {
            this.f87001b = Arrays.copyOf(jArr, i5);
        }
        System.arraycopy(longArrayList.f87001b, 0, this.f87001b, this.f87002c, longArrayList.f87002c);
        this.f87002c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Long l3) {
        e(i3, l3.longValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l3) {
        f(l3.longValue());
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.f87002c != longArrayList.f87002c) {
            return false;
        }
        long[] jArr = longArrayList.f87001b;
        for (int i3 = 0; i3 < this.f87002c; i3++) {
            if (this.f87001b[i3] != jArr[i3]) {
                return false;
            }
        }
        return true;
    }

    public void f(long j3) {
        a();
        int i3 = this.f87002c;
        long[] jArr = this.f87001b;
        if (i3 == jArr.length) {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            this.f87001b = jArr2;
        }
        long[] jArr3 = this.f87001b;
        int i4 = this.f87002c;
        this.f87002c = i4 + 1;
        jArr3[i4] = j3;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Long get(int i3) {
        return Long.valueOf(l(i3));
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i3 = 0; i3 < this.f87002c; i3++) {
            iF = (iF * 31) + Internal.f(this.f87001b[i3]);
        }
        return iF;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Long)) {
            return -1;
        }
        long jLongValue = ((Long) obj).longValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f87001b[i3] == jLongValue) {
                return i3;
            }
        }
        return -1;
    }

    public long l(int i3) {
        g(i3);
        return this.f87001b[i3];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Long remove(int i3) {
        a();
        g(i3);
        long[] jArr = this.f87001b;
        long j3 = jArr[i3];
        if (i3 < this.f87002c - 1) {
            System.arraycopy(jArr, i3 + 1, jArr, i3, (r3 - i3) - 1);
        }
        this.f87002c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j3);
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Long set(int i3, Long l3) {
        return Long.valueOf(q(i3, l3.longValue()));
    }

    public long q(int i3, long j3) {
        a();
        g(i3);
        long[] jArr = this.f87001b;
        long j4 = jArr[i3];
        jArr[i3] = j3;
        return j4;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        long[] jArr = this.f87001b;
        System.arraycopy(jArr, i4, jArr, i3, this.f87002c - i4);
        this.f87002c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f87002c;
    }

    private LongArrayList(long[] jArr, int i3) {
        this.f87001b = jArr;
        this.f87002c = i3;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    public Internal.LongList c(int i3) {
        if (i3 >= this.f87002c) {
            return new LongArrayList(Arrays.copyOf(this.f87001b, i3), this.f87002c);
        }
        throw new IllegalArgumentException();
    }
}
