package com.google.crypto.tink.shaded.protobuf;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
final class ProtobufArrayList<E> extends AbstractProtobufList<E> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final ProtobufArrayList f87064d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f87065b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f87066c;

    static {
        ProtobufArrayList protobufArrayList = new ProtobufArrayList(new Object[0], 0);
        f87064d = protobufArrayList;
        protobufArrayList.j();
    }

    private ProtobufArrayList(Object[] objArr, int i3) {
        this.f87065b = objArr;
        this.f87066c = i3;
    }

    private static Object[] b(int i3) {
        return new Object[i3];
    }

    public static ProtobufArrayList d() {
        return f87064d;
    }

    private void e(int i3) {
        if (i3 < 0 || i3 >= this.f87066c) {
            throw new IndexOutOfBoundsException(f(i3));
        }
    }

    private String f(int i3) {
        return "Index:" + i3 + ", Size:" + this.f87066c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        a();
        int i3 = this.f87066c;
        Object[] objArr = this.f87065b;
        if (i3 == objArr.length) {
            this.f87065b = Arrays.copyOf(objArr, ((i3 * 3) / 2) + 1);
        }
        Object[] objArr2 = this.f87065b;
        int i4 = this.f87066c;
        this.f87066c = i4 + 1;
        objArr2[i4] = obj;
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.Internal.ProtobufList, com.google.crypto.tink.shaded.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public ProtobufArrayList c(int i3) {
        if (i3 >= this.f87066c) {
            return new ProtobufArrayList(Arrays.copyOf(this.f87065b, i3), this.f87066c);
        }
        throw new IllegalArgumentException();
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        e(i3);
        return this.f87065b[i3];
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Object remove(int i3) {
        a();
        e(i3);
        Object[] objArr = this.f87065b;
        Object obj = objArr[i3];
        if (i3 < this.f87066c - 1) {
            System.arraycopy(objArr, i3 + 1, objArr, i3, (r2 - i3) - 1);
        }
        this.f87066c--;
        ((AbstractList) this).modCount++;
        return obj;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        a();
        e(i3);
        Object[] objArr = this.f87065b;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        ((AbstractList) this).modCount++;
        return obj2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f87066c;
    }

    @Override // com.google.crypto.tink.shaded.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        int i4;
        a();
        if (i3 >= 0 && i3 <= (i4 = this.f87066c)) {
            Object[] objArr = this.f87065b;
            if (i4 < objArr.length) {
                System.arraycopy(objArr, i3, objArr, i3 + 1, i4 - i3);
            } else {
                Object[] objArrB = b(((i4 * 3) / 2) + 1);
                System.arraycopy(this.f87065b, 0, objArrB, 0, i3);
                System.arraycopy(this.f87065b, i3, objArrB, i3 + 1, this.f87066c - i3);
                this.f87065b = objArrB;
            }
            this.f87065b[i3] = obj;
            this.f87066c++;
            ((AbstractList) this).modCount++;
            return;
        }
        throw new IndexOutOfBoundsException(f(i3));
    }
}
