package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.KeyCycleOscillator;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.applovin.exoplayer2.common.base.Ascii;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewOscillator extends KeyCycleOscillator {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AlphaSet extends ViewOscillator {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setAlpha(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class CustomSet extends ViewOscillator {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        float[] f32557h = new float[1];

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        protected ConstraintAttribute f32558i;

        CustomSet() {
        }

        @Override // androidx.constraintlayout.core.motion.utils.KeyCycleOscillator
        protected void d(Object obj) {
            this.f32558i = (ConstraintAttribute) obj;
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            this.f32557h[0] = a(f3);
            CustomSupport.b(this.f32558i, view, this.f32557h);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ElevationSet extends ViewOscillator {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setElevation(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ProgressSet extends ViewOscillator {

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        boolean f32559h = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            Method method;
            if (view instanceof MotionLayout) {
                ((MotionLayout) view).setProgress(a(f3));
                return;
            }
            if (this.f32559h) {
                return;
            }
            try {
                method = view.getClass().getMethod("setProgress", Float.TYPE);
            } catch (NoSuchMethodException unused) {
                this.f32559h = true;
                method = null;
            }
            if (method != null) {
                try {
                    method.invoke(view, Float.valueOf(a(f3)));
                } catch (IllegalAccessException e3) {
                    Log.e("ViewOscillator", "unable to setProgress", e3);
                } catch (InvocationTargetException e4) {
                    Log.e("ViewOscillator", "unable to setProgress", e4);
                }
            }
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RotationSet extends ViewOscillator {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setRotation(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RotationXset extends ViewOscillator {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setRotationX(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RotationYset extends ViewOscillator {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setRotationY(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ScaleXset extends ViewOscillator {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setScaleX(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ScaleYset extends ViewOscillator {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setScaleY(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TranslationXset extends ViewOscillator {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setTranslationX(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TranslationYset extends ViewOscillator {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setTranslationY(a(f3));
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TranslationZset extends ViewOscillator {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
            view.setTranslationZ(a(f3));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ViewOscillator k(String str) {
        if (str.startsWith("CUSTOM")) {
            return new CustomSet();
        }
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
            case -40300674:
                if (str.equals("rotation")) {
                    b3 = 9;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b3 = 10;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b3 = Ascii.VT;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b3 = Ascii.FF;
                }
                break;
            case 156108012:
                if (str.equals("waveOffset")) {
                    b3 = Ascii.CR;
                }
                break;
        }
        switch (b3) {
            case 0:
                return new RotationXset();
            case 1:
                return new RotationYset();
            case 2:
                return new TranslationXset();
            case 3:
                return new TranslationYset();
            case 4:
                return new TranslationZset();
            case 5:
                return new ProgressSet();
            case 6:
                return new ScaleXset();
            case 7:
                return new ScaleYset();
            case 8:
                return new AlphaSet();
            case 9:
                return new RotationSet();
            case 10:
                return new ElevationSet();
            case 11:
                return new PathRotateSet();
            case 12:
                return new AlphaSet();
            case 13:
                return new AlphaSet();
            default:
                return null;
        }
    }

    public abstract void l(View view, float f3);

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PathRotateSet extends ViewOscillator {
        public void m(View view, float f3, double d3, double d4) {
            view.setRotation(a(f3) + ((float) Math.toDegrees(Math.atan2(d4, d3))));
        }

        @Override // androidx.constraintlayout.motion.utils.ViewOscillator
        public void l(View view, float f3) {
        }
    }
}
