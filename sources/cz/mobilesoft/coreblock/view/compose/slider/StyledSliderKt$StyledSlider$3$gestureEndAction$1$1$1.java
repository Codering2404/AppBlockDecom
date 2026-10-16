package cz.mobilesoft.coreblock.view.compose.slider;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.compose.slider.StyledSliderKt$StyledSlider$3$gestureEndAction$1$1$1", f = "StyledSlider.kt", l = {214}, m = "invokeSuspend", v = 1)
final class StyledSliderKt$StyledSlider$3$gestureEndAction$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f132066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SliderDraggableState f132067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ float f132068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f132069d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ float f132070f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function0 f132071g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StyledSliderKt$StyledSlider$3$gestureEndAction$1$1$1(SliderDraggableState sliderDraggableState, float f3, float f4, float f5, Function0 function0, Continuation continuation) {
        super(2, continuation);
        this.f132067b = sliderDraggableState;
        this.f132068c = f3;
        this.f132069d = f4;
        this.f132070f = f5;
        this.f132071g = function0;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StyledSliderKt$StyledSlider$3$gestureEndAction$1$1$1(this.f132067b, this.f132068c, this.f132069d, this.f132070f, this.f132071g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f132066a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SliderDraggableState sliderDraggableState = this.f132067b;
            float f3 = this.f132068c;
            float f4 = this.f132069d;
            float f5 = this.f132070f;
            this.f132066a = 1;
            if (StyledSliderKt.J(sliderDraggableState, f3, f4, f5, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        Function0 function0 = this.f132071g;
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StyledSliderKt$StyledSlider$3$gestureEndAction$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
