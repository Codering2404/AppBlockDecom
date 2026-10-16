package kotlinx.collections.immutable.implementations.immutableList;

import androidx.glance.session.ecY.lisODU;
import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import kotlin.Metadata;
import kotlin.collections.AbstractMutableList;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.ArrayIteratorKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.PersistentList;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlinx.collections.immutable.internal.ListImplementation;
import kotlinx.collections.immutable.internal.MutabilityOwnership;

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
public final class PersistentVectorBuilder<E> extends AbstractMutableList<E> implements PersistentList.Builder<E> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private PersistentList f140709a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f140710b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Object[] f140711c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int f140712d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private MutabilityOwnership f140713f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Object[] f140714g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Object[] f140715h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f140716i;

    public PersistentVectorBuilder(PersistentList vector, Object[] objArr, Object[] vectorTail, int i3) {
        Intrinsics.checkNotNullParameter(vector, "vector");
        Intrinsics.checkNotNullParameter(vectorTail, "vectorTail");
        this.f140709a = vector;
        this.f140710b = objArr;
        this.f140711c = vectorTail;
        this.f140712d = i3;
        this.f140713f = new MutabilityOwnership();
        this.f140714g = this.f140710b;
        this.f140715h = this.f140711c;
        this.f140716i = this.f140709a.size();
    }

    private final Object[] A(Object[] objArr, int i3, Object[][] objArr2) {
        Iterator itA = ArrayIteratorKt.a(objArr2);
        int i4 = i3 >> 5;
        int i5 = this.f140712d;
        Object[] objArrY = i4 < (1 << i5) ? y(objArr, i3, i5, itA) : q(objArr);
        while (itA.hasNext()) {
            this.f140712d += 5;
            objArrY = u(objArrY);
            int i6 = this.f140712d;
            y(objArrY, 1 << i6, i6, itA);
        }
        return objArrY;
    }

    private final void B(Object[] objArr, Object[] objArr2, Object[] objArr3) {
        int size = size() >> 5;
        int i3 = this.f140712d;
        if (size > (1 << i3)) {
            this.f140714g = C(u(objArr), objArr2, this.f140712d + 5);
            this.f140715h = objArr3;
            this.f140712d += 5;
            this.f140716i = size() + 1;
            return;
        }
        if (objArr == null) {
            this.f140714g = objArr2;
            this.f140715h = objArr3;
            this.f140716i = size() + 1;
        } else {
            this.f140714g = C(objArr, objArr2, i3);
            this.f140715h = objArr3;
            this.f140716i = size() + 1;
        }
    }

    private final Object[] C(Object[] objArr, Object[] objArr2, int i3) {
        int iA = UtilsKt.a(size() - 1, i3);
        Object[] objArrQ = q(objArr);
        if (i3 == 5) {
            objArrQ[iA] = objArr2;
            return objArrQ;
        }
        objArrQ[iA] = C((Object[]) objArrQ[iA], objArr2, i3 - 5);
        return objArrQ;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final int D(Function1 function1, Object[] objArr, int i3, int i4, ObjectRef objectRef, List list, List list2) {
        if (o(objArr)) {
            list.add(objArr);
        }
        Object objA = objectRef.a();
        if (objA == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        Object[] objArr2 = (Object[]) objA;
        Object[] objArrT = objArr2;
        int i5 = 0;
        while (i5 < i3) {
            int i6 = i5 + 1;
            Object obj = objArr[i5];
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                i5 = i6;
            } else {
                if (i4 == 32) {
                    objArrT = !list.isEmpty() ? (Object[]) list.remove(list.size() - 1) : t();
                    i4 = 0;
                }
                objArrT[i4] = obj;
                i5 = i6;
                i4++;
            }
        }
        objectRef.b(objArrT);
        if (objArr2 != objectRef.a()) {
            list2.add(objArr2);
        }
        return i4;
    }

    private final int E(Function1 function1, Object[] objArr, int i3, ObjectRef objectRef) {
        int i4 = 0;
        Object[] objArrQ = objArr;
        int i5 = i3;
        boolean z2 = false;
        while (i4 < i3) {
            int i6 = i4 + 1;
            Object obj = objArr[i4];
            if (((Boolean) function1.invoke(obj)).booleanValue()) {
                if (!z2) {
                    objArrQ = q(objArr);
                    z2 = true;
                    i5 = i4;
                }
            } else if (z2) {
                i4 = i5 + 1;
                objArrQ[i5] = obj;
                i5 = i4;
            }
            i4 = i6;
        }
        objectRef.b(objArrQ);
        return i5;
    }

    private final boolean G(Function1 function1) {
        Object[] objArrY;
        int iR = R();
        ObjectRef objectRef = new ObjectRef(null);
        if (this.f140714g == null) {
            return H(function1, iR, objectRef) != iR;
        }
        ListIterator listIteratorP = p(0);
        int iE = 32;
        while (iE == 32 && listIteratorP.hasNext()) {
            iE = E(function1, (Object[]) listIteratorP.next(), 32, objectRef);
        }
        if (iE == 32) {
            CommonFunctionsKt.a(!listIteratorP.hasNext());
            int iH = H(function1, iR, objectRef);
            if (iH == 0) {
                x(this.f140714g, size(), this.f140712d);
            }
            return iH != iR;
        }
        int iPreviousIndex = listIteratorP.previousIndex() << 5;
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        int iD = iE;
        while (listIteratorP.hasNext()) {
            iD = D(function1, (Object[]) listIteratorP.next(), 32, iD, objectRef, arrayList2, arrayList);
        }
        int iD2 = D(function1, this.f140715h, iR, iD, objectRef, arrayList2, arrayList);
        Object objA = objectRef.a();
        if (objA == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        Object[] objArr = (Object[]) objA;
        ArraysKt.fill(objArr, (Object) null, iD2, 32);
        if (arrayList.isEmpty()) {
            objArrY = this.f140714g;
            Intrinsics.checkNotNull(objArrY);
        } else {
            objArrY = y(this.f140714g, iPreviousIndex, this.f140712d, arrayList.iterator());
        }
        int size = iPreviousIndex + (arrayList.size() << 5);
        this.f140714g = L(objArrY, size);
        this.f140715h = objArr;
        this.f140716i = size + iD2;
        return true;
    }

    private final int H(Function1 function1, int i3, ObjectRef objectRef) {
        int iE = E(function1, this.f140715h, i3, objectRef);
        if (iE == i3) {
            CommonFunctionsKt.a(objectRef.a() == this.f140715h);
            return i3;
        }
        Object objA = objectRef.a();
        if (objA == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        Object[] objArr = (Object[]) objA;
        ArraysKt.fill(objArr, (Object) null, iE, i3);
        this.f140715h = objArr;
        this.f140716i = size() - (i3 - iE);
        return iE;
    }

    private final Object[] J(Object[] objArr, int i3, int i4, ObjectRef objectRef) {
        int iA = UtilsKt.a(i4, i3);
        if (i3 == 0) {
            Object obj = objArr[iA];
            Object[] objArrCopyInto = ArraysKt.copyInto(objArr, q(objArr), iA, iA + 1, 32);
            objArrCopyInto[31] = objectRef.a();
            objectRef.b(obj);
            return objArrCopyInto;
        }
        int iA2 = objArr[31] == null ? UtilsKt.a(M() - 1, i3) : 31;
        Object[] objArrQ = q(objArr);
        int i5 = i3 - 5;
        int i6 = iA + 1;
        if (i6 <= iA2) {
            while (true) {
                int i7 = iA2 - 1;
                Object obj2 = objArrQ[iA2];
                if (obj2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
                }
                objArrQ[iA2] = J((Object[]) obj2, i5, 0, objectRef);
                if (iA2 == i6) {
                    break;
                }
                iA2 = i7;
            }
        }
        Object obj3 = objArrQ[iA];
        if (obj3 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        objArrQ[iA] = J((Object[]) obj3, i5, i4, objectRef);
        return objArrQ;
    }

    private final Object K(Object[] objArr, int i3, int i4, int i5) {
        int size = size() - i3;
        CommonFunctionsKt.a(i5 < size);
        if (size == 1) {
            Object obj = this.f140715h[0];
            x(objArr, i3, i4);
            return obj;
        }
        Object[] objArr2 = this.f140715h;
        Object obj2 = objArr2[i5];
        Object[] objArrCopyInto = ArraysKt.copyInto(objArr2, q(objArr2), i5, i5 + 1, size);
        objArrCopyInto[size - 1] = null;
        this.f140714g = objArr;
        this.f140715h = objArrCopyInto;
        this.f140716i = (i3 + size) - 1;
        this.f140712d = i4;
        return obj2;
    }

    private final Object[] L(Object[] objArr, int i3) {
        if ((i3 & 31) != 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (i3 == 0) {
            this.f140712d = 0;
            return null;
        }
        int i4 = i3 - 1;
        while (true) {
            int i5 = this.f140712d;
            if ((i4 >> i5) != 0) {
                return v(objArr, i4, i5);
            }
            this.f140712d = i5 - 5;
            Object[] objArr2 = objArr[0];
            if (objArr2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr = objArr2;
        }
    }

    private final int M() {
        if (size() <= 32) {
            return 0;
        }
        return UtilsKt.c(size());
    }

    private final Object[] N(Object[] objArr, int i3, int i4, Object obj, ObjectRef objectRef) {
        int iA = UtilsKt.a(i4, i3);
        Object[] objArrQ = q(objArr);
        if (i3 == 0) {
            if (objArrQ != objArr) {
                ((AbstractList) this).modCount++;
            }
            objectRef.b(objArrQ[iA]);
            objArrQ[iA] = obj;
            return objArrQ;
        }
        Object obj2 = objArrQ[iA];
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        objArrQ[iA] = N((Object[]) obj2, i3 - 5, i4, obj, objectRef);
        return objArrQ;
    }

    private final Object[] P(int i3, int i4, Object[][] objArr, int i5, Object[] objArr2) {
        if (this.f140714g == null) {
            throw new IllegalStateException("Required value was null.");
        }
        ListIterator listIteratorP = p(M() >> 5);
        while (listIteratorP.previousIndex() != i3) {
            Object[] objArr3 = (Object[]) listIteratorP.previous();
            ArraysKt.copyInto(objArr3, objArr2, 0, 32 - i4, 32);
            objArr2 = s(objArr3, i4);
            i5--;
            objArr[i5] = objArr2;
        }
        return (Object[]) listIteratorP.previous();
    }

    private final void Q(Collection collection, int i3, Object[] objArr, int i4, Object[][] objArr2, int i5, Object[] objArr3) {
        Object[] objArrT;
        if (i5 < 1) {
            throw new IllegalStateException("Check failed.");
        }
        Object[] objArrQ = q(objArr);
        objArr2[0] = objArrQ;
        int i6 = i3 & 31;
        int size = ((i3 + collection.size()) - 1) & 31;
        int i7 = (i4 - i6) + size;
        if (i7 < 32) {
            ArraysKt.copyInto(objArrQ, objArr3, size + 1, i6, i4);
        } else {
            int i8 = i7 - 31;
            if (i5 == 1) {
                objArrT = objArrQ;
            } else {
                objArrT = t();
                i5--;
                objArr2[i5] = objArrT;
            }
            int i9 = i4 - i8;
            ArraysKt.copyInto(objArrQ, objArr3, 0, i9, i4);
            ArraysKt.copyInto(objArrQ, objArrT, size + 1, i6, i9);
            objArr3 = objArrT;
        }
        Iterator<E> it = collection.iterator();
        b(objArrQ, i6, it);
        for (int i10 = 1; i10 < i5; i10++) {
            objArr2[i10] = b(t(), 0, it);
        }
        b(objArr3, 0, it);
    }

    private final int R() {
        return S(size());
    }

    private final int S(int i3) {
        return i3 <= 32 ? i3 : i3 - UtilsKt.c(i3);
    }

    private final Object[] a(int i3) {
        if (M() <= i3) {
            return this.f140715h;
        }
        Object[] objArr = this.f140714g;
        Intrinsics.checkNotNull(objArr);
        for (int i4 = this.f140712d; i4 > 0; i4 -= 5) {
            Object[] objArr2 = objArr[UtilsKt.a(i3, i4)];
            if (objArr2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArr = objArr2;
        }
        return objArr;
    }

    private final Object[] b(Object[] objArr, int i3, Iterator it) {
        while (i3 < 32 && it.hasNext()) {
            objArr[i3] = it.next();
            i3++;
        }
        return objArr;
    }

    private final void h(Collection collection, int i3, int i4, Object[][] objArr, int i5, Object[] objArr2) {
        Object[] objArr3;
        if (this.f140714g == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int i6 = i3 >> 5;
        Object[] objArrP = P(i6, i4, objArr, i5, objArr2);
        int iM = i5 - (((M() >> 5) - 1) - i6);
        if (iM < i5) {
            Object[] objArr4 = objArr[iM];
            Intrinsics.checkNotNull(objArr4);
            objArr3 = objArr4;
        } else {
            objArr3 = objArr2;
        }
        Q(collection, i3, objArrP, 32, objArr, iM, objArr3);
    }

    private final Object[] l(Object[] objArr, int i3, int i4, Object obj, ObjectRef objectRef) {
        int iA = UtilsKt.a(i4, i3);
        if (i3 == 0) {
            objectRef.b(objArr[31]);
            Object[] objArrCopyInto = ArraysKt.copyInto(objArr, q(objArr), iA + 1, iA, 31);
            objArrCopyInto[iA] = obj;
            return objArrCopyInto;
        }
        Object[] objArrQ = q(objArr);
        int i5 = i3 - 5;
        Object obj2 = objArrQ[iA];
        if (obj2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        objArrQ[iA] = l((Object[]) obj2, i5, i4, obj, objectRef);
        int i6 = iA + 1;
        while (i6 < 32) {
            int i7 = i6 + 1;
            Object obj3 = objArrQ[i6];
            if (obj3 == null) {
                break;
            }
            if (obj3 == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArrQ[i6] = l((Object[]) obj3, i5, 0, objectRef.a(), objectRef);
            i6 = i7;
        }
        return objArrQ;
    }

    private final void n(Object[] objArr, int i3, Object obj) {
        int iR = R();
        Object[] objArrQ = q(this.f140715h);
        if (iR < 32) {
            ArraysKt.copyInto(this.f140715h, objArrQ, i3 + 1, i3, iR);
            objArrQ[i3] = obj;
            this.f140714g = objArr;
            this.f140715h = objArrQ;
            this.f140716i = size() + 1;
            return;
        }
        Object[] objArr2 = this.f140715h;
        Object obj2 = objArr2[31];
        ArraysKt.copyInto(objArr2, objArrQ, i3 + 1, i3, 31);
        objArrQ[i3] = obj;
        B(objArr, objArrQ, u(obj2));
    }

    private final boolean o(Object[] objArr) {
        return objArr.length == 33 && objArr[32] == this.f140713f;
    }

    private final ListIterator p(int i3) {
        if (this.f140714g == null) {
            throw new IllegalStateException("Required value was null.");
        }
        int iM = M() >> 5;
        ListImplementation.b(i3, iM);
        int i4 = this.f140712d;
        if (i4 == 0) {
            Object[] objArr = this.f140714g;
            Intrinsics.checkNotNull(objArr);
            return new SingleElementListIterator(objArr, i3);
        }
        Object[] objArr2 = this.f140714g;
        Intrinsics.checkNotNull(objArr2);
        return new TrieIterator(objArr2, i3, iM, i4 / 5);
    }

    private final Object[] q(Object[] objArr) {
        return objArr == null ? t() : o(objArr) ? objArr : ArraysKt.copyInto$default(objArr, t(), 0, 0, RangesKt.k(objArr.length, 32), 6, (Object) null);
    }

    private final Object[] s(Object[] objArr, int i3) {
        return o(objArr) ? ArraysKt.copyInto(objArr, objArr, i3, 0, 32 - i3) : ArraysKt.copyInto(objArr, t(), i3, 0, 32 - i3);
    }

    private final Object[] t() {
        Object[] objArr = new Object[33];
        objArr[32] = this.f140713f;
        return objArr;
    }

    private final Object[] u(Object obj) {
        Object[] objArr = new Object[33];
        objArr[0] = obj;
        objArr[32] = this.f140713f;
        return objArr;
    }

    private final Object[] v(Object[] objArr, int i3, int i4) {
        if (i4 < 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (i4 == 0) {
            return objArr;
        }
        int iA = UtilsKt.a(i3, i4);
        Object obj = objArr[iA];
        if (obj == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
        }
        Object objV = v((Object[]) obj, i3, i4 - 5);
        if (iA < 31) {
            int i5 = iA + 1;
            if (objArr[i5] != null) {
                if (o(objArr)) {
                    ArraysKt.fill(objArr, (Object) null, i5, 32);
                }
                objArr = ArraysKt.copyInto(objArr, t(), 0, 0, i5);
            }
        }
        if (objV == objArr[iA]) {
            return objArr;
        }
        Object[] objArrQ = q(objArr);
        objArrQ[iA] = objV;
        return objArrQ;
    }

    private final Object[] w(Object[] objArr, int i3, int i4, ObjectRef objectRef) {
        Object[] objArrW;
        int iA = UtilsKt.a(i4 - 1, i3);
        if (i3 == 5) {
            objectRef.b(objArr[iA]);
            objArrW = null;
        } else {
            Object obj = objArr[iA];
            if (obj == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<kotlin.Any?>");
            }
            objArrW = w((Object[]) obj, i3 - 5, i4, objectRef);
        }
        if (objArrW == null && iA == 0) {
            return null;
        }
        Object[] objArrQ = q(objArr);
        objArrQ[iA] = objArrW;
        return objArrQ;
    }

    private final void x(Object[] objArr, int i3, int i4) {
        if (i4 == 0) {
            this.f140714g = null;
            if (objArr == null) {
                objArr = new Object[0];
            }
            this.f140715h = objArr;
            this.f140716i = i3;
            this.f140712d = i4;
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Intrinsics.checkNotNull(objArr);
        Object[] objArrW = w(objArr, i4, i3, objectRef);
        Intrinsics.checkNotNull(objArrW);
        Object objA = objectRef.a();
        if (objA == null) {
            throw new NullPointerException(lisODU.yCoWPPQvpIP);
        }
        this.f140715h = (Object[]) objA;
        this.f140716i = i3;
        if (objArrW[1] == null) {
            this.f140714g = (Object[]) objArrW[0];
            this.f140712d = i4 - 5;
        } else {
            this.f140714g = objArrW;
            this.f140712d = i4;
        }
    }

    private final Object[] y(Object[] objArr, int i3, int i4, Iterator it) {
        if (!it.hasNext()) {
            throw new IllegalStateException("Check failed.");
        }
        if (i4 < 0) {
            throw new IllegalStateException("Check failed.");
        }
        if (i4 == 0) {
            return (Object[]) it.next();
        }
        Object[] objArrQ = q(objArr);
        int iA = UtilsKt.a(i3, i4);
        int i5 = i4 - 5;
        objArrQ[iA] = y((Object[]) objArrQ[iA], i3, i5, it);
        while (true) {
            iA++;
            if (iA >= 32 || !it.hasNext()) {
                break;
            }
            objArrQ[iA] = y((Object[]) objArrQ[iA], 0, i5, it);
        }
        return objArrQ;
    }

    public final boolean I(Function1 predicate) {
        Intrinsics.checkNotNullParameter(predicate, "predicate");
        boolean zG = G(predicate);
        if (zG) {
            ((AbstractList) this).modCount++;
        }
        return zG;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean add(Object obj) {
        ((AbstractList) this).modCount++;
        int iR = R();
        if (iR < 32) {
            Object[] objArrQ = q(this.f140715h);
            objArrQ[iR] = obj;
            this.f140715h = objArrQ;
            this.f140716i = size() + 1;
        } else {
            B(this.f140714g, this.f140715h, u(obj));
        }
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean addAll(Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int iR = R();
        Iterator<E> it = elements.iterator();
        if (32 - iR >= elements.size()) {
            this.f140715h = b(q(this.f140715h), iR, it);
            this.f140716i = size() + elements.size();
        } else {
            int size = ((elements.size() + iR) - 1) / 32;
            Object[][] objArr = new Object[size][];
            objArr[0] = b(q(this.f140715h), iR, it);
            for (int i3 = 1; i3 < size; i3++) {
                objArr[i3] = b(t(), 0, it);
            }
            this.f140714g = A(this.f140714g, M(), objArr);
            this.f140715h = b(t(), 0, it);
            this.f140716i = size() + elements.size();
        }
        return true;
    }

    @Override // kotlinx.collections.immutable.PersistentList.Builder
    public PersistentList build() {
        PersistentList persistentVector;
        if (this.f140714g == this.f140710b && this.f140715h == this.f140711c) {
            persistentVector = this.f140709a;
        } else {
            this.f140713f = new MutabilityOwnership();
            Object[] objArr = this.f140714g;
            this.f140710b = objArr;
            Object[] objArr2 = this.f140715h;
            this.f140711c = objArr2;
            if (objArr != null) {
                Object[] objArr3 = this.f140714g;
                Intrinsics.checkNotNull(objArr3);
                persistentVector = new PersistentVector(objArr3, this.f140715h, size(), this.f140712d);
            } else if (objArr2.length == 0) {
                persistentVector = UtilsKt.b();
            } else {
                Object[] objArrCopyOf = Arrays.copyOf(this.f140715h, size());
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
                persistentVector = new SmallPersistentVector(objArrCopyOf);
            }
        }
        this.f140709a = persistentVector;
        return persistentVector;
    }

    public final int d() {
        return ((AbstractList) this).modCount;
    }

    public final Object[] e() {
        return this.f140714g;
    }

    public final int f() {
        return this.f140712d;
    }

    public final Object[] g() {
        return this.f140715h;
    }

    @Override // java.util.AbstractList, java.util.List
    public Object get(int i3) {
        ListImplementation.a(i3, size());
        return a(i3)[i3 & 31];
    }

    @Override // kotlin.collections.AbstractMutableList
    public int getSize() {
        return this.f140716i;
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator iterator() {
        return listIterator();
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator() {
        return listIterator(0);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public boolean removeAll(final Collection elements) {
        Intrinsics.checkNotNullParameter(elements, "elements");
        return I(new Function1<E, Boolean>() { // from class: kotlinx.collections.immutable.implementations.immutableList.PersistentVectorBuilder.removeAll.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj) {
                return Boolean.valueOf(elements.contains(obj));
            }
        });
    }

    @Override // kotlin.collections.AbstractMutableList
    public Object removeAt(int i3) {
        ListImplementation.a(i3, size());
        ((AbstractList) this).modCount++;
        int iM = M();
        if (i3 >= iM) {
            return K(this.f140714g, iM, this.f140712d, i3 - iM);
        }
        ObjectRef objectRef = new ObjectRef(this.f140715h[0]);
        Object[] objArr = this.f140714g;
        Intrinsics.checkNotNull(objArr);
        K(J(objArr, this.f140712d, i3, objectRef), iM, this.f140712d, 0);
        return objectRef.a();
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public Object set(int i3, Object obj) {
        ListImplementation.a(i3, size());
        if (M() > i3) {
            ObjectRef objectRef = new ObjectRef(null);
            Object[] objArr = this.f140714g;
            Intrinsics.checkNotNull(objArr);
            this.f140714g = N(objArr, this.f140712d, i3, obj, objectRef);
            return objectRef.a();
        }
        Object[] objArrQ = q(this.f140715h);
        if (objArrQ != this.f140715h) {
            ((AbstractList) this).modCount++;
        }
        int i4 = i3 & 31;
        Object obj2 = objArrQ[i4];
        objArrQ[i4] = obj;
        this.f140715h = objArrQ;
        return obj2;
    }

    @Override // java.util.AbstractList, java.util.List
    public ListIterator listIterator(int i3) {
        ListImplementation.b(i3, size());
        return new PersistentVectorMutableIterator(this, i3);
    }

    @Override // kotlin.collections.AbstractMutableList, java.util.AbstractList, java.util.List
    public void add(int i3, Object obj) {
        ListImplementation.b(i3, size());
        if (i3 == size()) {
            add(obj);
            return;
        }
        ((AbstractList) this).modCount++;
        int iM = M();
        if (i3 >= iM) {
            n(this.f140714g, i3 - iM, obj);
            return;
        }
        ObjectRef objectRef = new ObjectRef(null);
        Object[] objArr = this.f140714g;
        Intrinsics.checkNotNull(objArr);
        n(l(objArr, this.f140712d, i3, obj, objectRef), 0, objectRef.a());
    }

    @Override // java.util.AbstractList, java.util.List
    public boolean addAll(int i3, Collection elements) {
        PersistentVectorBuilder<E> persistentVectorBuilder;
        Collection collection;
        Object[] objArrCopyInto;
        Object[][] objArr;
        Intrinsics.checkNotNullParameter(elements, "elements");
        ListImplementation.b(i3, size());
        if (i3 == size()) {
            return addAll(elements);
        }
        if (elements.isEmpty()) {
            return false;
        }
        ((AbstractList) this).modCount++;
        int i4 = (i3 >> 5) << 5;
        int size = (((size() - i4) + elements.size()) - 1) / 32;
        if (size == 0) {
            CommonFunctionsKt.a(i3 >= M());
            int i5 = i3 & 31;
            int size2 = ((i3 + elements.size()) - 1) & 31;
            Object[] objArr2 = this.f140715h;
            Object[] objArrCopyInto2 = ArraysKt.copyInto(objArr2, q(objArr2), size2 + 1, i5, R());
            b(objArrCopyInto2, i5, elements.iterator());
            this.f140715h = objArrCopyInto2;
            this.f140716i = size() + elements.size();
            return true;
        }
        Object[][] objArr3 = new Object[size][];
        int iR = R();
        int iS = S(size() + elements.size());
        if (i3 >= M()) {
            objArrCopyInto = t();
            objArr = objArr3;
            persistentVectorBuilder = this;
            collection = elements;
            persistentVectorBuilder.Q(collection, i3, this.f140715h, iR, objArr, size, objArrCopyInto);
        } else {
            persistentVectorBuilder = this;
            collection = elements;
            if (iS > iR) {
                int i6 = iS - iR;
                Object[] objArrS = s(persistentVectorBuilder.f140715h, i6);
                persistentVectorBuilder.h(collection, i3, i6, objArr3, size, objArrS);
                objArr = objArr3;
                objArrCopyInto = objArrS;
            } else {
                int i7 = iR - iS;
                objArrCopyInto = ArraysKt.copyInto(persistentVectorBuilder.f140715h, t(), 0, i7, iR);
                int i8 = 32 - i7;
                Object[] objArrS2 = s(persistentVectorBuilder.f140715h, i8);
                int i9 = size - 1;
                objArr3[i9] = objArrS2;
                persistentVectorBuilder.h(collection, i3, i8, objArr3, i9, objArrS2);
                collection = collection;
                objArr = objArr3;
                persistentVectorBuilder = persistentVectorBuilder;
            }
        }
        persistentVectorBuilder.f140714g = A(persistentVectorBuilder.f140714g, i4, objArr);
        persistentVectorBuilder.f140715h = objArrCopyInto;
        persistentVectorBuilder.f140716i = size() + collection.size();
        return true;
    }
}
