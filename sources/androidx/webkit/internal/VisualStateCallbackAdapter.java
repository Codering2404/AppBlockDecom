package androidx.webkit.internal;

import androidx.webkit.WebViewCompat;
import org.chromium.support_lib_boundary.VisualStateCallbackBoundaryInterface;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class VisualStateCallbackAdapter implements VisualStateCallbackBoundaryInterface {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final WebViewCompat.VisualStateCallback f53944a;

    @Override // org.chromium.support_lib_boundary.VisualStateCallbackBoundaryInterface
    public void onComplete(long j3) {
        this.f53944a.onComplete(j3);
    }
}
