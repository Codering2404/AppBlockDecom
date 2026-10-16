package androidx.datastore.preferences.protobuf;

import com.facebook.stetho.common.Utf8Charset;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.AbstractList;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.RandomAccess;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class Internal {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    static final Charset f36423a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Charset f36424b = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Charset f36425c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f36426d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f36427e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CodedInputStream f36428f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BooleanList extends ProtobufList<Boolean> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        BooleanList c(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DoubleList extends ProtobufList<Double> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        DoubleList c(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EnumLite {
        int J();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EnumLiteMap<T extends EnumLite> {
        EnumLite a(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface EnumVerifier {
        boolean a(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface FloatList extends ProtobufList<Float> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        FloatList c(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface IntList extends ProtobufList<Integer> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        IntList c(int i3);

        int getInt(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class IntListAdapter<T> extends AbstractList<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final IntList f36429a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final IntConverter f36430b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface IntConverter<T> {
            Object a(int i3);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i3) {
            return this.f36430b.a(this.f36429a.getInt(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f36429a.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ListAdapter<F, T> extends AbstractList<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f36431a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Converter f36432b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface Converter<F, T> {
            Object a(Object obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i3) {
            return this.f36432b.a(this.f36431a.get(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f36431a.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface LongList extends ProtobufList<Long> {
        @Override // androidx.datastore.preferences.protobuf.Internal.ProtobufList, androidx.datastore.preferences.protobuf.Internal.BooleanList
        LongList c(int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f36433a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Converter f36434b;

        /* JADX INFO: renamed from: androidx.datastore.preferences.protobuf.Internal$MapAdapter$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements Converter<Integer, EnumLite> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ EnumLiteMap f36435a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ EnumLite f36436b;

            @Override // androidx.datastore.preferences.protobuf.Internal.MapAdapter.Converter
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer b(EnumLite enumLite) {
                return Integer.valueOf(enumLite.J());
            }

            @Override // androidx.datastore.preferences.protobuf.Internal.MapAdapter.Converter
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public EnumLite a(Integer num) {
                EnumLite enumLiteA = this.f36435a.a(num.intValue());
                return enumLiteA == null ? this.f36436b : enumLiteA;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface Converter<A, B> {
            Object a(Object obj);

            Object b(Object obj);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class EntryAdapter implements Map.Entry<K, V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Map.Entry f36437a;

            public EntryAdapter(Map.Entry entry) {
                this.f36437a = entry;
            }

            @Override // java.util.Map.Entry
            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                return (obj instanceof Map.Entry) && getKey().equals(((Map.Entry) obj).getKey()) && getValue().equals(getValue());
            }

            @Override // java.util.Map.Entry
            public Object getKey() {
                return this.f36437a.getKey();
            }

            @Override // java.util.Map.Entry
            public Object getValue() {
                return MapAdapter.this.f36434b.a(this.f36437a.getValue());
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.f36437a.hashCode();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Map.Entry
            public Object setValue(Object obj) {
                Object value = this.f36437a.setValue(MapAdapter.this.f36434b.b(obj));
                if (value == null) {
                    return null;
                }
                return MapAdapter.this.f36434b.a(value);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class IteratorAdapter implements Iterator<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Iterator f36439a;

            public IteratorAdapter(Iterator it) {
                this.f36439a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return new EntryAdapter((Map.Entry) this.f36439a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f36439a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f36439a.remove();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Set f36441a;

            public SetAdapter(Set set) {
                this.f36441a = set;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new IteratorAdapter(this.f36441a.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f36441a.size();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            return new SetAdapter(this.f36433a.entrySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Object obj2 = this.f36433a.get(obj);
            if (obj2 == null) {
                return null;
            }
            return this.f36434b.a(obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Object objPut = this.f36433a.put(obj, this.f36434b.b(obj2));
            if (objPut == null) {
                return null;
            }
            return this.f36434b.a(objPut);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface ProtobufList<E> extends List<E>, RandomAccess {
        ProtobufList c(int i3);

        void j();

        boolean m();
    }

    static {
        byte[] bArr = new byte[0];
        f36426d = bArr;
        f36427e = ByteBuffer.wrap(bArr);
        f36428f = CodedInputStream.k(bArr);
    }

    static Object a(Object obj) {
        obj.getClass();
        return obj;
    }

    static Object b(Object obj, String str) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException(str);
    }

    public static int c(boolean z2) {
        return z2 ? 1231 : 1237;
    }

    public static int d(byte[] bArr) {
        return e(bArr, 0, bArr.length);
    }

    static int e(byte[] bArr, int i3, int i4) {
        int i5 = i(i4, bArr, i3, i4);
        if (i5 == 0) {
            return 1;
        }
        return i5;
    }

    public static int f(long j3) {
        return (int) (j3 ^ (j3 >>> 32));
    }

    public static boolean g(byte[] bArr) {
        return Utf8.t(bArr);
    }

    static Object h(Object obj, Object obj2) {
        return ((MessageLite) obj).a().T((MessageLite) obj2).f();
    }

    static int i(int i3, byte[] bArr, int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            i3 = (i3 * 31) + bArr[i6];
        }
        return i3;
    }

    public static byte[] j(String str) {
        return str.getBytes(f36424b);
    }

    public static String k(byte[] bArr) {
        return new String(bArr, f36424b);
    }
}
