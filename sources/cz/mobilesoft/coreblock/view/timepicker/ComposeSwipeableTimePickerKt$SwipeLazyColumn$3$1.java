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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt$SwipeLazyColumn$3$1", f = "ComposeSwipeableTimePicker.kt", l = {}, m = "invokeSuspend", v = 1)
final class ComposeSwipeableTimePickerKt$SwipeLazyColumn$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f132982a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f132983b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LazyListState f132984c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f132985d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f132986f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f132987g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f132988h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableState f132989i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeSwipeableTimePickerKt$SwipeLazyColumn$3$1(boolean z2, LazyListState lazyListState, float f3, int i3, Function1 function1, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f132983b = z2;
        this.f132984c = lazyListState;
        this.f132985d = f3;
        this.f132986f = i3;
        this.f132987g = function1;
        this.f132988h = mutableState;
        this.f132989i = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposeSwipeableTimePickerKt$SwipeLazyColumn$3$1(this.f132983b, this.f132984c, this.f132985d, this.f132986f, this.f132987g, this.f132988h, this.f132989i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f132982a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!this.f132983b && ComposeSwipeableTimePickerKt.x(this.f132988h) && ComposeSwipeableTimePickerKt.D(this.f132989i)) {
            this.f132987g.invoke(Boxing.d(this.f132984c.s() + (((float) this.f132984c.t()) > this.f132985d / ((float) this.f132986f) ? 1 : 0)));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((ComposeSwipeableTimePickerKt$SwipeLazyColumn$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
