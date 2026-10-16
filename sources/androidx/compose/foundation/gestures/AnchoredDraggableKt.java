package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.animation.core.FloatDecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.foundation.gestures.snapping.SnapFlingBehaviorKt;
import androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider;
import androidx.compose.ui.input.pointer.PointerInputChange;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.ranges.RangesKt;

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
public final class AnchoredDraggableKt {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Function1 f5384a = new Function1<PointerInputChange, Boolean>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$AlwaysDrag$1
        @Override // kotlin.jvm.functions.Function1
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Boolean invoke(PointerInputChange pointerInputChange) {
            return Boolean.TRUE;
        }
    };

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Function1 f5385b = new Function1<Integer, Float>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$GetOrNan$1
        public final Float c(int i3) {
            return Float.valueOf(Float.NaN);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            return c(((Number) obj).intValue());
        }
    };

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final float f5386c = Dp.g(125);

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final DecayAnimationSpec f5387d = DecayAnimationSpecKt.d(new FloatDecayAnimationSpec() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$NoOpDecayAnimationSpec$1

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final float f5395a;

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float a() {
            return this.f5395a;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float b(long j3, float f3, float f4) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public long c(float f3, float f4) {
            return 0L;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float d(float f3, float f4) {
            return 0.0f;
        }

        @Override // androidx.compose.animation.core.FloatDecayAnimationSpec
        public float e(long j3, float f3, float f4) {
            return 0.0f;
        }
    });

    private static final SnapLayoutInfoProvider a(final AnchoredDraggableState anchoredDraggableState, final Function1 function1, final Function0 function0) {
        return new SnapLayoutInfoProvider() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$AnchoredDraggableLayoutInfoProvider$1
            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float a(float f3) {
                float fA = anchoredDraggableState.A();
                return anchoredDraggableState.l().c(AnchoredDraggableKt.o(anchoredDraggableState.l(), fA, f3, function1, function0)) - fA;
            }

            @Override // androidx.compose.foundation.gestures.snapping.SnapLayoutInfoProvider
            public float b(float f3, float f4) {
                return 0.0f;
            }
        };
    }

    public static final AnchoredDraggableState b(Object obj, Function1 function1, Function0 function0, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Function1 function12) {
        AnchoredDraggableState anchoredDraggableState = new AnchoredDraggableState(obj, function12);
        anchoredDraggableState.G(function1);
        anchoredDraggableState.J(function0);
        anchoredDraggableState.I(animationSpec);
        anchoredDraggableState.C(decayAnimationSpec);
        return anchoredDraggableState;
    }

    public static final TargetedFlingBehavior j(AnchoredDraggableState anchoredDraggableState, final Density density, Function1 function1, AnimationSpec animationSpec) {
        return SnapFlingBehaviorKt.o(a(anchoredDraggableState, function1, new Function0<Float>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$anchoredDraggableFlingBehavior$1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final Float invoke() {
                return Float.valueOf(density.M1(Dp.g(125)));
            }
        }), f5387d, animationSpec);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object k(AnchoredDraggableState anchoredDraggableState, float f3, final AnchoredDragScope anchoredDragScope, DraggableAnchors draggableAnchors, Object obj, AnimationSpec animationSpec, Continuation continuation) {
        Object objB;
        float fC = draggableAnchors.c(obj);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        floatRef.f140141a = Float.isNaN(anchoredDraggableState.r()) ? 0.0f : anchoredDraggableState.r();
        if (!Float.isNaN(fC)) {
            float f4 = floatRef.f140141a;
            if (f4 != fC && (objB = SuspendAnimationKt.b(f4, fC, f3, animationSpec, new Function2<Float, Float, Unit>() { // from class: androidx.compose.foundation.gestures.AnchoredDraggableKt$animateTo$2$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                public final void c(float f5, float f6) {
                    anchoredDragScope.a(f5, f6);
                    floatRef.f140141a = f5;
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Object invoke(Object obj2, Object obj3) {
                    c(((Number) obj2).floatValue(), ((Number) obj3).floatValue());
                    return Unit.f139807a;
                }
            }, continuation)) == IntrinsicsKt.f()) {
                return objB;
            }
        }
        return Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:8:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object l(androidx.compose.foundation.gestures.AnchoredDraggableState r10, java.lang.Object r11, float r12, androidx.compose.animation.core.AnimationSpec r13, androidx.compose.animation.core.DecayAnimationSpec r14, kotlin.coroutines.Continuation r15) throws java.lang.Throwable {
        /*
            boolean r1 = r15 instanceof androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1
            if (r1 == 0) goto L14
            r1 = r15
            androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1 r1 = (androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1) r1
            int r3 = r1.f5408d
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = r3 & r4
            if (r5 == 0) goto L14
            int r3 = r3 - r4
            r1.f5408d = r3
        L12:
            r7 = r1
            goto L1a
        L14:
            androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1 r1 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$1
            r1.<init>(r15)
            goto L12
        L1a:
            java.lang.Object r0 = r7.f5407c
            java.lang.Object r9 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r7.f5408d
            r8 = 1
            if (r1 == 0) goto L39
            if (r1 != r8) goto L31
            float r1 = r7.f5405a
            java.lang.Object r2 = r7.f5406b
            kotlin.jvm.internal.Ref$FloatRef r2 = (kotlin.jvm.internal.Ref.FloatRef) r2
            kotlin.ResultKt.b(r0)
            goto L64
        L31:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "call to 'resume' before 'invoke' with coroutine"
            r0.<init>(r1)
            throw r0
        L39:
            kotlin.ResultKt.b(r0)
            kotlin.jvm.internal.Ref$FloatRef r4 = new kotlin.jvm.internal.Ref$FloatRef
            r4.<init>()
            r4.f140141a = r12
            androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$animateToWithDecay$2
            r6 = 0
            r1 = r10
            r2 = r12
            r3 = r13
            r5 = r14
            r0.<init>(r1, r2, r3, r4, r5, r6)
            r5 = r0
            r0 = r4
            r7.f5406b = r0
            r7.f5405a = r12
            r7.f5408d = r8
            r4 = 0
            r6 = r7
            r7 = 2
            r8 = 0
            r2 = r10
            r3 = r11
            java.lang.Object r2 = androidx.compose.foundation.gestures.AnchoredDraggableState.k(r2, r3, r4, r5, r6, r7, r8)
            if (r2 != r9) goto L62
            return r9
        L62:
            r1 = r12
            r2 = r0
        L64:
            float r0 = r2.f140141a
            float r1 = r1 - r0
            java.lang.Float r0 = kotlin.coroutines.jvm.internal.Boxing.c(r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt.l(androidx.compose.foundation.gestures.AnchoredDraggableState, java.lang.Object, float, androidx.compose.animation.core.AnimationSpec, androidx.compose.animation.core.DecayAnimationSpec, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static /* synthetic */ Object m(AnchoredDraggableState anchoredDraggableState, Object obj, float f3, AnimationSpec animationSpec, DecayAnimationSpec decayAnimationSpec, Continuation continuation, int i3, Object obj2) {
        if ((i3 & 4) != 0) {
            animationSpec = anchoredDraggableState.w() ? anchoredDraggableState.u() : AnchoredDraggableDefaults.f5370a.c();
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i3 & 8) != 0) {
            decayAnimationSpec = anchoredDraggableState.w() ? anchoredDraggableState.o() : AnchoredDraggableDefaults.f5370a.a();
        }
        return l(anchoredDraggableState, obj, f3, animationSpec2, decayAnimationSpec, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float n(float f3, float f4) {
        if (f4 == 0.0f) {
            return 0.0f;
        }
        return f4 > 0.0f ? RangesKt.j(f3, f4) : RangesKt.e(f3, f4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:32:0x008a A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x008b A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object o(androidx.compose.foundation.gestures.DraggableAnchors r5, float r6, float r7, kotlin.jvm.functions.Function1 r8, kotlin.jvm.functions.Function0 r9) {
        /*
            boolean r0 = java.lang.Float.isNaN(r6)
            if (r0 != 0) goto L92
            float r0 = java.lang.Math.abs(r7)
            r1 = 0
            int r0 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            r2 = 0
            r3 = 1
            if (r0 <= 0) goto L13
            r0 = r3
            goto L14
        L13:
            r0 = r2
        L14:
            if (r0 == 0) goto L1c
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 <= 0) goto L1c
            r1 = r3
            goto L1d
        L1c:
            r1 = r2
        L1d:
            if (r0 != 0) goto L27
            java.lang.Object r5 = r5.b(r6)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            return r5
        L27:
            float r7 = java.lang.Math.abs(r7)
            java.lang.Object r9 = r9.invoke()
            java.lang.Number r9 = (java.lang.Number) r9
            float r9 = r9.floatValue()
            float r9 = java.lang.Math.abs(r9)
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 < 0) goto L45
            java.lang.Object r5 = r5.a(r6, r1)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            return r5
        L45:
            java.lang.Object r7 = r5.a(r6, r2)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r7)
            float r9 = r5.c(r7)
            java.lang.Object r0 = r5.a(r6, r3)
            kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
            float r5 = r5.c(r0)
            float r4 = r9 - r5
            float r4 = java.lang.Math.abs(r4)
            java.lang.Float r4 = java.lang.Float.valueOf(r4)
            java.lang.Object r8 = r8.invoke(r4)
            java.lang.Number r8 = (java.lang.Number) r8
            float r8 = r8.floatValue()
            float r8 = java.lang.Math.abs(r8)
            if (r1 == 0) goto L76
            goto L77
        L76:
            r9 = r5
        L77:
            float r9 = r9 - r6
            float r5 = java.lang.Math.abs(r9)
            int r5 = (r5 > r8 ? 1 : (r5 == r8 ? 0 : -1))
            if (r5 < 0) goto L81
            r2 = r3
        L81:
            if (r2 != r3) goto L86
            if (r1 == 0) goto L8a
            goto L8b
        L86:
            if (r2 != 0) goto L8c
            if (r1 == 0) goto L8b
        L8a:
            return r7
        L8b:
            return r0
        L8c:
            kotlin.NoWhenBranchMatchedException r5 = new kotlin.NoWhenBranchMatchedException
            r5.<init>()
            throw r5
        L92:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "The offset provided to computeTarget must not be NaN."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt.o(androidx.compose.foundation.gestures.DraggableAnchors, float, float, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function0):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DefaultDraggableAnchors p() {
        return new DefaultDraggableAnchors(CollectionsKt.emptyList(), new float[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object q(kotlin.jvm.functions.Function0 r4, kotlin.jvm.functions.Function2 r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            boolean r0 = r6 instanceof androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1 r0 = (androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1) r0
            int r1 = r0.f5423b
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f5423b = r1
            goto L18
        L13:
            androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1 r0 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$1
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.f5422a
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f5423b
            r3 = 1
            if (r2 == 0) goto L31
            if (r2 != r3) goto L29
            kotlin.ResultKt.b(r6)     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L43
            goto L43
        L29:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L31:
            kotlin.ResultKt.b(r6)
            androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2 r6 = new androidx.compose.foundation.gestures.AnchoredDraggableKt$restartable$2     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L43
            r2 = 0
            r6.<init>(r4, r5, r2)     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L43
            r0.f5423b = r3     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L43
            java.lang.Object r4 = kotlinx.coroutines.CoroutineScopeKt.f(r6, r0)     // Catch: androidx.compose.foundation.gestures.AnchoredDragFinishedSignal -> L43
            if (r4 != r1) goto L43
            return r1
        L43:
            kotlin.Unit r4 = kotlin.Unit.f139807a
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.foundation.gestures.AnchoredDraggableKt.q(kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
