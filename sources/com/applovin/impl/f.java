package com.applovin.impl;

import com.applovin.exoplayer2.common.base.Preconditions;
import com.applovin.impl.h;
import com.applovin.impl.uc;
import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;
import java.util.SortedSet;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes4.dex */
abstract class f extends com.applovin.impl.h implements Serializable {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private transient Map f59564d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private transient int f59565f;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class b extends uc.f {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final transient Map f59567c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a extends uc.c {
            a() {
            }

            @Override // com.applovin.impl.uc.c
            Map a() {
                return b.this;
            }

            @Override // com.applovin.impl.uc.c, java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean contains(Object obj) {
                return q3.a(b.this.f59567c.entrySet(), obj);
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
            public Iterator iterator() {
                return b.this.new C0103b();
            }

            @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
            public boolean remove(Object obj) {
                if (!contains(obj)) {
                    return false;
                }
                f.this.c(((Map.Entry) obj).getKey());
                return true;
            }
        }

        /* JADX INFO: renamed from: com.applovin.impl.f$b$b, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class C0103b implements Iterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator f59570a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Collection f59571b;

            C0103b() {
                this.f59570a = b.this.f59567c.entrySet().iterator();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Map.Entry next() {
                Map.Entry entry = (Map.Entry) this.f59570a.next();
                this.f59571b = (Collection) entry.getValue();
                return b.this.a(entry);
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f59570a.hasNext();
            }

            @Override // java.util.Iterator
            public void remove() {
                p3.a(this.f59571b != null);
                this.f59570a.remove();
                f.b(f.this, this.f59571b.size());
                this.f59571b.clear();
                this.f59571b = null;
            }
        }

        b(Map map) {
            this.f59567c = map;
        }

        Map.Entry a(Map.Entry entry) {
            Object key = entry.getKey();
            return uc.a(key, f.this.a(key, (Collection) entry.getValue()));
        }

        @Override // java.util.AbstractMap, java.util.Map
        public void clear() {
            if (this.f59567c == f.this.f59564d) {
                f.this.clear();
            } else {
                wb.a((Iterator) new C0103b());
            }
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean containsKey(Object obj) {
            return uc.b(this.f59567c, obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public boolean equals(Object obj) {
            return this == obj || this.f59567c.equals(obj);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int hashCode() {
            return this.f59567c.hashCode();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Set keySet() {
            return f.this.e();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public int size() {
            return this.f59567c.size();
        }

        @Override // java.util.AbstractMap
        public String toString() {
            return this.f59567c.toString();
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection get(Object obj) {
            Collection collection = (Collection) uc.c(this.f59567c, obj);
            if (collection == null) {
                return null;
            }
            return f.this.a(obj, collection);
        }

        @Override // java.util.AbstractMap, java.util.Map
        public Collection remove(Object obj) {
            Collection collection = (Collection) this.f59567c.remove(obj);
            if (collection == null) {
                return null;
            }
            Collection collectionG = f.this.g();
            collectionG.addAll(collection);
            f.b(f.this, collection.size());
            collection.clear();
            return collectionG;
        }

        @Override // com.applovin.impl.uc.f
        protected Set a() {
            return new a();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private abstract class c implements Iterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Iterator f59573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f59574b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Collection f59575c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        Iterator f59576d = wb.c();

        c() {
            this.f59573a = f.this.f59564d.entrySet().iterator();
        }

        abstract Object a(Object obj, Object obj2);

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f59573a.hasNext() || this.f59576d.hasNext();
        }

        @Override // java.util.Iterator
        public Object next() {
            if (!this.f59576d.hasNext()) {
                Map.Entry entry = (Map.Entry) this.f59573a.next();
                this.f59574b = entry.getKey();
                Collection collection = (Collection) entry.getValue();
                this.f59575c = collection;
                this.f59576d = collection.iterator();
            }
            return a(this.f59574b, this.f59576d.next());
        }

        @Override // java.util.Iterator
        public void remove() {
            this.f59576d.remove();
            if (this.f59575c.isEmpty()) {
                this.f59573a.remove();
            }
            f.c(f.this);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class d extends uc.d {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a implements Iterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            Map.Entry f59579a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ Iterator f59580b;

            a(Iterator it) {
                this.f59580b = it;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f59580b.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                Map.Entry entry = (Map.Entry) this.f59580b.next();
                this.f59579a = entry;
                return entry.getKey();
            }

            @Override // java.util.Iterator
            public void remove() {
                p3.a(this.f59579a != null);
                Collection collection = (Collection) this.f59579a.getValue();
                this.f59580b.remove();
                f.b(f.this, collection.size());
                collection.clear();
                this.f59579a = null;
            }
        }

        d(Map map) {
            super(map);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            wb.a(iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean containsAll(Collection collection) {
            return a().keySet().containsAll(collection);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public boolean equals(Object obj) {
            return this == obj || a().keySet().equals(obj);
        }

        @Override // java.util.AbstractSet, java.util.Collection, java.util.Set
        public int hashCode() {
            return a().keySet().hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new a(a().entrySet().iterator());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Collection collection = (Collection) a().remove(obj);
            if (collection == null) {
                return false;
            }
            int size = collection.size();
            collection.clear();
            f.b(f.this, size);
            return size > 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class e extends h implements NavigableMap {
        e(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // com.applovin.impl.f.h, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap headMap(Object obj) {
            return headMap(obj, false);
        }

        @Override // com.applovin.impl.f.h, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavigableMap tailMap(Object obj) {
            return tailMap(obj, true);
        }

        @Override // java.util.NavigableMap
        public Map.Entry ceilingEntry(Object obj) {
            Map.Entry entryCeilingEntry = d().ceilingEntry(obj);
            if (entryCeilingEntry == null) {
                return null;
            }
            return a(entryCeilingEntry);
        }

        @Override // java.util.NavigableMap
        public Object ceilingKey(Object obj) {
            return d().ceilingKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet descendingKeySet() {
            return descendingMap().navigableKeySet();
        }

        @Override // java.util.NavigableMap
        public NavigableMap descendingMap() {
            return f.this.new e(d().descendingMap());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.applovin.impl.f.h
        /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
        public NavigableSet c() {
            return f.this.new C0104f(d());
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.applovin.impl.f.h
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public NavigableMap d() {
            return (NavigableMap) super.d();
        }

        @Override // java.util.NavigableMap
        public Map.Entry firstEntry() {
            Map.Entry entryFirstEntry = d().firstEntry();
            if (entryFirstEntry == null) {
                return null;
            }
            return a(entryFirstEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry floorEntry(Object obj) {
            Map.Entry entryFloorEntry = d().floorEntry(obj);
            if (entryFloorEntry == null) {
                return null;
            }
            return a(entryFloorEntry);
        }

        @Override // java.util.NavigableMap
        public Object floorKey(Object obj) {
            return d().floorKey(obj);
        }

        @Override // java.util.NavigableMap
        public Map.Entry higherEntry(Object obj) {
            Map.Entry entryHigherEntry = d().higherEntry(obj);
            if (entryHigherEntry == null) {
                return null;
            }
            return a(entryHigherEntry);
        }

        @Override // java.util.NavigableMap
        public Object higherKey(Object obj) {
            return d().higherKey(obj);
        }

        @Override // com.applovin.impl.f.h, com.applovin.impl.f.b, java.util.AbstractMap, java.util.Map
        public NavigableSet keySet() {
            return (NavigableSet) super.keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry lastEntry() {
            Map.Entry entryLastEntry = d().lastEntry();
            if (entryLastEntry == null) {
                return null;
            }
            return a(entryLastEntry);
        }

        @Override // java.util.NavigableMap
        public Map.Entry lowerEntry(Object obj) {
            Map.Entry entryLowerEntry = d().lowerEntry(obj);
            if (entryLowerEntry == null) {
                return null;
            }
            return a(entryLowerEntry);
        }

        @Override // java.util.NavigableMap
        public Object lowerKey(Object obj) {
            return d().lowerKey(obj);
        }

        @Override // java.util.NavigableMap
        public NavigableSet navigableKeySet() {
            return keySet();
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollFirstEntry() {
            return a(entrySet().iterator());
        }

        @Override // java.util.NavigableMap
        public Map.Entry pollLastEntry() {
            return a(descendingMap().entrySet().iterator());
        }

        Map.Entry a(Iterator it) {
            if (!it.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) it.next();
            Collection collectionG = f.this.g();
            collectionG.addAll((Collection) entry.getValue());
            it.remove();
            return uc.a(entry.getKey(), f.this.c(collectionG));
        }

        @Override // java.util.NavigableMap
        public NavigableMap headMap(Object obj, boolean z2) {
            return f.this.new e(d().headMap(obj, z2));
        }

        @Override // java.util.NavigableMap
        public NavigableMap subMap(Object obj, boolean z2, Object obj2, boolean z3) {
            return f.this.new e(d().subMap(obj, z2, obj2, z3));
        }

        @Override // java.util.NavigableMap
        public NavigableMap tailMap(Object obj, boolean z2) {
            return f.this.new e(d().tailMap(obj, z2));
        }

        @Override // com.applovin.impl.f.h, java.util.SortedMap, java.util.NavigableMap
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableMap subMap(Object obj, Object obj2) {
            return subMap(obj, true, obj2, false);
        }
    }

    /* JADX INFO: renamed from: com.applovin.impl.f$f, reason: collision with other inner class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class C0104f extends i implements NavigableSet {
        C0104f(NavigableMap navigableMap) {
            super(navigableMap);
        }

        @Override // com.applovin.impl.f.i, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableSet headSet(Object obj) {
            return headSet(obj, false);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.applovin.impl.f.i
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public NavigableMap b() {
            return (NavigableMap) super.b();
        }

        @Override // java.util.NavigableSet
        public Object ceiling(Object obj) {
            return b().ceilingKey(obj);
        }

        @Override // java.util.NavigableSet
        public Iterator descendingIterator() {
            return descendingSet().iterator();
        }

        @Override // java.util.NavigableSet
        public NavigableSet descendingSet() {
            return f.this.new C0104f(b().descendingMap());
        }

        @Override // java.util.NavigableSet
        public Object floor(Object obj) {
            return b().floorKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object higher(Object obj) {
            return b().higherKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object lower(Object obj) {
            return b().lowerKey(obj);
        }

        @Override // java.util.NavigableSet
        public Object pollFirst() {
            return wb.c(iterator());
        }

        @Override // java.util.NavigableSet
        public Object pollLast() {
            return wb.c(descendingIterator());
        }

        @Override // com.applovin.impl.f.i, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public NavigableSet subSet(Object obj, Object obj2) {
            return subSet(obj, true, obj2, false);
        }

        @Override // com.applovin.impl.f.i, java.util.SortedSet, java.util.NavigableSet
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public NavigableSet tailSet(Object obj) {
            return tailSet(obj, true);
        }

        @Override // java.util.NavigableSet
        public NavigableSet headSet(Object obj, boolean z2) {
            return f.this.new C0104f(b().headMap(obj, z2));
        }

        @Override // java.util.NavigableSet
        public NavigableSet subSet(Object obj, boolean z2, Object obj2, boolean z3) {
            return f.this.new C0104f(b().subMap(obj, z2, obj2, z3));
        }

        @Override // java.util.NavigableSet
        public NavigableSet tailSet(Object obj, boolean z2) {
            return f.this.new C0104f(b().tailMap(obj, z2));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class g extends k implements RandomAccess {
        g(Object obj, List list, j jVar) {
            super(obj, list, jVar);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class h extends b implements SortedMap {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        SortedSet f59585f;

        h(SortedMap sortedMap) {
            super(sortedMap);
        }

        SortedSet c() {
            return f.this.new i(d());
        }

        @Override // java.util.SortedMap
        public Comparator comparator() {
            return d().comparator();
        }

        SortedMap d() {
            return (SortedMap) this.f59567c;
        }

        @Override // java.util.SortedMap
        public Object firstKey() {
            return d().firstKey();
        }

        public SortedMap headMap(Object obj) {
            return f.this.new h(d().headMap(obj));
        }

        @Override // java.util.SortedMap
        public Object lastKey() {
            return d().lastKey();
        }

        public SortedMap subMap(Object obj, Object obj2) {
            return f.this.new h(d().subMap(obj, obj2));
        }

        public SortedMap tailMap(Object obj) {
            return f.this.new h(d().tailMap(obj));
        }

        @Override // com.applovin.impl.f.b, java.util.AbstractMap, java.util.Map
        public SortedSet keySet() {
            SortedSet sortedSet = this.f59585f;
            if (sortedSet != null) {
                return sortedSet;
            }
            SortedSet sortedSetC = c();
            this.f59585f = sortedSetC;
            return sortedSetC;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private class i extends d implements SortedSet {
        i(SortedMap sortedMap) {
            super(sortedMap);
        }

        SortedMap b() {
            return (SortedMap) super.a();
        }

        @Override // java.util.SortedSet
        public Comparator comparator() {
            return b().comparator();
        }

        @Override // java.util.SortedSet
        public Object first() {
            return b().firstKey();
        }

        public SortedSet headSet(Object obj) {
            return f.this.new i(b().headMap(obj));
        }

        @Override // java.util.SortedSet
        public Object last() {
            return b().lastKey();
        }

        public SortedSet subSet(Object obj, Object obj2) {
            return f.this.new i(b().subMap(obj, obj2));
        }

        public SortedSet tailSet(Object obj) {
            return f.this.new i(b().tailMap(obj));
        }
    }

    protected f(Map map) {
        Preconditions.checkArgument(map.isEmpty());
        this.f59564d = map;
    }

    static /* synthetic */ int b(f fVar) {
        int i3 = fVar.f59565f;
        fVar.f59565f = i3 + 1;
        return i3;
    }

