package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ViewCompatShims {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api26Impl {
        public static AutofillId a(View view) {
            return view.getAutofillId();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api29Impl {
        static ContentCaptureSession a(View view) {
            return view.getContentCaptureSession();
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api30Impl {
        static void a(View view, int i3) {
            view.setImportantForContentCapture(i3);
        }
    }

    public static AutofillIdCompat a(View view) {
        return AutofillIdCompat.b(Api26Impl.a(view));
    }

    public static ContentCaptureSessionCompat b(View view) {
        ContentCaptureSession contentCaptureSessionA;
        if (Build.VERSION.SDK_INT < 29 || (contentCaptureSessionA = Api29Impl.a(view)) == null) {
            return null;
        }
        return ContentCaptureSessionCompat.g(contentCaptureSessionA, view);
    }

    public static void c(View view, int i3) {
        if (Build.VERSION.SDK_INT >= 30) {
            Api30Impl.a(view, i3);
        }
    }
}
