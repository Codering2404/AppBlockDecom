package androidx.webkit.internal;

import android.webkit.ServiceWorkerController;
import android.webkit.ServiceWorkerWebSettings;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ApiHelperForN {
    public static ServiceWorkerController a() {
        return ServiceWorkerController.getInstance();
    }

    public static ServiceWorkerWebSettings b(ServiceWorkerController serviceWorkerController) {
        return serviceWorkerController.getServiceWorkerWebSettings();
    }

    public static ServiceWorkerWebSettingsImpl c(ServiceWorkerController serviceWorkerController) {
        return new ServiceWorkerWebSettingsImpl(b(serviceWorkerController));
    }
}
