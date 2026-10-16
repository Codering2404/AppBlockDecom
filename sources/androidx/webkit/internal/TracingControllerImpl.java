package androidx.webkit.internal;

import androidx.webkit.TracingController;
import androidx.webkit.internal.ApiFeature;
import org.chromium.support_lib_boundary.TracingControllerBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class TracingControllerImpl extends TracingController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private android.webkit.TracingController f53942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TracingControllerBoundaryInterface f53943b;

    public TracingControllerImpl() {
        ApiFeature.P p3 = WebViewFeatureInternal.L;
        if (p3.c()) {
            this.f53942a = ApiHelperForP.a();
            this.f53943b = null;
        } else {
            if (!p3.d()) {
                throw WebViewFeatureInternal.a();
            }
            this.f53942a = null;
            this.f53943b = WebViewGlueCommunicator.d().getTracingController();
        }
    }
}
