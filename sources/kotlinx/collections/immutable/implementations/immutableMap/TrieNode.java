package kotlinx.collections.immutable.implementations.immutableMap;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.RangesKt;
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
public final class TrieNode<K, V> {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Companion f140767e = new Companion(null);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static final TrieNode f140768f = new TrieNode(0, 0, new Object[0]);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f140769a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f140770b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutabilityOwnership f140771c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Object[] f140772d;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final TrieNode a() {
            return TrieNode.f140768f;
        }

        private Companion() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class ModificationResult<K, V> {
    }

    public TrieNode(int i3, int i4, Object[] buffer, MutabilityOwnership mutabilityOwnership) {
        Intrinsics.checkNotNullParameter(buffer, "buffer");
        this.f140769a = i3;
        this.f140770b = i4;
        this.f140771c = mutabilityOwnership;
        this.f140772d = buffer;
    }

    private final TrieNode A(TrieNode trieNode, int i3, int i4, DeltaCounter deltaCounter, PersistentHashMapBuilder persistentHashMapBuilder) {
        if (o(i3)) {
            TrieNode trieNodeI = I(J(i3));
            if (trieNode.o(i3)) {
                return trieNodeI.z(trieNode.I(trieNode.J(i3)), i4 + 5, deltaCounter, persistentHashMapBuilder);
            }
            if (!trieNode.n(i3)) {
                return trieNodeI;
            }
            int iJ = trieNode.j(i3);
            Object objP = trieNode.p(iJ);
            Object objK = trieNode.K(iJ);
            int size = persistentHashMapBuilder.size();
            TrieNode trieNodeY = trieNodeI.y(objP != null ? objP.hashCode() : 0, objP, objK, i4 + 5, persistentHashMapBuilder);
            if (persistentHashMapBuilder.size() == size) {
                deltaCounter.c(deltaCounter.a() + 1);
            }
            return trieNodeY;
        }
        if (!trieNode.o(i3)) {
            int iJ2 = j(i3);
            Object objP2 = p(iJ2);
            Object objK2 = K(iJ2);
            int iJ3 = trieNode.j(i3);
            Object objP3 = trieNode.p(iJ3);
            return q(objP2 == null ? 0 : objP2.hashCode(), objP2, objK2, objP3 != null ? objP3.hashCode() : 0, objP3, trieNode.K(iJ3), i4 + 5, persistentHashMapBuilder.d());
        }
        TrieNode trieNodeI2 = trieNode.I(trieNode.J(i3));
        if (!n(i3)) {
            return trieNodeI2;
        }
        int iJ4 = j(i3);
        Object objP4 = p(iJ4);
        int i5 = i4 + 5;
        if (!trieNodeI2.g(objP4 == null ? 0 : objP4.hashCode(), objP4, i5)) {
            return trieNodeI2.y(objP4 != null ? objP4.hashCode() : 0, objP4, K(iJ4), i5, persistentHashMapBuilder);
        }
        deltaCounter.c(deltaCounter.a() + 1);
        return trieNodeI2;
    }

