package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.SplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.applovin.exoplayer2.common.base.Ascii;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewSpline extends SplineSet {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AlphaSet extends ViewSpline {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setAlpha(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CustomSet extends ViewSpline {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        String f32560f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        SparseArray f32561g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float[] f32562h;

        public CustomSet(String str, SparseArray sparseArray) {
            this.f32560f = str.split(",")[1];
            this.f32561g = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void e(int i3, float f3) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.SplineSet
        public void h(int i3) {
            int size = this.f32561g.size();
            int iH = ((ConstraintAttribute) this.f32561g.valueAt(0)).h();
            double[] dArr = new double[size];
            this.f32562h = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, iH);
            for (int i4 = 0; i4 < size; i4++) {
                int iKeyAt = this.f32561g.keyAt(i4);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f32561g.valueAt(i4);
                dArr[i4] = ((double) iKeyAt) * 0.01d;
                constraintAttribute.f(this.f32562h);
                int i5 = 0;
                while (true) {
                    if (i5 < this.f32562h.length) {
                        dArr2[i4][i5] = r6[i5];
                        i5++;
                    }
                }
            }
            this.f31815a = CurveFit.a(i3, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            this.f31815a.e(f3, this.f32562h);
            CustomSupport.b((ConstraintAttribute) this.f32561g.valueAt(0), view, this.f32562h);
        }

        public void l(int i3, ConstraintAttribute constraintAttribute) {
            this.f32561g.append(i3, constraintAttribute);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ElevationSet extends ViewSpline {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setElevation(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PivotXset extends ViewSpline {
        PivotXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setPivotX(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class PivotYset extends ViewSpline {
        PivotYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setPivotY(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ProgressSet extends ViewSpline {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        boolean f32563f = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f3));
                return;
            }
            if (this.f32563f) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f32563f = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f3)));
                } catch (IllegalAccessException e3) {
                    Log.e("ViewSpline", "unable to setProgress", e3);
                } catch (InvocationTargetException e4) {
                    Log.e("ViewSpline", "unable to setProgress", e4);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RotationSet extends ViewSpline {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setRotation(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RotationXset extends ViewSpline {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setRotationX(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RotationYset extends ViewSpline {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setRotationY(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ScaleXset extends ViewSpline {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setScaleX(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ScaleYset extends ViewSpline {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setScaleY(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TranslationXset extends ViewSpline {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setTranslationX(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TranslationYset extends ViewSpline {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setTranslationY(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TranslationZset extends ViewSpline {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
            view.setTranslationZ(a(f3));
        }
    }

    public static ViewSpline i(String str, SparseArray sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ViewSpline j(String str) {
        str.getClass();
        byte b3 = -1;
        switch (str.hashCode()) {
            case -1249320806:
                if (str.equals("rotationX")) {
                    b3 = 0;
                }
                break;
            case -1249320805:
                if (str.equals("rotationY")) {
                    b3 = 1;
                }
                break;
            case -1225497657:
                if (str.equals("translationX")) {
                    b3 = 2;
                }
                break;
            case -1225497656:
                if (str.equals("translationY")) {
                    b3 = 3;
                }
                break;
            case -1225497655:
                if (str.equals("translationZ")) {
                    b3 = 4;
                }
                break;
            case -1001078227:
                if (str.equals("progress")) {
                    b3 = 5;
                }
                break;
            case -908189618:
                if (str.equals("scaleX")) {
                    b3 = 6;
                }
                break;
            case -908189617:
                if (str.equals("scaleY")) {
                    b3 = 7;
                }
                break;
            case -797520672:
                if (str.equals("waveVariesBy")) {
                    b3 = 8;
                }
                break;
            case -760884510:
                if (str.equals("transformPivotX")) {
                    b3 = 9;
                }
                break;
            case -760884509:
                if (str.equals("transformPivotY")) {
                    b3 = 10;
                }
                break;
            case -40300674:
                if (str.equals("rotation")) {
                    b3 = Ascii.VT;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b3 = Ascii.FF;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b3 = Ascii.CR;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b3 = Ascii.SO;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    b3 = Ascii.SI;
                }
                break;
        }
        switch (b3) {
        }
        return new AlphaSet();
    }

    public abstract void k(View view, float f3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PathRotate extends ViewSpline {
        public void l(View view, float f3, double d3, double d4) {
            view.setRotation(a(f3) + ((float) Math.toDegrees(Math.atan2(d4, d3))));
        }

        @Override // androidx.constraintlayout.motion.utils.ViewSpline
        public void k(View view, float f3) {
        }
    }
}
