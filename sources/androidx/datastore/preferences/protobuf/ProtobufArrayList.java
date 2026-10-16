package androidx.datastore.preferences.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ProtobufArrayList f36557d = new ProtobufArrayList(new Object[0], 0, false);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f36558b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f36559c;

    private ProtobufArrayList(Object[] objArr, int i3, boolean z2) {
        super(z2);
        this.f36558b = objArr;
        this.f36559c = i3;
    }

    private static Object[] b(int i3) {
        return new Object[i3];
    }

    public static ProtobufArrayList d() {
        return f36557d;
    }

    private void e(int i3) {
        if (i3 < 0 || i3 >= this.f36559c) {
            throw new IndexOutOfBoundsException(f(i3));
        }
    }

    private String f(int i3) {
        return "Index:" + i3 + ", Size:" + this.f36559c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i3 = this.f36559c;
        Object[] objArr = this.f36558b;
        if (i3 == objArr.length) {
            this.f36558b = Arrays.copyOf(objArr, ((i3 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f36558b;
        int i4 = this.f36559c;
        this.f36559c = i4 + 1;
        objArr2[i4] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ProtobufArrayList c(int i3) {
        if (i3 >= this.f36559c) {
            return new ProtobufArrayList(Arrays.copyOf(this.f36558b, i3), this.f36559c, true);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        e(i3);
        return this.f36558b[i3];
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Object remove(int i3) {
        a();
        e(i3);
        Object[] objArr = this.f36558b;
        Object obj = objArr[i3];
        if (i3 < this.f36559c - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (r2 - i3) - 1);
        }
        this.f36559c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        a();
        e(i3);
        Object[] objArr = this.f36558b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f36559c;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        int i4;
        a();
        if (i3 >= 0 && i3 <= (i4 = this.f36559c)) {
            Object[] objArr = this.f36558b;
            if (i4 < objArr.length) {
                System.arraycopy(objArr, i3, objArr, i3 + 1, i4 - i3);
            } else {
                Object[] objArrB = b(((i4 * 3) / 2) + 1);
                System.arraycopy(this.f36558b, 0, objArrB, 0, i3);
                System.arraycopy(this.f36558b, i3, objArrB, i3 + 1, this.f36559c - i3);
                this.f36558b = objArrB;
            }
            this.f36558b[i3] = obj;
            this.f36559c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(f(i3));
    }
}
