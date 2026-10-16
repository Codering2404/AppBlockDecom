package androidx.constraintlayout.compose.carousel;

import kotlin.Metadata;
import kotlinx.coroutines.flow.FlowCollector;

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
final class CarouselSwipeableState$snapTo$2<T> implements FlowCollector {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Object f31122a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ CarouselSwipeableState f31123b;

    CarouselSwipeableState$snapTo$2(Object obj, CarouselSwipeableState carouselSwipeableState) {
        this.f31122a = obj;
        this.f31123b = carouselSwipeableState;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object emit(java.util.Map r5, kotlin.coroutines.Continuation r6) throws java.lang.Throwable {
        /*
            r4 = this;
            boolean r0 = r6 instanceof androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2$emit$1
            if (r0 == 0) goto L13
            r0 = r6
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2$emit$1 r0 = (androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2$emit$1) r0
            int r1 = r0.f31127d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.f31127d = r1
            goto L18
        L13:
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2$emit$1 r0 = new androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2$emit$1
            r0.<init>(r4, r6)
        L18:
            java.lang.Object r6 = r0.f31125b
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r2 = r0.f31127d
            r3 = 1
            if (r2 == 0) goto L35
            if (r2 != r3) goto L2d
            java.lang.Object r5 = r0.f31124a
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2 r5 = (androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2) r5
            kotlin.ResultKt.b(r6)
            goto L52
        L2d:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L35:
            kotlin.ResultKt.b(r6)
            java.lang.Object r6 = r4.f31122a
            java.lang.Float r5 = androidx.constraintlayout.compose.carousel.CarouselSwipeableKt.b(r5, r6)
            if (r5 == 0) goto L5c
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState r6 = r4.f31123b
            float r5 = r5.floatValue()
            r0.f31124a = r4
            r0.f31127d = r3
            java.lang.Object r5 = androidx.constraintlayout.compose.carousel.CarouselSwipeableState.h(r6, r5, r0)
            if (r5 != r1) goto L51
            return r1
        L51:
            r5 = r4
        L52:
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState r6 = r5.f31123b
            java.lang.Object r5 = r5.f31122a
            androidx.constraintlayout.compose.carousel.CarouselSwipeableState.g(r6, r5)
            kotlin.Unit r5 = kotlin.Unit.f139807a
            return r5
        L5c:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException
            java.lang.String r6 = "The target value must have an associated anchor."
            r5.<init>(r6)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.compose.carousel.CarouselSwipeableState$snapTo$2.emit(java.util.Map, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
