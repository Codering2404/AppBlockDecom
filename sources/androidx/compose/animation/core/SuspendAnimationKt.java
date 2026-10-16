package androidx.compose.animation.core;

import androidx.compose.runtime.MonotonicFrameClockKt;
import androidx.compose.ui.MotionDurationScale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.FloatCompanionObject;

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
public final class SuspendAnimationKt {
    public static final Object b(float f3, float f4, float f5, AnimationSpec animationSpec, Function2 function2, Continuation continuation) {
        Object objD = d(VectorConvertersKt.i(FloatCompanionObject.f140130a), Boxing.c(f3), Boxing.c(f4), Boxing.c(f5), animationSpec, function2, continuation);
        return objD == IntrinsicsKt.f() ? objD : Unit.f139807a;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x0138  */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object c(final androidx.compose.animation.core.AnimationState r23, androidx.compose.animation.core.Animation r24, long r25, final kotlin.jvm.functions.Function1 r27, kotlin.coroutines.Continuation r28) throws java.lang.Throwable {
        /*
            Method dump skipped, instruction units count: 328
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.animation.core.SuspendAnimationKt.c(androidx.compose.animation.core.AnimationState, androidx.compose.animation.core.Animation, long, kotlin.jvm.functions.Function1, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public static final Object d(final TwoWayConverter twoWayConverter, Object obj, Object obj2, Object obj3, AnimationSpec animationSpec, final Function2 function2, Continuation continuation) {
        AnimationVector animationVectorG;
        if (obj3 == null || (animationVectorG = (AnimationVector) twoWayConverter.a().invoke(obj3)) == null) {
            animationVectorG = AnimationVectorsKt.g((AnimationVector) twoWayConverter.a().invoke(obj));
        }
        AnimationVector animationVector = animationVectorG;
        Object objF = f(new AnimationState(twoWayConverter, obj, animationVector, 0L, 0L, false, 56, null), new TargetBasedAnimation(animationSpec, twoWayConverter, obj, obj2, animationVector), 0L, new Function1<AnimationScope<Object, AnimationVector>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(AnimationScope animationScope) {
                function2.invoke(animationScope.e(), twoWayConverter.b().invoke(animationScope.g()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj4) {
                c((AnimationScope) obj4);
                return Unit.f139807a;
            }
        }, continuation, 2, null);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public static /* synthetic */ Object e(float f3, float f4, float f5, AnimationSpec animationSpec, Function2 function2, Continuation continuation, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            f5 = 0.0f;
        }
        if ((i3 & 8) != 0) {
            animationSpec = AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
        }
        return b(f3, f4, f5, animationSpec, function2, continuation);
    }

    public static /* synthetic */ Object f(AnimationState animationState, Animation animation, long j3, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            j3 = Long.MIN_VALUE;
        }
        long j4 = j3;
        if ((i3 & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animate$5
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((AnimationScope) obj2);
                    return Unit.f139807a;
                }

                public final void c(AnimationScope animationScope) {
                }
            };
        }
        return c(animationState, animation, j4, function1, continuation);
    }

    public static final Object g(float f3, float f4, FloatDecayAnimationSpec floatDecayAnimationSpec, final Function2 function2, Continuation continuation) {
        Object objF = f(AnimationStateKt.c(f3, f4, 0L, 0L, false, 28, null), AnimationKt.a(floatDecayAnimationSpec, f3, f4), 0L, new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$2
            {
                super(1);
            }

            public final void c(AnimationScope animationScope) {
                function2.invoke(animationScope.e(), Float.valueOf(((AnimationVector1D) animationScope.g()).f()));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                c((AnimationScope) obj);
                return Unit.f139807a;
            }
        }, continuation, 2, null);
        return objF == IntrinsicsKt.f() ? objF : Unit.f139807a;
    }

    public static final Object h(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z2, Function1 function1, Continuation continuation) throws Throwable {
        Object objC = c(animationState, new DecayAnimation(decayAnimationSpec, animationState.n(), animationState.getValue(), animationState.q()), z2 ? animationState.i() : Long.MIN_VALUE, function1, continuation);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    public static /* synthetic */ Object i(AnimationState animationState, DecayAnimationSpec decayAnimationSpec, boolean z2, Function1 function1, Continuation continuation, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateDecay$4
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((AnimationScope) obj2);
                    return Unit.f139807a;
                }

                public final void c(AnimationScope animationScope) {
                }
            };
        }
        return h(animationState, decayAnimationSpec, z2, function1, continuation);
    }

    public static final Object j(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z2, Function1 function1, Continuation continuation) throws Throwable {
        Object objC = c(animationState, new TargetBasedAnimation(animationSpec, animationState.n(), animationState.getValue(), obj, animationState.q()), z2 ? animationState.i() : Long.MIN_VALUE, function1, continuation);
        return objC == IntrinsicsKt.f() ? objC : Unit.f139807a;
    }

    public static /* synthetic */ Object k(AnimationState animationState, Object obj, AnimationSpec animationSpec, boolean z2, Function1 function1, Continuation continuation, int i3, Object obj2) {
        if ((i3 & 2) != 0) {
            animationSpec = AnimationSpecKt.l(0.0f, 0.0f, null, 7, null);
        }
        AnimationSpec animationSpec2 = animationSpec;
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        boolean z3 = z2;
        if ((i3 & 8) != 0) {
            function1 = new Function1() { // from class: androidx.compose.animation.core.SuspendAnimationKt$animateTo$2
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj3) {
                    c((AnimationScope) obj3);
                    return Unit.f139807a;
                }

                public final void c(AnimationScope animationScope) {
                }
            };
        }
        return j(animationState, obj, animationSpec2, z3, function1, continuation);
    }

    private static final Object l(Animation animation, final Function1 function1, Continuation continuation) {
        return animation.a() ? InfiniteAnimationPolicyKt.a(function1, continuation) : MonotonicFrameClockKt.c(new Function1<Long, Object>() { // from class: androidx.compose.animation.core.SuspendAnimationKt$callWithFrameNanos$2
            {
                super(1);
            }

            public final Object c(long j3) {
                return function1.invoke(Long.valueOf(j3));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                return c(((Number) obj).longValue());
            }
        }, continuation);
    }

    private static final void m(AnimationScope animationScope, long j3, long j4, Animation animation, AnimationState animationState, Function1 function1) {
        animationScope.j(j3);
        animationScope.l(animation.f(j4));
        animationScope.m(animation.b(j4));
        if (animation.c(j4)) {
            animationScope.i(animationScope.c());
            animationScope.k(false);
        }
        p(animationScope, animationState);
        function1.invoke(animationScope);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void n(AnimationScope animationScope, long j3, float f3, Animation animation, AnimationState animationState, Function1 function1) {
        m(animationScope, j3, f3 == 0.0f ? animation.d() : (long) ((j3 - animationScope.d()) / f3), animation, animationState, function1);
    }

    public static final float o(CoroutineContext coroutineContext) {
        MotionDurationScale motionDurationScale = (MotionDurationScale) coroutineContext.get(MotionDurationScale.c8);
        float fK = motionDurationScale != null ? motionDurationScale.k() : 1.0f;
        if (!(fK >= 0.0f)) {
            PreconditionsKt.b("negative scale factor");
        }
        return fK;
    }

    public static final void p(AnimationScope animationScope, AnimationState animationState) {
        animationState.y(animationScope.e());
        AnimationVectorsKt.f(animationState.q(), animationScope.g());
        animationState.v(animationScope.b());
        animationState.w(animationScope.c());
        animationState.x(animationScope.h());
    }
}
