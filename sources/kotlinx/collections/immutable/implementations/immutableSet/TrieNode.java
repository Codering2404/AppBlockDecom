package kotlinx.collections.immutable.implementations.immutableSet;

import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.internal.CommonFunctionsKt;
import kotlinx.collections.immutable.internal.DeltaCounter;
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
public final class TrieNode<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f140793d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static final TrieNode f140794e = new TrieNode(0, new Object[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f140795a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f140796b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutabilityOwnership f140797c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrieNode a() {
            return TrieNode.f140794e;
        }

        private Companion() {
        }
    }

    public TrieNode(int i3, Object[] buffer, MutabilityOwnership mutabilityOwnership) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.f140795a = i3;
        this.f140796b = buffer;
        this.f140797c = mutabilityOwnership;
    }

    private final TrieNode B(int i3) {
        Object obj = this.f140796b[i3];
        if (obj != null) {
            return (TrieNode) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
    }

    private final TrieNode C(int i3, int i4, MutabilityOwnership mutabilityOwnership) {
        return E(i4 ^ this.f140795a, TrieNodeKt.e(this.f140796b, i3), mutabilityOwnership);
    }

    private final TrieNode D(int i3, Object obj, MutabilityOwnership mutabilityOwnership) {
        MutabilityOwnership mutabilityOwnership2 = this.f140797c;
        if (mutabilityOwnership2 != null && mutabilityOwnership2 == mutabilityOwnership) {
            this.f140796b[i3] = obj;
            return this;
        }
        Object[] objArr = this.f140796b;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i3] = obj;
        return new TrieNode(this.f140795a, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode E(int i3, Object[] objArr, MutabilityOwnership mutabilityOwnership) {
        MutabilityOwnership mutabilityOwnership2 = this.f140797c;
        if (mutabilityOwnership2 == null || mutabilityOwnership2 != mutabilityOwnership) {
            return new TrieNode(i3, objArr, mutabilityOwnership);
        }
        this.f140795a = i3;
        this.f140796b = objArr;
        return this;
    }

    private final TrieNode b(int i3, Object obj, MutabilityOwnership mutabilityOwnership) {
        return E(i3 | this.f140795a, TrieNodeKt.c(this.f140796b, n(i3), obj), mutabilityOwnership);
    }

    private final int c() {
        if (this.f140795a == 0) {
            return this.f140796b.length;
        }
        Object[] objArr = this.f140796b;
        int length = objArr.length;
        int i3 = 0;
        int iC = 0;
        while (i3 < length) {
            Object obj = objArr[i3];
            i3++;
            iC += obj instanceof TrieNode ? ((TrieNode) obj).c() : 1;
        }
        return iC;
    }

    private final TrieNode d(int i3, TrieNode trieNode, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = trieNode.f140796b;
        Object obj = trieNode;
        if (objArr.length == 1) {
            Object obj2 = objArr[0];
            obj = trieNode;
            if (!(obj2 instanceof TrieNode)) {
                if (this.f140796b.length == 1) {
                    trieNode.f140795a = this.f140795a;
                    return trieNode;
                }
                obj = obj2;
            }
        }
        return D(i3, obj, mutabilityOwnership);
    }

    private final boolean e(Object obj) {
        return ArraysKt.contains(this.f140796b, obj);
    }

    private final TrieNode f(int i3, MutabilityOwnership mutabilityOwnership) {
        return E(0, TrieNodeKt.e(this.f140796b, i3), mutabilityOwnership);
    }

    private final Object i(int i3) {
        return this.f140796b[i3];
    }

    private final boolean j(TrieNode trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.f140795a != trieNode.f140795a) {
            return false;
        }
        int length = this.f140796b.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (this.f140796b[i3] != trieNode.f140796b[i3]) {
                return false;
            }
            i3 = i4;
        }
        return true;
    }

    private final boolean m(int i3) {
        return (i3 & this.f140795a) == 0;
    }

    private final TrieNode o(int i3, Object obj, int i4, Object obj2, int i5, MutabilityOwnership mutabilityOwnership) {
        if (i5 > 30) {
            return new TrieNode(0, new Object[]{obj, obj2}, mutabilityOwnership);
        }
        int iD = TrieNodeKt.d(i3, i5);
        int iD2 = TrieNodeKt.d(i4, i5);
        if (iD != iD2) {
            return new TrieNode((1 << iD) | (1 << iD2), iD < iD2 ? new Object[]{obj, obj2} : new Object[]{obj2, obj}, mutabilityOwnership);
        }
        return new TrieNode(1 << iD, new Object[]{o(i3, obj, i4, obj2, i5 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode p(int i3, int i4, Object obj, int i5, MutabilityOwnership mutabilityOwnership) {
        Object objI = i(i3);
        return o(objI == null ? 0 : objI.hashCode(), objI, i4, obj, i5 + 5, mutabilityOwnership);
    }

    private final TrieNode q(int i3, int i4, Object obj, int i5, MutabilityOwnership mutabilityOwnership) {
        return D(i3, p(i3, i4, obj, i5, mutabilityOwnership), mutabilityOwnership);
    }

    private final TrieNode t(Object obj, PersistentHashSetBuilder persistentHashSetBuilder) {
        if (e(obj)) {
            return this;
        }
        persistentHashSetBuilder.f(persistentHashSetBuilder.size() + 1);
        return E(0, TrieNodeKt.c(this.f140796b, 0, obj), persistentHashSetBuilder.e());
    }

    private final TrieNode u(TrieNode trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.b(this.f140796b.length);
            return this;
        }
        Object[] objArr = this.f140796b;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + trieNode.f140796b.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        Object[] objArr2 = trieNode.f140796b;
        int length = this.f140796b.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < objArr2.length) {
            CommonFunctionsKt.a(i4 <= i3);
            if (!e(objArr2[i3])) {
                objArrCopyOf[length + i4] = objArr2[i3];
                i4++;
                CommonFunctionsKt.a(length + i4 <= objArrCopyOf.length);
            }
            i3++;
        }
        int length2 = i4 + this.f140796b.length;
        deltaCounter.b(objArrCopyOf.length - length2);
        if (length2 == this.f140796b.length) {
            return this;
        }
        if (length2 == trieNode.f140796b.length) {
            return trieNode;
        }
        if (length2 != objArrCopyOf.length) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, length2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        }
        return E(0, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode v(Object obj, PersistentHashSetBuilder persistentHashSetBuilder) {
        int iIndexOf = ArraysKt.indexOf(this.f140796b, obj);
        if (iIndexOf == -1) {
            return this;
        }
        persistentHashSetBuilder.f(persistentHashSetBuilder.size() - 1);
        return f(iIndexOf, persistentHashSetBuilder.e());
    }

    private final Object w(TrieNode trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.b(this.f140796b.length);
            return f140794e;
        }
        Object[] objArr = mutabilityOwnership == this.f140797c ? this.f140796b : new Object[this.f140796b.length];
        Object[] objArr2 = this.f140796b;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.a(i4 <= i3);
            if (!trieNode.e(objArr2[i3])) {
                objArr[i4] = objArr2[i3];
                i4++;
                CommonFunctionsKt.a(i4 <= objArr.length);
            }
            i3++;
        }
        deltaCounter.b(this.f140796b.length - i4);
        if (i4 == 0) {
            return f140794e;
        }
        if (i4 == 1) {
            return objArr[0];
        }
        if (i4 == this.f140796b.length) {
            return this;
        }
        if (i4 == objArr.length) {
            return E(0, objArr, mutabilityOwnership);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, i4);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        return E(0, objArrCopyOf, mutabilityOwnership);
    }

    private final Object x(TrieNode trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.b(this.f140796b.length);
            return this;
        }
        Object[] objArr = mutabilityOwnership == this.f140797c ? this.f140796b : new Object[Math.min(this.f140796b.length, trieNode.f140796b.length)];
        Object[] objArr2 = this.f140796b;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.a(i4 <= i3);
            if (trieNode.e(objArr2[i3])) {
                objArr[i4] = objArr2[i3];
                i4++;
                CommonFunctionsKt.a(i4 <= objArr.length);
            }
            i3++;
        }
        deltaCounter.b(i4);
        if (i4 == 0) {
            return f140794e;
        }
        if (i4 == 1) {
            return objArr[0];
        }
        if (i4 == this.f140796b.length) {
            return this;
        }
        if (i4 == trieNode.f140796b.length) {
            return trieNode;
        }
        if (i4 == objArr.length) {
            return E(0, objArr, mutabilityOwnership);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, i4);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        return E(0, objArrCopyOf, mutabilityOwnership);
    }

    public final Object A(TrieNode otherNode, int i3, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder mutator) {
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionSizeRef, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.b(c());
            return this;
        }
        if (i3 > 30) {
            return x(otherNode, intersectionSizeRef, mutator.e());
        }
        int i4 = this.f140795a & otherNode.f140795a;
        if (i4 == 0) {
            return f140794e;
        }
        TrieNode<E> trieNode = (Intrinsics.areEqual(this.f140797c, mutator.e()) && i4 == this.f140795a) ? this : new TrieNode<>(i4, new Object[Integer.bitCount(i4)], mutator.e());
        int i5 = i4;
        int i6 = 0;
        int i7 = 0;
        while (i5 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i5);
            int iN = n(iLowestOneBit);
            int iN2 = otherNode.n(iLowestOneBit);
            Object objA = l()[iN];
            Object obj = otherNode.l()[iN2];
            boolean z2 = objA instanceof TrieNode;
            boolean z3 = obj instanceof TrieNode;
            if (z2 && z3) {
                objA = ((TrieNode) objA).A((TrieNode) obj, i3 + 5, intersectionSizeRef, mutator);
            } else if (z2) {
                if (((TrieNode) objA).g(obj == null ? 0 : obj.hashCode(), obj, i3 + 5)) {
                    intersectionSizeRef.b(1);
                    objA = obj;
                } else {
                    objA = f140794e;
                }
            } else if (z3) {
                if (((TrieNode) obj).g(objA == null ? 0 : objA.hashCode(), objA, i3 + 5)) {
                    intersectionSizeRef.b(1);
                } else {
                    objA = f140794e;
                }
            } else if (Intrinsics.areEqual(objA, obj)) {
                intersectionSizeRef.b(1);
            } else {
                objA = f140794e;
            }
            if (objA != f140794e) {
                i6 |= iLowestOneBit;
            }
            trieNode.l()[i7] = objA;
            i7++;
            i5 ^= iLowestOneBit;
        }
        int iBitCount = Integer.bitCount(i6);
        if (i6 == 0) {
            return f140794e;
        }
        if (i6 == i4) {
            return trieNode.j(this) ? this : trieNode.j(otherNode) ? otherNode : trieNode;
        }
        if (iBitCount == 1 && i3 != 0) {
            Object obj2 = trieNode.f140796b[trieNode.n(i6)];
            return obj2 instanceof TrieNode ? new TrieNode(i6, new Object[]{obj2}, mutator.e()) : obj2;
        }
        Object[] objArr = new Object[iBitCount];
        Object[] objArr2 = trieNode.f140796b;
        int i8 = 0;
        int i9 = 0;
        while (i8 < objArr2.length) {
            CommonFunctionsKt.a(i9 <= i8);
            if (objArr2[i8] != f140793d.a()) {
                objArr[i9] = objArr2[i8];
                i9++;
                CommonFunctionsKt.a(i9 <= iBitCount);
            }
            i8++;
        }
        return new TrieNode(i6, objArr, mutator.e());
    }

    public final boolean g(int i3, Object obj, int i4) {
        int iD = 1 << TrieNodeKt.d(i3, i4);
        if (m(iD)) {
            return false;
        }
        int iN = n(iD);
        Object obj2 = this.f140796b[iN];
        if (!(obj2 instanceof TrieNode)) {
            return Intrinsics.areEqual(obj, obj2);
        }
        TrieNode trieNodeB = B(iN);
        return i4 == 30 ? trieNodeB.e(obj) : trieNodeB.g(i3, obj, i4 + 5);
    }

    public final boolean h(TrieNode otherNode, int i3) {
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        if (this == otherNode) {
            return true;
        }
        if (i3 > 30) {
            Object[] objArr = otherNode.f140796b;
            int length = objArr.length;
            int i4 = 0;
            while (i4 < length) {
                Object obj = objArr[i4];
                i4++;
                if (!ArraysKt.contains(l(), obj)) {
                    return false;
                }
            }
            return true;
        }
        int i5 = this.f140795a;
        int i6 = otherNode.f140795a;
        int i7 = i5 & i6;
        if (i7 != i6) {
            return false;
        }
        while (i7 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i7);
            int iN = n(iLowestOneBit);
            int iN2 = otherNode.n(iLowestOneBit);
            Object obj2 = l()[iN];
            Object obj3 = otherNode.l()[iN2];
            boolean z2 = obj2 instanceof TrieNode;
            boolean z3 = obj3 instanceof TrieNode;
            if (z2 && z3) {
                if (!((TrieNode) obj2).h((TrieNode) obj3, i3 + 5)) {
                    return false;
                }
            } else if (z2) {
                if (!((TrieNode) obj2).g(obj3 == null ? 0 : obj3.hashCode(), obj3, i3 + 5)) {
                    return false;
                }
            } else if (z3 || !Intrinsics.areEqual(obj2, obj3)) {
                return false;
            }
            i7 ^= iLowestOneBit;
        }
        return true;
    }

    public final int k() {
        return this.f140795a;
    }

    public final Object[] l() {
        return this.f140796b;
    }

    public final int n(int i3) {
        return Integer.bitCount((i3 - 1) & this.f140795a);
    }

    public final TrieNode r(int i3, Object obj, int i4, PersistentHashSetBuilder mutator) {
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int iD = 1 << TrieNodeKt.d(i3, i4);
        if (m(iD)) {
            mutator.f(mutator.size() + 1);
            return b(iD, obj, mutator.e());
        }
        int iN = n(iD);
        Object obj2 = this.f140796b[iN];
        if (obj2 instanceof TrieNode) {
            TrieNode trieNodeB = B(iN);
            TrieNode trieNodeT = i4 == 30 ? trieNodeB.t(obj, mutator) : trieNodeB.r(i3, obj, i4 + 5, mutator);
            if (trieNodeB != trieNodeT) {
                return D(iN, trieNodeT, mutator.e());
            }
        } else if (!Intrinsics.areEqual(obj, obj2)) {
            mutator.f(mutator.size() + 1);
            return q(iN, i3, obj, i4, mutator.e());
        }
        return this;
    }

    public final TrieNode s(TrieNode otherNode, int i3, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder mutator) {
        Object objO;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionSizeRef, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.c(intersectionSizeRef.a() + c());
            return this;
        }
        if (i3 > 30) {
            return u(otherNode, intersectionSizeRef, mutator.e());
        }
        int i4 = this.f140795a;
        int i5 = otherNode.f140795a | i4;
        TrieNode trieNode = (i5 == i4 && Intrinsics.areEqual(this.f140797c, mutator.e())) ? this : new TrieNode(i5, new Object[Integer.bitCount(i5)], mutator.e());
        int i6 = i5;
        int i7 = 0;
        while (i6 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i6);
            int iN = n(iLowestOneBit);
            int iN2 = otherNode.n(iLowestOneBit);
            Object[] objArrL = trieNode.l();
            if (m(iLowestOneBit)) {
                objO = otherNode.l()[iN2];
            } else if (otherNode.m(iLowestOneBit)) {
                objO = l()[iN];
            } else {
                objO = l()[iN];
                Object obj = otherNode.l()[iN2];
                boolean z2 = objO instanceof TrieNode;
                boolean z3 = obj instanceof TrieNode;
                if (z2 && z3) {
                    objO = ((TrieNode) objO).s((TrieNode) obj, i3 + 5, intersectionSizeRef, mutator);
                } else if (z2) {
                    TrieNode trieNode2 = (TrieNode) objO;
                    int size = mutator.size();
                    objO = trieNode2.r(obj == null ? 0 : obj.hashCode(), obj, i3 + 5, mutator);
                    if (mutator.size() == size) {
                        intersectionSizeRef.c(intersectionSizeRef.a() + 1);
                    }
                    Unit unit = Unit.f139807a;
                } else if (z3) {
                    TrieNode trieNode3 = (TrieNode) obj;
                    int size2 = mutator.size();
                    objO = trieNode3.r(objO == null ? 0 : objO.hashCode(), objO, i3 + 5, mutator);
                    if (mutator.size() == size2) {
                        intersectionSizeRef.c(intersectionSizeRef.a() + 1);
                    }
                    Unit unit2 = Unit.f139807a;
                } else if (Intrinsics.areEqual(objO, obj)) {
                    intersectionSizeRef.c(intersectionSizeRef.a() + 1);
                    Unit unit3 = Unit.f139807a;
                } else {
                    objO = o(objO == null ? 0 : objO.hashCode(), objO, obj == null ? 0 : obj.hashCode(), obj, i3 + 5, mutator.e());
                }
            }
            objArrL[i7] = objO;
            i7++;
            i6 ^= iLowestOneBit;
        }
        return j(trieNode) ? this : otherNode.j(trieNode) ? otherNode : trieNode;
    }

    public final TrieNode y(int i3, Object obj, int i4, PersistentHashSetBuilder mutator) {
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int iD = 1 << TrieNodeKt.d(i3, i4);
        if (!m(iD)) {
            int iN = n(iD);
            Object obj2 = this.f140796b[iN];
            if (obj2 instanceof TrieNode) {
                TrieNode trieNodeB = B(iN);
                TrieNode trieNodeV = i4 == 30 ? trieNodeB.v(obj, mutator) : trieNodeB.y(i3, obj, i4 + 5, mutator);
                if (trieNodeB.f140797c == mutator.e() || trieNodeB != trieNodeV) {
                    return d(iN, trieNodeV, mutator.e());
                }
            } else if (Intrinsics.areEqual(obj, obj2)) {
                mutator.f(mutator.size() - 1);
                return C(iN, iD, mutator.e());
            }
        }
        return this;
    }

    public final Object z(TrieNode otherNode, int i3, DeltaCounter intersectionSizeRef, PersistentHashSetBuilder mutator) {
        TrieNode<E> trieNode;
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionSizeRef, "intersectionSizeRef");
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionSizeRef.b(c());
            return f140794e;
        }
        if (i3 > 30) {
            return w(otherNode, intersectionSizeRef, mutator.e());
        }
        int i4 = this.f140795a & otherNode.f140795a;
        if (i4 != 0) {
            if (Intrinsics.areEqual(this.f140797c, mutator.e())) {
                trieNode = this;
            } else {
                int i5 = this.f140795a;
                Object[] objArr = this.f140796b;
                Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
                Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
                trieNode = new TrieNode<>(i5, objArrCopyOf, mutator.e());
            }
            int i6 = this.f140795a;
            while (i4 != 0) {
                int iLowestOneBit = Integer.lowestOneBit(i4);
                int iN = n(iLowestOneBit);
                int iN2 = otherNode.n(iLowestOneBit);
                Object objZ = l()[iN];
                Object obj = otherNode.l()[iN2];
                boolean z2 = objZ instanceof TrieNode;
                boolean z3 = obj instanceof TrieNode;
                if (z2 && z3) {
                    objZ = ((TrieNode) objZ).z((TrieNode) obj, i3 + 5, intersectionSizeRef, mutator);
                } else if (z2) {
                    TrieNode trieNode2 = (TrieNode) objZ;
                    int size = mutator.size();
                    TrieNode trieNodeY = trieNode2.y(obj == null ? 0 : obj.hashCode(), obj, i3 + 5, mutator);
                    if (size != mutator.size()) {
                        intersectionSizeRef.b(1);
                        objZ = (trieNodeY.l().length != 1 || (trieNodeY.l()[0] instanceof TrieNode)) ? trieNodeY : trieNodeY.l()[0];
                    }
                } else if (z3) {
                    if (((TrieNode) obj).g(objZ == null ? 0 : objZ.hashCode(), objZ, i3 + 5)) {
                        intersectionSizeRef.b(1);
                        objZ = f140794e;
                    }
                } else if (Intrinsics.areEqual(objZ, obj)) {
                    intersectionSizeRef.b(1);
                    objZ = f140794e;
                }
                if (objZ == f140794e) {
                    i6 ^= iLowestOneBit;
                }
                trieNode.l()[iN] = objZ;
                i4 ^= iLowestOneBit;
            }
            int iBitCount = Integer.bitCount(i6);
            if (i6 == 0) {
                return f140794e;
            }
            if (i6 != this.f140795a) {
                if (iBitCount == 1 && i3 != 0) {
                    Object obj2 = trieNode.f140796b[trieNode.n(i6)];
                    return obj2 instanceof TrieNode ? new TrieNode(i6, new Object[]{obj2}, mutator.e()) : obj2;
                }
                Object[] objArr2 = new Object[iBitCount];
                Object[] objArr3 = trieNode.f140796b;
                int i7 = 0;
                int i8 = 0;
                while (i7 < objArr3.length) {
                    CommonFunctionsKt.a(i8 <= i7);
                    if (objArr3[i7] != f140793d.a()) {
                        objArr2[i8] = objArr3[i7];
                        i8++;
                        CommonFunctionsKt.a(i8 <= iBitCount);
                    }
                    i7++;
                }
                return new TrieNode(i6, objArr2, mutator.e());
            }
            if (!trieNode.j(this)) {
                return trieNode;
            }
        }
        return this;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrieNode(int i3, Object[] buffer) {
        this(i3, buffer, null);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }
}
