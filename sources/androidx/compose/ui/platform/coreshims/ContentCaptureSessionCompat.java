package androidx.compose.ui.platform.coreshims;

import android.os.Build;
import android.view.View;
import android.view.ViewStructure;
import android.view.autofill.AutofillId;
import android.view.contentcapture.ContentCaptureSession;
import java.util.Objects;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public class ContentCaptureSessionCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Object f28362a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final View f28363b;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api23Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api29Impl {
        static AutofillId a(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j3) {
            return contentCaptureSession.newAutofillId(autofillId, j3);
        }

        static ViewStructure b(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long j3) {
            return contentCaptureSession.newVirtualViewStructure(autofillId, j3);
        }

        static void c(ContentCaptureSession contentCaptureSession, ViewStructure viewStructure) {
            contentCaptureSession.notifyViewAppeared(viewStructure);
        }

        static void d(ContentCaptureSession contentCaptureSession, AutofillId autofillId) {
            contentCaptureSession.notifyViewDisappeared(autofillId);
        }

        public static void e(ContentCaptureSession contentCaptureSession, AutofillId autofillId, CharSequence charSequence) {
            contentCaptureSession.notifyViewTextChanged(autofillId, charSequence);
        }

        static void f(ContentCaptureSession contentCaptureSession, AutofillId autofillId, long[] jArr) {
            contentCaptureSession.notifyViewsDisappeared(autofillId, jArr);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Api34Impl {
    }

    private ContentCaptureSessionCompat(ContentCaptureSession contentCaptureSession, View view) {
        this.f28362a = contentCaptureSession;
        this.f28363b = view;
    }

    public static ContentCaptureSessionCompat g(ContentCaptureSession contentCaptureSession, View view) {
        return new ContentCaptureSessionCompat(contentCaptureSession, view);
    }

    public void a() {
        if (Build.VERSION.SDK_INT >= 29) {
            ContentCaptureSession contentCaptureSessionA = a.a(this.f28362a);
            AutofillIdCompat autofillIdCompatA = ViewCompatShims.a(this.f28363b);
            Objects.requireNonNull(autofillIdCompatA);
            Api29Impl.f(contentCaptureSessionA, autofillIdCompatA.a(), new long[]{Long.MIN_VALUE});
        }
    }

    public AutofillId b(long j3) {
        if (Build.VERSION.SDK_INT < 29) {
            return null;
        }
        ContentCaptureSession contentCaptureSessionA = a.a(this.f28362a);
        AutofillIdCompat autofillIdCompatA = ViewCompatShims.a(this.f28363b);
        Objects.requireNonNull(autofillIdCompatA);
        return Api29Impl.a(contentCaptureSessionA, autofillIdCompatA.a(), j3);
    }

    public ViewStructureCompat c(AutofillId autofillId, long j3) {
        if (Build.VERSION.SDK_INT >= 29) {
            return ViewStructureCompat.i(Api29Impl.b(a.a(this.f28362a), autofillId, j3));
        }
        return null;
    }

    public void d(ViewStructure viewStructure) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.c(a.a(this.f28362a), viewStructure);
        }
    }

    public void e(AutofillId autofillId) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.d(a.a(this.f28362a), autofillId);
        }
    }

    public void f(AutofillId autofillId, CharSequence charSequence) {
        if (Build.VERSION.SDK_INT >= 29) {
            Api29Impl.e(a.a(this.f28362a), autofillId, charSequence);
        }
    }
}
