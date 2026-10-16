package androidx.compose.material;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationVector1D;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.DragScope;
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
@DebugMetadata(c = "androidx.compose.material.SliderKt$animateToTarget$2", f = "Slider.kt", l = {964}, m = "invokeSuspend")
final class SliderKt$animateToTarget$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f13951a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f13952b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f13953c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f13954d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ float f13955f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SliderKt$animateToTarget$2(float f3, float f4, float f5, Continuation continuation) {
        super(2, continuation);
        this.f13953c = f3;
        this.f13954d = f4;
        this.f13955f = f5;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        SliderKt$animateToTarget$2 sliderKt$animateToTarget$2 = new SliderKt$animateToTarget$2(this.f13953c, this.f13954d, this.f13955f, continuation);
        sliderKt$animateToTarget$2.f13952b = obj;
        return sliderKt$animateToTarget$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(DragScope dragScope, Continuation continuation) {
        return ((SliderKt$animateToTarget$2) create(dragScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f13951a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final DragScope dragScope = (DragScope) this.f13952b;
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            float f3 = this.f13953c;
            floatRef.f140141a = f3;
            Animatable animatableB = AnimatableKt.b(f3, 0.0f, 2, null);
            Float fC = Boxing.c(this.f13954d);
            TweenSpec tweenSpec = SliderKt.f13778i;
            Float fC2 = Boxing.c(this.f13955f);
            Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.compose.material.SliderKt$animateToTarget$2.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                public final void c(Animatable animatable) {
                    dragScope.a(((Number) animatable.n()).floatValue() - floatRef.f140141a);
                    floatRef.f140141a = ((Number) animatable.n()).floatValue();
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    c((Animatable) obj2);
                    return Unit.f139807a;
                }
            };
            this.f13951a = 1;
            if (animatableB.e(fC, tweenSpec, fC2, function1, this) == objF) {
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
