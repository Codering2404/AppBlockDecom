package com.superwall.sdk.paywall.view.webview.messaging;

import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.storage.core_data.ConvertersKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CancellableContinuation;
import kotlinx.coroutines.CoroutineScope;

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
/* JADX INFO: loaded from: classes7.dex */
@Metadata
@DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$2$1$1", f = "PaywallMessageHandler.kt", l = {}, m = "invokeSuspend")
final class PaywallMessageHandler$getState$2$1$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ CancellableContinuation<Map<String, ? extends Object>> $continuation;
    final /* synthetic */ String $messageScript;
    private /* synthetic */ Object L$0;
    int label;
    final /* synthetic */ PaywallMessageHandler this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    PaywallMessageHandler$getState$2$1$1(PaywallMessageHandler paywallMessageHandler, String str, CancellableContinuation<? super Map<String, ? extends Object>> cancellableContinuation, Continuation<? super PaywallMessageHandler$getState$2$1$1> continuation) {
        super(2, continuation);
        this.this$0 = paywallMessageHandler;
        this.$messageScript = str;
        this.$continuation = cancellableContinuation;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        PaywallMessageHandler$getState$2$1$1 paywallMessageHandler$getState$2$1$1 = new PaywallMessageHandler$getState$2$1$1(this.this$0, this.$messageScript, this.$continuation, continuation);
        paywallMessageHandler$getState$2$1$1.L$0 = obj;
        return paywallMessageHandler$getState$2$1$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PaywallMessageHandlerDelegate messageHandler = this.this$0.getMessageHandler();
        if (messageHandler != null) {
            final String str = this.$messageScript;
            final PaywallMessageHandler paywallMessageHandler = this.this$0;
            final CancellableContinuation<Map<String, ? extends Object>> cancellableContinuation = this.$continuation;
            messageHandler.evaluate(str, new Function1<String, Unit>() { // from class: com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler$getState$2$1$1.1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Object invoke(Object obj2) {
                    invoke((String) obj2);
                    return Unit.f139807a;
                }

                public final void invoke(String str2) {
                    if (str2 == null) {
                        CancellableContinuation<Map<String, ? extends Object>> cancellableContinuation2 = cancellableContinuation;
                        Result.Companion companion = Result.f139772b;
                        cancellableContinuation2.resumeWith(Result.b(MapsKt.emptyMap()));
                        return;
                    }
                    try {
                        Object objReplaceNullsWithEmpty = paywallMessageHandler.replaceNullsWithEmpty(ConvertersKt.convertFromJsonElement(paywallMessageHandler.json.h(str2)));
                        Map mapEmptyMap = objReplaceNullsWithEmpty instanceof Map ? (Map) objReplaceNullsWithEmpty : null;
                        if (mapEmptyMap == null) {
                            mapEmptyMap = MapsKt.emptyMap();
                        }
                        cancellableContinuation.resumeWith(Result.b(mapEmptyMap));
                    } catch (Exception e3) {
                        Logger.INSTANCE.debug(LogLevel.error, LogScope.paywallView, "Error parsing state JSON", MapsKt.mapOf(TuplesKt.a("message", str), TuplesKt.a("result", str2)), e3);
                        CancellableContinuation<Map<String, ? extends Object>> cancellableContinuation3 = cancellableContinuation;
                        Result.Companion companion2 = Result.f139772b;
                        cancellableContinuation3.resumeWith(Result.b(MapsKt.emptyMap()));
                    }
                }
            });
        } else {
            CancellableContinuation<Map<String, ? extends Object>> cancellableContinuation2 = this.$continuation;
            Result.Companion companion = Result.f139772b;
            cancellableContinuation2.resumeWith(Result.b(MapsKt.emptyMap()));
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((PaywallMessageHandler$getState$2$1$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
