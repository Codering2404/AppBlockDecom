package androidx.webkit.internal;

import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebViewCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebMessageListenerAdapter implements WebMessageListenerBoundaryInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebViewCompat.WebMessageListener f53948a;

    public WebMessageListenerAdapter(WebViewCompat.WebMessageListener webMessageListener) {
        this.f53948a = webMessageListener;
    }

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_LISTENER", "WEB_MESSAGE_ARRAY_BUFFER"};
    }

    @Override // org.chromium.support_lib_boundary.WebMessageListenerBoundaryInterface
    public void onPostMessage(WebView webView, InvocationHandler invocationHandler, Uri uri, boolean z2, InvocationHandler invocationHandler2) {
        WebMessageCompat webMessageCompatB = WebMessageAdapter.b((WebMessageBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebMessageBoundaryInterface.class, invocationHandler));
        if (webMessageCompatB != null) {
            this.f53948a.onPostMessage(webView, webMessageCompatB, uri, z2, JavaScriptReplyProxyImpl.b(invocationHandler2));
        }
    }
}
