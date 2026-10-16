package androidx.compose.foundation.pager;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.MutatePriority;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Density;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

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
public abstract class PagerState implements ScrollableState {
    private final AwaitFirstLayoutModifier A;
    private final MutableState B;
    private final RemeasurementModifier C;
    private long D;
    private final LazyLayoutPinnedItemList E;
    private final MutableState F;
    private final MutableState G;
    private final MutableState H;
    private final MutableState I;
    private final MutableState J;
    private final MutableState K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8841a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PagerMeasureResult f8842b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f8843c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final PagerScrollPosition f8844d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f8845e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private int f8846f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private long f8847g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private long f8848h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private float f8849i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private float f8850j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final ScrollableState f8851k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private int f8852l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private int f8853m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private boolean f8854n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f8855o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private LazyLayoutPrefetchState.PrefetchHandle f8856p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private boolean f8857q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private MutableState f8858r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private Density f8859s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MutableInteractionSource f8860t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MutableIntState f8861u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MutableIntState f8862v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final State f8863w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final State f8864x;

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private final LazyLayoutPrefetchState f8865y;

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private final LazyLayoutBeyondBoundsInfo f8866z;

    public PagerState(int i3, float f3, PrefetchScheduler prefetchScheduler) {
        double d3 = f3;
        boolean z2 = false;
        if (-0.5d <= d3 && d3 <= 0.5d) {
            z2 = true;
        }
        if (!z2) {
            InlineClassHelperKt.a("currentPageOffsetFraction " + f3 + " is not within the range -0.5 to 0.5");
        }
        this.f8843c = SnapshotStateKt__SnapshotStateKt.e(Offset.d(Offset.f25596b.c()), null, 2, null);
        PagerScrollPosition pagerScrollPosition = new PagerScrollPosition(i3, f3, this);
        this.f8844d = pagerScrollPosition;
        this.f8845e = i3;
        this.f8847g = Long.MAX_VALUE;
        this.f8851k = ScrollableStateKt.a(new Function1<Float, Float>() { // from class: androidx.compose.foundation.pager.PagerState$scrollableState$1
            {
                super(1);
            }

            public final Float c(float f4) {
                return Float.valueOf(this.f8895a.a0(f4));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        });
        this.f8854n = true;
        this.f8855o = -1;
        this.f8858r = SnapshotStateKt.i(PagerStateKt.k(), SnapshotStateKt.k());
        this.f8859s = PagerStateKt.f8900c;
        this.f8860t = InteractionSourceKt.a();
        this.f8861u = SnapshotIntStateKt.a(-1);
        this.f8862v = SnapshotIntStateKt.a(i3);
        this.f8863w = SnapshotStateKt.d(SnapshotStateKt.r(), new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$settledPage$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(this.f8896a.c() ? this.f8896a.T() : this.f8896a.v());
            }
        });
        this.f8864x = SnapshotStateKt.d(SnapshotStateKt.r(), new Function0<Integer>() { // from class: androidx.compose.foundation.pager.PagerState$targetPage$2
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Integer invoke() {
                return Integer.valueOf(this.f8897a.s(!this.f8897a.c() ? this.f8897a.v() : this.f8897a.P() != -1 ? this.f8897a.P() : Math.abs(this.f8897a.w()) >= Math.abs(this.f8897a.N()) ? this.f8897a.B() ? this.f8897a.y() + 1 : this.f8897a.y() : this.f8897a.v()));
            }
        });
        this.f8865y = new LazyLayoutPrefetchState(prefetchScheduler, new Function1<NestedPrefetchScope, Unit>() { // from class: androidx.compose.foundation.pager.PagerState$prefetchState$1
            {
                super(1);
            }

            public final void c(NestedPrefetchScope nestedPrefetchScope) {
                Snapshot.Companion companion = Snapshot.f24914e;
                PagerState pagerState = this.f8881a;
                Snapshot snapshotD = companion.d();
                Function1 function1G = snapshotD != null ? snapshotD.g() : null;
                Snapshot snapshotE = companion.e(snapshotD);
                try {
                    nestedPrefetchScope.a(pagerState.y());
                    Unit unit = Unit.f139807a;
                } finally {
                    companion.m(snapshotD, snapshotE, function1G);
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((NestedPrefetchScope) obj);
                return Unit.f139807a;
            }
        });
        this.f8866z = new LazyLayoutBeyondBoundsInfo();
        this.A = new AwaitFirstLayoutModifier();
        this.B = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.C = new RemeasurementModifier() { // from class: androidx.compose.foundation.pager.PagerState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void K0(Remeasurement remeasurement) {
                this.f8882a.l0(remeasurement);
            }
        };
        this.D = ConstraintsKt.b(0, 0, 0, 0, 15, null);
        this.E = new LazyLayoutPinnedItemList();
        pagerScrollPosition.d();
        this.F = ObservableScopeInvalidator.c(null, 1, null);
        this.G = ObservableScopeInvalidator.c(null, 1, null);
        Boolean bool = Boolean.FALSE;
        this.H = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.I = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.J = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.K = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int P() {
        return this.f8861u.g();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int T() {
        return this.f8862v.g();
    }

    private final boolean W(float f3) {
        if (C().getOrientation() == Orientation.f6031a) {
            if (Math.signum(f3) == Math.signum(-Float.intBitsToFloat((int) (V() & 4294967295L)))) {
                return true;
            }
        } else if (Math.signum(f3) == Math.signum(-Float.intBitsToFloat((int) (V() >> 32)))) {
            return true;
        }
        return X();
    }

    private final void Z(float f3, PagerLayoutInfo pagerLayoutInfo) {
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle2;
        LazyLayoutPrefetchState.PrefetchHandle prefetchHandle3;
        if (this.f8854n && !pagerLayoutInfo.y().isEmpty()) {
            boolean z2 = f3 > 0.0f;
            int index = z2 ? ((PageInfo) CollectionsKt.last(pagerLayoutInfo.y())).getIndex() + pagerLayoutInfo.D() + 1 : (((PageInfo) CollectionsKt.first(pagerLayoutInfo.y())).getIndex() - pagerLayoutInfo.D()) - 1;
            if (index < 0 || index >= H()) {
                return;
            }
            if (index != this.f8855o) {
                if (this.f8857q != z2 && (prefetchHandle3 = this.f8856p) != null) {
                    prefetchHandle3.cancel();
                }
                this.f8857q = z2;
                this.f8855o = index;
                this.f8856p = this.f8865y.e(index, this.D);
            }
            if (z2) {
                if ((((PageInfo) CollectionsKt.last(pagerLayoutInfo.y())).getOffset() + (pagerLayoutInfo.w() + pagerLayoutInfo.C())) - pagerLayoutInfo.d() >= f3 || (prefetchHandle2 = this.f8856p) == null) {
                    return;
                }
                prefetchHandle2.a();
                return;
            }
            if (pagerLayoutInfo.g() - ((PageInfo) CollectionsKt.first(pagerLayoutInfo.y())).getOffset() >= (-f3) || (prefetchHandle = this.f8856p) == null) {
                return;
            }
            prefetchHandle.a();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float a0(float f3) {
        PagerMeasureResult pagerMeasureResult;
        long jA = PagerScrollPositionKt.a(this);
        float f4 = this.f8849i + f3;
        long jF = MathKt.f(f4);
        this.f8849i = f4 - jF;
        if (Math.abs(f3) < 1.0E-4f) {
            return f3;
        }
        long j3 = jA + jF;
        long jR = RangesKt.r(j3, this.f8848h, this.f8847g);
        boolean z2 = j3 != jR;
        long j4 = jR - jA;
        float f5 = j4;
        this.f8850j = f5;
        if (Math.abs(j4) != 0) {
            this.J.setValue(Boolean.valueOf(f5 > 0.0f));
            this.K.setValue(Boolean.valueOf(f5 < 0.0f));
        }
        int i3 = (int) j4;
        int i4 = -i3;
        PagerMeasureResult pagerMeasureResultE = ((PagerMeasureResult) this.f8858r.getValue()).e(i4);
        if (pagerMeasureResultE != null && (pagerMeasureResult = this.f8842b) != null) {
            PagerMeasureResult pagerMeasureResultE2 = pagerMeasureResult != null ? pagerMeasureResult.e(i4) : null;
            if (pagerMeasureResultE2 != null) {
                this.f8842b = pagerMeasureResultE2;
            } else {
                pagerMeasureResultE = null;
            }
        }
        if (pagerMeasureResultE != null) {
            o(pagerMeasureResultE, this.f8841a, true);
            ObservableScopeInvalidator.f(this.F);
            this.f8853m++;
        } else {
            this.f8844d.a(i3);
            Remeasurement remeasurementQ = Q();
            if (remeasurementQ != null) {
                remeasurementQ.g();
            }
            this.f8852l++;
        }
        return (z2 ? Long.valueOf(j4) : Float.valueOf(f3)).floatValue();
    }

    public static /* synthetic */ void c0(PagerState pagerState, int i3, float f3, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: requestScrollToPage");
        }
        if ((i4 & 2) != 0) {
            f3 = 0.0f;
        }
        pagerState.b0(i3, f3);
    }

    /* JADX WARN: Code restructure failed: missing block: B:23:0x0078, code lost:
    
        if (r8.e(r6, r7, r0) == r1) goto L24;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    static /* synthetic */ java.lang.Object d0(androidx.compose.foundation.pager.PagerState r5, androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof androidx.compose.foundation.pager.PagerState$scroll$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = (androidx.compose.foundation.pager.PagerState$scroll$1) r0
            int r1 = r0.f8890g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8890g = r1
            goto L18
        L13:
            androidx.compose.foundation.pager.PagerState$scroll$1 r0 = new androidx.compose.foundation.pager.PagerState$scroll$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f8888d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f8890g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L4a
            if (r2 == r4) goto L38
            if (r2 != r3) goto L30
            java.lang.Object r5 = r0.f8885a
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.ResultKt.b(r8)
            goto L7b
        L30:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L38:
            java.lang.Object r5 = r0.f8887c
            r7 = r5
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r5 = r0.f8886b
            r6 = r5
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r5 = r0.f8885a
            androidx.compose.foundation.pager.PagerState r5 = (androidx.compose.foundation.pager.PagerState) r5
            kotlin.ResultKt.b(r8)
            goto L5c
        L4a:
            kotlin.ResultKt.b(r8)
            r0.f8885a = r5
            r0.f8886b = r6
            r0.f8887c = r7
            r0.f8890g = r4
            java.lang.Object r8 = r5.q(r0)
            if (r8 != r1) goto L5c
            goto L7a
        L5c:
            boolean r8 = r5.c()
            if (r8 != 0) goto L69
            int r8 = r5.v()
            r5.m0(r8)
        L69:
            androidx.compose.foundation.gestures.ScrollableState r8 = r5.f8851k
            r0.f8885a = r5
            r2 = 0
            r0.f8886b = r2
            r0.f8887c = r2
            r0.f8890g = r3
            java.lang.Object r6 = r8.e(r6, r7, r0)
            if (r6 != r1) goto L7b
        L7a:
            return r1
        L7b:
            r6 = -1
            r5.k0(r6)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.d0(androidx.compose.foundation.pager.PagerState, androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object f0(PagerState pagerState, int i3, float f3, Continuation continuation, int i4, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: scrollToPage");
        }
        if ((i4 & 2) != 0) {
            f3 = 0.0f;
        }
        return pagerState.e0(i3, f3, continuation);
    }

    private final void g0(boolean z2) {
        this.I.setValue(Boolean.valueOf(z2));
    }

    private final void h0(boolean z2) {
        this.H.setValue(Boolean.valueOf(z2));
    }

    private final void k0(int i3) {
        this.f8861u.a(i3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void l0(Remeasurement remeasurement) {
        this.B.setValue(remeasurement);
    }

    private final void m0(int i3) {
        this.f8862v.a(i3);
    }

    public static /* synthetic */ Object n(PagerState pagerState, int i3, float f3, AnimationSpec animationSpec, Continuation continuation, int i4, Object obj) throws Throwable {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateScrollToPage");
        }
        if ((i4 & 2) != 0) {
            f3 = 0.0f;
        }
        if ((i4 & 4) != 0) {
            animationSpec = AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
        }
        return pagerState.m(i3, f3, animationSpec, continuation);
    }

    public static /* synthetic */ void p(PagerState pagerState, PagerMeasureResult pagerMeasureResult, boolean z2, boolean z3, int i3, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: applyMeasureResult");
        }
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        pagerState.o(pagerMeasureResult, z2, z3);
    }

    private final void p0(PagerMeasureResult pagerMeasureResult) {
        Snapshot.Companion companion = Snapshot.f24914e;
        Snapshot snapshotD = companion.d();
        Function1 function1G = snapshotD != null ? snapshotD.g() : null;
        Snapshot snapshotE = companion.e(snapshotD);
        try {
            if (Math.abs(this.f8850j) > 0.5f && this.f8854n && W(this.f8850j)) {
                Z(this.f8850j, pagerMeasureResult);
            }
            Unit unit = Unit.f139807a;
            companion.m(snapshotD, snapshotE, function1G);
        } catch (Throwable th) {
            companion.m(snapshotD, snapshotE, function1G);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object q(Continuation continuation) throws Throwable {
        Object objB = this.A.b(continuation);
        return objB == IntrinsicsKt.f() ? objB : Unit.f139807a;
    }

    private final void r(PagerLayoutInfo pagerLayoutInfo) {
        if (this.f8855o == -1 || pagerLayoutInfo.y().isEmpty()) {
            return;
        }
        if (this.f8855o != (this.f8857q ? ((PageInfo) CollectionsKt.last(pagerLayoutInfo.y())).getIndex() + pagerLayoutInfo.D() + 1 : (((PageInfo) CollectionsKt.first(pagerLayoutInfo.y())).getIndex() - pagerLayoutInfo.D()) - 1)) {
            this.f8855o = -1;
            LazyLayoutPrefetchState.PrefetchHandle prefetchHandle = this.f8856p;
            if (prefetchHandle != null) {
                prefetchHandle.cancel();
            }
            this.f8856p = null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int s(int i3) {
        if (H() > 0) {
            return RangesKt.p(i3, 0, H() - 1);
        }
        return 0;
    }

    public final MutableInteractionSource A() {
        return this.f8860t;
    }

    public boolean B() {
        return ((Boolean) this.J.getValue()).booleanValue();
    }

    public final PagerLayoutInfo C() {
        return (PagerLayoutInfo) this.f8858r.getValue();
    }

    public final long D() {
        return this.f8847g;
    }

    public final MutableState E() {
        return this.G;
    }

    public final long F() {
        return this.f8848h;
    }

    public final IntRange G() {
        return (IntRange) this.f8844d.d().getValue();
    }

    public abstract int H();

    public final int I() {
        return ((PagerMeasureResult) this.f8858r.getValue()).w();
    }

    public final int J() {
        return I() + K();
    }

    public final int K() {
        return ((PagerMeasureResult) this.f8858r.getValue()).C();
    }

    public final LazyLayoutPinnedItemList L() {
        return this.E;
    }

    public final MutableState M() {
        return this.F;
    }

    public final float N() {
        return Math.min(this.f8859s.M1(PagerStateKt.j()), I() / 2.0f) / I();
    }

    public final LazyLayoutPrefetchState O() {
        return this.f8865y;
    }

    public final Remeasurement Q() {
        return (Remeasurement) this.B.getValue();
    }

    public final RemeasurementModifier R() {
        return this.C;
    }

    public final int S() {
        return ((Number) this.f8863w.getValue()).intValue();
    }

    public final int U() {
        return ((Number) this.f8864x.getValue()).intValue();
    }

    public final long V() {
        return ((Offset) this.f8843c.getValue()).u();
    }

    public final boolean X() {
        return ((int) Float.intBitsToFloat((int) (V() >> 32))) == 0 && ((int) Float.intBitsToFloat((int) (V() & 4294967295L))) == 0;
    }

    public final int Y(PagerLazyLayoutItemProvider pagerLazyLayoutItemProvider, int i3) {
        return this.f8844d.e(pagerLazyLayoutItemProvider, i3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float b(float f3) {
        return this.f8851k.b(f3);
    }

    public final void b0(int i3, float f3) {
        if (c()) {
            BuildersKt__Builders_commonKt.d(((PagerMeasureResult) this.f8858r.getValue()).i(), null, null, new PagerState$requestScrollToPage$1(this, null), 3, null);
        }
        o0(i3, f3, false);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean c() {
        return this.f8851k.c();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean d() {
        return ((Boolean) this.I.getValue()).booleanValue();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public Object e(MutatePriority mutatePriority, Function2 function2, Continuation continuation) {
        return d0(this, mutatePriority, function2, continuation);
    }

    public final Object e0(int i3, float f3, Continuation continuation) {
        Object objA = ScrollableState.a(this, null, new PagerState$scrollToPage$2(this, f3, i3, null), continuation, 1, null);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public final boolean f() {
        return ((Boolean) this.H.getValue()).booleanValue();
    }

    public final void i0(Density density) {
        this.f8859s = density;
    }

    public final void j0(long j3) {
        this.D = j3;
    }

    /* JADX WARN: Code restructure failed: missing block: B:40:0x00c2, code lost:
    
        if (androidx.compose.foundation.gestures.ScrollableState.a(r1, null, r3, r4, 1, null) == r0) goto L41;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object m(int r12, float r13, androidx.compose.animation.core.AnimationSpec r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            r11 = this;
            boolean r0 = r15 instanceof androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            if (r0 == 0) goto L14
            r0 = r15
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r0 = (androidx.compose.foundation.pager.PagerState$animateScrollToPage$1) r0
            int r1 = r0.f8873h
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L14
            int r1 = r1 - r2
            r0.f8873h = r1
        L12:
            r4 = r0
            goto L1a
        L14:
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$1 r0 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$1
            r0.<init>(r11, r15)
            goto L12
        L1a:
            java.lang.Object r15 = r4.f8871f
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r4.f8873h
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L48
            if (r1 == r3) goto L37
            if (r1 != r2) goto L2f
            kotlin.ResultKt.b(r15)
            goto Lc5
        L2f:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r13)
            throw r12
        L37:
            float r13 = r4.f8870d
            int r12 = r4.f8869c
            java.lang.Object r14 = r4.f8868b
            androidx.compose.animation.core.AnimationSpec r14 = (androidx.compose.animation.core.AnimationSpec) r14
            java.lang.Object r1 = r4.f8867a
            androidx.compose.foundation.pager.PagerState r1 = (androidx.compose.foundation.pager.PagerState) r1
            kotlin.ResultKt.b(r15)
        L46:
            r9 = r14
            goto L76
        L48:
            kotlin.ResultKt.b(r15)
            int r15 = r11.v()
            if (r12 != r15) goto L5a
            float r15 = r11.w()
            int r15 = (r15 > r13 ? 1 : (r15 == r13 ? 0 : -1))
            if (r15 != 0) goto L5a
            goto L60
        L5a:
            int r15 = r11.H()
            if (r15 != 0) goto L63
        L60:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        L63:
            r4.f8867a = r11
            r4.f8868b = r14
            r4.f8869c = r12
            r4.f8870d = r13
            r4.f8873h = r3
            java.lang.Object r15 = r11.q(r4)
            if (r15 != r0) goto L74
            goto Lc4
        L74:
            r1 = r11
            goto L46
        L76:
            double r14 = (double) r13
            r5 = -4620693217682128896(0xbfe0000000000000, double:-0.5)
            int r5 = (r5 > r14 ? 1 : (r5 == r14 ? 0 : -1))
            r6 = 0
            if (r5 > 0) goto L85
            r7 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            int r14 = (r14 > r7 ? 1 : (r14 == r7 ? 0 : -1))
            if (r14 > 0) goto L85
            goto L86
        L85:
            r3 = r6
        L86:
            if (r3 != 0) goto La1
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r15 = "pageOffsetFraction "
            r14.append(r15)
            r14.append(r13)
            java.lang.String r15 = " is not within the range -0.5 to 0.5"
            r14.append(r15)
            java.lang.String r14 = r14.toString()
            androidx.compose.foundation.internal.InlineClassHelperKt.a(r14)
        La1:
            int r7 = r1.s(r12)
            int r12 = r1.J()
            float r12 = (float) r12
            float r8 = r13 * r12
            androidx.compose.foundation.pager.PagerState$animateScrollToPage$3 r3 = new androidx.compose.foundation.pager.PagerState$animateScrollToPage$3
            r10 = 0
            r6 = r1
            r5 = r3
            r5.<init>(r6, r7, r8, r9, r10)
            r12 = 0
            r4.f8867a = r12
            r4.f8868b = r12
            r4.f8873h = r2
            r2 = 0
            r5 = 1
            r6 = 0
            java.lang.Object r12 = androidx.compose.foundation.gestures.ScrollableState.a(r1, r2, r3, r4, r5, r6)
            if (r12 != r0) goto Lc5
        Lc4:
            return r0
        Lc5:
            kotlin.Unit r12 = kotlin.Unit.f139807a
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.pager.PagerState.m(int, float, androidx.compose.animation.core.AnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void n0(long j3) {
        this.f8843c.setValue(Offset.d(j3));
    }

    public final void o(PagerMeasureResult pagerMeasureResult, boolean z2, boolean z3) {
        if (!z2 && this.f8841a) {
            this.f8842b = pagerMeasureResult;
            return;
        }
        if (z2) {
            this.f8841a = true;
        }
        if (z3) {
            this.f8844d.j(pagerMeasureResult.k());
        } else {
            this.f8844d.k(pagerMeasureResult);
            r(pagerMeasureResult);
        }
        this.f8858r.setValue(pagerMeasureResult);
        h0(pagerMeasureResult.h());
        g0(pagerMeasureResult.f());
        MeasuredPage measuredPageL = pagerMeasureResult.l();
        if (measuredPageL != null) {
            this.f8845e = measuredPageL.getIndex();
        }
        this.f8846f = pagerMeasureResult.m();
        p0(pagerMeasureResult);
        this.f8847g = PagerStateKt.h(pagerMeasureResult, H());
        this.f8848h = PagerStateKt.i(pagerMeasureResult, H());
    }

    public final void o0(int i3, float f3, boolean z2) {
        this.f8844d.f(i3, f3);
        if (!z2) {
            ObservableScopeInvalidator.f(this.G);
            return;
        }
        Remeasurement remeasurementQ = Q();
        if (remeasurementQ != null) {
            remeasurementQ.g();
        }
    }

    public final void q0(ScrollScope scrollScope, int i3) {
        k0(s(i3));
    }

    public final AwaitFirstLayoutModifier t() {
        return this.A;
    }

    public final LazyLayoutBeyondBoundsInfo u() {
        return this.f8866z;
    }

    public final int v() {
        return this.f8844d.b();
    }

    public final float w() {
        return this.f8844d.c();
    }

    public final Density x() {
        return this.f8859s;
    }

    public final int y() {
        return this.f8845e;
    }

    public final int z() {
        return this.f8846f;
    }

    public PagerState(int i3, float f3) {
        this(i3, f3, null);
    }
}
