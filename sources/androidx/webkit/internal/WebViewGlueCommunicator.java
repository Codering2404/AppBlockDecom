package androidx.webkit.internal;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import org.chromium.support_lib_boundary.WebViewProviderFactoryBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebViewGlueCommunicator {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LAZY_COMPAT_CONVERTER_HOLDER {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final WebkitToCompatConverter f53992a = new WebkitToCompatConverter(WebViewGlueCommunicator.d().getWebkitToCompatConverter());
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class LAZY_FACTORY_HOLDER {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final WebViewProviderFactory f53993a = WebViewGlueCommunicator.a();
    }

    static WebViewProviderFactory a() {
        try {
            return new WebViewProviderFactoryAdapter((WebViewProviderFactoryBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebViewProviderFactoryBoundaryInterface.class, b()));
        } catch (ClassNotFoundException unused) {
            return new IncompatibleApkWebViewProviderFactory();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e3) {
            throw new RuntimeException(e3);
        }
    }

    private static InvocationHandler b() {
        return (InvocationHandler) Class.forName("org.chromium.support_lib_glue.SupportLibReflectionUtil", false, e()).getDeclaredMethod("createWebViewProviderFactory", null).invoke(null, null);
    }

    public static WebkitToCompatConverter c() {
        return LAZY_COMPAT_CONVERTER_HOLDER.f53992a;
    }

    public static WebViewProviderFactory d() {
        return LAZY_FACTORY_HOLDER.f53993a;
    }

    public static ClassLoader e() {
        return ApiHelperForP.b();
    }
}
