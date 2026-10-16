package androidx.transition;

import android.graphics.Matrix;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class GhostViewUtils {
    static GhostView a(View view, ViewGroup viewGroup, Matrix matrix) {
        return Build.VERSION.SDK_INT == 28 ? GhostViewPlatform.b(view, viewGroup, matrix) : GhostViewPort.b(view, viewGroup, matrix);
    }

    static void b(View view) {
        if (Build.VERSION.SDK_INT == 28) {
            GhostViewPlatform.f(view);
        } else {
            GhostViewPort.f(view);
        }
    }
}
