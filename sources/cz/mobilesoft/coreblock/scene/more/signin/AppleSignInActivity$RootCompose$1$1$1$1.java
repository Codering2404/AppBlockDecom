package cz.mobilesoft.coreblock.scene.more.signin;

import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cz.mobilesoft.coreblock.scene.more.signin.AppleSignInActivity;
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
/* JADX INFO: loaded from: classes8.dex */
@Metadata
public final class AppleSignInActivity$RootCompose$1$1$1$1 extends WebViewClient {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AppleSignInActivity f110357a;

    AppleSignInActivity$RootCompose$1$1$1$1(AppleSignInActivity appleSignInActivity) {
        this.f110357a = appleSignInActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void b(WebView webView) {
        webView.loadUrl("javascript: (function() { " + AppleSignInActivity.FormInterceptorInterface.f110353b.a() + " } ) ()");
    }

    @Override // android.webkit.WebViewClient
    public WebResourceResponse shouldInterceptRequest(final WebView view, WebResourceRequest request) {
        Intrinsics.checkNotNullParameter(view, "view");
        Intrinsics.checkNotNullParameter(request, "request");
        String string = request.getUrl().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (StringsKt.U(string, "https://appblock.app/user/success/", false, 2, null)) {
            this.f110357a.runOnUiThread(new Runnable() { // from class: cz.mobilesoft.coreblock.scene.more.signin.c
                @Override // java.lang.Runnable
                public final void run() {
                    AppleSignInActivity$RootCompose$1$1$1$1.b(view);
                }
            });
        }
        return super.shouldInterceptRequest(view, request);
    }
}
