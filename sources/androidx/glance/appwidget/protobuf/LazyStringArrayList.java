package androidx.glance.appwidget.protobuf;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class LazyStringArrayList extends AbstractProtobufList<String> implements LazyStringList, RandomAccess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final LazyStringArrayList f39130c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LazyStringList f39131d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f39132b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LazyStringArrayList f39133a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(int i3, byte[] bArr) {
            this.f39133a.o(i3, bArr);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] get(int i3) {
            return this.f39133a.u(i3);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] remove(int i3) {
            String strRemove = this.f39133a.remove(i3);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.p(strRemove);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public byte[] set(int i3, byte[] bArr) {
            Object objA = this.f39133a.A(i3, bArr);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.p(objA);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f39133a.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LazyStringArrayList f39134a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(int i3, ByteString byteString) {
            this.f39134a.l(i3, byteString);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ByteString get(int i3) {
            return this.f39134a.v(i3);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ByteString remove(int i3) {
            String strRemove = this.f39134a.remove(i3);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.q(strRemove);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ByteString set(int i3, ByteString byteString) {
            Object objZ = this.f39134a.z(i3, byteString);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.q(objZ);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f39134a.size();
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList();
        f39130c = lazyStringArrayList;
        lazyStringArrayList.j();
        f39131d = lazyStringArrayList;
    }

    public LazyStringArrayList() {
        this(10);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object A(int i3, byte[] bArr) {
        a();
        return this.f39132b.set(i3, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3, ByteString byteString) {
        a();
        this.f39132b.add(i3, byteString);
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i3, byte[] bArr) {
        a();
        this.f39132b.add(i3, bArr);
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] p(Object obj) {
        return obj instanceof byte[] ? (byte[]) obj : obj instanceof String ? Internal.j((String) obj) : ((ByteString) obj).I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString q(Object obj) {
        return obj instanceof ByteString ? (ByteString) obj : obj instanceof String ? ByteString.s((String) obj) : ByteString.p((byte[]) obj);
    }

    private static String s(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof ByteString ? ((ByteString) obj).M() : Internal.k((byte[]) obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object z(int i3, ByteString byteString) {
        a();
        return this.f39132b.set(i3, byteString);
    }

    @Override // androidx.glance.appwidget.protobuf.LazyStringList
    public LazyStringList F() {
        return m() ? new UnmodifiableLazyStringList(this) : this;
    }

    @Override // androidx.glance.appwidget.protobuf.LazyStringList
    public void X0(ByteString byteString) {
        a();
        this.f39132b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f39132b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.glance.appwidget.protobuf.LazyStringList
    public List k() {
        return Collections.unmodifiableList(this.f39132b);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, androidx.glance.appwidget.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void add(int i3, String str) {
        a();
        this.f39132b.add(i3, str);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.glance.appwidget.protobuf.LazyStringList
    public Object r(int i3) {
        return this.f39132b.get(i3);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f39132b.size();
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public String get(int i3) {
        Object obj = this.f39132b.get(i3);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String strM = byteString.M();
            if (byteString.y()) {
                this.f39132b.set(i3, strM);
            }
            return strM;
        }
        byte[] bArr = (byte[]) obj;
        String strK = Internal.k(bArr);
        if (Internal.g(bArr)) {
            this.f39132b.set(i3, strK);
        }
        return strK;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public byte[] u(int i3) {
        Object obj = this.f39132b.get(i3);
        byte[] bArrP = p(obj);
        if (bArrP != obj) {
            this.f39132b.set(i3, bArrP);
        }
        return bArrP;
    }

    public ByteString v(int i3) {
        Object obj = this.f39132b.get(i3);
        ByteString byteStringQ = q(obj);
        if (byteStringQ != obj) {
            this.f39132b.set(i3, byteStringQ);
        }
        return byteStringQ;
    }

    @Override // androidx.glance.appwidget.protobuf.Internal.ProtobufList
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public LazyStringArrayList c(int i3) {
        if (i3 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i3);
        arrayList.addAll(this.f39132b);
        return new LazyStringArrayList(arrayList);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public String remove(int i3) {
        a();
        Object objRemove = this.f39132b.remove(i3);
        ((AbstractList) this).modCount++;
        return s(objRemove);
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public String set(int i3, String str) {
        a();
        return s(this.f39132b.set(i3, str));
    }

    public LazyStringArrayList(int i3) {
        this(new ArrayList(i3));
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection collection) {
        a();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).k();
        }
        boolean zAddAll = this.f39132b.addAll(i3, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // androidx.glance.appwidget.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private LazyStringArrayList(ArrayList arrayList) {
        this.f39132b = arrayList;
    }
}
