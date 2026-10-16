package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.scene.schedule.detail.LockState;
import cz.mobilesoft.coreblock.scene.schedule.detail.ScheduleViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$handleRemainingLockTimer$1", f = "ScheduleViewModel.kt", l = {}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$handleRemainingLockTimer$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114632a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f114633b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114634c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$handleRemainingLockTimer$1(ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(2, continuation);
        this.f114634c = scheduleViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ScheduleViewState A(Long l3, ScheduleViewState scheduleViewState) {
        return ScheduleViewState.b(scheduleViewState, ScheduleViewState.DetailViewState.b(scheduleViewState.g(), null, null, null, false, false, null, null, null, false, null, null, null, null, false, false, l3, false, false, false, false, false, false, false, null, null, null, 67076095, null), null, false, null, false, false, false, false, null, null, null, null, null, false, null, null, null, 131070, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LockState z(LockState lockState) {
        return LockState.b(lockState, false, false, null, null, 7, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        ScheduleViewModel$handleRemainingLockTimer$1 scheduleViewModel$handleRemainingLockTimer$1 = new ScheduleViewModel$handleRemainingLockTimer$1(this.f114634c, continuation);
        scheduleViewModel$handleRemainingLockTimer$1.f114633b = obj;
        return scheduleViewModel$handleRemainingLockTimer$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final Long l3 = (Long) this.f114633b;
        IntrinsicsKt.f();
        if (this.f114632a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        boolean z2 = ScheduleViewModel.q1(this.f114634c).g().j() != null;
        if (l3 == null || l3.longValue() <= 0) {
            l3 = null;
        }
        if (z2 && l3 == null) {
            this.f114634c.S4(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.f3
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj2) {
                    return ScheduleViewModel$handleRemainingLockTimer$1.z((LockState) obj2);
                }
            });
        }
        this.f114634c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.scene.schedule.g3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj2) {
                return ScheduleViewModel$handleRemainingLockTimer$1.A(l3, (ScheduleViewState) obj2);
            }
        });
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: y, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Long l3, Continuation continuation) {
        return ((ScheduleViewModel$handleRemainingLockTimer$1) create(l3, continuation)).invokeSuspend(Unit.f139807a);
    }
}
