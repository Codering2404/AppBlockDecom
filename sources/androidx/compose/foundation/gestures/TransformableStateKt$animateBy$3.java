package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationStateKt;
import androidx.compose.animation.core.AnimationVector4D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.ui.geometry.Offset;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;

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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animateBy$3", f = "TransformableState.kt", l = {230}, m = "invokeSuspend")
final class TransformableStateKt$animateBy$3 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6367a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f6368b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.ObjectRef f6369c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ AnimationData f6370d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ DelegatingAnimationSpec f6371f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableStateKt$animateBy$3(Ref.ObjectRef objectRef, AnimationData animationData, DelegatingAnimationSpec delegatingAnimationSpec, Continuation continuation) {
        super(2, continuation);
        this.f6369c = objectRef;
        this.f6370d = animationData;
        this.f6371f = delegatingAnimationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TransformableStateKt$animateBy$3 transformableStateKt$animateBy$3 = new TransformableStateKt$animateBy$3(this.f6369c, this.f6370d, this.f6371f, continuation);
        transformableStateKt$animateBy$3.f6368b = obj;
        return transformableStateKt$animateBy$3;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(TransformScope transformScope, Continuation continuation) {
        return ((TransformableStateKt$animateBy$3) create(transformScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f6367a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final TransformScope transformScope = (TransformScope) this.f6368b;
            AnimationState animationStateD = AnimationStateKt.d(AnimationDataConverter.f5539a, this.f6369c.f140144a, TransformableStateKt.f6366a, 0L, 0L, false, 56, null);
            AnimationData animationData = this.f6370d;
            DelegatingAnimationSpec delegatingAnimationSpec = this.f6371f;
            final Ref.ObjectRef objectRef = this.f6369c;
            Function1<AnimationScope<AnimationData, AnimationVector4D>, Unit> function1 = new Function1<AnimationScope<AnimationData, AnimationVector4D>, Unit>() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$animateBy$3.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(AnimationScope animationScope) {
                    float fC = ((AnimationData) objectRef.f140144a).c() == 0.0f ? 1.0f : ((AnimationData) animationScope.e()).c() / ((AnimationData) objectRef.f140144a).c();
                    transformScope.a(fC, Offset.p(((AnimationData) animationScope.e()).b(), ((AnimationData) objectRef.f140144a).b()), ((AnimationData) animationScope.e()).a() - ((AnimationData) objectRef.f140144a).a());
                    objectRef.f140144a = animationScope.e();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((AnimationScope) obj2);
                    return Unit.f139807a;
                }
            };
            this.f6367a = 1;
            if (SuspendAnimationKt.k(animationStateD, animationData, delegatingAnimationSpec, false, function1, this, 4, null) == objF) {
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
}
