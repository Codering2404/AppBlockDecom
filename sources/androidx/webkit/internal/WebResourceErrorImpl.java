package androidx.webkit.internal;

import android.webkit.WebResourceError;
import androidx.webkit.WebResourceErrorCompat;
import androidx.webkit.internal.ApiFeature;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebResourceErrorBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebResourceErrorImpl extends WebResourceErrorCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebResourceError f53954a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebResourceErrorBoundaryInterface f53955b;

    public WebResourceErrorImpl(InvocationHandler invocationHandler) {
        this.f53955b = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebResourceErrorBoundaryInterface.class, invocationHandler);
    }

    private WebResourceErrorBoundaryInterface c() {
        if (this.f53955b == null) {
            this.f53955b = (WebResourceErrorBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebResourceErrorBoundaryInterface.class, WebViewGlueCommunicator.c().e(this.f53954a));
        }
        return this.f53955b;
    }

    private WebResourceError d() {
        if (this.f53954a == null) {
            this.f53954a = WebViewGlueCommunicator.c().d(Proxy.getInvocationHandler(this.f53955b));
        }
        return this.f53954a;
    }

    @Override // androidx.webkit.WebResourceErrorCompat
    public CharSequence a() {
        ApiFeature.M m3 = WebViewFeatureInternal.f53986v;
        if (m3.c()) {
            return ApiHelperForM.b(d());
        }
        if (m3.d()) {
            return c().getDescription();
        }
        throw WebViewFeatureInternal.a();
    }

    @Override // androidx.webkit.WebResourceErrorCompat
    public int b() {
        ApiFeature.M m3 = WebViewFeatureInternal.f53987w;
        if (m3.c()) {
            return ApiHelperForM.c(d());
        }
        if (m3.d()) {
            return c().getErrorCode();
        }
        throw WebViewFeatureInternal.a();
    }

    public WebResourceErrorImpl(WebResourceError webResourceError) {
        this.f53954a = webResourceError;
    }
}
