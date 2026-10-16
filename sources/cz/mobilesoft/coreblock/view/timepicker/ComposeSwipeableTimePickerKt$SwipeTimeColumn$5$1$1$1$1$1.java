package cz.mobilesoft.coreblock.view.timepicker;

import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1", f = "ComposeSwipeableTimePicker.kt", l = {235}, m = "invokeSuspend", v = 1)
final class ComposeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f132999a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ Function1 f133000b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f133001c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ LazyListState f133002d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ Function0 f133003f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ MutableState f133004g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1(Function1 function1, int i3, LazyListState lazyListState, Function0 function0, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f133000b = function1;
        this.f133001c = i3;
        this.f133002d = lazyListState;
        this.f133003f = function0;
        this.f133004g = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1(this.f133000b, this.f133001c, this.f133002d, this.f133003f, this.f133004g, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        ComposeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1 composeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f132999a;
        if (i3 == 0) {
            ResultKt.b(obj);
            ComposeSwipeableTimePickerKt.L(this.f133004g, true);
            this.f133000b.invoke(Boxing.d(this.f133001c));
            LazyListState lazyListState = this.f133002d;
            int i4 = this.f133001c;
            this.f132999a = 1;
            composeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1 = this;
            if (LazyListState.l(lazyListState, i4, 0, composeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1, 2, null) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
            composeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1 = this;
        }
        ComposeSwipeableTimePickerKt.L(composeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1.f133004g, false);
        composeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1.f133003f.invoke();
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ComposeSwipeableTimePickerKt$SwipeTimeColumn$5$1$1$1$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
