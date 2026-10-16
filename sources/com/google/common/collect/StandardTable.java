package com.google.common.collect;

import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Predicate;
import com.google.common.base.Predicates;
import com.google.common.base.Supplier;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
class StandardTable<R, C, V> extends AbstractTable<R, C, V> implements Serializable {
    private static final long serialVersionUID = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Map f84683c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final Supplier f84684d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient Set f84685f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private transient Map f84686g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private transient ColumnMap f84687h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class CellIterator implements Iterator<Table.Cell<R, C, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator f84688a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map.Entry f84689b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Iterator f84690c;

        private CellIterator() {
            this.f84688a = StandardTable.this.f84683c.entrySet().iterator();
            this.f84690c = Iterators.o();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Table.Cell next() {
            if (!this.f84690c.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f84688a.next();
                this.f84689b = entry;
                this.f84690c = ((Map) entry.getValue()).entrySet().iterator();
            }
            Objects.requireNonNull(this.f84689b);
            Map.Entry entry2 = (Map.Entry) this.f84690c.next();
            return Tables.d(this.f84689b.getKey(), entry2.getKey(), entry2.getValue());
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f84688a.hasNext() || this.f84690c.hasNext();
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f84690c.remove();
            Map.Entry entry = this.f84689b;
            Objects.requireNonNull(entry);
            if (((Map) entry.getValue()).isEmpty()) {
                this.f84688a.remove();
                this.f84689b = null;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class Column extends Maps.ViewCachingAbstractMap<R, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Object f84692d;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class EntrySet extends Sets.ImprovedAbstractSet<Map.Entry<R, V>> {
            private EntrySet() {
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public void clear() {
                Column.this.d(Predicates.b());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.o(entry.getKey(), Column.this.f84692d, entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean isEmpty() {
                Column column = Column.this;
                return !StandardTable.this.n(column.f84692d);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return new EntrySetIterator();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                return StandardTable.this.w(entry.getKey(), Column.this.f84692d, entry.getValue());
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                return Column.this.d(Predicates.j(Predicates.g(collection)));
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                Iterator<V> it = StandardTable.this.f84683c.values().iterator();
                int i3 = 0;
                while (it.hasNext()) {
                    if (((Map) it.next()).containsKey(Column.this.f84692d)) {
                        i3++;
                    }
                }
                return i3;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class EntrySetIterator extends AbstractIterator<Map.Entry<R, V>> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            final Iterator f84695c;

            private EntrySetIterator() {
                this.f84695c = StandardTable.this.f84683c.entrySet().iterator();
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.common.collect.AbstractIterator
            /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
            public Map.Entry a() {
                while (this.f84695c.hasNext()) {
                    final Map.Entry entry = (Map.Entry) this.f84695c.next();
                    if (((Map) entry.getValue()).containsKey(Column.this.f84692d)) {
                        return new AbstractMapEntry<R, V>(this) { // from class: com.google.common.collect.StandardTable.Column.EntrySetIterator.1EntryImpl

                            /* JADX INFO: renamed from: b, reason: collision with root package name */
                            final /* synthetic */ EntrySetIterator f84698b;

                            {
                                this.f84698b = this;
                            }

                            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                            public Object getKey() {
                                return entry.getKey();
                            }

                            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                            public Object getValue() {
                                return ((Map) entry.getValue()).get(Column.this.f84692d);
                            }

                            /* JADX WARN: Multi-variable type inference failed */
                            @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
                            public Object setValue(Object obj) {
                                return NullnessCasts.a(((Map) entry.getValue()).put(Column.this.f84692d, Preconditions.t(obj)));
                            }
                        };
                    }
                }
                return (Map.Entry) b();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class KeySet extends Maps.KeySet<R, V> {
            KeySet() {
                super(Column.this);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                Column column = Column.this;
                return StandardTable.this.b(obj, column.f84692d);
            }

            @Override // com.google.common.collect.Maps.KeySet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                Column column = Column.this;
                return StandardTable.this.u(obj, column.f84692d) != null;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                return Column.this.d(Maps.z(Predicates.j(Predicates.g(collection))));
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class Values extends Maps.Values<R, V> {
            Values() {
                super(Column.this);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                return obj != null && Column.this.d(Maps.a0(Predicates.f(obj)));
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection collection) {
                return Column.this.d(Maps.a0(Predicates.g(collection)));
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection collection) {
                return Column.this.d(Maps.a0(Predicates.j(Predicates.g(collection))));
            }
        }

        Column(Object obj) {
            this.f84692d = Preconditions.t(obj);
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Set a() {
            return new EntrySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        /* JADX INFO: renamed from: b */
        Set g() {
            return new KeySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection c() {
            return new Values();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.b(obj, this.f84692d);
        }

        boolean d(Predicate predicate) {
            Iterator it = StandardTable.this.f84683c.entrySet().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Map.Entry entry = (Map.Entry) it.next();
                Map map = (Map) entry.getValue();
                Object obj = map.get(this.f84692d);
                if (obj != null && predicate.apply(Maps.u(entry.getKey(), obj))) {
                    map.remove(this.f84692d);
                    if (map.isEmpty()) {
                        it.remove();
                    }
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            return StandardTable.this.e(obj, this.f84692d);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            return StandardTable.this.t(obj, this.f84692d, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            return StandardTable.this.u(obj, this.f84692d);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ColumnKeyIterator extends AbstractIterator<C> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Map f84701c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Iterator f84702d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        Iterator f84703f;

        private ColumnKeyIterator() {
            this.f84701c = (Map) StandardTable.this.f84684d.get();
            this.f84702d = StandardTable.this.f84683c.values().iterator();
            this.f84703f = Iterators.m();
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.google.common.collect.AbstractIterator
        protected Object a() {
            while (true) {
                if (this.f84703f.hasNext()) {
                    Map.Entry entry = (Map.Entry) this.f84703f.next();
                    if (!this.f84701c.containsKey(entry.getKey())) {
                        this.f84701c.put(entry.getKey(), entry.getValue());
                        return entry.getKey();
                    }
                } else {
                    if (!this.f84702d.hasNext()) {
                        return b();
                    }
                    this.f84703f = ((Map) this.f84702d.next()).entrySet().iterator();
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ColumnKeySet extends StandardTable<R, C, V>.TableSet<C> {
        private ColumnKeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return StandardTable.this.n(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return StandardTable.this.q();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            boolean z2 = false;
            if (obj == null) {
                return false;
            }
            Iterator<V> it = StandardTable.this.f84683c.values().iterator();
            while (it.hasNext()) {
                Map map = (Map) it.next();
                if (map.keySet().remove(obj)) {
                    if (map.isEmpty()) {
                        it.remove();
                    }
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean removeAll(Collection collection) {
            Preconditions.t(collection);
            Iterator<V> it = StandardTable.this.f84683c.values().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Map map = (Map) it.next();
                if (Iterators.H(map.keySet().iterator(), collection)) {
                    if (map.isEmpty()) {
                        it.remove();
                    }
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean retainAll(Collection collection) {
            Preconditions.t(collection);
            Iterator<V> it = StandardTable.this.f84683c.values().iterator();
            boolean z2 = false;
            while (it.hasNext()) {
                Map map = (Map) it.next();
                if (map.keySet().retainAll(collection)) {
                    if (map.isEmpty()) {
                        it.remove();
                    }
                    z2 = true;
                }
            }
            return z2;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return Iterators.L(iterator());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class ColumnMap extends Maps.ViewCachingAbstractMap<C, Map<R, V>> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private final class ColumnMapEntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<C, Map<R, V>>> {
            private ColumnMapEntrySet() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (!(obj instanceof Map.Entry)) {
                    return false;
                }
                Map.Entry entry = (Map.Entry) obj;
                if (!StandardTable.this.n(entry.getKey())) {
                    return false;
                }
                Map map = ColumnMap.this.get(entry.getKey());
                Objects.requireNonNull(map);
                return map.equals(entry.getValue());
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Maps.k(StandardTable.this.m(), new Function<C, Map<R, V>>() { // from class: com.google.common.collect.StandardTable.ColumnMap.ColumnMapEntrySet.1
                    @Override // com.google.common.base.Function
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Map apply(Object obj) {
                        return StandardTable.this.k(obj);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj) || !(obj instanceof Map.Entry)) {
                    return false;
                }
                StandardTable.this.v(((Map.Entry) obj).getKey());
                return true;
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean removeAll(Collection collection) {
                Preconditions.t(collection);
                return Sets.o(this, collection.iterator());
            }

            @Override // com.google.common.collect.Sets.ImprovedAbstractSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean retainAll(Collection collection) {
                Preconditions.t(collection);
                ArrayList arrayListK = Lists.k(StandardTable.this.m().iterator());
                int size = arrayListK.size();
                boolean z2 = false;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayListK.get(i3);
                    i3++;
                    if (!collection.contains(Maps.u(obj, StandardTable.this.k(obj)))) {
                        StandardTable.this.v(obj);
                        z2 = true;
                    }
                }
                return z2;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.m().size();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class ColumnMapValues extends Maps.Values<C, Map<R, V>> {
            ColumnMapValues() {
                super(ColumnMap.this);
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean remove(Object obj) {
                for (Map.Entry entry : ColumnMap.this.entrySet()) {
                    if (((Map) entry.getValue()).equals(obj)) {
                        StandardTable.this.v(entry.getKey());
                        return true;
                    }
                }
                return false;
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean removeAll(Collection collection) {
                Preconditions.t(collection);
                ArrayList arrayListK = Lists.k(StandardTable.this.m().iterator());
                int size = arrayListK.size();
                boolean z2 = false;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayListK.get(i3);
                    i3++;
                    if (collection.contains(StandardTable.this.k(obj))) {
                        StandardTable.this.v(obj);
                        z2 = true;
                    }
                }
                return z2;
            }

            @Override // com.google.common.collect.Maps.Values, java.util.AbstractCollection, java.util.Collection
            public boolean retainAll(Collection collection) {
                Preconditions.t(collection);
                ArrayList arrayListK = Lists.k(StandardTable.this.m().iterator());
                int size = arrayListK.size();
                boolean z2 = false;
                int i3 = 0;
                while (i3 < size) {
                    Object obj = arrayListK.get(i3);
                    i3++;
                    if (!collection.contains(StandardTable.this.k(obj))) {
                        StandardTable.this.v(obj);
                        z2 = true;
                    }
                }
                return z2;
            }
        }

        private ColumnMap() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        public Set a() {
            return new ColumnMapEntrySet();
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        Collection c() {
            return new ColumnMapValues();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.n(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map get(Object obj) {
            if (!StandardTable.this.n(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.k(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map remove(Object obj) {
            if (StandardTable.this.n(obj)) {
                return StandardTable.this.v(obj);
            }
            return null;
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap, java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: keySet */
        public Set h() {
            return StandardTable.this.m();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class Row extends Maps.IteratorBasedAbstractMap<C, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84710a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Map f84711b;

        Row(Object obj) {
            this.f84710a = Preconditions.t(obj);
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap
        Iterator a() {
            d();
            Map map = this.f84711b;
            if (map == null) {
                return Iterators.o();
            }
            final Iterator it = map.entrySet().iterator();
            return new Iterator<Map.Entry<C, V>>(this) { // from class: com.google.common.collect.StandardTable.Row.1

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Row f84714b;

                {
                    this.f84714b = this;
                }

                @Override // java.util.Iterator
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public Map.Entry next() {
                    return this.f84714b.e((Map.Entry) it.next());
                }

                @Override // java.util.Iterator
                public boolean hasNext() {
                    return it.hasNext();
                }

                @Override // java.util.Iterator
                public void remove() {
                    it.remove();
                    this.f84714b.c();
                }
            };
        }

        Map b() {
            return (Map) StandardTable.this.f84683c.get(this.f84710a);
        }

        void c() {
            d();
            Map map = this.f84711b;
            if (map == null || !map.isEmpty()) {
                return;
            }
            StandardTable.this.f84683c.remove(this.f84710a);
            this.f84711b = null;
        }

        @Override // com.google.common.collect.Maps.IteratorBasedAbstractMap, java.util.AbstractMap, java.util.Map
        public void clear() {
            d();
            Map map = this.f84711b;
            if (map != null) {
                map.clear();
            }
            c();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            Map map;
            d();
            return (obj == null || (map = this.f84711b) == null || !Maps.I(map, obj)) ? false : true;
        }

        final void d() {
            Map map = this.f84711b;
            if (map == null || (map.isEmpty() && StandardTable.this.f84683c.containsKey(this.f84710a))) {
                this.f84711b = b();
            }
        }

        Map.Entry e(final Map.Entry entry) {
            return new ForwardingMapEntry<C, V>(this) { // from class: com.google.common.collect.StandardTable.Row.2

                /* JADX INFO: renamed from: b, reason: collision with root package name */
                final /* synthetic */ Row f84716b;

                {
                    this.f84716b = this;
                }

                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.ForwardingMapEntry, com.google.common.collect.ForwardingObject
                /* JADX INFO: renamed from: I1 */
                public Map.Entry k2() {
                    return entry;
                }

                @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                public boolean equals(Object obj) {
                    return S1(obj);
                }

                @Override // com.google.common.collect.ForwardingMapEntry, java.util.Map.Entry
                public Object setValue(Object obj) {
                    return super.setValue(Preconditions.t(obj));
                }
            };
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object get(Object obj) {
            Map map;
            d();
            if (obj == null || (map = this.f84711b) == null) {
                return null;
            }
            return Maps.J(map, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object put(Object obj, Object obj2) {
            Preconditions.t(obj);
            Preconditions.t(obj2);
            Map map = this.f84711b;
            return (map == null || map.isEmpty()) ? StandardTable.this.t(this.f84710a, obj, obj2) : this.f84711b.put(obj, obj2);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Object remove(Object obj) {
            d();
            Map map = this.f84711b;
            if (map == null) {
                return null;
            }
            Object objK = Maps.K(map, obj);
            c();
            return objK;
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            d();
            Map map = this.f84711b;
            if (map == null) {
                return 0;
            }
            return map.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class RowMap extends Maps.ViewCachingAbstractMap<R, Map<C, V>> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private final class EntrySet extends StandardTable<R, C, V>.TableSet<Map.Entry<R, Map<C, V>>> {
            private EntrySet() {
                super();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (entry.getKey() != null && (entry.getValue() instanceof Map) && Collections2.g(StandardTable.this.f84683c.entrySet(), entry)) {
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return Maps.k(StandardTable.this.f84683c.keySet(), new Function<R, Map<C, V>>() { // from class: com.google.common.collect.StandardTable.RowMap.EntrySet.1
                    @Override // com.google.common.base.Function
                    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                    public Map apply(Object obj) {
                        return StandardTable.this.x(obj);
                    }
                });
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (obj instanceof Map.Entry) {
                    Map.Entry entry = (Map.Entry) obj;
                    if (entry.getKey() != null && (entry.getValue() instanceof Map) && StandardTable.this.f84683c.entrySet().remove(entry)) {
                        return true;
                    }
                }
                return false;
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public int size() {
                return StandardTable.this.f84683c.size();
            }
        }

        RowMap() {
        }

        @Override // com.google.common.collect.Maps.ViewCachingAbstractMap
        protected Set a() {
            return new EntrySet();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return StandardTable.this.p(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public Map get(Object obj) {
            if (!StandardTable.this.p(obj)) {
                return null;
            }
            StandardTable standardTable = StandardTable.this;
            Objects.requireNonNull(obj);
            return standardTable.x(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public Map remove(Object obj) {
            if (obj == null) {
                return null;
            }
            return (Map) StandardTable.this.f84683c.remove(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class TableSet<T> extends Sets.ImprovedAbstractSet<T> {
        private TableSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            StandardTable.this.f84683c.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return StandardTable.this.f84683c.isEmpty();
        }
    }

    StandardTable(Map map, Supplier supplier) {
        this.f84683c = map;
        this.f84684d = supplier;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean o(Object obj, Object obj2, Object obj3) {
        return obj3 != null && obj3.equals(e(obj, obj2));
    }

    private Map s(Object obj) {
        Map map = (Map) this.f84683c.get(obj);
        if (map != null) {
            return map;
        }
        Map map2 = (Map) this.f84684d.get();
        this.f84683c.put(obj, map2);
        return map2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public Map v(Object obj) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator it = this.f84683c.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            Object objRemove = ((Map) entry.getValue()).remove(obj);
            if (objRemove != null) {
                linkedHashMap.put(entry.getKey(), objRemove);
                if (((Map) entry.getValue()).isEmpty()) {
                    it.remove();
                }
            }
        }
        return linkedHashMap;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean w(Object obj, Object obj2, Object obj3) {
        if (!o(obj, obj2, obj3)) {
            return false;
        }
        u(obj, obj2);
        return true;
    }

    @Override // com.google.common.collect.Table
    public Map C() {
        ColumnMap columnMap = this.f84687h;
        if (columnMap != null) {
            return columnMap;
        }
        ColumnMap columnMap2 = new ColumnMap();
        this.f84687h = columnMap2;
        return columnMap2;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Set O0() {
        return super.O0();
    }

    @Override // com.google.common.collect.AbstractTable
    Iterator a() {
        return new CellIterator();
    }

    @Override // com.google.common.collect.AbstractTable
    public boolean b(Object obj, Object obj2) {
        return (obj == null || obj2 == null || !super.b(obj, obj2)) ? false : true;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public void clear() {
        this.f84683c.clear();
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public boolean containsValue(Object obj) {
        return obj != null && super.containsValue(obj);
    }

    @Override // com.google.common.collect.AbstractTable
    public Object e(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return null;
        }
        return super.e(obj, obj2);
    }

    public Map k(Object obj) {
        return new Column(obj);
    }

    @Override // com.google.common.collect.Table
    public Map l() {
        Map map = this.f84686g;
        if (map != null) {
            return map;
        }
        Map mapR = r();
        this.f84686g = mapR;
        return mapR;
    }

    public Set m() {
        Set set = this.f84685f;
        if (set != null) {
            return set;
        }
        ColumnKeySet columnKeySet = new ColumnKeySet();
        this.f84685f = columnKeySet;
        return columnKeySet;
    }

    public boolean n(Object obj) {
        if (obj == null) {
            return false;
        }
        Iterator<V> it = this.f84683c.values().iterator();
        while (it.hasNext()) {
            if (Maps.I((Map) it.next(), obj)) {
                return true;
            }
        }
        return false;
    }

    public boolean p(Object obj) {
        return obj != null && Maps.I(this.f84683c, obj);
    }

    Iterator q() {
        return new ColumnKeyIterator();
    }

    Map r() {
        return new RowMap();
    }

    @Override // com.google.common.collect.Table
    public int size() {
        Iterator<V> it = this.f84683c.values().iterator();
        int size = 0;
        while (it.hasNext()) {
            size += ((Map) it.next()).size();
        }
        return size;
    }

    public Object t(Object obj, Object obj2, Object obj3) {
        Preconditions.t(obj);
        Preconditions.t(obj2);
        Preconditions.t(obj3);
        return s(obj).put(obj2, obj3);
    }

    public Object u(Object obj, Object obj2) {
        Map map;
        if (obj == null || obj2 == null || (map = (Map) Maps.J(this.f84683c, obj)) == null) {
            return null;
        }
        Object objRemove = map.remove(obj2);
        if (map.isEmpty()) {
            this.f84683c.remove(obj);
        }
        return objRemove;
    }

    @Override // com.google.common.collect.AbstractTable, com.google.common.collect.Table
    public Collection values() {
        return super.values();
    }

    public Map x(Object obj) {
        return new Row(obj);
    }
}
