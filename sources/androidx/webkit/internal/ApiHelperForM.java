package androidx.webkit.internal;

import android.webkit.WebMessage;
import android.webkit.WebMessagePort;
import android.webkit.WebResourceError;
import android.webkit.WebView;
import androidx.webkit.WebMessageCompat;
import androidx.webkit.WebMessagePortCompat;
import androidx.webkit.WebViewCompat;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes.dex */
public class ApiHelperForM {

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiHelperForM$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 extends WebMessagePort.WebMessageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebMessagePortCompat.WebMessageCallbackCompat f53921a;

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            this.f53921a.a(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.b(webMessage));
        }
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiHelperForM$2, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass2 extends WebMessagePort.WebMessageCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebMessagePortCompat.WebMessageCallbackCompat f53922a;

        @Override // android.webkit.WebMessagePort.WebMessageCallback
        public void onMessage(WebMessagePort webMessagePort, WebMessage webMessage) {
            this.f53922a.a(new WebMessagePortImpl(webMessagePort), WebMessagePortImpl.b(webMessage));
        }
    }

    /* JADX INFO: renamed from: androidx.webkit.internal.ApiHelperForM$3, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass3 extends WebView.VisualStateCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ WebViewCompat.VisualStateCallback f53923a;

        @Override // android.webkit.WebView.VisualStateCallback
        public void onComplete(long j3) {
            this.f53923a.onComplete(j3);
        }
    }

    public static WebMessageCompat a(WebMessage webMessage) {
        return new WebMessageCompat(webMessage.getData(), WebMessagePortImpl.d(webMessage.getPorts()));
    }

    public static CharSequence b(WebResourceError webResourceError) {
        return webResourceError.getDescription();
    }

    public static int c(WebResourceError webResourceError) {
        return webResourceError.getErrorCode();
    }
}
