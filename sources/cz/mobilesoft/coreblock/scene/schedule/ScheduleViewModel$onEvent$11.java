package cz.mobilesoft.coreblock.scene.schedule;

import cz.mobilesoft.coreblock.R;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewCommand;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.ScheduleViewModel$onEvent$11", f = "ScheduleViewModel.kt", l = {1040}, m = "invokeSuspend", v = 1)
final class ScheduleViewModel$onEvent$11 extends SuspendLambda implements Function1<Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f114799a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    int f114800b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    int f114801c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ ScheduleViewEvent f114802d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ ScheduleViewModel f114803f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ScheduleViewModel$onEvent$11(ScheduleViewEvent scheduleViewEvent, ScheduleViewModel scheduleViewModel, Continuation continuation) {
        super(1, continuation);
        this.f114802d = scheduleViewEvent;
        this.f114803f = scheduleViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Continuation continuation) {
        return new ScheduleViewModel$onEvent$11(this.f114802d, this.f114803f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f114801c;
        if (i3 == 0) {
            ResultKt.b(obj);
            Integer titleResId = ((ScheduleViewEvent.OnDisabledConditionClick) this.f114802d).a().getTitleResId();
            if (titleResId != null) {
                ScheduleViewModel scheduleViewModel = this.f114803f;
                int iIntValue = titleResId.intValue();
                String string = scheduleViewModel.A0().getString(R.string.Pt, scheduleViewModel.A0().getString(iIntValue));
                Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                ScheduleViewCommand.ShowDisabledDialog showDisabledDialog = new ScheduleViewCommand.ShowDisabledDialog(string);
                this.f114799a = iIntValue;
                this.f114800b = 0;
                this.f114801c = 1;
                if (scheduleViewModel.P0(showDisabledDialog, this) == objF) {
                    return objF;
                }
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
        return ((ScheduleViewModel$onEvent$11) create(continuation)).invokeSuspend(Unit.f139807a);
    }
}
