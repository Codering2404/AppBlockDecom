package cz.mobilesoft.coreblock.scene.schedule.preview;

import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewCommand;
import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$onEvent$3", f = "SchedulePreviewViewModel.kt", l = {408}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$onEvent$3 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f117495a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117496b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewEvent f117497c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$onEvent$3(SchedulePreviewViewModel schedulePreviewViewModel, SchedulePreviewViewEvent schedulePreviewViewEvent, Continuation continuation) {
        super(1, continuation);
        this.f117496b = schedulePreviewViewModel;
        this.f117497c = schedulePreviewViewEvent;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SchedulePreviewViewModel$onEvent$3(this.f117496b, this.f117497c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f117495a;
        if (i3 == 0) {
            ResultKt.b(obj);
            this.f117496b.q1(((SchedulePreviewViewEvent.OnProfileDeleted) this.f117497c).a());
            SchedulePreviewViewModel schedulePreviewViewModel = this.f117496b;
            SchedulePreviewViewCommand.OnCloseClicked onCloseClicked = SchedulePreviewViewCommand.OnCloseClicked.f117385a;
            this.f117495a = 1;
            if (schedulePreviewViewModel.P0(onCloseClicked, this) == objF) {
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
        return ((SchedulePreviewViewModel$onEvent$3) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
