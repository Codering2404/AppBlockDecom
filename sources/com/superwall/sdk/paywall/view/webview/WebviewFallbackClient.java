package com.superwall.sdk.paywall.view.webview;

import android.graphics.Bitmap;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import com.revenuecat.purchases.ui.revenuecatui.helpers.ColorExtractionConstants;
import com.superwall.sdk.models.paywall.PaywallWebviewUrl;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.Random;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.TimeoutCancellationException;
import kotlinx.coroutines.TimeoutKt;
import kotlinx.coroutines.flow.FlowKt;
import kotlinx.coroutines.flow.MutableStateFlow;
import kotlinx.coroutines.flow.StateFlowKt;

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
public final class WebviewFallbackClient extends DefaultWebviewClient {
    private final PaywallWebviewUrl.Config config;
    private int failureCount;
    private final CoroutineScope ioScope;
    private final Function1<PaywallWebviewUrl, Unit> loadUrl;
    private final CoroutineScope mainScope;
    private final Function2<WebView, RenderProcessGoneDetail, Unit> onCrashed;
    private final Function0<Unit> stopLoading;
    private final MutableStateFlow<UrlState> timeoutFlow;
    private final Set<PaywallWebviewUrl> untriedUrls;
    private final List<PaywallWebviewUrl> urls;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    private static final class MaxAttemptsReachedException extends Exception {
        public MaxAttemptsReachedException() {
            super("Max attempts reached");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    interface UrlState {

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Loading implements UrlState {
            public static final Loading INSTANCE = new Loading();

            private Loading() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class None implements UrlState {
            public static final None INSTANCE = new None();

            private None() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PageError implements UrlState {
            public static final PageError INSTANCE = new PageError();

            private PageError() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class PageStarted implements UrlState {
            public static final PageStarted INSTANCE = new PageStarted();

            private PageStarted() {
            }
        }

        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        public static final class Timeout implements UrlState {
            public static final Timeout INSTANCE = new Timeout();

            private Timeout() {
            }
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onLoadResource$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onLoadResource$1", f = "WebviewFallbackClient.kt", l = {98}, m = "invokeSuspend")
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebviewFallbackClient.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                if (Intrinsics.areEqual(WebviewFallbackClient.this.timeoutFlow.getValue(), UrlState.Loading.INSTANCE)) {
                    MutableStateFlow mutableStateFlow = WebviewFallbackClient.this.timeoutFlow;
                    UrlState.PageStarted pageStarted = UrlState.PageStarted.INSTANCE;
                    this.label = 1;
                    if (mutableStateFlow.emit(pageStarted, this) == objF) {
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
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onPageStarted$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onPageStarted$1", f = "WebviewFallbackClient.kt", l = {75}, m = "invokeSuspend")
    static final class C28841 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ long $timeoutForUrl;
        int label;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onPageStarted$1$2, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onPageStarted$1$2", f = "WebviewFallbackClient.kt", l = {76}, m = "invokeSuspend")
        static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super UrlState>, Object> {
            int label;
            final /* synthetic */ WebviewFallbackClient this$0;

            /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onPageStarted$1$2$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onPageStarted$1$2$1", f = "WebviewFallbackClient.kt", l = {}, m = "invokeSuspend")
            static final class C02511 extends SuspendLambda implements Function2<UrlState, Continuation<? super Boolean>, Object> {
                /* synthetic */ Object L$0;
                int label;

                C02511(Continuation<? super C02511> continuation) {
                    super(2, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    C02511 c02511 = new C02511(continuation);
                    c02511.L$0 = obj;
                    return c02511;
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(UrlState urlState, Continuation<? super Boolean> continuation) {
                    return ((C02511) create(urlState, continuation)).invokeSuspend(Unit.f139807a);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    UrlState urlState = (UrlState) this.L$0;
                    return Boxing.a((urlState instanceof UrlState.PageStarted) || (urlState instanceof UrlState.PageError));
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass2(WebviewFallbackClient webviewFallbackClient, Continuation<? super AnonymousClass2> continuation) {
                super(2, continuation);
                this.this$0 = webviewFallbackClient;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass2(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                Object objF = IntrinsicsKt.f();
                int i3 = this.label;
                if (i3 != 0) {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return obj;
                }
                ResultKt.b(obj);
                MutableStateFlow mutableStateFlow = this.this$0.timeoutFlow;
                C02511 c02511 = new C02511(null);
                this.label = 1;
                Object objE = FlowKt.E(mutableStateFlow, c02511, this);
                return objE == objF ? objF : objE;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super UrlState> continuation) {
                return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onPageStarted$1$3, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.WebviewFallbackClient$onPageStarted$1$3", f = "WebviewFallbackClient.kt", l = {}, m = "invokeSuspend")
        static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ WebviewFallbackClient this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass3(WebviewFallbackClient webviewFallbackClient, Continuation<? super AnonymousClass3> continuation) {
                super(2, continuation);
                this.this$0 = webviewFallbackClient;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass3(this.this$0, continuation);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws Throwable {
                IntrinsicsKt.f();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                this.this$0.stopLoading.invoke();
                return Unit.f139807a;
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28841(long j3, Continuation<? super C28841> continuation) {
            super(2, continuation);
            this.$timeoutForUrl = j3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return WebviewFallbackClient.this.new C28841(this.$timeoutForUrl, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object value;
            Object value2;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            try {
                if (i3 == 0) {
                    ResultKt.b(obj);
                    MutableStateFlow mutableStateFlow = WebviewFallbackClient.this.timeoutFlow;
                    do {
                        value2 = mutableStateFlow.getValue();
                    } while (!mutableStateFlow.compareAndSet(value2, UrlState.Loading.INSTANCE));
                    long j3 = this.$timeoutForUrl;
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(WebviewFallbackClient.this, null);
                    this.label = 1;
                    if (TimeoutKt.c(j3, anonymousClass2, this) == objF) {
                        return objF;
                    }
                } else {
                    if (i3 != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                }
            } catch (TimeoutCancellationException unused) {
                BuildersKt__Builders_commonKt.d(WebviewFallbackClient.this.mainScope, null, null, new AnonymousClass3(WebviewFallbackClient.this, null), 3, null);
                MutableStateFlow mutableStateFlow2 = WebviewFallbackClient.this.timeoutFlow;
                do {
                    value = mutableStateFlow2.getValue();
                } while (!mutableStateFlow2.compareAndSet(value, UrlState.Timeout.INSTANCE));
            }
            return Unit.f139807a;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C28841) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public /* synthetic */ WebviewFallbackClient(PaywallWebviewUrl.Config config, CoroutineScope coroutineScope, CoroutineScope coroutineScope2, Function1 function1, Function0 function0, Function2 function2, LocalResourceHandler localResourceHandler, Function1 function12, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(config, coroutineScope, coroutineScope2, function1, function0, function2, (i3 & 64) != 0 ? null : localResourceHandler, (i3 & ColorExtractionConstants.MINIMUM_ALPHA_THRESHOLD) != 0 ? new Function1() { // from class: com.superwall.sdk.paywall.view.webview.v
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return WebviewFallbackClient._init_$lambda$0((WebView) obj);
            }
        } : function12);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit _init_$lambda$0(WebView it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.f139807a;
    }

    private final PaywallWebviewUrl evaluateNext(int i3, Collection<PaywallWebviewUrl> collection, int i4) {
        while (true) {
            Collection<PaywallWebviewUrl> collection2 = collection;
            PaywallWebviewUrl paywallWebviewUrl = (PaywallWebviewUrl) CollectionsKt.firstOrNull(collection2);
            if (paywallWebviewUrl == null) {
                throw new NoSuchElementException("No more URLs to evaluate");
            }
            i4 += paywallWebviewUrl.getScore();
            if (i3 < i4) {
                return paywallWebviewUrl;
            }
            collection = CollectionsKt.drop(collection2, 1);
        }
    }

    static /* synthetic */ PaywallWebviewUrl evaluateNext$default(WebviewFallbackClient webviewFallbackClient, int i3, Collection collection, int i4, int i5, Object obj) {
        if ((i5 & 4) != 0) {
            i4 = 0;
        }
        return webviewFallbackClient.evaluateNext(i3, collection, i4);
    }

    private final PaywallWebviewUrl nextWeightedUrl(Collection<PaywallWebviewUrl> collection) {
        Iterator<T> it = collection.iterator();
        int score = 0;
        while (it.hasNext()) {
            score += ((PaywallWebviewUrl) it.next()).getScore();
        }
        if (score == 0) {
            PaywallWebviewUrl paywallWebviewUrl = (PaywallWebviewUrl) CollectionsKt.random(this.untriedUrls, Random.f140182a);
            this.untriedUrls.remove(paywallWebviewUrl);
            return paywallWebviewUrl;
        }
        PaywallWebviewUrl paywallWebviewUrlEvaluateNext = evaluateNext(RangesKt.w(RangesKt.B(0, score), Random.f140182a), this.untriedUrls, 0);
        this.untriedUrls.remove(paywallWebviewUrlEvaluateNext);
        return paywallWebviewUrlEvaluateNext;
    }

    public final void loadWithFallback$superwall_release() {
        if (this.urls.isEmpty()) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new WebviewFallbackClient$loadWithFallback$1(this, null), 3, null);
            return;
        }
        try {
            PaywallWebviewUrl paywallWebviewUrlNextUrl$superwall_release = nextUrl$superwall_release();
            if (this.failureCount > 0) {
                BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new WebviewFallbackClient$loadWithFallback$2(this, null), 3, null);
            }
            BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new WebviewFallbackClient$loadWithFallback$3(this, paywallWebviewUrlNextUrl$superwall_release, null), 3, null);
        } catch (MaxAttemptsReachedException unused) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new WebviewFallbackClient$loadWithFallback$url$2(this, null), 3, null);
        } catch (NoSuchElementException unused2) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new WebviewFallbackClient$loadWithFallback$url$1(this, null), 3, null);
        }
    }

    public final PaywallWebviewUrl nextUrl$superwall_release() throws MaxAttemptsReachedException {
        if (this.failureCount >= this.config.getMaxAttempts()) {
            throw new MaxAttemptsReachedException();
        }
        this.failureCount++;
        Set<PaywallWebviewUrl> set = this.untriedUrls;
        if (!(set instanceof Collection) || !set.isEmpty()) {
            Iterator<T> it = set.iterator();
            while (it.hasNext()) {
                if (((PaywallWebviewUrl) it.next()).getScore() != 0) {
                    Set<PaywallWebviewUrl> set2 = this.untriedUrls;
                    ArrayList arrayList = new ArrayList();
                    for (Object obj : set2) {
                        if (((PaywallWebviewUrl) obj).getScore() != 0) {
                            arrayList.add(obj);
                        }
                    }
                    return nextWeightedUrl(arrayList);
                }
            }
        }
        return nextWeightedUrl(this.untriedUrls);
    }

    @Override // android.webkit.WebViewClient
    public void onLoadResource(WebView webView, String str) {
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new AnonymousClass1(null), 3, null);
        super.onLoadResource(webView, str);
    }

    @Override // android.webkit.WebViewClient
    public void onPageCommitVisible(WebView webView, String str) {
        super.onPageCommitVisible(webView, str);
        this.failureCount = 0;
    }

    @Override // com.superwall.sdk.paywall.view.webview.DefaultWebviewClient, android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        Object next;
        super.onPageStarted(webView, str, bitmap);
        Iterator<T> it = this.urls.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            PaywallWebviewUrl paywallWebviewUrl = (PaywallWebviewUrl) next;
            boolean zA0 = false;
            if (str != null) {
                zA0 = StringsKt.a0(str, paywallWebviewUrl.getUrl(), false, 2, null);
            }
            if (zA0) {
                break;
            }
        }
        PaywallWebviewUrl paywallWebviewUrl2 = (PaywallWebviewUrl) next;
        if (paywallWebviewUrl2 != null) {
            BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28841(paywallWebviewUrl2.getTimeout(), null), 3, null);
            return;
        }
        throw new IllegalStateException(("No such URL(" + str + " in list of - " + CollectionsKt.joinToString$default(this.urls, null, null, null, 0, null, null, 63, null) + " ").toString());
    }

    @Override // com.superwall.sdk.paywall.view.webview.DefaultWebviewClient, android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError error) {
        Object value;
        Intrinsics.checkNotNullParameter(error, "error");
        if (!isPageLevelFailure(webResourceRequest)) {
            super.onReceivedError(webView, webResourceRequest, error);
            return;
        }
        MutableStateFlow<UrlState> mutableStateFlow = this.timeoutFlow;
        do {
            value = mutableStateFlow.getValue();
        } while (!mutableStateFlow.compareAndSet(value, UrlState.PageError.INSTANCE));
        super.onReceivedError(webView, webResourceRequest, error);
        loadWithFallback$superwall_release();
    }

    @Override // com.superwall.sdk.paywall.view.webview.DefaultWebviewClient, android.webkit.WebViewClient
    public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
        Object value;
        if (isPageLevelFailure(webResourceRequest)) {
            MutableStateFlow<UrlState> mutableStateFlow = this.timeoutFlow;
            do {
                value = mutableStateFlow.getValue();
            } while (!mutableStateFlow.compareAndSet(value, UrlState.PageError.INSTANCE));
        }
        super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public WebviewFallbackClient(PaywallWebviewUrl.Config config, CoroutineScope ioScope, CoroutineScope mainScope, Function1<? super PaywallWebviewUrl, Unit> loadUrl, Function0<Unit> stopLoading, Function2<? super WebView, ? super RenderProcessGoneDetail, Unit> onCrashed, LocalResourceHandler localResourceHandler, Function1<? super WebView, Unit> onPageStartedHook) {
        super("", ioScope, onCrashed, localResourceHandler, onPageStartedHook);
        Intrinsics.checkNotNullParameter(config, "config");
        Intrinsics.checkNotNullParameter(ioScope, "ioScope");
        Intrinsics.checkNotNullParameter(mainScope, "mainScope");
        Intrinsics.checkNotNullParameter(loadUrl, "loadUrl");
        Intrinsics.checkNotNullParameter(stopLoading, "stopLoading");
        Intrinsics.checkNotNullParameter(onCrashed, "onCrashed");
        Intrinsics.checkNotNullParameter(onPageStartedHook, "onPageStartedHook");
        this.config = config;
        this.ioScope = ioScope;
        this.mainScope = mainScope;
        this.loadUrl = loadUrl;
        this.stopLoading = stopLoading;
        this.onCrashed = onCrashed;
        List<PaywallWebviewUrl> endpoints = config.getEndpoints();
        this.urls = endpoints;
        this.untriedUrls = CollectionsKt.toMutableSet(endpoints);
        this.timeoutFlow = StateFlowKt.a(UrlState.None.INSTANCE);
    }
}
