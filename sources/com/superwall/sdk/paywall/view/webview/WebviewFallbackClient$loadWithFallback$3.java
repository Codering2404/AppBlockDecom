package com.superwall.sdk.paywall.view.webview;

import com.superwall.sdk.models.paywall.PaywallWebviewUrl;
import com.superwall.sdk.paywall.view.webview.WebviewFallbackClient;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;

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
@DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$loadWithFallback$3", f = "WebviewFallbackClient.kt", l = {}, m = "invokeSuspend")
final class WebviewFallbackClient$loadWithFallback$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ PaywallWebviewUrl $url;
    int label;
    final /* synthetic */ WebviewFallbackClient this$0;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$loadWithFallback$3$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$loadWithFallback$3$1", f = "WebviewFallbackClient.kt", l = {216}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ WebviewFallbackClient this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(WebviewFallbackClient webviewFallbackClient, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.this$0 = webviewFallbackClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object value;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableStateFlow mutableStateFlow = this.this$0.timeoutFlow;
                WebviewFallbackClient$loadWithFallback$3$1$nextEvent$1 webviewFallbackClient$loadWithFallback$3$1$nextEvent$1 = new WebviewFallbackClient$loadWithFallback$3$1$nextEvent$1(null);
                this.label = 1;
                obj = FlowKt.E(mutableStateFlow, webviewFallbackClient$loadWithFallback$3$1$nextEvent$1, this);
                if (obj == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
            }
            if (((WebviewFallbackClient.UrlState) obj) instanceof WebviewFallbackClient.UrlState.Timeout) {
                this.this$0.loadWithFallback$superwall_release();
            } else {
                MutableStateFlow mutableStateFlow2 = this.this$0.timeoutFlow;
                do {
                    value = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value, WebviewFallbackClient.UrlState.None.INSTANCE));
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebviewFallbackClient$loadWithFallback$3(WebviewFallbackClient webviewFallbackClient, PaywallWebviewUrl paywallWebviewUrl, Continuation<? super WebviewFallbackClient$loadWithFallback$3> continuation) {
        super(2, continuation);
        this.this$0 = webviewFallbackClient;
        this.$url = paywallWebviewUrl;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new WebviewFallbackClient$loadWithFallback$3(this.this$0, this.$url, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        this.this$0.loadUrl.invoke(this.$url);
        BuildersKt__Builders_commonKt.d(this.this$0.ioScope, null, null, new AnonymousClass1(this.this$0, null), 3, null);
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((WebviewFallbackClient$loadWithFallback$3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
