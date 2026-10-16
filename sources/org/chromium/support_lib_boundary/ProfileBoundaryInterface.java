package org.chromium.support_lib_boundary;

import android.webkit.CookieManager;
import android.webkit.GeolocationPermissions;
import android.webkit.ServiceWorkerController;
import android.webkit.ValueCallback;
import android.webkit.WebStorage;
import java.lang.reflect.InvocationHandler;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes9.dex */
public interface ProfileBoundaryInterface {
    void cancelPrefetch(String str);

    void clearPrefetch(String str, ValueCallback<InvocationHandler> valueCallback);

    CookieManager getCookieManager();

    GeolocationPermissions getGeoLocationPermissions();

    String getName();

    ServiceWorkerController getServiceWorkerController();

    WebStorage getWebStorage();

    void prefetchUrl(String str, ValueCallback<InvocationHandler> valueCallback);

    void prefetchUrl(String str, InvocationHandler invocationHandler, ValueCallback<InvocationHandler> valueCallback);
}