    static /* synthetic */ int c(f fVar) {
        int i3 = fVar.f59565f;
        fVar.f59565f = i3 - 1;
        return i3;
    }

    abstract Collection a(Object obj, Collection collection);

    abstract Collection c(Collection collection);

    @Override // com.applovin.impl.tf
    public void clear() {
        Iterator it = this.f59564d.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.f59564d.clear();
        this.f59565f = 0;
    }

    @Override // com.applovin.impl.h
    Collection d() {
        return new h.a();
    }

    @Override // com.applovin.impl.h
    Iterator f() {
        return new a();
    }

    abstract Collection g();

    final Map h() {
        Map map = this.f59564d;
        return map instanceof NavigableMap ? new e((NavigableMap) this.f59564d) : map instanceof SortedMap ? new h((SortedMap) this.f59564d) : new b(this.f59564d);
    }

    final Set i() {
        Map map = this.f59564d;
        return map instanceof NavigableMap ? new C0104f((NavigableMap) this.f59564d) : map instanceof SortedMap ? new i((SortedMap) this.f59564d) : new d(this.f59564d);
    }

    @Override // com.applovin.impl.tf
    public boolean put(Object obj, Object obj2) {
        Collection collection = (Collection) this.f59564d.get(obj);
        if (collection != null) {
            if (!collection.add(obj2)) {
                return false;
            }
            this.f59565f++;
            return true;
        }
        Collection collectionB = b(obj);
        if (!collectionB.add(obj2)) {
            throw new AssertionError("New Collection violated the Collection spec");
        }
        this.f59565f++;
        this.f59564d.put(obj, collectionB);
        return true;
    }

