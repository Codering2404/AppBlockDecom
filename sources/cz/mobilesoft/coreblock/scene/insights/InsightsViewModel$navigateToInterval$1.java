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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.InsightsViewModel$navigateToInterval$1", f = "InsightsViewModel.kt", l = {695}, m = "invokeSuspend", v = 1)
final class InsightsViewModel$navigateToInterval$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102763a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102764b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f102765c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f102766d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ InsightsViewModel f102767f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ int f102768g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    InsightsViewModel$navigateToInterval$1(InsightsViewModel insightsViewModel, int i3, Continuation continuation) {
        super(1, continuation);
        this.f102767f = insightsViewModel;
        this.f102768g = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new InsightsViewModel$navigateToInterval$1(this.f102767f, this.f102768g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102766d;
        if (i3 == 0) {
            ResultKt.b(obj);
            InsightsViewState insightsViewStateX1 = InsightsViewModel.x1(this.f102767f);
            ImmutableList immutableListK = insightsViewStateX1.K();
            if (immutableListK.isEmpty()) {
                return Unit.f139807a;
            }
            int iP = RangesKt.p(this.f102768g, 0, immutableListK.size() - 1);
            AppDistractionType appDistractionTypeF = insightsViewStateX1.f();
            InsightsViewState.InsightsPeriodType insightsPeriodTypeA0 = insightsViewStateX1.a0();
            int iB0 = insightsViewStateX1.b0();
            InsightsViewModel insightsViewModel = this.f102767f;
            this.f102763a = SpillingKt.a(insightsViewStateX1);
            this.f102764b = SpillingKt.a(immutableListK);
            this.f102765c = iP;
            this.f102766d = 1;
            if (InsightsViewModel.H2(insightsViewModel, immutableListK, iP, insightsPeriodTypeA0, iB0, null, appDistractionTypeF, null, this, 80, null) == objF) {
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
        return ((InsightsViewModel$navigateToInterval$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
