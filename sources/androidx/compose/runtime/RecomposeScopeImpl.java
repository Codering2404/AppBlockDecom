package androidx.compose.runtime;

import androidx.collection.MutableObjectIntMap;
import androidx.collection.MutableScatterMap;
import androidx.compose.runtime.tooling.RecomposeScopeObserver;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.sun.jna.Function;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
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
public final class RecomposeScopeImpl implements ScopeUpdateScope, RecomposeScope {

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final Companion f24021i = new Companion(null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final int f24022j = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f24023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private RecomposeScopeOwner f24024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Anchor f24025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Function2 f24026d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private RecomposeScopeObserver f24027e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f24028f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private MutableObjectIntMap f24029g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private MutableScatterMap f24030h;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final void a(SlotWriter slotWriter, List list, RecomposeScopeOwner recomposeScopeOwner) {
            List list2 = list;
            if (list2.isEmpty()) {
                return;
            }
            int size = list2.size();
            for (int i3 = 0; i3 < size; i3++) {
                Object objB1 = slotWriter.b1((Anchor) list.get(i3), 0);
                RecomposeScopeImpl recomposeScopeImpl = objB1 instanceof RecomposeScopeImpl ? (RecomposeScopeImpl) objB1 : null;
                if (recomposeScopeImpl != null) {
                    recomposeScopeImpl.e(recomposeScopeOwner);
                }
            }
        }

        public final boolean b(SlotTable slotTable, List list) {
            List list2 = list;
            if (!list2.isEmpty()) {
                int size = list2.size();
                for (int i3 = 0; i3 < size; i3++) {
                    Anchor anchor = (Anchor) list.get(i3);
                    if (slotTable.D(anchor) && (slotTable.G(slotTable.f(anchor), 0) instanceof RecomposeScopeImpl)) {
                        return true;
                    }
                }
            }
            return false;
        }

        private Companion() {
        }
    }

    public RecomposeScopeImpl(RecomposeScopeOwner recomposeScopeOwner) {
        this.f24024b = recomposeScopeOwner;
    }

    private final void J(boolean z2) {
        if (z2) {
            this.f24023a |= 32;
        } else {
            this.f24023a &= -33;
        }
    }

    private final void M(boolean z2) {
        if (z2) {
            this.f24023a |= 16;
        } else {
            this.f24023a &= -17;
        }
    }

    private final boolean f(DerivedState derivedState, MutableScatterMap mutableScatterMap) {
        Intrinsics.checkNotNull(derivedState, "null cannot be cast to non-null type androidx.compose.runtime.DerivedState<kotlin.Any?>");
        SnapshotMutationPolicy snapshotMutationPolicyF = derivedState.f();
        if (snapshotMutationPolicyF == null) {
            snapshotMutationPolicyF = SnapshotStateKt.r();
        }
        return !snapshotMutationPolicyF.b(derivedState.u().a(), mutableScatterMap.e(derivedState));
    }

    private final boolean p() {
        return (this.f24023a & 32) != 0;
    }

