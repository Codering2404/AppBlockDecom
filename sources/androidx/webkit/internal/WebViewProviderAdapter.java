package androidx.webkit.internal;

import androidx.webkit.WebViewCompat;
import org.chromium.support_lib_boundary.WebViewProviderBoundaryInterface;
import org.chromium.support_lib_boundary.util.BoundaryInterfaceReflectionUtil;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class WebViewProviderAdapter {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final WebViewProviderBoundaryInterface f53994a;

    public WebViewProviderAdapter(WebViewProviderBoundaryInterface webViewProviderBoundaryInterface) {
        this.f53994a = webViewProviderBoundaryInterface;
    }

    public ScriptHandlerImpl a(String str, String[] strArr) {
        return ScriptHandlerImpl.a(this.f53994a.addDocumentStartJavaScript(str, strArr));
    }

    public void b(String str, String[] strArr, WebViewCompat.WebMessageListener webMessageListener) {
        this.f53994a.addWebMessageListener(str, strArr, BoundaryInterfaceReflectionUtil.c(new WebMessageListenerAdapter(webMessageListener)));
    }

    public void c(String str) {
        this.f53994a.removeWebMessageListener(str);
    }

    public void d(boolean z2) {
        this.f53994a.setAudioMuted(z2);
    }

    public void e(String str) {
        this.f53994a.setProfile(str);
    }
}
