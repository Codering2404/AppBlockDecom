package cz.mobilesoft.coreblock.scene.insights;

import cz.mobilesoft.coreblock.enums.AppDistractionType;
import cz.mobilesoft.coreblock.scene.insights.InsightsViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;
import kotlinx.collections.immutable.ImmutableList;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$updateTrendInterval$1", f = "InsightsViewModel.kt", l = {674}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$updateTrendInterval$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102918a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102919b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f102920c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f102921d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102922f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ InsightsViewState.TrendInterval f102923g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$updateTrendInterval$1(InsightsViewModel insightsViewModel, InsightsViewState.TrendInterval trendInterval, Continuation continuation) {
        super(1, continuation);
        this.f102922f = insightsViewModel;
        this.f102923g = trendInterval;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$updateTrendInterval$1(this.f102922f, this.f102923g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102921d;
        if (i3 == 0) {
            ResultKt.b(obj);
            InsightsViewState insightsViewStateX1 = InsightsViewModel.x1(this.f102922f);
            ImmutableList immutableListK = insightsViewStateX1.K();
            if (immutableListK.isEmpty()) {
                return Unit.f139807a;
            }
            int iP = RangesKt.p(this.f102923g.ordinal(), 0, immutableListK.size() - 1);
            AppDistractionType appDistractionTypeF = insightsViewStateX1.f();
            InsightsViewState.InsightsPeriodType insightsPeriodTypeA0 = insightsViewStateX1.a0();
            int iOrdinal = this.f102923g.ordinal();
            InsightsViewModel insightsViewModel = this.f102922f;
            this.f102918a = SpillingKt.a(insightsViewStateX1);
            this.f102919b = SpillingKt.a(immutableListK);
            this.f102920c = iP;
            this.f102921d = 1;
            if (InsightsViewModel.H2(insightsViewModel, immutableListK, iP, insightsPeriodTypeA0, iOrdinal, null, appDistractionTypeF, null, this, 80, null) == objF) {
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
        return ((InsightsViewModel$updateTrendInterval$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
