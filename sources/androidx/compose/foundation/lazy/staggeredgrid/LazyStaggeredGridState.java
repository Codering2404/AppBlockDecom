package androidx.compose.foundation.lazy.staggeredgrid;

import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.gestures.ScrollableState;
import androidx.compose.foundation.gestures.ScrollableStateKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier;
import androidx.compose.foundation.lazy.layout.LazyLayoutBeyondBoundsInfo;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemAnimator;
import androidx.compose.foundation.lazy.layout.LazyLayoutItemProvider;
import androidx.compose.foundation.lazy.layout.LazyLayoutPinnedItemList;
import androidx.compose.foundation.lazy.layout.LazyLayoutPrefetchState;
import androidx.compose.foundation.lazy.layout.LazyLayoutScrollDeltaBetweenPasses;
import androidx.compose.foundation.lazy.layout.ObservableScopeInvalidator;
import androidx.compose.foundation.lazy.layout.PrefetchScheduler;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.ListSaverKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.layout.Remeasurement;
import androidx.compose.ui.layout.RemeasurementModifier;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
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
public final class LazyStaggeredGridState implements ScrollableState {

    /* JADX INFO: renamed from: y, reason: collision with root package name */
    public static final Companion f8545y = new Companion(null);

    /* JADX INFO: renamed from: z, reason: collision with root package name */
    private static final Saver f8546z = ListSaverKt.a(new Function2<SaverScope, LazyStaggeredGridState, List<? extends int[]>>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$Companion$Saver$1
        @Override // kotlin.jvm.functions.Function2
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final List invoke(SaverScope saverScope, LazyStaggeredGridState lazyStaggeredGridState) {
            return CollectionsKt.listOf((Object[]) new int[][]{lazyStaggeredGridState.H().d(), lazyStaggeredGridState.H().g()});
        }
    }, new Function1<List<? extends int[]>, LazyStaggeredGridState>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$Companion$Saver$2
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final LazyStaggeredGridState invoke(List list) {
            return new LazyStaggeredGridState((int[]) list.get(0), (int[]) list.get(1), null);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f8547a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private LazyStaggeredGridMeasureResult f8548b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final LazyStaggeredGridScrollPosition f8549c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f8550d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final LazyStaggeredGridLaneInfo f8551e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableState f8552f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableState f8553g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private Remeasurement f8554h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final RemeasurementModifier f8555i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final AwaitFirstLayoutModifier f8556j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private final LazyLayoutBeyondBoundsInfo f8557k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private boolean f8558l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final LazyLayoutPrefetchState f8559m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final ScrollableState f8560n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private float f8561o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private int f8562p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private int f8563q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private final Map f8564r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    private final MutableInteractionSource f8565s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    private final LazyLayoutPinnedItemList f8566t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    private final LazyLayoutItemAnimator f8567u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    private final MutableState f8568v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    private final MutableState f8569w;

    /* JADX INFO: renamed from: x, reason: collision with root package name */
    private final LazyLayoutScrollDeltaBetweenPasses f8570x;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a() {
            return LazyStaggeredGridState.f8546z;
        }

        private Companion() {
        }
    }

