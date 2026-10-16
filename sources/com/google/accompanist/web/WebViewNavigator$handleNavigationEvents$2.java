package com.google.accompanist.web;

import android.webkit.WebView;
import com.google.accompanist.web.WebViewNavigator;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
@DebugMetadata(c = "com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$2", f = "WebView.kt", l = {356}, m = "invokeSuspend")
final class WebViewNavigator$handleNavigationEvents$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<?>, Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    int f68927a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ WebViewNavigator f68928b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ WebView f68929c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    WebViewNavigator$handleNavigationEvents$2(WebViewNavigator webViewNavigator, WebView webView, Continuation continuation) {
        super(2, continuation);
        this.f68928b = webViewNavigator;
        this.f68929c = webView;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation create(Object obj, Continuation continuation) {
        return new WebViewNavigator$handleNavigationEvents$2(this.f68928b, this.f68929c, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        Object objF = IntrinsicsKt.f();
        int i3 = this.f68927a;
        if (i3 == 0) {
            ResultKt.b(obj);
            MutableSharedFlow mutableSharedFlow = this.f68928b.f68916b;
            final WebView webView = this.f68929c;
            FlowCollector<WebViewNavigator.NavigationEvent> flowCollector = new FlowCollector<WebViewNavigator.NavigationEvent>() { // from class: com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$2.1

                /* JADX INFO: renamed from: com.google.accompanist.web.WebViewNavigator$handleNavigationEvents$2$1$WhenMappings */
                /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
                @Metadata
                public /* synthetic */ class WhenMappings {

                    /* JADX INFO: renamed from: a, reason: collision with root package name */
                    public static final /* synthetic */ int[] f68931a;

                    static {
                        int[] iArr = new int[WebViewNavigator.NavigationEvent.values().length];
                        try {
                            iArr[WebViewNavigator.NavigationEvent.BACK.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[WebViewNavigator.NavigationEvent.FORWARD.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[WebViewNavigator.NavigationEvent.RELOAD.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[WebViewNavigator.NavigationEvent.STOP_LOADING.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        f68931a = iArr;
                    }
                }

                @Override // kotlinx.coroutines.flow.FlowCollector
                /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
                public final Object emit(WebViewNavigator.NavigationEvent navigationEvent, Continuation continuation) {
                    int i4 = WhenMappings.f68931a[navigationEvent.ordinal()];
                    if (i4 == 1) {
                        webView.goBack();
                    } else if (i4 == 2) {
                        webView.goForward();
                    } else if (i4 == 3) {
                        webView.reload();
                    } else if (i4 == 4) {
                        webView.stopLoading();
                    }
                    return Unit.f139807a;
                }
            };
            this.f68927a = 1;
            if (mutableSharedFlow.collect(flowCollector, this) == objF) {
                return objF;
            }
        } else {
            if (i3 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.b(obj);
        }
        throw new KotlinNothingValueException();
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation continuation) {
        return ((WebViewNavigator$handleNavigationEvents$2) create(coroutineScope, continuation)).invokeSuspend(Unit.f139807a);
    }
}
