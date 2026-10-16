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
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.timepicker.StatelessTimePickerKt$StatelessSwipeLazyColumn$4$1", f = "StatelessTimePicker.kt", l = {447}, m = "invokeSuspend", v = 1)
final class StatelessTimePickerKt$StatelessSwipeLazyColumn$4$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f133023a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyListState f133024b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ int f133025c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final /* synthetic */ Function1 f133026d;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    final /* synthetic */ MutableState f133027f;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    StatelessTimePickerKt$StatelessSwipeLazyColumn$4$1(LazyListState lazyListState, int i3, Function1 function1, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f133024b = lazyListState;
        this.f133025c = i3;
        this.f133026d = function1;
        this.f133027f = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new StatelessTimePickerKt$StatelessSwipeLazyColumn$4$1(this.f133024b, this.f133025c, this.f133026d, this.f133027f, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        StatelessTimePickerKt$StatelessSwipeLazyColumn$4$1 statelessTimePickerKt$StatelessSwipeLazyColumn$4$1;
        Object objF = IntrinsicsKt.f();
        int i3 = this.f133023a;
        if (i3 == 0) {
            ResultKt.b(obj);
            if (!StatelessTimePickerKt.t(this.f133027f)) {
                LazyListState lazyListState = this.f133024b;
                int i4 = this.f133025c;
                this.f133023a = 1;
                statelessTimePickerKt$StatelessSwipeLazyColumn$4$1 = this;
                if (LazyListState.l(lazyListState, i4, 0, statelessTimePickerKt$StatelessSwipeLazyColumn$4$1, 2, null) == objF) {
                    return objF;
                }
            }
            statelessTimePickerKt$StatelessSwipeLazyColumn$4$1.f133026d.invoke(Boxing.a(statelessTimePickerKt$StatelessSwipeLazyColumn$4$1.f133024b.c()));
            return Unit.f139807a;
        }
        if (i3 != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        statelessTimePickerKt$StatelessSwipeLazyColumn$4$1 = this;
        statelessTimePickerKt$StatelessSwipeLazyColumn$4$1.f133026d.invoke(Boxing.a(statelessTimePickerKt$StatelessSwipeLazyColumn$4$1.f133024b.c()));
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((StatelessTimePickerKt$StatelessSwipeLazyColumn$4$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
