package com.google.accompanist.web;

import android.graphics.Bitmap;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.facebook.internal.ServerProtocol;
import com.google.accompanist.web.LoadingState;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

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
/* JADX INFO: loaded from: classes4.dex */
@Metadata
public class AccompanistWebViewClient extends WebViewClient {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final int f68868c = 8;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public WebViewState f68869a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public WebViewNavigator f68870b;

    public WebViewNavigator a() {
        WebViewNavigator webViewNavigator = this.f68870b;
        if (webViewNavigator != null) {
            return webViewNavigator;
        }
        Intrinsics.throwUninitializedPropertyAccessException("navigator");
        return null;
    }

    public WebViewState b() {
        WebViewState webViewState = this.f68869a;
        if (webViewState != null) {
            return webViewState;
        }
        Intrinsics.throwUninitializedPropertyAccessException(ServerProtocol.DIALOG_PARAM_STATE);
        return null;
    }

    public void c(WebViewNavigator webViewNavigator) {
        Intrinsics.checkNotNullParameter(webViewNavigator, "<set-?>");
        this.f68870b = webViewNavigator;
    }

    public void d(WebViewState webViewState) {
        Intrinsics.checkNotNullParameter(webViewState, "<set-?>");
        this.f68869a = webViewState;
    }

    @Override // android.webkit.WebViewClient
    public void doUpdateVisitedHistory(WebView webView, String str, boolean z2) {
        super.doUpdateVisitedHistory(webView, str, z2);
        if (str == null || StringsKt.U(str, "data:text/html", false, 2, null) || Intrinsics.areEqual(b().a().a(), str)) {
            return;
        }
        b().d(WebViewKt.j(b().a(), str));
    }

    @Override // android.webkit.WebViewClient
    public void onPageFinished(WebView webView, String str) {
        super.onPageFinished(webView, str);
        b().e(LoadingState.Finished.f68871a);
        a().d(webView != null ? webView.canGoBack() : false);
        a().e(webView != null ? webView.canGoForward() : false);
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        super.onPageStarted(webView, str, bitmap);
        b().e(new LoadingState.Loading(0.0f));
        b().b().clear();
        b().g(null);
        b().f(null);
    }

    @Override // android.webkit.WebViewClient
    public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
        super.onReceivedError(webView, webResourceRequest, webResourceError);
        if (webResourceError != null) {
            b().b().add(new WebViewError(webResourceRequest, webResourceError));
        }
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
        if (Intrinsics.areEqual(webView != null ? webView.getUrl() : null, String.valueOf(webResourceRequest != null ? webResourceRequest.getUrl() : null))) {
            return false;
        }
        if (webResourceRequest == null) {
            return true;
        }
        WebViewState webViewStateB = b();
        WebContent webContentA = b().a();
        String string = webResourceRequest.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "it.url.toString()");
        webViewStateB.d(WebViewKt.j(webContentA, string));
        return true;
    }
}
