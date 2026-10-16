package com.google.common.cache;

import com.facebook.internal.NativeProtocol;
import com.google.common.base.Equivalence;
import com.google.common.base.Function;
import com.google.common.base.Preconditions;
import com.google.common.base.Stopwatch;
import com.google.common.base.Ticker;
import com.google.common.cache.AbstractCache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LocalCache;
import com.google.common.collect.AbstractSequentialIterator;
import com.google.common.collect.ImmutableSet;
import com.google.common.primitives.Ints;
import com.google.common.util.concurrent.ExecutionError;
import com.google.common.util.concurrent.Futures;
import com.google.common.util.concurrent.ListenableFuture;
import com.google.common.util.concurrent.MoreExecutors;
import com.google.common.util.concurrent.SettableFuture;
import com.google.common.util.concurrent.UncheckedExecutionException;
import com.google.common.util.concurrent.Uninterruptibles;
import java.io.IOException;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.lang.ref.ReferenceQueue;
import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;
import java.util.AbstractCollection;
import java.util.AbstractMap;
import java.util.AbstractQueue;
import java.util.AbstractSet;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
class LocalCache<K, V> extends AbstractMap<K, V> implements ConcurrentMap<K, V> {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    static final Logger f83499x = Logger.getLogger(LocalCache.class.getName());

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    static final ValueReference f83500y = new ValueReference<Object, Object>() { // from class: com.google.common.cache.LocalCache.1
        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean a() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return 0;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry c() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object f() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void d(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference e(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }
    };

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    static final Queue f83501z = new AbstractQueue<Object>() { // from class: com.google.common.cache.LocalCache.2
        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return ImmutableSet.z().iterator();
        }

        @Override // java.util.Queue
        public boolean offer(Object obj) {
            return true;
        }

        @Override // java.util.Queue
        public Object peek() {
            return null;
        }

        @Override // java.util.Queue
        public Object poll() {
            return null;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return 0;
        }
    };

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final int f83502a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final int f83503b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final Segment[] f83504c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final int f83505d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final Equivalence f83506f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final Equivalence f83507g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final Strength f83508h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final Strength f83509i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    final long f83510j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    final Weigher f83511k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    final long f83512l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    final long f83513m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    final long f83514n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    final Queue f83515o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    final RemovalListener f83516p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    final Ticker f83517q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    final EntryFactory f83518r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    final AbstractCache.StatsCounter f83519s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    final CacheLoader f83520t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    Set f83521u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    Collection f83522v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    Set f83523w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    abstract class AbstractCacheSet<T> extends AbstractSet<T> {
        AbstractCacheSet() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public void clear() throws Throwable {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public int size() {
            return LocalCache.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class AbstractReferenceEntry<K, V> implements ReferenceEntry<K, V> {
        AbstractReferenceEntry() {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference a() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry b() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int c() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry d() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry e() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry f() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void g(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry h() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void i(ValueReference valueReference) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long j() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void k(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long l() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void m(long j3) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void n(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class AccessQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ReferenceEntry f83525a = new AbstractReferenceEntry<K, V>() { // from class: com.google.common.cache.LocalCache.AccessQueue.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            ReferenceEntry f83526a = this;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            ReferenceEntry f83527b = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry d() {
                return this.f83527b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry f() {
                return this.f83526a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void g(ReferenceEntry referenceEntry) {
                this.f83527b = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long l() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void n(ReferenceEntry referenceEntry) {
                this.f83526a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void k(long j3) {
            }
        };

        AccessQueue() {
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(ReferenceEntry referenceEntry) {
            LocalCache.a(referenceEntry.d(), referenceEntry.f());
            LocalCache.a(this.f83525a.d(), referenceEntry);
            LocalCache.a(referenceEntry, this.f83525a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReferenceEntry peek() {
            ReferenceEntry referenceEntryF = this.f83525a.f();
            if (referenceEntryF == this.f83525a) {
                return null;
            }
            return referenceEntryF;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry referenceEntryF = this.f83525a.f();
            while (true) {
                ReferenceEntry referenceEntry = this.f83525a;
                if (referenceEntryF == referenceEntry) {
                    referenceEntry.n(referenceEntry);
                    ReferenceEntry referenceEntry2 = this.f83525a;
                    referenceEntry2.g(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry referenceEntryF2 = referenceEntryF.f();
                    LocalCache.q(referenceEntryF);
                    referenceEntryF = referenceEntryF2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).f() != NullEntry.INSTANCE;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ReferenceEntry poll() {
            ReferenceEntry referenceEntryF = this.f83525a.f();
            if (referenceEntryF == this.f83525a) {
                return null;
            }
            remove(referenceEntryF);
            return referenceEntryF;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f83525a.f() == this.f83525a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: com.google.common.cache.LocalCache.AccessQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public ReferenceEntry a(ReferenceEntry referenceEntry) {
                    ReferenceEntry referenceEntryF = referenceEntry.f();
                    if (referenceEntryF == AccessQueue.this.f83525a) {
                        return null;
                    }
                    return referenceEntryF;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry referenceEntryD = referenceEntry.d();
            ReferenceEntry referenceEntryF = referenceEntry.f();
            LocalCache.a(referenceEntryD, referenceEntryF);
            LocalCache.q(referenceEntry);
            return referenceEntryF != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i3 = 0;
            for (ReferenceEntry referenceEntryF = this.f83525a.f(); referenceEntryF != this.f83525a; referenceEntryF = referenceEntryF.f()) {
                i3++;
            }
            return i3;
        }
    }

    /* JADX WARN: Enum visitor error
    jadx.core.utils.exceptions.JadxRuntimeException: Can't remove SSA var: r0v0 com.google.common.cache.LocalCache$EntryFactory, still in use, count: 1, list:
      (r0v0 com.google.common.cache.LocalCache$EntryFactory) from 0x005a: FILLED_NEW_ARRAY 
      (r0v0 com.google.common.cache.LocalCache$EntryFactory)
      (r1v1 com.google.common.cache.LocalCache$EntryFactory)
      (r3v1 com.google.common.cache.LocalCache$EntryFactory)
      (r5v1 com.google.common.cache.LocalCache$EntryFactory)
      (r7v1 com.google.common.cache.LocalCache$EntryFactory)
      (r9v1 com.google.common.cache.LocalCache$EntryFactory)
      (r11v1 com.google.common.cache.LocalCache$EntryFactory)
      (r13v1 com.google.common.cache.LocalCache$EntryFactory)
     A[WRAPPED] (LINE:91) elemType: com.google.common.cache.LocalCache$EntryFactory
    	at jadx.core.utils.InsnRemover.removeSsaVar(InsnRemover.java:162)
    	at jadx.core.utils.InsnRemover.unbindResult(InsnRemover.java:127)
    	at jadx.core.utils.InsnRemover.lambda$unbindInsns$1(InsnRemover.java:99)
    	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
    	at jadx.core.utils.InsnRemover.unbindInsns(InsnRemover.java:98)
    	at jadx.core.utils.InsnRemover.removeAllAndUnbind(InsnRemover.java:252)
    	at jadx.core.dex.visitors.EnumVisitor.convertToEnum(EnumVisitor.java:180)
    	at jadx.core.dex.visitors.EnumVisitor.visit(EnumVisitor.java:100)
     */
    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static abstract class EntryFactory {
        STRONG { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new StrongEntry(obj, i3, referenceEntry);
            }
        },
        STRONG_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                b(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new StrongAccessEntry(obj, i3, referenceEntry);
            }
        },
        STRONG_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                d(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new StrongWriteEntry(obj, i3, referenceEntry);
            }
        },
        STRONG_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                b(referenceEntry, referenceEntryC);
                d(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new StrongAccessWriteEntry(obj, i3, referenceEntry);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new WeakEntry(segment.f83580i, obj, i3, referenceEntry);
            }
        },
        WEAK_ACCESS { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                b(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new WeakAccessEntry(segment.f83580i, obj, i3, referenceEntry);
            }
        },
        WEAK_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                d(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new WeakWriteEntry(segment.f83580i, obj, i3, referenceEntry);
            }
        },
        WEAK_ACCESS_WRITE { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                b(referenceEntry, referenceEntryC);
                d(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new WeakAccessWriteEntry(segment.f83580i, obj, i3, referenceEntry);
            }
        };


        /* JADX INFO: renamed from: j, reason: collision with root package name */
        static final EntryFactory[] f83538j = {new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.1
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new StrongEntry(obj, i3, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.2
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                b(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new StrongAccessEntry(obj, i3, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.3
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                d(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new StrongWriteEntry(obj, i3, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.4
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                b(referenceEntry, referenceEntryC);
                d(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new StrongAccessWriteEntry(obj, i3, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.5
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new WeakEntry(segment.f83580i, obj, i3, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.6
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                b(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new WeakAccessEntry(segment.f83580i, obj, i3, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.7
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                d(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new WeakWriteEntry(segment.f83580i, obj, i3, referenceEntry);
            }
        }, new EntryFactory() { // from class: com.google.common.cache.LocalCache.EntryFactory.8
            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
                ReferenceEntry referenceEntryC = super.c(segment, referenceEntry, referenceEntry2, obj);
                b(referenceEntry, referenceEntryC);
                d(referenceEntry, referenceEntryC);
                return referenceEntryC;
            }

            @Override // com.google.common.cache.LocalCache.EntryFactory
            ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry) {
                return new WeakAccessWriteEntry(segment.f83580i, obj, i3, referenceEntry);
            }
        }};

        static {
        }

        private EntryFactory() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        static EntryFactory e(Strength strength, boolean z2, boolean z3) {
            return f83538j[(strength == Strength.WEAK ? (char) 4 : (char) 0) | (z2 ? 1 : 0) | (z3 ? 2 : 0)];
        }

        public static EntryFactory valueOf(String str) {
            return (EntryFactory) Enum.valueOf(EntryFactory.class, str);
        }

        public static EntryFactory[] values() {
            return (EntryFactory[]) f83539k.clone();
        }

        void b(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            referenceEntry2.k(referenceEntry.l());
            LocalCache.a(referenceEntry.d(), referenceEntry2);
            LocalCache.a(referenceEntry2, referenceEntry.f());
            LocalCache.q(referenceEntry);
        }

        ReferenceEntry c(Segment segment, ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj) {
            return f(segment, obj, referenceEntry.c(), referenceEntry2);
        }

        void d(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            referenceEntry2.m(referenceEntry.j());
            LocalCache.b(referenceEntry.h(), referenceEntry2);
            LocalCache.b(referenceEntry2, referenceEntry.e());
            LocalCache.r(referenceEntry);
        }

        abstract ReferenceEntry f(Segment segment, Object obj, int i3, ReferenceEntry referenceEntry);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class EntryIterator extends LocalCache<K, V>.HashIterator<Map.Entry<K, V>> {
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
    final class EntrySet extends LocalCache<K, V>.AbstractCacheSet<Map.Entry<K, V>> {
        EntrySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            Map.Entry entry;
            Object key;
            Object obj2;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && (obj2 = LocalCache.this.get(key)) != null && LocalCache.this.f83507g.d(entry.getValue(), obj2);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new EntryIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            Map.Entry entry;
            Object key;
            return (obj instanceof Map.Entry) && (key = (entry = (Map.Entry) obj).getKey()) != null && LocalCache.this.remove(key, entry.getValue());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    abstract class HashIterator<T> implements Iterator<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f83542a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        int f83543b = -1;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        Segment f83544c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        AtomicReferenceArray f83545d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ReferenceEntry f83546f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        WriteThroughEntry f83547g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        WriteThroughEntry f83548h;

        HashIterator() {
            this.f83542a = LocalCache.this.f83504c.length - 1;
            a();
        }

        final void a() {
            this.f83547g = null;
            if (d() || e()) {
                return;
            }
            while (true) {
                int i3 = this.f83542a;
                if (i3 < 0) {
                    return;
                }
                Segment[] segmentArr = LocalCache.this.f83504c;
                this.f83542a = i3 - 1;
                Segment segment = segmentArr[i3];
                this.f83544c = segment;
                if (segment.f83574b != 0) {
                    this.f83545d = this.f83544c.f83578g;
                    this.f83543b = r0.length() - 1;
                    if (e()) {
                        return;
                    }
                }
            }
        }

        boolean b(ReferenceEntry referenceEntry) {
            try {
                long jA = LocalCache.this.f83517q.a();
                Object key = referenceEntry.getKey();
                Object objJ = LocalCache.this.j(referenceEntry, jA);
                if (objJ == null) {
                    this.f83544c.F();
                    return false;
                }
                this.f83547g = new WriteThroughEntry(key, objJ);
                this.f83544c.F();
                return true;
            } catch (Throwable th) {
                this.f83544c.F();
                throw th;
            }
        }

        WriteThroughEntry c() {
            WriteThroughEntry writeThroughEntry = this.f83547g;
            if (writeThroughEntry == null) {
                throw new NoSuchElementException();
            }
            this.f83548h = writeThroughEntry;
            a();
            return this.f83548h;
        }

        boolean d() {
            ReferenceEntry referenceEntry = this.f83546f;
            if (referenceEntry == null) {
                return false;
            }
            while (true) {
                this.f83546f = referenceEntry.b();
                ReferenceEntry referenceEntry2 = this.f83546f;
                if (referenceEntry2 == null) {
                    return false;
                }
                if (b(referenceEntry2)) {
                    return true;
                }
                referenceEntry = this.f83546f;
            }
        }

        boolean e() {
            while (true) {
                int i3 = this.f83543b;
                if (i3 < 0) {
                    return false;
                }
                AtomicReferenceArray atomicReferenceArray = this.f83545d;
                this.f83543b = i3 - 1;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(i3);
                this.f83546f = referenceEntry;
                if (referenceEntry != null && (b(referenceEntry) || d())) {
                    return true;
                }
            }
        }

        @Override // java.util.Iterator
        public boolean hasNext() {
            return this.f83547g != null;
        }

        @Override // java.util.Iterator
        public void remove() {
            Preconditions.z(this.f83548h != null);
            LocalCache.this.remove(this.f83548h.getKey());
            this.f83548h = null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class KeyIterator extends LocalCache<K, V>.HashIterator<K> {
        KeyIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getKey();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class KeySet extends LocalCache<K, V>.AbstractCacheSet<K> {
        KeySet() {
            super();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean contains(Object obj) {
            return LocalCache.this.containsKey(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return new KeyIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean remove(Object obj) {
            return LocalCache.this.remove(obj) != null;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class LoadingSerializationProxy<K, V> extends ManualSerializationProxy<K, V> implements LoadingCache<K, V>, Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        transient LoadingCache f83552o;

        LoadingSerializationProxy(LocalCache localCache) {
            super(localCache);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f83552o = S1().b(this.f83569m);
        }

        private Object readResolve() {
            return this.f83552o;
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public Object apply(Object obj) {
            return this.f83552o.apply(obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LoadingValueReference<K, V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        volatile ValueReference f83553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final SettableFuture f83554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Stopwatch f83555c;

        public LoadingValueReference() {
            this(LocalCache.C());
        }

        public static /* synthetic */ Object g(LoadingValueReference loadingValueReference, Object obj) {
            loadingValueReference.l(obj);
            return obj;
        }

        private ListenableFuture i(Throwable th) {
            return Futures.e(th);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean a() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return this.f83553a.b();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry c() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void d(Object obj) {
            if (obj != null) {
                l(obj);
            } else {
                this.f83553a = LocalCache.C();
            }
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object f() {
            return Uninterruptibles.a(this.f83554b);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return this.f83553a.get();
        }

        public long h() {
            return this.f83555c.e(TimeUnit.NANOSECONDS);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return this.f83553a.isActive();
        }

        public ValueReference j() {
            return this.f83553a;
        }

        public ListenableFuture k(Object obj, CacheLoader cacheLoader) {
            try {
                this.f83555c.i();
                Object obj2 = this.f83553a.get();
                if (obj2 == null) {
                    Object objA = cacheLoader.a(obj);
                    return l(objA) ? this.f83554b : Futures.f(objA);
                }
                ListenableFuture listenableFutureB = cacheLoader.b(obj, obj2);
                return listenableFutureB == null ? Futures.f(null) : Futures.h(listenableFutureB, new Function() { // from class: com.google.common.cache.b
                    @Override // com.google.common.base.Function
                    public final Object apply(Object obj3) {
                        return LocalCache.LoadingValueReference.g(this.f83661a, obj3);
                    }
                }, MoreExecutors.a());
            } catch (Throwable th) {
                ListenableFuture listenableFutureI = m(th) ? this.f83554b : i(th);
                if (th instanceof InterruptedException) {
                    Thread.currentThread().interrupt();
                }
                return listenableFutureI;
            }
        }

        public boolean l(Object obj) {
            return this.f83554b.B(obj);
        }

        public boolean m(Throwable th) {
            return this.f83554b.C(th);
        }

        public LoadingValueReference(ValueReference valueReference) {
            this.f83554b = SettableFuture.F();
            this.f83555c = Stopwatch.d();
            this.f83553a = valueReference;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference e(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LocalLoadingCache<K, V> extends LocalManualCache<K, V> implements LoadingCache<K, V> {
        private static final long serialVersionUID = 1;

        LocalLoadingCache(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
            super();
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use LoadingSerializationProxy");
        }

        public Object a(Object obj) {
            try {
                return get(obj);
            } catch (ExecutionException e3) {
                throw new UncheckedExecutionException(e3.getCause());
            }
        }

        @Override // com.google.common.cache.LoadingCache, com.google.common.base.Function
        public final Object apply(Object obj) {
            return a(obj);
        }

        @Override // com.google.common.cache.LoadingCache
        public Object get(Object obj) {
            return this.f83556a.k(obj);
        }

        @Override // com.google.common.cache.LocalCache.LocalManualCache
        Object writeReplace() {
            return new LoadingSerializationProxy(this.f83556a);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class LocalManualCache<K, V> implements Cache<K, V>, Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final LocalCache f83556a;

        /* JADX INFO: renamed from: com.google.common.cache.LocalCache$LocalManualCache$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 extends CacheLoader<Object, Object> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final /* synthetic */ Callable f83557a;

            @Override // com.google.common.cache.CacheLoader
            public Object a(Object obj) {
                return this.f83557a.call();
            }
        }

        private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
            throw new InvalidObjectException("Use ManualSerializationProxy");
        }

        Object writeReplace() {
            return new ManualSerializationProxy(this.f83556a);
        }

        LocalManualCache(CacheBuilder cacheBuilder) {
            this(new LocalCache(cacheBuilder, null));
        }

        private LocalManualCache(LocalCache localCache) {
            this.f83556a = localCache;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ManualSerializationProxy<K, V> extends ForwardingCache<K, V> implements Serializable {
        private static final long serialVersionUID = 1;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Strength f83558a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final Strength f83559b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final Equivalence f83560c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final Equivalence f83561d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        final long f83562f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        final long f83563g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final long f83564h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final Weigher f83565i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final int f83566j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final RemovalListener f83567k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final Ticker f83568l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final CacheLoader f83569m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        transient Cache f83570n;

        ManualSerializationProxy(LocalCache localCache) {
            this(localCache.f83508h, localCache.f83509i, localCache.f83506f, localCache.f83507g, localCache.f83513m, localCache.f83512l, localCache.f83510j, localCache.f83511k, localCache.f83505d, localCache.f83516p, localCache.f83517q, localCache.f83520t);
        }

        private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
            objectInputStream.defaultReadObject();
            this.f83570n = S1().a();
        }

        private Object readResolve() {
            return this.f83570n;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.common.cache.ForwardingCache, com.google.common.collect.ForwardingObject
        /* JADX INFO: renamed from: I1, reason: merged with bridge method [inline-methods] */
        public Cache k2() {
            return this.f83570n;
        }

        CacheBuilder S1() {
            CacheBuilder cacheBuilderZ = CacheBuilder.y().A(this.f83558a).B(this.f83559b).v(this.f83560c).D(this.f83561d).e(this.f83566j).z(this.f83567k);
            cacheBuilderZ.f83446a = false;
            long j3 = this.f83562f;
            if (j3 > 0) {
                cacheBuilderZ.g(j3, TimeUnit.NANOSECONDS);
            }
            long j4 = this.f83563g;
            if (j4 > 0) {
                cacheBuilderZ.f(j4, TimeUnit.NANOSECONDS);
            }
            Weigher weigher = this.f83565i;
            if (weigher != CacheBuilder.OneWeigher.INSTANCE) {
                cacheBuilderZ.F(weigher);
                long j5 = this.f83564h;
                if (j5 != -1) {
                    cacheBuilderZ.x(j5);
                }
            } else {
                long j6 = this.f83564h;
                if (j6 != -1) {
                    cacheBuilderZ.w(j6);
                }
            }
            Ticker ticker = this.f83568l;
            if (ticker != null) {
                cacheBuilderZ.C(ticker);
            }
            return cacheBuilderZ;
        }

        private ManualSerializationProxy(Strength strength, Strength strength2, Equivalence equivalence, Equivalence equivalence2, long j3, long j4, long j5, Weigher weigher, int i3, RemovalListener removalListener, Ticker ticker, CacheLoader cacheLoader) {
            this.f83558a = strength;
            this.f83559b = strength2;
            this.f83560c = equivalence;
            this.f83561d = equivalence2;
            this.f83562f = j3;
            this.f83563g = j4;
            this.f83564h = j5;
            this.f83565i = weigher;
            this.f83566j = i3;
            this.f83567k = removalListener;
            this.f83568l = (ticker == Ticker.b() || ticker == CacheBuilder.f83445t) ? null : ticker;
            this.f83569m = cacheLoader;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Segment<K, V> extends ReentrantLock {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final LocalCache f83573a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        volatile int f83574b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        long f83575c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        int f83576d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        int f83577f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        volatile AtomicReferenceArray f83578g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        final long f83579h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        final ReferenceQueue f83580i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        final ReferenceQueue f83581j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        final Queue f83582k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        final AtomicInteger f83583l = new AtomicInteger();

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        final Queue f83584m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        final Queue f83585n;

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        final AbstractCache.StatsCounter f83586o;

        Segment(LocalCache localCache, int i3, long j3, AbstractCache.StatsCounter statsCounter) {
            this.f83573a = localCache;
            this.f83579h = j3;
            this.f83586o = (AbstractCache.StatsCounter) Preconditions.t(statsCounter);
            y(E(i3));
            this.f83580i = localCache.F() ? new ReferenceQueue() : null;
            this.f83581j = localCache.G() ? new ReferenceQueue() : null;
            this.f83582k = localCache.E() ? new ConcurrentLinkedQueue() : LocalCache.e();
            this.f83584m = localCache.I() ? new WriteQueue() : LocalCache.e();
            this.f83585n = localCache.E() ? new AccessQueue() : LocalCache.e();
        }

        public static /* synthetic */ void a(Segment segment, Object obj, int i3, LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) {
            segment.getClass();
            try {
                segment.s(obj, i3, loadingValueReference, listenableFuture);
            } catch (Throwable th) {
                LocalCache.f83499x.log(Level.WARNING, "Exception thrown during refresh", th);
                loadingValueReference.m(th);
            }
        }

        ListenableFuture A(final Object obj, final int i3, final LoadingValueReference loadingValueReference, CacheLoader cacheLoader) {
            final ListenableFuture listenableFutureK = loadingValueReference.k(obj, cacheLoader);
            listenableFutureK.addListener(new Runnable() { // from class: com.google.common.cache.c
                @Override // java.lang.Runnable
                public final void run() {
                    LocalCache.Segment.a(this.f83662a, obj, i3, loadingValueReference, listenableFutureK);
                }
            }, MoreExecutors.a());
            return listenableFutureK;
        }

        Object B(Object obj, int i3, LoadingValueReference loadingValueReference, CacheLoader cacheLoader) {
            return s(obj, i3, loadingValueReference, loadingValueReference.k(obj, cacheLoader));
        }

        /* JADX WARN: Code restructure failed: missing block: B:29:0x00a0, code lost:
        
            if (r2 == false) goto L34;
         */
        /* JADX WARN: Code restructure failed: missing block: B:30:0x00a2, code lost:
        
            r13 = new com.google.common.cache.LocalCache.LoadingValueReference();
         */
        /* JADX WARN: Code restructure failed: missing block: B:31:0x00a7, code lost:
        
            if (r12 != null) goto L33;
         */
        /* JADX WARN: Code restructure failed: missing block: B:32:0x00a9, code lost:
        
            r12 = D(r16, r3, r11);
            r12.i(r13);
            r9.set(r10, r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:33:0x00b4, code lost:
        
            r12.i(r13);
         */
        /* JADX WARN: Code restructure failed: missing block: B:34:0x00b7, code lost:
        
            unlock();
            G();
         */
        /* JADX WARN: Code restructure failed: missing block: B:35:0x00bd, code lost:
        
            if (r2 == false) goto L48;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x00bf, code lost:
        
            monitor-enter(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:38:0x00c2, code lost:
        
            r0 = B(r16, r3, r13, r18);
         */
        /* JADX WARN: Code restructure failed: missing block: B:39:0x00c6, code lost:
        
            monitor-exit(r12);
         */
        /* JADX WARN: Code restructure failed: missing block: B:41:0x00cc, code lost:
        
            return r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:45:0x00d0, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:46:0x00d1, code lost:
        
            r15.f83586o.b(1);
         */
        /* JADX WARN: Code restructure failed: missing block: B:47:0x00d6, code lost:
        
            throw r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:49:0x00db, code lost:
        
            return h0(r12, r16, r14);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object C(java.lang.Object r16, int r17, com.google.common.cache.CacheLoader r18) {
            /*
                Method dump skipped, instruction units count: 227
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.C(java.lang.Object, int, com.google.common.cache.CacheLoader):java.lang.Object");
        }

        ReferenceEntry D(Object obj, int i3, ReferenceEntry referenceEntry) {
            return this.f83573a.f83518r.f(this, Preconditions.t(obj), i3, referenceEntry);
        }

        AtomicReferenceArray E(int i3) {
            return new AtomicReferenceArray(i3);
        }

        void F() {
            if ((this.f83583l.incrementAndGet() & 63) == 0) {
                b();
            }
        }

        void G() {
            a0();
        }

        void H(long j3) {
            Z(j3);
        }

        /* JADX WARN: Code restructure failed: missing block: B:23:0x0088, code lost:
        
            unlock();
            G();
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x008e, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object I(java.lang.Object r13, int r14, java.lang.Object r15, boolean r16) {
            /*
                Method dump skipped, instruction units count: 242
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.I(java.lang.Object, int, java.lang.Object, boolean):java.lang.Object");
        }

        boolean J(ReferenceEntry referenceEntry, int i3) throws Throwable {
            AtomicReferenceArray atomicReferenceArray;
            int length;
            ReferenceEntry referenceEntry2;
            ReferenceEntry referenceEntryB;
            lock();
            try {
                atomicReferenceArray = this.f83578g;
                length = (atomicReferenceArray.length() - 1) & i3;
                referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
                referenceEntryB = referenceEntry2;
            } catch (Throwable th) {
                th = th;
            }
            while (referenceEntryB != null) {
                if (referenceEntryB == referenceEntry) {
                    this.f83576d++;
                    ReferenceEntry referenceEntryW = W(referenceEntry2, referenceEntryB, referenceEntryB.getKey(), i3, referenceEntryB.a().get(), referenceEntryB.a(), RemovalCause.COLLECTED);
                    int i4 = this.f83574b - 1;
                    atomicReferenceArray.set(length, referenceEntryW);
                    this.f83574b = i4;
                    unlock();
                    G();
                    return true;
                }
                int i5 = i3;
                try {
                    referenceEntryB = referenceEntryB.b();
                    i3 = i5;
                } catch (Throwable th2) {
                    th = th2;
                }
                th = th2;
                Throwable th3 = th;
                unlock();
                G();
                throw th3;
            }
            unlock();
            G();
            return false;
        }

        /* JADX WARN: Removed duplicated region for block: B:37:0x008f  */
        /* JADX WARN: Removed duplicated region for block: B:45:? A[SYNTHETIC] */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean K(java.lang.Object r13, int r14, com.google.common.cache.LocalCache.ValueReference r15) throws java.lang.Throwable {
            /*
                r12 = this;
                r12.lock()
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f83578g     // Catch: java.lang.Throwable -> L5d
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L5d
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L5d
                r5 = r3
                com.google.common.cache.ReferenceEntry r5 = (com.google.common.cache.ReferenceEntry) r5     // Catch: java.lang.Throwable -> L5d
                r6 = r5
            L14:
                r3 = 0
                if (r6 == 0) goto L78
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L5d
                int r4 = r6.c()     // Catch: java.lang.Throwable -> L5d
                if (r4 != r14) goto L6e
                if (r7 == 0) goto L6e
                com.google.common.cache.LocalCache r4 = r12.f83573a     // Catch: java.lang.Throwable -> L5d
                com.google.common.base.Equivalence r4 = r4.f83506f     // Catch: java.lang.Throwable -> L5d
                boolean r4 = r4.d(r13, r7)     // Catch: java.lang.Throwable -> L5d
                if (r4 == 0) goto L6e
                com.google.common.cache.LocalCache$ValueReference r13 = r6.a()     // Catch: java.lang.Throwable -> L5d
                if (r13 != r15) goto L60
                int r13 = r12.f83576d     // Catch: java.lang.Throwable -> L5d
                int r13 = r13 + r2
                r12.f83576d = r13     // Catch: java.lang.Throwable -> L5d
                java.lang.Object r9 = r15.get()     // Catch: java.lang.Throwable -> L5d
                com.google.common.cache.RemovalCause r11 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L5d
                r4 = r12
                r8 = r14
                r10 = r15
                com.google.common.cache.ReferenceEntry r13 = r4.W(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L5a
                int r14 = r4.f83574b     // Catch: java.lang.Throwable -> L5a
                int r14 = r14 - r2
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L5a
                r4.f83574b = r14     // Catch: java.lang.Throwable -> L5a
                r12.unlock()
                boolean r13 = r12.isHeldByCurrentThread()
                if (r13 != 0) goto L59
                r12.G()
            L59:
                return r2
            L5a:
                r0 = move-exception
            L5b:
                r13 = r0
                goto L86
            L5d:
                r0 = move-exception
                r4 = r12
                goto L5b
            L60:
                r4 = r12
                r12.unlock()
                boolean r13 = r12.isHeldByCurrentThread()
                if (r13 != 0) goto L6d
                r12.G()
            L6d:
                return r3
            L6e:
                r4 = r12
                r8 = r14
                r10 = r15
                com.google.common.cache.ReferenceEntry r6 = r6.b()     // Catch: java.lang.Throwable -> L5a
                r14 = r8
                r15 = r10
                goto L14
            L78:
                r4 = r12
                r12.unlock()
                boolean r13 = r12.isHeldByCurrentThread()
                if (r13 != 0) goto L85
                r12.G()
            L85:
                return r3
            L86:
                r12.unlock()
                boolean r14 = r12.isHeldByCurrentThread()
                if (r14 != 0) goto L92
                r12.G()
            L92:
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.K(java.lang.Object, int, com.google.common.cache.LocalCache$ValueReference):boolean");
        }

        void L(ReferenceEntry referenceEntry, long j3) {
            if (this.f83573a.v()) {
                referenceEntry.k(j3);
            }
            this.f83585n.add(referenceEntry);
        }

        void M(ReferenceEntry referenceEntry, long j3) {
            if (this.f83573a.v()) {
                referenceEntry.k(j3);
            }
            this.f83582k.add(referenceEntry);
        }

        void N(ReferenceEntry referenceEntry, int i3, long j3) {
            j();
            this.f83575c += (long) i3;
            if (this.f83573a.v()) {
                referenceEntry.k(j3);
            }
            if (this.f83573a.x()) {
                referenceEntry.m(j3);
            }
            this.f83585n.add(referenceEntry);
            this.f83584m.add(referenceEntry);
        }

        Object P(Object obj, int i3, CacheLoader cacheLoader, boolean z2) {
            LoadingValueReference loadingValueReferenceZ = z(obj, i3, z2);
            if (loadingValueReferenceZ == null) {
                return null;
            }
            ListenableFuture listenableFutureA = A(obj, i3, loadingValueReferenceZ, cacheLoader);
            if (listenableFutureA.isDone()) {
                try {
                    return Uninterruptibles.a(listenableFutureA);
                } catch (Throwable unused) {
                }
            }
            return null;
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        
            r9 = r5.a();
            r8 = r9.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0040, code lost:
        
            if (r8 == null) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0042, code lost:
        
            r12 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x0044, code lost:
        
            r10 = r12;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0046, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0047, code lost:
        
            r12 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:18:0x004e, code lost:
        
            if (r9.isActive() == false) goto L29;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0050, code lost:
        
            r12 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x0053, code lost:
        
            r11.f83576d++;
         */
        /* JADX WARN: Code restructure failed: missing block: B:22:0x005b, code lost:
        
            r12 = W(r4, r5, r6, r13, r8, r9, r10);
            r13 = r11.f83574b - 1;
            r0.set(r1, r12);
            r11.f83574b = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0068, code lost:
        
            unlock();
            G();
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x006e, code lost:
        
            return r8;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object Q(java.lang.Object r12, int r13) throws java.lang.Throwable {
            /*
                r11 = this;
                r11.lock()
                com.google.common.cache.LocalCache r0 = r11.f83573a     // Catch: java.lang.Throwable -> L72
                com.google.common.base.Ticker r0 = r0.f83517q     // Catch: java.lang.Throwable -> L72
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L72
                r11.H(r0)     // Catch: java.lang.Throwable -> L72
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r11.f83578g     // Catch: java.lang.Throwable -> L72
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L72
                int r1 = r1 + (-1)
                r1 = r1 & r13
                java.lang.Object r2 = r0.get(r1)     // Catch: java.lang.Throwable -> L72
                r4 = r2
                com.google.common.cache.ReferenceEntry r4 = (com.google.common.cache.ReferenceEntry) r4     // Catch: java.lang.Throwable -> L72
                r5 = r4
            L1f:
                r2 = 0
                if (r5 == 0) goto L75
                java.lang.Object r6 = r5.getKey()     // Catch: java.lang.Throwable -> L72
                int r3 = r5.c()     // Catch: java.lang.Throwable -> L72
                if (r3 != r13) goto L7d
                if (r6 == 0) goto L7d
                com.google.common.cache.LocalCache r3 = r11.f83573a     // Catch: java.lang.Throwable -> L72
                com.google.common.base.Equivalence r3 = r3.f83506f     // Catch: java.lang.Throwable -> L72
                boolean r3 = r3.d(r12, r6)     // Catch: java.lang.Throwable -> L72
                if (r3 == 0) goto L7d
                com.google.common.cache.LocalCache$ValueReference r9 = r5.a()     // Catch: java.lang.Throwable -> L72
                java.lang.Object r8 = r9.get()     // Catch: java.lang.Throwable -> L72
                if (r8 == 0) goto L4a
                com.google.common.cache.RemovalCause r12 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L46
            L44:
                r10 = r12
                goto L53
            L46:
                r0 = move-exception
                r12 = r0
                r3 = r11
                goto L85
            L4a:
                boolean r12 = r9.isActive()     // Catch: java.lang.Throwable -> L72
                if (r12 == 0) goto L75
                com.google.common.cache.RemovalCause r12 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L72
                goto L44
            L53:
                int r12 = r11.f83576d     // Catch: java.lang.Throwable -> L72
                int r12 = r12 + 1
                r11.f83576d = r12     // Catch: java.lang.Throwable -> L72
                r3 = r11
                r7 = r13
                com.google.common.cache.ReferenceEntry r12 = r3.W(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Throwable -> L6f
                int r13 = r3.f83574b     // Catch: java.lang.Throwable -> L6f
                int r13 = r13 + (-1)
                r0.set(r1, r12)     // Catch: java.lang.Throwable -> L6f
                r3.f83574b = r13     // Catch: java.lang.Throwable -> L6f
                r11.unlock()
                r11.G()
                return r8
            L6f:
                r0 = move-exception
            L70:
                r12 = r0
                goto L85
            L72:
                r0 = move-exception
                r3 = r11
                goto L70
            L75:
                r3 = r11
                r11.unlock()
                r11.G()
                return r2
            L7d:
                r3 = r11
                r7 = r13
                com.google.common.cache.ReferenceEntry r5 = r5.b()     // Catch: java.lang.Throwable -> L6f
                r13 = r7
                goto L1f
            L85:
                r11.unlock()
                r11.G()
                throw r12
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.Q(java.lang.Object, int):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:11:0x0038, code lost:
        
            r10 = r6.a();
            r9 = r10.get();
         */
        /* JADX WARN: Code restructure failed: missing block: B:12:0x0048, code lost:
        
            if (r12.f83573a.f83507g.d(r15, r9) == false) goto L17;
         */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x004a, code lost:
        
            r13 = com.google.common.cache.RemovalCause.EXPLICIT;
         */
        /* JADX WARN: Code restructure failed: missing block: B:14:0x004c, code lost:
        
            r11 = r13;
         */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x004e, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x004f, code lost:
        
            r13 = r0;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0052, code lost:
        
            if (r9 != null) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x0058, code lost:
        
            if (r10.isActive() == false) goto L38;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x005a, code lost:
        
            r13 = com.google.common.cache.RemovalCause.COLLECTED;
         */
        /* JADX WARN: Code restructure failed: missing block: B:21:0x005d, code lost:
        
            r12.f83576d++;
         */
        /* JADX WARN: Code restructure failed: missing block: B:23:0x0064, code lost:
        
            r13 = W(r5, r6, r7, r14, r9, r10, r11);
            r14 = r12.f83574b - 1;
            r0.set(r1, r13);
            r12.f83574b = r14;
         */
        /* JADX WARN: Code restructure failed: missing block: B:24:0x0072, code lost:
        
            if (r11 != com.google.common.cache.RemovalCause.EXPLICIT) goto L26;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x0075, code lost:
        
            r2 = false;
         */
        /* JADX WARN: Code restructure failed: missing block: B:27:0x0076, code lost:
        
            unlock();
            G();
         */
        /* JADX WARN: Code restructure failed: missing block: B:28:0x007c, code lost:
        
            return r2;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean R(java.lang.Object r13, int r14, java.lang.Object r15) throws java.lang.Throwable {
            /*
                r12 = this;
                r12.lock()
                com.google.common.cache.LocalCache r0 = r12.f83573a     // Catch: java.lang.Throwable -> L80
                com.google.common.base.Ticker r0 = r0.f83517q     // Catch: java.lang.Throwable -> L80
                long r0 = r0.a()     // Catch: java.lang.Throwable -> L80
                r12.H(r0)     // Catch: java.lang.Throwable -> L80
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r12.f83578g     // Catch: java.lang.Throwable -> L80
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L80
                r2 = 1
                int r1 = r1 - r2
                r1 = r1 & r14
                java.lang.Object r3 = r0.get(r1)     // Catch: java.lang.Throwable -> L80
                r5 = r3
                com.google.common.cache.ReferenceEntry r5 = (com.google.common.cache.ReferenceEntry) r5     // Catch: java.lang.Throwable -> L80
                r6 = r5
            L1f:
                r3 = 0
                if (r6 == 0) goto L92
                java.lang.Object r7 = r6.getKey()     // Catch: java.lang.Throwable -> L80
                int r4 = r6.c()     // Catch: java.lang.Throwable -> L80
                if (r4 != r14) goto L8a
                if (r7 == 0) goto L8a
                com.google.common.cache.LocalCache r4 = r12.f83573a     // Catch: java.lang.Throwable -> L80
                com.google.common.base.Equivalence r4 = r4.f83506f     // Catch: java.lang.Throwable -> L80
                boolean r4 = r4.d(r13, r7)     // Catch: java.lang.Throwable -> L80
                if (r4 == 0) goto L8a
                com.google.common.cache.LocalCache$ValueReference r10 = r6.a()     // Catch: java.lang.Throwable -> L80
                java.lang.Object r9 = r10.get()     // Catch: java.lang.Throwable -> L80
                com.google.common.cache.LocalCache r13 = r12.f83573a     // Catch: java.lang.Throwable -> L80
                com.google.common.base.Equivalence r13 = r13.f83507g     // Catch: java.lang.Throwable -> L80
                boolean r13 = r13.d(r15, r9)     // Catch: java.lang.Throwable -> L80
                if (r13 == 0) goto L52
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L4e
            L4c:
                r11 = r13
                goto L5d
            L4e:
                r0 = move-exception
                r13 = r0
                r4 = r12
                goto L94
            L52:
                if (r9 != 0) goto L92
                boolean r13 = r10.isActive()     // Catch: java.lang.Throwable -> L80
                if (r13 == 0) goto L92
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L80
                goto L4c
            L5d:
                int r13 = r12.f83576d     // Catch: java.lang.Throwable -> L80
                int r13 = r13 + r2
                r12.f83576d = r13     // Catch: java.lang.Throwable -> L80
                r4 = r12
                r8 = r14
                com.google.common.cache.ReferenceEntry r13 = r4.W(r5, r6, r7, r8, r9, r10, r11)     // Catch: java.lang.Throwable -> L7d
                int r14 = r4.f83574b     // Catch: java.lang.Throwable -> L7d
                int r14 = r14 - r2
                r0.set(r1, r13)     // Catch: java.lang.Throwable -> L7d
                r4.f83574b = r14     // Catch: java.lang.Throwable -> L7d
                com.google.common.cache.RemovalCause r13 = com.google.common.cache.RemovalCause.EXPLICIT     // Catch: java.lang.Throwable -> L7d
                if (r11 != r13) goto L75
                goto L76
            L75:
                r2 = r3
            L76:
                r12.unlock()
                r12.G()
                return r2
            L7d:
                r0 = move-exception
            L7e:
                r13 = r0
                goto L94
            L80:
                r0 = move-exception
                r4 = r12
                goto L7e
            L83:
                r12.unlock()
                r12.G()
                return r3
            L8a:
                r4 = r12
                r8 = r14
                com.google.common.cache.ReferenceEntry r6 = r6.b()     // Catch: java.lang.Throwable -> L7d
                r14 = r8
                goto L1f
            L92:
                r4 = r12
                goto L83
            L94:
                r12.unlock()
                r12.G()
                throw r13
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.R(java.lang.Object, int, java.lang.Object):boolean");
        }

        void S(ReferenceEntry referenceEntry) {
            m(referenceEntry.getKey(), referenceEntry.c(), referenceEntry.a().get(), referenceEntry.a().b(), RemovalCause.COLLECTED);
            this.f83584m.remove(referenceEntry);
            this.f83585n.remove(referenceEntry);
        }

        boolean T(ReferenceEntry referenceEntry, int i3, RemovalCause removalCause) {
            AtomicReferenceArray atomicReferenceArray = this.f83578g;
            int length = (atomicReferenceArray.length() - 1) & i3;
            ReferenceEntry referenceEntry2 = (ReferenceEntry) atomicReferenceArray.get(length);
            for (ReferenceEntry referenceEntryB = referenceEntry2; referenceEntryB != null; referenceEntryB = referenceEntryB.b()) {
                if (referenceEntryB == referenceEntry) {
                    this.f83576d++;
                    ReferenceEntry referenceEntryW = W(referenceEntry2, referenceEntryB, referenceEntryB.getKey(), i3, referenceEntryB.a().get(), referenceEntryB.a(), removalCause);
                    int i4 = this.f83574b - 1;
                    atomicReferenceArray.set(length, referenceEntryW);
                    this.f83574b = i4;
                    return true;
                }
            }
            return false;
        }

        ReferenceEntry U(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            int i3 = this.f83574b;
            ReferenceEntry referenceEntryB = referenceEntry2.b();
            while (referenceEntry != referenceEntry2) {
                ReferenceEntry referenceEntryH = h(referenceEntry, referenceEntryB);
                if (referenceEntryH != null) {
                    referenceEntryB = referenceEntryH;
                } else {
                    S(referenceEntry);
                    i3--;
                }
                referenceEntry = referenceEntry.b();
            }
            this.f83574b = i3;
            return referenceEntryB;
        }

        boolean V(Object obj, int i3, LoadingValueReference loadingValueReference) {
            lock();
            try {
                AtomicReferenceArray atomicReferenceArray = this.f83578g;
                int length = (atomicReferenceArray.length() - 1) & i3;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntryB = referenceEntry;
                while (true) {
                    if (referenceEntryB == null) {
                        break;
                    }
                    Object key = referenceEntryB.getKey();
                    if (referenceEntryB.c() != i3 || key == null || !this.f83573a.f83506f.d(obj, key)) {
                        referenceEntryB = referenceEntryB.b();
                    } else if (referenceEntryB.a() == loadingValueReference) {
                        if (loadingValueReference.isActive()) {
                            referenceEntryB.i(loadingValueReference.j());
                        } else {
                            atomicReferenceArray.set(length, U(referenceEntry, referenceEntryB));
                        }
                        unlock();
                        G();
                        return true;
                    }
                }
                unlock();
                G();
                return false;
            } catch (Throwable th) {
                unlock();
                G();
                throw th;
            }
        }

        ReferenceEntry W(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2, Object obj, int i3, Object obj2, ValueReference valueReference, RemovalCause removalCause) {
            m(obj, i3, obj2, valueReference.b(), removalCause);
            this.f83584m.remove(referenceEntry2);
            this.f83585n.remove(referenceEntry2);
            if (!valueReference.a()) {
                return U(referenceEntry, referenceEntry2);
            }
            valueReference.d(null);
            return referenceEntry;
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x006c, code lost:
        
            return null;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        java.lang.Object X(java.lang.Object r14, int r15, java.lang.Object r16) {
            /*
                r13 = this;
                r13.lock()
                com.google.common.cache.LocalCache r0 = r13.f83573a     // Catch: java.lang.Throwable -> L63
                com.google.common.base.Ticker r0 = r0.f83517q     // Catch: java.lang.Throwable -> L63
                long r7 = r0.a()     // Catch: java.lang.Throwable -> L63
                r13.H(r7)     // Catch: java.lang.Throwable -> L63
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r13.f83578g     // Catch: java.lang.Throwable -> L63
                int r1 = r0.length()     // Catch: java.lang.Throwable -> L63
                int r1 = r1 + (-1)
                r9 = r15 & r1
                java.lang.Object r1 = r0.get(r9)     // Catch: java.lang.Throwable -> L63
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> L63
                r1 = r2
            L20:
                r10 = 0
                if (r1 == 0) goto L66
                java.lang.Object r4 = r1.getKey()     // Catch: java.lang.Throwable -> L63
                int r5 = r1.c()     // Catch: java.lang.Throwable -> L63
                if (r5 != r15) goto L95
                if (r4 == 0) goto L95
                com.google.common.cache.LocalCache r5 = r13.f83573a     // Catch: java.lang.Throwable -> L63
                com.google.common.base.Equivalence r5 = r5.f83506f     // Catch: java.lang.Throwable -> L63
                boolean r5 = r5.d(r14, r4)     // Catch: java.lang.Throwable -> L63
                if (r5 == 0) goto L95
                r11 = r7
                com.google.common.cache.LocalCache$ValueReference r7 = r1.a()     // Catch: java.lang.Throwable -> L63
                java.lang.Object r6 = r7.get()     // Catch: java.lang.Throwable -> L63
                if (r6 != 0) goto L6d
                boolean r14 = r7.isActive()     // Catch: java.lang.Throwable -> L63
                if (r14 == 0) goto L66
                int r14 = r13.f83576d     // Catch: java.lang.Throwable -> L63
                int r14 = r14 + 1
                r13.f83576d = r14     // Catch: java.lang.Throwable -> L63
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L63
                r5 = r15
                r3 = r1
                r1 = r13
                com.google.common.cache.ReferenceEntry r14 = r1.W(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L63
                int r2 = r13.f83574b     // Catch: java.lang.Throwable -> L63
                int r2 = r2 + (-1)
                r0.set(r9, r14)     // Catch: java.lang.Throwable -> L63
                r13.f83574b = r2     // Catch: java.lang.Throwable -> L63
                goto L66
            L63:
                r0 = move-exception
                r14 = r0
                goto La0
            L66:
                r13.unlock()
                r13.G()
                return r10
            L6d:
                r0 = r1
                r4 = r6
                int r2 = r13.f83576d     // Catch: java.lang.Throwable -> L63
                int r2 = r2 + 1
                r13.f83576d = r2     // Catch: java.lang.Throwable -> L63
                int r5 = r7.b()     // Catch: java.lang.Throwable -> L63
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L63
                r1 = r13
                r2 = r14
                r3 = r15
                r1.m(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L63
                r7 = r4
                r1 = r13
                r3 = r14
                r4 = r16
                r2 = r0
                r5 = r11
                r1.c0(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L63
                r13.n(r2)     // Catch: java.lang.Throwable -> L63
                r13.unlock()
                r13.G()
                return r7
            L95:
                r3 = r2
                r5 = r7
                r2 = r1
                com.google.common.cache.ReferenceEntry r2 = r2.b()     // Catch: java.lang.Throwable -> L63
                r1 = r2
                r2 = r3
                r7 = r5
                goto L20
            La0:
                r13.unlock()
                r13.G()
                throw r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.X(java.lang.Object, int, java.lang.Object):java.lang.Object");
        }

        /* JADX WARN: Code restructure failed: missing block: B:20:0x006f, code lost:
        
            return false;
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        boolean Y(java.lang.Object r17, int r18, java.lang.Object r19, java.lang.Object r20) {
            /*
                r16 = this;
                r1 = r16
                r3 = r18
                r1.lock()
                com.google.common.cache.LocalCache r0 = r1.f83573a     // Catch: java.lang.Throwable -> L67
                com.google.common.base.Ticker r0 = r0.f83517q     // Catch: java.lang.Throwable -> L67
                long r7 = r0.a()     // Catch: java.lang.Throwable -> L67
                r1.H(r7)     // Catch: java.lang.Throwable -> L67
                java.util.concurrent.atomic.AtomicReferenceArray r0 = r1.f83578g     // Catch: java.lang.Throwable -> L67
                int r2 = r0.length()     // Catch: java.lang.Throwable -> L67
                r9 = 1
                int r2 = r2 - r9
                r10 = r3 & r2
                java.lang.Object r2 = r0.get(r10)     // Catch: java.lang.Throwable -> L67
                com.google.common.cache.ReferenceEntry r2 = (com.google.common.cache.ReferenceEntry) r2     // Catch: java.lang.Throwable -> L67
                r4 = r2
            L23:
                r11 = 0
                if (r4 == 0) goto L69
                r5 = r4
                java.lang.Object r4 = r5.getKey()     // Catch: java.lang.Throwable -> L67
                int r6 = r5.c()     // Catch: java.lang.Throwable -> L67
                if (r6 != r3) goto La9
                if (r4 == 0) goto La9
                com.google.common.cache.LocalCache r6 = r1.f83573a     // Catch: java.lang.Throwable -> L67
                com.google.common.base.Equivalence r6 = r6.f83506f     // Catch: java.lang.Throwable -> L67
                r12 = r17
                boolean r6 = r6.d(r12, r4)     // Catch: java.lang.Throwable -> L67
                if (r6 == 0) goto La9
                r13 = r7
                com.google.common.cache.LocalCache$ValueReference r7 = r5.a()     // Catch: java.lang.Throwable -> L67
                java.lang.Object r6 = r7.get()     // Catch: java.lang.Throwable -> L67
                if (r6 != 0) goto L70
                boolean r8 = r7.isActive()     // Catch: java.lang.Throwable -> L67
                if (r8 == 0) goto L69
                int r8 = r1.f83576d     // Catch: java.lang.Throwable -> L67
                int r8 = r8 + r9
                r1.f83576d = r8     // Catch: java.lang.Throwable -> L67
                com.google.common.cache.RemovalCause r8 = com.google.common.cache.RemovalCause.COLLECTED     // Catch: java.lang.Throwable -> L67
                r15 = r5
                r5 = r3
                r3 = r15
                com.google.common.cache.ReferenceEntry r2 = r1.W(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L67
                int r3 = r1.f83574b     // Catch: java.lang.Throwable -> L67
                int r3 = r3 - r9
                r0.set(r10, r2)     // Catch: java.lang.Throwable -> L67
                r1.f83574b = r3     // Catch: java.lang.Throwable -> L67
                goto L69
            L67:
                r0 = move-exception
                goto Lba
            L69:
                r1.unlock()
                r1.G()
                return r11
            L70:
                r0 = r5
                r4 = r6
                com.google.common.cache.LocalCache r2 = r1.f83573a     // Catch: java.lang.Throwable -> L67
                com.google.common.base.Equivalence r2 = r2.f83507g     // Catch: java.lang.Throwable -> L67
                r3 = r19
                boolean r2 = r2.d(r3, r4)     // Catch: java.lang.Throwable -> L67
                if (r2 == 0) goto La4
                int r2 = r1.f83576d     // Catch: java.lang.Throwable -> L67
                int r2 = r2 + r9
                r1.f83576d = r2     // Catch: java.lang.Throwable -> L67
                int r5 = r7.b()     // Catch: java.lang.Throwable -> L67
                com.google.common.cache.RemovalCause r6 = com.google.common.cache.RemovalCause.REPLACED     // Catch: java.lang.Throwable -> L67
                r3 = r18
                r2 = r12
                r1.m(r2, r3, r4, r5, r6)     // Catch: java.lang.Throwable -> L67
                r1 = r16
                r3 = r17
                r4 = r20
                r2 = r0
                r5 = r13
                r1.c0(r2, r3, r4, r5)     // Catch: java.lang.Throwable -> L67
                r1.n(r2)     // Catch: java.lang.Throwable -> L67
                r1.unlock()
                r1.G()
                return r9
            La4:
                r2 = r0
                r1.L(r2, r13)     // Catch: java.lang.Throwable -> L67
                goto L69
            La9:
                r3 = r19
                r4 = r2
                r2 = r5
                r13 = r7
                com.google.common.cache.ReferenceEntry r2 = r2.b()     // Catch: java.lang.Throwable -> L67
                r3 = r4
                r4 = r2
                r2 = r3
                r3 = r18
                r7 = r13
                goto L23
            Lba:
                r1.unlock()
                r1.G()
                throw r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.common.cache.LocalCache.Segment.Y(java.lang.Object, int, java.lang.Object, java.lang.Object):boolean");
        }

        void Z(long j3) {
            if (tryLock()) {
                try {
                    k();
                    p(j3);
                    this.f83583l.set(0);
                } finally {
                    unlock();
                }
            }
        }

        void a0() {
            if (isHeldByCurrentThread()) {
                return;
            }
            this.f83573a.s();
        }

        void b() {
            Z(this.f83573a.f83517q.a());
            a0();
        }

        Object b0(ReferenceEntry referenceEntry, Object obj, int i3, Object obj2, long j3, CacheLoader cacheLoader) {
            Object objP;
            return (!this.f83573a.y() || j3 - referenceEntry.j() <= this.f83573a.f83514n || referenceEntry.a().a() || (objP = P(obj, i3, cacheLoader, true)) == null) ? obj2 : objP;
        }

        void c() throws Throwable {
            if (this.f83574b == 0) {
                return;
            }
            lock();
            try {
                H(this.f83573a.f83517q.a());
                AtomicReferenceArray atomicReferenceArray = this.f83578g;
                for (int i3 = 0; i3 < atomicReferenceArray.length(); i3++) {
                    for (ReferenceEntry referenceEntryB = (ReferenceEntry) atomicReferenceArray.get(i3); referenceEntryB != null; referenceEntryB = referenceEntryB.b()) {
                        if (referenceEntryB.a().isActive()) {
                            Object key = referenceEntryB.getKey();
                            Object obj = referenceEntryB.a().get();
                            try {
                                m(key, referenceEntryB.c(), obj, referenceEntryB.a().b(), (key == null || obj == null) ? RemovalCause.COLLECTED : RemovalCause.EXPLICIT);
                            } catch (Throwable th) {
                                th = th;
                                unlock();
                                G();
                                throw th;
                            }
                        }
                    }
                }
                for (int i4 = 0; i4 < atomicReferenceArray.length(); i4++) {
                    atomicReferenceArray.set(i4, null);
                }
                e();
                this.f83584m.clear();
                this.f83585n.clear();
                this.f83583l.set(0);
                this.f83576d++;
                this.f83574b = 0;
                unlock();
                G();
            } catch (Throwable th2) {
                th = th2;
            }
        }

        void c0(ReferenceEntry referenceEntry, Object obj, Object obj2, long j3) {
            ValueReference valueReferenceA = referenceEntry.a();
            int iA = this.f83573a.f83511k.a(obj, obj2);
            Preconditions.A(iA >= 0, "Weights must be non-negative");
            referenceEntry.i(this.f83573a.f83509i.c(this, referenceEntry, obj2, iA));
            N(referenceEntry, iA, j3);
            valueReferenceA.d(obj2);
        }

        void d() {
            while (this.f83580i.poll() != null) {
            }
        }

        boolean d0(Object obj, int i3, LoadingValueReference loadingValueReference, Object obj2) {
            lock();
            try {
                long jA = this.f83573a.f83517q.a();
                H(jA);
                int i4 = this.f83574b + 1;
                if (i4 > this.f83577f) {
                    o();
                    i4 = this.f83574b + 1;
                }
                AtomicReferenceArray atomicReferenceArray = this.f83578g;
                int length = i3 & (atomicReferenceArray.length() - 1);
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                ReferenceEntry referenceEntryB = referenceEntry;
                while (true) {
                    if (referenceEntryB == null) {
                        this.f83576d++;
                        ReferenceEntry referenceEntryD = D(obj, i3, referenceEntry);
                        c0(referenceEntryD, obj, obj2, jA);
                        atomicReferenceArray.set(length, referenceEntryD);
                        this.f83574b = i4;
                        n(referenceEntryD);
                        break;
                    }
                    Object key = referenceEntryB.getKey();
                    if (referenceEntryB.c() == i3 && key != null && this.f83573a.f83506f.d(obj, key)) {
                        ValueReference valueReferenceA = referenceEntryB.a();
                        Object obj3 = valueReferenceA.get();
                        if (loadingValueReference != valueReferenceA && (obj3 != null || valueReferenceA == LocalCache.f83500y)) {
                            m(obj, i3, obj2, 0, RemovalCause.REPLACED);
                            unlock();
                            G();
                            return false;
                        }
                        this.f83576d++;
                        if (loadingValueReference.isActive()) {
                            m(obj, i3, obj3, loadingValueReference.b(), obj3 == null ? RemovalCause.COLLECTED : RemovalCause.REPLACED);
                            i4--;
                        }
                        ReferenceEntry referenceEntry2 = referenceEntryB;
                        c0(referenceEntry2, obj, obj2, jA);
                        this.f83574b = i4;
                        n(referenceEntry2);
                    } else {
                        referenceEntryB = referenceEntryB.b();
                    }
                }
                unlock();
                G();
                return true;
            } catch (Throwable th) {
                unlock();
                G();
                throw th;
            }
        }

        void e() {
            if (this.f83573a.F()) {
                d();
            }
            if (this.f83573a.G()) {
                f();
            }
        }

        void e0() {
            if (tryLock()) {
                try {
                    k();
                } finally {
                    unlock();
                }
            }
        }

        void f() {
            while (this.f83581j.poll() != null) {
            }
        }

        void f0(long j3) {
            if (tryLock()) {
                try {
                    p(j3);
                } finally {
                    unlock();
                }
            }
        }

        boolean g(Object obj, int i3) {
            try {
                if (this.f83574b == 0) {
                    return false;
                }
                ReferenceEntry referenceEntryV = v(obj, i3, this.f83573a.f83517q.a());
                if (referenceEntryV == null) {
                    return false;
                }
                return referenceEntryV.a().get() != null;
            } finally {
                F();
            }
        }

        ReferenceEntry h(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
            Object key = referenceEntry.getKey();
            if (key == null) {
                return null;
            }
            ValueReference valueReferenceA = referenceEntry.a();
            Object obj = valueReferenceA.get();
            if (obj == null && valueReferenceA.isActive()) {
                return null;
            }
            ReferenceEntry referenceEntryC = this.f83573a.f83518r.c(this, referenceEntry, referenceEntry2, key);
            referenceEntryC.i(valueReferenceA.e(this.f83581j, obj, referenceEntryC));
            return referenceEntryC;
        }

        Object h0(ReferenceEntry referenceEntry, Object obj, ValueReference valueReference) {
            if (!valueReference.a()) {
                throw new AssertionError();
            }
            Preconditions.D(!Thread.holdsLock(referenceEntry), "Recursive load of: %s", obj);
            try {
                Object objF = valueReference.f();
                if (objF != null) {
                    M(referenceEntry, this.f83573a.f83517q.a());
                    return objF;
                }
                throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + obj + ".");
            } finally {
                this.f83586o.b(1);
            }
        }

        void i() throws Throwable {
            int i3 = 0;
            do {
                Object objPoll = this.f83580i.poll();
                if (objPoll == null) {
                    return;
                }
                this.f83573a.t((ReferenceEntry) objPoll);
                i3++;
            } while (i3 != 16);
        }

        void j() {
            while (true) {
                ReferenceEntry referenceEntry = (ReferenceEntry) this.f83582k.poll();
                if (referenceEntry == null) {
                    return;
                }
                if (this.f83585n.contains(referenceEntry)) {
                    this.f83585n.add(referenceEntry);
                }
            }
        }

        void k() throws Throwable {
            if (this.f83573a.F()) {
                i();
            }
            if (this.f83573a.G()) {
                l();
            }
        }

        void l() throws Throwable {
            int i3 = 0;
            do {
                Object objPoll = this.f83581j.poll();
                if (objPoll == null) {
                    return;
                }
                this.f83573a.u((ValueReference) objPoll);
                i3++;
            } while (i3 != 16);
        }

        void m(Object obj, int i3, Object obj2, int i4, RemovalCause removalCause) {
            this.f83575c -= (long) i4;
            if (removalCause.b()) {
                this.f83586o.c();
            }
            if (this.f83573a.f83515o != LocalCache.f83501z) {
                this.f83573a.f83515o.offer(RemovalNotification.a(obj, obj2, removalCause));
            }
        }

        void n(ReferenceEntry referenceEntry) {
            if (this.f83573a.f()) {
                j();
                if (referenceEntry.a().b() > this.f83579h && !T(referenceEntry, referenceEntry.c(), RemovalCause.SIZE)) {
                    throw new AssertionError();
                }
                while (this.f83575c > this.f83579h) {
                    ReferenceEntry referenceEntryX = x();
                    if (!T(referenceEntryX, referenceEntryX.c(), RemovalCause.SIZE)) {
                        throw new AssertionError();
                    }
                }
            }
        }

        void o() {
            AtomicReferenceArray atomicReferenceArray = this.f83578g;
            int length = atomicReferenceArray.length();
            if (length >= 1073741824) {
                return;
            }
            int i3 = this.f83574b;
            AtomicReferenceArray atomicReferenceArrayE = E(length << 1);
            this.f83577f = (atomicReferenceArrayE.length() * 3) / 4;
            int length2 = atomicReferenceArrayE.length() - 1;
            for (int i4 = 0; i4 < length; i4++) {
                ReferenceEntry referenceEntryB = (ReferenceEntry) atomicReferenceArray.get(i4);
                if (referenceEntryB != null) {
                    ReferenceEntry referenceEntryB2 = referenceEntryB.b();
                    int iC = referenceEntryB.c() & length2;
                    if (referenceEntryB2 == null) {
                        atomicReferenceArrayE.set(iC, referenceEntryB);
                    } else {
                        ReferenceEntry referenceEntry = referenceEntryB;
                        while (referenceEntryB2 != null) {
                            int iC2 = referenceEntryB2.c() & length2;
                            if (iC2 != iC) {
                                referenceEntry = referenceEntryB2;
                                iC = iC2;
                            }
                            referenceEntryB2 = referenceEntryB2.b();
                        }
                        atomicReferenceArrayE.set(iC, referenceEntry);
                        while (referenceEntryB != referenceEntry) {
                            int iC3 = referenceEntryB.c() & length2;
                            ReferenceEntry referenceEntryH = h(referenceEntryB, (ReferenceEntry) atomicReferenceArrayE.get(iC3));
                            if (referenceEntryH != null) {
                                atomicReferenceArrayE.set(iC3, referenceEntryH);
                            } else {
                                S(referenceEntryB);
                                i3--;
                            }
                            referenceEntryB = referenceEntryB.b();
                        }
                    }
                }
            }
            this.f83578g = atomicReferenceArrayE;
            this.f83574b = i3;
        }

        void p(long j3) {
            ReferenceEntry referenceEntry;
            ReferenceEntry referenceEntry2;
            j();
            do {
                referenceEntry = (ReferenceEntry) this.f83584m.peek();
                if (referenceEntry == null || !this.f83573a.m(referenceEntry, j3)) {
                    do {
                        referenceEntry2 = (ReferenceEntry) this.f83585n.peek();
                        if (referenceEntry2 == null || !this.f83573a.m(referenceEntry2, j3)) {
                            return;
                        }
                    } while (T(referenceEntry2, referenceEntry2.c(), RemovalCause.EXPIRED));
                    throw new AssertionError();
                }
            } while (T(referenceEntry, referenceEntry.c(), RemovalCause.EXPIRED));
            throw new AssertionError();
        }

        Object q(Object obj, int i3) {
            try {
                if (this.f83574b != 0) {
                    long jA = this.f83573a.f83517q.a();
                    ReferenceEntry referenceEntryV = v(obj, i3, jA);
                    if (referenceEntryV == null) {
                        F();
                        return null;
                    }
                    Object obj2 = referenceEntryV.a().get();
                    if (obj2 != null) {
                        M(referenceEntryV, jA);
                        Object objB0 = b0(referenceEntryV, referenceEntryV.getKey(), i3, obj2, jA, this.f83573a.f83520t);
                        F();
                        return objB0;
                    }
                    e0();
                }
                F();
                return null;
            } catch (Throwable th) {
                F();
                throw th;
            }
        }

        Object r(Object obj, int i3, CacheLoader cacheLoader) throws Throwable {
            Object obj2;
            int i4;
            CacheLoader cacheLoader2;
            ReferenceEntry referenceEntryT;
            Preconditions.t(obj);
            Preconditions.t(cacheLoader);
            try {
                try {
                    try {
                    } catch (ExecutionException e3) {
                        e = e3;
                    }
                } catch (Throwable th) {
                    th = th;
                    Throwable th2 = th;
                    F();
                    throw th2;
                }
            } catch (ExecutionException e4) {
                e = e4;
            } catch (Throwable th3) {
                th = th3;
                Throwable th22 = th;
                F();
                throw th22;
            }
            if (this.f83574b != 0 && (referenceEntryT = t(obj, i3)) != null) {
                long jA = this.f83573a.f83517q.a();
                Object objW = w(referenceEntryT, jA);
                if (objW != null) {
                    M(referenceEntryT, jA);
                    this.f83586o.a(1);
                    Object objB0 = b0(referenceEntryT, obj, i3, objW, jA, cacheLoader);
                    F();
                    return objB0;
                }
                obj2 = obj;
                i4 = i3;
                cacheLoader2 = cacheLoader;
                ValueReference valueReferenceA = referenceEntryT.a();
                if (valueReferenceA.a()) {
                    Object objH0 = h0(referenceEntryT, obj2, valueReferenceA);
                    F();
                    return objH0;
                }
                ExecutionException executionException = e;
                Throwable cause = executionException.getCause();
                if (cause instanceof Error) {
                    throw new ExecutionError((Error) cause);
                }
                if (cause instanceof RuntimeException) {
                    throw new UncheckedExecutionException(cause);
                }
                throw executionException;
            }
            obj2 = obj;
            i4 = i3;
            cacheLoader2 = cacheLoader;
            Object objC = C(obj2, i4, cacheLoader2);
            F();
            return objC;
        }

        Object s(Object obj, int i3, LoadingValueReference loadingValueReference, ListenableFuture listenableFuture) throws Throwable {
            Object objA;
            try {
                objA = Uninterruptibles.a(listenableFuture);
            } catch (Throwable th) {
                th = th;
                objA = null;
            }
            try {
                if (objA != null) {
                    this.f83586o.e(loadingValueReference.h());
                    d0(obj, i3, loadingValueReference, objA);
                    return objA;
                }
                throw new CacheLoader.InvalidCacheLoadException("CacheLoader returned null for key " + obj + ".");
            } catch (Throwable th2) {
                th = th2;
                if (objA == null) {
                    this.f83586o.d(loadingValueReference.h());
                    V(obj, i3, loadingValueReference);
                }
                throw th;
            }
        }

        ReferenceEntry t(Object obj, int i3) {
            for (ReferenceEntry referenceEntryU = u(i3); referenceEntryU != null; referenceEntryU = referenceEntryU.b()) {
                if (referenceEntryU.c() == i3) {
                    Object key = referenceEntryU.getKey();
                    if (key == null) {
                        e0();
                    } else if (this.f83573a.f83506f.d(obj, key)) {
                        return referenceEntryU;
                    }
                }
            }
            return null;
        }

        ReferenceEntry u(int i3) {
            return (ReferenceEntry) this.f83578g.get(i3 & (r0.length() - 1));
        }

        ReferenceEntry v(Object obj, int i3, long j3) {
            ReferenceEntry referenceEntryT = t(obj, i3);
            if (referenceEntryT == null) {
                return null;
            }
            if (!this.f83573a.m(referenceEntryT, j3)) {
                return referenceEntryT;
            }
            f0(j3);
            return null;
        }

        Object w(ReferenceEntry referenceEntry, long j3) {
            if (referenceEntry.getKey() == null) {
                e0();
                return null;
            }
            Object obj = referenceEntry.a().get();
            if (obj == null) {
                e0();
                return null;
            }
            if (!this.f83573a.m(referenceEntry, j3)) {
                return obj;
            }
            f0(j3);
            return null;
        }

        ReferenceEntry x() {
            for (ReferenceEntry referenceEntry : this.f83585n) {
                if (referenceEntry.a().b() > 0) {
                    return referenceEntry;
                }
            }
            throw new AssertionError();
        }

        void y(AtomicReferenceArray atomicReferenceArray) {
            this.f83577f = (atomicReferenceArray.length() * 3) / 4;
            if (!this.f83573a.d()) {
                int i3 = this.f83577f;
                if (i3 == this.f83579h) {
                    this.f83577f = i3 + 1;
                }
            }
            this.f83578g = atomicReferenceArray;
        }

        /* JADX WARN: Finally extract failed */
        LoadingValueReference z(Object obj, int i3, boolean z2) {
            lock();
            try {
                long jA = this.f83573a.f83517q.a();
                H(jA);
                AtomicReferenceArray atomicReferenceArray = this.f83578g;
                int length = (atomicReferenceArray.length() - 1) & i3;
                ReferenceEntry referenceEntry = (ReferenceEntry) atomicReferenceArray.get(length);
                for (ReferenceEntry referenceEntryB = referenceEntry; referenceEntryB != null; referenceEntryB = referenceEntryB.b()) {
                    Object key = referenceEntryB.getKey();
                    if (referenceEntryB.c() == i3 && key != null && this.f83573a.f83506f.d(obj, key)) {
                        ValueReference valueReferenceA = referenceEntryB.a();
                        if (!valueReferenceA.a() && (!z2 || jA - referenceEntryB.j() >= this.f83573a.f83514n)) {
                            this.f83576d++;
                            LoadingValueReference loadingValueReference = new LoadingValueReference(valueReferenceA);
                            referenceEntryB.i(loadingValueReference);
                            unlock();
                            G();
                            return loadingValueReference;
                        }
                        unlock();
                        G();
                        return null;
                    }
                }
                this.f83576d++;
                LoadingValueReference loadingValueReference2 = new LoadingValueReference();
                ReferenceEntry referenceEntryD = D(obj, i3, referenceEntry);
                referenceEntryD.i(loadingValueReference2);
                atomicReferenceArray.set(length, referenceEntryD);
                unlock();
                G();
                return loadingValueReference2;
            } catch (Throwable th) {
                unlock();
                G();
                throw th;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    enum Strength {
        STRONG { // from class: com.google.common.cache.LocalCache.Strength.1
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence b() {
                return Equivalence.c();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            ValueReference c(Segment segment, ReferenceEntry referenceEntry, Object obj, int i3) {
                return i3 == 1 ? new StrongValueReference(obj) : new WeightedStrongValueReference(obj, i3);
            }
        },
        SOFT { // from class: com.google.common.cache.LocalCache.Strength.2
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence b() {
                return Equivalence.f();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            ValueReference c(Segment segment, ReferenceEntry referenceEntry, Object obj, int i3) {
                return i3 == 1 ? new SoftValueReference(segment.f83581j, obj, referenceEntry) : new WeightedSoftValueReference(segment.f83581j, obj, referenceEntry, i3);
            }
        },
        WEAK { // from class: com.google.common.cache.LocalCache.Strength.3
            @Override // com.google.common.cache.LocalCache.Strength
            Equivalence b() {
                return Equivalence.f();
            }

            @Override // com.google.common.cache.LocalCache.Strength
            ValueReference c(Segment segment, ReferenceEntry referenceEntry, Object obj, int i3) {
                return i3 == 1 ? new WeakValueReference(segment.f83581j, obj, referenceEntry) : new WeightedWeakValueReference(segment.f83581j, obj, referenceEntry, i3);
            }
        };

        abstract Equivalence b();

        abstract ValueReference c(Segment segment, ReferenceEntry referenceEntry, Object obj, int i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StrongAccessEntry<K, V> extends StrongEntry<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile long f83592f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ReferenceEntry f83593g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ReferenceEntry f83594h;

        StrongAccessEntry(Object obj, int i3, ReferenceEntry referenceEntry) {
            super(obj, i3, referenceEntry);
            this.f83592f = Long.MAX_VALUE;
            this.f83593g = LocalCache.p();
            this.f83594h = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry d() {
            return this.f83594h;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry f() {
            return this.f83593g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void g(ReferenceEntry referenceEntry) {
            this.f83594h = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void k(long j3) {
            this.f83592f = j3;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long l() {
            return this.f83592f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void n(ReferenceEntry referenceEntry) {
            this.f83593g = referenceEntry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StrongAccessWriteEntry<K, V> extends StrongEntry<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile long f83595f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ReferenceEntry f83596g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ReferenceEntry f83597h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        volatile long f83598i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        ReferenceEntry f83599j;

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        ReferenceEntry f83600k;

        StrongAccessWriteEntry(Object obj, int i3, ReferenceEntry referenceEntry) {
            super(obj, i3, referenceEntry);
            this.f83595f = Long.MAX_VALUE;
            this.f83596g = LocalCache.p();
            this.f83597h = LocalCache.p();
            this.f83598i = Long.MAX_VALUE;
            this.f83599j = LocalCache.p();
            this.f83600k = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry d() {
            return this.f83597h;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry e() {
            return this.f83599j;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry f() {
            return this.f83596g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void g(ReferenceEntry referenceEntry) {
            this.f83597h = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry h() {
            return this.f83600k;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long j() {
            return this.f83598i;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void k(long j3) {
            this.f83595f = j3;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long l() {
            return this.f83595f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void m(long j3) {
            this.f83598i = j3;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void n(ReferenceEntry referenceEntry) {
            this.f83596g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry referenceEntry) {
            this.f83599j = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry referenceEntry) {
            this.f83600k = referenceEntry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class StrongEntry<K, V> extends AbstractReferenceEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f83601a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f83602b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final ReferenceEntry f83603c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile ValueReference f83604d = LocalCache.C();

        StrongEntry(Object obj, int i3, ReferenceEntry referenceEntry) {
            this.f83601a = obj;
            this.f83602b = i3;
            this.f83603c = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ValueReference a() {
            return this.f83604d;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry b() {
            return this.f83603c;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public int c() {
            return this.f83602b;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return this.f83601a;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void i(ValueReference valueReference) {
            this.f83604d = valueReference;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class StrongWriteEntry<K, V> extends StrongEntry<K, V> {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        volatile long f83606f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ReferenceEntry f83607g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        ReferenceEntry f83608h;

        StrongWriteEntry(Object obj, int i3, ReferenceEntry referenceEntry) {
            super(obj, i3, referenceEntry);
            this.f83606f = Long.MAX_VALUE;
            this.f83607g = LocalCache.p();
            this.f83608h = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry e() {
            return this.f83607g;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry h() {
            return this.f83608h;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public long j() {
            return this.f83606f;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void m(long j3) {
            this.f83606f = j3;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry referenceEntry) {
            this.f83607g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry referenceEntry) {
            this.f83608h = referenceEntry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class ValueIterator extends LocalCache<K, V>.HashIterator<V> {
        ValueIterator() {
            super();
        }

        @Override // java.util.Iterator
        public Object next() {
            return c().getValue();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    interface ValueReference<K, V> {
        boolean a();

        int b();

        ReferenceEntry c();

        void d(Object obj);

        ValueReference e(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry);

        Object f();

        Object get();

        boolean isActive();
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class Values extends AbstractCollection<V> {
        Values() {
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public void clear() throws Throwable {
            LocalCache.this.clear();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return LocalCache.this.containsValue(obj);
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return LocalCache.this.isEmpty();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new ValueIterator();
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            return LocalCache.this.size();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeakAccessEntry<K, V> extends WeakEntry<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f83611d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ReferenceEntry f83612f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ReferenceEntry f83613g;

        WeakAccessEntry(ReferenceQueue referenceQueue, Object obj, int i3, ReferenceEntry referenceEntry) {
            super(referenceQueue, obj, i3, referenceEntry);
            this.f83611d = Long.MAX_VALUE;
            this.f83612f = LocalCache.p();
            this.f83613g = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry d() {
            return this.f83613g;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry f() {
            return this.f83612f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void g(ReferenceEntry referenceEntry) {
            this.f83613g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void k(long j3) {
            this.f83611d = j3;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long l() {
            return this.f83611d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void n(ReferenceEntry referenceEntry) {
            this.f83612f = referenceEntry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeakAccessWriteEntry<K, V> extends WeakEntry<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f83614d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ReferenceEntry f83615f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ReferenceEntry f83616g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        volatile long f83617h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        ReferenceEntry f83618i;

        /* JADX INFO: renamed from: j, reason: collision with root package name */
        ReferenceEntry f83619j;

        WeakAccessWriteEntry(ReferenceQueue referenceQueue, Object obj, int i3, ReferenceEntry referenceEntry) {
            super(referenceQueue, obj, i3, referenceEntry);
            this.f83614d = Long.MAX_VALUE;
            this.f83615f = LocalCache.p();
            this.f83616g = LocalCache.p();
            this.f83617h = Long.MAX_VALUE;
            this.f83618i = LocalCache.p();
            this.f83619j = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry d() {
            return this.f83616g;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry e() {
            return this.f83618i;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry f() {
            return this.f83615f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void g(ReferenceEntry referenceEntry) {
            this.f83616g = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry h() {
            return this.f83619j;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long j() {
            return this.f83617h;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void k(long j3) {
            this.f83614d = j3;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long l() {
            return this.f83614d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void m(long j3) {
            this.f83617h = j3;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void n(ReferenceEntry referenceEntry) {
            this.f83615f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry referenceEntry) {
            this.f83618i = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry referenceEntry) {
            this.f83619j = referenceEntry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class WeakEntry<K, V> extends WeakReference<K> implements ReferenceEntry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f83620a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final ReferenceEntry f83621b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        volatile ValueReference f83622c;

        WeakEntry(ReferenceQueue referenceQueue, Object obj, int i3, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.f83622c = LocalCache.C();
            this.f83620a = i3;
            this.f83621b = referenceEntry;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference a() {
            return this.f83622c;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry b() {
            return this.f83621b;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int c() {
            return this.f83620a;
        }

        public ReferenceEntry d() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry e() {
            throw new UnsupportedOperationException();
        }

        public ReferenceEntry f() {
            throw new UnsupportedOperationException();
        }

        public void g(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return get();
        }

        public ReferenceEntry h() {
            throw new UnsupportedOperationException();
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void i(ValueReference valueReference) {
            this.f83622c = valueReference;
        }

        public long j() {
            throw new UnsupportedOperationException();
        }

        public void k(long j3) {
            throw new UnsupportedOperationException();
        }

        public long l() {
            throw new UnsupportedOperationException();
        }

        public void m(long j3) {
            throw new UnsupportedOperationException();
        }

        public void n(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void o(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }

        public void p(ReferenceEntry referenceEntry) {
            throw new UnsupportedOperationException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeakWriteEntry<K, V> extends WeakEntry<K, V> {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        volatile long f83624d;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        ReferenceEntry f83625f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        ReferenceEntry f83626g;

        WeakWriteEntry(ReferenceQueue referenceQueue, Object obj, int i3, ReferenceEntry referenceEntry) {
            super(referenceQueue, obj, i3, referenceEntry);
            this.f83624d = Long.MAX_VALUE;
            this.f83625f = LocalCache.p();
            this.f83626g = LocalCache.p();
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry e() {
            return this.f83625f;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public ReferenceEntry h() {
            return this.f83626g;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public long j() {
            return this.f83624d;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void m(long j3) {
            this.f83624d = j3;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry referenceEntry) {
            this.f83625f = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.WeakEntry, com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry referenceEntry) {
            this.f83626g = referenceEntry;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeightedSoftValueReference<K, V> extends SoftValueReference<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f83627b;

        WeightedSoftValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry, int i3) {
            super(referenceQueue, obj, referenceEntry);
            this.f83627b = i3;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return this.f83627b;
        }

        @Override // com.google.common.cache.LocalCache.SoftValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference e(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeightedSoftValueReference(referenceQueue, obj, referenceEntry, this.f83627b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeightedStrongValueReference<K, V> extends StrongValueReference<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f83628b;

        WeightedStrongValueReference(Object obj, int i3) {
            super(obj);
            this.f83628b = i3;
        }

        @Override // com.google.common.cache.LocalCache.StrongValueReference, com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return this.f83628b;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WeightedWeakValueReference<K, V> extends WeakValueReference<K, V> {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final int f83629b;

        WeightedWeakValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry, int i3) {
            super(referenceQueue, obj, referenceEntry);
            this.f83629b = i3;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return this.f83629b;
        }

        @Override // com.google.common.cache.LocalCache.WeakValueReference, com.google.common.cache.LocalCache.ValueReference
        public ValueReference e(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeightedWeakValueReference(referenceQueue, obj, referenceEntry, this.f83629b);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static final class WriteQueue<K, V> extends AbstractQueue<ReferenceEntry<K, V>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ReferenceEntry f83630a = new AbstractReferenceEntry<K, V>() { // from class: com.google.common.cache.LocalCache.WriteQueue.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            ReferenceEntry f83631a = this;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            ReferenceEntry f83632b = this;

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry e() {
                return this.f83631a;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public ReferenceEntry h() {
                return this.f83632b;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public long j() {
                return Long.MAX_VALUE;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void o(ReferenceEntry referenceEntry) {
                this.f83631a = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void p(ReferenceEntry referenceEntry) {
                this.f83632b = referenceEntry;
            }

            @Override // com.google.common.cache.LocalCache.AbstractReferenceEntry, com.google.common.cache.ReferenceEntry
            public void m(long j3) {
            }
        };

        WriteQueue() {
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean offer(ReferenceEntry referenceEntry) {
            LocalCache.b(referenceEntry.h(), referenceEntry.e());
            LocalCache.b(this.f83630a.h(), referenceEntry);
            LocalCache.b(referenceEntry, this.f83630a);
            return true;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public ReferenceEntry peek() {
            ReferenceEntry referenceEntryE = this.f83630a.e();
            if (referenceEntryE == this.f83630a) {
                return null;
            }
            return referenceEntryE;
        }

        @Override // java.util.AbstractQueue, java.util.AbstractCollection, java.util.Collection
        public void clear() {
            ReferenceEntry referenceEntryE = this.f83630a.e();
            while (true) {
                ReferenceEntry referenceEntry = this.f83630a;
                if (referenceEntryE == referenceEntry) {
                    referenceEntry.o(referenceEntry);
                    ReferenceEntry referenceEntry2 = this.f83630a;
                    referenceEntry2.p(referenceEntry2);
                    return;
                } else {
                    ReferenceEntry referenceEntryE2 = referenceEntryE.e();
                    LocalCache.r(referenceEntryE);
                    referenceEntryE = referenceEntryE2;
                }
            }
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean contains(Object obj) {
            return ((ReferenceEntry) obj).e() != NullEntry.INSTANCE;
        }

        @Override // java.util.Queue
        /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
        public ReferenceEntry poll() {
            ReferenceEntry referenceEntryE = this.f83630a.e();
            if (referenceEntryE == this.f83630a) {
                return null;
            }
            remove(referenceEntryE);
            return referenceEntryE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean isEmpty() {
            return this.f83630a.e() == this.f83630a;
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new AbstractSequentialIterator<ReferenceEntry<K, V>>(peek()) { // from class: com.google.common.cache.LocalCache.WriteQueue.2
                /* JADX INFO: Access modifiers changed from: protected */
                @Override // com.google.common.collect.AbstractSequentialIterator
                /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
                public ReferenceEntry a(ReferenceEntry referenceEntry) {
                    ReferenceEntry referenceEntryE = referenceEntry.e();
                    if (referenceEntryE == WriteQueue.this.f83630a) {
                        return null;
                    }
                    return referenceEntryE;
                }
            };
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public boolean remove(Object obj) {
            ReferenceEntry referenceEntry = (ReferenceEntry) obj;
            ReferenceEntry referenceEntryH = referenceEntry.h();
            ReferenceEntry referenceEntryE = referenceEntry.e();
            LocalCache.b(referenceEntryH, referenceEntryE);
            LocalCache.r(referenceEntry);
            return referenceEntryE != NullEntry.INSTANCE;
        }

        @Override // java.util.AbstractCollection, java.util.Collection
        public int size() {
            int i3 = 0;
            for (ReferenceEntry referenceEntryE = this.f83630a.e(); referenceEntryE != this.f83630a; referenceEntryE = referenceEntryE.e()) {
                i3++;
            }
            return i3;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    final class WriteThroughEntry implements Map.Entry<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f83635a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        Object f83636b;

        WriteThroughEntry(Object obj, Object obj2) {
            this.f83635a = obj;
            this.f83636b = obj2;
        }

        @Override // java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj instanceof Map.Entry) {
                Map.Entry entry = (Map.Entry) obj;
                if (this.f83635a.equals(entry.getKey()) && this.f83636b.equals(entry.getValue())) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f83635a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f83636b;
        }

        @Override // java.util.Map.Entry
        public int hashCode() {
            return this.f83635a.hashCode() ^ this.f83636b.hashCode();
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            Object objPut = LocalCache.this.put(this.f83635a, obj);
            this.f83636b = obj;
            return objPut;
        }

        public String toString() {
            return getKey() + "=" + getValue();
        }
    }

    LocalCache(CacheBuilder cacheBuilder, CacheLoader cacheLoader) {
        this.f83505d = Math.min(cacheBuilder.h(), NativeProtocol.MESSAGE_GET_ACCESS_TOKEN_REQUEST);
        Strength strengthM = cacheBuilder.m();
        this.f83508h = strengthM;
        this.f83509i = cacheBuilder.t();
        this.f83506f = cacheBuilder.l();
        this.f83507g = cacheBuilder.s();
        long jN = cacheBuilder.n();
        this.f83510j = jN;
        this.f83511k = cacheBuilder.u();
        this.f83512l = cacheBuilder.i();
        this.f83513m = cacheBuilder.j();
        this.f83514n = cacheBuilder.o();
        RemovalListener removalListenerP = cacheBuilder.p();
        this.f83516p = removalListenerP;
        this.f83515o = removalListenerP == CacheBuilder.NullListener.INSTANCE ? e() : new ConcurrentLinkedQueue();
        this.f83517q = cacheBuilder.r(w());
        this.f83518r = EntryFactory.e(strengthM, D(), H());
        this.f83519s = (AbstractCache.StatsCounter) cacheBuilder.q().get();
        this.f83520t = cacheLoader;
        int iMin = Math.min(cacheBuilder.k(), 1073741824);
        if (f() && !d()) {
            iMin = (int) Math.min(iMin, jN);
        }
        int i3 = 0;
        int i4 = 1;
        int i5 = 0;
        int i6 = 1;
        while (i6 < this.f83505d && (!f() || ((long) i6) * 20 <= this.f83510j)) {
            i5++;
            i6 <<= 1;
        }
        this.f83503b = 32 - i5;
        this.f83502a = i6 - 1;
        this.f83504c = o(i6);
        int i7 = iMin / i6;
        while (i4 < (i7 * i6 < iMin ? i7 + 1 : i7)) {
            i4 <<= 1;
        }
        if (f()) {
            long j3 = this.f83510j;
            long j4 = i6;
            long j5 = (j3 / j4) + 1;
            long j6 = j3 % j4;
            while (true) {
                Segment[] segmentArr = this.f83504c;
                if (i3 >= segmentArr.length) {
                    return;
                }
                if (i3 == j6) {
                    j5--;
                }
                segmentArr[i3] = c(i4, j5, (AbstractCache.StatsCounter) cacheBuilder.q().get());
                i3++;
            }
        } else {
            while (true) {
                Segment[] segmentArr2 = this.f83504c;
                if (i3 >= segmentArr2.length) {
                    return;
                }
                segmentArr2[i3] = c(i4, -1L, (AbstractCache.StatsCounter) cacheBuilder.q().get());
                i3++;
            }
        }
    }

    static int A(int i3) {
        int i4 = i3 + ((i3 << 15) ^ (-12931));
        int i5 = i4 ^ (i4 >>> 10);
        int i6 = i5 + (i5 << 3);
        int i7 = i6 ^ (i6 >>> 6);
        int i8 = i7 + (i7 << 2) + (i7 << 14);
        return i8 ^ (i8 >>> 16);
    }

    static ValueReference C() {
        return f83500y;
    }

    static void a(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        referenceEntry.n(referenceEntry2);
        referenceEntry2.g(referenceEntry);
    }

    static void b(ReferenceEntry referenceEntry, ReferenceEntry referenceEntry2) {
        referenceEntry.o(referenceEntry2);
        referenceEntry2.p(referenceEntry);
    }

    static Queue e() {
        return f83501z;
    }

    static ReferenceEntry p() {
        return NullEntry.INSTANCE;
    }

    static void q(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntryP = p();
        referenceEntry.n(referenceEntryP);
        referenceEntry.g(referenceEntryP);
    }

    static void r(ReferenceEntry referenceEntry) {
        ReferenceEntry referenceEntryP = p();
        referenceEntry.o(referenceEntryP);
        referenceEntry.p(referenceEntryP);
    }

    Segment B(int i3) {
        return this.f83504c[(i3 >>> this.f83503b) & this.f83502a];
    }

    boolean D() {
        return E() || v();
    }

    boolean E() {
        return g() || f();
    }

    boolean F() {
        return this.f83508h != Strength.STRONG;
    }

    boolean G() {
        return this.f83509i != Strength.STRONG;
    }

    boolean H() {
        return I() || x();
    }

    boolean I() {
        return h();
    }

    Segment c(int i3, long j3, AbstractCache.StatsCounter statsCounter) {
        return new Segment(this, i3, j3, statsCounter);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() throws Throwable {
        for (Segment segment : this.f83504c) {
            segment.c();
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsKey(Object obj) {
        if (obj == null) {
            return false;
        }
        int iL = l(obj);
        return B(iL).g(obj, iL);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // java.util.AbstractMap, java.util.Map
    public boolean containsValue(Object obj) {
        int i3 = 0;
        if (obj == null) {
            return false;
        }
        long jA = this.f83517q.a();
        Segment[] segmentArr = this.f83504c;
        long j3 = -1;
        int i4 = 0;
        while (i4 < 3) {
            int length = segmentArr.length;
            long j4 = 0;
            int i5 = i3 == true ? 1 : 0;
            while (i5 < length) {
                Segment segment = segmentArr[i5];
                int i6 = segment.f83574b;
                AtomicReferenceArray atomicReferenceArray = segment.f83578g;
                int i7 = i3;
                while (i7 < atomicReferenceArray.length()) {
                    ReferenceEntry referenceEntryB = (ReferenceEntry) atomicReferenceArray.get(i7);
                    while (referenceEntryB != null) {
                        Segment[] segmentArr2 = segmentArr;
                        Object objW = segment.w(referenceEntryB, jA);
                        ReferenceEntry referenceEntry = referenceEntryB;
                        if (objW != null && this.f83507g.d(obj, objW)) {
                            return true;
                        }
                        referenceEntryB = referenceEntry.b();
                        segmentArr = segmentArr2;
                    }
                    i7++;
                }
                j4 += (long) segment.f83576d;
                i5++;
                i3 = i7;
            }
            boolean z2 = i3;
            Segment[] segmentArr3 = segmentArr;
            if (j4 == j3) {
                return z2;
            }
            i4++;
            j3 = j4;
            i3 = z2 ? 1 : 0;
            segmentArr = segmentArr3;
        }
        return i3 == true ? 1 : 0;
    }

    boolean d() {
        return this.f83511k != CacheBuilder.OneWeigher.INSTANCE;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set entrySet() {
        Set set = this.f83523w;
        if (set != null) {
            return set;
        }
        EntrySet entrySet = new EntrySet();
        this.f83523w = entrySet;
        return entrySet;
    }

    boolean f() {
        return this.f83510j >= 0;
    }

    boolean g() {
        return this.f83512l > 0;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        int iL = l(obj);
        return B(iL).q(obj, iL);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    boolean h() {
        return this.f83513m > 0;
    }

    Object i(Object obj, CacheLoader cacheLoader) {
        int iL = l(Preconditions.t(obj));
        return B(iL).r(obj, iL, cacheLoader);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public boolean isEmpty() {
        Segment[] segmentArr = this.f83504c;
        long j3 = 0;
        for (Segment segment : segmentArr) {
            if (segment.f83574b != 0) {
                return false;
            }
            j3 += (long) segment.f83576d;
        }
        if (j3 == 0) {
            return true;
        }
        for (Segment segment2 : segmentArr) {
            if (segment2.f83574b != 0) {
                return false;
            }
            j3 -= (long) segment2.f83576d;
        }
        return j3 == 0;
    }

    Object j(ReferenceEntry referenceEntry, long j3) {
        Object obj;
        if (referenceEntry.getKey() == null || (obj = referenceEntry.a().get()) == null || m(referenceEntry, j3)) {
            return null;
        }
        return obj;
    }

    Object k(Object obj) {
        return i(obj, this.f83520t);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Set keySet() {
        Set set = this.f83521u;
        if (set != null) {
            return set;
        }
        KeySet keySet = new KeySet();
        this.f83521u = keySet;
        return keySet;
    }

    int l(Object obj) {
        return A(this.f83506f.e(obj));
    }

    boolean m(ReferenceEntry referenceEntry, long j3) {
        Preconditions.t(referenceEntry);
        if (!g() || j3 - referenceEntry.l() < this.f83512l) {
            return h() && j3 - referenceEntry.j() >= this.f83513m;
        }
        return true;
    }

    long n() {
        long jMax = 0;
        for (Segment segment : this.f83504c) {
            jMax += (long) Math.max(0, segment.f83574b);
        }
        return jMax;
    }

    final Segment[] o(int i3) {
        return new Segment[i3];
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Preconditions.t(obj);
        Preconditions.t(obj2);
        int iL = l(obj);
        return B(iL).I(obj, iL, obj2, false);
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
        int iL = l(obj);
        return B(iL).I(obj, iL, obj2, true);
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        int iL = l(obj);
        return B(iL).Q(obj, iL);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean replace(Object obj, Object obj2, Object obj3) {
        Preconditions.t(obj);
        Preconditions.t(obj3);
        if (obj2 == null) {
            return false;
        }
        int iL = l(obj);
        return B(iL).Y(obj, iL, obj2, obj3);
    }

    void s() {
        while (true) {
            RemovalNotification removalNotification = (RemovalNotification) this.f83515o.poll();
            if (removalNotification == null) {
                return;
            }
            try {
                this.f83516p.a(removalNotification);
            } catch (Throwable th) {
                f83499x.log(Level.WARNING, "Exception thrown by removal listener", th);
            }
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public int size() {
        return Ints.m(n());
    }

    void t(ReferenceEntry referenceEntry) throws Throwable {
        int iC = referenceEntry.c();
        B(iC).J(referenceEntry, iC);
    }

    void u(ValueReference valueReference) throws Throwable {
        ReferenceEntry referenceEntryC = valueReference.c();
        int iC = referenceEntryC.c();
        B(iC).K(referenceEntryC.getKey(), iC, valueReference);
    }

    boolean v() {
        return g();
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Collection values() {
        Collection collection = this.f83522v;
        if (collection != null) {
            return collection;
        }
        Values values = new Values();
        this.f83522v = values;
        return values;
    }

    boolean w() {
        return x() || v();
    }

    boolean x() {
        return h() || y();
    }

    boolean y() {
        return this.f83514n > 0;
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public boolean remove(Object obj, Object obj2) {
        if (obj == null || obj2 == null) {
            return false;
        }
        int iL = l(obj);
        return B(iL).R(obj, iL, obj2);
    }

    @Override // java.util.Map, java.util.concurrent.ConcurrentMap
    public Object replace(Object obj, Object obj2) {
        Preconditions.t(obj);
        Preconditions.t(obj2);
        int iL = l(obj);
        return B(iL).X(obj, iL, obj2);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum NullEntry implements ReferenceEntry<Object, Object> {
        INSTANCE;

        @Override // com.google.common.cache.ReferenceEntry
        public ValueReference a() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry b() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public int c() {
            return 0;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public Object getKey() {
            return null;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long j() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public long l() {
            return 0L;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry d() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry e() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry f() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public ReferenceEntry h() {
            return this;
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void g(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void i(ValueReference valueReference) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void k(long j3) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void m(long j3) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void n(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void o(ReferenceEntry referenceEntry) {
        }

        @Override // com.google.common.cache.ReferenceEntry
        public void p(ReferenceEntry referenceEntry) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class SoftValueReference<K, V> extends SoftReference<V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ReferenceEntry f83587a;

        SoftValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.f83587a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean a() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry c() {
            return this.f83587a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference e(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new SoftValueReference(referenceQueue, obj, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object f() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void d(Object obj) {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class StrongValueReference<K, V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final Object f83605a;

        StrongValueReference(Object obj) {
            this.f83605a = obj;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean a() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry c() {
            return null;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object f() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object get() {
            return this.f83605a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void d(Object obj) {
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference e(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return this;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class WeakValueReference<K, V> extends WeakReference<V> implements ValueReference<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ReferenceEntry f83623a;

        WeakValueReference(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            super(obj, referenceQueue);
            this.f83623a = referenceEntry;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean a() {
            return false;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public int b() {
            return 1;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ReferenceEntry c() {
            return this.f83623a;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public ValueReference e(ReferenceQueue referenceQueue, Object obj, ReferenceEntry referenceEntry) {
            return new WeakValueReference(referenceQueue, obj, referenceEntry);
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public Object f() {
            return get();
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public boolean isActive() {
            return true;
        }

        @Override // com.google.common.cache.LocalCache.ValueReference
        public void d(Object obj) {
        }
    }
}
