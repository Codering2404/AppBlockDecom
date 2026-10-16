package cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker;

import androidx.compose.material3.DatePickerState;
import cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.PauseBlockingViewEvent;
import java.util.Calendar;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.dashboard.blocking.pause.datetimepicker.DateTimePickerScreenKt$PauseDatePicker$1$1", f = "DateTimePickerScreen.kt", l = {}, m = "invokeSuspend", v = 1)
final class DateTimePickerScreenKt$PauseDatePicker$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f100229a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1 f100230b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ DatePickerState f100231c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Calendar f100232d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DateTimePickerScreenKt$PauseDatePicker$1$1(Function1 function1, DatePickerState datePickerState, Calendar calendar, Continuation continuation) {
        super(2, continuation);
        this.f100230b = function1;
        this.f100231c = datePickerState;
        this.f100232d = calendar;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DateTimePickerScreenKt$PauseDatePicker$1$1(this.f100230b, this.f100231c, this.f100232d, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f100229a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Function1 function1 = this.f100230b;
        Long lI = this.f100231c.i();
        function1.invoke(new PauseBlockingViewEvent.OnDateSelected(lI != null ? lI.longValue() : this.f100232d.getTimeInMillis()));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DateTimePickerScreenKt$PauseDatePicker$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
