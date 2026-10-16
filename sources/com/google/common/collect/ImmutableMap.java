package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@DoNotMock
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMap<K, V> implements Map<K, V>, Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    static final Map.Entry[] f84022d = new Map.Entry[0];
    private static final long serialVersionUID = 912559;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private transient ImmutableSet f84023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private transient ImmutableSet f84024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private transient ImmutableCollection f84025c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @DoNotMock
    public static class Builder<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Comparator f84028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object[] f84029b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f84030c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        boolean f84031d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        DuplicateKey f84032e;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class DuplicateKey {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Object f84033a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final Object f84034b;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final Object f84035c;

            DuplicateKey(Object obj, Object obj2, Object obj3) {
                this.f84033a = obj;
                this.f84034b = obj2;
                this.f84035c = obj3;
            }

            IllegalArgumentException a() {
                return new IllegalArgumentException("Multiple entries with same key: " + this.f84033a + "=" + this.f84034b + " and " + this.f84033a + "=" + this.f84035c);
            }
        }

        public Builder() {
            this(4);
        }

        private ImmutableMap b(boolean z2) {
            Object[] objArrF;
            DuplicateKey duplicateKey;
            DuplicateKey duplicateKey2;
            if (z2 && (duplicateKey2 = this.f84032e) != null) {
                throw duplicateKey2.a();
            }
            int length = this.f84030c;
            if (this.f84028a == null) {
                objArrF = this.f84029b;
            } else {
                if (this.f84031d) {
                    this.f84029b = Arrays.copyOf(this.f84029b, length * 2);
                }
                objArrF = this.f84029b;
                if (!z2) {
                    objArrF = f(objArrF, this.f84030c);
                    if (objArrF.length < this.f84029b.length) {
                        length = objArrF.length >>> 1;
                    }
                }
                k(objArrF, length, this.f84028a);
            }
            this.f84031d = true;
            RegularImmutableMap regularImmutableMapU = RegularImmutableMap.u(length, objArrF, this);
            if (!z2 || (duplicateKey = this.f84032e) == null) {
                return regularImmutableMapU;
            }
            throw duplicateKey.a();
        }

        private void e(int i3) {
            int i4 = i3 * 2;
            Object[] objArr = this.f84029b;
            if (i4 > objArr.length) {
                this.f84029b = Arrays.copyOf(objArr, ImmutableCollection.Builder.d(objArr.length, i4));
                this.f84031d = false;
            }
        }

        private Object[] f(Object[] objArr, int i3) {
            HashSet hashSet = new HashSet();
            BitSet bitSet = new BitSet();
            for (int i4 = i3 - 1; i4 >= 0; i4--) {
                Object obj = objArr[i4 * 2];
                Objects.requireNonNull(obj);
                if (!hashSet.add(obj)) {
                    bitSet.set(i4);
                }
            }
            if (bitSet.isEmpty()) {
                return objArr;
            }
            Object[] objArr2 = new Object[(i3 - bitSet.cardinality()) * 2];
            int i5 = 0;
            int i6 = 0;
            while (i5 < i3 * 2) {
                if (bitSet.get(i5 >>> 1)) {
                    i5 += 2;
                } else {
                    int i7 = i6 + 1;
                    int i8 = i5 + 1;
                    Object obj2 = objArr[i5];
                    Objects.requireNonNull(obj2);
                    objArr2[i6] = obj2;
                    i6 += 2;
                    i5 += 2;
                    Object obj3 = objArr[i8];
                    Objects.requireNonNull(obj3);
                    objArr2[i7] = obj3;
                }
            }
            return objArr2;
        }

        static void k(Object[] objArr, int i3, Comparator comparator) {
            Map.Entry[] entryArr = new Map.Entry[i3];
            for (int i4 = 0; i4 < i3; i4++) {
                int i5 = i4 * 2;
                Object obj = objArr[i5];
                Objects.requireNonNull(obj);
                Object obj2 = objArr[i5 + 1];
                Objects.requireNonNull(obj2);
                entryArr[i4] = new AbstractMap.SimpleImmutableEntry(obj, obj2);
            }
            Arrays.sort(entryArr, 0, i3, Ordering.b(comparator).j(Maps.X()));
            for (int i6 = 0; i6 < i3; i6++) {
                int i7 = i6 * 2;
                objArr[i7] = entryArr[i6].getKey();
                objArr[i7 + 1] = entryArr[i6].getValue();
            }
        }

        public ImmutableMap a() {
            return d();
        }

        public ImmutableMap c() {
            return b(false);
        }

        public ImmutableMap d() {
            return b(true);
        }

        public Builder g(Object obj, Object obj2) {
            e(this.f84030c + 1);
            CollectPreconditions.a(obj, obj2);
            Object[] objArr = this.f84029b;
            int i3 = this.f84030c;
            objArr[i3 * 2] = obj;
            objArr[(i3 * 2) + 1] = obj2;
            this.f84030c = i3 + 1;
            return this;
        }

        public Builder h(Map.Entry entry) {
            return g(entry.getKey(), entry.getValue());
        }

        public Builder i(Iterable iterable) {
            if (iterable instanceof Collection) {
                e(this.f84030c + ((Collection) iterable).size());
            }
            Iterator it = iterable.iterator();
            while (it.hasNext()) {
                h((Map.Entry) it.next());
            }
            return this;
        }

        public Builder j(Map map) {
            return i(map.entrySet());
        }

        Builder(int i3) {
            this.f84029b = new Object[i3 * 2];
            this.f84030c = 0;
            this.f84031d = false;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class IteratorBasedImmutableMap<K, V> extends ImmutableMap<K, V> {
        IteratorBasedImmutableMap() {
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set entrySet() {
            return super.entrySet();
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet f() {
            return new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap.1EntrySetImpl
                @Override // com.google.common.collect.ImmutableMapEntrySet
                ImmutableMap I() {
                    return IteratorBasedImmutableMap.this;
                }

                @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
                /* JADX INFO: renamed from: h */
                public UnmodifiableIterator iterator() {
                    return IteratorBasedImmutableMap.this.t();
                }

                @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
                Object writeReplace() {
                    return super.writeReplace();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableSet g() {
            return new ImmutableMapKeySet(this);
        }

        @Override // com.google.common.collect.ImmutableMap
        ImmutableCollection h() {
            return new ImmutableMapValues(this);
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public /* bridge */ /* synthetic */ Set keySet() {
            return super.keySet();
        }

        abstract UnmodifiableIterator t();

        @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
        public /* bridge */ /* synthetic */ Collection values() {
            return super.values();
        }

        @Override // com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private final class MapViewOfValuesAsSingletonSets extends IteratorBasedImmutableMap<K, ImmutableSet<V>> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final /* synthetic */ ImmutableMap f84037f;

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public boolean containsKey(Object obj) {
            return this.f84037f.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        ImmutableSet g() {
            return this.f84037f.keySet();
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        public int hashCode() {
            return this.f84037f.hashCode();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean j() {
            return this.f84037f.j();
        }

        @Override // com.google.common.collect.ImmutableMap
        boolean k() {
            return this.f84037f.k();
        }

        @Override // java.util.Map
        public int size() {
            return this.f84037f.size();
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap
        UnmodifiableIterator t() {
            final UnmodifiableIterator it = this.f84037f.entrySet().iterator();
            return new UnmodifiableIterator<Map.Entry<K, ImmutableSet<V>>>(this) { // from class: com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ MapViewOfValuesAsSingletonSets f84039b;

                {
                    this.f84039b = this;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry next() {
                    final Map.Entry entry = (Map.Entry) it.next();
                    return new AbstractMapEntry<K, ImmutableSet<V>>(this) { // from class: com.google.common.collect.ImmutableMap.MapViewOfValuesAsSingletonSets.1.1

                        /* JADX INFO: renamed from: b, reason: collision with root package name */
                        final /* synthetic */ AnonymousClass1 f84041b;

                        {
                            this.f84041b = this;
                        }

                        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                        public ImmutableSet getValue() {
                            return ImmutableSet.A(entry.getValue());
                        }

                        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                        public Object getKey() {
                            return entry.getKey();
                        }
                    };
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }
            };
        }

        @Override // com.google.common.collect.ImmutableMap, java.util.Map
        /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
        public ImmutableSet get(Object obj) {
            Object obj2 = this.f84037f.get(obj);
            if (obj2 == null) {
                return null;
            }
            return ImmutableSet.A(obj2);
        }

        @Override // com.google.common.collect.ImmutableMap.IteratorBasedImmutableMap, com.google.common.collect.ImmutableMap
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SerializedForm<K, V> implements Serializable {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f84042a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f84043b;

        SerializedForm(ImmutableMap immutableMap) {
            Object[] objArr = new Object[immutableMap.size()];
            Object[] objArr2 = new Object[immutableMap.size()];
            UnmodifiableIterator it = immutableMap.entrySet().iterator();
            int i3 = 0;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                objArr[i3] = entry.getKey();
                objArr2[i3] = entry.getValue();
                i3++;
            }
            this.f84042a = objArr;
            this.f84043b = objArr2;
        }

        final Object a() {
            Object[] objArr = (Object[]) this.f84042a;
            Object[] objArr2 = (Object[]) this.f84043b;
            Builder builderB = b(objArr.length);
            for (int i3 = 0; i3 < objArr.length; i3++) {
                builderB.g(objArr[i3], objArr2[i3]);
            }
            return builderB.d();
        }

        Builder b(int i3) {
            return new Builder(i3);
        }

        final Object readResolve() {
            Object obj = this.f84042a;
            if (!(obj instanceof ImmutableSet)) {
                return a();
            }
            ImmutableSet immutableSet = (ImmutableSet) obj;
            ImmutableCollection immutableCollection = (ImmutableCollection) this.f84043b;
            Builder builderB = b(immutableSet.size());
            UnmodifiableIterator it = immutableSet.iterator();
            UnmodifiableIterator it2 = immutableCollection.iterator();
            while (it.hasNext()) {
                builderB.g(it.next(), it2.next());
            }
            return builderB.d();
        }
    }

    ImmutableMap() {
    }

    public static Builder a() {
        return new Builder();
    }

    static void b(boolean z2, String str, Object obj, Object obj2) {
        if (!z2) {
            throw c(str, obj, obj2);
        }
    }

    static IllegalArgumentException c(String str, Object obj, Object obj2) {
        return new IllegalArgumentException("Multiple entries with same " + str + ": " + obj + " and " + obj2);
    }

    public static ImmutableMap d(Iterable iterable) {
        Builder builder = new Builder(iterable instanceof Collection ? ((Collection) iterable).size() : 4);
        builder.i(iterable);
        return builder.a();
    }

    public static ImmutableMap e(Map map) {
        if ((map instanceof ImmutableMap) && !(map instanceof SortedMap)) {
            ImmutableMap immutableMap = (ImmutableMap) map;
            if (!immutableMap.k()) {
                return immutableMap;
            }
        }
        return d(map.entrySet());
    }

    public static ImmutableMap n() {
        return RegularImmutableMap.f84581i;
    }

    public static ImmutableMap o(Object obj, Object obj2) {
        CollectPreconditions.a(obj, obj2);
        return RegularImmutableMap.t(1, new Object[]{obj, obj2});
    }

    public static ImmutableMap p(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8) {
        CollectPreconditions.a(obj, obj2);
        CollectPreconditions.a(obj3, obj4);
        CollectPreconditions.a(obj5, obj6);
        CollectPreconditions.a(obj7, obj8);
        return RegularImmutableMap.t(4, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8});
    }

    public static ImmutableMap q(Object obj, Object obj2, Object obj3, Object obj4, Object obj5, Object obj6, Object obj7, Object obj8, Object obj9, Object obj10) {
        CollectPreconditions.a(obj, obj2);
        CollectPreconditions.a(obj3, obj4);
        CollectPreconditions.a(obj5, obj6);
        CollectPreconditions.a(obj7, obj8);
        CollectPreconditions.a(obj9, obj10);
        return RegularImmutableMap.t(5, new Object[]{obj, obj2, obj3, obj4, obj5, obj6, obj7, obj8, obj9, obj10});
    }

    public static ImmutableMap r(Map.Entry... entryArr) {
        return d(Arrays.asList(entryArr));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    @Override // java.util.Map
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        return Maps.p(this, obj);
    }

    abstract ImmutableSet f();

    abstract ImmutableSet g();

    @Override // java.util.Map
    public abstract Object get(Object obj);

    @Override // java.util.Map
    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    abstract ImmutableCollection h();

    @Override // java.util.Map
    public int hashCode() {
        return Sets.f(entrySet());
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public ImmutableSet entrySet() {
        ImmutableSet immutableSet = this.f84023a;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet immutableSetF = f();
        this.f84023a = immutableSetF;
        return immutableSetF;
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    boolean j() {
        return false;
    }

    abstract boolean k();

    UnmodifiableIterator l() {
        final UnmodifiableIterator it = entrySet().iterator();
        return new UnmodifiableIterator<K>(this) { // from class: com.google.common.collect.ImmutableMap.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ ImmutableMap f84027b;

            {
                this.f84027b = this;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return it.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                return ((Map.Entry) it.next()).getKey();
            }
        };
    }

    @Override // java.util.Map
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public ImmutableSet keySet() {
        ImmutableSet immutableSet = this.f84024b;
        if (immutableSet != null) {
            return immutableSet;
        }
        ImmutableSet immutableSetG = g();
        this.f84024b = immutableSetG;
        return immutableSetG;
    }

    @Override // java.util.Map
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final void putAll(Map map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map, com.google.common.collect.BiMap
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection values() {
        ImmutableCollection immutableCollection = this.f84025c;
        if (immutableCollection != null) {
            return immutableCollection;
        }
        ImmutableCollection immutableCollectionH = h();
        this.f84025c = immutableCollectionH;
        return immutableCollectionH;
    }

    public String toString() {
        return Maps.L(this);
    }

    Object writeReplace() {
        return new SerializedForm(this);
    }
}
