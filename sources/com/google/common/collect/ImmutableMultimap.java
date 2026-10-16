package com.google.common.collect;

import com.google.common.collect.ImmutableCollection;
import com.google.common.collect.Multiset;
import com.google.common.collect.Serialization;
import com.google.errorprone.annotations.DoNotMock;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public abstract class ImmutableMultimap<K, V> extends BaseImmutableMultimap<K, V> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient ImmutableMap f84055g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final transient int f84056h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @DoNotMock
    public static class Builder<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Map f84064a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Comparator f84065b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Comparator f84066c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f84067d = 4;

        public ImmutableMultimap a() {
            Map map = this.f84064a;
            if (map == null) {
                return ImmutableListMultimap.A();
            }
            Collection collectionEntrySet = map.entrySet();
            Comparator comparator = this.f84065b;
            if (comparator != null) {
                collectionEntrySet = Ordering.b(comparator).i().c(collectionEntrySet);
            }
            return ImmutableListMultimap.y(collectionEntrySet, this.f84066c);
        }

        Map b() {
            Map map = this.f84064a;
            if (map != null) {
                return map;
            }
            Map mapG = Platform.g();
            this.f84064a = mapG;
            return mapG;
        }

        ImmutableCollection.Builder c(int i3) {
            return ImmutableList.p(i3);
        }

        public Builder d(Object obj, Object obj2) {
            CollectPreconditions.a(obj, obj2);
            ImmutableCollection.Builder builderC = (ImmutableCollection.Builder) b().get(obj);
            if (builderC == null) {
                builderC = c(this.f84067d);
                b().put(obj, builderC);
            }
            builderC.e(obj2);
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class EntryCollection<K, V> extends ImmutableCollection<Map.Entry<K, V>> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ImmutableMultimap f84068b;

        EntryCollection(ImmutableMultimap immutableMultimap) {
            this.f84068b = immutableMultimap;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return this.f84068b.w1(entry.getKey(), entry.getValue());
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return this.f84068b.r();
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* JADX INFO: renamed from: h */
        public UnmodifiableIterator iterator() {
            return this.f84068b.i();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f84068b.size();
        }

        @Override // com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class FieldSettersHolder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final Serialization.FieldSetter f84069a = Serialization.a(ImmutableMultimap.class, "map");

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        static final Serialization.FieldSetter f84070b = Serialization.a(ImmutableMultimap.class, "size");
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Keys extends ImmutableMultiset<K> {
        Keys() {
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use KeysSerializedForm");
        }

        @Override // com.google.common.collect.Multiset
        public int Y1(Object obj) {
            Collection collection = (Collection) ImmutableMultimap.this.f84055g.get(obj);
            if (collection == null) {
                return 0;
            }
            return collection.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return ImmutableMultimap.this.containsKey(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.Multiset
        /* JADX INFO: renamed from: o */
        public ImmutableSet i() {
            return ImmutableMultimap.this.keySet();
        }

        @Override // com.google.common.collect.ImmutableMultiset
        Multiset.Entry q(int i3) {
            Map.Entry entry = (Map.Entry) ImmutableMultimap.this.f84055g.entrySet().a().get(i3);
            return Multisets.h(entry.getKey(), ((Collection) entry.getValue()).size());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
        public int size() {
            return ImmutableMultimap.this.size();
        }

        @Override // com.google.common.collect.ImmutableMultiset, com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return new KeysSerializedForm(ImmutableMultimap.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class KeysSerializedForm implements Serializable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ImmutableMultimap f84072a;

        KeysSerializedForm(ImmutableMultimap immutableMultimap) {
            this.f84072a = immutableMultimap;
        }

        Object readResolve() {
            return this.f84072a.keys();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Values<K, V> extends ImmutableCollection<V> {
        private static final long serialVersionUID = 0;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final transient ImmutableMultimap f84073b;

        Values(ImmutableMultimap immutableMultimap) {
            this.f84073b = immutableMultimap;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.ImmutableCollection
        int b(Object[] objArr, int i3) {
            UnmodifiableIterator it = this.f84073b.f84055g.values().iterator();
            while (it.hasNext()) {
                i3 = ((ImmutableCollection) it.next()).b(objArr, i3);
            }
            return i3;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return this.f84073b.containsValue(obj);
        }

        @Override // com.google.common.collect.ImmutableCollection
        boolean g() {
            return true;
        }

        @Override // com.google.common.collect.ImmutableCollection, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set, java.util.NavigableSet
        /* JADX INFO: renamed from: h */
        public UnmodifiableIterator iterator() {
            return this.f84073b.j();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return this.f84073b.size();
        }

        @Override // com.google.common.collect.ImmutableCollection
        Object writeReplace() {
            return super.writeReplace();
        }
    }

    ImmutableMultimap(ImmutableMap immutableMap, int i3) {
        this.f84055g = immutableMap;
        this.f84056h = i3;
    }

    @Override // com.google.common.collect.AbstractMultimap
    Map c() {
        throw new AssertionError("should never be called");
    }

    @Override // com.google.common.collect.Multimap
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap
    public boolean containsKey(Object obj) {
        return this.f84055g.containsKey(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap
    Set e() {
        throw new AssertionError("unreachable");
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* JADX INFO: renamed from: k */
    public ImmutableMap a1() {
        return this.f84055g;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* JADX INFO: renamed from: l, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection d() {
        return new EntryCollection(this);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* JADX INFO: renamed from: m, reason: merged with bridge method [inline-methods] */
    public ImmutableMultiset g() {
        return new Keys();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection h() {
        return new Values(this);
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* JADX INFO: renamed from: o, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection b() {
        return (ImmutableCollection) super.b();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* JADX INFO: renamed from: p, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator i() {
        return new UnmodifiableIterator<Map.Entry<K, V>>() { // from class: com.google.common.collect.ImmutableMultimap.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator f84057a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Object f84058b = null;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            Iterator f84059c = Iterators.m();

            {
                this.f84057a = ImmutableMultimap.this.f84055g.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                if (!this.f84059c.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f84057a.next();
                    this.f84058b = entry.getKey();
                    this.f84059c = ((ImmutableCollection) entry.getValue()).iterator();
                }
                Object obj = this.f84058b;
                Objects.requireNonNull(obj);
                return Maps.u(obj, this.f84059c.next());
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f84059c.hasNext() || this.f84057a.hasNext();
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public abstract ImmutableCollection get(Object obj);

    boolean r() {
        return this.f84055g.k();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public final boolean remove(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* JADX INFO: renamed from: s, reason: merged with bridge method [inline-methods] */
    public ImmutableSet keySet() {
        return this.f84055g.keySet();
    }

    @Override // com.google.common.collect.Multimap
    public int size() {
        return this.f84056h;
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* JADX INFO: renamed from: t, reason: merged with bridge method [inline-methods] */
    public ImmutableMultiset keys() {
        return (ImmutableMultiset) super.keys();
    }

    @Override // com.google.common.collect.AbstractMultimap
    public /* bridge */ /* synthetic */ String toString() {
        return super.toString();
    }

    @Override // com.google.common.collect.Multimap, com.google.common.collect.ListMultimap
    /* JADX INFO: renamed from: u, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection a(Object obj) {
        throw new UnsupportedOperationException();
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.google.common.collect.AbstractMultimap
    /* JADX INFO: renamed from: v, reason: merged with bridge method [inline-methods] */
    public UnmodifiableIterator j() {
        return new UnmodifiableIterator<V>() { // from class: com.google.common.collect.ImmutableMultimap.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Iterator f84061a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Iterator f84062b = Iterators.m();

            {
                this.f84061a = ImmutableMultimap.this.f84055g.values().iterator();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f84062b.hasNext() || this.f84061a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!this.f84062b.hasNext()) {
                    this.f84062b = ((ImmutableCollection) this.f84061a.next()).iterator();
                }
                return this.f84062b.next();
            }
        };
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    /* JADX INFO: renamed from: w, reason: merged with bridge method [inline-methods] */
    public ImmutableCollection values() {
        return (ImmutableCollection) super.values();
    }

    @Override // com.google.common.collect.AbstractMultimap, com.google.common.collect.Multimap
    public /* bridge */ /* synthetic */ boolean w1(Object obj, Object obj2) {
        return super.w1(obj, obj2);
    }
}
