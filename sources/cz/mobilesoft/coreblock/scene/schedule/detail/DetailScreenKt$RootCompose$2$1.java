package cz.mobilesoft.coreblock.scene.schedule.detail;

import androidx.compose.material.ModalBottomSheetState;
import androidx.compose.material.ModalBottomSheetValue;
import androidx.compose.runtime.SnapshotStateKt;
import cz.mobilesoft.coreblock.scene.schedule.ScheduleViewEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
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
@DebugMetadata(c = "cz.mobilesoft.coreblock.scene.schedule.detail.DetailScreenKt$RootCompose$2$1", f = "DetailScreen.kt", l = {218}, m = "invokeSuspend", v = 1)
final class DetailScreenKt$RootCompose$2$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f116563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ ModalBottomSheetState f116564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ Function1 f116565c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DetailScreenKt$RootCompose$2$1(ModalBottomSheetState modalBottomSheetState, Function1 function1, Continuation continuation) {
        super(2, continuation);
        this.f116564b = modalBottomSheetState;
        this.f116565c = function1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ModalBottomSheetValue q(ModalBottomSheetState modalBottomSheetState) {
        return modalBottomSheetState.e();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new DetailScreenKt$RootCompose$2$1(this.f116564b, this.f116565c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f116563a;
        if (i3 == 0) {
            ResultKt.b(obj);
            final ModalBottomSheetState modalBottomSheetState = this.f116564b;
            Flow flowQ = SnapshotStateKt.q(new Function0() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.x4
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return DetailScreenKt$RootCompose$2$1.q(modalBottomSheetState);
                }
            });
            final Function1 function1 = this.f116565c;
            FlowCollector flowCollector = new FlowCollector() { // from class: cz.mobilesoft.coreblock.scene.schedule.detail.DetailScreenKt$RootCompose$2$1.2
                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(ModalBottomSheetValue modalBottomSheetValue, Continuation continuation) {
                    if (modalBottomSheetValue == ModalBottomSheetValue.Hidden) {
                        function1.invoke(ScheduleViewEvent.OnBottomSheetHidden.f114553a);
                    }
                    return Unit.f139807a;
                }
            };
            this.f116563a = 1;
            if (flowQ.collect(flowCollector, this) == objF) {
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
        return ((DetailScreenKt$RootCompose$2$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
