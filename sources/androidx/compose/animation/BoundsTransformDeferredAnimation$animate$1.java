package androidx.compose.animation;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.ui.geometry.Rect;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

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
@DebugMetadata(c = "androidx.compose.animation.BoundsTransformDeferredAnimation$animate$1", f = "AnimateBoundsModifier.kt", l = {428}, m = "invokeSuspend")
final class BoundsTransformDeferredAnimation$animate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f3426a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Animatable f3427b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Rect f3428c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ BoundsTransform f3429d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BoundsTransformDeferredAnimation f3430f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BoundsTransformDeferredAnimation$animate$1(Animatable animatable, Rect rect, BoundsTransform boundsTransform, BoundsTransformDeferredAnimation boundsTransformDeferredAnimation, Continuation continuation) {
        super(2, continuation);
        this.f3427b = animatable;
        this.f3428c = rect;
        this.f3429d = boundsTransform;
        this.f3430f = boundsTransformDeferredAnimation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new BoundsTransformDeferredAnimation$animate$1(this.f3427b, this.f3428c, this.f3429d, this.f3430f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f3426a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Animatable animatable = this.f3427b;
            Rect rect = this.f3428c;
            BoundsTransform boundsTransform = this.f3429d;
            Rect rectC = this.f3430f.c();
            Intrinsics.checkNotNull(rectC);
            FiniteAnimationSpec finiteAnimationSpecA = boundsTransform.a(rectC, this.f3428c);
            this.f3426a = 1;
            if (Animatable.f(animatable, rect, finiteAnimationSpecA, null, null, this, 12, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((BoundsTransformDeferredAnimation$animate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
