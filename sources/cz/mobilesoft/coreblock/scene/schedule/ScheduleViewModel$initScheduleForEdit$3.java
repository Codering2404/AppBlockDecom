package cz.mobilesoft.coreblock.scene.schedule;

import com.facebook.internal.FacebookRequestErrorClassification;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import cz.mobilesoft.coreblock.usecase.SchedulingConflictUseCase;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForEdit$3", f = "ScheduleViewModel.kt", l = {FacebookRequestErrorClassification.EC_TOO_MANY_USER_ACTION_CALLS}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$initScheduleForEdit$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114682a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114683b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScheduleDTO f114684c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$initScheduleForEdit$3(ScheduleViewModel scheduleViewModel, ScheduleDTO scheduleDTO, Continuation continuation) {
        super(2, continuation);
        this.f114683b = scheduleViewModel;
        this.f114684c = scheduleDTO;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState q(List list, ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, null, null, false, null, false, false, false, false, null, list, null, null, null, false, null, null, null, 130559, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$initScheduleForEdit$3(this.f114683b, this.f114684c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114682a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SchedulingConflictUseCase schedulingConflictUseCaseM3 = this.f114683b.m3();
            SchedulingConflictUseCase.Params params = new SchedulingConflictUseCase.Params(this.f114684c.o(), this.f114684c.k(), this.f114684c.e(), this.f114684c.C(), this.f114684c.p(), this.f114684c.z() == 64, this.f114684c.x(), this.f114684c.q(), this.f114684c.A());
            this.f114682a = 1;
            obj = schedulingConflictUseCaseM3.c(params, this);
            if (obj == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        final List list = (List) obj;
        this.f114683b.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.o3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ScheduleViewModel$initScheduleForEdit$3.q(list, (ScheduleViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$initScheduleForEdit$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
