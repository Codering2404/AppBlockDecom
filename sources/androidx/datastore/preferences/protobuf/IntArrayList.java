package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.Internal;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final IntArrayList f36420d = new IntArrayList(new int[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f36421b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36422c;

    IntArrayList() {
        this(new int[10], 0, true);
    }

    private void f(int i3, int i4) {
        int i5;
        a();
        if (i3 < 0 || i3 > (i5 = this.f36422c)) {
            throw new IndexOutOfBoundsException(n(i3));
        }
        int[] iArr = this.f36421b;
        if (i5 < iArr.length) {
            System.arraycopy(iArr, i3, iArr, i3 + 1, i5 - i3);
        } else {
            int[] iArr2 = new int[((i5 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.f36421b, i3, iArr2, i3 + 1, this.f36422c - i3);
            this.f36421b = iArr2;
        }
        this.f36421b[i3] = i4;
        this.f36422c++;
        ((AbstractList) this).modCount++;
    }

    public static IntArrayList g() {
        return f36420d;
    }

    private void h(int i3) {
        if (i3 < 0 || i3 >= this.f36422c) {
            throw new IndexOutOfBoundsException(n(i3));
        }
    }

    private String n(int i3) {
        return "Index:" + i3 + ", Size:" + this.f36422c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i3 = intArrayList.f36422c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f36422c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        int[] iArr = this.f36421b;
        if (i5 > iArr.length) {
            this.f36421b = Arrays.copyOf(iArr, i5);
        }
        System.arraycopy(intArrayList.f36421b, 0, this.f36421b, this.f36422c, intArrayList.f36422c);
        this.f36422c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Integer num) {
        f(i3, num.intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        e(num.intValue());
        return true;
    }

    public void e(int i3) {
        a();
        int i4 = this.f36422c;
        int[] iArr = this.f36421b;
        if (i4 == iArr.length) {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f36421b = iArr2;
        }
        int[] iArr3 = this.f36421b;
        int i5 = this.f36422c;
        this.f36422c = i5 + 1;
        iArr3[i5] = i3;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.f36422c != intArrayList.f36422c) {
            return false;
        }
        int[] iArr = intArrayList.f36421b;
        for (int i3 = 0; i3 < this.f36422c; i3++) {
            if (this.f36421b[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.IntList
    public int getInt(int i3) {
        h(i3);
        return this.f36421b[i3];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.f36422c; i4++) {
            i3 = (i3 * 31) + this.f36421b[i4];
        }
        return i3;
    }

    @Override // java.util.AbstractList, java.util.List
    public int indexOf(Object obj) {
        if (!(obj instanceof Integer)) {
            return -1;
        }
        int iIntValue = ((Integer) obj).intValue();
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (this.f36421b[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public Integer get(int i3) {
        return Integer.valueOf(getInt(i3));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i3) {
        a();
        h(i3);
        int[] iArr = this.f36421b;
        int i4 = iArr[i3];
        if (i3 < this.f36422c - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (r2 - i3) - 1);
        }
        this.f36422c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Integer set(int i3, Integer num) {
        return Integer.valueOf(q(i3, num.intValue()));
    }

    public int q(int i3, int i4) {
        a();
        h(i3);
        int[] iArr = this.f36421b;
        int i5 = iArr[i3];
        iArr[i3] = i4;
        return i5;
    }

    @Override // java.util.AbstractList
    protected void removeRange(int i3, int i4) {
        a();
        if (i4 < i3) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        int[] iArr = this.f36421b;
        System.arraycopy(iArr, i4, iArr, i3, this.f36422c - i4);
        this.f36422c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f36422c;
    }

    private IntArrayList(int[] iArr, int i3, boolean z2) {
        super(z2);
        this.f36421b = iArr;
        this.f36422c = i3;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    public Internal.IntList c(int i3) {
        if (i3 >= this.f36422c) {
            return new IntArrayList(Arrays.copyOf(this.f36421b, i3), this.f36422c, true);
        }
        throw new IllegalArgumentException();
    }
}
