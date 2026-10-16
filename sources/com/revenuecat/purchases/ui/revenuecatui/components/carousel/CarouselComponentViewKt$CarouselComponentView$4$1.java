package com.revenuecat.purchases.ui.revenuecatui.components.carousel;

import androidx.compose.foundation.pager.PagerState;
import androidx.compose.runtime.SnapshotStateKt;
import com.revenuecat.purchases.ui.revenuecatui.components.style.CarouselComponentStyle;
import com.revenuecat.purchases.ui.revenuecatui.helpers.CarouselPageChangeInteraction;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionFactoriesKt;
import com.revenuecat.purchases.ui.revenuecatui.helpers.PaywallComponentInteractionTracker;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/* JADX INFO: Access modifiers changed from: package-private */
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$4$1", f = "CarouselComponentView.kt", l = {131}, m = "invokeSuspend")
public final class CarouselComponentViewKt$CarouselComponentView$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaywallComponentInteractionTracker $componentInteractionTracker;
    final /* synthetic */ int $pageCount;
    final /* synthetic */ PagerState $pagerState;
    final /* synthetic */ ProgrammaticPageTrackingFlag $skipProgrammaticPageTracking;
    final /* synthetic */ CarouselComponentStyle $style;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CarouselComponentViewKt$CarouselComponentView$4$1(PagerState pagerState, ProgrammaticPageTrackingFlag programmaticPageTrackingFlag, int i3, PaywallComponentInteractionTracker paywallComponentInteractionTracker, CarouselComponentStyle carouselComponentStyle, Continuation<? super CarouselComponentViewKt$CarouselComponentView$4$1> continuation) {
        super(2, continuation);
        this.$pagerState = pagerState;
        this.$skipProgrammaticPageTracking = programmaticPageTrackingFlag;
        this.$pageCount = i3;
        this.$componentInteractionTracker = paywallComponentInteractionTracker;
        this.$style = carouselComponentStyle;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CarouselComponentViewKt$CarouselComponentView$4$1(this.$pagerState, this.$skipProgrammaticPageTracking, this.$pageCount, this.$componentInteractionTracker, this.$style, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            final Ref.IntRef intRef = new Ref.IntRef();
            intRef.f140142a = this.$pagerState.v();
            final PagerState pagerState = this.$pagerState;
            Flow flowQ = SnapshotStateKt.q(new Function0<Integer>() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$4$1.1
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final Integer invoke() {
                    return Integer.valueOf(pagerState.v());
                }
            });
            final ProgrammaticPageTrackingFlag programmaticPageTrackingFlag = this.$skipProgrammaticPageTracking;
            final int i4 = this.$pageCount;
            final PaywallComponentInteractionTracker paywallComponentInteractionTracker = this.$componentInteractionTracker;
            final CarouselComponentStyle carouselComponentStyle = this.$style;
            FlowCollector flowCollector = new FlowCollector() { // from class: com.revenuecat.purchases.ui.revenuecatui.components.carousel.CarouselComponentViewKt$CarouselComponentView$4$1.2
                private static final String emit$pageName(CarouselComponentStyle carouselComponentStyle2, int i5) {
                    String str = (String) CollectionsKt.getOrNull(carouselComponentStyle2.getPageContextNames(), i5);
                    if (str == null || StringsKt.p0(str)) {
                        return null;
                    }
                    return str;
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                    return emit(((Number) obj2).intValue(), (Continuation<? super Unit>) continuation);
                }

                public final Object emit(int i5, Continuation<? super Unit> continuation) {
                    if (i5 != intRef.f140142a) {
                        if (!programmaticPageTrackingFlag.consumeShouldSkipPageChange()) {
                            int i6 = i4;
                            int i7 = i5 % i6;
                            int i8 = intRef.f140142a % i6;
                            paywallComponentInteractionTracker.track(PaywallComponentInteractionFactoriesKt.paywallCarouselPageChange(new CarouselPageChangeInteraction(carouselComponentStyle.getComponentName(), i7, i8, carouselComponentStyle.getInitialPageIndex(), emit$pageName(carouselComponentStyle, i8), emit$pageName(carouselComponentStyle, i7))));
                        }
                        intRef.f140142a = i5;
                    }
                    return Unit.f139807a;
                }
            };
            this.label = 1;
            if (flowQ.collect(flowCollector, this) == objF) {
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((CarouselComponentViewKt$CarouselComponentView$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
