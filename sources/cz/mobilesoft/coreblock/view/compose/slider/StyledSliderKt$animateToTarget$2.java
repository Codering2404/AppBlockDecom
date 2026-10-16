package cz.mobilesoft.coreblock.view.compose.slider;

import androidx.compose.animation.core.Animatable;
import androidx.compose.animation.core.AnimatableKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.gestures.DragScope;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$animateToTarget$2", f = "StyledSlider.kt", l = {573}, m = "invokeSuspend", v = 1)
final class StyledSliderKt$animateToTarget$2 extends SuspendLambda implements Function2<DragScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f132072a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f132073b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private /* synthetic */ Object f132074c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f132075d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ float f132076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ float f132077g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StyledSliderKt$animateToTarget$2(float f3, float f4, float f5, Continuation continuation) {
        super(2, continuation);
        this.f132075d = f3;
        this.f132076f = f4;
        this.f132077g = f5;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit y(DragScope dragScope, Ref.FloatRef floatRef, Animatable animatable) {
        dragScope.a(((Number) animatable.n()).floatValue() - floatRef.f140141a);
        floatRef.f140141a = ((Number) animatable.n()).floatValue();
        return Unit.f139807a;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        StyledSliderKt$animateToTarget$2 styledSliderKt$animateToTarget$2 = new StyledSliderKt$animateToTarget$2(this.f132075d, this.f132076f, this.f132077g, continuation);
        styledSliderKt$animateToTarget$2.f132074c = obj;
        return styledSliderKt$animateToTarget$2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final DragScope dragScope = (DragScope) this.f132074c;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f132073b;
        if (i3 == 0) {
            ResultKt.b(obj);
            final Ref.FloatRef floatRef = new Ref.FloatRef();
            float f3 = this.f132075d;
            floatRef.f140141a = f3;
            Animatable animatableB = AnimatableKt.b(f3, 0.0f, 2, null);
            Float fC = Boxing.c(this.f132076f);
            TweenSpec tweenSpec = StyledSliderKt.f132055i;
            Float fC2 = Boxing.c(this.f132077g);
            Function1 function1 = new Function1() { // from class: cz.mobilesoft.coreblock.view.compose.slider.y
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return StyledSliderKt$animateToTarget$2.y(dragScope, floatRef, (Animatable) obj2);
                }
            };
            this.f132074c = SpillingKt.a(dragScope);
            this.f132072a = SpillingKt.a(floatRef);
            this.f132073b = 1;
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

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(DragScope dragScope, Continuation continuation) {
        return ((StyledSliderKt$animateToTarget$2) create(dragScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
