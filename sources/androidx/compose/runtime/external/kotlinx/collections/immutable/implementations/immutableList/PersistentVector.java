package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.ListImplementation;
import java.util.Arrays;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
@Metadata
public final class PersistentVector<E> extends AbstractPersistentList<E> implements PersistentList<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object[] f24426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Object[] f24427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f24428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final int f24429d;

    public PersistentVector(Object[] objArr, Object[] objArr2, int i3, int i4) {
        this.f24426a = objArr;
        this.f24427b = objArr2;
        this.f24428c = i3;
        this.f24429d = i4;
        if (!(size() > 32)) {
            PreconditionsKt.a("Trie-based persistent vector should have at least 33 elements, got " + size());
        }
        CommonFunctionsKt.a(size() - UtilsKt.d(size()) <= RangesKt.k(objArr2.length, 32));
    }

    private final Object[] b(int i3) {
        if (q() <= i3) {
            return this.f24427b;
        }
        Object[] objArr = this.f24426a;
        for (int i4 = this.f24429d; i4 > 0; i4 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.a(i3, i4)];
            Intrinsics.checkNotNull(objArr2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] e(Object[] objArr, int i3, int i4, Object obj, ObjectRef objectRef) {
        Object[] objArrCopyOf;
        int iA = UtilsKt.a(i4, i3);
        if (i3 == 0) {
            if (iA == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            }
            ArraysKt.copyInto(objArr, objArrCopyOf, iA + 1, iA, 31);
            objectRef.b(objArr[31]);
            objArrCopyOf[iA] = obj;
            return objArrCopyOf;
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
        int i5 = i3 - 5;
        Object obj2 = objArr[iA];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iA] = e((Object[]) obj2, i5, i4, obj, objectRef);
        while (true) {
            iA++;
            if (iA >= 32 || objArrCopyOf2[iA] == null) {
                break;
            }
            Object obj3 = objArr[iA];
            Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrCopyOf2[iA] = e((Object[]) obj3, i5, 0, objectRef.a(), objectRef);
        }
        return objArrCopyOf2;
    }

    private final PersistentVector f(Object[] objArr, int i3, Object obj) {
        int size = size() - q();
        Object[] objArrCopyOf = Arrays.copyOf(this.f24427b, 32);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        if (size < 32) {
            ArraysKt.copyInto(this.f24427b, objArrCopyOf, i3 + 1, i3, size);
            objArrCopyOf[i3] = obj;
            return new PersistentVector(objArr, objArrCopyOf, size() + 1, this.f24429d);
        }
        Object[] objArr2 = this.f24427b;
        Object obj2 = objArr2[31];
        ArraysKt.copyInto(objArr2, objArrCopyOf, i3 + 1, i3, size - 1);
        objArrCopyOf[i3] = obj;
        return l(objArr, objArrCopyOf, UtilsKt.c(obj2));
    }

    private final Object[] g(Object[] objArr, int i3, int i4, ObjectRef objectRef) {
        Object[] objArrG;
        int iA = UtilsKt.a(i4, i3);
        if (i3 == 5) {
            objectRef.b(objArr[iA]);
            objArrG = null;
        } else {
            Object obj = objArr[iA];
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            objArrG = g((Object[]) obj, i3 - 5, i4, objectRef);
        }
        if (objArrG == null && iA == 0) {
            return null;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[iA] = objArrG;
        return objArrCopyOf;
    }

    private final PersistentList h(Object[] objArr, int i3, int i4) {
        if (i4 == 0) {
            if (objArr.length == 33) {
                objArr = Arrays.copyOf(objArr, 32);
                Intrinsics.checkNotNullExpressionValue(objArr, "copyOf(...)");
            }
            return new SmallPersistentVector(objArr);
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArrG = g(objArr, i4, i3 - 1, objectRef);
        Intrinsics.checkNotNull(objArrG);
        Object objA = objectRef.a();
        Intrinsics.checkNotNull(objA, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        Object[] objArr2 = (Object[]) objA;
        if (objArrG[1] != null) {
            return new PersistentVector(objArrG, objArr2, i3, i4);
        }
        Object obj = objArrG[0];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        return new PersistentVector((Object[]) obj, objArr2, i3, i4 - 5);
    }

    private final PersistentVector l(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i3 = this.f24429d;
        if (size <= (1 << i3)) {
            return new PersistentVector(n(objArr, i3, objArr2), objArr3, size() + 1, this.f24429d);
        }
        Object[] objArrC = UtilsKt.c(objArr);
        int i4 = this.f24429d + 5;
        return new PersistentVector(n(objArrC, i4, objArr2), objArr3, size() + 1, i4);
    }

    /* JADX WARN: Removed duplicated region for block: B:6:0x0019  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final java.lang.Object[] n(java.lang.Object[] r4, int r5, java.lang.Object[] r6) {
        /*
            r3 = this;
            int r0 = r3.size()
            int r0 = r0 + (-1)
            int r0 = androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.UtilsKt.a(r0, r5)
            r1 = 32
            if (r4 == 0) goto L19
            java.lang.Object[] r4 = java.util.Arrays.copyOf(r4, r1)
            java.lang.String r2 = "copyOf(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)
            if (r4 != 0) goto L1b
        L19:
            java.lang.Object[] r4 = new java.lang.Object[r1]
        L1b:
            r1 = 5
            if (r5 != r1) goto L21
            r4[r0] = r6
            return r4
        L21:
            r2 = r4[r0]
            java.lang.Object[] r2 = (java.lang.Object[]) r2
            int r5 = r5 - r1
            java.lang.Object[] r5 = r3.n(r2, r5, r6)
            r4[r0] = r5
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableList.PersistentVector.n(java.lang.Object[], int, java.lang.Object[]):java.lang.Object[]");
    }

    private final Object[] o(Object[] objArr, int i3, int i4, ObjectRef objectRef) {
        Object[] objArrCopyOf;
        int iA = UtilsKt.a(i4, i3);
        if (i3 == 0) {
            if (iA == 0) {
                objArrCopyOf = new Object[32];
            } else {
                objArrCopyOf = Arrays.copyOf(objArr, 32);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            }
            ArraysKt.copyInto(objArr, objArrCopyOf, iA, iA + 1, 32);
            objArrCopyOf[31] = objectRef.a();
            objectRef.b(objArr[iA]);
            return objArrCopyOf;
        }
        int iA2 = objArr[31] == null ? UtilsKt.a(q() - 1, i3) : 31;
        Object[] objArrCopyOf2 = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
        int i5 = i3 - 5;
        int i6 = iA + 1;
        if (i6 <= iA2) {
            while (true) {
                Object obj = objArrCopyOf2[iA2];
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                objArrCopyOf2[iA2] = o((Object[]) obj, i5, 0, objectRef);
                if (iA2 == i6) {
                    break;
                }
                iA2--;
            }
        }
        Object obj2 = objArrCopyOf2[iA];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf2[iA] = o((Object[]) obj2, i5, i4, objectRef);
        return objArrCopyOf2;
    }

    private final PersistentList p(Object[] objArr, int i3, int i4, int i5) {
        int size = size() - i3;
        CommonFunctionsKt.a(i5 < size);
        if (size == 1) {
            return h(objArr, i3, i4);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f24427b, 32);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        int i6 = size - 1;
        if (i5 < i6) {
            ArraysKt.copyInto(this.f24427b, objArrCopyOf, i5, i5 + 1, size);
        }
        objArrCopyOf[i6] = null;
        return new PersistentVector(objArr, objArrCopyOf, (i3 + size) - 1, i4);
    }

    private final int q() {
        return UtilsKt.d(size());
    }

    private final Object[] s(Object[] objArr, int i3, int i4, Object obj) {
        int iA = UtilsKt.a(i4, i3);
        Object[] objArrCopyOf = Arrays.copyOf(objArr, 32);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        if (i3 == 0) {
            objArrCopyOf[iA] = obj;
            return objArrCopyOf;
        }
        Object obj2 = objArrCopyOf[iA];
        Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        objArrCopyOf[iA] = s((Object[]) obj2, i3 - 5, i4, obj);
        return objArrCopyOf;
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList R1(Function1 function1) {
        PersistentVectorBuilder persistentVectorBuilderBuilder = builder();
        persistentVectorBuilderBuilder.I(function1);
        return persistentVectorBuilderBuilder.build();
    }

    @Override // java.util.Collection, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList add(Object obj) {
        int size = size() - q();
        if (size >= 32) {
            return l(this.f24426a, this.f24427b, UtilsKt.c(obj));
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f24427b, 32);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[size] = obj;
        return new PersistentVector(this.f24426a, objArrCopyOf, size() + 1, this.f24429d);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    /* JADX INFO: renamed from: d, reason: merged with bridge method [inline-methods] */
    public PersistentVectorBuilder builder() {
        return new PersistentVectorBuilder(this, this.f24426a, this.f24427b, this.f24429d);
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public Object get(int i3) {
        ListImplementation.a(i3, size());
        return b(i3)[i3 & 31];
    }

    @Override // kotlin.collections.AbstractList, kotlin.collections.AbstractCollection
    public int getSize() {
        return this.f24428c;
    }

    @Override // kotlin.collections.AbstractList, java.util.List
    public ListIterator listIterator(int i3) {
        ListImplementation.b(i3, size());
        return new PersistentVectorIterator(this.f24426a, this.f24427b, i3, size(), (this.f24429d / 5) + 1);
    }

    @Override // androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList q0(int i3) {
        ListImplementation.a(i3, size());
        int iQ = q();
        return i3 >= iQ ? p(this.f24426a, iQ, this.f24429d, i3 - iQ) : p(o(this.f24426a, this.f24429d, i3, new ObjectRef(this.f24427b[0])), iQ, this.f24429d, 0);
    }

    @Override // kotlin.collections.AbstractList, java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList set(int i3, Object obj) {
        ListImplementation.a(i3, size());
        if (q() > i3) {
            return new PersistentVector(s(this.f24426a, this.f24429d, i3, obj), this.f24427b, size(), this.f24429d);
        }
        Object[] objArrCopyOf = Arrays.copyOf(this.f24427b, 32);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i3 & 31] = obj;
        return new PersistentVector(this.f24426a, objArrCopyOf, size(), this.f24429d);
    }

    @Override // java.util.List, androidx.compose.runtime.external.kotlinx.collections.immutable.PersistentList
    public PersistentList add(int i3, Object obj) {
        ListImplementation.b(i3, size());
        if (i3 == size()) {
            return add(obj);
        }
        int iQ = q();
        if (i3 >= iQ) {
            return f(this.f24426a, i3 - iQ, obj);
        }
        ObjectRef objectRef = new ObjectRef(null);
        return f(e(this.f24426a, this.f24429d, i3, obj, objectRef), 0, objectRef.a());
    }
}
