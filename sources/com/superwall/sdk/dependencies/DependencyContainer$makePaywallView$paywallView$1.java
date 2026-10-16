package com.superwall.sdk.dependencies;

import android.content.Context;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.config.options.PaywallOptions;
import com.superwall.sdk.network.device.DeviceHelper;
import com.superwall.sdk.paywall.manager.PaywallViewCache;
import com.superwall.sdk.paywall.view.PaywallView;
import com.superwall.sdk.paywall.view.delegate.PaywallViewDelegateAdapter;
import com.superwall.sdk.paywall.view.webview.SWWebView;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler;
import com.superwall.sdk.storage.LocalStorage;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
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
@DebugMetadata(c = "com.superwall.sdk.dependencies.DependencyContainer$makePaywallView$paywallView$1", f = "DependencyContainer.kt", l = {}, m = "invokeSuspend")
final class DependencyContainer$makePaywallView$paywallView$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super PaywallView>, Object> {
    final /* synthetic */ PaywallViewCache $cache;
    final /* synthetic */ PaywallView.PaywallController $controller;
    final /* synthetic */ PaywallViewDelegateAdapter $delegate;
    final /* synthetic */ PaywallMessageHandler $messageHandler;
    int label;
    final /* synthetic */ DependencyContainer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    DependencyContainer$makePaywallView$paywallView$1(DependencyContainer dependencyContainer, PaywallMessageHandler paywallMessageHandler, PaywallViewDelegateAdapter paywallViewDelegateAdapter, PaywallViewCache paywallViewCache, PaywallView.PaywallController paywallController, Continuation<? super DependencyContainer$makePaywallView$paywallView$1> continuation) {
        super(2, continuation);
        this.this$0 = dependencyContainer;
        this.$messageHandler = paywallMessageHandler;
        this.$delegate = paywallViewDelegateAdapter;
        this.$cache = paywallViewCache;
        this.$controller = paywallController;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final PaywallOptions invokeSuspend$lambda$0(DependencyContainer dependencyContainer) {
        return dependencyContainer.makeSuperwallOptions().getPaywalls();
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new DependencyContainer$makePaywallView$paywallView$1(this.this$0, this.$messageHandler, this.$delegate, this.$cache, this.$controller, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        IntrinsicsKt.f();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.b(obj);
        Context context = this.this$0.getContext();
        PaywallMessageHandler paywallMessageHandler = this.$messageHandler;
        final DependencyContainer dependencyContainer = this.this$0;
        SWWebView sWWebView = new SWWebView(context, paywallMessageHandler, null, new Function0() { // from class: com.superwall.sdk.dependencies.o0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return DependencyContainer$makePaywallView$paywallView$1.invokeSuspend$lambda$0(dependencyContainer);
            }
        }, null, 20, null);
        Context context2 = this.this$0.getContext();
        DeviceHelper deviceHelper = this.this$0.getDeviceHelper();
        LocalStorage storage = this.this$0.getStorage();
        PaywallView paywallView = new PaywallView(context2, Superwall.Companion.getInstance(), this.$delegate, deviceHelper, this.this$0, storage, sWWebView, this.$cache, this.$controller, this.$messageHandler, this.this$0.getReedemer());
        sWWebView.setDelegate(paywallView);
        this.$messageHandler.setMessageHandler(paywallView);
        return paywallView;
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super PaywallView> continuation) {
        return ((DependencyContainer$makePaywallView$paywallView$1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
