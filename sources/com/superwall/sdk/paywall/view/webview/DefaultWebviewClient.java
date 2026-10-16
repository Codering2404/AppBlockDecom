package com.superwall.sdk.paywall.view.webview;

import android.graphics.Bitmap;
import android.net.Uri;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.superwall.sdk.paywall.view.webview.WebviewClientEvent;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;

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
public class DefaultWebviewClient extends WebViewClient {
    private final String forUrl;
    private volatile boolean hadMainFrameError;
    private final CoroutineScope ioScope;
    private final LocalResourceHandler localResourceHandler;
    private final Function1<WebView, Unit> onPageStartedHook;
    private final Function2<WebView, RenderProcessGoneDetail, Unit> onWebViewCrash;
    private final MutableSharedFlow<WebviewClientEvent> webviewClientEvents;

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.DefaultWebviewClient$onPageFinished$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.DefaultWebviewClient$onPageFinished$1", f = "DefaultWebviewClient.kt", l = {73}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $url;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$url = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return DefaultWebviewClient.this.new AnonymousClass1(this.$url, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                MutableSharedFlow<WebviewClientEvent> webviewClientEvents = DefaultWebviewClient.this.getWebviewClientEvents();
                WebviewClientEvent.OnPageFinished onPageFinished = new WebviewClientEvent.OnPageFinished(this.$url);
                this.label = 1;
                if (webviewClientEvents.emit(onPageFinished, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.DefaultWebviewClient$onReceivedError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.DefaultWebviewClient$onReceivedError$1", f = "DefaultWebviewClient.kt", l = {147, 157}, m = "invokeSuspend")
    static final class C28781 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WebResourceError $error;
        final /* synthetic */ boolean $isPageLevel;
        final /* synthetic */ String $requestUrl;
        int label;
        final /* synthetic */ DefaultWebviewClient this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28781(WebResourceError webResourceError, boolean z2, String str, DefaultWebviewClient defaultWebviewClient, Continuation<? super C28781> continuation) {
            super(2, continuation);
            this.$error = webResourceError;
            this.$isPageLevel = z2;
            this.$requestUrl = str;
            this.this$0 = defaultWebviewClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28781(this.$error, this.$isPageLevel, this.$requestUrl, this.this$0, continuation);
        }

        /* JADX WARN: Code restructure failed: missing block: B:13:0x0098, code lost:
        
            if (r2.emit(r4, r13) == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00bb, code lost:
        
            if (r3.emit(r4, r13) == r0) goto L20;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x00bd, code lost:
        
            return r0;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r14) throws java.lang.Throwable {
            /*
                r13 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.f()
                int r1 = r13.label
                r2 = 2
                r3 = 1
                if (r1 == 0) goto L1c
                if (r1 == r3) goto L17
                if (r1 != r2) goto Lf
                goto L17
            Lf:
                java.lang.IllegalStateException r14 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r14.<init>(r0)
                throw r14
            L17:
                kotlin.ResultKt.b(r14)
                goto Lbe
            L1c:
                kotlin.ResultKt.b(r14)
                android.webkit.WebResourceError r14 = r13.$error
                int r14 = r14.getErrorCode()
                java.lang.Integer r14 = kotlin.coroutines.jvm.internal.Boxing.d(r14)
                android.webkit.WebResourceError r1 = r13.$error
                java.lang.CharSequence r1 = r1.getDescription()
                java.lang.String r1 = r1.toString()
                kotlin.Pair r14 = kotlin.TuplesKt.a(r14, r1)
                java.lang.Object r1 = r14.a()
                java.lang.Number r1 = (java.lang.Number) r1
                int r1 = r1.intValue()
                java.lang.Object r14 = r14.b()
                java.lang.String r14 = (java.lang.String) r14
                boolean r4 = r13.$isPageLevel
                if (r4 == 0) goto L9b
                com.superwall.sdk.logger.Logger r5 = com.superwall.sdk.logger.Logger.INSTANCE
                com.superwall.sdk.logger.LogLevel r6 = com.superwall.sdk.logger.LogLevel.debug
                com.superwall.sdk.logger.LogScope r7 = com.superwall.sdk.logger.LogScope.paywallView
                java.lang.String r2 = r13.$requestUrl
                java.lang.StringBuilder r4 = new java.lang.StringBuilder
                r4.<init>()
                java.lang.String r8 = "Paywall loading failed due to network error. Url: "
                r4.append(r8)
                r4.append(r2)
                java.lang.String r2 = " - Code: "
                r4.append(r2)
                r4.append(r1)
                java.lang.String r2 = " for "
                r4.append(r2)
                r4.append(r14)
                java.lang.String r8 = r4.toString()
                r11 = 24
                r12 = 0
                r9 = 0
                r10 = 0
                com.superwall.sdk.logger.Logger.debug$default(r5, r6, r7, r8, r9, r10, r11, r12)
                com.superwall.sdk.paywall.view.webview.DefaultWebviewClient r2 = r13.this$0
                kotlinx.coroutines.flow.MutableSharedFlow r2 = r2.getWebviewClientEvents()
                com.superwall.sdk.paywall.view.webview.WebviewClientEvent$OnError r4 = new com.superwall.sdk.paywall.view.webview.WebviewClientEvent$OnError
                com.superwall.sdk.paywall.view.webview.WebviewError$NetworkError r5 = new com.superwall.sdk.paywall.view.webview.WebviewError$NetworkError
                com.superwall.sdk.paywall.view.webview.DefaultWebviewClient r6 = r13.this$0
                java.lang.String r6 = com.superwall.sdk.paywall.view.webview.DefaultWebviewClient.access$getForUrl$p(r6)
                r5.<init>(r1, r14, r6)
                r4.<init>(r5)
                r13.label = r3
                java.lang.Object r14 = r2.emit(r4, r13)
                if (r14 != r0) goto Lbe
                goto Lbd
            L9b:
                com.superwall.sdk.paywall.view.webview.DefaultWebviewClient r3 = r13.this$0
                kotlinx.coroutines.flow.MutableSharedFlow r3 = r3.getWebviewClientEvents()
                com.superwall.sdk.paywall.view.webview.WebviewClientEvent$OnResourceError r4 = new com.superwall.sdk.paywall.view.webview.WebviewClientEvent$OnResourceError
                com.superwall.sdk.paywall.view.webview.WebviewError$NetworkError r5 = new com.superwall.sdk.paywall.view.webview.WebviewError$NetworkError
                java.lang.String r6 = r13.$requestUrl
                if (r6 != 0) goto Laf
                com.superwall.sdk.paywall.view.webview.DefaultWebviewClient r6 = r13.this$0
                java.lang.String r6 = com.superwall.sdk.paywall.view.webview.DefaultWebviewClient.access$getForUrl$p(r6)
            Laf:
                r5.<init>(r1, r14, r6)
                r4.<init>(r5)
                r13.label = r2
                java.lang.Object r14 = r3.emit(r4, r13)
                if (r14 != r0) goto Lbe
            Lbd:
                return r0
            Lbe:
                kotlin.Unit r14 = kotlin.Unit.f139807a
                return r14
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.DefaultWebviewClient.C28781.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28781) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.DefaultWebviewClient$onReceivedHttpError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.DefaultWebviewClient$onReceivedHttpError$1", f = "DefaultWebviewClient.kt", l = {106}, m = "invokeSuspend")
    static final class C28791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WebResourceResponse $errorResponse;
        final /* synthetic */ boolean $isPageLevel;
        final /* synthetic */ String $requestUrl;
        int label;
        final /* synthetic */ DefaultWebviewClient this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28791(String str, WebResourceResponse webResourceResponse, boolean z2, DefaultWebviewClient defaultWebviewClient, Continuation<? super C28791> continuation) {
            super(2, continuation);
            this.$requestUrl = str;
            this.$errorResponse = webResourceResponse;
            this.$isPageLevel = z2;
            this.this$0 = defaultWebviewClient;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28791(this.$requestUrl, this.$errorResponse, this.$isPageLevel, this.this$0, continuation);
        }

        /* JADX WARN: Removed duplicated region for block: B:35:0x0099  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x00c0  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x00db  */
        /* JADX WARN: Removed duplicated region for block: B:48:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:51:0x00ee A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) throws java.lang.Throwable {
            /*
                Method dump skipped, instruction units count: 242
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.DefaultWebviewClient.C28791.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28791) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public /* synthetic */ DefaultWebviewClient(String str, CoroutineScope coroutineScope, Function2 function2, LocalResourceHandler localResourceHandler, Function1 function1, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this((i3 & 1) != 0 ? "" : str, coroutineScope, (i3 & 4) != 0 ? new Function2() { // from class: com.superwall.sdk.paywall.view.webview.a
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return DefaultWebviewClient._init_$lambda$0((WebView) obj, (RenderProcessGoneDetail) obj2);
            }
        } : function2, (i3 & 8) != 0 ? null : localResourceHandler, (i3 & 16) != 0 ? new Function1() { // from class: com.superwall.sdk.paywall.view.webview.b
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return DefaultWebviewClient._init_$lambda$1((WebView) obj);
            }
        } : function1);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(WebView v2, RenderProcessGoneDetail d3) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(d3, "d");
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$1(WebView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    public final boolean getHadMainFrameError$superwall_release() {
        return this.hadMainFrameError;
    }

    public final MutableSharedFlow<WebviewClientEvent> getWebviewClientEvents() {
        return this.webviewClientEvents;
    }

    protected final boolean isPageLevelFailure(WebResourceRequest webResourceRequest) {
        Uri url;
        String string;
        return (webResourceRequest != null && webResourceRequest.isForMainFrame()) || !(webResourceRequest == null || (url = webResourceRequest.getUrl()) == null || (string = url.toString()) == null || !StringsKt.a0(string, "runtime", false, 2, null));
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView view, String url) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(url, "url");
        super.onPageFinished(view, url);
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass1(url, null), 3, null);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        this.hadMainFrameError = false;
        if (webView != null) {
            this.onPageStartedHook.invoke(webView);
        }
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError error) {
        Uri url;
        Intrinsics.checkNotNullParameter(error, "error");
        String string = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString();
        boolean zIsPageLevelFailure = isPageLevelFailure(webResourceRequest);
        if (zIsPageLevelFailure) {
            this.hadMainFrameError = true;
        }
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28781(error, zIsPageLevelFailure, string, this, null), 3, null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Uri url;
        String string = (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) ? null : url.toString();
        if (string == null || !StringsKt.a0(string, "favicon.ico", false, 2, null)) {
            boolean zIsPageLevelFailure = isPageLevelFailure(webResourceRequest);
            if (zIsPageLevelFailure) {
                this.hadMainFrameError = true;
            }
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28791(string, webResourceResponse, zIsPageLevelFailure, this, null), 3, null);
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean onRenderProcessGone(WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        this.onWebViewCrash.invoke(view, detail);
        return true;
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
        Uri url;
        if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
            return super.shouldInterceptRequest(webView, webResourceRequest);
        }
        LocalResourceHandler localResourceHandler = this.localResourceHandler;
        return localResourceHandler == null ? super.shouldInterceptRequest(webView, webResourceRequest) : !localResourceHandler.isLocalResourceUrl(url) ? super.shouldInterceptRequest(webView, webResourceRequest) : localResourceHandler.handleRequest(url);
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public DefaultWebviewClient(String forUrl, CoroutineScope ioScope, Function2<? super WebView, ? super RenderProcessGoneDetail, Unit> onWebViewCrash, LocalResourceHandler localResourceHandler, Function1<? super WebView, Unit> onPageStartedHook) {
        Intrinsics.checkNotNullParameter(forUrl, "forUrl");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(onWebViewCrash, "onWebViewCrash");
        Intrinsics.checkNotNullParameter(onPageStartedHook, "onPageStartedHook");
        this.forUrl = forUrl;
        this.ioScope = ioScope;
        this.onWebViewCrash = onWebViewCrash;
        this.localResourceHandler = localResourceHandler;
        this.onPageStartedHook = onPageStartedHook;
        this.webviewClientEvents = SharedFlowKt.b(2, 10, null, 4, null);
    }
}
