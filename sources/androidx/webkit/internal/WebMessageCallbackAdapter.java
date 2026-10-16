package androidx.webkit.internal;

import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import java.lang.reflect.InvocationHandler;
import org.chromium.support_lib_boundary.WebMessageBoundaryInterface;
import org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebMessageCallbackAdapter implements WebMessageCallbackBoundaryInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebMessagePortCompat.WebMessageCallbackCompat f53947a;

    @Override // org.chromium.support_lib_boundary.FeatureFlagHolderBoundaryInterface
    public String[] getSupportedFeatures() {
        return new String[]{"WEB_MESSAGE_CALLBACK_ON_MESSAGE"};
    }

    @Override // org.chromium.support_lib_boundary.WebMessageCallbackBoundaryInterface
    public void onMessage(InvocationHandler invocationHandler, InvocationHandler invocationHandler2) {
        WebMessageCompat webMessageCompatB = WebMessageAdapter.b((WebMessageBoundaryInterface) BoundaryInterfaceReflectionUtil.a(WebMessageBoundaryInterface.class, invocationHandler2));
        if (webMessageCompatB != null) {
            this.f53947a.a(new WebMessagePortImpl(invocationHandler), webMessageCompatB);
        }
    }
}
