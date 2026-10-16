package androidx.compose.foundation.lazy.grid;

import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
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
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.math.MathKt;
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
public final class LazyGridState implements ScrollableState {

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    public static final Companion f7905x = new Companion(null);

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    private static final Saver f7906y = ListSaverKt.a(new Function2<SaverScope, LazyGridState, List<? extends Integer>>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List invoke(SaverScope saverScope, LazyGridState lazyGridState) {
            return CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(lazyGridState.r()), Integer.valueOf(lazyGridState.s())});
        }
    }, new Function1<List<? extends Integer>, LazyGridState>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LazyGridState invoke(List list) {
            return new LazyGridState(((Number) list.get(0)).intValue(), ((Number) list.get(1)).intValue());
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final LazyGridPrefetchStrategy f7907a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private boolean f7908b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private LazyGridMeasureResult f7909c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final LazyGridScrollPosition f7910d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableState f7911e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableInteractionSource f7912f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private float f7913g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final ScrollableState f7914h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f7915i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private boolean f7916j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private Remeasurement f7917k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private final RemeasurementModifier f7918l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final AwaitFirstLayoutModifier f7919m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final LazyLayoutItemAnimator f7920n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final LazyLayoutBeyondBoundsInfo f7921o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final LazyLayoutPrefetchState f7922p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private final LazyGridPrefetchScope f7923q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final LazyLayoutPinnedItemList f7924r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableState f7925s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final MutableState f7926t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final MutableState f7927u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MutableState f7928v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final LazyLayoutScrollDeltaBetweenPasses f7929w;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return LazyGridState.f7906y;
        }

        private Companion() {
        }
    }

    public LazyGridState(final int i3, int i4, LazyGridPrefetchStrategy lazyGridPrefetchStrategy) {
        this.f7907a = lazyGridPrefetchStrategy;
        LazyGridScrollPosition lazyGridScrollPosition = new LazyGridScrollPosition(i3, i4);
        this.f7910d = lazyGridScrollPosition;
        this.f7911e = SnapshotStateKt.i(LazyGridStateKt.f7956a, SnapshotStateKt.k());
        this.f7912f = InteractionSourceKt.a();
        this.f7914h = ScrollableStateKt.a(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$scrollableState$1
            {
                super(1);
            }

            public final Float c(float f3) {
                return Float.valueOf(-this.f7955a.I(-f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        });
        this.f7916j = true;
        this.f7918l = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void K0(Remeasurement remeasurement) {
                this.f7942a.f7917k = remeasurement;
            }
        };
        this.f7919m = new AwaitFirstLayoutModifier();
        this.f7920n = new LazyLayoutItemAnimator();
        this.f7921o = new LazyLayoutBeyondBoundsInfo();
        this.f7922p = new LazyLayoutPrefetchState(lazyGridPrefetchStrategy.b(), new Function1<NestedPrefetchScope, Unit>() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$prefetchState$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(NestedPrefetchScope nestedPrefetchScope) {
                LazyGridPrefetchStrategy lazyGridPrefetchStrategy2 = this.f7940a.f7907a;
                int i5 = i3;
                Snapshot.Companion companion = Snapshot.f24914e;
                Snapshot snapshotD = companion.d();
                companion.m(snapshotD, companion.e(snapshotD), snapshotD != null ? snapshotD.g() : null);
                lazyGridPrefetchStrategy2.a(nestedPrefetchScope, i5);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((NestedPrefetchScope) obj);
                return Unit.f139807a;
            }
        });
        this.f7923q = new LazyGridPrefetchScope() { // from class: androidx.compose.foundation.lazy.grid.LazyGridState$prefetchScope$1
            @Override // androidx.compose.foundation.lazy.grid.LazyGridPrefetchScope
            public List a(int i5) {
                ArrayList arrayList = new ArrayList();
                Snapshot.Companion companion = Snapshot.f24914e;
                LazyGridState lazyGridState = this.f7939a;
                Snapshot snapshotD = companion.d();
                Function1 function1G = snapshotD != null ? snapshotD.g() : null;
                Snapshot snapshotE = companion.e(snapshotD);
                try {
                    LazyGridMeasureResult lazyGridMeasureResultN = lazyGridState.t() ? lazyGridState.n() : (LazyGridMeasureResult) lazyGridState.f7911e.getValue();
                    if (lazyGridMeasureResultN != null) {
                        List list = (List) lazyGridMeasureResultN.q().invoke(Integer.valueOf(i5));
                        int size = list.size();
                        for (int i6 = 0; i6 < size; i6++) {
                            Pair pair = (Pair) list.get(i6);
                            arrayList.add(lazyGridState.C().e(((Number) pair.e()).intValue(), ((Constraints) pair.f()).r()));
                        }
                        Unit unit = Unit.f139807a;
                    }
                    companion.m(snapshotD, snapshotE, function1G);
                    return arrayList;
                } catch (Throwable th) {
                    companion.m(snapshotD, snapshotE, function1G);
                    throw th;
                }
            }
        };
        this.f7924r = new LazyLayoutPinnedItemList();
        lazyGridScrollPosition.b();
        this.f7925s = ObservableScopeInvalidator.c(null, 1, null);
        this.f7926t = ObservableScopeInvalidator.c(null, 1, null);
        Boolean bool = Boolean.FALSE;
        this.f7927u = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f7928v = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f7929w = new LazyLayoutScrollDeltaBetweenPasses();
    }

    private final void H(float f3, LazyGridLayoutInfo lazyGridLayoutInfo) {
        if (this.f7916j) {
            this.f7907a.c(this.f7923q, f3, lazyGridLayoutInfo);
        }
    }

    public static /* synthetic */ Object K(LazyGridState lazyGridState, int i3, int i4, Continuation continuation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return lazyGridState.J(i3, i4, continuation);
    }

    private void L(boolean z2) {
        this.f7928v.setValue(Boolean.valueOf(z2));
    }

    private void M(boolean z2) {
        this.f7927u.setValue(Boolean.valueOf(z2));
    }

    public static /* synthetic */ void m(LazyGridState lazyGridState, LazyGridMeasureResult lazyGridMeasureResult, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        lazyGridState.l(lazyGridMeasureResult, z2, z3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int z() {
        return G() * 100;
    }

    public final LazyLayoutPinnedItemList A() {
        return this.f7924r;
    }

    public final MutableState B() {
        return this.f7925s;
    }

    public final LazyLayoutPrefetchState C() {
        return this.f7922p;
    }

    public final RemeasurementModifier D() {
        return this.f7918l;
    }

    public final float E() {
        return this.f7929w.b();
    }

    public final float F() {
        return this.f7913g;
    }

    public final int G() {
        return ((LazyGridMeasureResult) this.f7911e.getValue()).t();
    }

    public final float I(float f3) {
        LazyGridMeasureResult lazyGridMeasureResult;
        if ((f3 < 0.0f && !f()) || (f3 > 0.0f && !d())) {
            return 0.0f;
        }
        if (!(Math.abs(this.f7913g) <= 0.5f)) {
            InlineClassHelperKt.c("entered drag with non-zero pending scroll");
        }
        float f4 = this.f7913g + f3;
        this.f7913g = f4;
        if (Math.abs(f4) > 0.5f) {
            float f5 = this.f7913g;
            int iD = MathKt.d(f5);
            LazyGridMeasureResult lazyGridMeasureResultI = ((LazyGridMeasureResult) this.f7911e.getValue()).i(iD, !this.f7908b);
            if (lazyGridMeasureResultI != null && (lazyGridMeasureResult = this.f7909c) != null) {
                LazyGridMeasureResult lazyGridMeasureResultI2 = lazyGridMeasureResult != null ? lazyGridMeasureResult.i(iD, true) : null;
                if (lazyGridMeasureResultI2 != null) {
                    this.f7909c = lazyGridMeasureResultI2;
                } else {
                    lazyGridMeasureResultI = null;
                }
            }
            if (lazyGridMeasureResultI != null) {
                l(lazyGridMeasureResultI, this.f7908b, true);
                ObservableScopeInvalidator.f(this.f7925s);
                H(f5 - this.f7913g, lazyGridMeasureResultI);
            } else {
                Remeasurement remeasurement = this.f7917k;
                if (remeasurement != null) {
                    remeasurement.g();
                }
                H(f5 - this.f7913g, w());
            }
        }
        if (Math.abs(this.f7913g) <= 0.5f) {
            return f3;
        }
        float f6 = f3 - this.f7913g;
        this.f7913g = 0.0f;
        return f6;
    }

    public final Object J(int i3, int i4, Continuation continuation) {
        Object objA = ScrollableState.a(this, null, new LazyGridState$scrollToItem$2(this, i3, i4, null), continuation, 1, null);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final void N(int i3, int i4, boolean z2) {
        if (this.f7910d.a() != i3 || this.f7910d.c() != i4) {
            this.f7920n.p();
        }
        this.f7910d.d(i3, i4);
        if (!z2) {
            ObservableScopeInvalidator.f(this.f7926t);
            return;
        }
        Remeasurement remeasurement = this.f7917k;
        if (remeasurement != null) {
            remeasurement.g();
        }
    }

    public final int O(LazyGridItemProvider lazyGridItemProvider, int i3) {
        return this.f7910d.j(lazyGridItemProvider, i3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float b(float f3) {
        return this.f7914h.b(f3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean c() {
        return this.f7914h.c();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean d() {
        return ((Boolean) this.f7928v.getValue()).booleanValue();
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
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1 r0 = (androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1) r0
            int r1 = r0.f7950g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f7950g = r1
            goto L18
        L13:
            androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1 r0 = new androidx.compose.foundation.lazy.grid.LazyGridState$scroll$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f7948d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f7950g
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
            java.lang.Object r6 = r0.f7947c
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r6 = r0.f7946b
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r2 = r0.f7945a
            androidx.compose.foundation.lazy.grid.LazyGridState r2 = (androidx.compose.foundation.lazy.grid.LazyGridState) r2
            kotlin.ResultKt.b(r8)
            goto L5a
        L45:
            kotlin.ResultKt.b(r8)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r8 = r5.f7919m
            r0.f7945a = r5
            r0.f7946b = r6
            r0.f7947c = r7
            r0.f7950g = r4
            java.lang.Object r8 = r8.b(r0)
            if (r8 != r1) goto L59
            goto L6b
        L59:
            r2 = r5
        L5a:
            androidx.compose.foundation.gestures.ScrollableState r8 = r2.f7914h
            r2 = 0
            r0.f7945a = r2
            r0.f7946b = r2
            r0.f7947c = r2
            r0.f7950g = r3
            java.lang.Object r6 = r8.e(r6, r7, r0)
            if (r6 != r1) goto L6c
        L6b:
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.grid.LazyGridState.e(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean f() {
        return ((Boolean) this.f7927u.getValue()).booleanValue();
    }

    public final void l(LazyGridMeasureResult lazyGridMeasureResult, boolean z2, boolean z3) {
        if (!z2 && this.f7908b) {
            this.f7909c = lazyGridMeasureResult;
            return;
        }
        if (z2) {
            this.f7908b = true;
        }
        this.f7913g -= lazyGridMeasureResult.l();
        this.f7911e.setValue(lazyGridMeasureResult);
        L(lazyGridMeasureResult.j());
        M(lazyGridMeasureResult.k());
        if (z3) {
            this.f7910d.i(lazyGridMeasureResult.p());
        } else {
            this.f7910d.h(lazyGridMeasureResult);
            if (this.f7916j) {
                this.f7907a.d(this.f7923q, lazyGridMeasureResult);
            }
        }
        if (z2) {
            this.f7929w.c(lazyGridMeasureResult.s(), lazyGridMeasureResult.n(), lazyGridMeasureResult.m());
        }
        this.f7915i++;
    }

    public final LazyGridMeasureResult n() {
        return this.f7909c;
    }

    public final AwaitFirstLayoutModifier o() {
        return this.f7919m;
    }

    public final LazyLayoutBeyondBoundsInfo p() {
        return this.f7921o;
    }

    public final Density q() {
        return ((LazyGridMeasureResult) this.f7911e.getValue()).n();
    }

    public final int r() {
        return this.f7910d.a();
    }

    public final int s() {
        return this.f7910d.c();
    }

    public final boolean t() {
        return this.f7908b;
    }

    public final MutableInteractionSource u() {
        return this.f7912f;
    }

    public final LazyLayoutItemAnimator v() {
        return this.f7920n;
    }

    public final LazyGridLayoutInfo w() {
        return (LazyGridLayoutInfo) this.f7911e.getValue();
    }

    public final MutableState x() {
        return this.f7926t;
    }

    public final IntRange y() {
        return (IntRange) this.f7910d.b().getValue();
    }

    public LazyGridState(int i3, int i4) {
        this(i3, i4, LazyGridPrefetchStrategyKt.b(0, 1, null));
    }
}
