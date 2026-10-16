package androidx.compose.foundation.lazy;

import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.NestedPrefetchScope;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Density;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.ranges.IntRange;

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
public final class LazyListState implements ScrollableState {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Companion f7563x = new Companion(null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Saver f7564y = ListSaverKt.a(new Function2<SaverScope, LazyListState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List invoke(SaverScope saverScope, LazyListState lazyListState) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyListState.s()), Integer.valueOf(lazyListState.t())});
        }
    }, new Function1<List<? extends Integer>, LazyListState>() { // from class: androidx.compose.foundation.lazy.LazyListState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LazyListState invoke(List list) {
            return new LazyListState(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyListPrefetchStrategy f7565a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7566b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LazyListMeasureResult f7567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LazyListScrollPosition f7568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f7569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableInteractionSource f7570f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f7571g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ScrollableState f7572h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7573i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7574j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Remeasurement f7575k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final RemeasurementModifier f7576l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AwaitFirstLayoutModifier f7577m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final LazyLayoutItemAnimator f7578n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final LazyLayoutBeyondBoundsInfo f7579o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final LazyLayoutPrefetchState f7580p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final LazyListPrefetchScope f7581q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final LazyLayoutPinnedItemList f7582r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableState f7583s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MutableState f7584t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MutableState f7585u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MutableState f7586v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final LazyLayoutScrollDeltaBetweenPasses f7587w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return LazyListState.f7564y;
        }

        private Companion() {
        }
    }

    public LazyListState(final int i3, int i4, LazyListPrefetchStrategy lazyListPrefetchStrategy) {
        this.f7565a = lazyListPrefetchStrategy;
        LazyListScrollPosition lazyListScrollPosition = new LazyListScrollPosition(i3, i4);
        this.f7568d = lazyListScrollPosition;
        this.f7569e = SnapshotStateKt.i(LazyListStateKt.f7615a, SnapshotStateKt.k());
        this.f7570f = InteractionSourceKt.a();
        this.f7572h = ScrollableStateKt.a(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.LazyListState$scrollableState$1
            {
                super(1);
            }

            public final Float c(float f3) {
                return Float.valueOf(-this.f7614a.I(-f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        });
        this.f7574j = true;
        this.f7576l = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.LazyListState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void K0(Remeasurement remeasurement) {
                this.f7600a.f7575k = remeasurement;
            }
        };
        this.f7577m = new AwaitFirstLayoutModifier();
        this.f7578n = new LazyLayoutItemAnimator();
        this.f7579o = new LazyLayoutBeyondBoundsInfo();
        this.f7580p = new LazyLayoutPrefetchState(lazyListPrefetchStrategy.b(), new Function1<NestedPrefetchScope, Unit>() { // from class: androidx.compose.foundation.lazy.LazyListState$prefetchState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(NestedPrefetchScope nestedPrefetchScope) {
                LazyListPrefetchStrategy lazyListPrefetchStrategy2 = this.f7598a.f7565a;
                int i5 = i3;
                Snapshot.Companion companion = Snapshot.f24914e;
                Snapshot snapshotD = companion.d();
                companion.m(snapshotD, companion.e(snapshotD), snapshotD != null ? snapshotD.g() : null);
                lazyListPrefetchStrategy2.a(nestedPrefetchScope, i5);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((NestedPrefetchScope) obj);
                return Unit.f139807a;
            }
        });
        this.f7581q = new LazyListPrefetchScope() { // from class: androidx.compose.foundation.lazy.LazyListState$prefetchScope$1
            @Override // androidx.compose.foundation.lazy.LazyListPrefetchScope
            public LazyLayoutPrefetchState.PrefetchHandle a(int i5) {
                Snapshot.Companion companion = Snapshot.f24914e;
                LazyListState lazyListState = this.f7597a;
                Snapshot snapshotD = companion.d();
                Function1 function1G = snapshotD != null ? snapshotD.g() : null;
                Snapshot snapshotE = companion.e(snapshotD);
                try {
                    long jL = ((LazyListMeasureResult) lazyListState.f7569e.getValue()).l();
                    companion.m(snapshotD, snapshotE, function1G);
                    return this.f7597a.D().e(i5, jL);
                } catch (Throwable th) {
                    companion.m(snapshotD, snapshotE, function1G);
                    throw th;
                }
            }
        };
        this.f7582r = new LazyLayoutPinnedItemList();
        lazyListScrollPosition.b();
        this.f7583s = ObservableScopeInvalidator.c(null, 1, null);
        Boolean bool = Boolean.FALSE;
        this.f7584t = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f7585u = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f7586v = ObservableScopeInvalidator.c(null, 1, null);
        this.f7587w = new LazyLayoutScrollDeltaBetweenPasses();
    }

    private final void H(float f3, LazyListLayoutInfo lazyListLayoutInfo) {
        if (this.f7574j) {
            this.f7565a.c(this.f7581q, f3, lazyListLayoutInfo);
        }
    }

    public static /* synthetic */ Object K(LazyListState lazyListState, int i3, int i4, Continuation continuation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return lazyListState.J(i3, i4, continuation);
    }

    private void L(boolean z2) {
        this.f7585u.setValue(Boolean.valueOf(z2));
    }

    private void M(boolean z2) {
        this.f7584t.setValue(Boolean.valueOf(z2));
    }

    public static /* synthetic */ Object l(LazyListState lazyListState, int i3, int i4, Continuation continuation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return lazyListState.k(i3, i4, continuation);
    }

    public static /* synthetic */ void n(LazyListState lazyListState, LazyListMeasureResult lazyListMeasureResult, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        lazyListState.m(lazyListMeasureResult, z2, z3);
    }

    public final IntRange A() {
        return (IntRange) this.f7568d.b().getValue();
    }

    public final LazyLayoutPinnedItemList B() {
        return this.f7582r;
    }

    public final MutableState C() {
        return this.f7586v;
    }

    public final LazyLayoutPrefetchState D() {
        return this.f7580p;
    }

    public final RemeasurementModifier E() {
        return this.f7576l;
    }

    public final float F() {
        return this.f7587w.b();
    }

    public final float G() {
        return this.f7571g;
    }

    public final float I(float f3) {
        LazyListMeasureResult lazyListMeasureResult;
        if ((f3 < 0.0f && !f()) || (f3 > 0.0f && !d())) {
            return 0.0f;
        }
        if (!(Math.abs(this.f7571g) <= 0.5f)) {
            InlineClassHelperKt.c("entered drag with non-zero pending scroll");
        }
        float f4 = this.f7571g + f3;
        this.f7571g = f4;
        if (Math.abs(f4) > 0.5f) {
            float f5 = this.f7571g;
            int iRound = Math.round(f5);
            LazyListMeasureResult lazyListMeasureResultI = ((LazyListMeasureResult) this.f7569e.getValue()).i(iRound, !this.f7566b);
            if (lazyListMeasureResultI != null && (lazyListMeasureResult = this.f7567c) != null) {
                LazyListMeasureResult lazyListMeasureResultI2 = lazyListMeasureResult != null ? lazyListMeasureResult.i(iRound, true) : null;
                if (lazyListMeasureResultI2 != null) {
                    this.f7567c = lazyListMeasureResultI2;
                } else {
                    lazyListMeasureResultI = null;
                }
            }
            if (lazyListMeasureResultI != null) {
                m(lazyListMeasureResultI, this.f7566b, true);
                ObservableScopeInvalidator.f(this.f7586v);
                H(f5 - this.f7571g, lazyListMeasureResultI);
            } else {
                Remeasurement remeasurement = this.f7575k;
                if (remeasurement != null) {
                    remeasurement.g();
                }
                H(f5 - this.f7571g, y());
            }
        }
        if (Math.abs(this.f7571g) <= 0.5f) {
            return f3;
        }
        float f6 = f3 - this.f7571g;
        this.f7571g = 0.0f;
        return f6;
    }

    public final Object J(int i3, int i4, Continuation continuation) {
        Object objA = ScrollableState.a(this, null, new LazyListState$scrollToItem$2(this, i3, i4, null), continuation, 1, null);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final void N(int i3, int i4, boolean z2) {
        if (this.f7568d.a() != i3 || this.f7568d.c() != i4) {
            this.f7578n.p();
        }
        this.f7568d.d(i3, i4);
        if (!z2) {
            ObservableScopeInvalidator.f(this.f7583s);
            return;
        }
        Remeasurement remeasurement = this.f7575k;
        if (remeasurement != null) {
            remeasurement.g();
        }
    }

    public final int O(LazyListItemProvider lazyListItemProvider, int i3) {
        return this.f7568d.j(lazyListItemProvider, i3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float b(float f3) {
        return this.f7572h.b(f3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean c() {
        return this.f7572h.c();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean d() {
        return ((Boolean) this.f7585u.getValue()).booleanValue();
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0069, code lost:
    
        if (r8.e(r6, r7, r0) == r1) goto L22;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // androidx.compose.foundation.gestures.ScrollableState
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public java.lang.Object e(androidx.compose.foundation.MutatePriority r6, kotlin.jvm.functions.Function2 r7, kotlin.coroutines.Continuation r8) throws java.lang.Throwable {
        /*
            r5 = this;
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.LazyListState$scroll$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = (androidx.compose.foundation.lazy.LazyListState$scroll$1) r0
            int r1 = r0.f7609g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7609g = r1
            goto L18
        L13:
            androidx.compose.foundation.lazy.LazyListState$scroll$1 r0 = new androidx.compose.foundation.lazy.LazyListState$scroll$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f7607d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f7609g
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L45
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.b(r8)
            goto L6c
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L34:
            java.lang.Object r6 = r0.f7606c
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r6 = r0.f7605b
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r2 = r0.f7604a
            androidx.compose.foundation.lazy.LazyListState r2 = (androidx.compose.foundation.lazy.LazyListState) r2
            kotlin.ResultKt.b(r8)
            goto L5a
        L45:
            kotlin.ResultKt.b(r8)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r8 = r5.f7577m
            r0.f7604a = r5
            r0.f7605b = r6
            r0.f7606c = r7
            r0.f7609g = r4
            java.lang.Object r8 = r8.b(r0)
            if (r8 != r1) goto L59
            goto L6b
        L59:
            r2 = r5
        L5a:
            androidx.compose.foundation.gestures.ScrollableState r8 = r2.f7572h
            r2 = 0
            r0.f7604a = r2
            r0.f7605b = r2
            r0.f7606c = r2
            r0.f7609g = r3
            java.lang.Object r6 = r8.e(r6, r7, r0)
            if (r6 != r1) goto L6c
        L6b:
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.LazyListState.e(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean f() {
        return ((Boolean) this.f7584t.getValue()).booleanValue();
    }

    public final Object k(int i3, int i4, Continuation continuation) {
        Object objA = ScrollableState.a(this, null, new LazyListState$animateScrollToItem$2(this, i3, i4, null), continuation, 1, null);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final void m(LazyListMeasureResult lazyListMeasureResult, boolean z2, boolean z3) {
        if (!z2 && this.f7566b) {
            this.f7567c = lazyListMeasureResult;
            return;
        }
        if (z2) {
            this.f7566b = true;
        }
        L(lazyListMeasureResult.j());
        M(lazyListMeasureResult.k());
        this.f7571g -= lazyListMeasureResult.m();
        this.f7569e.setValue(lazyListMeasureResult);
        if (z3) {
            this.f7568d.i(lazyListMeasureResult.q());
        } else {
            this.f7568d.h(lazyListMeasureResult);
            if (this.f7574j) {
                this.f7565a.d(this.f7581q, lazyListMeasureResult);
            }
        }
        if (z2) {
            this.f7587w.c(lazyListMeasureResult.s(), lazyListMeasureResult.o(), lazyListMeasureResult.n());
        }
        this.f7573i++;
    }

    public final LazyListMeasureResult o() {
        return this.f7567c;
    }

    public final AwaitFirstLayoutModifier p() {
        return this.f7577m;
    }

    public final LazyLayoutBeyondBoundsInfo q() {
        return this.f7579o;
    }

    public final Density r() {
        return ((LazyListMeasureResult) this.f7569e.getValue()).o();
    }

    public final int s() {
        return this.f7568d.a();
    }

    public final int t() {
        return this.f7568d.c();
    }

    public final boolean u() {
        return this.f7566b;
    }

    public final InteractionSource v() {
        return this.f7570f;
    }

    public final MutableInteractionSource w() {
        return this.f7570f;
    }

    public final LazyLayoutItemAnimator x() {
        return this.f7578n;
    }

    public final LazyListLayoutInfo y() {
        return (LazyListLayoutInfo) this.f7569e.getValue();
    }

    public final MutableState z() {
        return this.f7583s;
    }

    public LazyListState(int i3, int i4) {
        this(i3, i4, LazyListPrefetchStrategyKt.b(0, 1, null));
    }
}
