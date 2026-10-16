package cz.mobilesoft.coreblock.view.timepicker;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt$SwipeLazyColumn$4$1", f = "ComposeSwipeableTimePicker.kt", l = {402}, m = "invokeSuspend", v = 1)
final class ComposeSwipeableTimePickerKt$SwipeLazyColumn$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f132990a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyListState f132991b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f132992c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function0 f132993d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f132994f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeSwipeableTimePickerKt$SwipeLazyColumn$4$1(LazyListState lazyListState, int i3, Function0 function0, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f132991b = lazyListState;
        this.f132992c = i3;
        this.f132993d = function0;
        this.f132994f = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposeSwipeableTimePickerKt$SwipeLazyColumn$4$1(this.f132991b, this.f132992c, this.f132993d, this.f132994f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ComposeSwipeableTimePickerKt$SwipeLazyColumn$4$1 composeSwipeableTimePickerKt$SwipeLazyColumn$4$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f132990a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (ComposeSwipeableTimePickerKt.y(this.f132994f)) {
                return Unit.f139807a;
            }
            LazyListState lazyListState = this.f132991b;
            int i4 = this.f132992c;
            this.f132990a = 1;
            composeSwipeableTimePickerKt$SwipeLazyColumn$4$1 = this;
            if (LazyListState.l(lazyListState, i4, 0, composeSwipeableTimePickerKt$SwipeLazyColumn$4$1, 2, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            composeSwipeableTimePickerKt$SwipeLazyColumn$4$1 = this;
        }
        ComposeSwipeableTimePickerKt.z(composeSwipeableTimePickerKt$SwipeLazyColumn$4$1.f132994f, true);
        composeSwipeableTimePickerKt$SwipeLazyColumn$4$1.f132993d.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ComposeSwipeableTimePickerKt$SwipeLazyColumn$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
