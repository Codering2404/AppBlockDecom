package androidx.compose.foundation.gestures;

import androidx.compose.animation.core.AnimationScope;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationState;
import androidx.compose.animation.core.AnimationVector2D;
import androidx.compose.animation.core.SuspendAnimationKt;
import androidx.compose.animation.core.VectorConvertersKt;
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
@DebugMetadata(c = "androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$2", f = "TransformableState.kt", l = {182}, m = "invokeSuspend")
final class TransformableStateKt$animatePanBy$2 extends SuspendLambda implements Function2<TransformScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f6374a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f6375b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Ref.LongRef f6376c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ long f6377d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f6378f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TransformableStateKt$animatePanBy$2(Ref.LongRef longRef, long j3, AnimationSpec animationSpec, Continuation continuation) {
        super(2, continuation);
        this.f6376c = longRef;
        this.f6377d = j3;
        this.f6378f = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TransformableStateKt$animatePanBy$2 transformableStateKt$animatePanBy$2 = new TransformableStateKt$animatePanBy$2(this.f6376c, this.f6377d, this.f6378f, continuation);
        transformableStateKt$animatePanBy$2.f6375b = obj;
        return transformableStateKt$animatePanBy$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(TransformScope transformScope, Continuation continuation) {
        return ((TransformableStateKt$animatePanBy$2) create(transformScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f6374a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final TransformScope transformScope = (TransformScope) this.f6375b;
            AnimationState animationState = new AnimationState(VectorConvertersKt.b(Offset.f25596b), Offset.d(this.f6376c.f140143a), null, 0L, 0L, false, 60, null);
            Offset offsetD = Offset.d(this.f6377d);
            AnimationSpec animationSpec = this.f6378f;
            final Ref.LongRef longRef = this.f6376c;
            Function1<AnimationScope<Offset, AnimationVector2D>, Unit> function1 = new Function1<AnimationScope<Offset, AnimationVector2D>, Unit>() { // from class: androidx.compose.foundation.gestures.TransformableStateKt$animatePanBy$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(AnimationScope animationScope) {
                    TransformScope.b(transformScope, 0.0f, Offset.p(((Offset) animationScope.e()).u(), longRef.f140143a), 0.0f, 5, null);
                    longRef.f140143a = ((Offset) animationScope.e()).u();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((AnimationScope) obj2);
                    return Unit.f139807a;
                }
            };
            this.f6374a = 1;
            if (SuspendAnimationKt.k(animationState, offsetD, animationSpec, false, function1, this, 4, null) == objF) {
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
