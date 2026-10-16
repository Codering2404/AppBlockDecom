package androidx.compose.foundation.gestures.snapping;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpecKt;
import androidx.compose.foundation.gestures.ScrollScope;
import androidx.compose.foundation.internal.InlineClassHelperKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1", f = "SnapFlingBehavior.kt", l = {135, 151}, m = "invokeSuspend")
final class SnapFlingBehavior$fling$result$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super AnimationResult<Float, AnimationVector1D>>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f6450a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f6451b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SnapFlingBehavior f6452c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f6453d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function1 f6454f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScrollScope f6455g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SnapFlingBehavior$fling$result$1(SnapFlingBehavior snapFlingBehavior, float f3, Function1 function1, ScrollScope scrollScope, Continuation continuation) {
        super(2, continuation);
        this.f6452c = snapFlingBehavior;
        this.f6453d = f3;
        this.f6454f = function1;
        this.f6455g = scrollScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new SnapFlingBehavior$fling$result$1(this.f6452c, this.f6453d, this.f6454f, this.f6455g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final Ref.FloatRef floatRef;
        Object objL;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f6451b;
        if (i3 == 0) {
            ResultKt.b(obj);
            float fB = this.f6452c.f6442a.b(this.f6453d, DecayAnimationSpecKt.a(this.f6452c.f6443b, 0.0f, this.f6453d));
            if (Float.isNaN(fB)) {
                InlineClassHelperKt.c("calculateApproachOffset returned NaN. Please use a valid value.");
            }
            floatRef = new Ref.FloatRef();
            float fAbs = Math.abs(fB) * Math.signum(this.f6453d);
            floatRef.f140141a = fAbs;
            this.f6454f.invoke(Boxing.c(fAbs));
            SnapFlingBehavior snapFlingBehavior = this.f6452c;
            ScrollScope scrollScope = this.f6455g;
            float f3 = floatRef.f140141a;
            float f4 = this.f6453d;
            final Function1 function1 = this.f6454f;
            Function1<Float, Unit> function12 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1$animationState$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(float f5) {
                    Ref.FloatRef floatRef2 = floatRef;
                    float f6 = floatRef2.f140141a - f5;
                    floatRef2.f140141a = f6;
                    function1.invoke(Float.valueOf(f6));
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c(((Number) obj2).floatValue());
                    return Unit.f139807a;
                }
            };
            this.f6450a = floatRef;
            this.f6451b = 1;
            objL = snapFlingBehavior.l(scrollScope, f3, f4, function12, this);
            if (objL != objF) {
            }
        }
        if (i3 != 1) {
            if (i3 != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            return obj;
        }
        Ref.FloatRef floatRef2 = (Ref.FloatRef) this.f6450a;
        ResultKt.b(obj);
        floatRef = floatRef2;
        objL = obj;
        AnimationState animationState = (AnimationState) objL;
        float fA = this.f6452c.f6442a.a(((Number) animationState.p()).floatValue());
        if (Float.isNaN(fA)) {
            InlineClassHelperKt.c("calculateSnapOffset returned NaN. Please use a valid value.");
        }
        floatRef.f140141a = fA;
        ScrollScope scrollScope2 = this.f6455g;
        AnimationState animationStateG = AnimationStateKt.g(animationState, 0.0f, 0.0f, 0L, 0L, false, 30, null);
        AnimationSpec animationSpec = this.f6452c.f6444c;
        final Function1 function13 = this.f6454f;
        Function1<Float, Unit> function14 = new Function1<Float, Unit>() { // from class: androidx.compose.foundation.gestures.snapping.SnapFlingBehavior$fling$result$1.4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            public final void c(float f5) {
                Ref.FloatRef floatRef3 = floatRef;
                float f6 = floatRef3.f140141a - f5;
                floatRef3.f140141a = f6;
                function13.invoke(Float.valueOf(f6));
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                c(((Number) obj2).floatValue());
                return Unit.f139807a;
            }
        };
        this.f6450a = null;
        this.f6451b = 2;
        Object objH = SnapFlingBehaviorKt.h(scrollScope2, fA, fA, animationStateG, animationSpec, function14, this);
        return objH == objF ? objF : objH;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((SnapFlingBehavior$fling$result$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
