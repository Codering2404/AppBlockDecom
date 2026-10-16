package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class LongArrayList extends AbstractProtobufList<Long> implements Internal.LongList, RandomAccess, PrimitiveNonBoxingCollection {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final LongArrayList f36492d = new LongArrayList(new long[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private long[] f36493b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36494c;

    LongArrayList() {
        this(new long[10], 0, true);
    }

    private void e(int i3, long j3) {
        int i4;
        a();
        if (i3 < 0 || i3 > (i4 = this.f36494c)) {
            throw new IndexOutOfBoundsException(n(i3));
        }
        long[] jArr = this.f36493b;
        if (i4 < jArr.length) {
            System.arraycopy(jArr, i3, jArr, i3 + 1, i4 - i3);
        } else {
            long[] jArr2 = new long[((i4 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            System.arraycopy(this.f36493b, i3, jArr2, i3 + 1, this.f36494c - i3);
            this.f36493b = jArr2;
        }
        this.f36493b[i3] = j3;
        this.f36494c++;
        ((AbstractList) this).modCount++;
    }

    private void g(int i3) {
        if (i3 < 0 || i3 >= this.f36494c) {
            throw new IndexOutOfBoundsException(n(i3));
        }
    }

    private String n(int i3) {
        return "Index:" + i3 + ", Size:" + this.f36494c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof LongArrayList)) {
            return super.addAll(collection);
        }
        LongArrayList longArrayList = (LongArrayList) collection;
        int i3 = longArrayList.f36494c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f36494c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        long[] jArr = this.f36493b;
        if (i5 > jArr.length) {
            this.f36493b = Arrays.copyOf(jArr, i5);
        }
        System.arraycopy(longArrayList.f36493b, 0, this.f36493b, this.f36494c, longArrayList.f36494c);
        this.f36494c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Long l3) {
        e(i3, l3.longValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Long l3) {
        f(l3.longValue());
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LongArrayList)) {
            return super.equals(obj);
        }
        LongArrayList longArrayList = (LongArrayList) obj;
        if (this.f36494c != longArrayList.f36494c) {
            return false;
        }
        long[] jArr = longArrayList.f36493b;
        for (int i3 = 0; i3 < this.f36494c; i3++) {
            if (this.f36493b[i3] != jArr[i3]) {
                return false;
            }
        }
        return true;
    }

    public void f(long j3) {
        a();
        int i3 = this.f36494c;
        long[] jArr = this.f36493b;
        if (i3 == jArr.length) {
            long[] jArr2 = new long[((i3 * 3) / 2) + 1];
            System.arraycopy(jArr, 0, jArr2, 0, i3);
            this.f36493b = jArr2;
        }
        long[] jArr3 = this.f36493b;
        int i4 = this.f36494c;
        this.f36494c = i4 + 1;
        jArr3[i4] = j3;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Long get(int i3) {
        return Long.valueOf(l(i3));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int iF = 1;
        for (int i3 = 0; i3 < this.f36494c; i3++) {
            iF = (iF * 31) + Internal.f(this.f36493b[i3]);
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
            if (this.f36493b[i3] == jLongValue) {
                return i3;
            }
        }
        return -1;
    }

    public long l(int i3) {
        g(i3);
        return this.f36493b[i3];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Long remove(int i3) {
        a();
        g(i3);
        long[] jArr = this.f36493b;
        long j3 = jArr[i3];
        if (i3 < this.f36494c - 1) {
            System.arraycopy(jArr, i3 + 1, jArr, i3, (r3 - i3) - 1);
        }
        this.f36494c--;
        ((AbstractList) this).modCount++;
        return Long.valueOf(j3);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Long set(int i3, Long l3) {
        return Long.valueOf(q(i3, l3.longValue()));
    }

    public long q(int i3, long j3) {
        a();
        g(i3);
        long[] jArr = this.f36493b;
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
        long[] jArr = this.f36493b;
        System.arraycopy(jArr, i4, jArr, i3, this.f36494c - i4);
        this.f36494c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f36494c;
    }

    private LongArrayList(long[] jArr, int i3, boolean z2) {
        super(z2);
        this.f36493b = jArr;
        this.f36494c = i3;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public Internal.LongList c(int i3) {
        if (i3 >= this.f36494c) {
            return new LongArrayList(Arrays.copyOf(this.f36493b, i3), this.f36494c, true);
        }
        throw new IllegalArgumentException();
    }
}
