package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.enums.ScheduleTemplate;
import cz.mobilesoft.coreblock.scene.schedule.condition.ConditionDTO;
import cz.mobilesoft.coreblock.scene.schedule.condition.IntervalDTO;
import cz.mobilesoft.coreblock.storage.room.entity.blocking.Interval;
import cz.mobilesoft.coreblock.util.profile.ProfileToViewDTOHelperKt;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleWithTemplate$1", f = "ScheduleViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$initScheduleWithTemplate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114705a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduleTemplate f114706b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114707c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$initScheduleWithTemplate$1(ScheduleTemplate scheduleTemplate, ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114706b = scheduleTemplate;
        this.f114707c = scheduleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$initScheduleWithTemplate$1(this.f114706b, this.f114707c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ConditionDTO.UsageLimitDTO usageLimitDTO;
        IntrinsicsKt.f();
        if (this.f114705a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        int dayFlags = this.f114706b.getDayFlags();
        Interval interval = this.f114706b.getInterval();
        ConditionDTO.TimeDTO timeDTO = new ConditionDTO.TimeDTO(dayFlags, CollectionsKt.arrayListOf(new IntervalDTO(interval.b(), interval.a(), null, null, 12, null)), 0, 4, null);
        Long usageLimitInMinutes = this.f114706b.getUsageLimitInMinutes();
        if (usageLimitInMinutes != null) {
            usageLimitDTO = new ConditionDTO.UsageLimitDTO(TimeUnit.MINUTES.toMillis(usageLimitInMinutes.longValue()), null, 0L, null, null, 30, null);
        } else {
            usageLimitDTO = null;
        }
        int to = timeDTO.a().setTo(0);
        if (usageLimitDTO != null) {
            to = usageLimitDTO.a().setTo(to);
        }
        int i3 = to;
        ScheduleViewModel scheduleViewModel = this.f114707c;
        scheduleViewModel.O = ProfileToViewDTOHelperKt.x(scheduleViewModel.N, this.f114707c.f114592r.J());
        MutableStateFlow mutableStateFlow = this.f114707c.T;
        ScheduleDTO scheduleDTO = this.f114707c.N;
        String string = this.f114707c.A0().getString(this.f114706b.getTitle());
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        mutableStateFlow.setValue(ScheduleDTO.b(scheduleDTO, null, string, false, false, false, false, false, false, i3, null, null, null, usageLimitDTO, null, timeDTO, null, null, null, null, null, null, true, true, false, 0L, 0L, this.f114706b.getEmoji(), false, null, 463449853, null));
        ScheduleViewModel.u3(this.f114707c, null, null, 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$initScheduleWithTemplate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
