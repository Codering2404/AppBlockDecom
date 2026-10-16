package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
@Deprecated
@Metadata
public class SwipeableState<T> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Companion f14356q = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationSpec f14357a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f14358b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f14359c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f14360d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableFloatState f14361e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableFloatState f14362f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableFloatState f14363g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f14364h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f14365i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Flow f14366j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f14367k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f14368l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableState f14369m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableFloatState f14370n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MutableState f14371o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final DraggableState f14372p;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public SwipeableState(Object obj, AnimationSpec animationSpec, Function1 function1) {
        this.f14357a = animationSpec;
        this.f14358b = function1;
        this.f14359c = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        this.f14360d = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);
        this.f14361e = PrimitiveSnapshotStateKt.a(0.0f);
        this.f14362f = PrimitiveSnapshotStateKt.a(0.0f);
        this.f14363g = PrimitiveSnapshotStateKt.a(0.0f);
        this.f14364h = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f14365i = SnapshotStateKt__SnapshotStateKt.e(MapsKt.emptyMap(), null, 2, null);
        final Flow flowQ = SnapshotStateKt.q(new Function0<Map<Float, ? extends T>>() { // from class: androidx.compose.material.SwipeableState$latestNonEmptyAnchorsFlow$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map invoke() {
                return this.f14393a.m();
            }
        });
        this.f14366j = FlowKt.i0(new Flow<Map<Float, ? extends T>>() { // from class: androidx.compose.material.SwipeableState$special$$inlined$filter$1

            /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f14413a;

                /* JADX INFO: renamed from: androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.compose.material.SwipeableState$special$$inlined$filter$1$2", f = "Swipeable.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f14414a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f14415b;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f14414a = obj;
                        this.f14415b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f14413a = flowCollector;
                }

                /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
                @Override // kotlinx.coroutines.flow.FlowCollector
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct code enable 'Show inconsistent code' option in preferences
                */
                public final java.lang.Object emit(java.lang.Object r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
                    /*
                        r4 = this;
                        boolean r0 = r6 instanceof androidx.compose.material.SwipeableState$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1 r0 = (androidx.compose.material.SwipeableState$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f14415b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f14415b = r1
                        goto L18
                    L13:
                        androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1 r0 = new androidx.compose.material.SwipeableState$special$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f14414a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f14415b
                        r3 = 1
                        if (r2 == 0) goto L31
                        if (r2 != r3) goto L29
                        kotlin.ResultKt.b(r6)
                        goto L48
                    L29:
                        java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
                        java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
                        r5.<init>(r6)
                        throw r5
                    L31:
                        kotlin.ResultKt.b(r6)
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f14413a
                        r2 = r5
                        java.util.Map r2 = (java.util.Map) r2
                        boolean r2 = r2.isEmpty()
                        if (r2 != 0) goto L48
                        r0.f14415b = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        kotlin.Unit r5 = kotlin.Unit.f139807a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowQ.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        }, 1);
        this.f14367k = Float.NEGATIVE_INFINITY;
        this.f14368l = Float.POSITIVE_INFINITY;
        this.f14369m = SnapshotStateKt__SnapshotStateKt.e(new Function2<Float, Float, Float>() { // from class: androidx.compose.material.SwipeableState$thresholds$2
            public final Float c(float f3, float f4) {
                return Float.valueOf(0.0f);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                return c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
            }
        }, null, 2, null);
        this.f14370n = PrimitiveSnapshotStateKt.a(0.0f);
        this.f14371o = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f14372p = DraggableKt.a(new Function1<Float, Unit>() { // from class: androidx.compose.material.SwipeableState$draggableState$1
            {
                super(1);
            }

            public final void c(float f3) {
                float fC = this.f14392a.f14363g.c() + f3;
                float fO = RangesKt.o(fC, this.f14392a.s(), this.f14392a.r());
                float f4 = fC - fO;
                ResistanceConfig resistanceConfigU = this.f14392a.u();
                this.f14392a.f14361e.s(fO + (resistanceConfigU != null ? resistanceConfigU.a(f4) : 0.0f));
                this.f14392a.f14362f.s(f4);
                this.f14392a.f14363g.s(fC);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                c(((Number) obj2).floatValue());
                return Unit.f139807a;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void C(boolean z2) {
        this.f14360d.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Object obj) {
        this.f14359c.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object H(float f3, Continuation continuation) {
        Object objC = DraggableState.c(this.f14372p, null, new SwipeableState$snapInternalToOffset$2(f3, this, null), continuation, 1, null);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(float f3, AnimationSpec animationSpec, Continuation continuation) {
        Object objC = DraggableState.c(this.f14372p, null, new SwipeableState$animateInternalToOffset$2(this, f3, animationSpec, null), continuation, 1, null);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    public static /* synthetic */ Object k(SwipeableState swipeableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i3 & 2) != 0) {
            animationSpec = swipeableState.f14357a;
        }
        return swipeableState.j(obj, animationSpec, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
    
        if (H(r10, r0) == r1) goto L86;
     */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0218  */
    /* JADX WARN: Type inference failed for: r10v21, types: [float] */
    /* JADX WARN: Type inference failed for: r10v76, types: [float] */
    /* JADX WARN: Type inference failed for: r10v78, types: [float] */
    /* JADX WARN: Type inference failed for: r10v83 */
    /* JADX WARN: Type inference failed for: r10v84 */
    /* JADX WARN: Type inference failed for: r10v85 */
    /* JADX WARN: Type inference failed for: r10v86 */
    /* JADX WARN: Type inference failed for: r2v0, types: [int] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object A(java.util.Map r10, java.util.Map r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 640
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeableState.A(java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void B(Map map) {
        this.f14365i.setValue(map);
    }

    public final void E(ResistanceConfig resistanceConfig) {
        this.f14371o.setValue(resistanceConfig);
    }

    public final void F(Function2 function2) {
        this.f14369m.setValue(function2);
    }

    public final void G(float f3) {
        this.f14370n.s(f3);
    }

    public final Object j(Object obj, AnimationSpec animationSpec, Continuation continuation) {
        Object objCollect = this.f14366j.collect(new SwipeableState$animateTo$2(obj, this, animationSpec), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public final void l(Map map) {
        if (m().isEmpty()) {
            Float fE = SwipeableKt.e(map, p());
            if (fE == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.");
            }
            this.f14361e.s(fE.floatValue());
            this.f14363g.s(fE.floatValue());
        }
    }

    public final Map m() {
        return (Map) this.f14365i.getValue();
    }

    public final AnimationSpec n() {
        return this.f14357a;
    }

    public final Function1 o() {
        return this.f14358b;
    }

    public final Object p() {
        return this.f14359c.getValue();
    }

    public final DraggableState q() {
        return this.f14372p;
    }

    public final float r() {
        return this.f14368l;
    }

    public final float s() {
        return this.f14367k;
    }

    public final State t() {
        return this.f14361e;
    }

    public final ResistanceConfig u() {
        return (ResistanceConfig) this.f14371o.getValue();
    }

    public final Function2 v() {
        return (Function2) this.f14369m.getValue();
    }

    public final float w() {
        return this.f14370n.c();
    }

    public final boolean x() {
        return ((Boolean) this.f14360d.getValue()).booleanValue();
    }

    public final float y(float f3) {
        float fO = RangesKt.o(this.f14363g.c() + f3, this.f14367k, this.f14368l) - this.f14363g.c();
        if (Math.abs(fO) > 0.0f) {
            this.f14372p.b(fO);
        }
        return fO;
    }

    public final Object z(final float f3, Continuation continuation) {
        Object objCollect = this.f14366j.collect(new FlowCollector() { // from class: androidx.compose.material.SwipeableState$performFling$2
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Map map, Continuation continuation2) {
                Float fE = SwipeableKt.e(map, this.f14394a.p());
                Intrinsics.checkNotNull(fE);
                float fFloatValue = fE.floatValue();
                Object obj = map.get(Boxing.c(SwipeableKt.c(((Number) this.f14394a.t().getValue()).floatValue(), fFloatValue, map.keySet(), this.f14394a.v(), f3, this.f14394a.w())));
                if (obj != null && ((Boolean) this.f14394a.o().invoke(obj)).booleanValue()) {
                    Object objK = SwipeableState.k(this.f14394a, obj, null, continuation2, 2, null);
                    return objK == IntrinsicsKt.f() ? objK : Unit.f139807a;
                }
                SwipeableState swipeableState = this.f14394a;
                Object objI = swipeableState.i(fFloatValue, swipeableState.n(), continuation2);
                return objI == IntrinsicsKt.f() ? objI : Unit.f139807a;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public /* synthetic */ SwipeableState(Object obj, AnimationSpec animationSpec, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(obj, (i3 & 2) != 0 ? SwipeableDefaults.f14296a.a() : animationSpec, (i3 & 4) != 0 ? new Function1<T, Boolean>() { // from class: androidx.compose.material.SwipeableState.1
            @Override // kotlin.jvm.functions.Function1
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public final Boolean invoke(Object obj2) {
                return Boolean.TRUE;
            }
        } : function1);
    }
}