    public LazyStaggeredGridState(int[] iArr, int[] iArr2, PrefetchScheduler prefetchScheduler) {
        LazyStaggeredGridScrollPosition lazyStaggeredGridScrollPosition = new LazyStaggeredGridScrollPosition(iArr, iArr2, new LazyStaggeredGridState$scrollPosition$1(this));
        this.f8549c = lazyStaggeredGridScrollPosition;
        this.f8550d = SnapshotStateKt.i(LazyStaggeredGridMeasureResultKt.b(), SnapshotStateKt.k());
        this.f8551e = new LazyStaggeredGridLaneInfo();
        Boolean bool = Boolean.FALSE;
        this.f8552f = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f8553g = SnapshotStateKt__SnapshotStateKt.e(bool, null, 2, null);
        this.f8555i = new RemeasurementModifier() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$remeasurementModifier$1
            @Override // androidx.compose.ui.layout.RemeasurementModifier
            public void K0(Remeasurement remeasurement) {
                this.f8580a.f8554h = remeasurement;
            }
        };
        this.f8556j = new AwaitFirstLayoutModifier();
        this.f8557k = new LazyLayoutBeyondBoundsInfo();
        this.f8558l = true;
        this.f8559m = new LazyLayoutPrefetchState(prefetchScheduler, null, 2, null);
        this.f8560n = ScrollableStateKt.a(new Function1<Float, Float>() { // from class: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scrollableState$1
            {
                super(1);
            }

            public final Float c(float f3) {
                return Float.valueOf(-this.f8593a.K(-f3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).floatValue());
            }
        });
        this.f8563q = -1;
        this.f8564r = new LinkedHashMap();
        this.f8565s = InteractionSourceKt.a();
        this.f8566t = new LazyLayoutPinnedItemList();
        this.f8567u = new LazyLayoutItemAnimator();
        lazyStaggeredGridScrollPosition.e();
        this.f8568v = ObservableScopeInvalidator.c(null, 1, null);
        this.f8569w = ObservableScopeInvalidator.c(null, 1, null);
        this.f8570x = new LazyLayoutScrollDeltaBetweenPasses();
    }

    private final void I(float f3, LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult) {
        int i3;
        if (!this.f8558l || lazyStaggeredGridMeasureResult.h().isEmpty()) {
            return;
        }
        boolean z2 = f3 < 0.0f;
        int index = z2 ? ((LazyStaggeredGridMeasuredItem) CollectionsKt.last(lazyStaggeredGridMeasureResult.h())).getIndex() : ((LazyStaggeredGridMeasuredItem) CollectionsKt.first(lazyStaggeredGridMeasureResult.h())).getIndex();
        if (index == this.f8563q) {
            return;
        }
        this.f8563q = index;
        LinkedHashSet linkedHashSet = new LinkedHashSet();
        LazyStaggeredGridSlots lazyStaggeredGridSlotsP = lazyStaggeredGridMeasureResult.p();
        int length = lazyStaggeredGridSlotsP.b().length;
        for (int i4 = 0; i4 < length; i4++) {
            index = z2 ? this.f8551e.e(index, i4) : this.f8551e.f(index, i4);
            if (index < 0 || index >= lazyStaggeredGridMeasureResult.e() || linkedHashSet.contains(Integer.valueOf(index))) {
                break;
            }
            linkedHashSet.add(Integer.valueOf(index));
            if (!this.f8564r.containsKey(Integer.valueOf(index))) {
                boolean zA = lazyStaggeredGridMeasureResult.q().a(index);
                int i5 = zA ? 0 : i4;
                int i6 = zA ? length : 1;
                if (i6 == 1) {
                    i3 = lazyStaggeredGridSlotsP.b()[i5];
                } else {
                    int i7 = lazyStaggeredGridSlotsP.a()[i5];
                    int i8 = (i5 + i6) - 1;
                    i3 = (lazyStaggeredGridSlotsP.a()[i8] + lazyStaggeredGridSlotsP.b()[i8]) - i7;
                }
                this.f8564r.put(Integer.valueOf(index), this.f8559m.e(index, lazyStaggeredGridMeasureResult.getOrientation() == Orientation.f6031a ? Constraints.f29963b.e(i3) : Constraints.f29963b.d(i3)));
            }
        }
        n(linkedHashSet);
    }

    static /* synthetic */ void J(LazyStaggeredGridState lazyStaggeredGridState, float f3, LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            lazyStaggeredGridMeasureResult = (LazyStaggeredGridMeasureResult) lazyStaggeredGridState.f8550d.getValue();
        }
        lazyStaggeredGridState.I(f3, lazyStaggeredGridMeasureResult);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float K(float f3) {
        LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult;
        if ((f3 < 0.0f && !f()) || (f3 > 0.0f && !d())) {
            return 0.0f;
        }
        if (!(Math.abs(this.f8561o) <= 0.5f)) {
            InlineClassHelperKt.c("entered drag with non-zero pending scroll");
        }
        float f4 = this.f8561o + f3;
        this.f8561o = f4;
        if (Math.abs(f4) > 0.5f) {
            float f5 = this.f8561o;
            int iD = MathKt.d(f5);
            LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResultD = ((LazyStaggeredGridMeasureResult) this.f8550d.getValue()).d(iD, !this.f8547a);
            if (lazyStaggeredGridMeasureResultD != null && (lazyStaggeredGridMeasureResult = this.f8548b) != null) {
                LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResultD2 = lazyStaggeredGridMeasureResult != null ? lazyStaggeredGridMeasureResult.d(iD, true) : null;
                if (lazyStaggeredGridMeasureResultD2 != null) {
                    this.f8548b = lazyStaggeredGridMeasureResultD2;
                } else {
                    lazyStaggeredGridMeasureResultD = null;
                }
            }
            if (lazyStaggeredGridMeasureResultD != null) {
                k(lazyStaggeredGridMeasureResultD, this.f8547a, true);
                ObservableScopeInvalidator.f(this.f8568v);
                I(f5 - this.f8561o, lazyStaggeredGridMeasureResultD);
            } else {
                Remeasurement remeasurement = this.f8554h;
                if (remeasurement != null) {
                    remeasurement.g();
                }
                J(this, f5 - this.f8561o, null, 2, null);
            }
        }
        if (Math.abs(this.f8561o) <= 0.5f) {
            return f3;
        }
        float f6 = f3 - this.f8561o;
        this.f8561o = 0.0f;
        return f6;
    }

    public static /* synthetic */ Object N(LazyStaggeredGridState lazyStaggeredGridState, int i3, int i4, Continuation continuation, int i5, Object obj) {
        if ((i5 & 2) != 0) {
            i4 = 0;
        }
        return lazyStaggeredGridState.M(i3, i4, continuation);
    }

    private void O(boolean z2) {
        this.f8553g.setValue(Boolean.valueOf(z2));
    }

    private void P(boolean z2) {
        this.f8552f.setValue(Boolean.valueOf(z2));
    }

    public static /* synthetic */ void l(LazyStaggeredGridState lazyStaggeredGridState, LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult, boolean z2, boolean z3, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z3 = false;
        }
        lazyStaggeredGridState.k(lazyStaggeredGridMeasureResult, z2, z3);
    }

    private final void m(LazyStaggeredGridLayoutInfo lazyStaggeredGridLayoutInfo) {
        List listH = lazyStaggeredGridLayoutInfo.h();
        if (this.f8563q == -1 || listH.isEmpty()) {
            return;
        }
        int index = ((LazyStaggeredGridItemInfo) CollectionsKt.first(listH)).getIndex();
        int index2 = ((LazyStaggeredGridItemInfo) CollectionsKt.last(listH)).getIndex();
        int i3 = this.f8563q;
        if (index > i3 || i3 > index2) {
            this.f8563q = -1;
            Iterator it = this.f8564r.values().iterator();
            while (it.hasNext()) {
                ((LazyLayoutPrefetchState.PrefetchHandle) it.next()).cancel();
            }
            this.f8564r.clear();
        }
    }

    private final void n(Set set) {
        Iterator it = this.f8564r.entrySet().iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (!set.contains(entry.getKey())) {
                ((LazyLayoutPrefetchState.PrefetchHandle) entry.getValue()).cancel();
                it.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int[] o(int i3, int i4) {
        int[] iArr = new int[i4];
        if (((LazyStaggeredGridMeasureResult) this.f8550d.getValue()).q().a(i3)) {
            ArraysKt.fill$default(iArr, i3, 0, 0, 6, (Object) null);
            return iArr;
        }
        this.f8551e.d(i3 + i4);
        int iH = this.f8551e.h(i3);
        if (iH != -2 && iH != -1) {
            if ((iH >= 0 ? 1 : 0) == 0) {
                InlineClassHelperKt.a("Expected positive lane number, got " + iH + " instead.");
            }
            iMin = Math.min(iH, i4);
        }
        int i5 = iMin;
        int i6 = i5 - 1;
        int iF = i3;
        while (true) {
            if (-1 >= i6) {
                break;
            }
            iF = this.f8551e.f(iF, i6);
            iArr[i6] = iF;
            if (iF == -1) {
                ArraysKt.fill$default(iArr, -1, 0, i6, 2, (Object) null);
                break;
            }
            i6--;
        }
        iArr[i5] = i3;
        for (int i7 = i5 + 1; i7 < i4; i7++) {
            i3 = this.f8551e.e(i3, i7);
            iArr[i7] = i3;
        }
        return iArr;
    }

    public final MutableInteractionSource A() {
        return this.f8565s;
    }

    public final IntRange B() {
        return (IntRange) this.f8549c.e().getValue();
    }

    public final LazyLayoutPinnedItemList C() {
        return this.f8566t;
    }

    public final MutableState D() {
        return this.f8568v;
    }

    public final LazyLayoutPrefetchState E() {
        return this.f8559m;
    }

    public final RemeasurementModifier F() {
        return this.f8555i;
    }

    public final float G() {
        return this.f8570x.b();
    }

    public final LazyStaggeredGridScrollPosition H() {
        return this.f8549c;
    }

    public final float L(boolean z2) {
        return (z2 || !this.f8547a) ? this.f8561o : G();
    }

    public final Object M(int i3, int i4, Continuation continuation) {
        Object objA = ScrollableState.a(this, null, new LazyStaggeredGridState$scrollToItem$2(this, i3, i4, null), continuation, 1, null);
        return objA == IntrinsicsKt.f() ? objA : Unit.f139807a;
    }

    public final void Q(int i3, int i4, boolean z2) {
        boolean z3 = (this.f8549c.c() == i3 && this.f8549c.f() == i4) ? false : true;
        if (z3) {
            this.f8567u.p();
        }
        LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult = (LazyStaggeredGridMeasureResult) this.f8550d.getValue();
        LazyStaggeredGridItemInfo lazyStaggeredGridItemInfoA = LazyStaggeredGridMeasureResultKt.a(lazyStaggeredGridMeasureResult, i3);
        if (lazyStaggeredGridItemInfoA == null || !z3) {
            this.f8549c.h(i3, i4);
        } else {
            int iL = (lazyStaggeredGridMeasureResult.getOrientation() == Orientation.f6031a ? IntOffset.l(lazyStaggeredGridItemInfoA.f()) : IntOffset.k(lazyStaggeredGridItemInfoA.f())) + i4;
            int length = lazyStaggeredGridMeasureResult.n().length;
            int[] iArr = new int[length];
            for (int i5 = 0; i5 < length; i5++) {
                iArr[i5] = lazyStaggeredGridMeasureResult.n()[i5] + iL;
            }
            this.f8549c.m(iArr);
        }
        if (!z2) {
            ObservableScopeInvalidator.f(this.f8569w);
            return;
        }
        Remeasurement remeasurement = this.f8554h;
        if (remeasurement != null) {
            remeasurement.g();
        }
    }

    public final int[] R(LazyLayoutItemProvider lazyLayoutItemProvider, int[] iArr) {
        return this.f8549c.n(lazyLayoutItemProvider, iArr);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public float b(float f3) {
        return this.f8560n.b(f3);
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean c() {
        return this.f8560n.c();
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean d() {
        return ((Boolean) this.f8553g.getValue()).booleanValue();
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
            boolean r0 = r8 instanceof androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1
            if (r0 == 0) goto L13
            r0 = r8
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1 r0 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1) r0
            int r1 = r0.f8588g
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f8588g = r1
            goto L18
        L13:
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1 r0 = new androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState$scroll$1
            r0.<init>(r5, r8)
        L18:
            java.lang.Object r8 = r0.f8586d
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f8588g
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
            java.lang.Object r6 = r0.f8585c
            r7 = r6
            kotlin.jvm.functions.Function2 r7 = (kotlin.jvm.functions.Function2) r7
            java.lang.Object r6 = r0.f8584b
            androidx.compose.foundation.MutatePriority r6 = (androidx.compose.foundation.MutatePriority) r6
            java.lang.Object r2 = r0.f8583a
            androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState r2 = (androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState) r2
            kotlin.ResultKt.b(r8)
            goto L5a
        L45:
            kotlin.ResultKt.b(r8)
            androidx.compose.foundation.lazy.layout.AwaitFirstLayoutModifier r8 = r5.f8556j
            r0.f8583a = r5
            r0.f8584b = r6
            r0.f8585c = r7
            r0.f8588g = r4
            java.lang.Object r8 = r8.b(r0)
            if (r8 != r1) goto L59
            goto L6b
        L59:
            r2 = r5
        L5a:
            androidx.compose.foundation.gestures.ScrollableState r8 = r2.f8560n
            r2 = 0
            r0.f8583a = r2
            r0.f8584b = r2
            r0.f8585c = r2
            r0.f8588g = r3
            java.lang.Object r6 = r8.e(r6, r7, r0)
            if (r6 != r1) goto L6c
        L6b:
            return r1
        L6c:
            kotlin.Unit r6 = kotlin.Unit.f139807a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.lazy.staggeredgrid.LazyStaggeredGridState.e(androidx.compose.foundation.MutatePriority, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // androidx.compose.foundation.gestures.ScrollableState
    public boolean f() {
        return ((Boolean) this.f8552f.getValue()).booleanValue();
    }

    public final void k(LazyStaggeredGridMeasureResult lazyStaggeredGridMeasureResult, boolean z2, boolean z3) {
        if (!z2 && this.f8547a) {
            this.f8548b = lazyStaggeredGridMeasureResult;
            return;
        }
        if (z2) {
            this.f8547a = true;
        }
        this.f8561o -= lazyStaggeredGridMeasureResult.j();
        this.f8550d.setValue(lazyStaggeredGridMeasureResult);
        if (z3) {
            this.f8549c.m(lazyStaggeredGridMeasureResult.n());
        } else {
            this.f8549c.l(lazyStaggeredGridMeasureResult);
            m(lazyStaggeredGridMeasureResult);
        }
        O(lazyStaggeredGridMeasureResult.g());
        P(lazyStaggeredGridMeasureResult.i());
        if (z2) {
            this.f8570x.c(lazyStaggeredGridMeasureResult.o(), lazyStaggeredGridMeasureResult.l(), lazyStaggeredGridMeasureResult.k());
        }
        this.f8562p++;
    }

    public final LazyStaggeredGridMeasureResult p() {
        return this.f8548b;
    }

    public final AwaitFirstLayoutModifier q() {
        return this.f8556j;
    }

    public final LazyLayoutBeyondBoundsInfo r() {
        return this.f8557k;
    }

    public final int s() {
        return this.f8549c.c();
    }

    public final int t() {
        return this.f8549c.f();
    }

    public final boolean u() {
        return this.f8547a;
    }

    public final LazyLayoutItemAnimator v() {
        return this.f8567u;
    }

    public final int w() {
        return ((LazyStaggeredGridMeasureResult) this.f8550d.getValue()).p().b().length;
    }

    public final LazyStaggeredGridLaneInfo x() {
        return this.f8551e;
    }

    public final LazyStaggeredGridLayoutInfo y() {
        return (LazyStaggeredGridLayoutInfo) this.f8550d.getValue();
    }

    public final MutableState z() {
        return this.f8569w;
    }

    public LazyStaggeredGridState(int i3, int i4) {
        this(new int[]{i3}, new int[]{i4}, null);
    }
}
