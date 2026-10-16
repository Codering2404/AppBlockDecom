package androidx.webkit;

import android.content.pm.PackageInfo;
import android.net.Uri;
import android.webkit.WebView;
import androidx.webkit.internal.ApiHelperForO;
import androidx.webkit.internal.WebViewFeatureInternal;
import androidx.webkit.internal.WebViewGlueCommunicator;
import androidx.webkit.internal.WebViewProviderAdapter;
import androidx.webkit.internal.WebViewProviderFactory;
import java.util.Set;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class WebViewCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final Uri f53915a = Uri.parse("*");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Uri f53916b = Uri.parse("");

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface VisualStateCallback {
        void onComplete(long j3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface WebMessageListener {
        void onPostMessage(WebView webView, WebMessageCompat webMessageCompat, Uri uri, boolean z2, JavaScriptReplyProxy javaScriptReplyProxy);
    }

    public static ScriptHandler a(WebView webView, String str, Set set) {
        if (WebViewFeatureInternal.V.d()) {
            return f(webView).a(str, (String[]) set.toArray(new String[0]));
        }
        throw WebViewFeatureInternal.a();
    }

    public static void b(WebView webView, String str, Set set, WebMessageListener webMessageListener) {
        if (!WebViewFeatureInternal.U.d()) {
            throw WebViewFeatureInternal.a();
        }
        f(webView).b(str, (String[]) set.toArray(new String[0]), webMessageListener);
    }

    private static WebViewProviderBoundaryInterface c(WebView webView) {
        return e().createWebView(webView);
    }

    public static PackageInfo d() {
        return ApiHelperForO.a();
    }

    private static WebViewProviderFactory e() {
        return WebViewGlueCommunicator.d();
    }

    private static WebViewProviderAdapter f(WebView webView) {
        return new WebViewProviderAdapter(c(webView));
    }

    public static String g() {
        if (WebViewFeatureInternal.X.d()) {
            return e().getStatics().getVariationsHeader();
        }
        throw WebViewFeatureInternal.a();
    }

    public static boolean h() {
        if (WebViewFeatureInternal.R.d()) {
            return e().getStatics().isMultiProcessEnabled();
        }
        throw WebViewFeatureInternal.a();
    }

    public static void i(WebView webView, String str) {
        if (!WebViewFeatureInternal.U.d()) {
            throw WebViewFeatureInternal.a();
        }
        f(webView).c(str);
    }

    public static void j(WebView webView, boolean z2) {
        if (!WebViewFeatureInternal.f53967f0.d()) {
            throw WebViewFeatureInternal.a();
        }
        f(webView).d(z2);
    }

    public static void k(WebView webView, String str) {
        if (!WebViewFeatureInternal.f53961c0.d()) {
            throw WebViewFeatureInternal.a();
        }
        f(webView).e(str);
    }
}
