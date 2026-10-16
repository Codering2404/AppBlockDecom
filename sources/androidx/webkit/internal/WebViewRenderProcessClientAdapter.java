package androidx.webkit.internal;

import android.webkit.WebView;
import androidx.webkit.WebViewRenderProcessClient;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Executor;
import org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebViewRenderProcessClientAdapter implements WebViewRendererClientBoundaryInterface {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final String[] f53996c = {"WEB_VIEW_RENDERER_CLIENT_BASIC_USAGE"};

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Executor f53997a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final WebViewRenderProcessClient f53998b;

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public final String[] getSupportedFeatures() {
        return f53996c;
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererResponsive(final WebView webView, InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl webViewRenderProcessImplC = WebViewRenderProcessImpl.c(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.f53998b;
        Executor executor = this.f53997a;
        if (executor == null) {
            webViewRenderProcessClient.a(webView, webViewRenderProcessImplC);
        } else {
            executor.execute(new Runnable() { // from class: androidx.webkit.internal.b
                @Override // java.lang.Runnable
                public final void run() {
                    webViewRenderProcessClient.a(webView, webViewRenderProcessImplC);
                }
            });
        }
    }

    @Override // org.chromium.support_lib_boundary.WebViewRendererClientBoundaryInterface
    public final void onRendererUnresponsive(final WebView webView, InvocationHandler invocationHandler) {
        final WebViewRenderProcessImpl webViewRenderProcessImplC = WebViewRenderProcessImpl.c(invocationHandler);
        final WebViewRenderProcessClient webViewRenderProcessClient = this.f53998b;
        Executor executor = this.f53997a;
        if (executor == null) {
            webViewRenderProcessClient.b(webView, webViewRenderProcessImplC);
        } else {
            executor.execute(new Runnable() { // from class: androidx.webkit.internal.c
                @Override // java.lang.Runnable
                public final void run() {
                    webViewRenderProcessClient.b(webView, webViewRenderProcessImplC);
                }
            });
        }
    }
}
