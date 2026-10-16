package cz.mobilesoft.coreblock.scene.insights;

import cz.mobilesoft.coreblock.scene.insights.InsightsViewCommand;
import cz.mobilesoft.coreblock.scene.strictmode3.followschedules.ScheduleSelectViewState;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.insights.BaseInsightsViewModel$onScheduleClicked$1", f = "BaseInsightsViewModel.kt", l = {143}, m = "invokeSuspend", v = 1)
final class BaseInsightsViewModel$onScheduleClicked$1 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    Object f102522a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    Object f102523b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f102524c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    int f102525d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ BaseInsightsViewModel f102526f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ int f102527g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    BaseInsightsViewModel$onScheduleClicked$1(BaseInsightsViewModel baseInsightsViewModel, int i3, Continuation continuation) {
        super(1, continuation);
        this.f102526f = baseInsightsViewModel;
        this.f102527g = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new BaseInsightsViewModel$onScheduleClicked$1(this.f102526f, this.f102527g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f102525d;
        if (i3 == 0) {
            ResultKt.b(obj);
            List listH1 = this.f102526f.h1();
            ScheduleSelectViewState.ScheduleDto scheduleDto = (ScheduleSelectViewState.ScheduleDto) listH1.get(this.f102527g);
            int i4 = (scheduleDto.j() && scheduleDto.i()) ? 1 : 0;
            if (!this.f102526f.i1() || i4 == 0) {
                ScheduleSelectViewState.ScheduleDto scheduleDtoB = ScheduleSelectViewState.ScheduleDto.b(scheduleDto, 0L, 0, 0, null, false, null, !scheduleDto.j(), false, false, false, false, 1983, null);
                List mutableList = CollectionsKt.toMutableList((Collection) listH1);
                mutableList.set(this.f102527g, scheduleDtoB);
                this.f102526f.p1(mutableList);
                return Unit.f139807a;
            }
            BaseInsightsViewModel baseInsightsViewModel = this.f102526f;
            InsightsViewCommand.ShowStrictModeActive showStrictModeActive = InsightsViewCommand.ShowStrictModeActive.f102670a;
            this.f102522a = SpillingKt.a(listH1);
            this.f102523b = SpillingKt.a(scheduleDto);
            this.f102524c = i4;
            this.f102525d = 1;
            if (baseInsightsViewModel.P0(showStrictModeActive, this) == objF) {
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
        return ((BaseInsightsViewModel$onScheduleClicked$1) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
