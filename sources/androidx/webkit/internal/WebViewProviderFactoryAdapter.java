package androidx.webkit.internal;

import android.webkit.WebView;
import org.chromium.support_lib_boundary.DropDataContentProviderBoundaryInterface;
import org.chromium.support_lib_boundary.ProfileStoreBoundaryInterface;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;
import org.chromium.support_lib_boundary.StaticsBoundaryInterface;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebViewProviderFactoryAdapter implements WebViewProviderFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WebViewProviderFactoryBoundaryInterface f53995a;

    public WebViewProviderFactoryAdapter(WebViewProviderFactoryBoundaryInterface webViewProviderFactoryBoundaryInterface) {
        this.f53995a = webViewProviderFactoryBoundaryInterface;
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public String[] a() {
        return this.f53995a.getSupportedFeatures();
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public WebViewProviderBoundaryInterface createWebView(WebView webView) {
        return (WebViewProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebViewProviderBoundaryInterface.class, this.f53995a.createWebView(webView));
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public DropDataContentProviderBoundaryInterface getDropDataProvider() {
        return (DropDataContentProviderBoundaryInterface) BoundaryInterfaceReflectionUtil.a(DropDataContentProviderBoundaryInterface.class, this.f53995a.getDropDataProvider());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public ProfileStoreBoundaryInterface getProfileStore() {
        return (ProfileStoreBoundaryInterface) BoundaryInterfaceReflectionUtil.a(ProfileStoreBoundaryInterface.class, this.f53995a.getProfileStore());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public ServiceWorkerControllerBoundaryInterface getServiceWorkerController() {
        return (ServiceWorkerControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.a(ServiceWorkerControllerBoundaryInterface.class, this.f53995a.getServiceWorkerController());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public StaticsBoundaryInterface getStatics() {
        return (StaticsBoundaryInterface) BoundaryInterfaceReflectionUtil.a(StaticsBoundaryInterface.class, this.f53995a.getStatics());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public TracingControllerBoundaryInterface getTracingController() {
        return (TracingControllerBoundaryInterface) BoundaryInterfaceReflectionUtil.a(TracingControllerBoundaryInterface.class, this.f53995a.getTracingController());
    }

    @Override // androidx.webkit.internal.WebViewProviderFactory
    public WebkitToCompatConverterBoundaryInterface getWebkitToCompatConverter() {
        return (WebkitToCompatConverterBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebkitToCompatConverterBoundaryInterface.class, this.f53995a.getWebkitToCompatConverter());
    }
}
