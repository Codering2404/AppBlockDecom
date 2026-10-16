package com.revenuecat.purchases.ui.revenuecatui.components.carousel;

import androidx.compose.foundation.pager.PagerState;
import com.revenuecat.purchases.paywalls.components.CarouselComponent;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$EnableAutoAdvance$1$1", f = "CarouselComponentView.kt", l = {348, 358}, m = "invokeSuspend")
final class CarouselComponentViewKt$EnableAutoAdvance$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CarouselComponent.AutoAdvancePages $autoAdvance;
    final /* synthetic */ int $pageCount;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ boolean $shouldLoop;
    final /* synthetic */ ProgrammaticPageTrackingFlag $skipProgrammaticPageTracking;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CarouselComponentViewKt$EnableAutoAdvance$1$1(CarouselComponent.AutoAdvancePages autoAdvancePages, PagerState pagerState, boolean z2, int i3, ProgrammaticPageTrackingFlag programmaticPageTrackingFlag, Continuation<? super CarouselComponentViewKt$EnableAutoAdvance$1$1> continuation) {
        super(2, continuation);
        this.$autoAdvance = autoAdvancePages;
        this.$pagerState = pagerState;
        this.$shouldLoop = z2;
        this.$pageCount = i3;
        this.$skipProgrammaticPageTracking = programmaticPageTrackingFlag;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CarouselComponentViewKt$EnableAutoAdvance$1$1(this.$autoAdvance, this.$pagerState, this.$shouldLoop, this.$pageCount, this.$skipProgrammaticPageTracking, continuation);
    }

    /* JADX WARN: Can't wrap try/catch for region: R(6:20|21|22|28|23|(0)) */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0072, code lost:
    
        r11.$skipProgrammaticPageTracking.clear();
     */
    /* JADX WARN: Path cross not found for [B:18:0x003d, B:7:0x0011], limit reached: 33 */
    /* JADX WARN: Removed duplicated region for block: B:15:0x0033  */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0035  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:17:0x003b -> B:7:0x0011). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x004b -> B:7:0x0011). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:24:0x006f -> B:13:0x0024). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r12) throws java.lang.Throwable {
        /*
            r11 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r11.label
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L21
            if (r1 == r3) goto L1d
            if (r1 != r2) goto L15
            kotlin.ResultKt.b(r12)     // Catch: java.util.concurrent.CancellationException -> L13
        L11:
            r8 = r11
            goto L24
        L13:
            r8 = r11
            goto L72
        L15:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r12.<init>(r0)
            throw r12
        L1d:
            kotlin.ResultKt.b(r12)
            goto L35
        L21:
            kotlin.ResultKt.b(r12)
        L24:
            com.revenuecat.purchases.paywalls.components.CarouselComponent$AutoAdvancePages r12 = r11.$autoAdvance
            int r12 = r12.getMsTimePerPage()
            long r4 = (long) r12
            r11.label = r3
            java.lang.Object r12 = kotlinx.coroutines.DelayKt.b(r4, r11)
            if (r12 != r0) goto L35
            r8 = r11
            goto L71
        L35:
            androidx.compose.foundation.pager.PagerState r12 = r11.$pagerState
            boolean r12 = r12.c()
            if (r12 != 0) goto L11
            boolean r12 = r11.$shouldLoop
            int r1 = r11.$pageCount
            androidx.compose.foundation.pager.PagerState r4 = r11.$pagerState
            int r4 = r4.v()
            java.lang.Integer r12 = com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt.nextAutoAdvanceTargetPage(r12, r1, r4)
            if (r12 == 0) goto L11
            com.revenuecat.purchases.ui.revenuecatui.components.carousel.ProgrammaticPageTrackingFlag r1 = r11.$skipProgrammaticPageTracking
            r1.markProgrammaticScrollStarted()
            androidx.compose.foundation.pager.PagerState r4 = r11.$pagerState     // Catch: java.util.concurrent.CancellationException -> L13
            int r5 = r12.intValue()     // Catch: java.util.concurrent.CancellationException -> L13
            com.revenuecat.purchases.paywalls.components.CarouselComponent$AutoAdvancePages r12 = r11.$autoAdvance     // Catch: java.util.concurrent.CancellationException -> L13
            int r12 = r12.getMsTransitionTime()     // Catch: java.util.concurrent.CancellationException -> L13
            r1 = 0
            r6 = 6
            r7 = 0
            androidx.compose.animation.core.TweenSpec r7 = androidx.compose.animation.core.AnimationSpecKt.n(r12, r1, r7, r6, r7)     // Catch: java.util.concurrent.CancellationException -> L13
            r11.label = r2     // Catch: java.util.concurrent.CancellationException -> L13
            r6 = 0
            r9 = 2
            r10 = 0
            r8 = r11
            java.lang.Object r12 = androidx.compose.foundation.pager.PagerState.n(r4, r5, r6, r7, r8, r9, r10)     // Catch: java.util.concurrent.CancellationException -> L72
            if (r12 != r0) goto L24
        L71:
            return r0
        L72:
            com.revenuecat.purchases.ui.revenuecatui.components.carousel.ProgrammaticPageTrackingFlag r12 = r8.$skipProgrammaticPageTracking
            r12.clear()
            goto L24
        */
        throw new UnsupportedOperationException("Method not decompiled: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$EnableAutoAdvance$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CarouselComponentViewKt$EnableAutoAdvance$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
