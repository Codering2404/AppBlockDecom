package androidx.glance.appwidget.protobuf;

import androidx.glance.appwidget.protobuf.Internal;
import com.google.android.gms.common.api.Api;
import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class IntArrayList extends AbstractProtobufList<Integer> implements Internal.IntList, RandomAccess, PrimitiveNonBoxingCollection {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final IntArrayList f39076d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int[] f39077b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f39078c;

    static {
        IntArrayList intArrayList = new IntArrayList(new int[0], 0);
        f39076d = intArrayList;
        intArrayList.j();
    }

    IntArrayList() {
        this(new int[10], 0);
    }

    private void f(int i3, int i4) {
        int i5;
        a();
        if (i3 < 0 || i3 > (i5 = this.f39078c)) {
            throw new IndexOutOfBoundsException(l(i3));
        }
        int[] iArr = this.f39077b;
        if (i5 < iArr.length) {
            System.arraycopy(iArr, i3, iArr, i3 + 1, i5 - i3);
        } else {
            int[] iArr2 = new int[((i5 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i3);
            System.arraycopy(this.f39077b, i3, iArr2, i3 + 1, this.f39078c - i3);
            this.f39077b = iArr2;
        }
        this.f39077b[i3] = i4;
        this.f39078c++;
        ((AbstractList) this).modCount++;
    }

    private void g(int i3) {
        if (i3 < 0 || i3 >= this.f39078c) {
            throw new IndexOutOfBoundsException(l(i3));
        }
    }

    private String l(int i3) {
        return "Index:" + i3 + ", Size:" + this.f39078c;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        a();
        Internal.a(collection);
        if (!(collection instanceof IntArrayList)) {
            return super.addAll(collection);
        }
        IntArrayList intArrayList = (IntArrayList) collection;
        int i3 = intArrayList.f39078c;
        if (i3 == 0) {
            return false;
        }
        int i4 = this.f39078c;
        if (Api.BaseClientBuilder.API_PRIORITY_OTHER - i4 < i3) {
            throw new OutOfMemoryError();
        }
        int i5 = i4 + i3;
        int[] iArr = this.f39077b;
        if (i5 > iArr.length) {
            this.f39077b = Arrays.copyOf(iArr, i5);
        }
        System.arraycopy(intArrayList.f39077b, 0, this.f39077b, this.f39078c, intArrayList.f39078c);
        this.f39078c = i5;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public void add(int i3, Integer num) {
        f(i3, num.intValue());
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean contains(Object obj) {
        return indexOf(obj) != -1;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public boolean add(Integer num) {
        e(num.intValue());
        return true;
    }

    public void e(int i3) {
        a();
        int i4 = this.f39078c;
        int[] iArr = this.f39077b;
        if (i4 == iArr.length) {
            int[] iArr2 = new int[((i4 * 3) / 2) + 1];
            System.arraycopy(iArr, 0, iArr2, 0, i4);
            this.f39077b = iArr2;
        }
        int[] iArr3 = this.f39077b;
        int i5 = this.f39078c;
        this.f39078c = i5 + 1;
        iArr3[i5] = i3;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IntArrayList)) {
            return super.equals(obj);
        }
        IntArrayList intArrayList = (IntArrayList) obj;
        if (this.f39078c != intArrayList.f39078c) {
            return false;
        }
        int[] iArr = intArrayList.f39077b;
        for (int i3 = 0; i3 < this.f39078c; i3++) {
            if (this.f39077b[i3] != iArr[i3]) {
                return false;
            }
        }
        return true;
    }

    public int getInt(int i3) {
        g(i3);
        return this.f39077b[i3];
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public Integer get(int i3) {
        return Integer.valueOf(getInt(i3));
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public int hashCode() {
        int i3 = 1;
        for (int i4 = 0; i4 < this.f39078c; i4++) {
            i3 = (i3 * 31) + this.f39077b[i4];
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
            if (this.f39077b[i3] == iIntValue) {
                return i3;
            }
        }
        return -1;
    }

    @Override // androidx.glance.appwidget.protobuf.Internal.ProtobufList
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Internal.IntList c(int i3) {
        if (i3 >= this.f39078c) {
            return new IntArrayList(Arrays.copyOf(this.f39077b, i3), this.f39078c);
        }
        throw new IllegalArgumentException();
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public Integer remove(int i3) {
        a();
        g(i3);
        int[] iArr = this.f39077b;
        int i4 = iArr[i3];
        if (i3 < this.f39078c - 1) {
            System.arraycopy(iArr, i3 + 1, iArr, i3, (r2 - i3) - 1);
        }
        this.f39078c--;
        ((AbstractList) this).modCount++;
        return Integer.valueOf(i4);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public Integer set(int i3, Integer num) {
        return Integer.valueOf(q(i3, num.intValue()));
    }

    public int q(int i3, int i4) {
        a();
        g(i3);
        int[] iArr = this.f39077b;
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
        int[] iArr = this.f39077b;
        System.arraycopy(iArr, i4, iArr, i3, this.f39078c - i4);
        this.f39078c -= i4 - i3;
        ((AbstractList) this).modCount++;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f39078c;
    }

    private IntArrayList(int[] iArr, int i3) {
        this.f39077b = iArr;
        this.f39078c = i3;
    }
}
