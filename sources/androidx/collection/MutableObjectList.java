package androidx.collection;

import androidx.collection.internal.RuntimeHelpersKt;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.CollectionToArray;
import kotlin.jvm.internal.DefaultConstructorMarker;
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
public final class MutableObjectList<E> extends ObjectList<E> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ObjectListMutableList f3017c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class MutableObjectListIterator<T> implements ListIterator<T>, KMutableListIterator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f3018a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f3019b;

        public MutableObjectListIterator(List list, int i3) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.f3018a = list;
            this.f3019b = i3 - 1;
        }

        @Override // java.util.ListIterator
        public void add(Object obj) {
            List list = this.f3018a;
            int i3 = this.f3019b + 1;
            this.f3019b = i3;
            list.add(i3, obj);
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public boolean hasNext() {
            return this.f3019b < this.f3018a.size() - 1;
        }

        @Override // java.util.ListIterator
        public boolean hasPrevious() {
            return this.f3019b >= 0;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public Object next() {
            List list = this.f3018a;
            int i3 = this.f3019b + 1;
            this.f3019b = i3;
            return list.get(i3);
        }

        @Override // java.util.ListIterator
        public int nextIndex() {
            return this.f3019b + 1;
        }

        @Override // java.util.ListIterator
        public Object previous() {
            List list = this.f3018a;
            int i3 = this.f3019b;
            this.f3019b = i3 - 1;
            return list.get(i3);
        }

        @Override // java.util.ListIterator
        public int previousIndex() {
            return this.f3019b;
        }

        @Override // java.util.ListIterator, java.util.Iterator
        public void remove() {
            this.f3018a.remove(this.f3019b);
            this.f3019b--;
        }

        @Override // java.util.ListIterator
        public void set(Object obj) {
            this.f3018a.set(this.f3019b, obj);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class ObjectListMutableList<T> implements List<T>, KMutableList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final MutableObjectList f3020a;

        public ObjectListMutableList(MutableObjectList objectList) {
            Intrinsics.checkNotNullParameter(objectList, "objectList");
            this.f3020a = objectList;
        }

        public int a() {
            return this.f3020a.e();
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            return this.f3020a.n(obj);
        }

        @Override // java.util.List
        public boolean addAll(int i3, Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.f3020a.o(i3, elements);
        }

        public Object b(int i3) {
            ObjectListKt.d(this, i3);
            return this.f3020a.A(i3);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            this.f3020a.t();
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            return this.f3020a.a(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.f3020a.b(elements);
        }

        @Override // java.util.List
        public Object get(int i3) {
            ObjectListKt.d(this, i3);
            return this.f3020a.d(i3);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            return this.f3020a.f(obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f3020a.g();
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            return this.f3020a.k(obj);
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i3) {
            return b(i3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.f3020a.z(elements);
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.f3020a.D(elements);
        }

        @Override // java.util.List
        public Object set(int i3, Object obj) {
            ObjectListKt.d(this, i3);
            return this.f3020a.E(i3, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List subList(int i3, int i4) {
            ObjectListKt.e(this, i3, i4);
            return new SubList(this, i3, i4);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List
        public void add(int i3, Object obj) {
            this.f3020a.m(i3, obj);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            return this.f3020a.q(elements);
        }

        @Override // java.util.List
        public ListIterator listIterator(int i3) {
            return new MutableObjectListIterator(this, i3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            return this.f3020a.y(obj);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return CollectionToArray.b(this, array);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class SubList<T> implements List<T>, KMutableList {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final List f3021a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f3022b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private int f3023c;

        public SubList(List list, int i3, int i4) {
            Intrinsics.checkNotNullParameter(list, "list");
            this.f3021a = list;
            this.f3022b = i3;
            this.f3023c = i4;
        }

        public int a() {
            return this.f3023c - this.f3022b;
        }

        @Override // java.util.List, java.util.Collection
        public boolean add(Object obj) {
            List list = this.f3021a;
            int i3 = this.f3023c;
            this.f3023c = i3 + 1;
            list.add(i3, obj);
            return true;
        }

        @Override // java.util.List
        public boolean addAll(int i3, Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.f3021a.addAll(i3 + this.f3022b, elements);
            this.f3023c += elements.size();
            return elements.size() > 0;
        }

        public Object b(int i3) {
            ObjectListKt.d(this, i3);
            this.f3023c--;
            return this.f3021a.remove(i3 + this.f3022b);
        }

        @Override // java.util.List, java.util.Collection
        public void clear() {
            int i3 = this.f3023c - 1;
            int i4 = this.f3022b;
            if (i4 <= i3) {
                while (true) {
                    this.f3021a.remove(i3);
                    if (i3 == i4) {
                        break;
                    } else {
                        i3--;
                    }
                }
            }
            this.f3023c = this.f3022b;
        }

        @Override // java.util.List, java.util.Collection
        public boolean contains(Object obj) {
            int i3 = this.f3023c;
            for (int i4 = this.f3022b; i4 < i3; i4++) {
                if (Intrinsics.areEqual(this.f3021a.get(i4), obj)) {
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public boolean containsAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                if (!contains(it.next())) {
                    return false;
                }
            }
            return true;
        }

        @Override // java.util.List
        public Object get(int i3) {
            ObjectListKt.d(this, i3);
            return this.f3021a.get(i3 + this.f3022b);
        }

        @Override // java.util.List
        public int indexOf(Object obj) {
            int i3 = this.f3023c;
            for (int i4 = this.f3022b; i4 < i3; i4++) {
                if (Intrinsics.areEqual(this.f3021a.get(i4), obj)) {
                    return i4 - this.f3022b;
                }
            }
            return -1;
        }

        @Override // java.util.List, java.util.Collection
        public boolean isEmpty() {
            return this.f3023c == this.f3022b;
        }

        @Override // java.util.List, java.util.Collection, java.lang.Iterable
        public Iterator iterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public int lastIndexOf(Object obj) {
            int i3 = this.f3023c - 1;
            int i4 = this.f3022b;
            if (i4 > i3) {
                return -1;
            }
            while (!Intrinsics.areEqual(this.f3021a.get(i3), obj)) {
                if (i3 == i4) {
                    return -1;
                }
                i3--;
            }
            return i3 - this.f3022b;
        }

        @Override // java.util.List
        public ListIterator listIterator() {
            return new MutableObjectListIterator(this, 0);
        }

        @Override // java.util.List
        public final /* bridge */ Object remove(int i3) {
            return b(i3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean removeAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            int i3 = this.f3023c;
            Iterator<T> it = elements.iterator();
            while (it.hasNext()) {
                remove(it.next());
            }
            return i3 != this.f3023c;
        }

        @Override // java.util.List, java.util.Collection
        public boolean retainAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            int i3 = this.f3023c;
            int i4 = i3 - 1;
            int i5 = this.f3022b;
            if (i5 <= i4) {
                while (true) {
                    if (!elements.contains(this.f3021a.get(i4))) {
                        this.f3021a.remove(i4);
                        this.f3023c--;
                    }
                    if (i4 == i5) {
                        break;
                    }
                    i4--;
                }
            }
            return i3 != this.f3023c;
        }

        @Override // java.util.List
        public Object set(int i3, Object obj) {
            ObjectListKt.d(this, i3);
            return this.f3021a.set(i3 + this.f3022b, obj);
        }

        @Override // java.util.List, java.util.Collection
        public final /* bridge */ int size() {
            return a();
        }

        @Override // java.util.List
        public List subList(int i3, int i4) {
            ObjectListKt.e(this, i3, i4);
            return new SubList(this, i3, i4);
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray() {
            return CollectionToArray.a(this);
        }

        @Override // java.util.List
        public void add(int i3, Object obj) {
            this.f3021a.add(i3 + this.f3022b, obj);
            this.f3023c++;
        }

        @Override // java.util.List
        public ListIterator listIterator(int i3) {
            return new MutableObjectListIterator(this, i3);
        }

        @Override // java.util.List, java.util.Collection
        public boolean remove(Object obj) {
            int i3 = this.f3023c;
            for (int i4 = this.f3022b; i4 < i3; i4++) {
                if (Intrinsics.areEqual(this.f3021a.get(i4), obj)) {
                    this.f3021a.remove(i4);
                    this.f3023c--;
                    return true;
                }
            }
            return false;
        }

        @Override // java.util.List, java.util.Collection
        public Object[] toArray(Object[] array) {
            Intrinsics.checkNotNullParameter(array, "array");
            return CollectionToArray.b(this, array);
        }

        @Override // java.util.List, java.util.Collection
        public boolean addAll(Collection elements) {
            Intrinsics.checkNotNullParameter(elements, "elements");
            this.f3021a.addAll(this.f3023c, elements);
            this.f3023c += elements.size();
            return elements.size() > 0;
        }
    }

    public MutableObjectList(int i3) {
        super(i3, null);
    }

    private final void F(int i3) {
        RuntimeHelpersKt.c("Index " + i3 + " must be in 0.." + this.f3082b);
    }

    public final Object A(int i3) {
        if (i3 < 0 || i3 >= this.f3082b) {
            l(i3);
        }
        Object[] objArr = this.f3081a;
        Object obj = objArr[i3];
        int i4 = this.f3082b;
        if (i3 != i4 - 1) {
            ArraysKt.copyInto(objArr, objArr, i3, i3 + 1, i4);
        }
        int i5 = this.f3082b - 1;
        this.f3082b = i5;
        objArr[i5] = null;
        return obj;
    }

    public final void B(int i3, int i4) {
        int i5;
        if (i3 < 0 || i3 > (i5 = this.f3082b) || i4 < 0 || i4 > i5) {
            RuntimeHelpersKt.c("Start (" + i3 + ") and end (" + i4 + ") must be in 0.." + this.f3082b);
        }
        if (i4 < i3) {
            RuntimeHelpersKt.a("Start (" + i3 + ") is more than end (" + i4 + ')');
        }
        if (i4 != i3) {
            int i6 = this.f3082b;
            if (i4 < i6) {
                Object[] objArr = this.f3081a;
                ArraysKt.copyInto(objArr, objArr, i3, i4, i6);
            }
            int i7 = this.f3082b;
            int i8 = i7 - (i4 - i3);
            ArraysKt.fill(this.f3081a, (Object) null, i8, i7);
            this.f3082b = i8;
        }
    }

    public final void C(int i3, Object[] oldContent) {
        Intrinsics.checkNotNullParameter(oldContent, "oldContent");
        int length = oldContent.length;
        this.f3081a = ArraysKt.copyInto(oldContent, new Object[Math.max(i3, (length * 3) / 2)], 0, 0, length);
    }

    public final boolean D(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i3 = this.f3082b;
        Object[] objArr = this.f3081a;
        for (int i4 = i3 - 1; -1 < i4; i4--) {
            if (!elements.contains(objArr[i4])) {
                A(i4);
            }
        }
        return i3 != this.f3082b;
    }

    public final Object E(int i3, Object obj) {
        if (i3 < 0 || i3 >= this.f3082b) {
            l(i3);
        }
        Object[] objArr = this.f3081a;
        Object obj2 = objArr[i3];
        objArr[i3] = obj;
        return obj2;
    }

    public final void m(int i3, Object obj) {
        if (i3 < 0 || i3 > this.f3082b) {
            F(i3);
        }
        int i4 = this.f3082b + 1;
        Object[] objArr = this.f3081a;
        if (objArr.length < i4) {
            C(i4, objArr);
        }
        Object[] objArr2 = this.f3081a;
        int i5 = this.f3082b;
        if (i3 != i5) {
            ArraysKt.copyInto(objArr2, objArr2, i3 + 1, i3, i5);
        }
        objArr2[i3] = obj;
        this.f3082b++;
    }

    public final boolean n(Object obj) {
        int i3 = this.f3082b + 1;
        Object[] objArr = this.f3081a;
        if (objArr.length < i3) {
            C(i3, objArr);
        }
        Object[] objArr2 = this.f3081a;
        int i4 = this.f3082b;
        objArr2[i4] = obj;
        this.f3082b = i4 + 1;
        return true;
    }

    public final boolean o(int i3, Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (i3 < 0 || i3 > this.f3082b) {
            F(i3);
        }
        int i4 = 0;
        if (elements.isEmpty()) {
            return false;
        }
        int size = this.f3082b + elements.size();
        Object[] objArr = this.f3081a;
        if (objArr.length < size) {
            C(size, objArr);
        }
        Object[] objArr2 = this.f3081a;
        if (i3 != this.f3082b) {
            ArraysKt.copyInto(objArr2, objArr2, elements.size() + i3, i3, this.f3082b);
        }
        for (Object obj : elements) {
            int i5 = i4 + 1;
            if (i4 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            objArr2[i4 + i3] = obj;
            i4 = i5;
        }
        this.f3082b += elements.size();
        return true;
    }

    public final boolean p(ObjectList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i3 = this.f3082b;
        v(elements);
        return i3 != this.f3082b;
    }

    public final boolean q(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i3 = this.f3082b;
        w(elements);
        return i3 != this.f3082b;
    }

    public final boolean r(List elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i3 = this.f3082b;
        x(elements);
        return i3 != this.f3082b;
    }

    public final List s() {
        ObjectListMutableList objectListMutableList = this.f3017c;
        if (objectListMutableList != null) {
            return objectListMutableList;
        }
        ObjectListMutableList objectListMutableList2 = new ObjectListMutableList(this);
        this.f3017c = objectListMutableList2;
        return objectListMutableList2;
    }

    public final void t() {
        ArraysKt.fill(this.f3081a, (Object) null, 0, this.f3082b);
        this.f3082b = 0;
    }

    public final void u(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            y(it.next());
        }
    }

    public final void v(ObjectList elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.g()) {
            return;
        }
        int i3 = this.f3082b + elements.f3082b;
        Object[] objArr = this.f3081a;
        if (objArr.length < i3) {
            C(i3, objArr);
        }
        ArraysKt.copyInto(elements.f3081a, this.f3081a, this.f3082b, 0, elements.f3082b);
        this.f3082b += elements.f3082b;
    }

    public final void w(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator it = elements.iterator();
        while (it.hasNext()) {
            n(it.next());
        }
    }

    public final void x(List elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return;
        }
        int i3 = this.f3082b;
        int size = elements.size() + i3;
        Object[] objArr = this.f3081a;
        if (objArr.length < size) {
            C(size, objArr);
        }
        Object[] objArr2 = this.f3081a;
        int size2 = elements.size();
        for (int i4 = 0; i4 < size2; i4++) {
            objArr2[i4 + i3] = elements.get(i4);
        }
        this.f3082b += elements.size();
    }

    public final boolean y(Object obj) {
        int iF = f(obj);
        if (iF < 0) {
            return false;
        }
        A(iF);
        return true;
    }

    public final boolean z(Iterable elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        int i3 = this.f3082b;
        u(elements);
        return i3 != this.f3082b;
    }

    public /* synthetic */ MutableObjectList(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 16 : i3);
    }
}
