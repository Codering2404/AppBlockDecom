package androidx.compose.ui.node;

import androidx.collection.MutableLongList;
import androidx.collection.MutableObjectList;
import androidx.compose.ui.Modifier;
import androidx.media3.extractor.jpeg.xWt.jTYhJgqLBN;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;

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
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class HitTestResult implements List<Modifier.Node>, KMappedMarker {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private MutableObjectList f27324a = new MutableObjectList(16);

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MutableLongList f27325b = new MutableLongList(16);

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f27326c = -1;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    /* JADX INFO: loaded from: classes2.dex */
    @Metadata
    private final class SubList implements List<Modifier.Node>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final int f27331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f27332b;

        public SubList(int i3, int i4) {
            this.f27331a = i3;
            this.f27332b = i4;
        }

        public boolean a(Modifier.Node node) {
            return indexOf(node) != -1;
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ void add(int i3, Modifier.Node node) {
            throw new UnsupportedOperationException(jTYhJgqLBN.HeVZ);
        }

        @Override // java.util.List
        public boolean addAll(int i3, Collection<? extends Modifier.Node> collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ void addFirst(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ void addLast(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Modifier.Node get(int i3) {
            Object objD = HitTestResult.this.f27324a.d(i3 + this.f27331a);
            Intrinsics.checkNotNull(objD, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) objD;
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ boolean contains(Object obj) {
            if (obj instanceof Modifier.Node) {
                return a((Modifier.Node) obj);
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                if (!contains((Modifier.Node) it.next())) {
                    return false;
                }
            }
            return true;
        }

        public int d() {
            return this.f27332b - this.f27331a;
        }

        public int e(Modifier.Node node) {
            int i3 = this.f27331a;
            int i4 = this.f27332b;
            if (i3 > i4) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.f27324a.d(i3), node)) {
                if (i3 == i4) {
                    return -1;
                }
                i3++;
            }
            return i3 - this.f27331a;
        }

        public int f(Modifier.Node node) {
            int i3 = this.f27332b;
            int i4 = this.f27331a;
            if (i4 > i3) {
                return -1;
            }
            while (!Intrinsics.areEqual(HitTestResult.this.f27324a.d(i3), node)) {
                if (i3 == i4) {
                    return -1;
                }
                i3--;
            }
            return i3 - this.f27331a;
        }

        @Override // java.util.List
        public final /* bridge */ int indexOf(Object obj) {
            if (obj instanceof Modifier.Node) {
                return e((Modifier.Node) obj);
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return size() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            HitTestResult hitTestResult = HitTestResult.this;
            int i3 = this.f27331a;
            return hitTestResult.new HitTestResultIterator(i3, i3, this.f27332b);
        }

        @Override // java.util.List
        public final /* bridge */ int lastIndexOf(Object obj) {
            if (obj instanceof Modifier.Node) {
                return f((Modifier.Node) obj);
            }
            return -1;
        }

        @Override // java.util.List
        public ListIterator<Modifier.Node> listIterator() {
            HitTestResult hitTestResult = HitTestResult.this;
            int i3 = this.f27331a;
            return hitTestResult.new HitTestResultIterator(i3, i3, this.f27332b);
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Modifier.Node remove(int i3) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ Object removeFirst() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* bridge */ /* synthetic */ Object removeLast() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public /* bridge */ /* synthetic */ Modifier.Node set(int i3, Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return d();
        }

        @Override // java.util.List
        public void sort(Comparator<? super Modifier.Node> comparator) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public List<Modifier.Node> subList(int i3, int i4) {
            HitTestResult hitTestResult = HitTestResult.this;
            int i5 = this.f27331a;
            return hitTestResult.new SubList(i3 + i5, i5 + i4);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List, java.util.Collection
        public /* bridge */ /* synthetic */ boolean add(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List
        public ListIterator<Modifier.Node> listIterator(int i3) {
            HitTestResult hitTestResult = HitTestResult.this;
            int i4 = this.f27331a;
            return hitTestResult.new HitTestResultIterator(i3 + i4, i4, this.f27332b);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return CollectionToArray.b(this, objArr);
        }
    }

    private final long l() {
        long jB = HitTestResultKt.b(Float.POSITIVE_INFINITY, false, false, 4, null);
        int i3 = this.f27326c + 1;
        int lastIndex = CollectionsKt.getLastIndex(this);
        if (i3 <= lastIndex) {
            while (true) {
                long jB2 = DistanceAndFlags.b(this.f27325b.a(i3));
                if (DistanceAndFlags.a(jB2, jB) < 0) {
                    jB = jB2;
                }
                if ((DistanceAndFlags.d(jB) < 0.0f && DistanceAndFlags.g(jB)) || i3 == lastIndex) {
                    break;
                }
                i3++;
            }
        }
        return jB;
    }

    private final void v(int i3) {
        this.f27324a.A(i3);
        this.f27325b.h(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void w(int i3, int i4) {
        if (i3 >= i4) {
            return;
        }
        this.f27324a.B(i3, i4);
        this.f27325b.i(i3, i4);
    }

    public final void a() {
        this.f27326c = size() - 1;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i3, Modifier.Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection<? extends Modifier.Node> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addFirst(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ void addLast(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final void clear() {
        this.f27326c = -1;
        this.f27324a.t();
        this.f27325b.f();
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Modifier.Node) {
            return h((Modifier.Node) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            if (!contains((Modifier.Node) it.next())) {
                return false;
            }
        }
        return true;
    }

    public boolean h(Modifier.Node node) {
        return indexOf(node) != -1;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Modifier.Node) {
            return s((Modifier.Node) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f27324a.g();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Modifier.Node) {
            return u((Modifier.Node) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<Modifier.Node> listIterator() {
        return new HitTestResultIterator(this, 0, 0, 0, 7, null);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: n, reason: merged with bridge method [inline-methods] */
    public Modifier.Node get(int i3) {
        Object objD = this.f27324a.d(i3);
        Intrinsics.checkNotNull(objD, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
        return (Modifier.Node) objD;
    }

    public int o() {
        return this.f27324a.e();
    }

    public final boolean p() {
        long jL = l();
        return DistanceAndFlags.d(jL) < 0.0f && DistanceAndFlags.g(jL) && !DistanceAndFlags.f(jL);
    }

    public final void q(Modifier.Node node, boolean z2, Function0 function0) {
        if (this.f27326c == CollectionsKt.getLastIndex(this)) {
            int i3 = this.f27326c;
            w(this.f27326c + 1, size());
            this.f27326c++;
            this.f27324a.n(node);
            this.f27325b.d(HitTestResultKt.a(0.0f, z2, true));
            function0.invoke();
            this.f27326c = i3;
            return;
        }
        long jL = l();
        int i4 = this.f27326c;
        if (!DistanceAndFlags.f(jL)) {
            if (DistanceAndFlags.d(jL) > 0.0f) {
                int i5 = this.f27326c;
                w(this.f27326c + 1, size());
                this.f27326c++;
                this.f27324a.n(node);
                this.f27325b.d(HitTestResultKt.a(0.0f, z2, true));
                function0.invoke();
                this.f27326c = i5;
                return;
            }
            return;
        }
        this.f27326c = CollectionsKt.getLastIndex(this);
        int i6 = this.f27326c;
        w(this.f27326c + 1, size());
        this.f27326c++;
        this.f27324a.n(node);
        this.f27325b.d(HitTestResultKt.a(0.0f, z2, true));
        function0.invoke();
        this.f27326c = i6;
        if (DistanceAndFlags.d(l()) < 0.0f) {
            w(i4 + 1, this.f27326c + 1);
        }
        this.f27326c = i4;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Modifier.Node remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object removeFirst() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public /* bridge */ /* synthetic */ Object removeLast() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<Modifier.Node> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public int s(Modifier.Node node) {
        int lastIndex = CollectionsKt.getLastIndex(this);
        if (lastIndex < 0) {
            return -1;
        }
        int i3 = 0;
        while (!Intrinsics.areEqual(this.f27324a.d(i3), node)) {
            if (i3 == lastIndex) {
                return -1;
            }
            i3++;
        }
        return i3;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Modifier.Node set(int i3, Modifier.Node node) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return o();
    }

    @Override // java.util.List
    public void sort(Comparator<? super Modifier.Node> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Modifier.Node> subList(int i3, int i4) {
        return new SubList(i3, i4);
    }

    public final boolean t(float f3, boolean z2) {
        if (this.f27326c == CollectionsKt.getLastIndex(this)) {
            return true;
        }
        return DistanceAndFlags.a(l(), HitTestResultKt.b(f3, z2, false, 4, null)) > 0;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public int u(Modifier.Node node) {
        for (int lastIndex = CollectionsKt.getLastIndex(this); -1 < lastIndex; lastIndex--) {
            if (Intrinsics.areEqual(this.f27324a.d(lastIndex), node)) {
                return lastIndex;
            }
        }
        return -1;
    }

    public final void x(Modifier.Node node, float f3, boolean z2, Function0 function0) {
        if (this.f27326c == CollectionsKt.getLastIndex(this)) {
            int i3 = this.f27326c;
            w(this.f27326c + 1, size());
            this.f27326c++;
            this.f27324a.n(node);
            this.f27325b.d(HitTestResultKt.a(f3, z2, false));
            function0.invoke();
            this.f27326c = i3;
            if (this.f27326c + 1 == CollectionsKt.getLastIndex(this) || DistanceAndFlags.f(l())) {
                v(this.f27326c + 1);
                return;
            }
            return;
        }
        long jL = l();
        int i4 = this.f27326c;
        this.f27326c = CollectionsKt.getLastIndex(this);
        int i5 = this.f27326c;
        w(this.f27326c + 1, size());
        this.f27326c++;
        this.f27324a.n(node);
        this.f27325b.d(HitTestResultKt.a(f3, z2, false));
        function0.invoke();
        this.f27326c = i5;
        long jL2 = l();
        if (this.f27326c + 1 >= CollectionsKt.getLastIndex(this) || DistanceAndFlags.a(jL, jL2) <= 0) {
            w(this.f27326c + 1, size());
        } else {
            w(i4 + 1, DistanceAndFlags.f(jL2) ? this.f27326c + 2 : this.f27326c + 1);
        }
        this.f27326c = i4;
    }

    @Override // java.util.List, java.util.Collection
    public /* bridge */ /* synthetic */ boolean add(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public ListIterator<Modifier.Node> listIterator(int i3) {
        return new HitTestResultIterator(this, i3, 0, 0, 6, null);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.b(this, objArr);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class HitTestResultIterator implements ListIterator<Modifier.Node>, KMappedMarker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private int f27327a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f27328b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private final int f27329c;

        public HitTestResultIterator(int i3, int i4, int i5) {
            this.f27327a = i3;
            this.f27328b = i4;
            this.f27329c = i5;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Modifier.Node next() {
            MutableObjectList mutableObjectList = HitTestResult.this.f27324a;
            int i3 = this.f27327a;
            this.f27327a = i3 + 1;
            Object objD = mutableObjectList.d(i3);
            Intrinsics.checkNotNull(objD, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) objD;
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void add(Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Modifier.Node previous() {
            MutableObjectList mutableObjectList = HitTestResult.this.f27324a;
            int i3 = this.f27327a - 1;
            this.f27327a = i3;
            Object objD = mutableObjectList.d(i3);
            Intrinsics.checkNotNull(objD, "null cannot be cast to non-null type androidx.compose.ui.Modifier.Node");
            return (Modifier.Node) objD;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f27327a < this.f27329c;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f27327a > this.f27328b;
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f27327a - this.f27328b;
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return (this.f27327a - this.f27328b) - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        @Override // java.util.ListIterator
        public /* bridge */ /* synthetic */ void set(Modifier.Node node) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }

        public /* synthetic */ HitTestResultIterator(HitTestResult hitTestResult, int i3, int i4, int i5, int i6, DefaultConstructorMarker defaultConstructorMarker) {
            this((i6 & 1) != 0 ? 0 : i3, (i6 & 2) != 0 ? 0 : i4, (i6 & 4) != 0 ? hitTestResult.size() : i5);
        }
    }
}
