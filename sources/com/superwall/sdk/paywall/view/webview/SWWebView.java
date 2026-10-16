package com.superwall.sdk.paywall.view.webview;

import android.R;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.BaseInputConnection;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;
import com.facebook.GraphRequest;
import com.facebook.internal.ServerProtocol;
import com.superwall.sdk.Superwall;
import com.superwall.sdk.analytics.internal.TrackingKt;
import com.superwall.sdk.analytics.internal.trackable.InternalSuperwallEvent;
import com.superwall.sdk.analytics.internal.trackable.TrackableSuperwallEvent;
import com.superwall.sdk.config.options.PaywallOptions;
import com.superwall.sdk.game.PublicGameControllerKt;
import com.superwall.sdk.logger.LogLevel;
import com.superwall.sdk.logger.LogScope;
import com.superwall.sdk.logger.Logger;
import com.superwall.sdk.misc.ActivityProvider;
import com.superwall.sdk.misc.IOScope;
import com.superwall.sdk.misc.MainScope;
import com.superwall.sdk.models.paywall.Paywall;
import com.superwall.sdk.models.paywall.PaywallWebviewUrl;
import com.superwall.sdk.paywall.presentation.PaywallInfo;
import com.superwall.sdk.paywall.view.PaywallViewState;
import com.superwall.sdk.paywall.view.webview.PaywallWebUI;
import com.superwall.sdk.paywall.view.webview.SWWebView;
import com.superwall.sdk.paywall.view.webview.messaging.PaywallMessageHandler;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

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
public final class SWWebView extends WebView implements PaywallWebUI {