    public final void A() {
        RecomposeScopeOwner recomposeScopeOwner = this.f24024b;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.b(this);
        }
        this.f24024b = null;
        this.f24029g = null;
        this.f24030h = null;
        RecomposeScopeObserver recomposeScopeObserver = this.f24027e;
        if (recomposeScopeObserver != null) {
            recomposeScopeObserver.a(this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void B() {
        /*
            r17 = this;
            r1 = r17
            androidx.compose.runtime.RecomposeScopeOwner r0 = r1.f24024b
            if (r0 == 0) goto L60
            androidx.collection.MutableObjectIntMap r2 = r1.f24029g
            if (r2 == 0) goto L60
            r3 = 1
            r1.J(r3)
            r3 = 0
            java.lang.Object[] r4 = r2.f3076b     // Catch: java.lang.Throwable -> L4b
            int[] r5 = r2.f3077c     // Catch: java.lang.Throwable -> L4b
            long[] r2 = r2.f3075a     // Catch: java.lang.Throwable -> L4b
            int r6 = r2.length     // Catch: java.lang.Throwable -> L4b
            int r6 = r6 + (-2)
            if (r6 < 0) goto L58
            r7 = r3
        L1b:
            r8 = r2[r7]     // Catch: java.lang.Throwable -> L4b
            long r10 = ~r8     // Catch: java.lang.Throwable -> L4b
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L53
            int r10 = r7 - r6
            int r10 = ~r10     // Catch: java.lang.Throwable -> L4b
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r3
        L35:
            if (r12 >= r10) goto L51
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L4d
            int r13 = r7 << 3
            int r13 = r13 + r12
            r14 = r4[r13]     // Catch: java.lang.Throwable -> L4b
            r13 = r5[r13]     // Catch: java.lang.Throwable -> L4b
            r0.a(r14)     // Catch: java.lang.Throwable -> L4b
            goto L4d
        L4b:
            r0 = move-exception
            goto L5c
        L4d:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L35
        L51:
            if (r10 != r11) goto L58
        L53:
            if (r7 == r6) goto L58
            int r7 = r7 + 1
            goto L1b
        L58:
            r1.J(r3)
            return
        L5c:
            r1.J(r3)
            throw r0
        L60:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.B():void");
    }

    public final void C() {
        if (r()) {
            return;
        }
        M(true);
    }

    public final void D(Anchor anchor) {
        this.f24025c = anchor;
    }

    public final void E(boolean z2) {
        if (z2) {
            this.f24023a |= 2;
        } else {
            this.f24023a &= -3;
        }
    }

    public final void F(boolean z2) {
        if (z2) {
            this.f24023a |= 4;
        } else {
            this.f24023a &= -5;
        }
    }

    public final void G(boolean z2) {
        if (z2) {
            this.f24023a |= 64;
        } else {
            this.f24023a &= -65;
        }
    }

    public final void H(boolean z2) {
        this.f24023a = z2 ? this.f24023a | Function.MAX_NARGS : this.f24023a & (-257);
    }

    public final void I(boolean z2) {
        if (z2) {
            this.f24023a |= 8;
        } else {
            this.f24023a &= -9;
        }
    }

    public final void K(boolean z2) {
        this.f24023a = z2 ? this.f24023a | 512 : this.f24023a & (-513);
    }

    public final void L(boolean z2) {
        this.f24023a = z2 ? this.f24023a | ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD : this.f24023a & (-129);
    }

    public final void N(boolean z2) {
        this.f24023a = z2 ? this.f24023a | 1 : this.f24023a & (-2);
    }

    public final void O(int i3) {
        this.f24028f = i3;
        M(false);
    }

    @Override // androidx.compose.runtime.ScopeUpdateScope
    public void a(Function2 function2) {
        this.f24026d = function2;
    }

    public final void e(RecomposeScopeOwner recomposeScopeOwner) {
        this.f24024b = recomposeScopeOwner;
    }

    public final void g(Composer composer) {
        Unit unit;
        Function2 function2 = this.f24026d;
        RecomposeScopeObserver recomposeScopeObserver = this.f24027e;
        if (recomposeScopeObserver != null && function2 != null) {
            recomposeScopeObserver.b(this);
            try {
                function2.invoke(composer, 1);
                return;
            } finally {
                recomposeScopeObserver.c(this);
            }
        }
        if (function2 != null) {
            function2.invoke(composer, 1);
            unit = Unit.f139807a;
        } else {
            unit = null;
        }
        if (unit == null) {
            throw new IllegalStateException("Invalid restart scope");
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:21:0x0056  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final kotlin.jvm.functions.Function1 h(final int r20) {
        /*
            r19 = this;
            r0 = r19
            r1 = r20
            androidx.collection.MutableObjectIntMap r2 = r0.f24029g
            r3 = 0
            if (r2 == 0) goto L5b
            boolean r4 = r0.s()
            if (r4 != 0) goto L5b
            java.lang.Object[] r4 = r2.f3076b
            int[] r5 = r2.f3077c
            long[] r6 = r2.f3075a
            int r7 = r6.length
            int r7 = r7 + (-2)
            if (r7 < 0) goto L5b
            r8 = 0
            r9 = r8
        L1c:
            r10 = r6[r9]
            long r12 = ~r10
            r14 = 7
            long r12 = r12 << r14
            long r12 = r12 & r10
            r14 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r12 = r12 & r14
            int r12 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r12 == 0) goto L56
            int r12 = r9 - r7
            int r12 = ~r12
            int r12 = r12 >>> 31
            r13 = 8
            int r12 = 8 - r12
            r14 = r8
        L36:
            if (r14 >= r12) goto L54
            r15 = 255(0xff, double:1.26E-321)
            long r15 = r15 & r10
            r17 = 128(0x80, double:6.3E-322)
            int r15 = (r15 > r17 ? 1 : (r15 == r17 ? 0 : -1))
            if (r15 >= 0) goto L50
            int r15 = r9 << 3
            int r15 = r15 + r14
            r16 = r4[r15]
            r15 = r5[r15]
            if (r15 == r1) goto L50
            androidx.compose.runtime.RecomposeScopeImpl$end$1$2 r3 = new androidx.compose.runtime.RecomposeScopeImpl$end$1$2
            r3.<init>()
            return r3
        L50:
            long r10 = r10 >> r13
            int r14 = r14 + 1
            goto L36
        L54:
            if (r12 != r13) goto L5b
        L56:
            if (r9 == r7) goto L5b
            int r9 = r9 + 1
            goto L1c
        L5b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.h(int):kotlin.jvm.functions.Function1");
    }

    public final Anchor i() {
        return this.f24025c;
    }

    @Override // androidx.compose.runtime.RecomposeScope
    public void invalidate() {
        RecomposeScopeOwner recomposeScopeOwner = this.f24024b;
        if (recomposeScopeOwner != null) {
            recomposeScopeOwner.j(this, null);
        }
    }

    public final boolean j() {
        return this.f24026d != null;
    }

    public final boolean k() {
        return (this.f24023a & 2) != 0;
    }

    public final boolean l() {
        return (this.f24023a & 4) != 0;
    }

    public final boolean m() {
        return (this.f24023a & 64) != 0;
    }

    public final boolean n() {
        return (this.f24023a & Function.MAX_NARGS) != 0;
    }

    public final boolean o() {
        return (this.f24023a & 8) != 0;
    }

    public final boolean q() {
        return (this.f24023a & 512) != 0;
    }

    public final boolean r() {
        return (this.f24023a & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0;
    }

    public final boolean s() {
        return (this.f24023a & 16) != 0;
    }

    public final boolean t() {
        return (this.f24023a & 1) != 0;
    }

    public final boolean u() {
        if (this.f24024b != null) {
            Anchor anchor = this.f24025c;
            if (anchor != null ? anchor.b() : false) {
                return true;
            }
        }
        return false;
    }

    public final InvalidationResult v(Object obj) {
        InvalidationResult invalidationResultJ;
        RecomposeScopeOwner recomposeScopeOwner = this.f24024b;
        return (recomposeScopeOwner == null || (invalidationResultJ = recomposeScopeOwner.j(this, obj)) == null) ? InvalidationResult.f23911a : invalidationResultJ;
    }

    public final boolean w() {
        return this.f24030h != null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:29:0x0065, code lost:
    
        return true;
     */
    /* JADX WARN: Removed duplicated region for block: B:32:0x006c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean x(java.lang.Object r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = 1
            if (r1 != 0) goto L8
            return r2
        L8:
            androidx.collection.MutableScatterMap r3 = r0.f24030h
            if (r3 != 0) goto Ld
            return r2
        Ld:
            boolean r4 = r1 instanceof androidx.compose.runtime.DerivedState
            if (r4 == 0) goto L18
            androidx.compose.runtime.DerivedState r1 = (androidx.compose.runtime.DerivedState) r1
            boolean r1 = r0.f(r1, r3)
            return r1
        L18:
            boolean r4 = r1 instanceof androidx.collection.ScatterSet
            if (r4 == 0) goto L72
            androidx.collection.ScatterSet r1 = (androidx.collection.ScatterSet) r1
            boolean r4 = r1.f()
            r5 = 0
            if (r4 == 0) goto L71
            java.lang.Object[] r4 = r1.f3116b
            long[] r1 = r1.f3115a
            int r6 = r1.length
            int r6 = r6 + (-2)
            if (r6 < 0) goto L71
            r7 = r5
        L2f:
            r8 = r1[r7]
            long r10 = ~r8
            r12 = 7
            long r10 = r10 << r12
            long r10 = r10 & r8
            r12 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r10 = r10 & r12
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 == 0) goto L6c
            int r10 = r7 - r6
            int r10 = ~r10
            int r10 = r10 >>> 31
            r11 = 8
            int r10 = 8 - r10
            r12 = r5
        L49:
            if (r12 >= r10) goto L6a
            r13 = 255(0xff, double:1.26E-321)
            long r13 = r13 & r8
            r15 = 128(0x80, double:6.3E-322)
            int r13 = (r13 > r15 ? 1 : (r13 == r15 ? 0 : -1))
            if (r13 >= 0) goto L66
            int r13 = r7 << 3
            int r13 = r13 + r12
            r13 = r4[r13]
            boolean r14 = r13 instanceof androidx.compose.runtime.DerivedState
            if (r14 == 0) goto L65
            androidx.compose.runtime.DerivedState r13 = (androidx.compose.runtime.DerivedState) r13
            boolean r13 = r0.f(r13, r3)
            if (r13 == 0) goto L66
        L65:
            return r2
        L66:
            long r8 = r8 >> r11
            int r12 = r12 + 1
            goto L49
        L6a:
            if (r10 != r11) goto L71
        L6c:
            if (r7 == r6) goto L71
            int r7 = r7 + 1
            goto L2f
        L71:
            return r5
        L72:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.runtime.RecomposeScopeImpl.x(java.lang.Object):boolean");
    }

    public final void y(DerivedState derivedState, Object obj) {
        MutableScatterMap mutableScatterMap = this.f24030h;
        if (mutableScatterMap == null) {
            mutableScatterMap = new MutableScatterMap(0, 1, null);
            this.f24030h = mutableScatterMap;
        }
        mutableScatterMap.x(derivedState, obj);
    }

    public final boolean z(Object obj) {
        if (p()) {
            return false;
        }
        MutableObjectIntMap mutableObjectIntMap = this.f24029g;
        if (mutableObjectIntMap == null) {
            mutableObjectIntMap = new MutableObjectIntMap(0, 1, null);
            this.f24029g = mutableObjectIntMap;
        }
        return mutableObjectIntMap.q(obj, this.f24028f, -1) == this.f24028f;
    }
}
