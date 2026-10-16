package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import com.sun.jna.Function;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WindowCompat {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api16Impl {
        static void a(Window window, boolean z2) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z2 ? systemUiVisibility & (-1793) : systemUiVisibility | 1792);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api28Impl {
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api30Impl {
        static void a(Window window, boolean z2) {
            View decorView = window.getDecorView();
            int systemUiVisibility = decorView.getSystemUiVisibility();
            decorView.setSystemUiVisibility(z2 ? systemUiVisibility & (-257) : systemUiVisibility | Function.MAX_NARGS);
            window.setDecorFitsSystemWindows(z2);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api35Impl {
        static void a(Window window, boolean z2) {
            window.setDecorFitsSystemWindows(z2);
        }
    }

    public static WindowInsetsControllerCompat a(Window window, View view) {
        return new WindowInsetsControllerCompat(window, view);
    }

    public static void b(Window window, boolean z2) {
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 35) {
            Api35Impl.a(window, z2);
        } else if (i3 >= 30) {
            Api30Impl.a(window, z2);
        } else {
            Api16Impl.a(window, z2);
        }
    }
}
