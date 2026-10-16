package cz.mobilesoft.coreblock.scene.schedule.preview;

import cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewCommand;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.preview.SchedulePreviewViewModel$onEvent$4", f = "SchedulePreviewViewModel.kt", l = {418}, m = "invokeSuspend", v = 1)
final class SchedulePreviewViewModel$onEvent$4 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f117498a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ SchedulePreviewViewModel f117499b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SchedulePreviewViewModel$onEvent$4(SchedulePreviewViewModel schedulePreviewViewModel, Continuation continuation) {
        super(1, continuation);
        this.f117499b = schedulePreviewViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new SchedulePreviewViewModel$onEvent$4(this.f117499b, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f117498a;
        if (i3 == 0) {
            ResultKt.b(obj);
            SchedulePreviewViewModel schedulePreviewViewModel = this.f117499b;
            SchedulePreviewViewCommand.OpenPremiumGenericActivity openPremiumGenericActivity = SchedulePreviewViewCommand.OpenPremiumGenericActivity.f117393a;
            this.f117498a = 1;
            if (schedulePreviewViewModel.P0(openPremiumGenericActivity, this) == objF) {
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
        return ((SchedulePreviewViewModel$onEvent$4) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
