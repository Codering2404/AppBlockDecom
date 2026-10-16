package androidx.datastore.preferences.protobuf;

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
    private static final LazyStringArrayList f36484c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final LazyStringList f36485d;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final List f36486b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteArrayListView extends AbstractList<byte[]> implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LazyStringArrayList f36487a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(int i3, byte[] bArr) {
            this.f36487a.o(i3, bArr);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public byte[] get(int i3) {
            return this.f36487a.v(i3);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public byte[] remove(int i3) {
            String strRemove = this.f36487a.remove(i3);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.q(strRemove);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public byte[] set(int i3, byte[] bArr) {
            Object objB = this.f36487a.B(i3, bArr);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.q(objB);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f36487a.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class ByteStringListView extends AbstractList<ByteString> implements RandomAccess {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final LazyStringArrayList f36488a;

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public void add(int i3, ByteString byteString) {
            this.f36488a.l(i3, byteString);
            ((AbstractList) this).modCount++;
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ByteString get(int i3) {
            return this.f36488a.w(i3);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ByteString remove(int i3) {
            String strRemove = this.f36488a.remove(i3);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.s(strRemove);
        }

        @Override // java.util.AbstractList, java.util.List
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public ByteString set(int i3, ByteString byteString) {
            Object objA = this.f36488a.A(i3, byteString);
            ((AbstractList) this).modCount++;
            return LazyStringArrayList.s(objA);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f36488a.size();
        }
    }

    static {
        LazyStringArrayList lazyStringArrayList = new LazyStringArrayList(false);
        f36484c = lazyStringArrayList;
        f36485d = lazyStringArrayList;
    }

    private LazyStringArrayList(boolean z2) {
        super(z2);
        this.f36486b = Collections.EMPTY_LIST;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object A(int i3, ByteString byteString) {
        a();
        return this.f36486b.set(i3, byteString);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Object B(int i3, byte[] bArr) {
        a();
        return this.f36486b.set(i3, bArr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(int i3, ByteString byteString) {
        a();
        this.f36486b.add(i3, byteString);
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(int i3, byte[] bArr) {
        a();
        this.f36486b.add(i3, bArr);
        ((AbstractList) this).modCount++;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] q(Object obj) {
        return obj instanceof byte[] ? (byte[]) obj : obj instanceof String ? Internal.j((String) obj) : ((ByteString) obj).I();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ByteString s(Object obj) {
        return obj instanceof ByteString ? (ByteString) obj : obj instanceof String ? ByteString.s((String) obj) : ByteString.p((byte[]) obj);
    }

    private static String t(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof ByteString ? ((ByteString) obj).M() : Internal.k((byte[]) obj);
    }

    @Override // androidx.datastore.preferences.protobuf.LazyStringList
    public void K1(ByteString byteString) {
        a();
        this.f36486b.add(byteString);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public void clear() {
        a();
        this.f36486b.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // androidx.datastore.preferences.protobuf.LazyStringList
    public List k() {
        return Collections.unmodifiableList(this.f36486b);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, androidx.datastore.preferences.protobuf.Internal.ProtobufList
    public /* bridge */ /* synthetic */ boolean m() {
        return super.m();
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public void add(int i3, String str) {
        a();
        this.f36486b.add(i3, str);
        ((AbstractList) this).modCount++;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public boolean add(String str) {
        a();
        this.f36486b.add(str);
        ((AbstractList) this).modCount++;
        return true;
    }

    @Override // androidx.datastore.preferences.protobuf.LazyStringList
    public Object r(int i3) {
        return this.f36486b.get(i3);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        return this.f36486b.size();
    }

    @Override // java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public String get(int i3) {
        Object obj = this.f36486b.get(i3);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof ByteString) {
            ByteString byteString = (ByteString) obj;
            String strM = byteString.M();
            if (byteString.y()) {
                this.f36486b.set(i3, strM);
            }
            return strM;
        }
        byte[] bArr = (byte[]) obj;
        String strK = Internal.k(bArr);
        if (Internal.g(bArr)) {
            this.f36486b.set(i3, strK);
        }
        return strK;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public byte[] v(int i3) {
        Object obj = this.f36486b.get(i3);
        byte[] bArrQ = q(obj);
        if (bArrQ != obj) {
            this.f36486b.set(i3, bArrQ);
        }
        return bArrQ;
    }

    public ByteString w(int i3) {
        Object obj = this.f36486b.get(i3);
        ByteString byteStringS = s(obj);
        if (byteStringS != obj) {
            this.f36486b.set(i3, byteStringS);
        }
        return byteStringS;
    }

    @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
    /* JADX INFO: renamed from: x, reason: merged with bridge method [inline-methods] */
    public LazyStringArrayList c(int i3) {
        if (i3 < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i3);
        arrayList.addAll(this.f36486b);
        return new LazyStringArrayList(arrayList);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public String remove(int i3) {
        a();
        Object objRemove = this.f36486b.remove(i3);
        ((AbstractList) this).modCount++;
        return t(objRemove);
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    /* JADX INFO: renamed from: z, reason: merged with bridge method [inline-methods] */
    public String set(int i3, String str) {
        a();
        return t(this.f36486b.set(i3, str));
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection collection) {
        a();
        if (collection instanceof LazyStringList) {
            collection = ((LazyStringList) collection).k();
        }
        boolean zAddAll = this.f36486b.addAll(i3, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // androidx.datastore.preferences.protobuf.AbstractProtobufList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    private LazyStringArrayList(ArrayList arrayList) {
        this.f36486b = arrayList;
    }
}
