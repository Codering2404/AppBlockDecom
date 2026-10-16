package androidx.compose.material3;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.material3.internal.CalendarModel;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.IntRange;
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
/* JADX INFO: loaded from: classes.dex */
@Metadata
@DebugMetadata(c = "androidx.compose.material3.DatePickerKt$HorizontalMonthsList$2$1", f = "DatePicker.kt", l = {1698}, m = "invokeSuspend")
final class DatePickerKt$HorizontalMonthsList$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f17066a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyListState f17067b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f17068c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ CalendarModel f17069d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ IntRange f17070f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DatePickerKt$HorizontalMonthsList$2$1(LazyListState lazyListState, Function1 function1, CalendarModel calendarModel, IntRange intRange, Continuation continuation) {
        super(2, continuation);
        this.f17067b = lazyListState;
        this.f17068c = function1;
        this.f17069d = calendarModel;
        this.f17070f = intRange;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DatePickerKt$HorizontalMonthsList$2$1(this.f17067b, this.f17068c, this.f17069d, this.f17070f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f17066a;
        if (i3 == 0) {
            ResultKt.b(obj);
            LazyListState lazyListState = this.f17067b;
            Function1 function1 = this.f17068c;
            CalendarModel calendarModel = this.f17069d;
            IntRange intRange = this.f17070f;
            this.f17066a = 1;
            if (DatePickerKt.L(lazyListState, function1, calendarModel, intRange, this) == objF) {
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

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((DatePickerKt$HorizontalMonthsList$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
