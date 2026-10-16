package cz.mobilesoft.coreblock.scene.schedule.usagelimit;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewCommand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.usagelimit.UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1", f = "UsageLimitTimePickerBottomSheet.kt", l = {}, m = "invokeSuspend", v = 1)
final class UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1 extends SuspendLambda implements Function2<TimePickerViewCommand, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f117978a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f117979b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f117980c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1(MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f117980c = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1 usageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1 = new UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1(this.f117980c, continuation);
        usageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1.f117979b = obj;
        return usageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: h, reason: merged with bridge method [inline-methods] */
    public final Object invoke(TimePickerViewCommand timePickerViewCommand, Continuation continuation) {
        return ((UsageLimitTimePickerBottomSheetKt$ConditionSelectorBottomSheet$2$6$1) create(timePickerViewCommand, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        TimePickerViewCommand timePickerViewCommand = (TimePickerViewCommand) this.f117979b;
        IntrinsicsKt.f();
        if (this.f117978a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (timePickerViewCommand instanceof TimePickerViewCommand.OnShowSnackbarCommand) {
            UsageLimitTimePickerBottomSheetKt.q(this.f117980c, ((TimePickerViewCommand.OnShowSnackbarCommand) timePickerViewCommand).a());
        }
        return Unit.f139807a;
    }
}
