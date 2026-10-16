package androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap;

import androidx.compose.runtime.PreconditionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.CommonFunctionsKt;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.DeltaCounter;
import androidx.compose.runtime.external.kotlinx.collections.immutable.internal.MutabilityOwnership;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
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
public final class TrieNode<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f24482e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final int f24483f = 8;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private static final TrieNode f24484g = new TrieNode(0, 0, new Object[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24485a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f24486b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutabilityOwnership f24487c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f24488d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrieNode a() {
            return TrieNode.f24484g;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ModificationResult<K, V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private TrieNode f24489a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final int f24490b;

        public ModificationResult(TrieNode trieNode, int i3) {
            this.f24489a = trieNode;
            this.f24490b = i3;
        }

        public final TrieNode a() {
            return this.f24489a;
        }

        public final int b() {
            return this.f24490b;
        }

        public final void c(TrieNode trieNode) {
            this.f24489a = trieNode;
        }
    }

    public TrieNode(int i3, int i4, Object[] objArr, MutabilityOwnership mutabilityOwnership) {
        this.f24485a = i3;
        this.f24486b = i4;
        this.f24487c = mutabilityOwnership;
        this.f24488d = objArr;
    }

    private final TrieNode A(int i3, PersistentHashMapBuilder persistentHashMapBuilder) {
        persistentHashMapBuilder.h(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.f(W(i3));
        if (this.f24488d.length == 2) {
            return null;
        }
        if (this.f24487c != persistentHashMapBuilder.d()) {
            return new TrieNode(0, 0, TrieNodeKt.h(this.f24488d, i3), persistentHashMapBuilder.d());
        }
        this.f24488d = TrieNodeKt.h(this.f24488d, i3);
        return this;
    }

    private final TrieNode B(int i3, Object obj, Object obj2, MutabilityOwnership mutabilityOwnership) {
        int iN = n(i3);
        if (this.f24487c != mutabilityOwnership) {
            return new TrieNode(i3 | this.f24485a, this.f24486b, TrieNodeKt.g(this.f24488d, iN, obj, obj2), mutabilityOwnership);
        }
        this.f24488d = TrieNodeKt.g(this.f24488d, iN, obj, obj2);
        this.f24485a = i3 | this.f24485a;
        return this;
    }

    private final TrieNode C(int i3, int i4, int i5, Object obj, Object obj2, int i6, MutabilityOwnership mutabilityOwnership) {
        if (this.f24487c != mutabilityOwnership) {
            return new TrieNode(this.f24485a ^ i4, i4 | this.f24486b, d(i3, i4, i5, obj, obj2, i6, mutabilityOwnership), mutabilityOwnership);
        }
        this.f24488d = d(i3, i4, i5, obj, obj2, i6, mutabilityOwnership);
        this.f24485a ^= i4;
        this.f24486b |= i4;
        return this;
    }

    private final TrieNode F(TrieNode trieNode, int i3, int i4, DeltaCounter deltaCounter, PersistentHashMapBuilder persistentHashMapBuilder) {
        if (r(i3)) {
            TrieNode trieNodeN = N(O(i3));
            if (trieNode.r(i3)) {
                return trieNodeN.E(trieNode.N(trieNode.O(i3)), i4 + 5, deltaCounter, persistentHashMapBuilder);
            }
            if (!trieNode.q(i3)) {
                return trieNodeN;
            }
            int iN = trieNode.n(i3);
            Object objT = trieNode.t(iN);
            Object objW = trieNode.W(iN);
            int size = persistentHashMapBuilder.size();
            TrieNode trieNodeD = trieNodeN.D(objT != null ? objT.hashCode() : 0, objT, objW, i4 + 5, persistentHashMapBuilder);
            if (persistentHashMapBuilder.size() == size) {
                deltaCounter.c(deltaCounter.a() + 1);
            }
            return trieNodeD;
        }
        if (!trieNode.r(i3)) {
            int iN2 = n(i3);
            Object objT2 = t(iN2);
            Object objW2 = W(iN2);
            int iN3 = trieNode.n(i3);
            Object objT3 = trieNode.t(iN3);
            return u(objT2 != null ? objT2.hashCode() : 0, objT2, objW2, objT3 != null ? objT3.hashCode() : 0, objT3, trieNode.W(iN3), i4 + 5, persistentHashMapBuilder.d());
        }
        TrieNode trieNodeN2 = trieNode.N(trieNode.O(i3));
        if (!q(i3)) {
            return trieNodeN2;
        }
        int iN4 = n(i3);
        Object objT4 = t(iN4);
        int i5 = i4 + 5;
        if (!trieNodeN2.k(objT4 != null ? objT4.hashCode() : 0, objT4, i5)) {
            return trieNodeN2.D(objT4 != null ? objT4.hashCode() : 0, objT4, W(iN4), i5, persistentHashMapBuilder);
        }
        deltaCounter.c(deltaCounter.a() + 1);
        return trieNodeN2;
    }

    private final TrieNode I(int i3, int i4, PersistentHashMapBuilder persistentHashMapBuilder) {
        persistentHashMapBuilder.h(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.f(W(i3));
        if (this.f24488d.length == 2) {
            return null;
        }
        if (this.f24487c != persistentHashMapBuilder.d()) {
            return new TrieNode(i4 ^ this.f24485a, this.f24486b, TrieNodeKt.h(this.f24488d, i3), persistentHashMapBuilder.d());
        }
        this.f24488d = TrieNodeKt.h(this.f24488d, i3);
        this.f24485a ^= i4;
        return this;
    }

    private final TrieNode J(int i3, int i4, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.f24488d;
        if (objArr.length == 1) {
            return null;
        }
        if (this.f24487c != mutabilityOwnership) {
            return new TrieNode(this.f24485a, i4 ^ this.f24486b, TrieNodeKt.i(objArr, i3), mutabilityOwnership);
        }
        this.f24488d = TrieNodeKt.i(objArr, i3);
        this.f24486b ^= i4;
        return this;
    }

    private final TrieNode K(TrieNode trieNode, TrieNode trieNode2, int i3, int i4, MutabilityOwnership mutabilityOwnership) {
        return trieNode2 == null ? J(i3, i4, mutabilityOwnership) : (this.f24487c == mutabilityOwnership || trieNode != trieNode2) ? L(i3, trieNode2, mutabilityOwnership) : this;
    }

    private final TrieNode L(int i3, TrieNode trieNode, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.f24488d;
        if (objArr.length == 1 && trieNode.f24488d.length == 2 && trieNode.f24486b == 0) {
            trieNode.f24485a = this.f24486b;
            return trieNode;
        }
        if (this.f24487c == mutabilityOwnership) {
            objArr[i3] = trieNode;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i3] = trieNode;
        return new TrieNode(this.f24485a, this.f24486b, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode M(int i3, Object obj, PersistentHashMapBuilder persistentHashMapBuilder) {
        if (this.f24487c == persistentHashMapBuilder.d()) {
            this.f24488d[i3 + 1] = obj;
            return this;
        }
        persistentHashMapBuilder.e(persistentHashMapBuilder.b() + 1);
        Object[] objArr = this.f24488d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i3 + 1] = obj;
        return new TrieNode(this.f24485a, this.f24486b, objArrCopyOf, persistentHashMapBuilder.d());
    }

    private final TrieNode R(int i3, int i4) {
        Object[] objArr = this.f24488d;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode(i4 ^ this.f24485a, this.f24486b, TrieNodeKt.h(objArr, i3));
    }

    private final TrieNode S(int i3, int i4) {
        Object[] objArr = this.f24488d;
        if (objArr.length == 1) {
            return null;
        }
        return new TrieNode(this.f24485a, i4 ^ this.f24486b, TrieNodeKt.i(objArr, i3));
    }

    private final TrieNode T(TrieNode trieNode, TrieNode trieNode2, int i3, int i4) {
        return trieNode2 == null ? S(i3, i4) : trieNode != trieNode2 ? U(i3, i4, trieNode2) : this;
    }

    private final TrieNode U(int i3, int i4, TrieNode trieNode) {
        Object[] objArr = trieNode.f24488d;
        if (objArr.length != 2 || trieNode.f24486b != 0) {
            Object[] objArr2 = this.f24488d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr2, objArr2.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[i3] = trieNode;
            return new TrieNode(this.f24485a, this.f24486b, objArrCopyOf);
        }
        if (this.f24488d.length == 1) {
            trieNode.f24485a = this.f24486b;
            return trieNode;
        }
        return new TrieNode(this.f24485a ^ i4, i4 ^ this.f24486b, TrieNodeKt.k(this.f24488d, i3, n(i4), objArr[0], objArr[1]));
    }

    private final TrieNode V(int i3, Object obj) {
        Object[] objArr = this.f24488d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        objArrCopyOf[i3 + 1] = obj;
        return new TrieNode(this.f24485a, this.f24486b, objArrCopyOf);
    }

    private final Object W(int i3) {
        return this.f24488d[i3 + 1];
    }

    private final ModificationResult b() {
        return new ModificationResult(this, 1);
    }

    private final ModificationResult c() {
        return new ModificationResult(this, 0);
    }

    private final Object[] d(int i3, int i4, int i5, Object obj, Object obj2, int i6, MutabilityOwnership mutabilityOwnership) {
        Object objT = t(i3);
        return TrieNodeKt.j(this.f24488d, i3, O(i4) + 1, u(objT != null ? objT.hashCode() : 0, objT, W(i3), i5, obj, obj2, i6 + 5, mutabilityOwnership));
    }

    private final int e() {
        if (this.f24486b == 0) {
            return this.f24488d.length / 2;
        }
        int iBitCount = Integer.bitCount(this.f24485a);
        int length = this.f24488d.length;
        for (int i3 = iBitCount * 2; i3 < length; i3++) {
            iBitCount += N(i3).e();
        }
        return iBitCount;
    }

    private final boolean f(Object obj) {
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, this.f24488d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (!Intrinsics.areEqual(obj, this.f24488d[iG])) {
                if (iG != iH) {
                    iG += iL;
                }
            }
            return true;
        }
        return false;
    }

    private final Object g(Object obj) {
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, this.f24488d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL <= 0 || iG > iH) && (iL >= 0 || iH > iG)) {
            return null;
        }
        while (!Intrinsics.areEqual(obj, t(iG))) {
            if (iG == iH) {
                return null;
            }
            iG += iL;
        }
        return W(iG);
    }

    private final ModificationResult h(Object obj, Object obj2) {
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, this.f24488d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (!Intrinsics.areEqual(obj, t(iG))) {
                if (iG != iH) {
                    iG += iL;
                }
            }
            if (obj2 == W(iG)) {
                return null;
            }
            Object[] objArr = this.f24488d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[iG + 1] = obj2;
            return new TrieNode(0, 0, objArrCopyOf).c();
        }
        return new TrieNode(0, 0, TrieNodeKt.g(this.f24488d, 0, obj, obj2)).b();
    }

    private final TrieNode i(Object obj) {
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, this.f24488d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (!Intrinsics.areEqual(obj, t(iG))) {
                if (iG != iH) {
                    iG += iL;
                }
            }
            return j(iG);
        }
        return this;
    }

    private final TrieNode j(int i3) {
        Object[] objArr = this.f24488d;
        if (objArr.length == 2) {
            return null;
        }
        return new TrieNode(0, 0, TrieNodeKt.h(objArr, i3));
    }

    private final boolean l(TrieNode trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.f24486b != trieNode.f24486b || this.f24485a != trieNode.f24485a) {
            return false;
        }
        int length = this.f24488d.length;
        for (int i3 = 0; i3 < length; i3++) {
            if (this.f24488d[i3] != trieNode.f24488d[i3]) {
                return false;
            }
        }
        return true;
    }

    private final boolean r(int i3) {
        return (i3 & this.f24486b) != 0;
    }

    private final TrieNode s(int i3, Object obj, Object obj2) {
        return new TrieNode(i3 | this.f24485a, this.f24486b, TrieNodeKt.g(this.f24488d, n(i3), obj, obj2));
    }

    private final Object t(int i3) {
        return this.f24488d[i3];
    }

    private final TrieNode u(int i3, Object obj, Object obj2, int i4, Object obj3, Object obj4, int i5, MutabilityOwnership mutabilityOwnership) {
        if (i5 > 30) {
            return new TrieNode(0, 0, new Object[]{obj, obj2, obj3, obj4}, mutabilityOwnership);
        }
        int iF = TrieNodeKt.f(i3, i5);
        int iF2 = TrieNodeKt.f(i4, i5);
        if (iF != iF2) {
            return new TrieNode((1 << iF) | (1 << iF2), 0, iF < iF2 ? new Object[]{obj, obj2, obj3, obj4} : new Object[]{obj3, obj4, obj, obj2}, mutabilityOwnership);
        }
        return new TrieNode(0, 1 << iF, new Object[]{u(i3, obj, obj2, i4, obj3, obj4, i5 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode v(int i3, int i4, int i5, Object obj, Object obj2, int i6) {
        return new TrieNode(this.f24485a ^ i4, this.f24486b | i4, d(i3, i4, i5, obj, obj2, i6, null));
    }

    private final TrieNode w(Object obj, Object obj2, PersistentHashMapBuilder persistentHashMapBuilder) {
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, this.f24488d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (!Intrinsics.areEqual(obj, t(iG))) {
                if (iG != iH) {
                    iG += iL;
                }
            }
            persistentHashMapBuilder.f(W(iG));
            if (this.f24487c == persistentHashMapBuilder.d()) {
                this.f24488d[iG + 1] = obj2;
                return this;
            }
            persistentHashMapBuilder.e(persistentHashMapBuilder.b() + 1);
            Object[] objArr = this.f24488d;
            Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
            Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
            objArrCopyOf[iG + 1] = obj2;
            return new TrieNode(0, 0, objArrCopyOf, persistentHashMapBuilder.d());
        }
        persistentHashMapBuilder.h(persistentHashMapBuilder.size() + 1);
        return new TrieNode(0, 0, TrieNodeKt.g(this.f24488d, 0, obj, obj2), persistentHashMapBuilder.d());
    }

    private final TrieNode x(TrieNode trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        CommonFunctionsKt.a(this.f24486b == 0);
        CommonFunctionsKt.a(this.f24485a == 0);
        CommonFunctionsKt.a(trieNode.f24486b == 0);
        CommonFunctionsKt.a(trieNode.f24485a == 0);
        Object[] objArr = this.f24488d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + trieNode.f24488d.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(...)");
        int length = this.f24488d.length;
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, trieNode.f24488d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (true) {
                if (f(trieNode.f24488d[iG])) {
                    deltaCounter.c(deltaCounter.a() + 1);
                } else {
                    Object[] objArr2 = trieNode.f24488d;
                    objArrCopyOf[length] = objArr2[iG];
                    objArrCopyOf[length + 1] = objArr2[iG + 1];
                    length += 2;
                }
                if (iG == iH) {
                    break;
                }
                iG += iL;
            }
        }
        if (length == this.f24488d.length) {
            return this;
        }
        if (length == trieNode.f24488d.length) {
            return trieNode;
        }
        if (length == objArrCopyOf.length) {
            return new TrieNode(0, 0, objArrCopyOf, mutabilityOwnership);
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(...)");
        return new TrieNode(0, 0, objArrCopyOf2, mutabilityOwnership);
    }

    private final TrieNode y(Object obj, PersistentHashMapBuilder persistentHashMapBuilder) {
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, this.f24488d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (!Intrinsics.areEqual(obj, t(iG))) {
                if (iG != iH) {
                    iG += iL;
                }
            }
            return A(iG, persistentHashMapBuilder);
        }
        return this;
    }

    private final TrieNode z(Object obj, Object obj2, PersistentHashMapBuilder persistentHashMapBuilder) {
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, this.f24488d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (true) {
                if (!Intrinsics.areEqual(obj, t(iG)) || !Intrinsics.areEqual(obj2, W(iG))) {
                    if (iG == iH) {
                        break;
                    }
                    iG += iL;
                } else {
                    return A(iG, persistentHashMapBuilder);
                }
            }
        }
        return this;
    }

    public final TrieNode D(int i3, Object obj, Object obj2, int i4, PersistentHashMapBuilder persistentHashMapBuilder) {
        PersistentHashMapBuilder persistentHashMapBuilder2;
        TrieNode trieNodeD;
        int iF = 1 << TrieNodeKt.f(i3, i4);
        if (q(iF)) {
            int iN = n(iF);
            if (Intrinsics.areEqual(obj, t(iN))) {
                persistentHashMapBuilder.f(W(iN));
                return W(iN) == obj2 ? this : M(iN, obj2, persistentHashMapBuilder);
            }
            persistentHashMapBuilder.h(persistentHashMapBuilder.size() + 1);
            return C(iN, iF, i3, obj, obj2, i4, persistentHashMapBuilder.d());
        }
        if (!r(iF)) {
            persistentHashMapBuilder.h(persistentHashMapBuilder.size() + 1);
            return B(iF, obj, obj2, persistentHashMapBuilder.d());
        }
        int iO = O(iF);
        TrieNode trieNodeN = N(iO);
        if (i4 == 30) {
            trieNodeD = trieNodeN.w(obj, obj2, persistentHashMapBuilder);
            persistentHashMapBuilder2 = persistentHashMapBuilder;
        } else {
            persistentHashMapBuilder2 = persistentHashMapBuilder;
            trieNodeD = trieNodeN.D(i3, obj, obj2, i4 + 5, persistentHashMapBuilder2);
        }
        return trieNodeN == trieNodeD ? this : L(iO, trieNodeD, persistentHashMapBuilder2.d());
    }

    public final TrieNode E(TrieNode trieNode, int i3, DeltaCounter deltaCounter, PersistentHashMapBuilder persistentHashMapBuilder) {
        if (this == trieNode) {
            deltaCounter.b(e());
            return this;
        }
        int i4 = i3;
        if (i4 > 30) {
            return x(trieNode, deltaCounter, persistentHashMapBuilder.d());
        }
        int i5 = this.f24486b | trieNode.f24486b;
        int i6 = this.f24485a;
        int i7 = trieNode.f24485a;
        int i8 = (i6 ^ i7) & (~i5);
        int i9 = i6 & i7;
        while (i9 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i9);
            if (Intrinsics.areEqual(t(n(iLowestOneBit)), trieNode.t(trieNode.n(iLowestOneBit)))) {
                i8 |= iLowestOneBit;
            } else {
                i5 |= iLowestOneBit;
            }
            i9 ^= iLowestOneBit;
        }
        int i10 = 0;
        if (!((i5 & i8) == 0)) {
            PreconditionsKt.b("Check failed.");
        }
        TrieNode trieNode2 = (Intrinsics.areEqual(this.f24487c, persistentHashMapBuilder.d()) && this.f24485a == i8 && this.f24486b == i5) ? this : new TrieNode(i8, i5, new Object[(Integer.bitCount(i8) * 2) + Integer.bitCount(i5)]);
        int i11 = i5;
        int i12 = 0;
        while (i11 != 0) {
            int iLowestOneBit2 = Integer.lowestOneBit(i11);
            Object[] objArr = trieNode2.f24488d;
            objArr[(objArr.length - 1) - i12] = F(trieNode, iLowestOneBit2, i4, deltaCounter, persistentHashMapBuilder);
            i12++;
            i11 ^= iLowestOneBit2;
            i4 = i3;
        }
        while (i8 != 0) {
            int iLowestOneBit3 = Integer.lowestOneBit(i8);
            int i13 = i10 * 2;
            if (trieNode.q(iLowestOneBit3)) {
                int iN = trieNode.n(iLowestOneBit3);
                trieNode2.f24488d[i13] = trieNode.t(iN);
                trieNode2.f24488d[i13 + 1] = trieNode.W(iN);
                if (q(iLowestOneBit3)) {
                    deltaCounter.c(deltaCounter.a() + 1);
                }
            } else {
                int iN2 = n(iLowestOneBit3);
                trieNode2.f24488d[i13] = t(iN2);
                trieNode2.f24488d[i13 + 1] = W(iN2);
            }
            i10++;
            i8 ^= iLowestOneBit3;
        }
        return l(trieNode2) ? this : trieNode.l(trieNode2) ? trieNode : trieNode2;
    }

    public final TrieNode G(int i3, Object obj, int i4, PersistentHashMapBuilder persistentHashMapBuilder) {
        int iF = 1 << TrieNodeKt.f(i3, i4);
        if (q(iF)) {
            int iN = n(iF);
            if (Intrinsics.areEqual(obj, t(iN))) {
                return I(iN, iF, persistentHashMapBuilder);
            }
        } else if (r(iF)) {
            int iO = O(iF);
            TrieNode trieNodeN = N(iO);
            return K(trieNodeN, i4 == 30 ? trieNodeN.y(obj, persistentHashMapBuilder) : trieNodeN.G(i3, obj, i4 + 5, persistentHashMapBuilder), iO, iF, persistentHashMapBuilder.d());
        }
        return this;
    }

    public final TrieNode H(int i3, Object obj, Object obj2, int i4, PersistentHashMapBuilder persistentHashMapBuilder) {
        int iF = 1 << TrieNodeKt.f(i3, i4);
        if (q(iF)) {
            int iN = n(iF);
            if (Intrinsics.areEqual(obj, t(iN)) && Intrinsics.areEqual(obj2, W(iN))) {
                return I(iN, iF, persistentHashMapBuilder);
            }
        } else if (r(iF)) {
            int iO = O(iF);
            TrieNode trieNodeN = N(iO);
            return K(trieNodeN, i4 == 30 ? trieNodeN.z(obj, obj2, persistentHashMapBuilder) : trieNodeN.H(i3, obj, obj2, i4 + 5, persistentHashMapBuilder), iO, iF, persistentHashMapBuilder.d());
        }
        return this;
    }

    public final TrieNode N(int i3) {
        Object obj = this.f24488d[i3];
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of androidx.compose.runtime.external.kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
        return (TrieNode) obj;
    }

    public final int O(int i3) {
        return (this.f24488d.length - 1) - Integer.bitCount((i3 - 1) & this.f24486b);
    }

    public final ModificationResult P(int i3, Object obj, Object obj2, int i4) {
        ModificationResult modificationResultP;
        int iF = 1 << TrieNodeKt.f(i3, i4);
        if (q(iF)) {
            int iN = n(iF);
            if (!Intrinsics.areEqual(obj, t(iN))) {
                return v(iN, iF, i3, obj, obj2, i4).b();
            }
            if (W(iN) == obj2) {
                return null;
            }
            return V(iN, obj2).c();
        }
        if (!r(iF)) {
            return s(iF, obj, obj2).b();
        }
        int iO = O(iF);
        TrieNode trieNodeN = N(iO);
        if (i4 == 30) {
            modificationResultP = trieNodeN.h(obj, obj2);
            if (modificationResultP == null) {
                return null;
            }
        } else {
            modificationResultP = trieNodeN.P(i3, obj, obj2, i4 + 5);
            if (modificationResultP == null) {
                return null;
            }
        }
        modificationResultP.c(U(iO, iF, modificationResultP.a()));
        return modificationResultP;
    }

    public final TrieNode Q(int i3, Object obj, int i4) {
        int iF = 1 << TrieNodeKt.f(i3, i4);
        if (q(iF)) {
            int iN = n(iF);
            if (Intrinsics.areEqual(obj, t(iN))) {
                return R(iN, iF);
            }
        } else if (r(iF)) {
            int iO = O(iF);
            TrieNode trieNodeN = N(iO);
            return T(trieNodeN, i4 == 30 ? trieNodeN.i(obj) : trieNodeN.Q(i3, obj, i4 + 5), iO, iF);
        }
        return this;
    }

    public final boolean k(int i3, Object obj, int i4) {
        int iF = 1 << TrieNodeKt.f(i3, i4);
        if (q(iF)) {
            return Intrinsics.areEqual(obj, t(n(iF)));
        }
        if (!r(iF)) {
            return false;
        }
        TrieNode trieNodeN = N(O(iF));
        return i4 == 30 ? trieNodeN.f(obj) : trieNodeN.k(i3, obj, i4 + 5);
    }

    public final int m() {
        return Integer.bitCount(this.f24485a);
    }

    public final int n(int i3) {
        return Integer.bitCount((i3 - 1) & this.f24485a) * 2;
    }

    public final Object o(int i3, Object obj, int i4) {
        int iF = 1 << TrieNodeKt.f(i3, i4);
        if (q(iF)) {
            int iN = n(iF);
            if (Intrinsics.areEqual(obj, t(iN))) {
                return W(iN);
            }
            return null;
        }
        if (!r(iF)) {
            return null;
        }
        TrieNode trieNodeN = N(O(iF));
        return i4 == 30 ? trieNodeN.g(obj) : trieNodeN.o(i3, obj, i4 + 5);
    }

    public final Object[] p() {
        return this.f24488d;
    }

    public final boolean q(int i3) {
        return (i3 & this.f24485a) != 0;
    }

    public TrieNode(int i3, int i4, Object[] objArr) {
        this(i3, i4, objArr, null);
    }
}
