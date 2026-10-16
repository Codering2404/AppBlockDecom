package androidx.transition;

import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Build;
import android.util.Property;
import android.view.View;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ViewUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ViewUtilsApi19 f53563a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    static final Property f53564b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    static final Property f53565c;

    static {
        if (Build.VERSION.SDK_INT >= 29) {
            f53563a = new ViewUtilsApi29();
        } else {
            f53563a = new ViewUtilsApi23();
        }
        f53564b = new Property<View, Float>(Float.class, "translationAlpha") { // from class: androidx.transition.ViewUtils.1
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Float get(View view) {
                return Float.valueOf(ViewUtils.b(view));
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(View view, Float f3) {
                ViewUtils.f(view, f3.floatValue());
            }
        };
        f53565c = new Property<View, Rect>(Rect.class, "clipBounds") { // from class: androidx.transition.ViewUtils.2
            @Override // android.util.Property
            /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
            public Rect get(View view) {
                return view.getClipBounds();
            }

            @Override // android.util.Property
            /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
            public void set(View view, Rect rect) {
                view.setClipBounds(rect);
            }
        };
    }

    static void a(View view) {
        f53563a.a(view);
    }

    static float b(View view) {
        return f53563a.c(view);
    }

    static void c(View view) {
        f53563a.d(view);
    }

    static void d(View view, Matrix matrix) {
        f53563a.e(view, matrix);
    }

    static void e(View view, int i3, int i4, int i5, int i6) {
        f53563a.f(view, i3, i4, i5, i6);
    }

    static void f(View view, float f3) {
        f53563a.g(view, f3);
    }

    static void g(View view, int i3) {
        f53563a.h(view, i3);
    }

    static void h(View view, Matrix matrix) {
        f53563a.i(view, matrix);
    }

    static void i(View view, Matrix matrix) {
        f53563a.j(view, matrix);
    }
}
