package androidx.collection;

import androidx.collection.internal.ContainerHelpersKt;
import com.applovin.impl.sdk.utils.JsonUtils;
import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.markers.KMutableCollection;
import kotlin.jvm.internal.markers.KMutableSet;

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
public final class ArraySet<E> implements Collection<E>, Set<E>, KMutableCollection, KMutableSet {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f2798a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f2799b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private int f2800c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private final class ElementIterator extends IndexBasedArrayIterator<E> {
        public ElementIterator() {
            super(ArraySet.this.f());
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected Object a(int i3) {
            return ArraySet.this.o(i3);
        }

        @Override // androidx.collection.IndexBasedArrayIterator
        protected void b(int i3) {
            ArraySet.this.g(i3);
        }
    }

    public ArraySet() {
        this(0, 1, null);
    }

    public final void a(int i3) {
        int iF = f();
        if (d().length < i3) {
            int[] iArrD = d();
            Object[] objArrB = b();
            ArraySetKt.a(this, i3);
            if (f() > 0) {
                ArraysKt.copyInto$default(iArrD, d(), 0, 0, f(), 6, (Object) null);
                ArraysKt.copyInto$default(objArrB, b(), 0, 0, f(), 6, (Object) null);
            }
        }
        if (f() != iF) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean add(Object obj) {
        int i3;
        int iC;
        int iF = f();
        if (obj == null) {
            iC = ArraySetKt.d(this);
            i3 = 0;
        } else {
            int iHashCode = obj.hashCode();
            i3 = iHashCode;
            iC = ArraySetKt.c(this, obj, iHashCode);
        }
        if (iC >= 0) {
            return false;
        }
        int i4 = ~iC;
        if (iF >= d().length) {
            int i5 = 8;
            if (iF >= 8) {
                i5 = (iF >> 1) + iF;
            } else if (iF < 4) {
                i5 = 4;
            }
            int[] iArrD = d();
            Object[] objArrB = b();
            ArraySetKt.a(this, i5);
            if (iF != f()) {
                throw new ConcurrentModificationException();
            }
            if (!(d().length == 0)) {
                ArraysKt.copyInto$default(iArrD, d(), 0, 0, iArrD.length, 6, (Object) null);
                ArraysKt.copyInto$default(objArrB, b(), 0, 0, objArrB.length, 6, (Object) null);
            }
        }
        if (i4 < iF) {
            int i6 = i4 + 1;
            ArraysKt.copyInto(d(), d(), i6, i4, iF);
            ArraysKt.copyInto(b(), b(), i6, i4, iF);
        }
        if (iF != f() || i4 >= d().length) {
            throw new ConcurrentModificationException();
        }
        d()[i4] = i3;
        b()[i4] = obj;
        n(f() + 1);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        a(f() + elements.size());
        Iterator<E> it = elements.iterator();
        boolean zAdd = false;
        while (it.hasNext()) {
            zAdd |= add(it.next());
        }
        return zAdd;
    }

    public final Object[] b() {
        return this.f2799b;
    }

    @Override // java.util.Collection, java.util.Set
    public void clear() {
        if (f() != 0) {
            l(ContainerHelpersKt.f3174a);
            h(ContainerHelpersKt.f3176c);
            n(0);
        }
        if (f() != 0) {
            throw new ConcurrentModificationException();
        }
    }

    @Override // java.util.Collection, java.util.Set
    public boolean contains(Object obj) {
        return indexOf(obj) >= 0;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean containsAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<E> it = elements.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    public final int[] d() {
        return this.f2798a;
    }

    public int e() {
        return this.f2800c;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Set) || size() != ((Set) obj).size()) {
            return false;
        }
        try {
            int iF = f();
            for (int i3 = 0; i3 < iF; i3++) {
                if (!((Set) obj).contains(o(i3))) {
                    return false;
                }
            }
            return true;
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final int f() {
        return this.f2800c;
    }

    public final Object g(int i3) {
        int i4;
        Object[] objArr;
        int iF = f();
        Object obj = b()[i3];
        if (iF <= 1) {
            clear();
            return obj;
        }
        int i5 = iF - 1;
        if (d().length <= 8 || f() >= d().length / 3) {
            if (i3 < i5) {
                int i6 = i3 + 1;
                ArraysKt.copyInto(d(), d(), i3, i6, iF);
                ArraysKt.copyInto(b(), b(), i3, i6, iF);
            }
            b()[i5] = null;
        } else {
            int iF2 = f() > 8 ? f() + (f() >> 1) : 8;
            int[] iArrD = d();
            Object[] objArrB = b();
            ArraySetKt.a(this, iF2);
            if (i3 > 0) {
                ArraysKt.copyInto$default(iArrD, d(), 0, 0, i3, 6, (Object) null);
                objArr = objArrB;
                ArraysKt.copyInto$default(objArr, b(), 0, 0, i3, 6, (Object) null);
                i4 = i3;
            } else {
                i4 = i3;
                objArr = objArrB;
            }
            if (i4 < i5) {
                int i7 = i4 + 1;
                ArraysKt.copyInto(iArrD, d(), i4, i7, iF);
                ArraysKt.copyInto(objArr, b(), i4, i7, iF);
            }
        }
        if (iF != f()) {
            throw new ConcurrentModificationException();
        }
        n(i5);
        return obj;
    }

    public final void h(Object[] objArr) {
        Intrinsics.checkNotNullParameter(objArr, "<set-?>");
        this.f2799b = objArr;
    }

    @Override // java.util.Collection, java.util.Set
    public int hashCode() {
        int[] iArrD = d();
        int iF = f();
        int i3 = 0;
        for (int i4 = 0; i4 < iF; i4++) {
            i3 += iArrD[i4];
        }
        return i3;
    }

    public final int indexOf(Object obj) {
        return obj == null ? ArraySetKt.d(this) : ArraySetKt.c(this, obj, obj.hashCode());
    }

    @Override // java.util.Collection, java.util.Set
    public boolean isEmpty() {
        return f() <= 0;
    }

    @Override // java.util.Collection, java.lang.Iterable, java.util.Set
    public Iterator iterator() {
        return new ElementIterator();
    }

    public final void l(int[] iArr) {
        Intrinsics.checkNotNullParameter(iArr, "<set-?>");
        this.f2798a = iArr;
    }

    public final void n(int i3) {
        this.f2800c = i3;
    }

    public final Object o(int i3) {
        return b()[i3];
    }

    @Override // java.util.Collection, java.util.Set
    public boolean remove(Object obj) {
        int iIndexOf = indexOf(obj);
        if (iIndexOf < 0) {
            return false;
        }
        g(iIndexOf);
        return true;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean removeAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        Iterator<E> it = elements.iterator();
        boolean zRemove = false;
        while (it.hasNext()) {
            zRemove |= remove(it.next());
        }
        return zRemove;
    }

    @Override // java.util.Collection, java.util.Set
    public boolean retainAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        boolean z2 = false;
        for (int iF = f() - 1; -1 < iF; iF--) {
            if (!CollectionsKt.contains(elements, b()[iF])) {
                g(iF);
                z2 = true;
            }
        }
        return z2;
    }

    @Override // java.util.Collection, java.util.Set
    public final /* bridge */ int size() {
        return e();
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray() {
        return ArraysKt.copyOfRange(this.f2799b, 0, this.f2800c);
    }

    public String toString() {
        if (isEmpty()) {
            return JsonUtils.EMPTY_JSON;
        }
        StringBuilder sb = new StringBuilder(f() * 14);
        sb.append('{');
        int iF = f();
        for (int i3 = 0; i3 < iF; i3++) {
            if (i3 > 0) {
                sb.append(", ");
            }
            Object objO = o(i3);
            if (objO != this) {
                sb.append(objO);
            } else {
                sb.append("(this Set)");
            }
        }
        sb.append('}');
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public ArraySet(int i3) {
        this.f2798a = ContainerHelpersKt.f3174a;
        this.f2799b = ContainerHelpersKt.f3176c;
        if (i3 > 0) {
            ArraySetKt.a(this, i3);
        }
    }

    @Override // java.util.Collection, java.util.Set
    public final Object[] toArray(Object[] array) {
        Intrinsics.checkNotNullParameter(array, "array");
        Object[] objArrA = ArraySetJvmUtil.a(array, this.f2800c);
        ArraysKt.copyInto(this.f2799b, objArrA, 0, 0, this.f2800c);
        Intrinsics.checkNotNull(objArrA);
        return objArrA;
    }

    public /* synthetic */ ArraySet(int i3, int i4, DefaultConstructorMarker defaultConstructorMarker) {
        this((i4 & 1) != 0 ? 0 : i3);
    }
}
