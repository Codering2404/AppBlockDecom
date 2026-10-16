package androidx.webkit.internal;

import android.webkit.ServiceWorkerController;
import androidx.webkit.ServiceWorkerControllerCompat;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import androidx.webkit.internal.ApiFeature;
import org.chromium.support_lib_boundary.ServiceWorkerControllerBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ServiceWorkerControllerImpl extends ServiceWorkerControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ServiceWorkerController f53934a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ServiceWorkerControllerBoundaryInterface f53935b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ServiceWorkerWebSettingsCompat f53936c;

    public ServiceWorkerControllerImpl() {
        ApiFeature.N n3 = WebViewFeatureInternal.f53975k;
        if (n3.c()) {
            this.f53934a = ApiHelperForN.a();
            this.f53935b = null;
            this.f53936c = ApiHelperForN.c(a());
        } else {
            if (!n3.d()) {
                throw WebViewFeatureInternal.a();
            }
            this.f53934a = null;
            ServiceWorkerControllerBoundaryInterface serviceWorkerController = WebViewGlueCommunicator.d().getServiceWorkerController();
            this.f53935b = serviceWorkerController;
            this.f53936c = new ServiceWorkerWebSettingsImpl(serviceWorkerController.getServiceWorkerWebSettings());
        }
    }

    private ServiceWorkerController a() {
        if (this.f53934a == null) {
            this.f53934a = ApiHelperForN.a();
        }
        return this.f53934a;
    }
}