    private final TrieNode D(int i3, int i4, PersistentHashMapBuilder persistentHashMapBuilder) {
        persistentHashMapBuilder.g(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.f(K(i3));
        if (this.f140772d.length == 2) {
            return null;
        }
        if (this.f140771c != persistentHashMapBuilder.d()) {
            return new TrieNode(i4 ^ this.f140769a, this.f140770b, TrieNodeKt.g(this.f140772d, i3), persistentHashMapBuilder.d());
        }
        this.f140772d = TrieNodeKt.g(this.f140772d, i3);
        this.f140769a ^= i4;
        return this;
    }

    private final TrieNode E(int i3, int i4, MutabilityOwnership mutabilityOwnership) {
        Object[] objArr = this.f140772d;
        if (objArr.length == 1) {
            return null;
        }
        if (this.f140771c != mutabilityOwnership) {
            return new TrieNode(this.f140769a, i4 ^ this.f140770b, TrieNodeKt.h(objArr, i3), mutabilityOwnership);
        }
        this.f140772d = TrieNodeKt.h(objArr, i3);
        this.f140770b ^= i4;
        return this;
    }

    private final TrieNode F(TrieNode trieNode, TrieNode trieNode2, int i3, int i4, MutabilityOwnership mutabilityOwnership) {
        return trieNode2 == null ? E(i3, i4, mutabilityOwnership) : trieNode != trieNode2 ? G(i3, trieNode2, mutabilityOwnership) : this;
    }

    private final TrieNode G(int i3, TrieNode trieNode, MutabilityOwnership mutabilityOwnership) {
        CommonFunctionsKt.a(trieNode.f140771c == mutabilityOwnership);
        Object[] objArr = this.f140772d;
        if (objArr.length == 1 && trieNode.f140772d.length == 2 && trieNode.f140770b == 0) {
            trieNode.f140769a = this.f140770b;
            return trieNode;
        }
        if (this.f140771c == mutabilityOwnership) {
            objArr[i3] = trieNode;
            return this;
        }
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i3] = trieNode;
        return new TrieNode(this.f140769a, this.f140770b, objArrCopyOf, mutabilityOwnership);
    }

    private final TrieNode H(int i3, Object obj, PersistentHashMapBuilder persistentHashMapBuilder) {
        if (this.f140771c == persistentHashMapBuilder.d()) {
            this.f140772d[i3 + 1] = obj;
            return this;
        }
        persistentHashMapBuilder.e(persistentHashMapBuilder.b() + 1);
        Object[] objArr = this.f140772d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[i3 + 1] = obj;
        return new TrieNode(this.f140769a, this.f140770b, objArrCopyOf, persistentHashMapBuilder.d());
    }

    private final Object K(int i3) {
        return this.f140772d[i3 + 1];
    }

    private final Object[] b(int i3, int i4, int i5, Object obj, Object obj2, int i6, MutabilityOwnership mutabilityOwnership) {
        Object objP = p(i3);
        return TrieNodeKt.i(this.f140772d, i3, J(i4) + 1, q(objP == null ? 0 : objP.hashCode(), objP, K(i3), i5, obj, obj2, i6 + 5, mutabilityOwnership));
    }

    private final int c() {
        if (this.f140770b == 0) {
            return this.f140772d.length / 2;
        }
        int iBitCount = Integer.bitCount(this.f140769a);
        int length = this.f140772d.length;
        for (int i3 = iBitCount * 2; i3 < length; i3++) {
            iBitCount += I(i3).c();
        }
        return iBitCount;
    }

    private final boolean d(Object obj) {
        return f(obj) != -1;
    }

    private final Object e(Object obj) {
        int iF = f(obj);
        if (iF != -1) {
            return K(iF);
        }
        return null;
    }

