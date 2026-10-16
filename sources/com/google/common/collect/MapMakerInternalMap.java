package com.google.common.collect;

import com.facebook.internal.NativeProtocol;
import com.google.common.base.Equivalence;
import com.google.common.base.Preconditions;
import com.google.common.collect.MapMaker;
import com.google.common.collect.MapMakerInternalMap.InternalEntry;
import com.google.common.collect.MapMakerInternalMap.Segment;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class MapMakerInternalMap<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends AbstractMap<K, V> implements ConcurrentMap<K, V>, Serializable {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    static final WeakValueReference f84299k = new WeakValueReference<Object, Object, DummyInternalEntry>() { // from class: com.google.common.collect.MapMakerInternalMap.1
        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public DummyInternalEntry c() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public Object get() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public void clear() {
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public WeakValueReference a(ReferenceQueue referenceQueue, DummyInternalEntry dummyInternalEntry) {
            return this;
        }
    };
    private static final long serialVersionUID = 5;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final transient int f84300a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final transient int f84301b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final transient Segment[] f84302c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f84303d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Equivalence f84304f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final transient InternalEntryHelper f84305g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    transient Set f84306h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    transient Collection f84307i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    transient Set f84308j;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class AbstractSerializationProxy<K, V> extends ForwardingConcurrentMap<K, V> implements Serializable {
        private static final long serialVersionUID = 3;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Strength f84309a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Strength f84310b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Equivalence f84311c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Equivalence f84312d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final int f84313f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        transient ConcurrentMap f84314g;

        AbstractSerializationProxy(Strength strength, Strength strength2, Equivalence equivalence, Equivalence equivalence2, int i3, ConcurrentMap concurrentMap) {
            this.f84309a = strength;
            this.f84310b = strength2;
            this.f84311c = equivalence;
            this.f84312d = equivalence2;
            this.f84313f = i3;
            this.f84314g = concurrentMap;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.collect.ForwardingConcurrentMap, com.google.common.collect.ForwardingMap
        /* JADX INFO: renamed from: c2 */
        public ConcurrentMap k2() {
            return this.f84314g;
        }

        /* JADX WARN: Multi-variable type inference failed */
        void g2(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            while (true) {
                Object object = objectInputStream.readObject();
                if (object == null) {
                    return;
                }
                this.f84314g.put(object, objectInputStream.readObject());
            }
        }

        MapMaker k2(ObjectInputStream objectInputStream) throws IOException {
            return new MapMaker().g(objectInputStream.readInt()).j(this.f84309a).k(this.f84310b).h(this.f84311c).a(this.f84313f);
        }

        void m2(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.writeInt(this.f84314g.size());
            for (Map.Entry<K, V> entry : this.f84314g.entrySet()) {
                objectOutputStream.writeObject(entry.getKey());
                objectOutputStream.writeObject(entry.getValue());
            }
            objectOutputStream.writeObject(null);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class AbstractStrongKeyEntry<K, V, E extends InternalEntry<K, V, E>> implements InternalEntry<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84315a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f84316b;

        AbstractStrongKeyEntry(Object obj, int i3) {
            this.f84315a = obj;
            this.f84316b = i3;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public InternalEntry b() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int c() {
            return this.f84316b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getKey() {
            return this.f84315a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class AbstractWeakKeyEntry<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<K> implements InternalEntry<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f84317a;

        AbstractWeakKeyEntry(ReferenceQueue referenceQueue, Object obj, int i3) {
            super(obj, referenceQueue);
            this.f84317a = i3;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public InternalEntry b() {
            return null;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final int c() {
            return this.f84317a;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getKey() {
            return get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class CleanupMapTask implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WeakReference f84318a;

        @Override // java.lang.Runnable
        public void run() {
            MapMakerInternalMap mapMakerInternalMap = (MapMakerInternalMap) this.f84318a.get();
            if (mapMakerInternalMap == null) {
                throw new CancellationException();
            }
            for (Segment segment : mapMakerInternalMap.f84302c) {
                segment.B();
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class DummyInternalEntry implements InternalEntry<Object, Object, DummyInternalEntry> {
        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public int c() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public DummyInternalEntry b() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getKey() {
            throw new AssertionError();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public Object getValue() {
            throw new AssertionError();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class EntryIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<Map.Entry<K, V>> {
        EntryIterator() {
            super();
        }

        @Override // java.util.Iterator
        /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
        public Map.Entry next() {
            return c();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class EntrySet extends AbstractSet<Map.Entry<K, V>> {
        EntrySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = MapMakerInternalMap.this.get(key)) != null && MapMakerInternalMap.this.l().d(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && MapMakerInternalMap.this.remove(key, entry.getValue());
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    abstract class HashIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f84321a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f84322b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Segment f84323c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        AtomicReferenceArray f84324d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        InternalEntry f84325f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        WriteThroughEntry f84326g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        WriteThroughEntry f84327h;

        HashIterator() {
            this.f84321a = MapMakerInternalMap.this.f84302c.length - 1;
            a();
        }

        final void a() {
            this.f84326g = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i3 = this.f84321a;
                if (i3 < 0) {
                    return;
                }
                Segment[] segmentArr = MapMakerInternalMap.this.f84302c;
                this.f84321a = i3 - 1;
                Segment segment = segmentArr[i3];
                this.f84323c = segment;
                if (segment.f84332b != 0) {
                    this.f84324d = this.f84323c.f84335f;
                    this.f84322b = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        boolean b(InternalEntry internalEntry) {
            try {
                Object key = internalEntry.getKey();
                Object objD = MapMakerInternalMap.this.d(internalEntry);
                if (objD == null) {
                    this.f84323c.r();
                    return false;
                }
                this.f84326g = new WriteThroughEntry(key, objD);
                this.f84323c.r();
                return true;
            } catch (Throwable th) {
                this.f84323c.r();
                throw th;
            }
        }

        WriteThroughEntry c() {
            WriteThroughEntry writeThroughEntry = this.f84326g;
            if (writeThroughEntry == null) {
                throw new NoSuchElementException();
            }
            this.f84327h = writeThroughEntry;
            a();
            return this.f84327h;
        }

        boolean d() {
            InternalEntry internalEntry = this.f84325f;
            if (internalEntry == null) {
                return false;
            }
            while (true) {
                this.f84325f = internalEntry.b();
                InternalEntry internalEntry2 = this.f84325f;
                if (internalEntry2 == null) {
                    return false;
                }
                if (b(internalEntry2)) {
                    return true;
                }
                internalEntry = this.f84325f;
            }
        }

        boolean e() {
            while (true) {
                int i3 = this.f84322b;
                if (i3 < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.f84324d;
                this.f84322b = i3 - 1;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(i3);
                this.f84325f = internalEntry;
                if (internalEntry != null && (b(internalEntry) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f84326g != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            CollectPreconditions.e(this.f84327h != null);
            MapMakerInternalMap.this.remove(this.f84327h.getKey());
            this.f84327h = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface InternalEntry<K, V, E extends InternalEntry<K, V, E>> {
        InternalEntry b();

        int c();

        Object getKey();

        Object getValue();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface InternalEntryHelper<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> {
        Segment a(MapMakerInternalMap mapMakerInternalMap, int i3);

        InternalEntry b(Segment segment, InternalEntry internalEntry, InternalEntry internalEntry2);

        Strength c();

        void d(Segment segment, InternalEntry internalEntry, Object obj);

        InternalEntry e(Segment segment, Object obj, int i3, InternalEntry internalEntry);

        Strength f();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class KeyIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<K> {
        KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class KeySet extends AbstractSet<K> {
        KeySet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return MapMakerInternalMap.this.remove(obj) != null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class SerializationProxy<K, V> extends AbstractSerializationProxy<K, V> {
        private static final long serialVersionUID = 3;

        SerializationProxy(Strength strength, Strength strength2, Equivalence equivalence, Equivalence equivalence2, int i3, ConcurrentMap concurrentMap) {
            super(strength, strength2, equivalence, equivalence2, i3, concurrentMap);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f84314g = k2(objectInputStream).i();
            g2(objectInputStream);
        }

        private Object readResolve() {
            return this.f84314g;
        }

        private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
            objectOutputStream.defaultWriteObject();
            m2(objectOutputStream);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum Strength {
        STRONG { // from class: com.google.common.collect.MapMakerInternalMap.Strength.1
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence b() {
                return Equivalence.c();
            }
        },
        WEAK { // from class: com.google.common.collect.MapMakerInternalMap.Strength.2
            @Override // com.google.common.collect.MapMakerInternalMap.Strength
            Equivalence b() {
                return Equivalence.f();
            }
        };

        abstract Equivalence b();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class StrongKeyDummyValueEntry<K> extends AbstractStrongKeyEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class LinkedStrongKeyDummyValueEntry<K> extends StrongKeyDummyValueEntry<K> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final StrongKeyDummyValueEntry f84341c;

            LinkedStrongKeyDummyValueEntry(Object obj, int i3, StrongKeyDummyValueEntry strongKeyDummyValueEntry) {
                super(obj, i3);
                this.f84341c = strongKeyDummyValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public StrongKeyDummyValueEntry b() {
                return this.f84341c;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.StrongKeyDummyValueEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        private StrongKeyDummyValueEntry(Object obj, int i3) {
            super(obj, i3);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Helper f84340a = new Helper();

            Helper() {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength f() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public StrongKeyDummyValueEntry b(StrongKeyDummyValueSegment strongKeyDummyValueSegment, StrongKeyDummyValueEntry strongKeyDummyValueEntry, StrongKeyDummyValueEntry strongKeyDummyValueEntry2) {
                return e(strongKeyDummyValueSegment, strongKeyDummyValueEntry.f84315a, strongKeyDummyValueEntry.f84316b, strongKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public StrongKeyDummyValueEntry e(StrongKeyDummyValueSegment strongKeyDummyValueSegment, Object obj, int i3, StrongKeyDummyValueEntry strongKeyDummyValueEntry) {
                return strongKeyDummyValueEntry == null ? new StrongKeyDummyValueEntry(obj, i3) : new LinkedStrongKeyDummyValueEntry(obj, i3, strongKeyDummyValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public StrongKeyDummyValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i3) {
                return new StrongKeyDummyValueSegment(mapMakerInternalMap, i3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public void d(StrongKeyDummyValueSegment strongKeyDummyValueSegment, StrongKeyDummyValueEntry strongKeyDummyValueEntry, MapMaker.Dummy dummy) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class StrongKeyStrongValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, StrongKeyStrongValueEntry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile Object f84342c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Helper f84343a = new Helper();

            Helper() {
            }

            static Helper h() {
                return f84343a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength f() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueEntry b(StrongKeyStrongValueSegment strongKeyStrongValueSegment, StrongKeyStrongValueEntry strongKeyStrongValueEntry, StrongKeyStrongValueEntry strongKeyStrongValueEntry2) {
                StrongKeyStrongValueEntry strongKeyStrongValueEntryE = e(strongKeyStrongValueSegment, strongKeyStrongValueEntry.f84315a, strongKeyStrongValueEntry.f84316b, strongKeyStrongValueEntry2);
                strongKeyStrongValueEntryE.f84342c = strongKeyStrongValueEntry.f84342c;
                return strongKeyStrongValueEntryE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueEntry e(StrongKeyStrongValueSegment strongKeyStrongValueSegment, Object obj, int i3, StrongKeyStrongValueEntry strongKeyStrongValueEntry) {
                return strongKeyStrongValueEntry == null ? new StrongKeyStrongValueEntry(obj, i3) : new LinkedStrongKeyStrongValueEntry(obj, i3, strongKeyStrongValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i3) {
                return new StrongKeyStrongValueSegment(mapMakerInternalMap, i3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(StrongKeyStrongValueSegment strongKeyStrongValueSegment, StrongKeyStrongValueEntry strongKeyStrongValueEntry, Object obj) {
                strongKeyStrongValueEntry.f84342c = obj;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class LinkedStrongKeyStrongValueEntry<K, V> extends StrongKeyStrongValueEntry<K, V> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final StrongKeyStrongValueEntry f84344d;

            LinkedStrongKeyStrongValueEntry(Object obj, int i3, StrongKeyStrongValueEntry strongKeyStrongValueEntry) {
                super(obj, i3);
                this.f84344d = strongKeyStrongValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public StrongKeyStrongValueEntry b() {
                return this.f84344d;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            return this.f84342c;
        }

        private StrongKeyStrongValueEntry(Object obj, int i3) {
            super(obj, i3);
            this.f84342c = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class StrongKeyWeakValueEntry<K, V> extends AbstractStrongKeyEntry<K, V, StrongKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, StrongKeyWeakValueEntry<K, V>> {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private volatile WeakValueReference f84345c;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class Helper<K, V> implements InternalEntryHelper<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Helper f84346a = new Helper();

            Helper() {
            }

            static Helper h() {
                return f84346a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength f() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueEntry b(StrongKeyWeakValueSegment strongKeyWeakValueSegment, StrongKeyWeakValueEntry strongKeyWeakValueEntry, StrongKeyWeakValueEntry strongKeyWeakValueEntry2) {
                if (Segment.n(strongKeyWeakValueEntry)) {
                    return null;
                }
                StrongKeyWeakValueEntry strongKeyWeakValueEntryE = e(strongKeyWeakValueSegment, strongKeyWeakValueEntry.f84315a, strongKeyWeakValueEntry.f84316b, strongKeyWeakValueEntry2);
                strongKeyWeakValueEntryE.f84345c = strongKeyWeakValueEntry.f84345c.a(strongKeyWeakValueSegment.f84348h, strongKeyWeakValueEntryE);
                return strongKeyWeakValueEntryE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueEntry e(StrongKeyWeakValueSegment strongKeyWeakValueSegment, Object obj, int i3, StrongKeyWeakValueEntry strongKeyWeakValueEntry) {
                return strongKeyWeakValueEntry == null ? new StrongKeyWeakValueEntry(obj, i3) : new LinkedStrongKeyWeakValueEntry(obj, i3, strongKeyWeakValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i3) {
                return new StrongKeyWeakValueSegment(mapMakerInternalMap, i3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(StrongKeyWeakValueSegment strongKeyWeakValueSegment, StrongKeyWeakValueEntry strongKeyWeakValueEntry, Object obj) {
                WeakValueReference weakValueReference = strongKeyWeakValueEntry.f84345c;
                strongKeyWeakValueEntry.f84345c = new WeakValueReferenceImpl(strongKeyWeakValueSegment.f84348h, obj, strongKeyWeakValueEntry);
                weakValueReference.clear();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class LinkedStrongKeyWeakValueEntry<K, V> extends StrongKeyWeakValueEntry<K, V> {

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private final StrongKeyWeakValueEntry f84347d;

            LinkedStrongKeyWeakValueEntry(Object obj, int i3, StrongKeyWeakValueEntry strongKeyWeakValueEntry) {
                super(obj, i3);
                this.f84347d = strongKeyWeakValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractStrongKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public StrongKeyWeakValueEntry b() {
                return this.f84347d;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public final WeakValueReference a() {
            return this.f84345c;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            return this.f84345c.get();
        }

        private StrongKeyWeakValueEntry(Object obj, int i3) {
            super(obj, i3);
            this.f84345c = MapMakerInternalMap.k();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface StrongValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ValueIterator extends MapMakerInternalMap<K, V, E, S>.HashIterator<V> {
        ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() {
            MapMakerInternalMap.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return MapMakerInternalMap.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return MapMakerInternalMap.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return MapMakerInternalMap.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class WeakKeyDummyValueEntry<K> extends AbstractWeakKeyEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> implements StrongValueEntry<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>> {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class LinkedWeakKeyDummyValueEntry<K> extends WeakKeyDummyValueEntry<K> {

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private final WeakKeyDummyValueEntry f84352b;

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
            public WeakKeyDummyValueEntry b() {
                return this.f84352b;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.WeakKeyDummyValueEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            public /* bridge */ /* synthetic */ Object getValue() {
                return super.getValue();
            }

            private LinkedWeakKeyDummyValueEntry(ReferenceQueue referenceQueue, Object obj, int i3, WeakKeyDummyValueEntry weakKeyDummyValueEntry) {
                super(referenceQueue, obj, i3);
                this.f84352b = weakKeyDummyValueEntry;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public final MapMaker.Dummy getValue() {
            return MapMaker.Dummy.VALUE;
        }

        private WeakKeyDummyValueEntry(ReferenceQueue referenceQueue, Object obj, int i3) {
            super(referenceQueue, obj, i3);
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class Helper<K> implements InternalEntryHelper<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Helper f84351a = new Helper();

            Helper() {
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength f() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public WeakKeyDummyValueEntry b(WeakKeyDummyValueSegment weakKeyDummyValueSegment, WeakKeyDummyValueEntry weakKeyDummyValueEntry, WeakKeyDummyValueEntry weakKeyDummyValueEntry2) {
                Object key = weakKeyDummyValueEntry.getKey();
                if (key == null) {
                    return null;
                }
                return e(weakKeyDummyValueSegment, key, weakKeyDummyValueEntry.f84317a, weakKeyDummyValueEntry2);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
            public WeakKeyDummyValueEntry e(WeakKeyDummyValueSegment weakKeyDummyValueSegment, Object obj, int i3, WeakKeyDummyValueEntry weakKeyDummyValueEntry) {
                return weakKeyDummyValueEntry == null ? new WeakKeyDummyValueEntry(weakKeyDummyValueSegment.f84353h, obj, i3) : new LinkedWeakKeyDummyValueEntry(weakKeyDummyValueSegment.f84353h, obj, i3, weakKeyDummyValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public WeakKeyDummyValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i3) {
                return new WeakKeyDummyValueSegment(mapMakerInternalMap, i3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public void d(WeakKeyDummyValueSegment weakKeyDummyValueSegment, WeakKeyDummyValueEntry weakKeyDummyValueEntry, MapMaker.Dummy dummy) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class WeakKeyStrongValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyStrongValueEntry<K, V>> implements StrongValueEntry<K, V, WeakKeyStrongValueEntry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile Object f84354b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Helper f84355a = new Helper();

            Helper() {
            }

            static Helper h() {
                return f84355a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.STRONG;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength f() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueEntry b(WeakKeyStrongValueSegment weakKeyStrongValueSegment, WeakKeyStrongValueEntry weakKeyStrongValueEntry, WeakKeyStrongValueEntry weakKeyStrongValueEntry2) {
                Object key = weakKeyStrongValueEntry.getKey();
                if (key == null) {
                    return null;
                }
                WeakKeyStrongValueEntry weakKeyStrongValueEntryE = e(weakKeyStrongValueSegment, key, weakKeyStrongValueEntry.f84317a, weakKeyStrongValueEntry2);
                weakKeyStrongValueEntryE.f84354b = weakKeyStrongValueEntry.f84354b;
                return weakKeyStrongValueEntryE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueEntry e(WeakKeyStrongValueSegment weakKeyStrongValueSegment, Object obj, int i3, WeakKeyStrongValueEntry weakKeyStrongValueEntry) {
                return weakKeyStrongValueEntry == null ? new WeakKeyStrongValueEntry(weakKeyStrongValueSegment.f84357h, obj, i3) : new LinkedWeakKeyStrongValueEntry(weakKeyStrongValueSegment.f84357h, obj, i3, weakKeyStrongValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i3) {
                return new WeakKeyStrongValueSegment(mapMakerInternalMap, i3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(WeakKeyStrongValueSegment weakKeyStrongValueSegment, WeakKeyStrongValueEntry weakKeyStrongValueEntry, Object obj) {
                weakKeyStrongValueEntry.f84354b = obj;
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class LinkedWeakKeyStrongValueEntry<K, V> extends WeakKeyStrongValueEntry<K, V> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final WeakKeyStrongValueEntry f84356c;

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public WeakKeyStrongValueEntry b() {
                return this.f84356c;
            }

            private LinkedWeakKeyStrongValueEntry(ReferenceQueue referenceQueue, Object obj, int i3, WeakKeyStrongValueEntry weakKeyStrongValueEntry) {
                super(referenceQueue, obj, i3);
                this.f84356c = weakKeyStrongValueEntry;
            }
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            return this.f84354b;
        }

        private WeakKeyStrongValueEntry(ReferenceQueue referenceQueue, Object obj, int i3) {
            super(referenceQueue, obj, i3);
            this.f84354b = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class WeakKeyWeakValueEntry<K, V> extends AbstractWeakKeyEntry<K, V, WeakKeyWeakValueEntry<K, V>> implements WeakValueEntry<K, V, WeakKeyWeakValueEntry<K, V>> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private volatile WeakValueReference f84358b;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        static final class Helper<K, V> implements InternalEntryHelper<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private static final Helper f84359a = new Helper();

            Helper() {
            }

            static Helper h() {
                return f84359a;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength c() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            public Strength f() {
                return Strength.WEAK;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueEntry b(WeakKeyWeakValueSegment weakKeyWeakValueSegment, WeakKeyWeakValueEntry weakKeyWeakValueEntry, WeakKeyWeakValueEntry weakKeyWeakValueEntry2) {
                Object key = weakKeyWeakValueEntry.getKey();
                if (key == null || Segment.n(weakKeyWeakValueEntry)) {
                    return null;
                }
                WeakKeyWeakValueEntry weakKeyWeakValueEntryE = e(weakKeyWeakValueSegment, key, weakKeyWeakValueEntry.f84317a, weakKeyWeakValueEntry2);
                weakKeyWeakValueEntryE.f84358b = weakKeyWeakValueEntry.f84358b.a(weakKeyWeakValueSegment.f84362i, weakKeyWeakValueEntryE);
                return weakKeyWeakValueEntryE;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueEntry e(WeakKeyWeakValueSegment weakKeyWeakValueSegment, Object obj, int i3, WeakKeyWeakValueEntry weakKeyWeakValueEntry) {
                return weakKeyWeakValueEntry == null ? new WeakKeyWeakValueEntry(weakKeyWeakValueSegment.f84361h, obj, i3) : new LinkedWeakKeyWeakValueEntry(weakKeyWeakValueSegment.f84361h, obj, i3, weakKeyWeakValueEntry);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: j, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueSegment a(MapMakerInternalMap mapMakerInternalMap, int i3) {
                return new WeakKeyWeakValueSegment(mapMakerInternalMap, i3);
            }

            @Override // com.google.common.collect.MapMakerInternalMap.InternalEntryHelper
            /* JADX INFO: renamed from: k, reason: merged with bridge method [inline-methods] */
            public void d(WeakKeyWeakValueSegment weakKeyWeakValueSegment, WeakKeyWeakValueEntry weakKeyWeakValueEntry, Object obj) {
                WeakValueReference weakValueReference = weakKeyWeakValueEntry.f84358b;
                weakKeyWeakValueEntry.f84358b = new WeakValueReferenceImpl(weakKeyWeakValueSegment.f84362i, obj, weakKeyWeakValueEntry);
                weakValueReference.clear();
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        private static final class LinkedWeakKeyWeakValueEntry<K, V> extends WeakKeyWeakValueEntry<K, V> {

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private final WeakKeyWeakValueEntry f84360c;

            LinkedWeakKeyWeakValueEntry(ReferenceQueue referenceQueue, Object obj, int i3, WeakKeyWeakValueEntry weakKeyWeakValueEntry) {
                super(referenceQueue, obj, i3);
                this.f84360c = weakKeyWeakValueEntry;
            }

            @Override // com.google.common.collect.MapMakerInternalMap.AbstractWeakKeyEntry, com.google.common.collect.MapMakerInternalMap.InternalEntry
            /* JADX INFO: renamed from: f, reason: merged with bridge method [inline-methods] */
            public WeakKeyWeakValueEntry b() {
                return this.f84360c;
            }
        }

        WeakKeyWeakValueEntry(ReferenceQueue referenceQueue, Object obj, int i3) {
            super(referenceQueue, obj, i3);
            this.f84358b = MapMakerInternalMap.k();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueEntry
        public final WeakValueReference a() {
            return this.f84358b;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.InternalEntry
        public final Object getValue() {
            return this.f84358b.get();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface WeakValueEntry<K, V, E extends InternalEntry<K, V, E>> extends InternalEntry<K, V, E> {
        WeakValueReference a();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface WeakValueReference<K, V, E extends InternalEntry<K, V, E>> {
        WeakValueReference a(ReferenceQueue referenceQueue, InternalEntry internalEntry);

        InternalEntry c();

        void clear();

        Object get();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeakValueReferenceImpl<K, V, E extends InternalEntry<K, V, E>> extends WeakReference<V> implements WeakValueReference<K, V, E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final InternalEntry f84363a;

        WeakValueReferenceImpl(ReferenceQueue referenceQueue, Object obj, InternalEntry internalEntry) {
            super(obj, referenceQueue);
            this.f84363a = internalEntry;
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public WeakValueReference a(ReferenceQueue referenceQueue, InternalEntry internalEntry) {
            return new WeakValueReferenceImpl(referenceQueue, get(), internalEntry);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.WeakValueReference
        public InternalEntry c() {
            return this.f84363a;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class WriteThroughEntry extends AbstractMapEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f84364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f84365b;

        WriteThroughEntry(Object obj, Object obj2) {
            this.f84364a = obj;
            this.f84365b = obj2;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (this.f84364a.equals(entry.getKey()) && this.f84365b.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getKey() {
            return this.f84364a;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object getValue() {
            return this.f84365b;
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public int hashCode() {
            return this.f84364a.hashCode() ^ this.f84365b.hashCode();
        }

        @Override // com.google.common.collect.AbstractMapEntry, java.util.Map.Entry
        public Object setValue(Object obj) {
            Object objPut = MapMakerInternalMap.this.put(this.f84364a, obj);
            this.f84365b = obj;
            return objPut;
        }
    }

    private MapMakerInternalMap(MapMaker mapMaker, InternalEntryHelper internalEntryHelper) {
        this.f84303d = Math.min(mapMaker.b(), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        this.f84304f = mapMaker.d();
        this.f84305g = internalEntryHelper;
        int iMin = Math.min(mapMaker.c(), 1073741824);
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        int i6 = 1;
        while (i6 < this.f84303d) {
            i5++;
            i6 <<= 1;
        }
        this.f84301b = 32 - i5;
        this.f84300a = i6 - 1;
        this.f84302c = f(i6);
        int i7 = iMin / i6;
        while (i4 < (i6 * i7 < iMin ? i7 + 1 : i7)) {
            i4 <<= 1;
        }
        while (true) {
            Segment[] segmentArr = this.f84302c;
            if (i3 >= segmentArr.length) {
                return;
            }
            segmentArr[i3] = b(i4);
            i3++;
        }
    }

    static MapMakerInternalMap a(MapMaker mapMaker) {
        Strength strengthE = mapMaker.e();
        Strength strength = Strength.STRONG;
        if (strengthE == strength && mapMaker.f() == strength) {
            return new MapMakerInternalMap(mapMaker, StrongKeyStrongValueEntry.Helper.h());
        }
        if (mapMaker.e() == strength && mapMaker.f() == Strength.WEAK) {
            return new MapMakerInternalMap(mapMaker, StrongKeyWeakValueEntry.Helper.h());
        }
        Strength strengthE2 = mapMaker.e();
        Strength strength2 = Strength.WEAK;
        if (strengthE2 == strength2 && mapMaker.f() == strength) {
            return new MapMakerInternalMap(mapMaker, WeakKeyStrongValueEntry.Helper.h());
        }
        if (mapMaker.e() == strength2 && mapMaker.f() == strength2) {
            return new MapMakerInternalMap(mapMaker, WeakKeyWeakValueEntry.Helper.h());
        }
        throw new AssertionError();
    }

    static int i(int i3) {
        int i4 = i3 + ((i3 << 15) ^ (-12931));
        int i5 = i4 ^ (i4 >>> 10);
        int i6 = i5 + (i5 << 3);
        int i7 = i6 ^ (i6 >>> 6);
        int i8 = i7 + (i7 << 2) + (i7 << 14);
        return i8 ^ (i8 >>> 16);
    }

    static WeakValueReference k() {
        return f84299k;
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializationProxy");
    }

    Segment b(int i3) {
        return this.f84305g.a(this, i3);
    }

    InternalEntry c(Object obj) {
        if (obj == null) {
            return null;
        }
        int iE = e(obj);
        return j(iE).i(obj, iE);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        for (Segment segment : this.f84302c) {
            segment.a();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iE = e(obj);
        return j(iE).c(obj, iE);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v0 */
    /* JADX WARN: Type inference failed for: r10v1, types: [int] */
    /* JADX WARN: Type inference failed for: r10v3 */
    /* JADX WARN: Type inference failed for: r12v1, types: [java.util.concurrent.atomic.AtomicReferenceArray] */
    /* JADX WARN: Type inference failed for: r13v0 */
    /* JADX WARN: Type inference failed for: r13v1, types: [int] */
    /* JADX WARN: Type inference failed for: r13v3 */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        boolean z2 = false;
        if (obj == null) {
            return false;
        }
        Segment[] segmentArr = this.f84302c;
        long j3 = -1;
        int i3 = 0;
        while (i3 < 3) {
            int length = segmentArr.length;
            long j4 = 0;
            for (?? r10 = z2; r10 < length; r10++) {
                Segment segment = segmentArr[r10];
                int i4 = segment.f84332b;
                ?? r12 = segment.f84335f;
                for (?? r13 = z2; r13 < r12.length(); r13++) {
                    InternalEntry internalEntryB = (InternalEntry) r12.get(r13);
                    while (internalEntryB != null) {
                        Object objL = segment.l(internalEntryB);
                        boolean z3 = z2;
                        if (objL != null && l().d(obj, objL)) {
                            return true;
                        }
                        internalEntryB = internalEntryB.b();
                        z2 = z3;
                    }
                }
                j4 += (long) segment.f84333c;
                z2 = z2;
            }
            boolean z4 = z2;
            if (j4 == j3) {
                return z4;
            }
            i3++;
            j3 = j4;
            z2 = z4;
        }
        return z2;
    }

    Object d(InternalEntry internalEntry) {
        if (internalEntry.getKey() == null) {
            return null;
        }
        return internalEntry.getValue();
    }

    int e(Object obj) {
        return i(this.f84304f.e(obj));
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.f84308j;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.f84308j = entrySet;
        return entrySet;
    }

    final Segment[] f(int i3) {
        return new Segment[i3];
    }

    void g(InternalEntry internalEntry) {
        int iC = internalEntry.c();
        j(iC).u(internalEntry, iC);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iE = e(obj);
        return j(iE).h(obj, iE);
    }

    void h(WeakValueReference weakValueReference) {
        InternalEntry internalEntryC = weakValueReference.c();
        int iC = internalEntryC.c();
        j(iC).v(internalEntryC.getKey(), iC, weakValueReference);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment[] segmentArr = this.f84302c;
        long j3 = 0;
        for (int i3 = 0; i3 < segmentArr.length; i3++) {
            if (segmentArr[i3].f84332b != 0) {
                return false;
            }
            j3 += (long) segmentArr[i3].f84333c;
        }
        if (j3 == 0) {
            return true;
        }
        for (int i4 = 0; i4 < segmentArr.length; i4++) {
            if (segmentArr[i4].f84332b != 0) {
                return false;
            }
            j3 -= (long) segmentArr[i4].f84333c;
        }
        return j3 == 0;
    }

    Segment j(int i3) {
        return this.f84302c[(i3 >>> this.f84301b) & this.f84300a];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f84306h;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.f84306h = keySet;
        return keySet;
    }

    Equivalence l() {
        return this.f84305g.c().b();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Preconditions.t(obj);
        Preconditions.t(obj2);
        int iE = e(obj);
        return j(iE).t(obj, iE, obj2, false);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void putAll(Map map) {
        for (Map.Entry<K, V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object putIfAbsent(Object obj, Object obj2) {
        Preconditions.t(obj);
        Preconditions.t(obj2);
        int iE = e(obj);
        return j(iE).t(obj, iE, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iE = e(obj);
        return j(iE).w(obj, iE);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object obj, Object obj2, Object obj3) {
        Preconditions.t(obj);
        Preconditions.t(obj3);
        if (obj2 == null) {
            return false;
        }
        int iE = e(obj);
        return j(iE).A(obj, iE, obj2, obj3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        long j3 = 0;
        for (Segment segment : this.f84302c) {
            j3 += (long) segment.f84332b;
        }
        return Ints.m(j3);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.f84307i;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.f84307i = values;
        return values;
    }

    Object writeReplace() {
        return new SerializationProxy(this.f84305g.f(), this.f84305g.c(), this.f84304f, this.f84305g.c().b(), this.f84303d, this);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iE = e(obj);
        return j(iE).x(obj, iE, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        Preconditions.t(obj);
        Preconditions.t(obj2);
        int iE = e(obj);
        return j(iE).z(obj, iE, obj2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class Segment<K, V, E extends InternalEntry<K, V, E>, S extends Segment<K, V, E, S>> extends ReentrantLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final MapMakerInternalMap f84331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile int f84332b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        int f84333c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f84334d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile AtomicReferenceArray f84335f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final AtomicInteger f84336g = new AtomicInteger();

        Segment(MapMakerInternalMap mapMakerInternalMap, int i3) {
            this.f84331a = mapMakerInternalMap;
            m(q(i3));
        }

        static boolean n(InternalEntry internalEntry) {
            return internalEntry.getValue() == null;
        }

        boolean A(Object obj, int i3, Object obj2, Object obj3) {
            lock();
            try {
                s();
                AtomicReferenceArray atomicReferenceArray = this.f84335f;
                int length = (atomicReferenceArray.length() - 1) & i3;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntryB = internalEntry; internalEntryB != null; internalEntryB = internalEntryB.b()) {
                    Object key = internalEntryB.getKey();
                    if (internalEntryB.c() == i3 && key != null && this.f84331a.f84304f.d(obj, key)) {
                        Object value = internalEntryB.getValue();
                        if (value != null) {
                            if (!this.f84331a.l().d(obj2, value)) {
                                return false;
                            }
                            this.f84333c++;
                            E(internalEntryB, obj3);
                            return true;
                        }
                        if (n(internalEntryB)) {
                            this.f84333c++;
                            InternalEntry internalEntryY = y(internalEntry, internalEntryB);
                            int i4 = this.f84332b - 1;
                            atomicReferenceArray.set(length, internalEntryY);
                            this.f84332b = i4;
                        }
                        return false;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        void B() {
            C();
        }

        void C() {
            if (tryLock()) {
                try {
                    p();
                    this.f84336g.set(0);
                } finally {
                    unlock();
                }
            }
        }

        abstract Segment D();

        void E(InternalEntry internalEntry, Object obj) {
            this.f84331a.f84305g.d(D(), internalEntry, obj);
        }

        void F() {
            if (tryLock()) {
                try {
                    p();
                } finally {
                    unlock();
                }
            }
        }

        void a() {
            if (this.f84332b != 0) {
                lock();
                try {
                    AtomicReferenceArray atomicReferenceArray = this.f84335f;
                    for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                        atomicReferenceArray.set(i3, null);
                    }
                    o();
                    this.f84336g.set(0);
                    this.f84333c++;
                    this.f84332b = 0;
                    unlock();
                } catch (Throwable th) {
                    unlock();
                    throw th;
                }
            }
        }

        void b(ReferenceQueue referenceQueue) {
            while (referenceQueue.poll() != null) {
            }
        }

        boolean c(Object obj, int i3) {
            try {
                boolean z2 = false;
                if (this.f84332b == 0) {
                    return false;
                }
                InternalEntry internalEntryK = k(obj, i3);
                if (internalEntryK != null) {
                    if (internalEntryK.getValue() != null) {
                        z2 = true;
                    }
                }
                return z2;
            } finally {
                r();
            }
        }

        InternalEntry d(InternalEntry internalEntry, InternalEntry internalEntry2) {
            return this.f84331a.f84305g.b(D(), internalEntry, internalEntry2);
        }

        void e(ReferenceQueue referenceQueue) {
            int i3 = 0;
            do {
                Object objPoll = referenceQueue.poll();
                if (objPoll == null) {
                    return;
                }
                this.f84331a.g((InternalEntry) objPoll);
                i3++;
            } while (i3 != 16);
        }

        void f(ReferenceQueue referenceQueue) {
            int i3 = 0;
            do {
                Object objPoll = referenceQueue.poll();
                if (objPoll == null) {
                    return;
                }
                this.f84331a.h((WeakValueReference) objPoll);
                i3++;
            } while (i3 != 16);
        }

        void g() {
            AtomicReferenceArray atomicReferenceArray = this.f84335f;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i3 = this.f84332b;
            AtomicReferenceArray atomicReferenceArrayQ = q(length << 1);
            this.f84334d = (atomicReferenceArrayQ.length() * 3) / 4;
            int length2 = atomicReferenceArrayQ.length() - 1;
            for (int i4 = 0; i4 < length; i4++) {
                InternalEntry internalEntryB = (InternalEntry) atomicReferenceArray.get(i4);
                if (internalEntryB != null) {
                    InternalEntry internalEntryB2 = internalEntryB.b();
                    int iC = internalEntryB.c() & length2;
                    if (internalEntryB2 == null) {
                        atomicReferenceArrayQ.set(iC, internalEntryB);
                    } else {
                        InternalEntry internalEntry = internalEntryB;
                        while (internalEntryB2 != null) {
                            int iC2 = internalEntryB2.c() & length2;
                            if (iC2 != iC) {
                                internalEntry = internalEntryB2;
                                iC = iC2;
                            }
                            internalEntryB2 = internalEntryB2.b();
                        }
                        atomicReferenceArrayQ.set(iC, internalEntry);
                        while (internalEntryB != internalEntry) {
                            int iC3 = internalEntryB.c() & length2;
                            InternalEntry internalEntryD = d(internalEntryB, (InternalEntry) atomicReferenceArrayQ.get(iC3));
                            if (internalEntryD != null) {
                                atomicReferenceArrayQ.set(iC3, internalEntryD);
                            } else {
                                i3--;
                            }
                            internalEntryB = internalEntryB.b();
                        }
                    }
                }
            }
            this.f84335f = atomicReferenceArrayQ;
            this.f84332b = i3;
        }

        Object h(Object obj, int i3) {
            try {
                InternalEntry internalEntryK = k(obj, i3);
                if (internalEntryK == null) {
                    r();
                    return null;
                }
                Object value = internalEntryK.getValue();
                if (value == null) {
                    F();
                }
                return value;
            } finally {
                r();
            }
        }

        InternalEntry i(Object obj, int i3) {
            if (this.f84332b == 0) {
                return null;
            }
            for (InternalEntry internalEntryJ = j(i3); internalEntryJ != null; internalEntryJ = internalEntryJ.b()) {
                if (internalEntryJ.c() == i3) {
                    Object key = internalEntryJ.getKey();
                    if (key == null) {
                        F();
                    } else if (this.f84331a.f84304f.d(obj, key)) {
                        return internalEntryJ;
                    }
                }
            }
            return null;
        }

        InternalEntry j(int i3) {
            return (InternalEntry) this.f84335f.get(i3 & (r0.length() - 1));
        }

        InternalEntry k(Object obj, int i3) {
            return i(obj, i3);
        }

        Object l(InternalEntry internalEntry) {
            if (internalEntry.getKey() == null) {
                F();
                return null;
            }
            Object value = internalEntry.getValue();
            if (value != null) {
                return value;
            }
            F();
            return null;
        }

        void m(AtomicReferenceArray atomicReferenceArray) {
            this.f84334d = (atomicReferenceArray.length() * 3) / 4;
            this.f84335f = atomicReferenceArray;
        }

        AtomicReferenceArray q(int i3) {
            return new AtomicReferenceArray(i3);
        }

        void r() {
            if ((this.f84336g.incrementAndGet() & 63) == 0) {
                B();
            }
        }

        void s() {
            C();
        }

        Object t(Object obj, int i3, Object obj2, boolean z2) {
            lock();
            try {
                s();
                int i4 = this.f84332b + 1;
                if (i4 > this.f84334d) {
                    g();
                    i4 = this.f84332b + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.f84335f;
                int length = (atomicReferenceArray.length() - 1) & i3;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntryB = internalEntry; internalEntryB != null; internalEntryB = internalEntryB.b()) {
                    Object key = internalEntryB.getKey();
                    if (internalEntryB.c() == i3 && key != null && this.f84331a.f84304f.d(obj, key)) {
                        Object value = internalEntryB.getValue();
                        if (value == null) {
                            this.f84333c++;
                            E(internalEntryB, obj2);
                            this.f84332b = this.f84332b;
                            unlock();
                            return null;
                        }
                        if (z2) {
                            unlock();
                            return value;
                        }
                        this.f84333c++;
                        E(internalEntryB, obj2);
                        unlock();
                        return value;
                    }
                }
                this.f84333c++;
                InternalEntry internalEntryE = this.f84331a.f84305g.e(D(), obj, i3, internalEntry);
                E(internalEntryE, obj2);
                atomicReferenceArray.set(length, internalEntryE);
                this.f84332b = i4;
                unlock();
                return null;
            } catch (Throwable th) {
                unlock();
                throw th;
            }
        }

        boolean u(InternalEntry internalEntry, int i3) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.f84335f;
                int length = i3 & (atomicReferenceArray.length() - 1);
                InternalEntry internalEntry2 = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntryB = internalEntry2; internalEntryB != null; internalEntryB = internalEntryB.b()) {
                    if (internalEntryB == internalEntry) {
                        this.f84333c++;
                        InternalEntry internalEntryY = y(internalEntry2, internalEntryB);
                        int i4 = this.f84332b - 1;
                        atomicReferenceArray.set(length, internalEntryY);
                        this.f84332b = i4;
                        return true;
                    }
                }
                unlock();
                return false;
            } finally {
                unlock();
            }
        }

        boolean v(Object obj, int i3, WeakValueReference weakValueReference) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.f84335f;
                int length = (atomicReferenceArray.length() - 1) & i3;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntryB = internalEntry; internalEntryB != null; internalEntryB = internalEntryB.b()) {
                    Object key = internalEntryB.getKey();
                    if (internalEntryB.c() == i3 && key != null && this.f84331a.f84304f.d(obj, key)) {
                        if (((WeakValueEntry) internalEntryB).a() != weakValueReference) {
                            return false;
                        }
                        this.f84333c++;
                        InternalEntry internalEntryY = y(internalEntry, internalEntryB);
                        int i4 = this.f84332b - 1;
                        atomicReferenceArray.set(length, internalEntryY);
                        this.f84332b = i4;
                        return true;
                    }
                }
                return false;
            } finally {
                unlock();
            }
        }

        Object w(Object obj, int i3) {
            lock();
            try {
                s();
                AtomicReferenceArray atomicReferenceArray = this.f84335f;
                int length = (atomicReferenceArray.length() - 1) & i3;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntryB = internalEntry; internalEntryB != null; internalEntryB = internalEntryB.b()) {
                    Object key = internalEntryB.getKey();
                    if (internalEntryB.c() == i3 && key != null && this.f84331a.f84304f.d(obj, key)) {
                        Object value = internalEntryB.getValue();
                        if (value == null && !n(internalEntryB)) {
                            return null;
                        }
                        this.f84333c++;
                        InternalEntry internalEntryY = y(internalEntry, internalEntryB);
                        int i4 = this.f84332b - 1;
                        atomicReferenceArray.set(length, internalEntryY);
                        this.f84332b = i4;
                        return value;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        /* JADX WARN: Code restructure failed: missing block: B:12:0x003d, code lost:
        
            if (r8.f84331a.l().d(r11, r4.getValue()) == false) goto L14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
        
            r5 = true;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0045, code lost:
        
            if (n(r4) == false) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        
            r8.f84333c++;
            r9 = y(r3, r4);
            r10 = r8.f84332b - 1;
            r0.set(r1, r9);
            r8.f84332b = r10;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x005b, code lost:
        
            return r5;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x0061, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean x(java.lang.Object r9, int r10, java.lang.Object r11) {
            /*
                r8 = this;
                r8.lock()
                r8.s()     // Catch: java.lang.Throwable -> L5c
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r8.f84335f     // Catch: java.lang.Throwable -> L5c
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L5c
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r10
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$InternalEntry r3 = (com.google.common.collect.MapMakerInternalMap.InternalEntry) r3     // Catch: java.lang.Throwable -> L5c
                r4 = r3
            L16:
                r5 = 0
                if (r4 == 0) goto L67
                java.lang.Object r6 = r4.getKey()     // Catch: java.lang.Throwable -> L5c
                int r7 = r4.c()     // Catch: java.lang.Throwable -> L5c
                if (r7 != r10) goto L62
                if (r6 == 0) goto L62
                com.google.common.collect.MapMakerInternalMap r7 = r8.f84331a     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence r7 = r7.f84304f     // Catch: java.lang.Throwable -> L5c
                boolean r6 = r7.d(r9, r6)     // Catch: java.lang.Throwable -> L5c
                if (r6 == 0) goto L62
                java.lang.Object r9 = r4.getValue()     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap r10 = r8.f84331a     // Catch: java.lang.Throwable -> L5c
                com.google.common.base.Equivalence r10 = r10.l()     // Catch: java.lang.Throwable -> L5c
                boolean r9 = r10.d(r11, r9)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L41
                r5 = r2
                goto L47
            L41:
                boolean r9 = n(r4)     // Catch: java.lang.Throwable -> L5c
                if (r9 == 0) goto L5e
            L47:
                int r9 = r8.f84333c     // Catch: java.lang.Throwable -> L5c
                int r9 = r9 + r2
                r8.f84333c = r9     // Catch: java.lang.Throwable -> L5c
                com.google.common.collect.MapMakerInternalMap$InternalEntry r9 = r8.y(r3, r4)     // Catch: java.lang.Throwable -> L5c
                int r10 = r8.f84332b     // Catch: java.lang.Throwable -> L5c
                int r10 = r10 - r2
                r0.set(r1, r9)     // Catch: java.lang.Throwable -> L5c
                r8.f84332b = r10     // Catch: java.lang.Throwable -> L5c
                r8.unlock()
                return r5
            L5c:
                r9 = move-exception
                goto L6b
            L5e:
                r8.unlock()
                return r5
            L62:
                com.google.common.collect.MapMakerInternalMap$InternalEntry r4 = r4.b()     // Catch: java.lang.Throwable -> L5c
                goto L16
            L67:
                r8.unlock()
                return r5
            L6b:
                r8.unlock()
                throw r9
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.collect.MapMakerInternalMap.Segment.x(java.lang.Object, int, java.lang.Object):boolean");
        }

        InternalEntry y(InternalEntry internalEntry, InternalEntry internalEntry2) {
            int i3 = this.f84332b;
            InternalEntry internalEntryB = internalEntry2.b();
            while (internalEntry != internalEntry2) {
                InternalEntry internalEntryD = d(internalEntry, internalEntryB);
                if (internalEntryD != null) {
                    internalEntryB = internalEntryD;
                } else {
                    i3--;
                }
                internalEntry = internalEntry.b();
            }
            this.f84332b = i3;
            return internalEntryB;
        }

        Object z(Object obj, int i3, Object obj2) {
            lock();
            try {
                s();
                AtomicReferenceArray atomicReferenceArray = this.f84335f;
                int length = (atomicReferenceArray.length() - 1) & i3;
                InternalEntry internalEntry = (InternalEntry) atomicReferenceArray.get(length);
                for (InternalEntry internalEntryB = internalEntry; internalEntryB != null; internalEntryB = internalEntryB.b()) {
                    Object key = internalEntryB.getKey();
                    if (internalEntryB.c() == i3 && key != null && this.f84331a.f84304f.d(obj, key)) {
                        Object value = internalEntryB.getValue();
                        if (value != null) {
                            this.f84333c++;
                            E(internalEntryB, obj2);
                            return value;
                        }
                        if (n(internalEntryB)) {
                            this.f84333c++;
                            InternalEntry internalEntryY = y(internalEntry, internalEntryB);
                            int i4 = this.f84332b - 1;
                            atomicReferenceArray.set(length, internalEntryY);
                            this.f84332b = i4;
                        }
                        return null;
                    }
                }
                return null;
            } finally {
                unlock();
            }
        }

        void o() {
        }

        void p() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StrongKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, StrongKeyDummyValueEntry<K>, StrongKeyDummyValueSegment<K>> {
        StrongKeyDummyValueSegment(MapMakerInternalMap mapMakerInternalMap, int i3) {
            super(mapMakerInternalMap, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public StrongKeyDummyValueSegment D() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StrongKeyStrongValueSegment<K, V> extends Segment<K, V, StrongKeyStrongValueEntry<K, V>, StrongKeyStrongValueSegment<K, V>> {
        StrongKeyStrongValueSegment(MapMakerInternalMap mapMakerInternalMap, int i3) {
            super(mapMakerInternalMap, i3);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* JADX INFO: renamed from: G, reason: merged with bridge method [inline-methods] */
        public StrongKeyStrongValueSegment D() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StrongKeyWeakValueSegment<K, V> extends Segment<K, V, StrongKeyWeakValueEntry<K, V>, StrongKeyWeakValueSegment<K, V>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ReferenceQueue f84348h;

        StrongKeyWeakValueSegment(MapMakerInternalMap mapMakerInternalMap, int i3) {
            super(mapMakerInternalMap, i3);
            this.f84348h = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void o() {
            b(this.f84348h);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void p() {
            f(this.f84348h);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public StrongKeyWeakValueSegment D() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeakKeyDummyValueSegment<K> extends Segment<K, MapMaker.Dummy, WeakKeyDummyValueEntry<K>, WeakKeyDummyValueSegment<K>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ReferenceQueue f84353h;

        WeakKeyDummyValueSegment(MapMakerInternalMap mapMakerInternalMap, int i3) {
            super(mapMakerInternalMap, i3);
            this.f84353h = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void o() {
            b(this.f84353h);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void p() {
            e(this.f84353h);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public WeakKeyDummyValueSegment D() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeakKeyStrongValueSegment<K, V> extends Segment<K, V, WeakKeyStrongValueEntry<K, V>, WeakKeyStrongValueSegment<K, V>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ReferenceQueue f84357h;

        WeakKeyStrongValueSegment(MapMakerInternalMap mapMakerInternalMap, int i3) {
            super(mapMakerInternalMap, i3);
            this.f84357h = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void o() {
            b(this.f84357h);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void p() {
            e(this.f84357h);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* JADX INFO: renamed from: H, reason: merged with bridge method [inline-methods] */
        public WeakKeyStrongValueSegment D() {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeakKeyWeakValueSegment<K, V> extends Segment<K, V, WeakKeyWeakValueEntry<K, V>, WeakKeyWeakValueSegment<K, V>> {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private final ReferenceQueue f84361h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private final ReferenceQueue f84362i;

        WeakKeyWeakValueSegment(MapMakerInternalMap mapMakerInternalMap, int i3) {
            super(mapMakerInternalMap, i3);
            this.f84361h = new ReferenceQueue();
            this.f84362i = new ReferenceQueue();
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void o() {
            b(this.f84361h);
        }

        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        void p() {
            e(this.f84361h);
            f(this.f84362i);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.google.common.collect.MapMakerInternalMap.Segment
        /* JADX INFO: renamed from: I, reason: merged with bridge method [inline-methods] */
        public WeakKeyWeakValueSegment D() {
            return this;
        }
    }
}
