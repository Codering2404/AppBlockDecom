package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableStateFlow;

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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForNew$1", f = "ScheduleViewModel.kt", l = {418}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$initScheduleForNew$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114685a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ List f114686b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ List f114687c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114688d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ConditionDTO f114689f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$initScheduleForNew$1(List list, List list2, ScheduleViewModel scheduleViewModel, ConditionDTO conditionDTO, Continuation continuation) {
        super(2, continuation);
        this.f114686b = list;
        this.f114687c = list2;
        this.f114688d = scheduleViewModel;
        this.f114689f = conditionDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$initScheduleForNew$1(this.f114686b, this.f114687c, this.f114688d, this.f114689f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114685a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (this.f114686b != null || this.f114687c != null) {
                ScheduleViewModel scheduleViewModel = this.f114688d;
                ScheduleDTO scheduleDTO = scheduleViewModel.N;
                List list = this.f114686b;
                ArrayList arrayList = list != null ? new ArrayList(list) : new ArrayList();
                List list2 = this.f114687c;
                scheduleViewModel.N = ScheduleDTO.b(scheduleDTO, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, arrayList, list2 != null ? new ArrayList(list2) : new ArrayList(), null, null, null, false, false, false, 0L, 0L, null, false, null, 536674303, null);
                ScheduleViewModel scheduleViewModel2 = this.f114688d;
                scheduleViewModel2.O = ProfileToViewDTOHelperKt.x(scheduleViewModel2.N, this.f114688d.f114592r.J());
            }
            ConditionDTO conditionDTO = this.f114689f;
            if (conditionDTO != null) {
                if (conditionDTO instanceof ConditionDTO.TimeDTO) {
                    ScheduleViewModel scheduleViewModel3 = this.f114688d;
                    ScheduleDTO scheduleDTO2 = scheduleViewModel3.N;
                    ConditionDTO conditionDTO2 = this.f114689f;
                    scheduleViewModel3.N = ScheduleDTO.b(scheduleDTO2, null, null, false, false, false, false, false, false, ((ConditionDTO.TimeDTO) conditionDTO2).a().setTo(1), null, null, null, null, null, (ConditionDTO.TimeDTO) conditionDTO2, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536854271, null);
                } else if (conditionDTO instanceof ConditionDTO.UsageLimitDTO) {
                    ScheduleViewModel scheduleViewModel4 = this.f114688d;
                    ScheduleDTO scheduleDTO3 = scheduleViewModel4.N;
                    ConditionDTO conditionDTO3 = this.f114689f;
                    scheduleViewModel4.N = ScheduleDTO.b(scheduleDTO3, null, null, false, false, false, false, false, false, ((ConditionDTO.UsageLimitDTO) conditionDTO3).a().setTo(16), null, null, null, (ConditionDTO.UsageLimitDTO) conditionDTO3, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536866559, null);
                } else if (conditionDTO instanceof ConditionDTO.LaunchCountDTO) {
                    ScheduleViewModel scheduleViewModel5 = this.f114688d;
                    ScheduleDTO scheduleDTO4 = scheduleViewModel5.N;
                    ConditionDTO conditionDTO4 = this.f114689f;
                    scheduleViewModel5.N = ScheduleDTO.b(scheduleDTO4, null, null, false, false, false, false, false, false, ((ConditionDTO.LaunchCountDTO) conditionDTO4).a().setTo(32), null, null, null, null, (ConditionDTO.LaunchCountDTO) conditionDTO4, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536862463, null);
                }
            }
            ScheduleViewModel scheduleViewModel6 = this.f114688d;
            this.f114685a = 1;
            if (scheduleViewModel6.v3(this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        MutableStateFlow mutableStateFlow = this.f114688d.T;
        ScheduleDTO scheduleDTO5 = this.f114688d.N;
        String string = this.f114688d.A0().getString(R.string.g4);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        mutableStateFlow.setValue(ScheduleDTO.b(scheduleDTO5, null, string, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870909, null));
        ScheduleViewModel.u3(this.f114688d, null, null, 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$initScheduleForNew$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
