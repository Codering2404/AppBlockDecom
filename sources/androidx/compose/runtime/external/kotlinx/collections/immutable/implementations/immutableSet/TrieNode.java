package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet;

import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

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
public final class TrieNode<E> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Companion f24512d = new Companion(null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final int f24513e = 8;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final TrieNode f24514f = new TrieNode(0, new Object[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24515a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private Object[] f24516b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private MutabilityOwnership f24517c;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrieNode a() {
            return TrieNode.f24514f;
        }

        private Companion() {
        }
    }

    public TrieNode(int i3, Object[] objArr, MutabilityOwnership mutabilityOwnership) {
        this.f24515a = i3;
        this.f24516b = objArr;
        this.f24517c = mutabilityOwnership;
    }

    private final TrieNode A(int i3, MutabilityOwnership mutabilityOwnership) {
        if (this.f24517c != mutabilityOwnership) {
            return new TrieNode(0, TrieNodeKt.e(this.f24516b, i3), mutabilityOwnership);
        }
        this.f24516b = TrieNodeKt.e(this.f24516b, i3);
        return this;
    }

    private final Object B(TrieNode trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.b(this.f24516b.length);
            return this;
        }
        Object[] objArr = Intrinsics.areEqual(mutabilityOwnership, this.f24517c) ? this.f24516b : new Object[Math.min(this.f24516b.length, trieNode.f24516b.length)];
        Object[] objArr2 = this.f24516b;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.a(i4 <= i3);
            if (trieNode.f(objArr2[i3])) {
                objArr[i4] = objArr2[i3];
                i4++;
                CommonFunctionsKt.a(i4 <= objArr.length);
            }
            i3++;
        }
        deltaCounter.b(i4);
        if (i4 == 0) {
            return f24514f;
        }
        if (i4 == 1) {
            return objArr[0];
        }
        if (i4 == this.f24516b.length) {
            return this;
        }
        if (i4 == trieNode.f24516b.length) {
            return trieNode;
        }
        if (i4 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, i4);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        return new TrieNode(0, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode C(int i3, int i4, Object obj, int i5, MutabilityOwnership mutabilityOwnership) {
        if (this.f24517c == mutabilityOwnership) {
            this.f24516b[i3] = r(i3, i4, obj, i5, mutabilityOwnership);
            return this;
        }
        Object[] objArr = this.f24516b;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i3] = r(i3, i4, obj, i5, mutabilityOwnership);
        return new TrieNode(this.f24515a, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode F(int i3, int i4, MutabilityOwnership mutabilityOwnership) {
        if (this.f24517c != mutabilityOwnership) {
            return new TrieNode(i4 ^ this.f24515a, TrieNodeKt.e(this.f24516b, i3), mutabilityOwnership);
        }
        this.f24516b = TrieNodeKt.e(this.f24516b, i3);
        this.f24515a ^= i4;
        return this;
    }

    private final TrieNode H(int i3, TrieNode trieNode, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = trieNode.f24516b;
        Object obj = trieNode;
        if (objArr.length == 1) {
            Object obj2 = objArr[0];
            obj = trieNode;
            if (!(obj2 instanceof TrieNode)) {
                if (this.f24516b.length == 1) {
                    trieNode.f24515a = this.f24515a;
                    return trieNode;
                }
                obj = obj2;
            }
        }
        if (this.f24517c == mutabilityOwnership) {
            this.f24516b[i3] = obj;
            return this;
        }
        Object[] objArr2 = this.f24516b;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i3] = obj;
        return new TrieNode(this.f24515a, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode I(int i3) {
        Object obj = this.f24516b[i3];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
        return (TrieNode) obj;
    }

    private final TrieNode K(int i3, int i4) {
        return new TrieNode(i4 ^ this.f24515a, TrieNodeKt.e(this.f24516b, i3));
    }

    private final TrieNode L(int i3, TrieNode trieNode) {
        Object[] objArr = trieNode.f24516b;
        Object obj = trieNode;
        if (objArr.length == 1) {
            Object obj2 = objArr[0];
            obj = trieNode;
            if (!(obj2 instanceof TrieNode)) {
                if (this.f24516b.length == 1) {
                    trieNode.f24515a = this.f24515a;
                    return trieNode;
                }
                obj = obj2;
            }
        }
        Object[] objArr2 = this.f24516b;
        Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i3] = obj;
        return new TrieNode(this.f24515a, objArrCopyOf);
    }

    private final TrieNode c(int i3, Object obj) {
        return new TrieNode(i3 | this.f24515a, TrieNodeKt.c(this.f24516b, p(i3), obj));
    }

    private final int d() {
        if (this.f24515a == 0) {
            return this.f24516b.length;
        }
        int iD = 0;
        for (Object obj : this.f24516b) {
            iD += obj instanceof TrieNode ? ((TrieNode) obj).d() : 1;
        }
        return iD;
    }

    private final TrieNode e(Object obj) {
        return f(obj) ? this : new TrieNode(0, TrieNodeKt.c(this.f24516b, 0, obj));
    }

    private final boolean f(Object obj) {
        return ArraysKt.contains(this.f24516b, obj);
    }

    private final TrieNode g(Object obj) {
        int iIndexOf = ArraysKt.indexOf(this.f24516b, obj);
        return iIndexOf != -1 ? h(iIndexOf) : this;
    }

    private final TrieNode h(int i3) {
        return new TrieNode(0, TrieNodeKt.e(this.f24516b, i3));
    }

    private final Object k(int i3) {
        return this.f24516b[i3];
    }

    private final boolean l(TrieNode trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.f24515a != trieNode.f24515a) {
            return false;
        }
        int length = this.f24516b.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f24516b[i3] != trieNode.f24516b[i3]) {
                return false;
            }
        }
        return true;
    }

    private final boolean o(int i3) {
        return (i3 & this.f24515a) == 0;
    }

    private final TrieNode q(int i3, Object obj, int i4, Object obj2, int i5, MutabilityOwnership mutabilityOwnership) {
        if (i5 > 30) {
            return new TrieNode(0, new Object[]{obj, obj2}, mutabilityOwnership);
        }
        int iD = TrieNodeKt.d(i3, i5);
        int iD2 = TrieNodeKt.d(i4, i5);
        if (iD != iD2) {
            return new TrieNode((1 << iD) | (1 << iD2), iD < iD2 ? new Object[]{obj, obj2} : new Object[]{obj2, obj}, mutabilityOwnership);
        }
        return new TrieNode(1 << iD, new Object[]{q(i3, obj, i4, obj2, i5 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode r(int i3, int i4, Object obj, int i5, MutabilityOwnership mutabilityOwnership) {
        Object objK = k(i3);
        return q(objK != null ? objK.hashCode() : 0, objK, i4, obj, i5 + 5, mutabilityOwnership);
    }

    private final TrieNode s(int i3, int i4, Object obj, int i5) {
        Object[] objArr = this.f24516b;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i3] = r(i3, i4, obj, i5, null);
        return new TrieNode(this.f24515a, objArrCopyOf);
    }

    private final TrieNode v(int i3, Object obj, MutabilityOwnership mutabilityOwnership) {
        int iP = p(i3);
        if (this.f24517c != mutabilityOwnership) {
            return new TrieNode(i3 | this.f24515a, TrieNodeKt.c(this.f24516b, iP, obj), mutabilityOwnership);
        }
        this.f24516b = TrieNodeKt.c(this.f24516b, iP, obj);
        this.f24515a = i3 | this.f24515a;
        return this;
    }

    private final TrieNode w(Object obj, PersistentHashSetBuilder persistentHashSetBuilder) {
        if (f(obj)) {
            return this;
        }
        persistentHashSetBuilder.f(persistentHashSetBuilder.size() + 1);
        if (this.f24517c != persistentHashSetBuilder.e()) {
            return new TrieNode(0, TrieNodeKt.c(this.f24516b, 0, obj), persistentHashSetBuilder.e());
        }
        this.f24516b = TrieNodeKt.c(this.f24516b, 0, obj);
        return this;
    }

    private final TrieNode x(TrieNode trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.b(this.f24516b.length);
            return this;
        }
        Object[] objArr = this.f24516b;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + trieNode.f24516b.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        Object[] objArr2 = trieNode.f24516b;
        int length = this.f24516b.length;
        int i3 = 0;
        int i4 = 0;
        while (i3 < objArr2.length) {
            CommonFunctionsKt.a(i4 <= i3);
            if (!f(objArr2[i3])) {
                objArrCopyOf[length + i4] = objArr2[i3];
                i4++;
                CommonFunctionsKt.a(length + i4 <= objArrCopyOf.length);
            }
            i3++;
        }
        int length2 = i4 + this.f24516b.length;
        deltaCounter.b(objArrCopyOf.length - length2);
        if (length2 == this.f24516b.length) {
            return this;
        }
        if (length2 == trieNode.f24516b.length) {
            return trieNode;
        }
        if (length2 != objArrCopyOf.length) {
            objArrCopyOf = Arrays.copyOf(objArrCopyOf, length2);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        }
        if (!Intrinsics.areEqual(this.f24517c, mutabilityOwnership)) {
            return new TrieNode(0, objArrCopyOf, mutabilityOwnership);
        }
        this.f24516b = objArrCopyOf;
        return this;
    }

    private final TrieNode y(Object obj, PersistentHashSetBuilder persistentHashSetBuilder) {
        int iIndexOf = ArraysKt.indexOf(this.f24516b, obj);
        if (iIndexOf == -1) {
            return this;
        }
        persistentHashSetBuilder.f(persistentHashSetBuilder.size() - 1);
        return A(iIndexOf, persistentHashSetBuilder.e());
    }

    private final Object z(TrieNode trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        if (this == trieNode) {
            deltaCounter.b(this.f24516b.length);
            return f24514f;
        }
        Object[] objArr = Intrinsics.areEqual(mutabilityOwnership, this.f24517c) ? this.f24516b : new Object[this.f24516b.length];
        Object[] objArr2 = this.f24516b;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= objArr2.length) {
                break;
            }
            CommonFunctionsKt.a(i4 <= i3);
            if (!trieNode.f(objArr2[i3])) {
                objArr[i4] = objArr2[i3];
                i4++;
                CommonFunctionsKt.a(i4 <= objArr.length);
            }
            i3++;
        }
        deltaCounter.b(this.f24516b.length - i4);
        if (i4 == 0) {
            return f24514f;
        }
        if (i4 == 1) {
            return objArr[0];
        }
        if (i4 == this.f24516b.length) {
            return this;
        }
        if (i4 == objArr.length) {
            return new TrieNode(0, objArr, mutabilityOwnership);
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, i4);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        return new TrieNode(0, objArrCopyOf, mutabilityOwnership);
    }

    public final TrieNode D(int i3, Object obj, int i4, PersistentHashSetBuilder persistentHashSetBuilder) {
        int iD = 1 << TrieNodeKt.d(i3, i4);
        if (!o(iD)) {
            int iP = p(iD);
            Object obj2 = this.f24516b[iP];
            if (obj2 instanceof TrieNode) {
                TrieNode trieNodeI = I(iP);
                TrieNode trieNodeY = i4 == 30 ? trieNodeI.y(obj, persistentHashSetBuilder) : trieNodeI.D(i3, obj, i4 + 5, persistentHashSetBuilder);
                if (this.f24517c == persistentHashSetBuilder.e() || trieNodeI != trieNodeY) {
                    return H(iP, trieNodeY, persistentHashSetBuilder.e());
                }
            } else if (Intrinsics.areEqual(obj, obj2)) {
                persistentHashSetBuilder.f(persistentHashSetBuilder.size() - 1);
                return F(iP, iD, persistentHashSetBuilder.e());
            }
        }
        return this;
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00b7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object E(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode r18, int r19, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter r20, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder r21) {
        /*
            Method dump skipped, instruction units count: 352
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode.E(androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode, int, androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter, androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.PersistentHashSetBuilder):java.lang.Object");
    }

    public final Object G(TrieNode trieNode, int i3, DeltaCounter deltaCounter, PersistentHashSetBuilder persistentHashSetBuilder) {
        if (this == trieNode) {
            deltaCounter.b(d());
            return this;
        }
        if (i3 > 30) {
            return B(trieNode, deltaCounter, persistentHashSetBuilder.e());
        }
        int i4 = this.f24515a & trieNode.f24515a;
        if (i4 == 0) {
            return f24514f;
        }
        TrieNode<E> trieNode2 = (Intrinsics.areEqual(this.f24517c, persistentHashSetBuilder.e()) && i4 == this.f24515a) ? this : new TrieNode<>(i4, new Object[Integer.bitCount(i4)], persistentHashSetBuilder.e());
        int i5 = i4;
        int i6 = 0;
        int i7 = 0;
        while (i5 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i5);
            int iP = p(iLowestOneBit);
            int iP2 = trieNode.p(iLowestOneBit);
            Object objG = this.f24516b[iP];
            Object obj = trieNode.f24516b[iP2];
            boolean z2 = objG instanceof TrieNode;
            boolean z3 = obj instanceof TrieNode;
            if (z2 && z3) {
                Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                objG = ((TrieNode) objG).G((TrieNode) obj, i3 + 5, deltaCounter, persistentHashSetBuilder);
            } else if (z2) {
                Intrinsics.checkNotNull(objG, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                if (((TrieNode) objG).i(obj != null ? obj.hashCode() : 0, obj, i3 + 5)) {
                    deltaCounter.b(1);
                    objG = obj;
                } else {
                    objG = f24514f;
                }
            } else if (z3) {
                Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                if (((TrieNode) obj).i(objG != null ? objG.hashCode() : 0, objG, i3 + 5)) {
                    deltaCounter.b(1);
                } else {
                    objG = f24514f;
                }
            } else if (Intrinsics.areEqual(objG, obj)) {
                deltaCounter.b(1);
            } else {
                objG = f24514f;
            }
            if (objG != f24514f) {
                i6 |= iLowestOneBit;
            }
            trieNode2.f24516b[i7] = objG;
            i7++;
            i5 ^= iLowestOneBit;
        }
        int iBitCount = Integer.bitCount(i6);
        if (i6 == 0) {
            return f24514f;
        }
        if (i6 == i4) {
            return trieNode2.l(this) ? this : trieNode2.l(trieNode) ? trieNode : trieNode2;
        }
        if (iBitCount == 1 && i3 != 0) {
            Object obj2 = trieNode2.f24516b[trieNode2.p(i6)];
            return obj2 instanceof TrieNode ? new TrieNode(i6, new Object[]{obj2}, persistentHashSetBuilder.e()) : obj2;
        }
        Object[] objArr = new Object[iBitCount];
        Object[] objArr2 = trieNode2.f24516b;
        int i8 = 0;
        int i9 = 0;
        while (i8 < objArr2.length) {
            CommonFunctionsKt.a(i9 <= i8);
            if (objArr2[i8] != f24512d.a()) {
                objArr[i9] = objArr2[i8];
                i9++;
                CommonFunctionsKt.a(i9 <= iBitCount);
            }
            i8++;
        }
        return new TrieNode(i6, objArr, persistentHashSetBuilder.e());
    }

    public final TrieNode J(int i3, Object obj, int i4) {
        int iD = 1 << TrieNodeKt.d(i3, i4);
        if (!o(iD)) {
            int iP = p(iD);
            Object obj2 = this.f24516b[iP];
            if (obj2 instanceof TrieNode) {
                TrieNode trieNodeI = I(iP);
                TrieNode trieNodeG = i4 == 30 ? trieNodeI.g(obj) : trieNodeI.J(i3, obj, i4 + 5);
                if (trieNodeI != trieNodeG) {
                    return L(iP, trieNodeG);
                }
            } else if (Intrinsics.areEqual(obj, obj2)) {
                return K(iP, iD);
            }
        }
        return this;
    }

    public final TrieNode b(int i3, Object obj, int i4) {
        int iD = 1 << TrieNodeKt.d(i3, i4);
        if (o(iD)) {
            return c(iD, obj);
        }
        int iP = p(iD);
        Object obj2 = this.f24516b[iP];
        if (obj2 instanceof TrieNode) {
            TrieNode trieNodeI = I(iP);
            TrieNode trieNodeE = i4 == 30 ? trieNodeI.e(obj) : trieNodeI.b(i3, obj, i4 + 5);
            if (trieNodeI != trieNodeE) {
                return L(iP, trieNodeE);
            }
        } else if (!Intrinsics.areEqual(obj, obj2)) {
            return s(iP, i3, obj, i4);
        }
        return this;
    }

    public final boolean i(int i3, Object obj, int i4) {
        int iD = 1 << TrieNodeKt.d(i3, i4);
        if (o(iD)) {
            return false;
        }
        int iP = p(iD);
        Object obj2 = this.f24516b[iP];
        if (!(obj2 instanceof TrieNode)) {
            return Intrinsics.areEqual(obj, obj2);
        }
        TrieNode trieNodeI = I(iP);
        return i4 == 30 ? trieNodeI.f(obj) : trieNodeI.i(i3, obj, i4 + 5);
    }

    public final boolean j(TrieNode trieNode, int i3) {
        if (this == trieNode) {
            return true;
        }
        if (i3 > 30) {
            for (Object obj : trieNode.f24516b) {
                if (!ArraysKt.contains(this.f24516b, obj)) {
                    return false;
                }
            }
            return true;
        }
        int i4 = this.f24515a;
        int i5 = trieNode.f24515a;
        int i6 = i4 & i5;
        if (i6 != i5) {
            return false;
        }
        while (i6 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i6);
            int iP = p(iLowestOneBit);
            int iP2 = trieNode.p(iLowestOneBit);
            Object obj2 = this.f24516b[iP];
            Object obj3 = trieNode.f24516b[iP2];
            boolean z2 = obj2 instanceof TrieNode;
            boolean z3 = obj3 instanceof TrieNode;
            if (z2 && z3) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                Intrinsics.checkNotNull(obj3, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                if (!((TrieNode) obj2).j((TrieNode) obj3, i3 + 5)) {
                    return false;
                }
            } else if (z2) {
                Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                if (!((TrieNode) obj2).i(obj3 != null ? obj3.hashCode() : 0, obj3, i3 + 5)) {
                    return false;
                }
            } else if (z3 || !Intrinsics.areEqual(obj2, obj3)) {
                return false;
            }
            i6 ^= iLowestOneBit;
        }
        return true;
    }

    public final int m() {
        return this.f24515a;
    }

    public final Object[] n() {
        return this.f24516b;
    }

    public final int p(int i3) {
        return Integer.bitCount((i3 - 1) & this.f24515a);
    }

    public final TrieNode t(int i3, Object obj, int i4, PersistentHashSetBuilder persistentHashSetBuilder) {
        int iD = 1 << TrieNodeKt.d(i3, i4);
        if (o(iD)) {
            persistentHashSetBuilder.f(persistentHashSetBuilder.size() + 1);
            return v(iD, obj, persistentHashSetBuilder.e());
        }
        int iP = p(iD);
        Object obj2 = this.f24516b[iP];
        if (obj2 instanceof TrieNode) {
            TrieNode trieNodeI = I(iP);
            TrieNode trieNodeW = i4 == 30 ? trieNodeI.w(obj, persistentHashSetBuilder) : trieNodeI.t(i3, obj, i4 + 5, persistentHashSetBuilder);
            if (trieNodeI != trieNodeW) {
                return H(iP, trieNodeW, persistentHashSetBuilder.e());
            }
        } else if (!Intrinsics.areEqual(obj, obj2)) {
            persistentHashSetBuilder.f(persistentHashSetBuilder.size() + 1);
            return C(iP, i3, obj, i4, persistentHashSetBuilder.e());
        }
        return this;
    }

    public final TrieNode u(TrieNode trieNode, int i3, DeltaCounter deltaCounter, PersistentHashSetBuilder persistentHashSetBuilder) {
        Object objQ;
        Object[] objArr;
        if (this == trieNode) {
            deltaCounter.c(deltaCounter.a() + d());
            return this;
        }
        if (i3 > 30) {
            return x(trieNode, deltaCounter, persistentHashSetBuilder.e());
        }
        int i4 = this.f24515a;
        int i5 = trieNode.f24515a | i4;
        TrieNode trieNode2 = (i5 == i4 && Intrinsics.areEqual(this.f24517c, persistentHashSetBuilder.e())) ? this : new TrieNode(i5, new Object[Integer.bitCount(i5)], persistentHashSetBuilder.e());
        int i6 = i5;
        int i7 = 0;
        while (i6 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i6);
            int iP = p(iLowestOneBit);
            int iP2 = trieNode.p(iLowestOneBit);
            Object[] objArr2 = trieNode2.f24516b;
            if (o(iLowestOneBit)) {
                objQ = trieNode.f24516b[iP2];
            } else if (trieNode.o(iLowestOneBit)) {
                objQ = this.f24516b[iP];
            } else {
                objQ = this.f24516b[iP];
                Object obj = trieNode.f24516b[iP2];
                boolean z2 = objQ instanceof TrieNode;
                boolean z3 = obj instanceof TrieNode;
                if (z2 && z3) {
                    Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                    objQ = ((TrieNode) objQ).u((TrieNode) obj, i3 + 5, deltaCounter, persistentHashSetBuilder);
                } else if (z2) {
                    Intrinsics.checkNotNull(objQ, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                    TrieNode trieNode3 = (TrieNode) objQ;
                    int size = persistentHashSetBuilder.size();
                    objQ = trieNode3.t(obj != null ? obj.hashCode() : 0, obj, i3 + 5, persistentHashSetBuilder);
                    if (persistentHashSetBuilder.size() == size) {
                        deltaCounter.c(deltaCounter.a() + 1);
                    }
                    Unit unit = Unit.f139807a;
                } else if (z3) {
                    Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode<E of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableSet.TrieNode>");
                    TrieNode trieNode4 = (TrieNode) obj;
                    int size2 = persistentHashSetBuilder.size();
                    objQ = trieNode4.t(objQ != null ? objQ.hashCode() : 0, objQ, i3 + 5, persistentHashSetBuilder);
                    if (persistentHashSetBuilder.size() == size2) {
                        deltaCounter.c(deltaCounter.a() + 1);
                    }
                    Unit unit2 = Unit.f139807a;
                } else if (Intrinsics.areEqual(objQ, obj)) {
                    deltaCounter.c(deltaCounter.a() + 1);
                    Unit unit3 = Unit.f139807a;
                } else {
                    objArr = objArr2;
                    objQ = q(objQ != null ? objQ.hashCode() : 0, objQ, obj != null ? obj.hashCode() : 0, obj, i3 + 5, persistentHashSetBuilder.e());
                    objArr[i7] = objQ;
                    i7++;
                    i6 ^= iLowestOneBit;
                }
            }
            objArr = objArr2;
            objArr[i7] = objQ;
            i7++;
            i6 ^= iLowestOneBit;
        }
        return l(trieNode2) ? this : trieNode.l(trieNode2) ? trieNode : trieNode2;
    }

    public TrieNode(int i3, Object[] objArr) {
        this(i3, objArr, null);
    }
}
