package cz.mobilesoft.coreblock.scene.insights;

import androidx.compose.foundation.pager.PagerState;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt$IntervalNavigation$1$1", f = "InsightsScreenComponents.kt", l = {212, 214}, m = "invokeSuspend", v = 1)
final class InsightsScreenComponentsKt$IntervalNavigation$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f102607a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ InsightsViewState f102608b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ PagerState f102609c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsScreenComponentsKt$IntervalNavigation$1$1(InsightsViewState insightsViewState, PagerState pagerState, Continuation continuation) {
        super(2, continuation);
        this.f102608b = insightsViewState;
        this.f102609c = pagerState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new InsightsScreenComponentsKt$IntervalNavigation$1$1(this.f102608b, this.f102609c, continuation);
    }

    /* JADX WARN: Code restructure failed: missing block: B:13:0x003f, code lost:
    
        if (androidx.compose.foundation.pager.PagerState.f0(r4, r5, 0.0f, r10, 2, null) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:16:0x0056, code lost:
    
        if (androidx.compose.foundation.pager.PagerState.n(r1, r11, 0.0f, null, r10, 6, null) == r0) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0058, code lost:
    
        return r0;
     */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r11) throws java.lang.Throwable {
        /*
            r10 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
            int r1 = r10.f102607a
            r2 = 2
            r3 = 1
            if (r1 == 0) goto L1f
            if (r1 == r3) goto L1a
            if (r1 != r2) goto L12
            kotlin.ResultKt.b(r11)
            goto L59
        L12:
            java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r11.<init>(r0)
            throw r11
        L1a:
            kotlin.ResultKt.b(r11)
            r5 = r10
            goto L59
        L1f:
            kotlin.ResultKt.b(r11)
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState r11 = r10.f102608b
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState$InsightsPeriodType r11 = r11.a0()
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState$InsightsPeriodType r1 = cz.mobilesoft.coreblock.scene.insights.InsightsViewState.InsightsPeriodType.Trend
            if (r11 != r1) goto L42
            androidx.compose.foundation.pager.PagerState r4 = r10.f102609c
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState r11 = r10.f102608b
            int r5 = r11.v()
            r10.f102607a = r3
            r6 = 0
            r8 = 2
            r9 = 0
            r7 = r10
            java.lang.Object r11 = androidx.compose.foundation.pager.PagerState.f0(r4, r5, r6, r7, r8, r9)
            r5 = r7
            if (r11 != r0) goto L59
            goto L58
        L42:
            r5 = r10
            androidx.compose.foundation.pager.PagerState r1 = r5.f102609c
            cz.mobilesoft.coreblock.scene.insights.InsightsViewState r11 = r5.f102608b
            int r11 = r11.v()
            r5.f102607a = r2
            r3 = 0
            r4 = 0
            r6 = 6
            r7 = 0
            r2 = r11
            java.lang.Object r11 = androidx.compose.foundation.pager.PagerState.n(r1, r2, r3, r4, r5, r6, r7)
            if (r11 != r0) goto L59
        L58:
            return r0
        L59:
            kotlin.Unit r11 = kotlin.Unit.f139807a
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: cz.mobilesoft.coreblock.scene.insights.InsightsScreenComponentsKt$IntervalNavigation$1$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((InsightsScreenComponentsKt$IntervalNavigation$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
