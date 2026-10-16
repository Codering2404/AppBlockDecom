package cz.mobilesoft.coreblock.scene.strictmode3.access;

import androidx.compose.runtime.MutableState;
import cz.mobilesoft.coreblock.enums.StrictModeAccessMethod;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerConfig;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel;
import java.util.concurrent.TimeUnit;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.strictmode3.access.StrictModeTimerBottomSheetKt$StrictModeTimerBottomSheet$1$1$1", f = "StrictModeTimerBottomSheet.kt", l = {}, m = "invokeSuspend", v = 1)
final class StrictModeTimerBottomSheetKt$StrictModeTimerBottomSheet$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f121572a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ MutableState f121573b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TimePickerViewModel f121574c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StrictModeTimerBottomSheetKt$StrictModeTimerBottomSheet$1$1$1(MutableState mutableState, TimePickerViewModel timePickerViewModel, Continuation continuation) {
        super(2, continuation);
        this.f121573b = mutableState;
        this.f121574c = timePickerViewModel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StrictModeTimerBottomSheetKt$StrictModeTimerBottomSheet$1$1$1(this.f121573b, this.f121574c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f121572a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (this.f121573b.getValue() == StrictModeAccessMethod.Cooldown) {
            TimePickerViewModel.p1(this.f121574c, TimePickerConfig.f133036h.a(), Boxing.e(TimeUnit.MINUTES.toMillis(3L)), null, false, 12, null);
        } else {
            TimePickerViewModel.p1(this.f121574c, new TimePickerConfig(new TimePickerConfig.TimePickerType.Minutes(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Hours(0L, 0L, 3, null), new TimePickerConfig.TimePickerType.Days(0L, 99L), false, null, false, 56, null), null, null, true, 6, null);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StrictModeTimerBottomSheetKt$StrictModeTimerBottomSheet$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
