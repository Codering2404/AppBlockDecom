package androidx.webkit.internal;

import android.webkit.SafeBrowsingResponse;
import androidx.webkit.SafeBrowsingResponseCompat;
import androidx.webkit.internal.ApiFeature;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;
import org.chromium.support_lib_boundary.SafeBrowsingResponseBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class SafeBrowsingResponseImpl extends SafeBrowsingResponseCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SafeBrowsingResponse f53930a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private SafeBrowsingResponseBoundaryInterface f53931b;

    public SafeBrowsingResponseImpl(InvocationHandler invocationHandler) {
        this.f53931b = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.a(SafeBrowsingResponseBoundaryInterface.class, invocationHandler);
    }

    private SafeBrowsingResponseBoundaryInterface b() {
        if (this.f53931b == null) {
            this.f53931b = (SafeBrowsingResponseBoundaryInterface) BoundaryInterfaceReflectionUtil.a(SafeBrowsingResponseBoundaryInterface.class, WebViewGlueCommunicator.c().b(this.f53930a));
        }
        return this.f53931b;
    }

    private SafeBrowsingResponse c() {
        if (this.f53930a == null) {
            this.f53930a = WebViewGlueCommunicator.c().a(Proxy.getInvocationHandler(this.f53931b));
        }
        return this.f53930a;
    }

    @Override // androidx.webkit.SafeBrowsingResponseCompat
    public void a(boolean z2) {
        ApiFeature.O_MR1 o_mr1 = WebViewFeatureInternal.f53990z;
        if (o_mr1.c()) {
            ApiHelperForOMR1.a(c(), z2);
        } else {
            if (!o_mr1.d()) {
                throw WebViewFeatureInternal.a();
            }
            b().showInterstitial(z2);
        }
    }

    public SafeBrowsingResponseImpl(SafeBrowsingResponse safeBrowsingResponse) {
        this.f53930a = safeBrowsingResponse;
    }
}
