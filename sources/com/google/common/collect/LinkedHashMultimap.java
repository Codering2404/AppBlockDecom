package com.google.common.collect;

import com.google.common.base.Preconditions;
import com.google.common.collect.Sets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class LinkedHashMultimap<K, V> extends LinkedHashMultimapGwtSerializationDependencies<K, V> {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    transient int f84211i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private transient ValueEntry f84212j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class ValueEntry<K, V> extends ImmutableEntry<K, V> implements ValueSetLink<K, V> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final int f84216c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        ValueEntry f84217d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ValueSetLink f84218f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ValueSetLink f84219g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private ValueEntry f84220h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private ValueEntry f84221i;

        ValueEntry(Object obj, Object obj2, int i3, ValueEntry valueEntry) {
            super(obj, obj2);
            this.f84216c = i3;
            this.f84217d = valueEntry;
        }

        static ValueEntry h() {
            return new ValueEntry(null, null, 0, null);
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink a() {
            ValueSetLink valueSetLink = this.f84218f;
            Objects.requireNonNull(valueSetLink);
            return valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink b() {
            ValueSetLink valueSetLink = this.f84219g;
            Objects.requireNonNull(valueSetLink);
            return valueSetLink;
        }

        public ValueEntry c() {
            ValueEntry valueEntry = this.f84220h;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void d(ValueSetLink valueSetLink) {
            this.f84219g = valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void e(ValueSetLink valueSetLink) {
            this.f84218f = valueSetLink;
        }

        public ValueEntry f() {
            ValueEntry valueEntry = this.f84221i;
            Objects.requireNonNull(valueEntry);
            return valueEntry;
        }

        boolean g(Object obj, int i3) {
            return this.f84216c == i3 && com.google.common.base.Objects.a(getValue(), obj);
        }

        public void i(ValueEntry valueEntry) {
            this.f84220h = valueEntry;
        }

        public void j(ValueEntry valueEntry) {
            this.f84221i = valueEntry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ValueSet extends Sets.ImprovedAbstractSet<V> implements ValueSetLink<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f84222a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        ValueEntry[] f84223b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f84224c = 0;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private int f84225d = 0;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private ValueSetLink f84226f = this;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private ValueSetLink f84227g = this;

        ValueSet(Object obj, int i3) {
            this.f84222a = obj;
            this.f84223b = new ValueEntry[Hashing.a(i3, 1.0d)];
        }

        private int h() {
            return this.f84223b.length - 1;
        }

        private void l() {
            if (Hashing.b(this.f84224c, this.f84223b.length, 1.0d)) {
                int length = this.f84223b.length * 2;
                ValueEntry[] valueEntryArr = new ValueEntry[length];
                this.f84223b = valueEntryArr;
                int i3 = length - 1;
                for (ValueSetLink valueSetLinkB = this.f84226f; valueSetLinkB != this; valueSetLinkB = valueSetLinkB.b()) {
                    ValueEntry valueEntry = (ValueEntry) valueSetLinkB;
                    int i4 = valueEntry.f84216c & i3;
                    valueEntry.f84217d = valueEntryArr[i4];
                    valueEntryArr[i4] = valueEntry;
                }
            }
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink a() {
            return this.f84227g;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            int iD = Hashing.d(obj);
            int iH = h() & iD;
            ValueEntry valueEntry = this.f84223b[iH];
            for (ValueEntry valueEntry2 = valueEntry; valueEntry2 != null; valueEntry2 = valueEntry2.f84217d) {
                if (valueEntry2.g(obj, iD)) {
                    return false;
                }
            }
            ValueEntry valueEntry3 = new ValueEntry(this.f84222a, obj, iD, valueEntry);
            LinkedHashMultimap.N(this.f84227g, valueEntry3);
            LinkedHashMultimap.N(valueEntry3, this);
            LinkedHashMultimap.M(LinkedHashMultimap.this.f84212j.c(), valueEntry3);
            LinkedHashMultimap.M(valueEntry3, LinkedHashMultimap.this.f84212j);
            this.f84223b[iH] = valueEntry3;
            this.f84224c++;
            this.f84225d++;
            l();
            return true;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public ValueSetLink b() {
            return this.f84226f;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            Arrays.fill(this.f84223b, (Object) null);
            this.f84224c = 0;
            for (ValueSetLink valueSetLinkB = this.f84226f; valueSetLinkB != this; valueSetLinkB = valueSetLinkB.b()) {
                LinkedHashMultimap.K((ValueEntry) valueSetLinkB);
            }
            LinkedHashMultimap.N(this, this);
            this.f84225d++;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            int iD = Hashing.d(obj);
            for (ValueEntry valueEntry = this.f84223b[h() & iD]; valueEntry != null; valueEntry = valueEntry.f84217d) {
                if (valueEntry.g(obj, iD)) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void d(ValueSetLink valueSetLink) {
            this.f84226f = valueSetLink;
        }

        @Override // com.google.common.collect.LinkedHashMultimap.ValueSetLink
        public void e(ValueSetLink valueSetLink) {
            this.f84227g = valueSetLink;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new Iterator<V>() { // from class: com.google.common.collect.LinkedHashMultimap.ValueSet.1

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                ValueSetLink f84229a;

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                ValueEntry f84230b;

                /* JADX INFO: renamed from: c, reason: collision with root package name */
                int f84231c;

                {
                    this.f84229a = ValueSet.this.f84226f;
                    this.f84231c = ValueSet.this.f84225d;
                }

                private void a() {
                    if (ValueSet.this.f84225d != this.f84231c) {
                        throw new ConcurrentModificationException();
                    }
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    a();
                    return this.f84229a != ValueSet.this;
                }

                @Override // java.util.Iterator
                public Object next() {
                    if (!hasNext()) {
                        throw new NoSuchElementException();
                    }
                    ValueEntry valueEntry = (ValueEntry) this.f84229a;
                    Object value = valueEntry.getValue();
                    this.f84230b = valueEntry;
                    this.f84229a = valueEntry.b();
                    return value;
                }

                @Override // java.util.Iterator
                public void remove() {
                    a();
                    Preconditions.A(this.f84230b != null, "no calls to next() since the last call to remove()");
                    ValueSet.this.remove(this.f84230b.getValue());
                    this.f84231c = ValueSet.this.f84225d;
                    this.f84230b = null;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            int iD = Hashing.d(obj);
            int iH = h() & iD;
            ValueEntry valueEntry = null;
            for (ValueEntry valueEntry2 = this.f84223b[iH]; valueEntry2 != null; valueEntry2 = valueEntry2.f84217d) {
                if (valueEntry2.g(obj, iD)) {
                    if (valueEntry == null) {
                        this.f84223b[iH] = valueEntry2.f84217d;
                    } else {
                        valueEntry.f84217d = valueEntry2.f84217d;
                    }
                    LinkedHashMultimap.L(valueEntry2);
                    LinkedHashMultimap.K(valueEntry2);
                    this.f84224c--;
                    this.f84225d++;
                    return true;
                }
                valueEntry = valueEntry2;
            }
            return false;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return this.f84224c;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private interface ValueSetLink<K, V> {
        ValueSetLink a();

        ValueSetLink b();

        void d(ValueSetLink valueSetLink);

        void e(ValueSetLink valueSetLink);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void K(ValueEntry valueEntry) {
        M(valueEntry.c(), valueEntry.f());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void L(ValueSetLink valueSetLink) {
        N(valueSetLink.a(), valueSetLink.b());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void M(ValueEntry valueEntry, ValueEntry valueEntry2) {
        valueEntry.j(valueEntry2);
        valueEntry2.i(valueEntry);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void N(ValueSetLink valueSetLink, ValueSetLink valueSetLink2) {
        valueSetLink.d(valueSetLink2);
        valueSetLink2.e(valueSetLink);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        ValueEntry valueEntryH = ValueEntry.h();
        this.f84212j = valueEntryH;
        M(valueEntryH, valueEntryH);
        this.f84211i = 2;
        int i3 = objectInputStream.readInt();
        Map mapE = Platform.e(12);
        for (int i4 = 0; i4 < i3; i4++) {
            Object object = objectInputStream.readObject();
            mapE.put(object, t(object));
        }
        int i5 = objectInputStream.readInt();
        for (int i6 = 0; i6 < i5; i6++) {
            Object object2 = objectInputStream.readObject();
            Object object3 = objectInputStream.readObject();
            Collection collection = (Collection) mapE.get(object2);
            Objects.requireNonNull(collection);
            collection.add(object3);
        }
        z(mapE);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(keySet().size());
        Iterator it = keySet().iterator();
        while (it.hasNext()) {
            objectOutputStream.writeObject(it.next());
        }
        objectOutputStream.writeInt(size());
        for (Map.Entry entry : b()) {
            objectOutputStream.writeObject(entry.getKey());
            objectOutputStream.writeObject(entry.getValue());
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap
    /* JADX INFO: renamed from: D */
    public Set s() {
        return Platform.f(this.f84211i);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Set a(Object obj) {
        return super.a(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Map a1() {
        return super.a1();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public void clear() {
        super.clear();
        ValueEntry valueEntry = this.f84212j;
        M(valueEntry, valueEntry);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsKey(Object obj) {
        return super.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean containsValue(Object obj) {
        return super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    public /* bridge */ /* synthetic */ Set get(Object obj) {
        return super.get(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    Iterator i() {
        return new Iterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.LinkedHashMultimap.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            ValueEntry f84213a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            ValueEntry f84214b;

            {
                this.f84213a = LinkedHashMultimap.this.f84212j.f();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                ValueEntry valueEntry = this.f84213a;
                this.f84214b = valueEntry;
                this.f84213a = valueEntry.f();
                return valueEntry;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f84213a != LinkedHashMultimap.this.f84212j;
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.A(this.f84214b != null, "no calls to next() since the last call to remove()");
                LinkedHashMultimap.this.remove(this.f84214b.getKey(), this.f84214b.getValue());
                this.f84214b = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap
    Iterator j() {
        return Maps.Y(i());
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set keySet() {
        return super.keySet();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ Multiset keys() {
        return super.keys();
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean put(Object obj, Object obj2) {
        return super.put(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean remove(Object obj, Object obj2) {
        return super.remove(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int size() {
        return super.size();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap
    Collection t(Object obj) {
        return new ValueSet(obj, this.f84211i);
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Collection values() {
        return super.values();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean w1(Object obj, Object obj2) {
        return super.w1(obj, obj2);
    }

    @Override // com.google.common.collect.AbstractSetMultimap, com.google.common.collect.AbstractMapBasedMultimap, com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public Set b() {
        return super.b();
    }
}
