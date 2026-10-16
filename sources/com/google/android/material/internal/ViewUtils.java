package com.google.android.material.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.inputmethod.InputMethodManager;
import androidx.core.content.ContextCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;
import com.google.android.material.drawable.DrawableUtils;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes6.dex */
public class ViewUtils {

    /* JADX INFO: renamed from: com.google.android.material.internal.ViewUtils$1, reason: invalid class name */
    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    class AnonymousClass1 implements OnApplyWindowInsetsListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ boolean f81307a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ boolean f81308b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ boolean f81309c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ OnApplyWindowInsetsListener f81310d;

        @Override // com.google.android.material.internal.ViewUtils.OnApplyWindowInsetsListener
        public WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding) {
            if (this.f81307a) {
                relativePadding.f81316d += windowInsetsCompat.j();
            }
            boolean zO = ViewUtils.o(view);
            if (this.f81308b) {
                if (zO) {
                    relativePadding.f81315c += windowInsetsCompat.k();
                } else {
                    relativePadding.f81313a += windowInsetsCompat.k();
                }
            }
            if (this.f81309c) {
                if (zO) {
                    relativePadding.f81313a += windowInsetsCompat.l();
                } else {
                    relativePadding.f81315c += windowInsetsCompat.l();
                }
            }
            relativePadding.a(view);
            OnApplyWindowInsetsListener onApplyWindowInsetsListener = this.f81310d;
            return onApplyWindowInsetsListener != null ? onApplyWindowInsetsListener.a(view, windowInsetsCompat, relativePadding) : windowInsetsCompat;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public interface OnApplyWindowInsetsListener {
        WindowInsetsCompat a(View view, WindowInsetsCompat windowInsetsCompat, RelativePadding relativePadding);
    }

    public static void b(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            view.getViewTreeObserver().addOnGlobalLayoutListener(onGlobalLayoutListener);
        }
    }

    public static Rect c(View view, View view2) {
        int[] iArr = new int[2];
        view2.getLocationOnScreen(iArr);
        int i3 = iArr[0];
        int i4 = iArr[1];
        int[] iArr2 = new int[2];
        view.getLocationOnScreen(iArr2);
        int i5 = i3 - iArr2[0];
        int i6 = i4 - iArr2[1];
        return new Rect(i5, i6, view2.getWidth() + i5, view2.getHeight() + i6);
    }

    public static Rect d(View view) {
        return e(view, 0);
    }

    public static Rect e(View view, int i3) {
        return new Rect(view.getLeft(), view.getTop() + i3, view.getRight(), view.getBottom() + i3);
    }

    public static void f(View view, final OnApplyWindowInsetsListener onApplyWindowInsetsListener) {
        final RelativePadding relativePadding = new RelativePadding(ViewCompat.D(view), view.getPaddingTop(), ViewCompat.C(view), view.getPaddingBottom());
        ViewCompat.C0(view, new androidx.core.view.OnApplyWindowInsetsListener() { // from class: com.google.android.material.internal.ViewUtils.2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public WindowInsetsCompat a(View view2, WindowInsetsCompat windowInsetsCompat) {
                return onApplyWindowInsetsListener.a(view2, windowInsetsCompat, new RelativePadding(relativePadding));
            }
        });
        s(view);
    }

    public static float g(Context context, int i3) {
        return TypedValue.applyDimension(1, i3, context.getResources().getDisplayMetrics());
    }

    public static Integer h(View view) {
        ColorStateList colorStateListG = DrawableUtils.g(view.getBackground());
        if (colorStateListG != null) {
            return Integer.valueOf(colorStateListG.getDefaultColor());
        }
        return null;
    }

    public static ViewGroup i(View view) {
        if (view == null) {
            return null;
        }
        View rootView = view.getRootView();
        ViewGroup viewGroup = (ViewGroup) rootView.findViewById(R.id.content);
        if (viewGroup != null) {
            return viewGroup;
        }
        if (rootView == view || !(rootView instanceof ViewGroup)) {
            return null;
        }
        return (ViewGroup) rootView;
    }

    public static ViewOverlayImpl j(View view) {
        return l(i(view));
    }

    private static InputMethodManager k(View view) {
        return (InputMethodManager) ContextCompat.getSystemService(view.getContext(), InputMethodManager.class);
    }

    public static ViewOverlayImpl l(View view) {
        if (view == null) {
            return null;
        }
        return new ViewOverlayApi18(view);
    }

    public static float m(View view) {
        float fT = 0.0f;
        for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
            fT += ViewCompat.t((View) parent);
        }
        return fT;
    }

    public static void n(View view, boolean z2) {
        WindowInsetsControllerCompat windowInsetsControllerCompatJ;
        if (z2 && (windowInsetsControllerCompatJ = ViewCompat.J(view)) != null) {
            windowInsetsControllerCompatJ.a(WindowInsetsCompat.Type.d());
            return;
        }
        InputMethodManager inputMethodManagerK = k(view);
        if (inputMethodManagerK != null) {
            inputMethodManagerK.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    public static boolean o(View view) {
        return ViewCompat.y(view) == 1;
    }

    public static PorterDuff.Mode p(int i3, PorterDuff.Mode mode) {
        if (i3 == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i3 == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i3 == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i3) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    public static void q(View view, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (view != null) {
            r(view.getViewTreeObserver(), onGlobalLayoutListener);
        }
    }

    public static void r(ViewTreeObserver viewTreeObserver, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        viewTreeObserver.removeOnGlobalLayoutListener(onGlobalLayoutListener);
    }

    public static void s(View view) {
        if (ViewCompat.Q(view)) {
            ViewCompat.j0(view);
        } else {
            view.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() { // from class: com.google.android.material.internal.ViewUtils.3
                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewAttachedToWindow(View view2) {
                    view2.removeOnAttachStateChangeListener(this);
                    ViewCompat.j0(view2);
                }

                @Override // android.view.View.OnAttachStateChangeListener
                public void onViewDetachedFromWindow(View view2) {
                }
            });
        }
    }

    public static void t(final View view, final boolean z2) {
        view.requestFocus();
        view.post(new Runnable() { // from class: com.google.android.material.internal.e
            @Override // java.lang.Runnable
            public final void run() {
                ViewUtils.u(view, z2);
            }
        });
    }

    public static void u(View view, boolean z2) {
        WindowInsetsControllerCompat windowInsetsControllerCompatJ;
        if (!z2 || (windowInsetsControllerCompatJ = ViewCompat.J(view)) == null) {
            k(view).showSoftInput(view, 1);
        } else {
            windowInsetsControllerCompatJ.e(WindowInsetsCompat.Type.d());
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class RelativePadding {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f81313a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public int f81314b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public int f81315c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f81316d;

        public RelativePadding(int i3, int i4, int i5, int i6) {
            this.f81313a = i3;
            this.f81314b = i4;
            this.f81315c = i5;
            this.f81316d = i6;
        }

        public void a(View view) {
            ViewCompat.D0(view, this.f81313a, this.f81314b, this.f81315c, this.f81316d);
        }

        public RelativePadding(RelativePadding relativePadding) {
            this.f81313a = relativePadding.f81313a;
            this.f81314b = relativePadding.f81314b;
            this.f81315c = relativePadding.f81315c;
            this.f81316d = relativePadding.f81316d;
        }
    }
}
