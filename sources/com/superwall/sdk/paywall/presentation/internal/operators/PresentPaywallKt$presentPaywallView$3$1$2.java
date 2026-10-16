package com.superwall.sdk.paywall.presentation.internal.operators;

import com.superwall.sdk.paywall.presentation.internal.state.PaywallState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
@DebugMetadata(c = "com.superwall.sdk.paywall.presentation.internal.operators.PresentPaywallKt$presentPaywallView$3$1$2", f = "PresentPaywall.kt", l = {92}, m = "invokeSuspend")
final class PresentPaywallKt$presentPaywallView$3$1$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Throwable $error;
    final /* synthetic */ MutableSharedFlow<PaywallState> $paywallStatePublisher;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PresentPaywallKt$presentPaywallView$3$1$2(MutableSharedFlow<PaywallState> mutableSharedFlow, Throwable th, Continuation<? super PresentPaywallKt$presentPaywallView$3$1$2> continuation) {
        super(2, continuation);
        this.$paywallStatePublisher = mutableSharedFlow;
        this.$error = th;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PresentPaywallKt$presentPaywallView$3$1$2(this.$paywallStatePublisher, this.$error, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableSharedFlow<PaywallState> mutableSharedFlow = this.$paywallStatePublisher;
            PaywallState.PresentationError presentationError = new PaywallState.PresentationError(this.$error);
            this.label = 1;
            if (mutableSharedFlow.emit(presentationError, this) == objF) {
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
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PresentPaywallKt$presentPaywallView$3$1$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
