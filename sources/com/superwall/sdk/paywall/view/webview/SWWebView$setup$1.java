package com.superwall.sdk.paywall.view.webview;

import com.superwall.sdk.config.models.OnDeviceCaching;
import com.superwall.sdk.paywall.view.PaywallViewState;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
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
@DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.SWWebView$setup$1", f = "SWWebView.kt", l = {}, m = "invokeSuspend")
final class SWWebView$setup$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ String $url;
    int label;
    final /* synthetic */ SWWebView this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    SWWebView$setup$1(SWWebView sWWebView, String str, Continuation<? super SWWebView$setup$1> continuation) {
        super(2, continuation);
        this.this$0 = sWWebView;
        this.$url = str;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new SWWebView$setup$1(this.this$0, this.$url, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PaywallViewState state;
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        PaywallUIDelegate delegate = this.this$0.getDelegate();
        if (delegate == null || (state = delegate.getState()) == null) {
            return Unit.f139807a;
        }
        if (state.getPaywall().getOnDeviceCache() instanceof OnDeviceCaching.Enabled) {
            this.this$0.getSettings().setCacheMode(1);
        } else {
            this.this$0.getSettings().setCacheMode(-1);
        }
        if (state.getUseMultipleUrls()) {
            this.this$0.loadPaywallWithFallbackUrl$superwall_release(state.getPaywall());
        } else {
            this.this$0.loadUrl(this.$url);
        }
        return Unit.f139807a;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((SWWebView$setup$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
