package cz.mobilesoft.coreblock.view.timepicker;

import cz.mobilesoft.coreblock.util.helperextension.ComparableExtKt;
import cz.mobilesoft.coreblock.view.timepicker.TimePickerViewCommand;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.timepicker.TimePickerViewModel$updateCountdown$1", f = "TimePickerViewModel.kt", l = {168}, m = "invokeSuspend", v = 1)
final class TimePickerViewModel$updateCountdown$1 extends SuspendLambda implements Function2<Long, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f133092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    /* synthetic */ Object f133093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ TimePickerViewModel f133094c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    TimePickerViewModel$updateCountdown$1(TimePickerViewModel timePickerViewModel, Continuation continuation) {
        super(2, continuation);
        this.f133094c = timePickerViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TimePickerViewState y(Long l3, TimePickerViewState timePickerViewState) {
        return TimePickerViewState.b(timePickerViewState, null, null, null, false, null, 0, 0, 0, 0, false, 0L, 0L, 0L, l3.longValue(), null, null, null, false, 253951, null);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        TimePickerViewModel$updateCountdown$1 timePickerViewModel$updateCountdown$1 = new TimePickerViewModel$updateCountdown$1(this.f133094c, continuation);
        timePickerViewModel$updateCountdown$1.f133093b = obj;
        return timePickerViewModel$updateCountdown$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        final Long l3 = (Long) this.f133093b;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f133092a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (l3 == null || ComparableExtKt.d(l3, Boxing.e(0L))) {
                TimePickerViewModel timePickerViewModel = this.f133094c;
                TimePickerViewCommand.CloseTimerScreenCommand closeTimerScreenCommand = TimePickerViewCommand.CloseTimerScreenCommand.f133061a;
                this.f133093b = SpillingKt.a(l3);
                this.f133092a = 1;
                if (timePickerViewModel.P0(closeTimerScreenCommand, this) == objF) {
                    return objF;
                }
            } else {
                this.f133094c.Q0(new Function1() { // from class: cz.mobilesoft.coreblock.view.timepicker.k1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return TimePickerViewModel$updateCountdown$1.y(l3, (TimePickerViewState) obj2);
                    }
                });
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    /* JADX INFO: renamed from: q, reason: merged with bridge method [inline-methods] */
    public final Object invoke(Long l3, Continuation continuation) {
        return ((TimePickerViewModel$updateCountdown$1) create(l3, continuation)).invokeSuspend(Unit.f139807a);
    }
}
