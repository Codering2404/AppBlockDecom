package androidx.webkit.internal;

import androidx.webkit.JavaScriptReplyProxy;
import java.lang.reflect.InvocationHandler;
import java.util.concurrent.Callable;
import org.chromium.support_lib_boundary.JsReplyProxyBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class JavaScriptReplyProxyImpl extends JavaScriptReplyProxy {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final JsReplyProxyBoundaryInterface f53926a;

    public JavaScriptReplyProxyImpl(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        this.f53926a = jsReplyProxyBoundaryInterface;
    }

    public static /* synthetic */ Object a(JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface) {
        return new JavaScriptReplyProxyImpl(jsReplyProxyBoundaryInterface);
    }

    public static JavaScriptReplyProxyImpl b(InvocationHandler invocationHandler) {
        final JsReplyProxyBoundaryInterface jsReplyProxyBoundaryInterface = (JsReplyProxyBoundaryInterface) BoundaryInterfaceReflectionUtil.a(JsReplyProxyBoundaryInterface.class, invocationHandler);
        return (JavaScriptReplyProxyImpl) jsReplyProxyBoundaryInterface.getOrCreatePeer(new Callable() { // from class: androidx.webkit.internal.a
            @Override // java.util.concurrent.Callable
            public final Object call() {
                return JavaScriptReplyProxyImpl.a(jsReplyProxyBoundaryInterface);
            }
        });
    }
}
