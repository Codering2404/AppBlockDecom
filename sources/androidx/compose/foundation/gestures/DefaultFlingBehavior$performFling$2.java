package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.DecayAnimationSpec;
import androidx.compose.animation.core.SuspendAnimationKt;
import java.util.concurrent.CancellationException;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2", f = "Scrollable.kt", l = {953}, m = "invokeSuspend")
final class DefaultFlingBehavior$performFling$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Float>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f5609a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f5610b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f5611c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f5612d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DefaultFlingBehavior f5613f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ ScrollScope f5614g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DefaultFlingBehavior$performFling$2(float f3, DefaultFlingBehavior defaultFlingBehavior, ScrollScope scrollScope, Continuation continuation) {
        super(2, continuation);
        this.f5612d = f3;
        this.f5613f = defaultFlingBehavior;
        this.f5614g = scrollScope;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DefaultFlingBehavior$performFling$2(this.f5612d, this.f5613f, this.f5614g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        float f3;
        AnimationState animationState;
        Ref.FloatRef floatRef;
        DecayAnimationSpec decayAnimationSpec;
        Function1<AnimationScope<Float, AnimationVector1D>, Unit> function1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f5611c;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (Math.abs(this.f5612d) > 1.0f) {
                final Ref.FloatRef floatRef2 = new Ref.FloatRef();
                floatRef2.f140141a = this.f5612d;
                final Ref.FloatRef floatRef3 = new Ref.FloatRef();
                AnimationState animationStateC = AnimationStateKt.c(0.0f, this.f5612d, 0L, 0L, false, 28, null);
                try {
                    decayAnimationSpec = this.f5613f.f5606a;
                    final ScrollScope scrollScope = this.f5614g;
                    final DefaultFlingBehavior defaultFlingBehavior = this.f5613f;
                    function1 = new Function1<AnimationScope<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.foundation.gestures.DefaultFlingBehavior$performFling$2.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        public final void c(AnimationScope animationScope) {
                            float fFloatValue = ((Number) animationScope.e()).floatValue() - floatRef3.f140141a;
                            float fD = scrollScope.d(fFloatValue);
                            floatRef3.f140141a = ((Number) animationScope.e()).floatValue();
                            floatRef2.f140141a = ((Number) animationScope.f()).floatValue();
                            if (Math.abs(fFloatValue - fD) > 0.5f) {
                                animationScope.a();
                            }
                            DefaultFlingBehavior defaultFlingBehavior2 = defaultFlingBehavior;
                            defaultFlingBehavior2.f(defaultFlingBehavior2.e() + 1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                            c((AnimationScope) obj2);
                            return Unit.f139807a;
                        }
                    };
                    this.f5609a = floatRef2;
                    this.f5610b = animationStateC;
                    this.f5611c = 1;
                    animationState = animationStateC;
                    try {
                    } catch (CancellationException unused) {
                        floatRef = floatRef2;
                        floatRef.f140141a = ((Number) animationState.p()).floatValue();
                    }
                } catch (CancellationException unused2) {
                    animationState = animationStateC;
                }
                if (SuspendAnimationKt.i(animationState, decayAnimationSpec, false, function1, this, 2, null) == objF) {
                    return objF;
                }
                floatRef = floatRef2;
                f3 = floatRef.f140141a;
            } else {
                f3 = this.f5612d;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            animationState = (AnimationState) this.f5610b;
            floatRef = (Ref.FloatRef) this.f5609a;
            try {
                ResultKt.b(obj);
            } catch (CancellationException unused3) {
                floatRef.f140141a = ((Number) animationState.p()).floatValue();
            }
            f3 = floatRef.f140141a;
        }
        return Boxing.c(f3);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DefaultFlingBehavior$performFling$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
