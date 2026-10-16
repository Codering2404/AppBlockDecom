package androidx.compose.runtime.snapshots;

import androidx.compose.runtime.PreconditionsKt;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;
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
final class SubList<T> implements List<T>, KMutableList {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final SnapshotStateList f25034a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f25035b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f25036c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f25037d;

    /* JADX INFO: renamed from: androidx.compose.runtime.snapshots.SubList$listIterator$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class AnonymousClass1 implements ListIterator<T>, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Ref.IntRef f25038a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ SubList f25039b;

        AnonymousClass1(Ref.IntRef intRef, SubList subList) {
            this.f25038a = intRef;
            this.f25039b = subList;
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void add(Object obj) {
            SnapshotStateListKt.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void remove() {
            SnapshotStateListKt.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Void set(Object obj) {
            SnapshotStateListKt.f();
            throw new KotlinNothingValueException();
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f25038a.f140142a < this.f25039b.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f25038a.f140142a >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            int i3 = this.f25038a.f140142a + 1;
            SnapshotStateListKt.g(i3, this.f25039b.size());
            this.f25038a.f140142a = i3;
            return this.f25039b.get(i3);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f25038a.f140142a + 1;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            int i3 = this.f25038a.f140142a;
            SnapshotStateListKt.g(i3, this.f25039b.size());
            this.f25038a.f140142a = i3 - 1;
            return this.f25039b.get(i3);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f25038a.f140142a;
        }
    }

    public SubList(SnapshotStateList snapshotStateList, int i3, int i4) {
        this.f25034a = snapshotStateList;
        this.f25035b = i3;
        this.f25036c = snapshotStateList.f();
        this.f25037d = i4 - i3;
    }

    private final void d() {
        if (this.f25034a.f() != this.f25036c) {
            throw new ConcurrentModificationException();
        }
    }

    public int a() {
        return this.f25037d;
    }

    @Override // java.util.List, java.util.Collection
    public boolean add(Object obj) {
        d();
        this.f25034a.add(this.f25035b + size(), obj);
        this.f25037d = size() + 1;
        this.f25036c = this.f25034a.f();
        return true;
    }

    @Override // java.util.List
    public boolean addAll(int i3, Collection collection) {
        d();
        boolean zAddAll = this.f25034a.addAll(i3 + this.f25035b, collection);
        if (zAddAll) {
            this.f25037d = size() + collection.size();
            this.f25036c = this.f25034a.f();
        }
        return zAddAll;
    }

    public Object b(int i3) {
        d();
        Object objRemove = this.f25034a.remove(this.f25035b + i3);
        this.f25037d = size() - 1;
        this.f25036c = this.f25034a.f();
        return objRemove;
    }

    @Override // java.util.List, java.util.Collection
    public void clear() {
        if (size() > 0) {
            d();
            SnapshotStateList snapshotStateList = this.f25034a;
            int i3 = this.f25035b;
            snapshotStateList.l(i3, size() + i3);
            this.f25037d = 0;
            this.f25036c = this.f25034a.f();
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.List, java.util.Collection
    public boolean containsAll(Collection collection) {
        Collection collection2 = collection;
        if ((collection2 instanceof Collection) && collection2.isEmpty()) {
            return true;
        }
        Iterator<T> it = collection2.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // java.util.List
    public Object get(int i3) {
        d();
        SnapshotStateListKt.g(i3, size());
        return this.f25034a.get(this.f25035b + i3);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        d();
        int i3 = this.f25035b;
        Iterator<Integer> it = RangesKt.B(i3, size() + i3).iterator();
        while (it.hasNext()) {
            int iNextInt = ((IntIterator) it).nextInt();
            if (Intrinsics.areEqual(obj, this.f25034a.get(iNextInt))) {
                return iNextInt - this.f25035b;
            }
        }
        return -1;
    }

    @Override // java.util.List, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.List, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        d();
        int size = this.f25035b + size();
        do {
            size--;
            if (size < this.f25035b) {
                return -1;
            }
        } while (!Intrinsics.areEqual(obj, this.f25034a.get(size)));
        return size - this.f25035b;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.List
    public final /* bridge */ Object remove(int i3) {
        return b(i3);
    }

    @Override // java.util.List, java.util.Collection
    public boolean removeAll(Collection collection) {
        Iterator it = collection.iterator();
        while (true) {
            boolean z2 = false;
            while (it.hasNext()) {
                if (remove(it.next()) || z2) {
                    z2 = true;
                }
            }
            return z2;
        }
    }

    @Override // java.util.List, java.util.Collection
    public boolean retainAll(Collection collection) {
        d();
        SnapshotStateList snapshotStateList = this.f25034a;
        int i3 = this.f25035b;
        int iO = snapshotStateList.o(collection, i3, size() + i3);
        if (iO > 0) {
            this.f25036c = this.f25034a.f();
            this.f25037d = size() - iO;
        }
        return iO > 0;
    }

    @Override // java.util.List
    public Object set(int i3, Object obj) {
        SnapshotStateListKt.g(i3, size());
        d();
        Object obj2 = this.f25034a.set(i3 + this.f25035b, obj);
        this.f25036c = this.f25034a.f();
        return obj2;
    }

    @Override // java.util.List, java.util.Collection
    public final /* bridge */ int size() {
        return a();
    }

    @Override // java.util.List
    public List subList(int i3, int i4) {
        if (!(i3 >= 0 && i3 <= i4 && i4 <= size())) {
            PreconditionsKt.a("fromIndex or toIndex are out of bounds");
        }
        d();
        SnapshotStateList snapshotStateList = this.f25034a;
        int i5 = this.f25035b;
        return new SubList(snapshotStateList, i3 + i5, i4 + i5);
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray() {
        return CollectionToArray.a(this);
    }

    @Override // java.util.List
    public ListIterator listIterator(int i3) {
        d();
        Ref.IntRef intRef = new Ref.IntRef();
        intRef.f140142a = i3 - 1;
        return new AnonymousClass1(intRef, this);
    }

    @Override // java.util.List, java.util.Collection
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        remove(iIndexOf);
        return true;
    }

    @Override // java.util.List, java.util.Collection
    public Object[] toArray(Object[] objArr) {
        return CollectionToArray.b(this, objArr);
    }

    @Override // java.util.List
    public void add(int i3, Object obj) {
        d();
        this.f25034a.add(this.f25035b + i3, obj);
        this.f25037d = size() + 1;
        this.f25036c = this.f25034a.f();
    }

    @Override // java.util.List, java.util.Collection
    public boolean addAll(Collection collection) {
        return addAll(size(), collection);
    }
}