    @Deprecated
    public static final int MAX_LOAD_RETRIES = 3;
    private PaywallUIDelegate delegate;
    private final Lazy gestureDetector$delegate;
    private boolean hostPaused;
    private final IOScope ioScope;
    private String lastLoadedUrl;
    private WebViewClient lastWebViewClient;
    private int loadRetryCount;
    private final Lazy localResourceHandler$delegate;
    private final MainScope mainScope;
    private boolean mediaLifecycleReady;
    private final PaywallMessageHandler messageHandler;
    private final Function1<String, Unit> onFinishedLoading;
    private final Function1<WebView, Unit> onPageStartedPreloadHook;
    private Function2<? super Boolean, ? super Integer, Unit> onRenderCrashed;
    private PaywallWebUI.OnScrollChangeListener onScrollChangeListener;
    private final Function0<PaywallOptions> options;
    private boolean scrollEnabled;
    private final Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> track;
    private boolean viewDestroyed;
    private static final ChromeClient ChromeClient = new ChromeClient(null);
    private static final Lazy<Bitmap> posterBmp$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.paywall.view.webview.j
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return SWWebView.posterBmp_delegate$lambda$13();
        }
    });

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.SWWebView$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.SWWebView$1", f = "SWWebView.kt", l = {74}, m = "invokeSuspend")
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<TrackableSuperwallEvent, Continuation<? super Unit>, Object> {
        /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(TrackableSuperwallEvent trackableSuperwallEvent, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(trackableSuperwallEvent, continuation)).invokeSuspend(Unit.f139807a);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                TrackableSuperwallEvent trackableSuperwallEvent = (TrackableSuperwallEvent) this.L$0;
                Superwall companion = Superwall.Companion.getInstance();
                this.label = 1;
                if (TrackingKt.track(companion, trackableSuperwallEvent, this) == objF) {
                    return objF;
                }
            } else {
                if (i3 != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.b(obj);
                ((Result) obj).j();
            }
            return Unit.f139807a;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    static final class ChromeClient extends WebChromeClient {

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.SWWebView$ChromeClient$ChromeClient, reason: collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        static final class C0247ChromeClient extends WebChromeClient {
            private final Function0<Activity> activity;

            /* JADX WARN: Multi-variable type inference failed */
            public C0247ChromeClient(Function0<? extends Activity> activity) {
                Intrinsics.checkNotNullParameter(activity, "activity");
                this.activity = activity;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void onJsPrompt$lambda$5(JsPromptResult jsPromptResult, EditText editText, DialogInterface dialogInterface, int i3) {
                jsPromptResult.confirm(editText.getText().toString());
            }

            public final Function0<Activity> getActivity() {
                return this.activity;
            }

            @Override // android.webkit.WebChromeClient
            public Bitmap getDefaultVideoPoster() {
                return SWWebView.ChromeClient.getPosterBmp();
            }

            @Override // android.webkit.WebChromeClient
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                Intrinsics.checkNotNullParameter(consoleMessage, "consoleMessage");
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsAlert(WebView view, String url, String message, final JsResult result) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(result, "result");
                Activity activity = (Activity) this.activity.invoke();
                if (activity == null) {
                    return false;
                }
                new AlertDialog.Builder(activity).setMessage(message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.superwall.sdk.paywall.view.webview.q
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        result.confirm();
                    }
                }).setOnCancelListener(new DialogInterface.OnCancelListener() { // from class: com.superwall.sdk.paywall.view.webview.r
                    @Override // android.content.DialogInterface.OnCancelListener
                    public final void onCancel(DialogInterface dialogInterface) {
                        result.cancel();
                    }
                }).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsConfirm(WebView view, String url, String message, final JsResult result) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(result, "result");
                Activity activity = (Activity) this.activity.invoke();
                if (activity == null) {
                    return false;
                }
                new AlertDialog.Builder(activity).setMessage(message).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.superwall.sdk.paywall.view.webview.s
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        result.confirm();
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.superwall.sdk.paywall.view.webview.t
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        result.cancel();
                    }
                }).show();
                return true;
            }

            @Override // android.webkit.WebChromeClient
            public boolean onJsPrompt(WebView view, String url, String message, String str, final JsPromptResult result) {
                Intrinsics.checkNotNullParameter(view, "view");
                Intrinsics.checkNotNullParameter(url, "url");
                Intrinsics.checkNotNullParameter(message, "message");
                Intrinsics.checkNotNullParameter(result, "result");
                final EditText editText = new EditText((Context) this.activity.invoke());
                if (str == null) {
                    str = "";
                }
                editText.setText(str);
                Activity activity = (Activity) this.activity.invoke();
                if (activity == null) {
                    return false;
                }
                new AlertDialog.Builder(activity).setMessage(message).setView(editText).setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() { // from class: com.superwall.sdk.paywall.view.webview.o
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        SWWebView.ChromeClient.C0247ChromeClient.onJsPrompt$lambda$5(result, editText, dialogInterface, i3);
                    }
                }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() { // from class: com.superwall.sdk.paywall.view.webview.p
                    @Override // android.content.DialogInterface.OnClickListener
                    public final void onClick(DialogInterface dialogInterface, int i3) {
                        result.cancel();
                    }
                }).show();
                return true;
            }
        }

        public /* synthetic */ ChromeClient(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final Bitmap getPosterBmp() {
            return (Bitmap) SWWebView.posterBmp$delegate.getValue();
        }

        private ChromeClient() {
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.SWWebView$listenToWebviewClientEvents$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.SWWebView$listenToWebviewClientEvents$1", f = "SWWebView.kt", l = {414}, m = "invokeSuspend")
    static final class C28801 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ DefaultWebviewClient $client;
        int label;
        final /* synthetic */ SWWebView this$0;

        /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.SWWebView$listenToWebviewClientEvents$1$1, reason: invalid class name and collision with other inner class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        @Metadata
        @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.SWWebView$listenToWebviewClientEvents$1$1", f = "SWWebView.kt", l = {413}, m = "invokeSuspend")
        static final class C02481 extends SuspendLambda implements Function2<WebviewClientEvent, Continuation<? super Boolean>, Object> {
            final /* synthetic */ DefaultWebviewClient $client;
            int label;
            final /* synthetic */ SWWebView this$0;

            /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.SWWebView$listenToWebviewClientEvents$1$1$1, reason: invalid class name and collision with other inner class name */
            /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
            @Metadata
            @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.SWWebView$listenToWebviewClientEvents$1$1$1", f = "SWWebView.kt", l = {}, m = "invokeSuspend")
            static final class C02491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
                final /* synthetic */ DefaultWebviewClient $client;
                int label;
                final /* synthetic */ SWWebView this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                C02491(SWWebView sWWebView, DefaultWebviewClient defaultWebviewClient, Continuation<? super C02491> continuation) {
                    super(2, continuation);
                    this.this$0 = sWWebView;
                    this.$client = defaultWebviewClient;
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                    return new C02491(this.this$0, this.$client, continuation);
                }

                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                public final Object invokeSuspend(Object obj) throws Throwable {
                    IntrinsicsKt.f();
                    if (this.label != 0) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.b(obj);
                    return Boxing.a(Intrinsics.areEqual(this.this$0.getWebViewClient(), this.$client));
                }

                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
                    return ((C02491) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02481(SWWebView sWWebView, DefaultWebviewClient defaultWebviewClient, Continuation<? super C02481> continuation) {
                super(2, continuation);
                this.this$0 = sWWebView;
                this.$client = defaultWebviewClient;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02481(this.this$0, this.$client, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(WebviewClientEvent webviewClientEvent, Continuation<? super Boolean> continuation) {
                return ((C02481) create(webviewClientEvent, continuation)).invokeSuspend(Unit.f139807a);
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
                Deferred deferredB = BuildersKt__Builders_commonKt.b(this.this$0.mainScope, null, null, new C02491(this.this$0, this.$client, null), 3, null);
                this.label = 1;
                Object objAwait = deferredB.await(this);
                return objAwait == objF ? objF : objAwait;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28801(DefaultWebviewClient defaultWebviewClient, SWWebView sWWebView, Continuation<? super C28801> continuation) {
            super(2, continuation);
            this.$client = defaultWebviewClient;
            this.this$0 = sWWebView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28801(this.$client, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                Flow flowJ0 = FlowKt.j0(this.$client.getWebviewClientEvents(), new C02481(this.this$0, this.$client, null));
                final SWWebView sWWebView = this.this$0;
                final DefaultWebviewClient defaultWebviewClient = this.$client;
                FlowCollector flowCollector = new FlowCollector() { // from class: com.superwall.sdk.paywall.view.webview.SWWebView.listenToWebviewClientEvents.1.2

                    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.SWWebView$listenToWebviewClientEvents$1$2$1, reason: invalid class name and collision with other inner class name */
                    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                    @Metadata
                    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.SWWebView$listenToWebviewClientEvents$1$2$1", f = "SWWebView.kt", l = {}, m = "invokeSuspend")
                    static final class C02501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ DefaultWebviewClient $client;
                        final /* synthetic */ WebviewClientEvent $it;
                        int label;
                        final /* synthetic */ SWWebView this$0;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C02501(WebviewClientEvent webviewClientEvent, SWWebView sWWebView, DefaultWebviewClient defaultWebviewClient, Continuation<? super C02501> continuation) {
                            super(2, continuation);
                            this.$it = webviewClientEvent;
                            this.this$0 = sWWebView;
                            this.$client = defaultWebviewClient;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C02501(this.$it, this.this$0, this.$client, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C02501) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
                        }

                        /* JADX WARN: Removed duplicated region for block: B:39:0x0143  */
                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        /*
                            Code decompiled incorrectly, please refer to instructions dump.
                            To view partially-correct code enable 'Show inconsistent code' option in preferences
                        */
                        public final java.lang.Object invokeSuspend(java.lang.Object r9) throws java.lang.Throwable {
                            /*
                                Method dump skipped, instruction units count: 520
                                To view this dump change 'Code comments level' option to 'DEBUG'
                            */
                            throw new UnsupportedOperationException("Method not decompiled: com.superwall.sdk.paywall.view.webview.SWWebView.C28801.AnonymousClass2.C02501.invokeSuspend(java.lang.Object):java.lang.Object");
                        }
                    }

                    private static final void emit$log(String str, Map<String, ? extends Object> map) {
                        Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, str, map, (Throwable) null, 16, (Object) null);
                    }

                    static /* synthetic */ void emit$log$default(String str, Map map, int i4, Object obj2) {
                        if ((i4 & 2) != 0) {
                            map = MapsKt.emptyMap();
                        }
                        emit$log(str, map);
                    }

                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((WebviewClientEvent) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(WebviewClientEvent webviewClientEvent, Continuation<? super Unit> continuation) {
                        BuildersKt__Builders_commonKt.d(sWWebView.mainScope, null, null, new C02501(webviewClientEvent, sWWebView, defaultWebviewClient, null), 3, null);
                        return Unit.f139807a;
                    }
                };
                this.label = 1;
                if (flowJ0.collect(flowCollector, this) == objF) {
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
            return ((C28801) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.SWWebView$trackLoadFallback$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.SWWebView$trackLoadFallback$1", f = "SWWebView.kt", l = {553}, m = "invokeSuspend")
    static final class C28811 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C28811(Continuation<? super C28811> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SWWebView.this.new C28811(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PaywallInfo info;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallUIDelegate delegate = SWWebView.this.getDelegate();
                if (delegate != null) {
                    delegate.updateState(PaywallViewState.Updates.WebLoadingFailed.INSTANCE);
                }
                PaywallUIDelegate delegate2 = SWWebView.this.getDelegate();
                if (delegate2 == null || (info = delegate2.getInfo()) == null) {
                    return Unit.f139807a;
                }
                InternalSuperwallEvent.PaywallWebviewLoad paywallWebviewLoad = new InternalSuperwallEvent.PaywallWebviewLoad(InternalSuperwallEvent.PaywallWebviewLoad.State.Fallback.INSTANCE, info);
                Function2 function2 = SWWebView.this.track;
                this.label = 1;
                if (function2.invoke(paywallWebviewLoad, this) == objF) {
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
            return ((C28811) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.SWWebView$trackPaywallError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.SWWebView$trackPaywallError$1", f = "SWWebView.kt", l = {575}, m = "invokeSuspend")
    static final class C28821 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WebviewError $error;
        final /* synthetic */ List<String> $urls;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28821(WebviewError webviewError, List<String> list, Continuation<? super C28821> continuation) {
            super(2, continuation);
            this.$error = webviewError;
            this.$urls = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SWWebView.this.new C28821(this.$error, this.$urls, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            PaywallInfo info;
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                PaywallUIDelegate delegate = SWWebView.this.getDelegate();
                if (delegate != null) {
                    delegate.updateState(PaywallViewState.Updates.WebLoadingFailed.INSTANCE);
                }
                PaywallUIDelegate delegate2 = SWWebView.this.getDelegate();
                if (delegate2 == null || (info = delegate2.getInfo()) == null) {
                    return Unit.f139807a;
                }
                InternalSuperwallEvent.PaywallWebviewLoad paywallWebviewLoad = new InternalSuperwallEvent.PaywallWebviewLoad(new InternalSuperwallEvent.PaywallWebviewLoad.State.Fail(this.$error, this.$urls), info);
                Function2 function2 = SWWebView.this.track;
                this.label = 1;
                if (function2.invoke(paywallWebviewLoad, this) == objF) {
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
            return ((C28821) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    /* JADX INFO: renamed from: com.superwall.sdk.paywall.view.webview.SWWebView$trackPaywallResourceError$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    @Metadata
    @DebugMetadata(c = "com.superwall.sdk.paywall.view.webview.SWWebView$trackPaywallResourceError$1", f = "SWWebView.kt", l = {589}, m = "invokeSuspend")
    static final class C28831 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ WebviewError $error;
        final /* synthetic */ String $url;
        int label;
        final /* synthetic */ SWWebView this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C28831(String str, WebviewError webviewError, SWWebView sWWebView, Continuation<? super C28831> continuation) {
            super(2, continuation);
            this.$url = str;
            this.$error = webviewError;
            this.this$0 = sWWebView;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C28831(this.$url, this.$error, this.this$0, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object objF = IntrinsicsKt.f();
            int i3 = this.label;
            if (i3 == 0) {
                ResultKt.b(obj);
                InternalSuperwallEvent.PaywallResourceLoadFail paywallResourceLoadFail = new InternalSuperwallEvent.PaywallResourceLoadFail(this.$url, this.$error.toString());
                Function2 function2 = this.this$0.track;
                this.label = 1;
                if (function2.invoke(paywallResourceLoadFail, this) == objF) {
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
            return ((C28831) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
        }
    }

    public /* synthetic */ SWWebView(Context context, PaywallMessageHandler paywallMessageHandler, Function1 function1, Function0 function0, Function2 function2, int i3, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, paywallMessageHandler, (i3 & 4) != 0 ? null : function1, function0, (i3 & 16) != 0 ? new AnonymousClass1(null) : function2);
    }

    private final String currentDeviceLocale() {
        PaywallViewState state;
        String locale;
        PaywallUIDelegate delegate = getDelegate();
        if (delegate != null && (state = delegate.getState()) != null && (locale = state.getLocale()) != null) {
            return locale;
        }
        Superwall.Companion companion = Superwall.Companion;
        if (companion.getInitialized()) {
            return companion.getInstance().getDependencyContainer$superwall_release().getDeviceHelper().getLocale();
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final GestureDetector gestureDetector_delegate$lambda$0(Context context) {
        return new GestureDetector(context, new ScrollDisabledListener());
    }

    private final GestureDetector getGestureDetector() {
        return (GestureDetector) this.gestureDetector$delegate.getValue();
    }

    private final LocalResourceHandler getLocalResourceHandler() {
        return (LocalResourceHandler) this.localResourceHandler$delegate.getValue();
    }

    private final void listenToWebviewClientEvents(DefaultWebviewClient defaultWebviewClient) {
        BuildersKt__Builders_commonKt.d(this.ioScope, null, null, new C28801(defaultWebviewClient, this, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadPaywallWithFallbackUrl$lambda$10(SWWebView sWWebView, WebView view, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(detail, "detail");
        if (Intrinsics.areEqual(view, sWWebView)) {
            sWWebView.onRenderCrashed.invoke(Boolean.valueOf(detail.didCrash()), Integer.valueOf(detail.rendererPriorityAtExit()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadPaywallWithFallbackUrl$lambda$8(SWWebView sWWebView, PaywallWebviewUrl it) {
        Intrinsics.checkNotNullParameter(it, "it");
        sWWebView.lastLoadedUrl = it.getUrl();
        super.loadUrl(sWWebView.transformUri(it.getUrl()));
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadPaywallWithFallbackUrl$lambda$9(SWWebView sWWebView) {
        sWWebView.stopLoading();
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit loadUrl$lambda$11(SWWebView sWWebView, WebView v2, RenderProcessGoneDetail detail) {
        Intrinsics.checkNotNullParameter(v2, "v");
        Intrinsics.checkNotNullParameter(detail, "detail");
        if (Intrinsics.areEqual(v2, sWWebView)) {
            sWWebView.onRenderCrashed.invoke(Boolean.valueOf(detail.didCrash()), Integer.valueOf(detail.rendererPriorityAtExit()));
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocalResourceHandler localResourceHandler_delegate$lambda$2(Context context) {
        return new LocalResourceHandler(context, new Function0() { // from class: com.superwall.sdk.paywall.view.webview.e
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SWWebView.localResourceHandler_delegate$lambda$2$lambda$1();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Map localResourceHandler_delegate$lambda$2$lambda$1() {
        return Superwall.Companion.getInstance().getLocalResources();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onPageStartedPreloadHook$lambda$5(SWWebView sWWebView, WebView view) {
        Intrinsics.checkNotNullParameter(view, "view");
        sWWebView.updateMediaPlayback();
        String strCurrentDeviceLocale = sWWebView.currentDeviceLocale();
        if (strCurrentDeviceLocale != null) {
            view.evaluateJavascript(DevicePreloadScript.INSTANCE.build(strCurrentDeviceLocale), null);
        }
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit onRenderCrashed$lambda$3(boolean z2, int i3) {
        return Unit.f139807a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Bitmap posterBmp_delegate$lambda$13() {
        return Bitmap.createBitmap(10, 10, Bitmap.Config.ARGB_8888);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackLoadFallback() {
        BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new C28811(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackPaywallError(WebviewError webviewError, List<String> list) {
        BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new C28821(webviewError, list, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void trackPaywallResourceError(WebviewError webviewError, String str) {
        BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new C28831(str, webviewError, this, null), 3, null);
    }

    private final String transformUri(String str) {
        Uri.Builder builderBuildUpon = Uri.parse(str).buildUpon();
        builderBuildUpon.appendQueryParameter("platform", "android");
        builderBuildUpon.appendQueryParameter("transport", "android");
        builderBuildUpon.appendQueryParameter(GraphRequest.DEBUG_PARAM, ServerProtocol.DIALOG_RETURN_SCOPES_TRUE);
        String string = builderBuildUpon.build().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        Logger.debug$default(Logger.INSTANCE, LogLevel.debug, LogScope.paywallView, "SWWebView.loadUrl: " + string, (Map) null, (Throwable) null, 24, (Object) null);
        return string;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateMediaPlayback() {
        if (!this.mediaLifecycleReady || this.viewDestroyed) {
            return;
        }
        evaluateJavascript(MediaPlaybackScript.INSTANCE.build(!this.hostPaused && isAttachedToWindow() && isShown() && getWindowVisibility() == 0), null);
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void attach(ViewGroup toView) {
        Intrinsics.checkNotNullParameter(toView, "toView");
        if (getParent() == null) {
            toView.addView(this);
        }
        if (getLayoutParams().height == -1 || getLayoutParams().width == -1) {
            return;
        }
        setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
    }

    @Override // android.webkit.WebView
    public void destroy() {
        this.viewDestroyed = true;
        setOnScrollChangeListener((PaywallWebUI.OnScrollChangeListener) null);
        super.destroy();
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void destroyView() {
        setOnScrollChangeListener((PaywallWebUI.OnScrollChangeListener) null);
        destroy();
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void detach(ViewGroup fromView) {
        Intrinsics.checkNotNullParameter(fromView, "fromView");
        fromView.removeView(this);
    }

    @Override // android.view.View
    public boolean dispatchGenericMotionEvent(MotionEvent motionEvent) {
        if (motionEvent != null) {
            Superwall.Companion companion = Superwall.Companion;
            if (companion.getInstance().getOptions().isGameControllerEnabled()) {
                PublicGameControllerKt.dispatchMotionEvent(companion.getInstance(), motionEvent);
                return true;
            }
        }
        return super.dispatchGenericMotionEvent(motionEvent);
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        if (keyEvent != null) {
            Superwall.Companion companion = Superwall.Companion;
            if (companion.getInstance().getOptions().isGameControllerEnabled()) {
                PublicGameControllerKt.dispatchKeyEvent(companion.getInstance(), keyEvent);
                return true;
            }
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void evaluate(String code, final Function1<? super String, Unit> function1) {
        Intrinsics.checkNotNullParameter(code, "code");
        evaluateJavascript(code, function1 != null ? new ValueCallback() { // from class: com.superwall.sdk.paywall.view.webview.c
            @Override // android.webkit.ValueCallback
            public final void onReceiveValue(Object obj) {
                function1.invoke((String) obj);
            }
        } : null);
    }

    public final Activity getActivity() {
        ActivityProvider activityProvider = Superwall.Companion.getInstance().getDependencyContainer$superwall_release().getActivityProvider();
        if (activityProvider != null) {
            return activityProvider.getCurrentActivity();
        }
        return null;
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public PaywallUIDelegate getDelegate() {
        return this.delegate;
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public PaywallMessageHandler getMessageHandler() {
        return this.messageHandler;
    }

    public final Function2<Boolean, Integer, Unit> getOnRenderCrashed() {
        return this.onRenderCrashed;
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public PaywallWebUI.OnScrollChangeListener getOnScrollChangeListener() {
        return this.onScrollChangeListener;
    }

    public final boolean getScrollEnabled() {
        return this.scrollEnabled;
    }

    public final void loadPaywallWithFallbackUrl$superwall_release(Paywall paywall) {
        Intrinsics.checkNotNullParameter(paywall, "paywall");
        prepareWebview$superwall_release();
        PaywallWebviewUrl.Config urlConfig = paywall.getUrlConfig();
        if (urlConfig == null) {
            Logger.debug$default(Logger.INSTANCE, LogLevel.error, LogScope.paywallView, "Tried to start a paywall with multiple URLS but without URL config", (Map) null, (Throwable) null, 24, (Object) null);
            return;
        }
        MainScope mainScope = this.mainScope;
        WebviewFallbackClient webviewFallbackClient = new WebviewFallbackClient(urlConfig, this.ioScope, mainScope, new Function1() { // from class: com.superwall.sdk.paywall.view.webview.f
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SWWebView.loadPaywallWithFallbackUrl$lambda$8(this.f93713a, (PaywallWebviewUrl) obj);
            }
        }, new Function0() { // from class: com.superwall.sdk.paywall.view.webview.g
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SWWebView.loadPaywallWithFallbackUrl$lambda$9(this.f93714a);
            }
        }, new Function2() { // from class: com.superwall.sdk.paywall.view.webview.h
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SWWebView.loadPaywallWithFallbackUrl$lambda$10(this.f93715a, (WebView) obj, (RenderProcessGoneDetail) obj2);
            }
        }, getLocalResourceHandler(), this.onPageStartedPreloadHook);
        setWebViewClient(webviewFallbackClient);
        this.lastWebViewClient = webviewFallbackClient;
        listenToWebviewClientEvents(webviewFallbackClient);
        webviewFallbackClient.loadWithFallback$superwall_release();
    }

    @Override // android.webkit.WebView
    public void loadUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        this.lastLoadedUrl = url;
        prepareWebview$superwall_release();
        DefaultWebviewClient defaultWebviewClient = new DefaultWebviewClient(url, CoroutineScopeKt.a(Dispatchers.b()), new Function2() { // from class: com.superwall.sdk.paywall.view.webview.i
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SWWebView.loadUrl$lambda$11(this.f93716a, (WebView) obj, (RenderProcessGoneDetail) obj2);
            }
        }, getLocalResourceHandler(), this.onPageStartedPreloadHook);
        setWebViewClient(defaultWebviewClient);
        this.lastWebViewClient = defaultWebviewClient;
        listenToWebviewClientEvents(defaultWebviewClient);
        super.loadUrl(transformUri(url));
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        onResume();
    }

    @Override // android.webkit.WebView, android.view.View
    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        Superwall.Companion companion = Superwall.Companion;
        return (companion.getInitialized() && companion.getInstance().getOptions().isGameControllerEnabled()) ? new BaseInputConnection(this, false) : super.onCreateInputConnection(editorInfo);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (!this.viewDestroyed) {
            evaluateJavascript(MediaPlaybackScript.INSTANCE.build(false), null);
        }
        super.onDetachedFromWindow();
    }

    @Override // android.webkit.WebView, com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void onPause() {
        this.hostPaused = true;
        updateMediaPlayback();
        super.onPause();
    }

    @Override // android.webkit.WebView, com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void onResume() {
        super.onResume();
        this.hostPaused = false;
        updateMediaPlayback();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onScrollChanged(int i3, int i4, int i5, int i6) {
        super.onScrollChanged(i3, i4, i5, i6);
        PaywallWebUI.OnScrollChangeListener onScrollChangeListener = getOnScrollChangeListener();
        if (onScrollChangeListener != null) {
            onScrollChangeListener.onScrollChanged(i3, i4, i5, i6);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkNotNullParameter(event, "event");
        if (this.scrollEnabled || event.getAction() != 2) {
            return super.onTouchEvent(event);
        }
        boolean zOnTouchEvent = getGestureDetector().onTouchEvent(event);
        return !zOnTouchEvent ? super.onTouchEvent(event) : zOnTouchEvent;
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void onView(Function1<? super View, Unit> perform) {
        Intrinsics.checkNotNullParameter(perform, "perform");
        perform.invoke(this);
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onVisibilityChanged(View changedView, int i3) {
        Intrinsics.checkNotNullParameter(changedView, "changedView");
        super.onVisibilityChanged(changedView, i3);
        updateMediaPlayback();
    }

    @Override // android.webkit.WebView, android.view.View
    protected void onWindowVisibilityChanged(int i3) {
        super.onWindowVisibilityChanged(i3);
        updateMediaPlayback();
    }

    public final void prepareWebview$superwall_release() {
        addJavascriptInterface(getMessageHandler(), "SWAndroid");
        WebSettings settings = getSettings();
        Intrinsics.checkNotNullExpressionValue(settings, "getSettings(...)");
        WebView.setWebContentsDebuggingEnabled(false);
        settings.setJavaScriptEnabled(true);
        settings.setSupportZoom(false);
        settings.setBuiltInZoomControls(false);
        settings.setDisplayZoomControls(false);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        settings.setTextZoom(100);
        settings.setMediaPlaybackRequiresUserGesture(false);
        setBackgroundColor(0);
        setWebChromeClient(new ChromeClient.C0247ChromeClient(new Function0() { // from class: com.superwall.sdk.paywall.view.webview.d
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return this.f93712a.getActivity();
            }
        }));
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void setDelegate(PaywallUIDelegate paywallUIDelegate) {
        this.delegate = paywallUIDelegate;
    }

    public final void setOnRenderCrashed(Function2<? super Boolean, ? super Integer, Unit> function2) {
        Intrinsics.checkNotNullParameter(function2, "<set-?>");
        this.onRenderCrashed = function2;
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void setOnScrollChangeListener(PaywallWebUI.OnScrollChangeListener onScrollChangeListener) {
        this.onScrollChangeListener = onScrollChangeListener;
    }

    public final void setScrollEnabled(boolean z2) {
        this.scrollEnabled = z2;
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    /* JADX INFO: renamed from: setup-MkQ7Bds */
    public void mo1339setupMkQ7Bds(String url, Function2<? super Boolean, ? super Integer, Unit> onRenderCrashed) {
        PaywallViewState state;
        Paywall paywall;
        Boolean boolIsScrollEnabled;
        Intrinsics.checkNotNullParameter(url, "url");
        Intrinsics.checkNotNullParameter(onRenderCrashed, "onRenderCrashed");
        this.onRenderCrashed = onRenderCrashed;
        PaywallUIDelegate delegate = getDelegate();
        this.scrollEnabled = (delegate == null || (state = delegate.getState()) == null || (paywall = state.getPaywall()) == null || (boolIsScrollEnabled = paywall.isScrollEnabled()) == null) ? true : boolIsScrollEnabled.booleanValue();
        this.loadRetryCount = 0;
        BuildersKt__Builders_commonKt.d(this.mainScope, null, null, new SWWebView$setup$1(this, url, null), 3, null);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Multi-variable type inference failed */
    public SWWebView(final Context context, PaywallMessageHandler messageHandler, Function1<? super String, Unit> function1, Function0<PaywallOptions> options, Function2<? super TrackableSuperwallEvent, ? super Continuation<? super Unit>, ? extends Object> track) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(messageHandler, "messageHandler");
        Intrinsics.checkNotNullParameter(options, "options");
        Intrinsics.checkNotNullParameter(track, "track");
        this.messageHandler = messageHandler;
        this.onFinishedLoading = function1;
        this.options = options;
        this.track = track;
        this.mainScope = new MainScope(null, 1, null);
        this.ioScope = new IOScope(null, 1, null);
        this.gestureDetector$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.paywall.view.webview.k
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SWWebView.gestureDetector_delegate$lambda$0(context);
            }
        });
        this.localResourceHandler$delegate = LazyKt.b(new Function0() { // from class: com.superwall.sdk.paywall.view.webview.l
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return SWWebView.localResourceHandler_delegate$lambda$2(context);
            }
        });
        this.scrollEnabled = true;
        this.onRenderCrashed = new Function2() { // from class: com.superwall.sdk.paywall.view.webview.m
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return SWWebView.onRenderCrashed$lambda$3(((Boolean) obj).booleanValue(), ((Integer) obj2).intValue());
            }
        };
        this.mediaLifecycleReady = true;
        this.onPageStartedPreloadHook = new Function1() { // from class: com.superwall.sdk.paywall.view.webview.n
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return SWWebView.onPageStartedPreloadHook$lambda$5(this.f93725a, (WebView) obj);
            }
        };
    }

    @Override // com.superwall.sdk.paywall.view.webview.PaywallWebUI
    public void enableBackgroundRendering() {
    }
}