    @Override // com.applovin.impl.tf
    public int size() {
        return this.f59565f;
    }

    @Override // com.applovin.impl.h, com.applovin.impl.tf
    public Collection values() {
        return super.values();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class j extends AbstractCollection {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f59588a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Collection f59589b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final j f59590c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Collection f59591d;

        j(Object obj, Collection collection, j jVar) {
            this.f59588a = obj;
            this.f59589b = collection;
            this.f59590c = jVar;
            this.f59591d = jVar == null ? null : jVar.c();
        }

        void a() {
            j jVar = this.f59590c;
            if (jVar != null) {
                jVar.a();
            } else {
                f.this.f59564d.put(this.f59588a, this.f59589b);
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean add(Object obj) {
            e();
            boolean zIsEmpty = this.f59589b.isEmpty();
            boolean zAdd = this.f59589b.add(obj);
            if (zAdd) {
                f.b(f.this);
                if (zIsEmpty) {
                    a();
                }
            }
            return zAdd;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean addAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = this.f59589b.addAll(collection);
            if (zAddAll) {
                f.a(f.this, this.f59589b.size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        j b() {
            return this.f59590c;
        }

        Collection c() {
            return this.f59589b;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            int size = size();
            if (size == 0) {
                return;
            }
            this.f59589b.clear();
            f.b(f.this, size);
            f();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            e();
            return this.f59589b.contains(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean containsAll(Collection collection) {
            e();
            return this.f59589b.containsAll(collection);
        }

        Object d() {
            return this.f59588a;
        }

        void e() {
            Collection collection;
            j jVar = this.f59590c;
            if (jVar != null) {
                jVar.e();
                if (this.f59590c.c() != this.f59591d) {
                    throw new ConcurrentModificationException();
                }
            } else {
                if (!this.f59589b.isEmpty() || (collection = (Collection) f.this.f59564d.get(this.f59588a)) == null) {
                    return;
                }
                this.f59589b = collection;
            }
        }

        @Override // java.util.Collection
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            e();
            return this.f59589b.equals(obj);
        }

        void f() {
            j jVar = this.f59590c;
            if (jVar != null) {
                jVar.f();
            } else if (this.f59589b.isEmpty()) {
                f.this.f59564d.remove(this.f59588a);
            }
        }

        @Override // java.util.Collection
        public int hashCode() {
            e();
            return this.f59589b.hashCode();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            e();
            return new a();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            e();
            boolean zRemove = this.f59589b.remove(obj);
            if (zRemove) {
                f.c(f.this);
                f();
            }
            return zRemove;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean removeAll(Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zRemoveAll = this.f59589b.removeAll(collection);
            if (zRemoveAll) {
                f.a(f.this, this.f59589b.size() - size);
                f();
            }
            return zRemoveAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean retainAll(Collection collection) {
            Preconditions.checkNotNull(collection);
            int size = size();
            boolean zRetainAll = this.f59589b.retainAll(collection);
            if (zRetainAll) {
                f.a(f.this, this.f59589b.size() - size);
                f();
            }
            return zRetainAll;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            e();
            return this.f59589b.size();
        }

        @Override // java.util.AbstractCollection
        public String toString() {
            e();
            return this.f59589b.toString();
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class a implements Iterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Iterator f59593a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final Collection f59594b;

            a() {
                Collection collection = j.this.f59589b;
                this.f59594b = collection;
                this.f59593a = f.b(collection);
            }

            Iterator a() {
                b();
                return this.f59593a;
            }

            void b() {
                j.this.e();
                if (j.this.f59589b != this.f59594b) {
                    throw new ConcurrentModificationException();
                }
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                b();
                return this.f59593a.hasNext();
            }

            @Override // java.util.Iterator
            public Object next() {
                b();
                return this.f59593a.next();
            }

            @Override // java.util.Iterator
            public void remove() {
                this.f59593a.remove();
                f.c(f.this);
                j.this.f();
            }

            a(Iterator it) {
                this.f59594b = j.this.f59589b;
                this.f59593a = it;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class k extends j implements List {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private class a extends j.a implements ListIterator {
            a() {
                super();
            }

            private ListIterator c() {
                return (ListIterator) a();
            }

            @Override // java.util.ListIterator
            public void add(Object obj) {
                boolean zIsEmpty = k.this.isEmpty();
                c().add(obj);
                f.b(f.this);
                if (zIsEmpty) {
                    k.this.a();
                }
            }

            @Override // java.util.ListIterator
            public boolean hasPrevious() {
                return c().hasPrevious();
            }

            @Override // java.util.ListIterator
            public int nextIndex() {
                return c().nextIndex();
            }

            @Override // java.util.ListIterator
            public Object previous() {
                return c().previous();
            }

            @Override // java.util.ListIterator
            public int previousIndex() {
                return c().previousIndex();
            }

            @Override // java.util.ListIterator
            public void set(Object obj) {
                c().set(obj);
            }

            public a(int i3) {
                super(k.this.g().listIterator(i3));
            }
        }

        k(Object obj, List list, j jVar) {
            super(obj, list, jVar);
        }

        @Override // java.util.List
        public void add(int i3, Object obj) {
            e();
            boolean zIsEmpty = c().isEmpty();
            g().add(i3, obj);
            f.b(f.this);
            if (zIsEmpty) {
                a();
            }
        }

        @Override // java.util.List
        public boolean addAll(int i3, Collection collection) {
            if (collection.isEmpty()) {
                return false;
            }
            int size = size();
            boolean zAddAll = g().addAll(i3, collection);
            if (zAddAll) {
                f.a(f.this, c().size() - size);
                if (size == 0) {
                    a();
                }
            }
            return zAddAll;
        }

        List g() {
            return (List) c();
        }

        @Override // java.util.List
        public Object get(int i3) {
            e();
            return g().get(i3);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            e();
            return g().indexOf(obj);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            e();
            return g().lastIndexOf(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            e();
            return new a();
        }

        @Override // java.util.List
        public Object remove(int i3) {
            e();
            Object objRemove = g().remove(i3);
            f.c(f.this);
            f();
            return objRemove;
        }

        @Override // java.util.List
        public Object set(int i3, Object obj) {
            e();
            return g().set(i3, obj);
        }

        @Override // java.util.List
        public List subList(int i3, int i4) {
            e();
            return f.this.a(d(), g().subList(i3, i4), b() == null ? this : b());
        }

        @Override // java.util.List
        public ListIterator listIterator(int i3) {
            e();
            return new a(i3);
        }
    }

    static /* synthetic */ int b(f fVar, int i3) {
        int i4 = fVar.f59565f - i3;
        fVar.f59565f = i4;
        return i4;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(Object obj) {
        Collection collection = (Collection) uc.d(this.f59564d, obj);
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            this.f59565f -= size;
        }
    }

    static /* synthetic */ int a(f fVar, int i3) {
        int i4 = fVar.f59565f + i3;
        fVar.f59565f = i4;
        return i4;
    }

    Collection b(Object obj) {
        return g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static Iterator b(Collection collection) {
        if (collection instanceof List) {
            return ((List) collection).listIterator();
        }
        return collection.iterator();
    }

    final List a(Object obj, List list, j jVar) {
        if (list instanceof RandomAccess) {
            return new g(obj, list, jVar);
        }
        return new k(obj, list, jVar);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class a extends c {
        a() {
            super();
        }

        @Override // com.applovin.impl.f.c
        Object a(Object obj, Object obj2) {
            return obj2;
        }
    }
}
