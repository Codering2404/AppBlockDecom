package androidx.webkit.internal;

import android.webkit.ServiceWorkerWebSettings;
import androidx.webkit.ServiceWorkerWebSettingsCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.ServiceWorkerWebSettingsBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ServiceWorkerWebSettingsImpl extends ServiceWorkerWebSettingsCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ServiceWorkerWebSettings f53937a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private ServiceWorkerWebSettingsBoundaryInterface f53938b;

    public ServiceWorkerWebSettingsImpl(ServiceWorkerWebSettings serviceWorkerWebSettings) {
        this.f53937a = serviceWorkerWebSettings;
    }

    public ServiceWorkerWebSettingsImpl(InvocationHandler invocationHandler) {
        this.f53938b = (ServiceWorkerWebSettingsBoundaryInterface) BoundaryInterfaceReflectionUtil.a(ServiceWorkerWebSettingsBoundaryInterface.class, invocationHandler);
    }
}
