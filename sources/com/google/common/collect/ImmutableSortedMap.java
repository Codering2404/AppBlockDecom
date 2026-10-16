package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.ImmutableMap;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.util.AbstractMap;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Objects;
import java.util.SortedMap;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class ImmutableSortedMap<K, V> extends ImmutableMap<K, V> implements NavigableMap<K, V> {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Comparator f84126i = Ordering.f();

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final ImmutableSortedMap f84127j = new ImmutableSortedMap(ImmutableSortedSet.M(Ordering.f()), ImmutableList.y());
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient RegularImmutableSortedSet f84128f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient ImmutableList f84129g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient ImmutableSortedMap f84130h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class Builder<K, V> extends ImmutableMap.Builder<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private transient Object[] f84133f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private transient Object[] f84134g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final Comparator f84135h;

        public Builder(Comparator comparator) {
            this(comparator, 4);
        }

        private void e(int i3) {
            Object[] objArr = this.f84133f;
            if (i3 > objArr.length) {
                int iD = ImmutableCollection.Builder.d(objArr.length, i3);
                this.f84133f = Arrays.copyOf(this.f84133f, iD);
                this.f84134g = Arrays.copyOf(this.f84134g, iD);
            }
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMap a() {
            return d();
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
        public final ImmutableSortedMap c() {
            throw new UnsupportedOperationException("ImmutableSortedMap.Builder does not yet implement buildKeepingLast()");
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
        public ImmutableSortedMap d() {
            int i3 = this.f84030c;
            if (i3 == 0) {
                return ImmutableSortedMap.C(this.f84135h);
            }
            if (i3 == 1) {
                Comparator comparator = this.f84135h;
                Object obj = this.f84133f[0];
                Objects.requireNonNull(obj);
                Object obj2 = this.f84134g[0];
                Objects.requireNonNull(obj2);
                return ImmutableSortedMap.L(comparator, obj, obj2);
            }
            Object[] objArrCopyOf = Arrays.copyOf(this.f84133f, i3);
            Arrays.sort(objArrCopyOf, this.f84135h);
            Object[] objArr = new Object[this.f84030c];
            for (int i4 = 0; i4 < this.f84030c; i4++) {
                if (i4 > 0) {
                    int i5 = i4 - 1;
                    if (this.f84135h.compare(objArrCopyOf[i5], objArrCopyOf[i4]) == 0) {
                        throw new IllegalArgumentException("keys required to be distinct but compared as equal: " + objArrCopyOf[i5] + " and " + objArrCopyOf[i4]);
                    }
                }
                Object obj3 = this.f84133f[i4];
                Objects.requireNonNull(obj3);
                int iBinarySearch = Arrays.binarySearch(objArrCopyOf, obj3, this.f84135h);
                Object obj4 = this.f84134g[i4];
                Objects.requireNonNull(obj4);
                objArr[iBinarySearch] = obj4;
            }
            return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.l(objArrCopyOf), this.f84135h), ImmutableList.l(objArr));
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
        public Builder g(Object obj, Object obj2) {
            e(this.f84030c + 1);
            CollectPreconditions.a(obj, obj2);
            Object[] objArr = this.f84133f;
            int i3 = this.f84030c;
            objArr[i3] = obj;
            this.f84134g[i3] = obj2;
            this.f84030c = i3 + 1;
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
        public Builder h(Map.Entry entry) {
            super.h(entry);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
        public Builder i(Iterable iterable) {
            super.i(iterable);
            return this;
        }

        @Override // com.google.common.collect.ImmutableMap.Builder
        /* JADX INFO: renamed from: r, reason: merged with bridge method [inline-methods] */
        public Builder j(Map map) {
            super.j(map);
            return this;
        }

        private Builder(Comparator comparator, int i3) {
            this.f84135h = (Comparator) Preconditions.t(comparator);
            this.f84133f = new Object[i3];
            this.f84134g = new Object[i3];
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class SerializedForm<K, V> extends ImmutableMap.SerializedForm<K, V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final Comparator f84136c;

        SerializedForm(ImmutableSortedMap immutableSortedMap) {
            super(immutableSortedMap);
            this.f84136c = immutableSortedMap.comparator();
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.ImmutableMap.SerializedForm
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Builder b(int i3) {
            return new Builder(this.f84136c);
        }
    }

    ImmutableSortedMap(RegularImmutableSortedSet regularImmutableSortedSet, ImmutableList immutableList) {
        this(regularImmutableSortedSet, immutableList, null);
    }

    static ImmutableSortedMap C(Comparator comparator) {
        return Ordering.f().equals(comparator) ? K() : new ImmutableSortedMap(ImmutableSortedSet.M(comparator), ImmutableList.y());
    }

    private static ImmutableSortedMap D(Comparator comparator, boolean z2, Iterable iterable) {
        Map.Entry[] entryArr = (Map.Entry[]) Iterables.w(iterable, ImmutableMap.f84022d);
        return E(comparator, z2, entryArr, entryArr.length);
    }

    private static ImmutableSortedMap E(final Comparator comparator, boolean z2, Map.Entry[] entryArr, int i3) {
        if (i3 == 0) {
            return C(comparator);
        }
        if (i3 == 1) {
            Map.Entry entry = entryArr[0];
            Objects.requireNonNull(entry);
            Map.Entry entry2 = entry;
            return L(comparator, entry2.getKey(), entry2.getValue());
        }
        Object[] objArr = new Object[i3];
        Object[] objArr2 = new Object[i3];
        if (z2) {
            for (int i4 = 0; i4 < i3; i4++) {
                Map.Entry entry3 = entryArr[i4];
                Objects.requireNonNull(entry3);
                Map.Entry entry4 = entry3;
                Object key = entry4.getKey();
                Object value = entry4.getValue();
                CollectPreconditions.a(key, value);
                objArr[i4] = key;
                objArr2[i4] = value;
            }
        } else {
            Arrays.sort(entryArr, 0, i3, new Comparator() { // from class: com.google.common.collect.u
                @Override // java.util.Comparator
                public final int compare(Object obj, Object obj2) {
                    return ImmutableSortedMap.t(comparator, (Map.Entry) obj, (Map.Entry) obj2);
                }
            });
            Map.Entry entry5 = entryArr[0];
            Objects.requireNonNull(entry5);
            Map.Entry entry6 = entry5;
            Object key2 = entry6.getKey();
            objArr[0] = key2;
            Object value2 = entry6.getValue();
            objArr2[0] = value2;
            CollectPreconditions.a(objArr[0], value2);
            int i5 = 1;
            while (i5 < i3) {
                Map.Entry entry7 = entryArr[i5 - 1];
                Objects.requireNonNull(entry7);
                Map.Entry entry8 = entry7;
                Map.Entry entry9 = entryArr[i5];
                Objects.requireNonNull(entry9);
                Map.Entry entry10 = entry9;
                Object key3 = entry10.getKey();
                Object value3 = entry10.getValue();
                CollectPreconditions.a(key3, value3);
                objArr[i5] = key3;
                objArr2[i5] = value3;
                ImmutableMap.b(comparator.compare(key2, key3) != 0, "key", entry8, entry10);
                i5++;
                key2 = key3;
            }
        }
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.l(objArr), comparator), ImmutableList.l(objArr2));
    }

    private ImmutableSortedMap F(int i3, int i4) {
        return (i3 == 0 && i4 == size()) ? this : i3 == i4 ? C(comparator()) : new ImmutableSortedMap(this.f84128f.a0(i3, i4), this.f84129g.subList(i3, i4));
    }

    public static ImmutableSortedMap K() {
        return f84127j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static ImmutableSortedMap L(Comparator comparator, Object obj, Object obj2) {
        return new ImmutableSortedMap(new RegularImmutableSortedSet(ImmutableList.z(obj), (Comparator) Preconditions.t(comparator)), ImmutableList.z(obj2));
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public static /* synthetic */ int t(Comparator comparator, Map.Entry entry, Map.Entry entry2) {
        Objects.requireNonNull(entry);
        Objects.requireNonNull(entry2);
        return comparator.compare(entry.getKey(), entry2.getKey());
    }

    public static ImmutableSortedMap x(Map map) {
        return y(map, (Ordering) f84126i);
    }

    private static ImmutableSortedMap y(Map map, Comparator comparator) {
        boolean zEquals = false;
        if (map instanceof SortedMap) {
            Comparator<? super K> comparator2 = ((SortedMap) map).comparator();
            if (comparator2 != null) {
                zEquals = comparator.equals(comparator2);
            } else if (comparator == f84126i) {
                zEquals = true;
            }
        }
        if (zEquals && (map instanceof ImmutableSortedMap)) {
            ImmutableSortedMap immutableSortedMap = (ImmutableSortedMap) map;
            if (!immutableSortedMap.k()) {
                return immutableSortedMap;
            }
        }
        return D(comparator, zEquals, map.entrySet());
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: A, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet descendingKeySet() {
        return this.f84128f.descendingSet();
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: B, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap descendingMap() {
        ImmutableSortedMap immutableSortedMap = this.f84130h;
        return immutableSortedMap == null ? isEmpty() ? C(Ordering.b(comparator()).k()) : new ImmutableSortedMap((RegularImmutableSortedSet) this.f84128f.descendingSet(), this.f84129g.J(), this) : immutableSortedMap;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap headMap(Object obj, boolean z2) {
        return F(0, this.f84128f.b0(Preconditions.t(obj), z2));
    }

    @Override // com.google.common.collect.ImmutableMap
    /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet keySet() {
        return this.f84128f;
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: J, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedSet navigableKeySet() {
        return this.f84128f;
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* JADX INFO: renamed from: M, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: N, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
        Preconditions.t(obj);
        Preconditions.t(obj2);
        Preconditions.o(comparator().compare(obj, obj2) <= 0, "expected fromKey <= toKey but %s > %s", obj, obj2);
        return headMap(obj2, z3).tailMap(obj, z2);
    }

    @Override // java.util.NavigableMap, java.util.SortedMap
    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }

    @Override // java.util.NavigableMap
    /* JADX INFO: renamed from: Q, reason: merged with bridge method [inline-methods] */
    public ImmutableSortedMap tailMap(Object obj, boolean z2) {
        return F(this.f84128f.c0(Preconditions.t(obj), z2), size());
    }

    @Override // java.util.NavigableMap
    public Map.Entry ceilingEntry(Object obj) {
        return tailMap(obj, true).firstEntry();
    }

    @Override // java.util.NavigableMap
    public Object ceilingKey(Object obj) {
        return Maps.y(ceilingEntry(obj));
    }

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return keySet().comparator();
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet f() {
        return isEmpty() ? ImmutableSet.z() : new ImmutableMapEntrySet<K, V>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet
            @Override // com.google.common.collect.ImmutableMapEntrySet
            ImmutableMap I() {
                return ImmutableSortedMap.this;
            }

            @Override // com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
            /* JADX INFO: renamed from: h */
            public UnmodifiableIterator iterator() {
                return a().iterator();
            }

            @Override // com.google.common.collect.ImmutableMapEntrySet, com.google.common.collect.ImmutableSet, com.google.common.collect.ImmutableCollection
            Object writeReplace() {
                return super.writeReplace();
            }

            @Override // com.google.common.collect.ImmutableSet
            ImmutableList x() {
                return new ImmutableList<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableSortedMap.1EntrySet.1
                    @Override // java.util.List
                    /* JADX INFO: renamed from: P, reason: merged with bridge method [inline-methods] */
                    public Map.Entry get(int i3) {
                        return new AbstractMap.SimpleImmutableEntry(ImmutableSortedMap.this.f84128f.a().get(i3), ImmutableSortedMap.this.f84129g.get(i3));
                    }

                    @Override // com.google.common.collect.ImmutableCollection
                    boolean g() {
                        return true;
                    }

                    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
                    public int size() {
                        return ImmutableSortedMap.this.size();
                    }

                    @Override // com.google.common.collect.ImmutableList, com.google.common.collect.ImmutableCollection
                    Object writeReplace() {
                        return super.writeReplace();
                    }
                };
            }
        };
    }

    @Override // java.util.NavigableMap
    public Map.Entry firstEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().a().get(0);
    }

    @Override // java.util.SortedMap
    public Object firstKey() {
        return keySet().first();
    }

    @Override // java.util.NavigableMap
    public Map.Entry floorEntry(Object obj) {
        return headMap(obj, true).lastEntry();
    }

    @Override // java.util.NavigableMap
    public Object floorKey(Object obj) {
        return Maps.y(floorEntry(obj));
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableSet g() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    public Object get(Object obj) {
        int iIndexOf = this.f84128f.indexOf(obj);
        if (iIndexOf == -1) {
            return null;
        }
        return this.f84129g.get(iIndexOf);
    }

    @Override // com.google.common.collect.ImmutableMap
    ImmutableCollection h() {
        throw new AssertionError("should never be called");
    }

    @Override // java.util.NavigableMap
    public Map.Entry higherEntry(Object obj) {
        return tailMap(obj, false).firstEntry();
    }

    @Override // java.util.NavigableMap
    public Object higherKey(Object obj) {
        return Maps.y(higherEntry(obj));
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map
    /* JADX INFO: renamed from: i */
    public ImmutableSet entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.ImmutableMap
    boolean k() {
        return this.f84128f.g() || this.f84129g.g();
    }

    @Override // java.util.NavigableMap
    public Map.Entry lastEntry() {
        if (isEmpty()) {
            return null;
        }
        return (Map.Entry) entrySet().a().get(size() - 1);
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        return keySet().last();
    }

    @Override // java.util.NavigableMap
    public Map.Entry lowerEntry(Object obj) {
        return headMap(obj, false).lastEntry();
    }

    @Override // java.util.NavigableMap
    public Object lowerKey(Object obj) {
        return Maps.y(lowerEntry(obj));
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollFirstEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.NavigableMap
    public final Map.Entry pollLastEntry() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.ImmutableMap, java.util.Map, com.google.common.collect.BiMap
    /* JADX INFO: renamed from: s */
    public ImmutableCollection values() {
        return this.f84129g;
    }

    @Override // java.util.Map
    public int size() {
        return this.f84129g.size();
    }

    @Override // com.google.common.collect.ImmutableMap
    Object writeReplace() {
        return new SerializedForm(this);
    }

    ImmutableSortedMap(RegularImmutableSortedSet regularImmutableSortedSet, ImmutableList immutableList, ImmutableSortedMap immutableSortedMap) {
        this.f84128f = regularImmutableSortedSet;
        this.f84129g = immutableList;
        this.f84130h = immutableSortedMap;
    }
}
