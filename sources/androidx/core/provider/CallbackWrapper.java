package androidx.core.provider;

import android.graphics.Typeface;
import androidx.core.provider.FontRequestWorker;
import androidx.core.provider.FontsContractCompat;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class CallbackWrapper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final FontsContractCompat.FontRequestCallback f34179a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final Executor f34180b;

    CallbackWrapper(FontsContractCompat.FontRequestCallback fontRequestCallback, Executor executor) {
        this.f34179a = fontRequestCallback;
        this.f34180b = executor;
    }

    private void a(final int i3) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f34179a;
        this.f34180b.execute(new Runnable() { // from class: androidx.core.provider.CallbackWrapper.2
            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.a(i3);
            }
        });
    }

    private void c(final Typeface typeface) {
        final FontsContractCompat.FontRequestCallback fontRequestCallback = this.f34179a;
        this.f34180b.execute(new Runnable() { // from class: androidx.core.provider.CallbackWrapper.1
            @Override // java.lang.Runnable
            public void run() {
                fontRequestCallback.b(typeface);
            }
        });
    }

    void b(FontRequestWorker.TypefaceResult typefaceResult) {
        if (typefaceResult.a()) {
            c(typefaceResult.f34214a);
        } else {
            a(typefaceResult.f34215b);
        }
    }
}
