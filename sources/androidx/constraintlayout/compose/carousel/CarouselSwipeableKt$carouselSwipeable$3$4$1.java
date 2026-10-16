package androidx.constraintlayout.compose.carousel;

import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
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
/* JADX INFO: loaded from: classes3.dex */
@Metadata
@DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$carouselSwipeable$3$4$1", f = "CarouselSwipeable.kt", l = {}, m = "invokeSuspend")
final class CarouselSwipeableKt$carouselSwipeable$3$4$1 extends SuspendLambda implements Function3<CoroutineScope, Float, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f31044a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private /* synthetic */ Object f31045b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    /* synthetic */ float f31046c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CarouselSwipeableState f31047d;

    /* JADX INFO: renamed from: androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$carouselSwipeable$3$4$1$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "androidx.constraintlayout.compose.carousel.CarouselSwipeableKt$carouselSwipeable$3$4$1$1", f = "CarouselSwipeable.kt", l = {593}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f31048a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ CarouselSwipeableState f31049b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ float f31050c;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(CarouselSwipeableState carouselSwipeableState, float f3, Continuation continuation) {
            super(2, continuation);
            this.f31049b = carouselSwipeableState;
            this.f31050c = f3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation create(Object obj, Continuation continuation) {
            return new AnonymousClass1(this.f31049b, this.f31050c, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.f31048a;
            if (i3 == 0) {
                ResultKt.b(obj);
                CarouselSwipeableState carouselSwipeableState = this.f31049b;
                float f3 = this.f31050c;
                this.f31048a = 1;
                if (carouselSwipeableState.z(f3, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CarouselSwipeableKt$carouselSwipeable$3$4$1(CarouselSwipeableState carouselSwipeableState, Continuation continuation) {
        super(3, continuation);
        this.f31047d = carouselSwipeableState;
    }

    public final Object h(CoroutineScope coroutineScope, float f3, Continuation continuation) {
        CarouselSwipeableKt$carouselSwipeable$3$4$1 carouselSwipeableKt$carouselSwipeable$3$4$1 = new CarouselSwipeableKt$carouselSwipeable$3$4$1(this.f31047d, continuation);
        carouselSwipeableKt$carouselSwipeable$3$4$1.f31045b = coroutineScope;
        carouselSwipeableKt$carouselSwipeable$3$4$1.f31046c = f3;
        return carouselSwipeableKt$carouselSwipeable$3$4$1.invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.jvm.functions.Function3
    public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2, Object obj3) {
        return h((CoroutineScope) obj, ((Number) obj2).floatValue(), (Continuation) obj3);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f31044a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        BuildersKt__Builders_commonKt.d((CoroutineScope) this.f31045b, null, null, new AnonymousClass1(this.f31047d, this.f31046c, null), 3, null);
        return Unit.f139807a;
    }
}
