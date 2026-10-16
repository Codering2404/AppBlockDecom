package androidx.core.view;

import android.view.WindowInsetsAnimationController;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WindowInsetsAnimationControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Impl f34515a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl {
        Impl() {
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl30 extends Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final WindowInsetsAnimationController f34516a;

        Impl30(WindowInsetsAnimationController windowInsetsAnimationController) {
            this.f34516a = windowInsetsAnimationController;
        }
    }

    WindowInsetsAnimationControllerCompat(WindowInsetsAnimationController windowInsetsAnimationController) {
        this.f34515a = new Impl30(windowInsetsAnimationController);
    }
}
