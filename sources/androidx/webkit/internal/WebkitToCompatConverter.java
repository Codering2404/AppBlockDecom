package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebkitToCompatConverterBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebkitToCompatConverter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebkitToCompatConverterBoundaryInterface f54003a;

    public WebkitToCompatConverter(WebkitToCompatConverterBoundaryInterface webkitToCompatConverterBoundaryInterface) {
        this.f54003a = webkitToCompatConverterBoundaryInterface;
    }

    public SafeBrowsingResponse a(InvocationHandler invocationHandler) {
        return (SafeBrowsingResponse) this.f54003a.convertSafeBrowsingResponse(invocationHandler);
    }

    public InvocationHandler b(SafeBrowsingResponse safeBrowsingResponse) {
        return this.f54003a.convertSafeBrowsingResponse(safeBrowsingResponse);
    }

    public InvocationHandler c(WebMessagePort webMessagePort) {
        return this.f54003a.convertWebMessagePort(webMessagePort);
    }

    public WebResourceError d(InvocationHandler invocationHandler) {
        return (WebResourceError) this.f54003a.convertWebResourceError(invocationHandler);
    }

    public InvocationHandler e(WebResourceError webResourceError) {
        return this.f54003a.convertWebResourceError(webResourceError);
    }
}
