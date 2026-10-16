package androidx.constraintlayout.compose;

import androidx.compose.runtime.MutableState;
import androidx.constraintlayout.compose.carousel.CarouselSwipeableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.constraintlayout.compose.MotionCarouselKt$MotionCarousel$2$1", f = "MotionCarousel.kt", l = {209}, m = "invokeSuspend")
final class MotionCarouselKt$MotionCarousel$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f30683a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CarouselSwipeableState f30684b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ String f30685c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ MutableState f30686d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    MotionCarouselKt$MotionCarousel$2$1(CarouselSwipeableState carouselSwipeableState, String str, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f30684b = carouselSwipeableState;
        this.f30685c = str;
        this.f30686d = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new MotionCarouselKt$MotionCarousel$2$1(this.f30684b, this.f30685c, this.f30686d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f30683a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (MotionCarouselKt.e(this.f30686d).b() > 0) {
                MotionCarouselKt.e(this.f30686d).d(r4.b() - 1);
            }
            CarouselSwipeableState carouselSwipeableState = this.f30684b;
            String str = this.f30685c;
            this.f30683a = 1;
            if (carouselSwipeableState.I(str, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        MotionCarouselKt.e(this.f30686d).c(MotionCarouselDirection.FORWARD);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((MotionCarouselKt$MotionCarousel$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