    private final int f(Object obj) {
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, this.f140772d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL <= 0 || iG > iH) && (iL >= 0 || iH > iG)) {
            return -1;
        }
        while (true) {
            int i3 = iG + iL;
            if (Intrinsics.areEqual(obj, p(iG))) {
                return iG;
            }
            if (iG == iH) {
                return -1;
            }
            iG = i3;
        }
    }

    private final boolean h(TrieNode trieNode) {
        if (this == trieNode) {
            return true;
        }
        if (this.f140770b != trieNode.f140770b || this.f140769a != trieNode.f140769a) {
            return false;
        }
        int length = this.f140772d.length;
        int i3 = 0;
        while (i3 < length) {
            int i4 = i3 + 1;
            if (this.f140772d[i3] != trieNode.f140772d[i3]) {
                return false;
            }
            i3 = i4;
        }
        return true;
    }

    private final boolean o(int i3) {
        return (i3 & this.f140770b) != 0;
    }

    private final Object p(int i3) {
        return this.f140772d[i3];
    }

    private final TrieNode q(int i3, Object obj, Object obj2, int i4, Object obj3, Object obj4, int i5, MutabilityOwnership mutabilityOwnership) {
        if (i5 > 30) {
            return new TrieNode(0, 0, new Object[]{obj, obj2, obj3, obj4}, mutabilityOwnership);
        }
        int iE = TrieNodeKt.e(i3, i5);
        int iE2 = TrieNodeKt.e(i4, i5);
        if (iE != iE2) {
            return new TrieNode((1 << iE) | (1 << iE2), 0, iE < iE2 ? new Object[]{obj, obj2, obj3, obj4} : new Object[]{obj3, obj4, obj, obj2}, mutabilityOwnership);
        }
        return new TrieNode(0, 1 << iE, new Object[]{q(i3, obj, obj2, i4, obj3, obj4, i5 + 5, mutabilityOwnership)}, mutabilityOwnership);
    }

    private final TrieNode r(Object obj, Object obj2, PersistentHashMapBuilder persistentHashMapBuilder) {
        int iF = f(obj);
        if (iF == -1) {
            persistentHashMapBuilder.g(persistentHashMapBuilder.size() + 1);
            return new TrieNode(0, 0, TrieNodeKt.f(this.f140772d, 0, obj, obj2), persistentHashMapBuilder.d());
        }
        persistentHashMapBuilder.f(K(iF));
        if (this.f140771c == persistentHashMapBuilder.d()) {
            this.f140772d[iF + 1] = obj2;
            return this;
        }
        persistentHashMapBuilder.e(persistentHashMapBuilder.b() + 1);
        Object[] objArr = this.f140772d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, size)");
        objArrCopyOf[iF + 1] = obj2;
        return new TrieNode(0, 0, objArrCopyOf, persistentHashMapBuilder.d());
    }

    private final TrieNode s(TrieNode trieNode, DeltaCounter deltaCounter, MutabilityOwnership mutabilityOwnership) {
        CommonFunctionsKt.a(this.f140770b == 0);
        CommonFunctionsKt.a(this.f140769a == 0);
        CommonFunctionsKt.a(trieNode.f140770b == 0);
        CommonFunctionsKt.a(trieNode.f140769a == 0);
        Object[] objArr = this.f140772d;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length + trieNode.f140772d.length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf, "copyOf(this, newSize)");
        int length = this.f140772d.length;
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, trieNode.f140772d.length), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (true) {
                int i3 = iG + iL;
                if (d(trieNode.f140772d[iG])) {
                    deltaCounter.c(deltaCounter.a() + 1);
                } else {
                    Object[] objArr2 = trieNode.f140772d;
                    objArrCopyOf[length] = objArr2[iG];
                    objArrCopyOf[length + 1] = objArr2[iG + 1];
                    length += 2;
                }
                if (iG == iH) {
                    break;
                }
                iG = i3;
            }
        }
        if (length == this.f140772d.length) {
            return this;
        }
        if (length == trieNode.f140772d.length) {
            return trieNode;
        }
        if (length == objArrCopyOf.length) {
            return new TrieNode(0, 0, objArrCopyOf, mutabilityOwnership);
        }
        Object[] objArrCopyOf2 = Arrays.copyOf(objArrCopyOf, length);
        Intrinsics.checkNotNullExpressionValue(objArrCopyOf2, "copyOf(this, newSize)");
        return new TrieNode(0, 0, objArrCopyOf2, mutabilityOwnership);
    }

    private final TrieNode t(Object obj, Object obj2, PersistentHashMapBuilder persistentHashMapBuilder) {
        int iF = f(obj);
        return (iF == -1 || !Intrinsics.areEqual(obj2, K(iF))) ? this : v(iF, persistentHashMapBuilder);
    }

    private final TrieNode u(Object obj, PersistentHashMapBuilder persistentHashMapBuilder) {
        int iF = f(obj);
        return iF != -1 ? v(iF, persistentHashMapBuilder) : this;
    }

    private final TrieNode v(int i3, PersistentHashMapBuilder persistentHashMapBuilder) {
        persistentHashMapBuilder.g(persistentHashMapBuilder.size() - 1);
        persistentHashMapBuilder.f(K(i3));
        if (this.f140772d.length == 2) {
            return null;
        }
        if (this.f140771c != persistentHashMapBuilder.d()) {
            return new TrieNode(0, 0, TrieNodeKt.g(this.f140772d, i3), persistentHashMapBuilder.d());
        }
        this.f140772d = TrieNodeKt.g(this.f140772d, i3);
        return this;
    }

    private final TrieNode w(int i3, Object obj, Object obj2, MutabilityOwnership mutabilityOwnership) {
        int iJ = j(i3);
        if (this.f140771c != mutabilityOwnership) {
            return new TrieNode(i3 | this.f140769a, this.f140770b, TrieNodeKt.f(this.f140772d, iJ, obj, obj2), mutabilityOwnership);
        }
        this.f140772d = TrieNodeKt.f(this.f140772d, iJ, obj, obj2);
        this.f140769a = i3 | this.f140769a;
        return this;
    }

    private final TrieNode x(int i3, int i4, int i5, Object obj, Object obj2, int i6, MutabilityOwnership mutabilityOwnership) {
        if (this.f140771c != mutabilityOwnership) {
            return new TrieNode(this.f140769a ^ i4, i4 | this.f140770b, b(i3, i4, i5, obj, obj2, i6, mutabilityOwnership), mutabilityOwnership);
        }
        this.f140772d = b(i3, i4, i5, obj, obj2, i6, mutabilityOwnership);
        this.f140769a ^= i4;
        this.f140770b |= i4;
        return this;
    }

    public final TrieNode B(int i3, Object obj, int i4, PersistentHashMapBuilder mutator) {
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int iE = 1 << TrieNodeKt.e(i3, i4);
        if (n(iE)) {
            int iJ = j(iE);
            if (Intrinsics.areEqual(obj, p(iJ))) {
                return D(iJ, iE, mutator);
            }
        } else if (o(iE)) {
            int iJ2 = J(iE);
            TrieNode trieNodeI = I(iJ2);
            return F(trieNodeI, i4 == 30 ? trieNodeI.u(obj, mutator) : trieNodeI.B(i3, obj, i4 + 5, mutator), iJ2, iE, mutator.d());
        }
        return this;
    }

    public final TrieNode C(int i3, Object obj, Object obj2, int i4, PersistentHashMapBuilder mutator) {
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int iE = 1 << TrieNodeKt.e(i3, i4);
        if (n(iE)) {
            int iJ = j(iE);
            if (Intrinsics.areEqual(obj, p(iJ)) && Intrinsics.areEqual(obj2, K(iJ))) {
                return D(iJ, iE, mutator);
            }
        } else if (o(iE)) {
            int iJ2 = J(iE);
            TrieNode trieNodeI = I(iJ2);
            return F(trieNodeI, i4 == 30 ? trieNodeI.t(obj, obj2, mutator) : trieNodeI.C(i3, obj, obj2, i4 + 5, mutator), iJ2, iE, mutator.d());
        }
        return this;
    }

    public final TrieNode I(int i3) {
        Object obj = this.f140772d[i3];
        if (obj != null) {
            return (TrieNode) obj;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlinx.collections.immutable.implementations.immutableMap.TrieNode<K of kotlinx.collections.immutable.implementations.immutableMap.TrieNode, V of kotlinx.collections.immutable.implementations.immutableMap.TrieNode>");
    }

    public final int J(int i3) {
        return (this.f140772d.length - 1) - Integer.bitCount((i3 - 1) & this.f140770b);
    }

    public final boolean g(int i3, Object obj, int i4) {
        int iE = 1 << TrieNodeKt.e(i3, i4);
        if (n(iE)) {
            return Intrinsics.areEqual(obj, p(j(iE)));
        }
        if (!o(iE)) {
            return false;
        }
        TrieNode trieNodeI = I(J(iE));
        return i4 == 30 ? trieNodeI.d(obj) : trieNodeI.g(i3, obj, i4 + 5);
    }

    public final int i() {
        return Integer.bitCount(this.f140769a);
    }

    public final int j(int i3) {
        return Integer.bitCount((i3 - 1) & this.f140769a) * 2;
    }

    public final boolean k(TrieNode that, Function2 equalityComparator) {
        int i3;
        Intrinsics.checkNotNullParameter(that, "that");
        Intrinsics.checkNotNullParameter(equalityComparator, "equalityComparator");
        if (this == that) {
            return true;
        }
        int i4 = this.f140769a;
        if (i4 != that.f140769a || (i3 = this.f140770b) != that.f140770b) {
            return false;
        }
        if (i4 == 0 && i3 == 0) {
            Object[] objArr = this.f140772d;
            if (objArr.length != that.f140772d.length) {
                return false;
            }
            Iterable iterableZ = RangesKt.z(RangesKt.B(0, objArr.length), 2);
            if ((iterableZ instanceof Collection) && ((Collection) iterableZ).isEmpty()) {
                return true;
            }
            Iterator it = iterableZ.iterator();
            while (it.hasNext()) {
                int iNextInt = ((IntIterator) it).nextInt();
                Object objP = that.p(iNextInt);
                Object objK = that.K(iNextInt);
                int iF = f(objP);
                if (!(iF != -1 ? ((Boolean) equalityComparator.invoke(K(iF), objK)).booleanValue() : false)) {
                    return false;
                }
            }
            return true;
        }
        int iBitCount = Integer.bitCount(i4) * 2;
        IntProgression intProgressionZ = RangesKt.z(RangesKt.B(0, iBitCount), 2);
        int iG = intProgressionZ.g();
        int iH = intProgressionZ.h();
        int iL = intProgressionZ.l();
        if ((iL > 0 && iG <= iH) || (iL < 0 && iH <= iG)) {
            while (true) {
                int i5 = iG + iL;
                if (!Intrinsics.areEqual(p(iG), that.p(iG)) || !((Boolean) equalityComparator.invoke(K(iG), that.K(iG))).booleanValue()) {
                    return false;
                }
                if (iG == iH) {
                    break;
                }
                iG = i5;
            }
        }
        int length = this.f140772d.length;
        while (iBitCount < length) {
            int i6 = iBitCount + 1;
            if (!I(iBitCount).k(that.I(iBitCount), equalityComparator)) {
                return false;
            }
            iBitCount = i6;
        }
        return true;
    }

    public final Object l(int i3, Object obj, int i4) {
        int iE = 1 << TrieNodeKt.e(i3, i4);
        if (n(iE)) {
            int iJ = j(iE);
            if (Intrinsics.areEqual(obj, p(iJ))) {
                return K(iJ);
            }
            return null;
        }
        if (!o(iE)) {
            return null;
        }
        TrieNode trieNodeI = I(J(iE));
        return i4 == 30 ? trieNodeI.e(obj) : trieNodeI.l(i3, obj, i4 + 5);
    }

    public final Object[] m() {
        return this.f140772d;
    }

    public final boolean n(int i3) {
        return (i3 & this.f140769a) != 0;
    }

    public final TrieNode y(int i3, Object obj, Object obj2, int i4, PersistentHashMapBuilder mutator) {
        PersistentHashMapBuilder persistentHashMapBuilder;
        TrieNode trieNodeY;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        int iE = 1 << TrieNodeKt.e(i3, i4);
        if (n(iE)) {
            int iJ = j(iE);
            if (Intrinsics.areEqual(obj, p(iJ))) {
                mutator.f(K(iJ));
                return K(iJ) == obj2 ? this : H(iJ, obj2, mutator);
            }
            mutator.g(mutator.size() + 1);
            return x(iJ, iE, i3, obj, obj2, i4, mutator.d());
        }
        if (!o(iE)) {
            mutator.g(mutator.size() + 1);
            return w(iE, obj, obj2, mutator.d());
        }
        int iJ2 = J(iE);
        TrieNode trieNodeI = I(iJ2);
        if (i4 == 30) {
            trieNodeY = trieNodeI.r(obj, obj2, mutator);
            persistentHashMapBuilder = mutator;
        } else {
            persistentHashMapBuilder = mutator;
            trieNodeY = trieNodeI.y(i3, obj, obj2, i4 + 5, persistentHashMapBuilder);
        }
        return trieNodeI == trieNodeY ? this : G(iJ2, trieNodeY, persistentHashMapBuilder.d());
    }

    public final TrieNode z(TrieNode otherNode, int i3, DeltaCounter intersectionCounter, PersistentHashMapBuilder persistentHashMapBuilder) {
        Intrinsics.checkNotNullParameter(otherNode, "otherNode");
        Intrinsics.checkNotNullParameter(intersectionCounter, "intersectionCounter");
        PersistentHashMapBuilder mutator = persistentHashMapBuilder;
        Intrinsics.checkNotNullParameter(mutator, "mutator");
        if (this == otherNode) {
            intersectionCounter.b(c());
            return this;
        }
        int i4 = i3;
        if (i4 > 30) {
            return s(otherNode, intersectionCounter, mutator.d());
        }
        int i5 = this.f140770b | otherNode.f140770b;
        int i6 = this.f140769a;
        int i7 = otherNode.f140769a;
        int i8 = (i6 ^ i7) & (~i5);
        int i9 = i6 & i7;
        while (i9 != 0) {
            int iLowestOneBit = Integer.lowestOneBit(i9);
            if (Intrinsics.areEqual(p(j(iLowestOneBit)), otherNode.p(otherNode.j(iLowestOneBit)))) {
                i8 |= iLowestOneBit;
            } else {
                i5 |= iLowestOneBit;
            }
            i9 ^= iLowestOneBit;
        }
        if ((i5 & i8) != 0) {
            throw new IllegalStateException("Check failed.");
        }
        TrieNode trieNode = (Intrinsics.areEqual(this.f140771c, mutator.d()) && this.f140769a == i8 && this.f140770b == i5) ? this : new TrieNode(i8, i5, new Object[(Integer.bitCount(i8) * 2) + Integer.bitCount(i5)]);
        int i10 = 0;
        int i11 = i5;
        int i12 = 0;
        while (i11 != 0) {
            int iLowestOneBit2 = Integer.lowestOneBit(i11);
            trieNode.m()[(trieNode.m().length - 1) - i12] = A(otherNode, iLowestOneBit2, i4, intersectionCounter, mutator);
            i12++;
            i11 ^= iLowestOneBit2;
            i4 = i3;
            mutator = persistentHashMapBuilder;
        }
        while (i8 != 0) {
            int iLowestOneBit3 = Integer.lowestOneBit(i8);
            int i13 = i10 * 2;
            if (otherNode.n(iLowestOneBit3)) {
                int iJ = otherNode.j(iLowestOneBit3);
                trieNode.m()[i13] = otherNode.p(iJ);
                trieNode.m()[i13 + 1] = otherNode.K(iJ);
                if (n(iLowestOneBit3)) {
                    intersectionCounter.c(intersectionCounter.a() + 1);
                }
            } else {
                int iJ2 = j(iLowestOneBit3);
                trieNode.m()[i13] = p(iJ2);
                trieNode.m()[i13 + 1] = K(iJ2);
            }
            i10++;
            i8 ^= iLowestOneBit3;
        }
        return h(trieNode) ? this : otherNode.h(trieNode) ? otherNode : trieNode;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public TrieNode(int i3, int i4, Object[] buffer) {
        this(i3, i4, buffer, null);
        Intrinsics.checkNotNullParameter(buffer, "buffer");
    }
}
