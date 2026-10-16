package cz.mobilesoft.coreblock.scene.schedule.usagelimit;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleActivity;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.usagelimit.UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$1$1", f = "UsageLimitTimePickerBottomSheet.kt", l = {}, m = "invokeSuspend", v = 1)
final class UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f117973a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ TimePickerViewModel f117974b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f117975c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$1$1(TimePickerViewModel timePickerViewModel, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f117974b = timePickerViewModel;
        this.f117975c = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$1$1(this.f117974b, this.f117975c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f117973a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        TimePickerViewModel.p1(this.f117974b, ((ScheduleActivity.BlockingConditionConfig) this.f117975c.getValue()).c(), Boxing.e(((ScheduleActivity.BlockingConditionConfig) this.f117975c.getValue()).a()), null, false, 12, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
