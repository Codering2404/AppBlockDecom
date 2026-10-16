package cz.mobilesoft.coreblock.view.timepicker;

import androidx.compose.foundation.interaction.DragInteraction;
import androidx.compose.foundation.interaction.Interaction;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.runtime.MutableState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;

/*  JADX ERROR: Error in decompile pass: KotlinMetadataDecompile
    java.lang.IllegalArgumentException: Provided Metadata instance does not have metadataVersion in it and therefore is malformed and cannot be read.
    	at kotlin.metadata.jvm.internal.JvmReadUtils.checkMetadataVersionForRead(JvmReadUtils.kt:79)
    	at kotlin.metadata.jvm.internal.JvmReadUtils.readMetadataImpl$kotlin_metadata_jvm(JvmReadUtils.kt:46)
    	at kotlin.metadata.jvm.KotlinClassMetadata$Companion.readLenient(KotlinClassMetadata.kt:418)
    	at jadx.plugins.kotlin.metadata.utils.KotlinMetadataExtKt.getKotlinClassMetadata(KotlinMetadataExt.kt:71)
    	at jadx.plugins.kotlin.metadata.utils.KmClassWrapper$Companion.getWrapper(KmClassWrapper.kt:37)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:35)
    	at jadx.plugins.kotlin.metadata.pass.KotlinMetadataDecompilePass.visit(KotlinMetadataDecompilePass.kt:33)
    */
/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes8.dex */
@Metadata
@DebugMetadata(c = "cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt$SwipeLazyColumn$5$1", f = "ComposeSwipeableTimePicker.kt", l = {408}, m = "invokeSuspend", v = 1)
final class ComposeSwipeableTimePickerKt$SwipeLazyColumn$5$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f132995a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ LazyListState f132996b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ MutableState f132997c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ComposeSwipeableTimePickerKt$SwipeLazyColumn$5$1(LazyListState lazyListState, MutableState mutableState, Continuation continuation) {
        super(2, continuation);
        this.f132996b = lazyListState;
        this.f132997c = mutableState;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new ComposeSwipeableTimePickerKt$SwipeLazyColumn$5$1(this.f132996b, this.f132997c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f132995a;
        if (i3 == 0) {
            ResultKt.b(obj);
            Flow flowC = this.f132996b.v().c();
            final MutableState mutableState = this.f132997c;
            FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.view.timepicker.ComposeSwipeableTimePickerKt$SwipeLazyColumn$5$1.1
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(Interaction interaction, Continuation continuation) {
                    if (interaction instanceof DragInteraction.Start) {
                        ComposeSwipeableTimePickerKt.z(mutableState, false);
                    }
                    return Unit.f139807a;
                }
            };
            this.f132995a = 1;
            if (flowC.collect(flowCollector, this) == objF) {
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
        return ((ComposeSwipeableTimePickerKt$SwipeLazyColumn$5$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
