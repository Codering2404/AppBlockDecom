package androidx.core.view;

import android.R;
import android.os.Build;
import android.view.View;
import android.view.WindowInsets;
import android.view.WindowInsetsController;
import android.view.inputmethod.InputMethodManager;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public final class SoftwareKeyboardControllerCompat {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Impl f34431a;

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Impl20 extends Impl {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final View f34432a;

        Impl20(View view) {
            this.f34432a = view;
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void a() {
            View view = this.f34432a;
            if (view != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f34432a.getWindowToken(), 0);
            }
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void b() {
            final View viewFindViewById = this.f34432a;
            if (viewFindViewById == null) {
                return;
            }
            if (viewFindViewById.isInEditMode() || viewFindViewById.onCheckIsTextEditor()) {
                viewFindViewById.requestFocus();
            } else {
                viewFindViewById = viewFindViewById.getRootView().findFocus();
            }
            if (viewFindViewById == null) {
                viewFindViewById = this.f34432a.getRootView().findViewById(R.id.content);
            }
            if (viewFindViewById == null || !viewFindViewById.hasWindowFocus()) {
                return;
            }
            viewFindViewById.post(new Runnable() { // from class: androidx.core.view.n
                @Override // java.lang.Runnable
                public final void run() {
                    View view = viewFindViewById;
                    ((InputMethodManager) view.getContext().getSystemService("input_method")).showSoftInput(view, 0);
                }
            });
        }
    }

    public SoftwareKeyboardControllerCompat(View view) {
        if (Build.VERSION.SDK_INT >= 30) {
            this.f34431a = new Impl30(view);
        } else {
            this.f34431a = new Impl20(view);
        }
    }

    public void a() {
        this.f34431a.a();
    }

    public void b() {
        this.f34431a.b();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Impl30 extends Impl20 {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private View f34433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private WindowInsetsController f34434c;

        Impl30(View view) {
            super(view);
            this.f34433b = view;
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void a() {
            View view;
            WindowInsetsController windowInsetsController = this.f34434c;
            if (windowInsetsController == null) {
                View view2 = this.f34433b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController == null) {
                super.a();
                return;
            }
            final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
            WindowInsetsController.OnControllableInsetsChangedListener onControllableInsetsChangedListener = new WindowInsetsController.OnControllableInsetsChangedListener() { // from class: androidx.core.view.t
                @Override // android.view.WindowInsetsController.OnControllableInsetsChangedListener
                public final void onControllableInsetsChanged(WindowInsetsController windowInsetsController2, int i3) {
                    atomicBoolean.set((i3 & 8) != 0);
                }
            };
            windowInsetsController.addOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            if (!atomicBoolean.get() && (view = this.f34433b) != null) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).hideSoftInputFromWindow(this.f34433b.getWindowToken(), 0);
            }
            windowInsetsController.removeOnControllableInsetsChangedListener(onControllableInsetsChangedListener);
            windowInsetsController.hide(WindowInsets.Type.ime());
        }

        @Override // androidx.core.view.SoftwareKeyboardControllerCompat.Impl20, androidx.core.view.SoftwareKeyboardControllerCompat.Impl
        void b() {
            View view = this.f34433b;
            if (view != null && Build.VERSION.SDK_INT < 33) {
                ((InputMethodManager) view.getContext().getSystemService("input_method")).isActive();
            }
            WindowInsetsController windowInsetsController = this.f34434c;
            if (windowInsetsController == null) {
                View view2 = this.f34433b;
                windowInsetsController = view2 != null ? view2.getWindowInsetsController() : null;
            }
            if (windowInsetsController != null) {
                windowInsetsController.show(WindowInsets.Type.ime());
            }
            super.b();
        }

        Impl30(WindowInsetsController windowInsetsController) {
            super(null);
            this.f34434c = windowInsetsController;
        }
    }

    SoftwareKeyboardControllerCompat(WindowInsetsController windowInsetsController) {
        this.f34431a = new Impl30(windowInsetsController);
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    private static class Impl {
        Impl() {
        }

        void a() {
        }

        void b() {
        }
    }
}
