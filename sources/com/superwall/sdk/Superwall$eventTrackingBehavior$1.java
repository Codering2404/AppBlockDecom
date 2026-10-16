package com.superwall.sdk;

import com.superwall.sdk.config.options.EventTrackingBehavior;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.webview.PaywallWebUI;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler;
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
@DebugMetadata(c = "com.superwall.sdk.Superwall$eventTrackingBehavior$1", f = "Superwall.kt", l = {173}, m = "invokeSuspend")
final class Superwall$eventTrackingBehavior$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ EventTrackingBehavior $newValue;
    int label;
    final /* synthetic */ Superwall this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Superwall$eventTrackingBehavior$1(Superwall superwall, EventTrackingBehavior eventTrackingBehavior, Continuation<? super Superwall$eventTrackingBehavior$1> continuation) {
        super(2, continuation);
        this.this$0 = superwall;
        this.$newValue = eventTrackingBehavior;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new Superwall$eventTrackingBehavior$1(this.this$0, this.$newValue, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        PaywallWebUI webView$superwall_release;
        PaywallMessageHandler messageHandler;
        Object objF = IntrinsicsKt.f();
        int i3 = this.label;
        if (i3 == 0) {
            ResultKt.b(obj);
            PaywallView paywallView = this.this$0.getPaywallView();
            if (paywallView != null && (webView$superwall_release = paywallView.getWebView$superwall_release()) != null && (messageHandler = webView$superwall_release.getMessageHandler()) != null) {
                EventTrackingBehavior eventTrackingBehavior = this.$newValue;
                this.label = 1;
                if (messageHandler.passEventTrackingBehaviorToWebView(eventTrackingBehavior, this) == objF) {
                    return objF;
                }
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
        return ((Superwall$eventTrackingBehavior$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
