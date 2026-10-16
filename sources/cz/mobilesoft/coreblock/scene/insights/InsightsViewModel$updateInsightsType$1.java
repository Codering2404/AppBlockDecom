package cz.mobilesoft.coreblock.scene.insights;

import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import cz.mobilesoft.coreblock.util.analytics.AnswersHelper;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$updateInsightsType$1", f = "InsightsViewModel.kt", l = {653}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$updateInsightsType$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102911a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f102912b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f102913c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102914d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ InsightsViewState.InsightsPeriodType f102915f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$updateInsightsType$1(InsightsViewModel insightsViewModel, InsightsViewState.InsightsPeriodType insightsPeriodType, Continuation continuation) {
        super(1, continuation);
        this.f102914d = insightsViewModel;
        this.f102915f = insightsPeriodType;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$updateInsightsType$1(this.f102914d, this.f102915f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102913c;
        if (i3 == 0) {
            ResultKt.b(obj);
            List listU1 = this.f102914d.U1(this.f102915f);
            if (listU1.isEmpty()) {
                return Unit.f139807a;
            }
            int iB0 = this.f102915f == InsightsViewState.InsightsPeriodType.Trend ? InsightsViewModel.x1(this.f102914d).b0() : Math.max(0, listU1.size() - 1);
            if (this.f102914d.p2() != null) {
                AnswersHelper.f128199a.j0(this.f102914d.p2(), this.f102915f.getEventName());
            } else {
                AnswersHelper.f128199a.s2(this.f102915f.getEventName());
            }
            InsightsViewModel insightsViewModel = this.f102914d;
            InsightsViewState.InsightsPeriodType insightsPeriodType = this.f102915f;
            int iB02 = InsightsViewModel.x1(insightsViewModel).b0();
            AppDistractionType appDistractionTypeF = InsightsViewModel.x1(this.f102914d).f();
            this.f102911a = SpillingKt.a(listU1);
            this.f102912b = iB0;
            this.f102913c = 1;
            if (InsightsViewModel.H2(insightsViewModel, listU1, iB0, insightsPeriodType, iB02, null, appDistractionTypeF, null, this, 80, null) == objF) {
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

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation continuation) {
        return ((InsightsViewModel$updateInsightsType$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
