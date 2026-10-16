package androidx.compose.runtime.collection;

import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.RandomAccess;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableList;
import kotlin.jvm.internal.markers.KMutableListIterator;

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
public final class MutableVector<T> implements RandomAccess {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final int f24388d = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object[] f24389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private List f24390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f24391c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class MutableVectorList<T> implements List<T>, KMutableList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MutableVector f24392a;

        public MutableVectorList(MutableVector mutableVector) {
            this.f24392a = mutableVector;
        }

        public int a() {
            return this.f24392a.o();
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            return this.f24392a.b(obj);
        }

        @Override // java.util.List
        public boolean addAll(int i3, Collection collection) {
            return this.f24392a.e(i3, collection);
        }

        public Object b(int i3) {
            MutableVectorKt.a(this, i3);
            return this.f24392a.u(i3);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.f24392a.i();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.f24392a.k(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            return this.f24392a.l(collection);
        }

        @Override // java.util.List
        public Object get(int i3) {
            MutableVectorKt.a(this, i3);
            return this.f24392a.f24389a[i3];
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.f24392a.p(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f24392a.o() == 0;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.f24392a.r(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i3) {
            return b(i3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            return this.f24392a.t(collection);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            return this.f24392a.x(collection);
        }

        @Override // java.util.List
        public Object set(int i3, Object obj) {
            MutableVectorKt.a(this, i3);
            return this.f24392a.y(i3, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List subList(int i3, int i4) {
            MutableVectorKt.b(this, i3, i4);
            return new SubList(this, i3, i4);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List
        public void add(int i3, Object obj) {
            this.f24392a.a(i3, obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            return this.f24392a.g(collection);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i3) {
            return new VectorListIterator(this, i3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.f24392a.s(obj);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return CollectionToArray.b(this, objArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SubList<T> implements List<T>, KMutableList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f24393a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f24394b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f24395c;

        public SubList(List list, int i3, int i4) {
            this.f24393a = list;
            this.f24394b = i3;
            this.f24395c = i4;
        }

        public int a() {
            return this.f24395c - this.f24394b;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            List list = this.f24393a;
            int i3 = this.f24395c;
            this.f24395c = i3 + 1;
            list.add(i3, obj);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i3, Collection collection) {
            this.f24393a.addAll(i3 + this.f24394b, collection);
            int size = collection.size();
            this.f24395c += size;
            return size > 0;
        }

        public Object b(int i3) {
            MutableVectorKt.a(this, i3);
            this.f24395c--;
            return this.f24393a.remove(i3 + this.f24394b);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i3 = this.f24395c - 1;
            int i4 = this.f24394b;
            if (i4 <= i3) {
                while (true) {
                    this.f24393a.remove(i3);
                    if (i3 == i4) {
                        break;
                    } else {
                        i3--;
                    }
                }
            }
            this.f24395c = this.f24394b;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i3 = this.f24395c;
            for (int i4 = this.f24394b; i4 < i3; i4++) {
                if (Intrinsics.areEqual(this.f24393a.get(i4), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection collection) {
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public Object get(int i3) {
            MutableVectorKt.a(this, i3);
            return this.f24393a.get(i3 + this.f24394b);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i3 = this.f24395c;
            for (int i4 = this.f24394b; i4 < i3; i4++) {
                if (Intrinsics.areEqual(this.f24393a.get(i4), obj)) {
                    return i4 - this.f24394b;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f24395c == this.f24394b;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i3 = this.f24395c - 1;
            int i4 = this.f24394b;
            if (i4 > i3) {
                return -1;
            }
            while (!Intrinsics.areEqual(this.f24393a.get(i3), obj)) {
                if (i3 == i4) {
                    return -1;
                }
                i3--;
            }
            return i3 - this.f24394b;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new VectorListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i3) {
            return b(i3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection collection) {
            int i3 = this.f24395c;
            Iterator<T> it = collection.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i3 != this.f24395c;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection collection) {
            int i3 = this.f24395c;
            int i4 = i3 - 1;
            int i5 = this.f24394b;
            if (i5 <= i4) {
                while (true) {
                    if (!collection.contains(this.f24393a.get(i4))) {
                        this.f24393a.remove(i4);
                        this.f24395c--;
                    }
                    if (i4 == i5) {
                        break;
                    }
                    i4--;
                }
            }
            return i3 != this.f24395c;
        }

        @Override // java.util.List
        public Object set(int i3, Object obj) {
            MutableVectorKt.a(this, i3);
            return this.f24393a.set(i3 + this.f24394b, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List subList(int i3, int i4) {
            MutableVectorKt.b(this, i3, i4);
            return new SubList(this, i3, i4);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List
        public void add(int i3, Object obj) {
            this.f24393a.add(i3 + this.f24394b, obj);
            this.f24395c++;
        }

        @Override // java.util.List
        public ListIterator listIterator(int i3) {
            return new VectorListIterator(this, i3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i3 = this.f24395c;
            for (int i4 = this.f24394b; i4 < i3; i4++) {
                if (Intrinsics.areEqual(this.f24393a.get(i4), obj)) {
                    this.f24393a.remove(i4);
                    this.f24395c--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] objArr) {
            return CollectionToArray.b(this, objArr);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection collection) {
            this.f24393a.addAll(this.f24395c, collection);
            int size = collection.size();
            this.f24395c += size;
            return size > 0;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class VectorListIterator<T> implements ListIterator<T>, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f24396a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f24397b;

        public VectorListIterator(List list, int i3) {
            this.f24396a = list;
            this.f24397b = i3;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            this.f24396a.add(this.f24397b, obj);
            this.f24397b++;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f24397b < this.f24396a.size();
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f24397b > 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            List list = this.f24396a;
            int i3 = this.f24397b;
            this.f24397b = i3 + 1;
            return list.get(i3);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f24397b;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            int i3 = this.f24397b - 1;
            this.f24397b = i3;
            return this.f24396a.get(i3);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f24397b - 1;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            int i3 = this.f24397b - 1;
            this.f24397b = i3;
            this.f24396a.remove(i3);
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.f24396a.set(this.f24397b, obj);
        }
    }

    public MutableVector(Object[] objArr, int i3) {
        this.f24389a = objArr;
        this.f24391c = i3;
    }

    public final void A(Comparator comparator) {
        ArraysKt.sortWith(this.f24389a, comparator, 0, this.f24391c);
    }

    public final Void B(String str) {
        throw new NoSuchElementException(str);
    }

    public final void a(int i3, Object obj) {
        int i4 = this.f24391c + 1;
        if (this.f24389a.length < i4) {
            w(i4);
        }
        Object[] objArr = this.f24389a;
        int i5 = this.f24391c;
        if (i3 != i5) {
            System.arraycopy(objArr, i3, objArr, i3 + 1, i5 - i3);
        }
        objArr[i3] = obj;
        this.f24391c++;
    }

    public final boolean b(Object obj) {
        int i3 = this.f24391c + 1;
        if (this.f24389a.length < i3) {
            w(i3);
        }
        Object[] objArr = this.f24389a;
        int i4 = this.f24391c;
        objArr[i4] = obj;
        this.f24391c = i4 + 1;
        return true;
    }

    public final boolean d(int i3, MutableVector mutableVector) {
        int i4 = mutableVector.f24391c;
        if (i4 == 0) {
            return false;
        }
        int i5 = this.f24391c + i4;
        if (this.f24389a.length < i5) {
            w(i5);
        }
        Object[] objArr = this.f24389a;
        int i6 = this.f24391c;
        if (i3 != i6) {
            System.arraycopy(objArr, i3, objArr, i3 + i4, i6 - i3);
        }
        System.arraycopy(mutableVector.f24389a, 0, objArr, i3, i4);
        this.f24391c += i4;
        return true;
    }

    public final boolean e(int i3, Collection collection) {
        int i4 = 0;
        if (collection.isEmpty()) {
            return false;
        }
        int size = collection.size();
        int i5 = this.f24391c + size;
        if (this.f24389a.length < i5) {
            w(i5);
        }
        Object[] objArr = this.f24389a;
        int i6 = this.f24391c;
        if (i3 != i6) {
            System.arraycopy(objArr, i3, objArr, i3 + size, i6 - i3);
        }
        for (T t2 : collection) {
            int i7 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            objArr[i4 + i3] = t2;
            i4 = i7;
        }
        this.f24391c += size;
        return true;
    }

    public final boolean f(int i3, List list) {
        if (list.isEmpty()) {
            return false;
        }
        int size = list.size();
        int i4 = this.f24391c + size;
        if (this.f24389a.length < i4) {
            w(i4);
        }
        Object[] objArr = this.f24389a;
        int i5 = this.f24391c;
        if (i3 != i5) {
            System.arraycopy(objArr, i3, objArr, i3 + size, i5 - i3);
        }
        int size2 = list.size();
        for (int i6 = 0; i6 < size2; i6++) {
            objArr[i3 + i6] = list.get(i6);
        }
        this.f24391c += size;
        return true;
    }

    public final boolean g(Collection collection) {
        return e(this.f24391c, collection);
    }

    public final List h() {
        List list = this.f24390b;
        if (list != null) {
            return list;
        }
        MutableVectorList mutableVectorList = new MutableVectorList(this);
        this.f24390b = mutableVectorList;
        return mutableVectorList;
    }

    public final void i() {
        Object[] objArr = this.f24389a;
        int i3 = this.f24391c;
        for (int i4 = 0; i4 < i3; i4++) {
            objArr[i4] = null;
        }
        this.f24391c = 0;
    }

    public final boolean k(Object obj) {
        int iO = o() - 1;
        if (iO >= 0) {
            for (int i3 = 0; !Intrinsics.areEqual(this.f24389a[i3], obj); i3++) {
                if (i3 != iO) {
                }
            }
            return true;
        }
        return false;
    }

    public final boolean l(Collection collection) {
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            if (!k(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final Object n() {
        if (o() != 0) {
            return this.f24389a[0];
        }
        B("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final int o() {
        return this.f24391c;
    }

    public final int p(Object obj) {
        Object[] objArr = this.f24389a;
        int i3 = this.f24391c;
        for (int i4 = 0; i4 < i3; i4++) {
            if (Intrinsics.areEqual(obj, objArr[i4])) {
                return i4;
            }
        }
        return -1;
    }

    public final Object q() {
        if (o() != 0) {
            return this.f24389a[o() - 1];
        }
        B("MutableVector is empty.");
        throw new KotlinNothingValueException();
    }

    public final int r(Object obj) {
        Object[] objArr = this.f24389a;
        for (int i3 = this.f24391c - 1; i3 >= 0; i3--) {
            if (Intrinsics.areEqual(obj, objArr[i3])) {
                return i3;
            }
        }
        return -1;
    }

    public final boolean s(Object obj) {
        int iP = p(obj);
        if (iP < 0) {
            return false;
        }
        u(iP);
        return true;
    }

    public final boolean t(Collection collection) {
        if (collection.isEmpty()) {
            return false;
        }
        int i3 = this.f24391c;
        Iterator<T> it = collection.iterator();
        while (it.hasNext()) {
            s(it.next());
        }
        return i3 != this.f24391c;
    }

    public final Object u(int i3) {
        Object[] objArr = this.f24389a;
        Object obj = objArr[i3];
        if (i3 != o() - 1) {
            int i4 = i3 + 1;
            System.arraycopy(objArr, i4, objArr, i3, this.f24391c - i4);
        }
        int i5 = this.f24391c - 1;
        this.f24391c = i5;
        objArr[i5] = null;
        return obj;
    }

    public final void v(int i3, int i4) {
        if (i4 > i3) {
            int i5 = this.f24391c;
            if (i4 < i5) {
                Object[] objArr = this.f24389a;
                System.arraycopy(objArr, i4, objArr, i3, i5 - i4);
            }
            int i6 = this.f24391c - (i4 - i3);
            int iO = o() - 1;
            if (i6 <= iO) {
                int i7 = i6;
                while (true) {
                    this.f24389a[i7] = null;
                    if (i7 == iO) {
                        break;
                    } else {
                        i7++;
                    }
                }
            }
            this.f24391c = i6;
        }
    }

    public final void w(int i3) {
        Object[] objArr = this.f24389a;
        int length = objArr.length;
        Object[] objArr2 = new Object[Math.max(i3, length * 2)];
        System.arraycopy(objArr, 0, objArr2, 0, length);
        this.f24389a = objArr2;
    }

    public final boolean x(Collection collection) {
        int i3 = this.f24391c;
        for (int iO = o() - 1; -1 < iO; iO--) {
            if (!collection.contains(this.f24389a[iO])) {
                u(iO);
            }
        }
        return i3 != this.f24391c;
    }

    public final Object y(int i3, Object obj) {
        Object[] objArr = this.f24389a;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    public final void z(int i3) {
        this.f24391c = i3;
    }
}
