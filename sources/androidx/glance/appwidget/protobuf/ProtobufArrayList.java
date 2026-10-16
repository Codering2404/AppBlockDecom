package androidx.glance.appwidget.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ProtobufArrayList f39203d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f39204b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f39205c;

    static {
        ProtobufArrayList protobufArrayList = new ProtobufArrayList(new Object[0], 0);
        f39203d = protobufArrayList;
        protobufArrayList.j();
    }

    private ProtobufArrayList(Object[] objArr, int i3) {
        this.f39204b = objArr;
        this.f39205c = i3;
    }

    private static Object[] b(int i3) {
        return new Object[i3];
    }

    public static ProtobufArrayList d() {
        return f39203d;
    }

    private void e(int i3) {
        if (i3 < 0 || i3 >= this.f39205c) {
            throw new IndexOutOfBoundsException(f(i3));
        }
    }

    private String f(int i3) {
        return "Index:" + i3 + ", Size:" + this.f39205c;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i3 = this.f39205c;
        Object[] objArr = this.f39204b;
        if (i3 == objArr.length) {
            this.f39204b = Arrays.copyOf(objArr, ((i3 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f39204b;
        int i4 = this.f39205c;
        this.f39205c = i4 + 1;
        objArr2[i4] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.glance.appwidget.protobuf.Internal.ProtobufList
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ProtobufArrayList c(int i3) {
        if (i3 >= this.f39205c) {
            return new ProtobufArrayList(Arrays.copyOf(this.f39204b, i3), this.f39205c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        e(i3);
        return this.f39204b[i3];
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Object remove(int i3) {
        a();
        e(i3);
        Object[] objArr = this.f39204b;
        Object obj = objArr[i3];
        if (i3 < this.f39205c - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (r2 - i3) - 1);
        }
        this.f39205c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        a();
        e(i3);
        Object[] objArr = this.f39204b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f39205c;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        int i4;
        a();
        if (i3 >= 0 && i3 <= (i4 = this.f39205c)) {
            Object[] objArr = this.f39204b;
            if (i4 < objArr.length) {
                System.arraycopy(objArr, i3, objArr, i3 + 1, i4 - i3);
            } else {
                Object[] objArrB = b(((i4 * 3) / 2) + 1);
                System.arraycopy(this.f39204b, 0, objArrB, 0, i3);
                System.arraycopy(this.f39204b, i3, objArrB, i3 + 1, this.f39205c - i3);
                this.f39204b = objArrB;
            }
            this.f39204b[i3] = obj;
            this.f39205c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(f(i3));
    }
}
