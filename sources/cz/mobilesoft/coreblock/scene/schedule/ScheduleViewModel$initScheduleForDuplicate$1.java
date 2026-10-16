package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.storage.room.entity.blocking.Profile;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$initScheduleForDuplicate$1", f = "ScheduleViewModel.kt", l = {372}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$initScheduleForDuplicate$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114668a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114669b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ ScheduleDTO f114670c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$initScheduleForDuplicate$1(ScheduleViewModel scheduleViewModel, ScheduleDTO scheduleDTO, Continuation continuation) {
        super(2, continuation);
        this.f114669b = scheduleViewModel;
        this.f114670c = scheduleDTO;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ScheduleViewModel$initScheduleForDuplicate$1(this.f114669b, this.f114670c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114668a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f114669b.T.setValue(ScheduleDTO.b(this.f114670c, null, null, false, false, false, false, false, false, 0, null, null, null, null, null, null, null, null, null, null, null, null, false, false, false, 0L, 0L, null, false, null, 536870911, null));
            if (this.f114670c.k() == Profile.BlockingMode.Blocklist) {
                ScheduleViewModel scheduleViewModel = this.f114669b;
                this.f114668a = 1;
                if (scheduleViewModel.v3(this) == objF) {
                    return objF;
                }
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        ScheduleViewModel.u3(this.f114669b, null, null, 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ScheduleViewModel$initScheduleForDuplicate$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
