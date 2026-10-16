package com.superwall.sdk.paywall.view.webview.messaging;

import com.superwall.sdk.paywall.view.PaywallView;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$triggerHapticFeedback$1$1", f = "PaywallMessageHandler.kt", l = {}, m = "invokeSuspend")
final class PaywallMessageHandler$triggerHapticFeedback$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ int $feedbackConstant;
    int label;
    final /* synthetic */ PaywallMessageHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    PaywallMessageHandler$triggerHapticFeedback$1$1(PaywallMessageHandler paywallMessageHandler, int i3, Continuation<? super PaywallMessageHandler$triggerHapticFeedback$1$1> continuation) {
        super(2, continuation);
        this.this$0 = paywallMessageHandler;
        this.$feedbackConstant = i3;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new PaywallMessageHandler$triggerHapticFeedback$1$1(this.this$0, this.$feedbackConstant, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PaywallView paywallView = (PaywallView) this.this$0.getView.invoke();
        if (paywallView != null) {
            Boxing.a(paywallView.performHapticFeedback(this.$feedbackConstant));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallMessageHandler$triggerHapticFeedback$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
