package androidx.constraintlayout.compose.carousel;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.DraggableKt;
import androidx.compose.foundation.gestures.DraggableState;
import androidx.compose.runtime.FloatState;
import androidx.compose.runtime.MutableFloatState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PrimitiveSnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import java.util.Map;
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
import kotlin.jvm.internal.Lambda;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
public class CarouselSwipeableState<T> {

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public static final Companion f31072q = new Companion(null);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final AnimationSpec f31073a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Function1 f31074b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final MutableState f31075c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final MutableState f31076d = SnapshotStateKt__SnapshotStateKt.e(Boolean.FALSE, null, 2, null);

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final MutableFloatState f31077e = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final MutableFloatState f31078f = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private final MutableFloatState f31079g = PrimitiveSnapshotStateKt.a(0.0f);

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private final MutableState f31080h = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private final MutableState f31081i = SnapshotStateKt__SnapshotStateKt.e(MapsKt.emptyMap(), null, 2, null);

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private final Flow f31082j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private float f31083k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private float f31084l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private final MutableState f31085m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private final MutableFloatState f31086n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private final MutableState f31087o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private final DraggableState f31088p;

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    final class AnonymousClass1 extends Lambda implements Function1<Object, Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final AnonymousClass1 f31089a = new AnonymousClass1();

