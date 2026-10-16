package kotlinx.coroutines.debug.internal;

import java.lang.ref.ReferenceQueue;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceArray;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.AbstractMutableMap;
import kotlin.collections.AbstractMutableSet;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableIterator;
import kotlin.jvm.internal.markers.KMutableMap;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.channels.d;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
@Metadata
public final class ConcurrentWeakMap<K, V> extends AbstractMutableMap<K, V> {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final /* synthetic */ AtomicIntegerFieldUpdater f141391b = AtomicIntegerFieldUpdater.newUpdater(ConcurrentWeakMap.class, "_size$volatile");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final /* synthetic */ AtomicReferenceFieldUpdater f141392c = AtomicReferenceFieldUpdater.newUpdater(ConcurrentWeakMap.class, Object.class, "core$volatile");
    private volatile /* synthetic */ int _size$volatile;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ReferenceQueue f141393a;
    private volatile /* synthetic */ Object core$volatile;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class Core {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private static final /* synthetic */ AtomicIntegerFieldUpdater f141394g = AtomicIntegerFieldUpdater.newUpdater(Core.class, "load$volatile");

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f141395a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f141396b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f141397c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final /* synthetic */ AtomicReferenceArray f141398d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private final /* synthetic */ AtomicReferenceArray f141399e;
        private volatile /* synthetic */ int load$volatile;

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        private final class KeyValueIterator<E> implements Iterator<E>, KMutableIterator {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final Function2 f141401a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            private int f141402b = -1;

            /* JADX INFO: renamed from: c, reason: collision with root package name */
            private Object f141403c;

            /* JADX INFO: renamed from: d, reason: collision with root package name */
            private Object f141404d;

            public KeyValueIterator(Function2 function2) {
                this.f141401a = function2;
                a();
            }

            private final void a() {
                T t2;
                while (true) {
                    int i3 = this.f141402b + 1;
                    this.f141402b = i3;
                    if (i3 >= Core.this.f141395a) {
                        return;
                    }
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) Core.this.e().get(this.f141402b);
                    if (hashedWeakRef != null && (t2 = hashedWeakRef.get()) != 0) {
                        this.f141403c = t2;
                        Object obj = Core.this.g().get(this.f141402b);
                        if (obj instanceof Marked) {
                            obj = ((Marked) obj).f141458a;
                        }
                        if (obj != null) {
                            this.f141404d = obj;
                            return;
                        }
                    }
                }
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public Void remove() {
                ConcurrentWeakMapKt.e();
                throw new KotlinNothingValueException();
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.f141402b < Core.this.f141395a;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (this.f141402b >= Core.this.f141395a) {
                    throw new NoSuchElementException();
                }
                Function2 function2 = this.f141401a;
                Object obj = this.f141403c;
                if (obj == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("key");
                    obj = Unit.f139807a;
                }
                Object obj2 = this.f141404d;
                if (obj2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("value");
                    obj2 = Unit.f139807a;
                }
                Object objInvoke = function2.invoke(obj, obj2);
                a();
                return objInvoke;
            }
        }

        public Core(int i3) {
            this.f141395a = i3;
            this.f141396b = Integer.numberOfLeadingZeros(i3) + 1;
            this.f141397c = (i3 * 2) / 3;
            this.f141398d = new AtomicReferenceArray(i3);
            this.f141399e = new AtomicReferenceArray(i3);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final /* synthetic */ AtomicReferenceArray e() {
            return this.f141398d;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final /* synthetic */ AtomicReferenceArray g() {
            return this.f141399e;
        }

        private final int h(int i3) {
            return (i3 * (-1640531527)) >>> this.f141396b;
        }

        public static /* synthetic */ Object k(Core core, Object obj, Object obj2, HashedWeakRef hashedWeakRef, int i3, Object obj3) {
            if ((i3 & 4) != 0) {
                hashedWeakRef = null;
            }
            return core.j(obj, obj2, hashedWeakRef);
        }

        private final void m(int i3) {
            Object obj;
            do {
                obj = g().get(i3);
                if (obj == null || (obj instanceof Marked)) {
                    return;
                }
            } while (!d.a(g(), i3, obj, null));
            ConcurrentWeakMap.this.h();
        }

        public final Object d(Object obj) {
            int iH = h(obj.hashCode());
            while (true) {
                HashedWeakRef hashedWeakRef = (HashedWeakRef) e().get(iH);
                if (hashedWeakRef == null) {
                    return null;
                }
                T t2 = hashedWeakRef.get();
                if (Intrinsics.areEqual(obj, t2)) {
                    Object obj2 = g().get(iH);
                    return obj2 instanceof Marked ? ((Marked) obj2).f141458a : obj2;
                }
                if (t2 == 0) {
                    m(iH);
                }
                if (iH == 0) {
                    iH = this.f141395a;
                }
                iH--;
            }
        }

        public final Iterator i(Function2 function2) {
            return new KeyValueIterator(function2);
        }

        public final Object j(Object obj, Object obj2, HashedWeakRef hashedWeakRef) {
            int i3;
            Object obj3;
            int iH = h(obj.hashCode());
            boolean z2 = false;
            while (true) {
                HashedWeakRef hashedWeakRef2 = (HashedWeakRef) e().get(iH);
                if (hashedWeakRef2 != null) {
                    T t2 = hashedWeakRef2.get();
                    if (!Intrinsics.areEqual(obj, t2)) {
                        if (t2 == 0) {
                            m(iH);
                        }
                        if (iH == 0) {
                            iH = this.f141395a;
                        }
                        iH--;
                    } else if (z2) {
                        f141394g.decrementAndGet(this);
                    }
                } else if (obj2 != null) {
                    if (!z2) {
                        AtomicIntegerFieldUpdater atomicIntegerFieldUpdater = f141394g;
                        do {
                            i3 = atomicIntegerFieldUpdater.get(this);
                            if (i3 >= this.f141397c) {
                                return ConcurrentWeakMapKt.f141410a;
                            }
                        } while (!atomicIntegerFieldUpdater.compareAndSet(this, i3, i3 + 1));
                        z2 = true;
                    }
                    if (hashedWeakRef == null) {
                        hashedWeakRef = new HashedWeakRef(obj, ConcurrentWeakMap.this.f141393a);
                    }
                    if (d.a(e(), iH, null, hashedWeakRef)) {
                        break;
                    }
                } else {
                    return null;
                }
            }
            do {
                obj3 = g().get(iH);
                if (obj3 instanceof Marked) {
                    return ConcurrentWeakMapKt.f141410a;
                }
            } while (!d.a(g(), iH, obj3, obj2));
            return obj3;
        }

        public final Core l() {
            int i3;
            Object obj;
            while (true) {
                Core core = new Core(Integer.highestOneBit(RangesKt.f(ConcurrentWeakMap.this.size(), 4)) * 4);
                int i4 = this.f141395a;
                while (i3 < i4) {
                    HashedWeakRef hashedWeakRef = (HashedWeakRef) e().get(i3);
                    Object obj2 = hashedWeakRef != null ? hashedWeakRef.get() : null;
                    if (hashedWeakRef != null && obj2 == null) {
                        m(i3);
                    }
                    while (true) {
                        obj = g().get(i3);
                        if (obj instanceof Marked) {
                            obj = ((Marked) obj).f141458a;
                            break;
                        }
                        if (d.a(g(), i3, obj, ConcurrentWeakMapKt.d(obj))) {
                            break;
                        }
                    }
                    i3 = (obj2 == null || obj == null || core.j(obj2, obj, hashedWeakRef) != ConcurrentWeakMapKt.f141410a) ? i3 + 1 : 0;
                }
                return core;
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class Entry<K, V> implements Map.Entry<K, V>, KMutableMap.Entry {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f141406a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final Object f141407b;

        public Entry(Object obj, Object obj2) {
            this.f141406a = obj;
            this.f141407b = obj2;
        }

        @Override // java.util.Map.Entry
        public Object getKey() {
            return this.f141406a;
        }

        @Override // java.util.Map.Entry
        public Object getValue() {
            return this.f141407b;
        }

        @Override // java.util.Map.Entry
        public Object setValue(Object obj) {
            ConcurrentWeakMapKt.e();
            throw new KotlinNothingValueException();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class KeyValueSet<E> extends AbstractMutableSet<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Function2 f141408a;

        public KeyValueSet(Function2 function2) {
            this.f141408a = function2;
        }

        @Override // kotlin.collections.AbstractMutableSet, java.util.AbstractCollection, java.util.Collection, java.util.Set
        public boolean add(Object obj) {
            ConcurrentWeakMapKt.e();
            throw new KotlinNothingValueException();
        }

        @Override // kotlin.collections.AbstractMutableSet
        public int getSize() {
            return ConcurrentWeakMap.this.size();
        }

        @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
        public Iterator iterator() {
            return ((Core) ConcurrentWeakMap.i().get(ConcurrentWeakMap.this)).i(this.f141408a);
        }
    }

    public /* synthetic */ ConcurrentWeakMap(boolean z2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? false : z2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map.Entry c(Object obj, Object obj2) {
        return new Entry(obj, obj2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void h() {
        f141391b.decrementAndGet(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final /* synthetic */ AtomicReferenceFieldUpdater i() {
        return f141392c;
    }

    private final synchronized Object k(Object obj, Object obj2) {
        Object objK;
        Core coreL = (Core) f141392c.get(this);
        while (true) {
            Object obj3 = obj;
            Object obj4 = obj2;
            objK = Core.k(coreL, obj3, obj4, null, 4, null);
            if (objK == ConcurrentWeakMapKt.f141410a) {
                coreL = coreL.l();
                f141392c.set(this, coreL);
                obj = obj3;
                obj2 = obj4;
            }
        }
        return objK;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public void clear() {
        Iterator<K> it = keySet().iterator();
        while (it.hasNext()) {
            remove(it.next());
        }
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object get(Object obj) {
        if (obj == null) {
            return null;
        }
        return ((Core) f141392c.get(this)).d(obj);
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set getEntries() {
        return new KeyValueSet(new Function2() { // from class: kotlinx.coroutines.debug.internal.b
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ConcurrentWeakMap.c(obj, obj2);
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    public Set getKeys() {
        return new KeyValueSet(new Function2() { // from class: kotlinx.coroutines.debug.internal.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return ConcurrentWeakMap.d(obj, obj2);
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableMap
    public int getSize() {
        return f141391b.get(this);
    }

    @Override // kotlin.collections.AbstractMutableMap, java.util.AbstractMap, java.util.Map
    public Object put(Object obj, Object obj2) {
        Object objK = Core.k((Core) f141392c.get(this), obj, obj2, null, 4, null);
        if (objK == ConcurrentWeakMapKt.f141410a) {
            objK = k(obj, obj2);
        }
        if (objK == null) {
            f141391b.incrementAndGet(this);
        }
        return objK;
    }

    @Override // java.util.AbstractMap, java.util.Map
    public Object remove(Object obj) {
        if (obj == null) {
            return null;
        }
        Object objK = Core.k((Core) f141392c.get(this), obj, null, null, 4, null);
        if (objK == ConcurrentWeakMapKt.f141410a) {
            objK = k(obj, null);
        }
        if (objK != null) {
            f141391b.decrementAndGet(this);
        }
        return objK;
    }

    public ConcurrentWeakMap(boolean z2) {
        this.core$volatile = new Core(16);
        this.f141393a = z2 ? new ReferenceQueue() : null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object d(Object obj, Object obj2) {
        return obj;
    }
}
