package androidx.webkit.internal;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.WebMessagePortBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebMessagePortImpl extends WebMessagePortCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WebMessagePort f53952a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private WebMessagePortBoundaryInterface f53953b;

    public WebMessagePortImpl(WebMessagePort webMessagePort) {
        this.f53952a = webMessagePort;
    }

    public static WebMessageCompat b(WebMessage webMessage) {
        return ApiHelperForM.a(webMessage);
    }

    private WebMessagePortBoundaryInterface c() {
        if (this.f53953b == null) {
            this.f53953b = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebMessagePortBoundaryInterface.class, WebViewGlueCommunicator.c().c(this.f53952a));
        }
        return this.f53953b;
    }

    public static WebMessagePortCompat[] d(WebMessagePort[] webMessagePortArr) {
        if (webMessagePortArr == null) {
            return null;
        }
        WebMessagePortCompat[] webMessagePortCompatArr = new WebMessagePortCompat[webMessagePortArr.length];
        for (int i3 = 0; i3 < webMessagePortArr.length; i3++) {
            webMessagePortCompatArr[i3] = new WebMessagePortImpl(webMessagePortArr[i3]);
        }
        return webMessagePortCompatArr;
    }

    @Override // androidx.webkit.WebMessagePortCompat
    public InvocationHandler a() {
        return Proxy.getInvocationHandler(c());
    }

    public WebMessagePortImpl(InvocationHandler invocationHandler) {
        this.f53953b = (WebMessagePortBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebMessagePortBoundaryInterface.class, invocationHandler);
    }
}
