package com.superwall.sdk.paywall.view.webview;

import com.superwall.sdk.paywall.view.webview.WebviewFallbackClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;

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
@DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$loadWithFallback$3$1$nextEvent$1", f = "WebviewFallbackClient.kt", l = {}, m = "invokeSuspend")
final class WebviewFallbackClient$loadWithFallback$3$1$nextEvent$1 extends SuspendLambda implements Function2<WebviewFallbackClient.UrlState, Continuation<? super Boolean>, Object> {
    /* synthetic */ Object L$0;
    int label;

    WebviewFallbackClient$loadWithFallback$3$1$nextEvent$1(Continuation<? super WebviewFallbackClient$loadWithFallback$3$1$nextEvent$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        WebviewFallbackClient$loadWithFallback$3$1$nextEvent$1 webviewFallbackClient$loadWithFallback$3$1$nextEvent$1 = new WebviewFallbackClient$loadWithFallback$3$1$nextEvent$1(continuation);
        webviewFallbackClient$loadWithFallback$3$1$nextEvent$1.L$0 = obj;
        return webviewFallbackClient$loadWithFallback$3$1$nextEvent$1;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(WebviewFallbackClient.UrlState urlState, Continuation<? super Boolean> continuation) {
        return ((WebviewFallbackClient$loadWithFallback$3$1$nextEvent$1) create(urlState, continuation)).invokeSuspend(Unit.f139807a);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        WebviewFallbackClient.UrlState urlState = (WebviewFallbackClient.UrlState) this.L$0;
        return Boxing.a((urlState instanceof WebviewFallbackClient.UrlState.PageStarted) || (urlState instanceof WebviewFallbackClient.UrlState.Timeout) || (urlState instanceof WebviewFallbackClient.UrlState.PageError));
    }
}
