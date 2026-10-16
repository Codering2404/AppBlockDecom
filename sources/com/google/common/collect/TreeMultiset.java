package com.google.common.collect;

import com.facebook.AuthenticationToken;
import com.google.common.base.MoreObjects;
import com.google.common.base.Preconditions;
import com.google.common.collect.Multiset;
import com.google.common.collect.Multisets;
import com.google.common.primitives.Ints;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NavigableSet;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.Set;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
@ElementTypesAreNonnullByDefault
public final class TreeMultiset<E> extends AbstractSortedMultiset<E> implements Serializable {
    private static final long serialVersionUID = 1;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final transient Reference f84775f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final transient GeneralRange f84776g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final transient AvlNode f84777h;

    /* JADX INFO: renamed from: com.google.common.collect.TreeMultiset$4, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static /* synthetic */ class AnonymousClass4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f84786a;

        static {
            int[] iArr = new int[BoundType.values().length];
            f84786a = iArr;
            try {
                iArr[BoundType.OPEN.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f84786a[BoundType.CLOSED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private enum Aggregate {
        SIZE { // from class: com.google.common.collect.TreeMultiset.Aggregate.1
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int b(AvlNode avlNode) {
                return avlNode.f84791b;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long c(AvlNode avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return avlNode.f84793d;
            }
        },
        DISTINCT { // from class: com.google.common.collect.TreeMultiset.Aggregate.2
            @Override // com.google.common.collect.TreeMultiset.Aggregate
            int b(AvlNode avlNode) {
                return 1;
            }

            @Override // com.google.common.collect.TreeMultiset.Aggregate
            long c(AvlNode avlNode) {
                if (avlNode == null) {
                    return 0L;
                }
                return avlNode.f84792c;
            }
        };

        abstract int b(AvlNode avlNode);

        abstract long c(AvlNode avlNode);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class Reference<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Object f84799a;

        private Reference() {
        }

        public void a(Object obj, Object obj2) {
            if (this.f84799a != obj) {
                throw new ConcurrentModificationException();
            }
            this.f84799a = obj2;
        }

        void b() {
            this.f84799a = null;
        }

        public Object c() {
            return this.f84799a;
        }
    }

    TreeMultiset(Reference reference, GeneralRange generalRange, AvlNode avlNode) {
        super(generalRange.b());
        this.f84775f = reference;
        this.f84776g = generalRange;
        this.f84777h = avlNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AvlNode A() {
        AvlNode avlNodeZ;
        AvlNode avlNode = (AvlNode) this.f84775f.c();
        if (avlNode == null) {
            return null;
        }
        if (this.f84776g.j()) {
            Object objA = NullnessCasts.a(this.f84776g.h());
            avlNodeZ = avlNode.v(comparator(), objA);
            if (avlNodeZ == null) {
                return null;
            }
            if (this.f84776g.g() == BoundType.OPEN && comparator().compare(objA, avlNodeZ.x()) == 0) {
                avlNodeZ = avlNodeZ.z();
            }
        } else {
            avlNodeZ = this.f84777h.z();
        }
        if (avlNodeZ == this.f84777h || !this.f84776g.c(avlNodeZ.x())) {
            return null;
        }
        return avlNodeZ;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void B(AvlNode avlNode, AvlNode avlNode2) {
        avlNode.f84798i = avlNode2;
        avlNode2.f84797h = avlNode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void C(AvlNode avlNode, AvlNode avlNode2, AvlNode avlNode3) {
        B(avlNode, avlNode2);
        B(avlNode2, avlNode3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Multiset.Entry D(final AvlNode avlNode) {
        return new Multisets.AbstractEntry<E>(this) { // from class: com.google.common.collect.TreeMultiset.1

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ TreeMultiset f84779b;

            {
                this.f84779b = this;
            }

            @Override // com.google.common.collect.Multiset.Entry
            public Object a() {
                return avlNode.x();
            }

            @Override // com.google.common.collect.Multiset.Entry
            public int getCount() {
                int iW = avlNode.w();
                return iW == 0 ? this.f84779b.Y1(a()) : iW;
            }
        };
    }

    private void readObject(ObjectInputStream objectInputStream) throws ClassNotFoundException, IOException {
        objectInputStream.defaultReadObject();
        Object object = objectInputStream.readObject();
        Objects.requireNonNull(object);
        Comparator comparator = (Comparator) object;
        Serialization.a(AbstractSortedMultiset.class, "comparator").b(this, comparator);
        Serialization.a(TreeMultiset.class, "range").b(this, GeneralRange.a(comparator));
        Serialization.a(TreeMultiset.class, "rootReference").b(this, new Reference());
        AvlNode avlNode = new AvlNode();
        Serialization.a(TreeMultiset.class, AuthenticationToken.HEADER_KEY).b(this, avlNode);
        B(avlNode, avlNode);
        Serialization.f(this, objectInputStream);
    }

    private long v(Aggregate aggregate, AvlNode avlNode) {
        long jC;
        long jV;
        if (avlNode == null) {
            return 0L;
        }
        int iCompare = comparator().compare(NullnessCasts.a(this.f84776g.h()), avlNode.x());
        if (iCompare > 0) {
            return v(aggregate, avlNode.f84796g);
        }
        if (iCompare == 0) {
            int i3 = AnonymousClass4.f84786a[this.f84776g.g().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return aggregate.c(avlNode.f84796g);
                }
                throw new AssertionError();
            }
            jC = aggregate.b(avlNode);
            jV = aggregate.c(avlNode.f84796g);
        } else {
            jC = aggregate.c(avlNode.f84796g) + ((long) aggregate.b(avlNode));
            jV = v(aggregate, avlNode.f84795f);
        }
        return jC + jV;
    }

    private long w(Aggregate aggregate, AvlNode avlNode) {
        long jC;
        long jW;
        if (avlNode == null) {
            return 0L;
        }
        int iCompare = comparator().compare(NullnessCasts.a(this.f84776g.f()), avlNode.x());
        if (iCompare < 0) {
            return w(aggregate, avlNode.f84795f);
        }
        if (iCompare == 0) {
            int i3 = AnonymousClass4.f84786a[this.f84776g.e().ordinal()];
            if (i3 != 1) {
                if (i3 == 2) {
                    return aggregate.c(avlNode.f84795f);
                }
                throw new AssertionError();
            }
            jC = aggregate.b(avlNode);
            jW = aggregate.c(avlNode.f84795f);
        } else {
            jC = aggregate.c(avlNode.f84795f) + ((long) aggregate.b(avlNode));
            jW = w(aggregate, avlNode.f84796g);
        }
        return jC + jW;
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(i().comparator());
        Serialization.k(this, objectOutputStream);
    }

    private long x(Aggregate aggregate) {
        AvlNode avlNode = (AvlNode) this.f84775f.c();
        long jC = aggregate.c(avlNode);
        if (this.f84776g.i()) {
            jC -= w(aggregate, avlNode);
        }
        return this.f84776g.j() ? jC - v(aggregate, avlNode) : jC;
    }

    static int y(AvlNode avlNode) {
        if (avlNode == null) {
            return 0;
        }
        return avlNode.f84792c;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public AvlNode z() {
        AvlNode avlNodeL;
        AvlNode avlNode = (AvlNode) this.f84775f.c();
        if (avlNode == null) {
            return null;
        }
        if (this.f84776g.i()) {
            Object objA = NullnessCasts.a(this.f84776g.f());
            avlNodeL = avlNode.s(comparator(), objA);
            if (avlNodeL == null) {
                return null;
            }
            if (this.f84776g.e() == BoundType.OPEN && comparator().compare(objA, avlNodeL.x()) == 0) {
                avlNodeL = avlNodeL.L();
            }
        } else {
            avlNodeL = this.f84777h.L();
        }
        if (avlNodeL == this.f84777h || !this.f84776g.c(avlNodeL.x())) {
            return null;
        }
        return avlNodeL;
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset A1() {
        return super.A1();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public boolean L1(Object obj, int i3, int i4) {
        CollectPreconditions.b(i4, "newCount");
        CollectPreconditions.b(i3, "oldCount");
        Preconditions.d(this.f84776g.c(obj));
        AvlNode avlNode = (AvlNode) this.f84775f.c();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.f84775f.a(avlNode, avlNode.J(comparator(), obj, i3, i4, iArr));
            return iArr[0] == i3;
        }
        if (i3 != 0) {
            return false;
        }
        if (i4 > 0) {
            t1(obj, i4);
        }
        return true;
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset Q1(Object obj, BoundType boundType) {
        return new TreeMultiset(this.f84775f, this.f84776g.k(GeneralRange.n(comparator(), obj, boundType)), this.f84777h);
    }

    @Override // com.google.common.collect.Multiset
    public int Y1(Object obj) {
        try {
            AvlNode avlNode = (AvlNode) this.f84775f.c();
            if (this.f84776g.c(obj) && avlNode != null) {
                return avlNode.t(comparator(), obj);
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        if (this.f84776g.i() || this.f84776g.j()) {
            Iterators.e(f());
            return;
        }
        AvlNode avlNodeL = this.f84777h.L();
        while (true) {
            AvlNode avlNode = this.f84777h;
            if (avlNodeL == avlNode) {
                B(avlNode, avlNode);
                this.f84775f.b();
                return;
            }
            AvlNode avlNodeL2 = avlNodeL.L();
            avlNodeL.f84791b = 0;
            avlNodeL.f84795f = null;
            avlNodeL.f84796g = null;
            avlNodeL.f84797h = null;
            avlNodeL.f84798i = null;
            avlNodeL = avlNodeL2;
        }
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset, com.google.common.collect.SortedIterable
    public /* bridge */ /* synthetic */ Comparator comparator() {
        return super.comparator();
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ boolean contains(Object obj) {
        return super.contains(obj);
    }

    @Override // com.google.common.collect.AbstractMultiset
    int d() {
        return Ints.m(x(Aggregate.DISTINCT));
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator e() {
        return Multisets.e(f());
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int e0(Object obj, int i3) {
        CollectPreconditions.b(i3, "count");
        if (!this.f84776g.c(obj)) {
            Preconditions.d(i3 == 0);
            return 0;
        }
        AvlNode avlNode = (AvlNode) this.f84775f.c();
        if (avlNode == null) {
            if (i3 > 0) {
                t1(obj, i3);
            }
            return 0;
        }
        int[] iArr = new int[1];
        this.f84775f.a(avlNode, avlNode.K(comparator(), obj, i3, iArr));
        return iArr[0];
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ Set entrySet() {
        return super.entrySet();
    }

    @Override // com.google.common.collect.AbstractMultiset
    Iterator f() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.2

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            AvlNode f84780a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Multiset.Entry f84781b;

            {
                this.f84780a = TreeMultiset.this.z();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                TreeMultiset treeMultiset = TreeMultiset.this;
                AvlNode avlNode = this.f84780a;
                Objects.requireNonNull(avlNode);
                Multiset.Entry entryD = treeMultiset.D(avlNode);
                this.f84781b = entryD;
                if (this.f84780a.L() == TreeMultiset.this.f84777h) {
                    this.f84780a = null;
                    return entryD;
                }
                this.f84780a = this.f84780a.L();
                return entryD;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f84780a == null) {
                    return false;
                }
                if (!TreeMultiset.this.f84776g.l(this.f84780a.x())) {
                    return true;
                }
                this.f84780a = null;
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.A(this.f84781b != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.e0(this.f84781b.a(), 0);
                this.f84781b = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry firstEntry() {
        return super.firstEntry();
    }

    @Override // com.google.common.collect.SortedMultiset
    public SortedMultiset h2(Object obj, BoundType boundType) {
        return new TreeMultiset(this.f84775f, this.f84776g.k(GeneralRange.d(comparator(), obj, boundType)), this.f84777h);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public /* bridge */ /* synthetic */ NavigableSet i() {
        return super.i();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ SortedMultiset i1(Object obj, BoundType boundType, Object obj2, BoundType boundType2) {
        return super.i1(obj, boundType, obj2, boundType2);
    }

    @Override // com.google.common.collect.AbstractMultiset, java.util.AbstractCollection, java.util.Collection
    public /* bridge */ /* synthetic */ boolean isEmpty() {
        return super.isEmpty();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, com.google.common.collect.Multiset
    public Iterator iterator() {
        return Multisets.j(this);
    }

    @Override // com.google.common.collect.AbstractSortedMultiset
    Iterator l() {
        return new Iterator<Multiset.Entry<E>>() { // from class: com.google.common.collect.TreeMultiset.3

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            AvlNode f84783a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            Multiset.Entry f84784b = null;

            {
                this.f84783a = TreeMultiset.this.A();
            }

            @Override // java.util.Iterator
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Multiset.Entry next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                Objects.requireNonNull(this.f84783a);
                Multiset.Entry entryD = TreeMultiset.this.D(this.f84783a);
                this.f84784b = entryD;
                if (this.f84783a.z() == TreeMultiset.this.f84777h) {
                    this.f84783a = null;
                    return entryD;
                }
                this.f84783a = this.f84783a.z();
                return entryD;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                if (this.f84783a == null) {
                    return false;
                }
                if (!TreeMultiset.this.f84776g.m(this.f84783a.x())) {
                    return true;
                }
                this.f84783a = null;
                return false;
            }

            @Override // java.util.Iterator
            public void remove() {
                Preconditions.A(this.f84784b != null, "no calls to next() since the last call to remove()");
                TreeMultiset.this.e0(this.f84784b.a(), 0);
                this.f84784b = null;
            }
        };
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry lastEntry() {
        return super.lastEntry();
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int o1(Object obj, int i3) {
        CollectPreconditions.b(i3, "occurrences");
        if (i3 == 0) {
            return Y1(obj);
        }
        AvlNode avlNode = (AvlNode) this.f84775f.c();
        int[] iArr = new int[1];
        try {
            if (this.f84776g.c(obj) && avlNode != null) {
                this.f84775f.a(avlNode, avlNode.E(comparator(), obj, i3, iArr));
                return iArr[0];
            }
        } catch (ClassCastException | NullPointerException unused) {
        }
        return 0;
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollFirstEntry() {
        return super.pollFirstEntry();
    }

    @Override // com.google.common.collect.AbstractSortedMultiset, com.google.common.collect.SortedMultiset
    public /* bridge */ /* synthetic */ Multiset.Entry pollLastEntry() {
        return super.pollLastEntry();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, com.google.common.collect.Multiset
    public int size() {
        return Ints.m(x(Aggregate.SIZE));
    }

    @Override // com.google.common.collect.AbstractMultiset, com.google.common.collect.Multiset
    public int t1(Object obj, int i3) {
        CollectPreconditions.b(i3, "occurrences");
        if (i3 == 0) {
            return Y1(obj);
        }
        Preconditions.d(this.f84776g.c(obj));
        AvlNode avlNode = (AvlNode) this.f84775f.c();
        if (avlNode != null) {
            int[] iArr = new int[1];
            this.f84775f.a(avlNode, avlNode.o(comparator(), obj, i3, iArr));
            return iArr[0];
        }
        comparator().compare(obj, obj);
        AvlNode avlNode2 = new AvlNode(obj, i3);
        AvlNode avlNode3 = this.f84777h;
        C(avlNode3, avlNode2, avlNode3);
        this.f84775f.a(avlNode, avlNode2);
        return 0;
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static final class AvlNode<E> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Object f84790a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f84791b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f84792c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private long f84793d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private int f84794e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        private AvlNode f84795f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        private AvlNode f84796g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        private AvlNode f84797h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        private AvlNode f84798i;

        AvlNode(Object obj, int i3) {
            Preconditions.d(i3 > 0);
            this.f84790a = obj;
            this.f84791b = i3;
            this.f84793d = i3;
            this.f84792c = 1;
            this.f84794e = 1;
            this.f84795f = null;
            this.f84796g = null;
        }

        private AvlNode A() {
            int iR = r();
            if (iR == -2) {
                Objects.requireNonNull(this.f84796g);
                if (this.f84796g.r() > 0) {
                    this.f84796g = this.f84796g.I();
                }
                return H();
            }
            if (iR != 2) {
                C();
                return this;
            }
            Objects.requireNonNull(this.f84795f);
            if (this.f84795f.r() < 0) {
                this.f84795f = this.f84795f.H();
            }
            return I();
        }

        private void B() {
            D();
            C();
        }

        private void C() {
            this.f84794e = Math.max(y(this.f84795f), y(this.f84796g)) + 1;
        }

        private void D() {
            this.f84792c = TreeMultiset.y(this.f84795f) + 1 + TreeMultiset.y(this.f84796g);
            this.f84793d = ((long) this.f84791b) + M(this.f84795f) + M(this.f84796g);
        }

        private AvlNode F(AvlNode avlNode) {
            AvlNode avlNode2 = this.f84796g;
            if (avlNode2 == null) {
                return this.f84795f;
            }
            this.f84796g = avlNode2.F(avlNode);
            this.f84792c--;
            this.f84793d -= (long) avlNode.f84791b;
            return A();
        }

        private AvlNode G(AvlNode avlNode) {
            AvlNode avlNode2 = this.f84795f;
            if (avlNode2 == null) {
                return this.f84796g;
            }
            this.f84795f = avlNode2.G(avlNode);
            this.f84792c--;
            this.f84793d -= (long) avlNode.f84791b;
            return A();
        }

        private AvlNode H() {
            Preconditions.z(this.f84796g != null);
            AvlNode avlNode = this.f84796g;
            this.f84796g = avlNode.f84795f;
            avlNode.f84795f = this;
            avlNode.f84793d = this.f84793d;
            avlNode.f84792c = this.f84792c;
            B();
            avlNode.C();
            return avlNode;
        }

        private AvlNode I() {
            Preconditions.z(this.f84795f != null);
            AvlNode avlNode = this.f84795f;
            this.f84795f = avlNode.f84796g;
            avlNode.f84796g = this;
            avlNode.f84793d = this.f84793d;
            avlNode.f84792c = this.f84792c;
            B();
            avlNode.C();
            return avlNode;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode L() {
            AvlNode avlNode = this.f84798i;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        private static long M(AvlNode avlNode) {
            if (avlNode == null) {
                return 0L;
            }
            return avlNode.f84793d;
        }

        private AvlNode p(Object obj, int i3) {
            this.f84795f = new AvlNode(obj, i3);
            TreeMultiset.C(z(), this.f84795f, this);
            this.f84794e = Math.max(2, this.f84794e);
            this.f84792c++;
            this.f84793d += (long) i3;
            return this;
        }

        private AvlNode q(Object obj, int i3) {
            AvlNode avlNode = new AvlNode(obj, i3);
            this.f84796g = avlNode;
            TreeMultiset.C(this, avlNode, L());
            this.f84794e = Math.max(2, this.f84794e);
            this.f84792c++;
            this.f84793d += (long) i3;
            return this;
        }

        private int r() {
            return y(this.f84795f) - y(this.f84796g);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode s(Comparator comparator, Object obj) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                AvlNode avlNode = this.f84795f;
                if (avlNode != null) {
                    return (AvlNode) MoreObjects.a(avlNode.s(comparator, obj), this);
                }
            } else if (iCompare != 0) {
                AvlNode avlNode2 = this.f84796g;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.s(comparator, obj);
            }
            return this;
        }

        private AvlNode u() {
            int i3 = this.f84791b;
            this.f84791b = 0;
            TreeMultiset.B(z(), L());
            AvlNode avlNode = this.f84795f;
            if (avlNode == null) {
                return this.f84796g;
            }
            AvlNode avlNode2 = this.f84796g;
            if (avlNode2 == null) {
                return avlNode;
            }
            if (avlNode.f84794e >= avlNode2.f84794e) {
                AvlNode avlNodeZ = z();
                avlNodeZ.f84795f = this.f84795f.F(avlNodeZ);
                avlNodeZ.f84796g = this.f84796g;
                avlNodeZ.f84792c = this.f84792c - 1;
                avlNodeZ.f84793d = this.f84793d - ((long) i3);
                return avlNodeZ.A();
            }
            AvlNode avlNodeL = L();
            avlNodeL.f84796g = this.f84796g.G(avlNodeL);
            avlNodeL.f84795f = this.f84795f;
            avlNodeL.f84792c = this.f84792c - 1;
            avlNodeL.f84793d = this.f84793d - ((long) i3);
            return avlNodeL.A();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode v(Comparator comparator, Object obj) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare > 0) {
                AvlNode avlNode = this.f84796g;
                if (avlNode != null) {
                    return (AvlNode) MoreObjects.a(avlNode.v(comparator, obj), this);
                }
            } else if (iCompare != 0) {
                AvlNode avlNode2 = this.f84795f;
                if (avlNode2 == null) {
                    return null;
                }
                return avlNode2.v(comparator, obj);
            }
            return this;
        }

        private static int y(AvlNode avlNode) {
            if (avlNode == null) {
                return 0;
            }
            return avlNode.f84794e;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public AvlNode z() {
            AvlNode avlNode = this.f84797h;
            Objects.requireNonNull(avlNode);
            return avlNode;
        }

        AvlNode E(Comparator comparator, Object obj, int i3, int[] iArr) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                AvlNode avlNode = this.f84795f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return this;
                }
                this.f84795f = avlNode.E(comparator, obj, i3, iArr);
                int i4 = iArr[0];
                if (i4 > 0) {
                    if (i3 >= i4) {
                        this.f84792c--;
                        this.f84793d -= (long) i4;
                    } else {
                        this.f84793d -= (long) i3;
                    }
                }
                return i4 == 0 ? this : A();
            }
            if (iCompare <= 0) {
                int i5 = this.f84791b;
                iArr[0] = i5;
                if (i3 >= i5) {
                    return u();
                }
                this.f84791b = i5 - i3;
                this.f84793d -= (long) i3;
                return this;
            }
            AvlNode avlNode2 = this.f84796g;
            if (avlNode2 == null) {
                iArr[0] = 0;
                return this;
            }
            this.f84796g = avlNode2.E(comparator, obj, i3, iArr);
            int i6 = iArr[0];
            if (i6 > 0) {
                if (i3 >= i6) {
                    this.f84792c--;
                    this.f84793d -= (long) i6;
                } else {
                    this.f84793d -= (long) i3;
                }
            }
            return A();
        }

        AvlNode J(Comparator comparator, Object obj, int i3, int i4, int[] iArr) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                AvlNode avlNode = this.f84795f;
                if (avlNode != null) {
                    this.f84795f = avlNode.J(comparator, obj, i3, i4, iArr);
                    int i5 = iArr[0];
                    if (i5 == i3) {
                        if (i4 == 0 && i5 != 0) {
                            this.f84792c--;
                        } else if (i4 > 0 && i5 == 0) {
                            this.f84792c++;
                        }
                        this.f84793d += (long) (i4 - i5);
                    }
                    return A();
                }
                iArr[0] = 0;
                if (i3 == 0 && i4 > 0) {
                    return p(obj, i4);
                }
            } else if (iCompare > 0) {
                AvlNode avlNode2 = this.f84796g;
                if (avlNode2 != null) {
                    this.f84796g = avlNode2.J(comparator, obj, i3, i4, iArr);
                    int i6 = iArr[0];
                    if (i6 == i3) {
                        if (i4 == 0 && i6 != 0) {
                            this.f84792c--;
                        } else if (i4 > 0 && i6 == 0) {
                            this.f84792c++;
                        }
                        this.f84793d += (long) (i4 - i6);
                    }
                    return A();
                }
                iArr[0] = 0;
                if (i3 == 0 && i4 > 0) {
                    return q(obj, i4);
                }
            } else {
                int i7 = this.f84791b;
                iArr[0] = i7;
                if (i3 == i7) {
                    if (i4 == 0) {
                        return u();
                    }
                    this.f84793d += (long) (i4 - i7);
                    this.f84791b = i4;
                }
            }
            return this;
        }

        AvlNode K(Comparator comparator, Object obj, int i3, int[] iArr) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                AvlNode avlNode = this.f84795f;
                if (avlNode != null) {
                    this.f84795f = avlNode.K(comparator, obj, i3, iArr);
                    if (i3 == 0 && iArr[0] != 0) {
                        this.f84792c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.f84792c++;
                    }
                    this.f84793d += (long) (i3 - iArr[0]);
                    return A();
                }
                iArr[0] = 0;
                if (i3 > 0) {
                    return p(obj, i3);
                }
            } else {
                if (iCompare <= 0) {
                    int i4 = this.f84791b;
                    iArr[0] = i4;
                    if (i3 == 0) {
                        return u();
                    }
                    this.f84793d += (long) (i3 - i4);
                    this.f84791b = i3;
                    return this;
                }
                AvlNode avlNode2 = this.f84796g;
                if (avlNode2 != null) {
                    this.f84796g = avlNode2.K(comparator, obj, i3, iArr);
                    if (i3 == 0 && iArr[0] != 0) {
                        this.f84792c--;
                    } else if (i3 > 0 && iArr[0] == 0) {
                        this.f84792c++;
                    }
                    this.f84793d += (long) (i3 - iArr[0]);
                    return A();
                }
                iArr[0] = 0;
                if (i3 > 0) {
                    return q(obj, i3);
                }
            }
            return this;
        }

        AvlNode o(Comparator comparator, Object obj, int i3, int[] iArr) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                AvlNode avlNode = this.f84795f;
                if (avlNode == null) {
                    iArr[0] = 0;
                    return p(obj, i3);
                }
                int i4 = avlNode.f84794e;
                AvlNode avlNodeO = avlNode.o(comparator, obj, i3, iArr);
                this.f84795f = avlNodeO;
                if (iArr[0] == 0) {
                    this.f84792c++;
                }
                this.f84793d += (long) i3;
                if (avlNodeO.f84794e != i4) {
                    return A();
                }
            } else {
                if (iCompare <= 0) {
                    int i5 = this.f84791b;
                    iArr[0] = i5;
                    long j3 = i3;
                    Preconditions.d(((long) i5) + j3 <= 2147483647L);
                    this.f84791b += i3;
                    this.f84793d += j3;
                    return this;
                }
                AvlNode avlNode2 = this.f84796g;
                if (avlNode2 == null) {
                    iArr[0] = 0;
                    return q(obj, i3);
                }
                int i6 = avlNode2.f84794e;
                AvlNode avlNodeO2 = avlNode2.o(comparator, obj, i3, iArr);
                this.f84796g = avlNodeO2;
                if (iArr[0] == 0) {
                    this.f84792c++;
                }
                this.f84793d += (long) i3;
                if (avlNodeO2.f84794e != i6) {
                    return A();
                }
            }
            return this;
        }

        int t(Comparator comparator, Object obj) {
            int iCompare = comparator.compare(obj, x());
            if (iCompare < 0) {
                AvlNode avlNode = this.f84795f;
                if (avlNode == null) {
                    return 0;
                }
                return avlNode.t(comparator, obj);
            }
            if (iCompare <= 0) {
                return this.f84791b;
            }
            AvlNode avlNode2 = this.f84796g;
            if (avlNode2 == null) {
                return 0;
            }
            return avlNode2.t(comparator, obj);
        }

        public String toString() {
            return Multisets.h(x(), w()).toString();
        }

        int w() {
            return this.f84791b;
        }

        Object x() {
            return NullnessCasts.a(this.f84790a);
        }

        AvlNode() {
            this.f84790a = null;
            this.f84791b = 1;
        }
    }
}
