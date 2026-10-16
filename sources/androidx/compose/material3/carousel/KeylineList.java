package androidx.compose.material3.carousel;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.UnaryOperator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMappedMarker;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

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
public final class KeylineList implements List<Keyline>, KMappedMarker {

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final Companion f21718h = new Companion(null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final int f21719i = 8;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final KeylineList f21720j = new KeylineList(CollectionsKt.emptyList());

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final /* synthetic */ List f21721a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f21722b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f21723c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f21724d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final int f21725f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final int f21726g;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final KeylineList a() {
            return KeylineList.f21720j;
        }

        private Companion() {
        }
    }

    public KeylineList(List list) {
        int iNextIndex;
        int iNextIndex2;
        this.f21721a = list;
        Iterator<Keyline> it = iterator();
        int i3 = 0;
        int i4 = 0;
        while (true) {
            iNextIndex = -1;
            if (!it.hasNext()) {
                i4 = -1;
                break;
            } else if (it.next().i()) {
                break;
            } else {
                i4++;
            }
        }
        this.f21722b = i4;
        Iterator<Keyline> it2 = iterator();
        int i5 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i5 = -1;
                break;
            } else if (!it2.next().g()) {
                break;
            } else {
                i5++;
            }
        }
        this.f21723c = i5;
        ListIterator<Keyline> listIterator = listIterator(size());
        while (true) {
            if (!listIterator.hasPrevious()) {
                iNextIndex2 = -1;
                break;
            } else if (!listIterator.previous().g()) {
                iNextIndex2 = listIterator.nextIndex();
                break;
            }
        }
        this.f21724d = iNextIndex2;
        Iterator<Keyline> it3 = iterator();
        while (true) {
            if (!it3.hasNext()) {
                i3 = -1;
                break;
            } else if (it3.next().h()) {
                break;
            } else {
                i3++;
            }
        }
        this.f21725f = i3;
        ListIterator<Keyline> listIterator2 = listIterator(size());
        while (true) {
            if (!listIterator2.hasPrevious()) {
                break;
            } else if (listIterator2.previous().h()) {
                iNextIndex = listIterator2.nextIndex();
                break;
            }
        }
        this.f21726g = iNextIndex;
    }

    public final boolean A(float f3) {
        return p().d() + (p().e() / ((float) 2)) <= f3 && Intrinsics.areEqual(p(), s());
    }

    public final int B(float f3) {
        Integer next;
        Iterator<Integer> it = RangesKt.v(this.f21725f - 1, 0).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (get(next.intValue()).e() == f3) {
                break;
            }
        }
        Integer num = next;
        if (num != null) {
            return num.intValue();
        }
        return 0;
    }

    public int C(Keyline keyline) {
        return this.f21721a.lastIndexOf(keyline);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ void add(int i3, Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection<? extends Keyline> collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public boolean b(Keyline keyline) {
        return this.f21721a.contains(keyline);
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ boolean contains(Object obj) {
        if (obj instanceof Keyline) {
            return b((Keyline) obj);
        }
        return false;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        return this.f21721a.containsAll(collection);
    }

    public final int d(float f3) {
        Integer next;
        Iterator<Integer> it = new IntRange(this.f21726g, CollectionsKt.getLastIndex(this)).iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            if (get(next.intValue()).e() == f3) {
                break;
            }
        }
        Integer num = next;
        return num != null ? num.intValue() : CollectionsKt.getLastIndex(this);
    }

    @Override // java.util.List
    /* JADX INFO: renamed from: e, reason: merged with bridge method [inline-methods] */
    public Keyline get(int i3) {
        return (Keyline) this.f21721a.get(i3);
    }

    @Override // java.util.List, java.util.Collection
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof KeylineList)) {
            return false;
        }
        KeylineList keylineList = (KeylineList) obj;
        if (size() != keylineList.size()) {
            return false;
        }
        int size = size();
        for (int i3 = 0; i3 < size; i3++) {
            if (!Intrinsics.areEqual(get(i3), keylineList.get(i3))) {
                return false;
            }
        }
        return true;
    }

    public final Keyline f() {
        Keyline keyline = (Keyline) CollectionsKt.getOrNull(this, this.f21725f);
        if (keyline != null) {
            return keyline;
        }
        throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
    }

    public final int g() {
        return this.f21725f;
    }

    public final Keyline h() {
        return get(this.f21723c);
    }

    @Override // java.util.List, java.util.Collection
    public int hashCode() {
        int size = size();
        int iHashCode = 0;
        for (int i3 = 0; i3 < size; i3++) {
            iHashCode += get(i3).hashCode() * 31;
        }
        return iHashCode;
    }

    @Override // java.util.List
    public final /* bridge */ int indexOf(Object obj) {
        if (obj instanceof Keyline) {
            return x((Keyline) obj);
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return this.f21721a.isEmpty();
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return this.f21721a.iterator();
    }

    public final int l() {
        return this.f21723c;
    }

    @Override // java.util.List
    public final /* bridge */ int lastIndexOf(Object obj) {
        if (obj instanceof Keyline) {
            return C((Keyline) obj);
        }
        return -1;
    }

    @Override // java.util.List
    public ListIterator<Keyline> listIterator() {
        return this.f21721a.listIterator();
    }

    public final Keyline n(float f3) {
        Keyline keyline;
        int size = size();
        int i3 = 0;
        while (true) {
            if (i3 >= size) {
                keyline = null;
                break;
            }
            keyline = get(i3);
            if (keyline.f() >= f3) {
                break;
            }
            i3++;
        }
        Keyline keyline2 = keyline;
        return keyline2 == null ? (Keyline) CollectionsKt.last((List) this) : keyline2;
    }

    public final Keyline o(float f3) {
        int size = size() - 1;
        if (size >= 0) {
            while (true) {
                int i3 = size - 1;
                Keyline keyline = get(size);
                if (keyline.f() < f3) {
                    return keyline;
                }
                if (i3 < 0) {
                    break;
                }
                size = i3;
            }
        }
        return (Keyline) CollectionsKt.first((List) this);
    }

    public final Keyline p() {
        Keyline keyline = (Keyline) CollectionsKt.getOrNull(this, this.f21726g);
        if (keyline != null) {
            return keyline;
        }
        throw new NoSuchElementException("All KeylineLists must have at least one focal keyline");
    }

    public final int q() {
        return this.f21726g;
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Keyline remove(int i3) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public void replaceAll(UnaryOperator<Keyline> unaryOperator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    public final Keyline s() {
        return get(this.f21724d);
    }

    @Override // java.util.List
    public /* bridge */ /* synthetic */ Keyline set(int i3, Keyline keyline) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return w();
    }

    @Override // java.util.List
    public void sort(Comparator<? super Keyline> comparator) {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }

    @Override // java.util.List
    public List<Keyline> subList(int i3, int i4) {
        return this.f21721a.subList(i3, i4);
    }

    public final int t() {
        return this.f21724d;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    public final Keyline u() {
        return get(this.f21722b);
    }

    public final int v() {
        return this.f21722b;
    }

    public int w() {
        return this.f21721a.size();
    }

    public int x(Keyline keyline) {
        return this.f21721a.indexOf(keyline);
    }

    public final boolean y() {
        return f().d() - (f().e() / ((float) 2)) >= 0.0f && Intrinsics.areEqual(f(), h());
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
    public ListIterator<Keyline> listIterator(int i3) {
        return this.f21721a.listIterator(i3);
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
