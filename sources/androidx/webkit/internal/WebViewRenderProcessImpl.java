package androidx.webkit.internal;

import androidx.webkit.WebViewRenderProcess;
import java.lang.ref.WeakReference;
import java.lang.reflect.InvocationHandler;
import java.util.WeakHashMap;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.WebViewRendererBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebViewRenderProcessImpl extends WebViewRenderProcess {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final WeakHashMap f54000c = new WeakHashMap();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebViewRendererBoundaryInterface f54001a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WeakReference f54002b;

    public WebViewRenderProcessImpl(WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) {
        this.f54001a = webViewRendererBoundaryInterface;
    }

    public static /* synthetic */ Object a(WebViewRendererBoundaryInterface webViewRendererBoundaryInterface) {
        return new WebViewRenderProcessImpl(webViewRendererBoundaryInterface);
    }

    public static WebViewRenderProcessImpl b(android.webkit.WebViewRenderProcess webViewRenderProcess) {
        WeakHashMap weakHashMap = f54000c;
        WebViewRenderProcessImpl webViewRenderProcessImpl = (WebViewRenderProcessImpl) weakHashMap.get(webViewRenderProcess);
        if (webViewRenderProcessImpl != null) {
            return webViewRenderProcessImpl;
        }
        WebViewRenderProcessImpl webViewRenderProcessImpl2 = new WebViewRenderProcessImpl(webViewRenderProcess);
        weakHashMap.put(webViewRenderProcess, webViewRenderProcessImpl2);
        return webViewRenderProcessImpl2;
    }

    public static WebViewRenderProcessImpl c(InvocationHandler invocationHandler) {
        final WebViewRendererBoundaryInterface webViewRendererBoundaryInterface = (WebViewRendererBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebViewRendererBoundaryInterface.class, invocationHandler);
        return (WebViewRenderProcessImpl) webViewRendererBoundaryInterface.getOrCreatePeer(new Callable() { // from class: androidx.webkit.internal.d
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return WebViewRenderProcessImpl.a(webViewRendererBoundaryInterface);
            }
        });
    }

    public WebViewRenderProcessImpl(android.webkit.WebViewRenderProcess webViewRenderProcess) {
        this.f54002b = new WeakReference(webViewRenderProcess);
    }
}
