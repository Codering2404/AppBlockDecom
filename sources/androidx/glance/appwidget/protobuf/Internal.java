package androidx.glance.appwidget.protobuf;

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
    static final Charset f39079a = Charset.forName("US-ASCII");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Charset f39080b = Charset.forName(Utf8Charset.NAME);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Charset f39081c = Charset.forName("ISO-8859-1");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final byte[] f39082d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final ByteBuffer f39083e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final CodedInputStream f39084f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface BooleanList extends ProtobufList<Boolean> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface DoubleList extends ProtobufList<Double> {
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
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface IntList extends ProtobufList<Integer> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class ListAdapter<F, T> extends AbstractList<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f39085a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Converter f39086b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        public interface Converter<F, T> {
            Object a(Object obj);
        }

        @Override // java.util.AbstractList, java.util.List
        public Object get(int i3) {
            return this.f39086b.a(this.f39085a.get(i3));
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
        public int size() {
            return this.f39085a.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface LongList extends ProtobufList<Long> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class MapAdapter<K, V, RealValue> extends AbstractMap<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Map f39087a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Converter f39088b;

        /* JADX INFO: renamed from: androidx.glance.appwidget.protobuf.Internal$MapAdapter$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        final class AnonymousClass1 implements Converter<Integer, EnumLite> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ EnumLiteMap f39089a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ EnumLite f39090b;

            @Override // androidx.glance.appwidget.protobuf.Internal.MapAdapter.Converter
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public Integer b(EnumLite enumLite) {
                return Integer.valueOf(enumLite.J());
            }

            @Override // androidx.glance.appwidget.protobuf.Internal.MapAdapter.Converter
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public EnumLite a(Integer num) {
                EnumLite enumLiteA = this.f39089a.a(num.intValue());
                return enumLiteA == null ? this.f39090b : enumLiteA;
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
            private final Map.Entry f39091a;

            public EntryAdapter(Map.Entry entry) {
                this.f39091a = entry;
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
                return this.f39091a.getKey();
            }

            @Override // java.util.Map.Entry
            public Object getValue() {
                return MapAdapter.this.f39088b.a(this.f39091a.getValue());
            }

            @Override // java.util.Map.Entry
            public int hashCode() {
                return this.f39091a.hashCode();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Map.Entry
            public Object setValue(Object obj) {
                Object value = this.f39091a.setValue(MapAdapter.this.f39088b.b(obj));
                if (value == null) {
                    return null;
                }
                return MapAdapter.this.f39088b.a(value);
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class IteratorAdapter implements Iterator<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Iterator f39093a;

            public IteratorAdapter(Iterator it) {
                this.f39093a = it;
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                return new EntryAdapter((Map.Entry) this.f39093a.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f39093a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f39093a.remove();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class SetAdapter extends AbstractSet<Map.Entry<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Set f39095a;

            public SetAdapter(Set set) {
                this.f39095a = set;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new IteratorAdapter(this.f39095a.iterator());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return this.f39095a.size();
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set entrySet() {
            return new SetAdapter(this.f39087a.entrySet());
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Object obj2 = this.f39087a.get(obj);
            if (obj2 == null) {
                return null;
            }
            return this.f39088b.a(obj2);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Object objPut = this.f39087a.put(obj, this.f39088b.b(obj2));
            if (objPut == null) {
                return null;
            }
            return this.f39088b.a(objPut);
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
        f39082d = bArr;
        f39083e = ByteBuffer.wrap(bArr);
        f39084f = CodedInputStream.j(bArr);
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
        return ((MessageLite) obj).a().S1((MessageLite) obj2).f();
    }

    static int i(int i3, byte[] bArr, int i4, int i5) {
        for (int i6 = i4; i6 < i4 + i5; i6++) {
            i3 = (i3 * 31) + bArr[i6];
        }
        return i3;
    }

    public static byte[] j(String str) {
        return str.getBytes(f39080b);
    }

    public static String k(byte[] bArr) {
        return new String(bArr, f39080b);
    }
}
