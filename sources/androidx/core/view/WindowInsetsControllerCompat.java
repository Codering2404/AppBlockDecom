package androidx.core.view;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsAnimationControlListener;
import android.view.WindowInsetsAnimationController;
import android.view.WindowInsetsController;
import androidx.collection.SimpleArrayMap;
import com.facebook.internal.Utility;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class WindowInsetsControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Impl f34550a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl20 extends Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        protected final Window f34551a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final SoftwareKeyboardControllerCompat f34552b;

        Impl20(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f34551a = window;
            this.f34552b = softwareKeyboardControllerCompat;
        }

        private void f(int i3) {
            if (i3 == 1) {
                g(4);
            } else if (i3 == 2) {
                g(2);
            } else {
                if (i3 != 8) {
                    return;
                }
                this.f34552b.a();
            }
        }

        private void i(int i3) {
            if (i3 == 1) {
                j(4);
                k(1024);
            } else if (i3 == 2) {
                j(2);
            } else {
                if (i3 != 8) {
                    return;
                }
                this.f34552b.b();
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void a(int i3) {
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    f(i4);
                }
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void e(int i3) {
            for (int i4 = 1; i4 <= 256; i4 <<= 1) {
                if ((i3 & i4) != 0) {
                    i(i4);
                }
            }
        }

        protected void g(int i3) {
            View decorView = this.f34551a.getDecorView();
            decorView.setSystemUiVisibility(i3 | decorView.getSystemUiVisibility());
        }

        protected void h(int i3) {
            this.f34551a.addFlags(i3);
        }

        protected void j(int i3) {
            View decorView = this.f34551a.getDecorView();
            decorView.setSystemUiVisibility((~i3) & decorView.getSystemUiVisibility());
        }

        protected void k(int i3) {
            this.f34551a.clearFlags(i3);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl23 extends Impl20 {
        Impl23(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean b() {
            return (this.f34551a.getDecorView().getSystemUiVisibility() & Utility.DEFAULT_STREAM_BUFFER_SIZE) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void d(boolean z2) {
            if (!z2) {
                j(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                return;
            }
            k(67108864);
            h(Integer.MIN_VALUE);
            g(Utility.DEFAULT_STREAM_BUFFER_SIZE);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl26 extends Impl23 {
        Impl26(Window window, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void c(boolean z2) {
            if (!z2) {
                j(16);
                return;
            }
            k(134217728);
            h(Integer.MIN_VALUE);
            g(16);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl31 extends Impl30 {
        Impl31(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }

        Impl31(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(windowInsetsController, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl35 extends Impl31 {
        Impl35(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(window, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl30, androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean b() {
            return (this.f34554b.getSystemBarsAppearance() & 8) != 0;
        }

        Impl35(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            super(windowInsetsController, windowInsetsControllerCompat, softwareKeyboardControllerCompat);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnControllableInsetsChangedListener {
    }

    private WindowInsetsControllerCompat(WindowInsetsController windowInsetsController) {
        if (Build.VERSION.SDK_INT >= 35) {
            this.f34550a = new Impl35(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
        } else {
            this.f34550a = new Impl30(windowInsetsController, this, new SoftwareKeyboardControllerCompat(windowInsetsController));
        }
    }

    public static WindowInsetsControllerCompat f(WindowInsetsController windowInsetsController) {
        return new WindowInsetsControllerCompat(windowInsetsController);
    }

    public void a(int i3) {
        this.f34550a.a(i3);
    }

    public boolean b() {
        return this.f34550a.b();
    }

    public void c(boolean z2) {
        this.f34550a.c(z2);
    }

    public void d(boolean z2) {
        this.f34550a.d(z2);
    }

    public void e(int i3) {
        this.f34550a.e(i3);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl30 extends Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final WindowInsetsControllerCompat f34553a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final WindowInsetsController f34554b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final SoftwareKeyboardControllerCompat f34555c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final SimpleArrayMap f34556d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        protected Window f34557e;

        /* JADX INFO: renamed from: androidx.core.view.WindowInsetsControllerCompat$Impl30$1, reason: invalid class name */
        /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
        class AnonymousClass1 implements WindowInsetsAnimationControlListener {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private WindowInsetsAnimationControllerCompat f34558a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            final /* synthetic */ WindowInsetsAnimationControlListenerCompat f34559b;

            public void onCancelled(WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f34559b.a(windowInsetsAnimationController == null ? null : this.f34558a);
            }

            public void onFinished(WindowInsetsAnimationController windowInsetsAnimationController) {
                this.f34559b.c(this.f34558a);
            }

            public void onReady(WindowInsetsAnimationController windowInsetsAnimationController, int i3) {
                WindowInsetsAnimationControllerCompat windowInsetsAnimationControllerCompat = new WindowInsetsAnimationControllerCompat(windowInsetsAnimationController);
                this.f34558a = windowInsetsAnimationControllerCompat;
                this.f34559b.b(windowInsetsAnimationControllerCompat, i3);
            }
        }

        Impl30(Window window, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this(window.getInsetsController(), windowInsetsControllerCompat, softwareKeyboardControllerCompat);
            this.f34557e = window;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void a(int i3) {
            if ((i3 & 8) != 0) {
                this.f34555c.a();
            }
            this.f34554b.hide(i3 & (-9));
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public boolean b() {
            this.f34554b.setSystemBarsAppearance(0, 0);
            return (this.f34554b.getSystemBarsAppearance() & 8) != 0;
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void c(boolean z2) {
            if (z2) {
                if (this.f34557e != null) {
                    f(16);
                }
                this.f34554b.setSystemBarsAppearance(16, 16);
            } else {
                if (this.f34557e != null) {
                    g(16);
                }
                this.f34554b.setSystemBarsAppearance(0, 16);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        public void d(boolean z2) {
            if (z2) {
                if (this.f34557e != null) {
                    f(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                }
                this.f34554b.setSystemBarsAppearance(8, 8);
            } else {
                if (this.f34557e != null) {
                    g(Utility.DEFAULT_STREAM_BUFFER_SIZE);
                }
                this.f34554b.setSystemBarsAppearance(0, 8);
            }
        }

        @Override // androidx.core.view.WindowInsetsControllerCompat.Impl
        void e(int i3) {
            if ((i3 & 8) != 0) {
                this.f34555c.b();
            }
            this.f34554b.show(i3 & (-9));
        }

        protected void f(int i3) {
            View decorView = this.f34557e.getDecorView();
            decorView.setSystemUiVisibility(i3 | decorView.getSystemUiVisibility());
        }

        protected void g(int i3) {
            View decorView = this.f34557e.getDecorView();
            decorView.setSystemUiVisibility((~i3) & decorView.getSystemUiVisibility());
        }

        Impl30(WindowInsetsController windowInsetsController, WindowInsetsControllerCompat windowInsetsControllerCompat, SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat) {
            this.f34556d = new SimpleArrayMap();
            this.f34554b = windowInsetsController;
            this.f34553a = windowInsetsControllerCompat;
            this.f34555c = softwareKeyboardControllerCompat;
        }
    }

    public WindowInsetsControllerCompat(Window window, View view) {
        SoftwareKeyboardControllerCompat softwareKeyboardControllerCompat = new SoftwareKeyboardControllerCompat(view);
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 35) {
            this.f34550a = new Impl35(window, this, softwareKeyboardControllerCompat);
        } else if (i3 >= 30) {
            this.f34550a = new Impl30(window, this, softwareKeyboardControllerCompat);
        } else {
            this.f34550a = new Impl26(window, softwareKeyboardControllerCompat);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl {
        Impl() {
        }

        public boolean b() {
            return false;
        }

        void a(int i3) {
        }

        public void c(boolean z2) {
        }

        public void d(boolean z2) {
        }

        void e(int i3) {
        }
    }
}
