package androidx.transition;

import android.graphics.Matrix;
import android.util.Log;
import android.view.View;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
class ViewUtilsApi19 {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static boolean f53566b = true;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static Method f53567c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static boolean f53568d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static Field f53569e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static boolean f53570f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private float[] f53571a;

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class Api29Impl {
        static float a(View view) {
            return view.getTransitionAlpha();
        }

        static void b(View view, float f3) {
            view.setTransitionAlpha(f3);
        }
    }

    ViewUtilsApi19() {
    }

    private void b() {
        if (f53568d) {
            return;
        }
        try {
            Class cls = Integer.TYPE;
            Method declaredMethod = View.class.getDeclaredMethod("setFrame", cls, cls, cls, cls);
            f53567c = declaredMethod;
            declaredMethod.setAccessible(true);
        } catch (NoSuchMethodException e3) {
            Log.i("ViewUtilsApi19", "Failed to retrieve setFrame method", e3);
        }
        f53568d = true;
    }

    public float c(View view) {
        if (f53566b) {
            try {
                return Api29Impl.a(view);
            } catch (NoSuchMethodError unused) {
                f53566b = false;
            }
        }
        return view.getAlpha();
    }

    public void e(View view, Matrix matrix) {
        if (matrix == null || matrix.isIdentity()) {
            view.setPivotX(view.getWidth() / 2);
            view.setPivotY(view.getHeight() / 2);
            view.setTranslationX(0.0f);
            view.setTranslationY(0.0f);
            view.setScaleX(1.0f);
            view.setScaleY(1.0f);
            view.setRotation(0.0f);
            return;
        }
        float[] fArr = this.f53571a;
        if (fArr == null) {
            fArr = new float[9];
            this.f53571a = fArr;
        }
        matrix.getValues(fArr);
        float f3 = fArr[3];
        float fSqrt = ((float) Math.sqrt(1.0f - (f3 * f3))) * (fArr[0] < 0.0f ? -1 : 1);
        float degrees = (float) Math.toDegrees(Math.atan2(f3, fSqrt));
        float f4 = fArr[0] / fSqrt;
        float f5 = fArr[4] / fSqrt;
        float f6 = fArr[2];
        float f7 = fArr[5];
        view.setPivotX(0.0f);
        view.setPivotY(0.0f);
        view.setTranslationX(f6);
        view.setTranslationY(f7);
        view.setRotation(degrees);
        view.setScaleX(f4);
        view.setScaleY(f5);
    }

    public void f(View view, int i3, int i4, int i5, int i6) {
        b();
        Method method = f53567c;
        if (method != null) {
            try {
                method.invoke(view, Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5), Integer.valueOf(i6));
            } catch (IllegalAccessException unused) {
            } catch (InvocationTargetException e3) {
                throw new RuntimeException(e3.getCause());
            }
        }
    }

    public void g(View view, float f3) {
        if (f53566b) {
            try {
                Api29Impl.b(view, f3);
                return;
            } catch (NoSuchMethodError unused) {
                f53566b = false;
            }
        }
        view.setAlpha(f3);
    }

    public void h(View view, int i3) {
        if (!f53570f) {
            try {
                Field declaredField = View.class.getDeclaredField("mViewFlags");
                f53569e = declaredField;
                declaredField.setAccessible(true);
            } catch (NoSuchFieldException unused) {
                Log.i("ViewUtilsApi19", "fetchViewFlagsField: ");
            }
            f53570f = true;
        }
        Field field = f53569e;
        if (field != null) {
            try {
                f53569e.setInt(view, i3 | (field.getInt(view) & (-13)));
            } catch (IllegalAccessException unused2) {
            }
        }
    }

    public void i(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            i((View) parent, matrix);
            matrix.preTranslate(-r0.getScrollX(), -r0.getScrollY());
        }
        matrix.preTranslate(view.getLeft(), view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        matrix.preConcat(matrix2);
    }

    public void j(View view, Matrix matrix) {
        Object parent = view.getParent();
        if (parent instanceof View) {
            j((View) parent, matrix);
            matrix.postTranslate(r0.getScrollX(), r0.getScrollY());
        }
        matrix.postTranslate(-view.getLeft(), -view.getTop());
        Matrix matrix2 = view.getMatrix();
        if (matrix2.isIdentity()) {
            return;
        }
        Matrix matrix3 = new Matrix();
        if (matrix2.invert(matrix3)) {
            matrix.postConcat(matrix3);
        }
    }

    public void a(View view) {
    }

    public void d(View view) {
    }
}
