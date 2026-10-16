package cz.mobilesoft.coreblock.scene.chatbot.chatbot;

import android.content.Context;
import android.net.Uri;
import android.os.Message;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import com.google.accompanist.web.AccompanistWebChromeClient;
import com.google.accompanist.web.AccompanistWebViewClient;
import cz.mobilesoft.coreblock.enums.ContactReason;
import cz.mobilesoft.coreblock.scene.feedback.FeedbackActivity;
import cz.mobilesoft.coreblock.util.ExternalLinksHelper;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

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
public final class ChatBotChromeClient extends AccompanistWebChromeClient {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Context f99032b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final String f99033c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private final ContactReason f99034d;

    public ChatBotChromeClient(Context context, String entrances, ContactReason contactReason) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(entrances, "entrances");
        Intrinsics.checkNotNullParameter(contactReason, "contactReason");
        this.f99032b = context;
        this.f99033c = entrances;
        this.f99034d = contactReason;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void d(Uri uri) {
        String string = uri.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        if (!ChatbotActionUrls.CONTACT_SUPPORT.getUrlPattern().k(string)) {
            ExternalLinksHelper.f127866a.c(this.f99032b, uri);
            return;
        }
        Context context = this.f99032b;
        context.startActivity(FeedbackActivity.Companion.b(FeedbackActivity.f102045f, context, this.f99034d, null, null, this.f99033c, "unknown url for chatbase", false, 76, null));
    }

    @Override // android.webkit.WebChromeClient
    public boolean onCreateWindow(WebView webView, boolean z2, boolean z3, Message message) {
        WebView webView2 = new WebView(this.f99032b);
        webView2.getSettings().setJavaScriptEnabled(true);
        webView2.getSettings().setSupportMultipleWindows(true);
        webView2.setWebViewClient(new AccompanistWebViewClient() { // from class: cz.mobilesoft.coreblock.scene.chatbot.chatbot.ChatBotChromeClient$onCreateWindow$dummyWebView$1$1
            @Override // com.google.accompanist.web.AccompanistWebViewClient, android.webkit.WebViewClient
            public boolean shouldOverrideUrlLoading(WebView webView3, WebResourceRequest webResourceRequest) {
                Uri url;
                if (webResourceRequest == null || (url = webResourceRequest.getUrl()) == null) {
                    return true;
                }
                this.f99035d.d(url);
                return true;
            }
        });
        Object obj = message != null ? message.obj : null;
        WebView.WebViewTransport webViewTransport = obj instanceof WebView.WebViewTransport ? (WebView.WebViewTransport) obj : null;
        if (webViewTransport != null) {
            webViewTransport.setWebView(webView2);
        }
        if (message != null) {
            message.sendToTarget();
        }
        return true;
    }
}
