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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.timepicker.StatelessTimePickerKt$StatelessSwipeLazyColumn$3$1", f = "StatelessTimePicker.kt", l = {}, m = "invokeSuspend", v = 1)
final class StatelessTimePickerKt$StatelessSwipeLazyColumn$3$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f133015a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ boolean f133016b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ LazyListState f133017c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ float f133018d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ int f133019f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    final /* synthetic */ Function1 f133020g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    final /* synthetic */ MutableState f133021h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    final /* synthetic */ MutableState f133022i;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatelessTimePickerKt$StatelessSwipeLazyColumn$3$1(boolean z2, LazyListState lazyListState, float f3, int i3, Function1 function1, MutableState mutableState, MutableState mutableState2, Continuation continuation) {
        super(2, continuation);
        this.f133016b = z2;
        this.f133017c = lazyListState;
        this.f133018d = f3;
        this.f133019f = i3;
        this.f133020g = function1;
        this.f133021h = mutableState;
        this.f133022i = mutableState2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatelessTimePickerKt$StatelessSwipeLazyColumn$3$1(this.f133016b, this.f133017c, this.f133018d, this.f133019f, this.f133020g, this.f133021h, this.f133022i, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.f133015a != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        if (!this.f133016b && StatelessTimePickerKt.s(this.f133021h) && StatelessTimePickerKt.y(this.f133022i)) {
            this.f133020g.invoke(Boxing.d(this.f133017c.s() + (((float) this.f133017c.t()) > this.f133018d / ((float) this.f133019f) ? 1 : 0)));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatelessTimePickerKt$StatelessSwipeLazyColumn$3$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