        AnonymousClass1() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(Object obj) {
            return Boolean.TRUE;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Saver a(final AnimationSpec animationSpec, final Function1 function1) {
            return SaverKt.a(new Function2<SaverScope, CarouselSwipeableState<Object>, Object>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$Companion$Saver$1
                @Override // kotlin.jvm.functions.Function2
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final Object invoke(SaverScope saverScope, CarouselSwipeableState carouselSwipeableState) {
                    return carouselSwipeableState.p();
                }
            }, new Function1<Object, CarouselSwipeableState<Object>>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$Companion$Saver$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public final CarouselSwipeableState invoke(Object obj) {
                    return new CarouselSwipeableState(obj, animationSpec, function1);
                }
            });
        }

        private Companion() {
        }
    }

    public CarouselSwipeableState(Object obj, AnimationSpec animationSpec, Function1 function1) {
        this.f31073a = animationSpec;
        this.f31074b = function1;
        this.f31075c = SnapshotStateKt__SnapshotStateKt.e(obj, null, 2, null);
        final Flow flowQ = SnapshotStateKt.q(new Function0<Map<Float, ? extends T>>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$latestNonEmptyAnchorsFlow$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Map invoke() {
                return this.f31109a.m();
            }
        });
        this.f31082j = FlowKt.i0(new Flow<Map<Float, ? extends T>>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1

            /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2, reason: invalid class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            public static final class AnonymousClass2<T> implements FlowCollector {

                /* JADX INFO: renamed from: a, reason: collision with root package name */
                final /* synthetic */ FlowCollector f31129a;

                /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2$1, reason: invalid class name */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                @DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2", f = "CarouselSwipeable.kt", l = {223}, m = "emit")
                public static final class AnonymousClass1 extends ContinuationImpl {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    /* synthetic */ Object f31130a;

                    /* JADX INFO: renamed from: b, reason: collision with root package name */
                    int f31131b;

                    public AnonymousClass1(Continuation continuation) {
                        super(continuation);
                    }

                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                    public final Object invokeSuspend(Object obj) {
                        this.f31130a = obj;
                        this.f31131b |= Integer.MIN_VALUE;
                        return AnonymousClass2.this.emit(null, this);
                    }
                }

                public AnonymousClass2(FlowCollector flowCollector) {
                    this.f31129a = flowCollector;
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
                        boolean r0 = r6 instanceof androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1
                        if (r0 == 0) goto L13
                        r0 = r6
                        androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2$1 r0 = (androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1.AnonymousClass2.AnonymousClass1) r0
                        int r1 = r0.f31131b
                        r2 = -2147483648(0xffffffff80000000, float:-0.0)
                        r3 = r1 & r2
                        if (r3 == 0) goto L13
                        int r1 = r1 - r2
                        r0.f31131b = r1
                        goto L18
                    L13:
                        androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2$1 r0 = new androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1$2$1
                        r0.<init>(r6)
                    L18:
                        java.lang.Object r6 = r0.f31130a
                        java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                        int r2 = r0.f31131b
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
                        kotlinx.coroutines.flow.FlowCollector r6 = r4.f31129a
                        r2 = r5
                        java.util.Map r2 = (java.util.Map) r2
                        boolean r2 = r2.isEmpty()
                        if (r2 != 0) goto L48
                        r0.f31131b = r3
                        java.lang.Object r5 = r6.emit(r5, r0)
                        if (r5 != r1) goto L48
                        return r1
                    L48:
                        kotlin.Unit r5 = kotlin.Unit.f139807a
                        return r5
                    */
                    throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$special$$inlined$filter$1.AnonymousClass2.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
                }
            }

            @Override // kotlinx.coroutines.flow.Flow
            public Object collect(FlowCollector flowCollector, Continuation continuation) {
                Object objCollect = flowQ.collect(new AnonymousClass2(flowCollector), continuation);
                return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
            }
        }, 1);
        this.f31083k = Float.NEGATIVE_INFINITY;
        this.f31084l = Float.POSITIVE_INFINITY;
        this.f31085m = SnapshotStateKt__SnapshotStateKt.e(new Function2<Float, Float, Float>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$thresholds$2
            public final Float c(float f3, float f4) {
                return Float.valueOf(0.0f);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                return c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
            }
        }, null, 2, null);
        this.f31086n = PrimitiveSnapshotStateKt.a(0.0f);
        this.f31087o = SnapshotStateKt__SnapshotStateKt.e(null, null, 2, null);
        this.f31088p = DraggableKt.a(new Function1<Float, Unit>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$draggableState$1
            {
                super(1);
            }

            public final void c(float f3) {
                float fC = this.f31108a.f31079g.c() + f3;
                float fO = RangesKt.o(fC, this.f31108a.s(), this.f31108a.r());
                float f4 = fC - fO;
                ResistanceConfig resistanceConfigU = this.f31108a.u();
                this.f31108a.f31077e.s(fO + (resistanceConfigU != null ? resistanceConfigU.a(f4) : 0.0f));
                this.f31108a.f31078f.s(f4);
                this.f31108a.f31079g.s(fC);
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
        this.f31076d.setValue(Boolean.valueOf(z2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void D(Object obj) {
        this.f31075c.setValue(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object H(float f3, Continuation continuation) {
        Object objC = DraggableState.c(this.f31088p, null, new CarouselSwipeableState$snapInternalToOffset$2(f3, this, null), continuation, 1, null);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object i(float f3, AnimationSpec animationSpec, Continuation continuation) {
        Object objC = DraggableState.c(this.f31088p, null, new CarouselSwipeableState$animateInternalToOffset$2(this, f3, animationSpec, null), continuation, 1, null);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    public static /* synthetic */ Object k(CarouselSwipeableState carouselSwipeableState, Object obj, AnimationSpec animationSpec, Continuation continuation, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: animateTo");
        }
        if ((i3 & 2) != 0) {
            animationSpec = carouselSwipeableState.f31073a;
        }
        return carouselSwipeableState.j(obj, animationSpec, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:31:0x009f, code lost:
    
        if (H(r10, r0) == r1) goto L86;
     */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0210  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object A(java.util.Map r10, java.util.Map r11, kotlin.coroutines.Continuation r12) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 632
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.carousel.CarouselSwipeableState.A(java.util.Map, java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void B(Map map) {
        this.f31081i.setValue(map);
    }

    public final void E(ResistanceConfig resistanceConfig) {
        this.f31087o.setValue(resistanceConfig);
    }

    public final void F(Function2 function2) {
        this.f31085m.setValue(function2);
    }

    public final void G(float f3) {
        this.f31086n.s(f3);
    }

    public final Object I(Object obj, Continuation continuation) {
        Object objCollect = this.f31082j.collect(new CarouselSwipeableState$snapTo$2(obj, this), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public final Object j(Object obj, AnimationSpec animationSpec, Continuation continuation) {
        Object objCollect = this.f31082j.collect(new CarouselSwipeableState$animateTo$2(obj, this, animationSpec), continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }

    public final void l(Map map) {
        if (m().isEmpty()) {
            Float fG = CarouselSwipeableKt.g(map, p());
            if (fG == null) {
                throw new IllegalArgumentException("The initial value must have an associated anchor.");
            }
            this.f31077e.s(fG.floatValue());
            this.f31079g.s(fG.floatValue());
        }
    }

    public final Map m() {
        return (Map) this.f31081i.getValue();
    }

    public final AnimationSpec n() {
        return this.f31073a;
    }

    public final Function1 o() {
        return this.f31074b;
    }

    public final Object p() {
        return this.f31075c.getValue();
    }

    public final DraggableState q() {
        return this.f31088p;
    }

    public final float r() {
        return this.f31084l;
    }

    public final float s() {
        return this.f31083k;
    }

    public final FloatState t() {
        return this.f31077e;
    }

    public final ResistanceConfig u() {
        return (ResistanceConfig) this.f31087o.getValue();
    }

    public final Function2 v() {
        return (Function2) this.f31085m.getValue();
    }

    public final float w() {
        return this.f31086n.c();
    }

    public final boolean x() {
        return ((Boolean) this.f31076d.getValue()).booleanValue();
    }

    public final float y(float f3) {
        float fO = RangesKt.o(this.f31079g.c() + f3, this.f31083k, this.f31084l) - this.f31079g.c();
        if (Math.abs(fO) > 0.0f) {
            this.f31088p.b(fO);
        }
        return fO;
    }

    public final Object z(final float f3, Continuation continuation) {
        Object objCollect = this.f31082j.collect(new FlowCollector() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$performFling$2
            @Override // kotlinx.coroutines.flow.FlowCollector
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public final Object emit(Map map, Continuation continuation2) {
                Float fG = CarouselSwipeableKt.g(map, this.f31110a.p());
                Intrinsics.checkNotNull(fG);
                float fFloatValue = fG.floatValue();
                Object obj = map.get(Boxing.c(CarouselSwipeableKt.e(this.f31110a.t().c(), fFloatValue, map.keySet(), this.f31110a.v(), f3, this.f31110a.w())));
                if (obj != null && ((Boolean) this.f31110a.o().invoke(obj)).booleanValue()) {
                    Object objK = CarouselSwipeableState.k(this.f31110a, obj, null, continuation2, 2, null);
                    return objK == IntrinsicsKt.f() ? objK : Unit.f139807a;
                }
                CarouselSwipeableState carouselSwipeableState = this.f31110a;
                Object objI = carouselSwipeableState.i(fFloatValue, carouselSwipeableState.n(), continuation2);
                return objI == IntrinsicsKt.f() ? objI : Unit.f139807a;
            }
        }, continuation);
        return objCollect == IntrinsicsKt.f() ? objCollect : Unit.f139807a;
    }
}
