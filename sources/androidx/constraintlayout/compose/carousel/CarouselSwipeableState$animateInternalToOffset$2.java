package androidx.constraintlayout.compose.carousel;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.AnimationVector1D;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableState$animateInternalToOffset$2", f = "CarouselSwipeable.kt", l = {209}, m = "invokeSuspend")
final class CarouselSwipeableState$animateInternalToOffset$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f31093a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f31094b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ CarouselSwipeableState f31095c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f31096d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ AnimationSpec f31097f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CarouselSwipeableState$animateInternalToOffset$2(CarouselSwipeableState carouselSwipeableState, float f3, AnimationSpec animationSpec, Continuation continuation) {
        super(2, continuation);
        this.f31095c = carouselSwipeableState;
        this.f31096d = f3;
        this.f31097f = animationSpec;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        CarouselSwipeableState$animateInternalToOffset$2 carouselSwipeableState$animateInternalToOffset$2 = new CarouselSwipeableState$animateInternalToOffset$2(this.f31095c, this.f31096d, this.f31097f, continuation);
        carouselSwipeableState$animateInternalToOffset$2.f31094b = obj;
        return carouselSwipeableState$animateInternalToOffset$2;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(DragScope dragScope, Continuation continuation) {
        return ((CarouselSwipeableState$animateInternalToOffset$2) create(dragScope, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f31093a;
        try {
            if (i3 == 0) {
                ResultKt.b(obj);
                final DragScope dragScope = (DragScope) this.f31094b;
                final Ref.FloatRef floatRef = new Ref.FloatRef();
                floatRef.f140141a = this.f31095c.f31079g.c();
                this.f31095c.f31080h.setValue(Boxing.c(this.f31096d));
                this.f31095c.C(true);
                Animatable animatableB = AnimatableKt.b(floatRef.f140141a, 0.0f, 2, null);
                Float fC = Boxing.c(this.f31096d);
                AnimationSpec animationSpec = this.f31097f;
                Function1<Animatable<Float, AnimationVector1D>, Unit> function1 = new Function1<Animatable<Float, AnimationVector1D>, Unit>() { // from class: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$animateInternalToOffset$2.1
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
                this.f31093a = 1;
                if (Animatable.f(animatableB, fC, animationSpec, null, function1, this, 4, null) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            this.f31095c.f31080h.setValue(null);
            this.f31095c.C(false);
            return Unit.f139807a;
        } catch (Throwable th) {
            this.f31095c.f31080h.setValue(null);
            this.f31095c.C(false);
            throw th;
        }
    }
}
