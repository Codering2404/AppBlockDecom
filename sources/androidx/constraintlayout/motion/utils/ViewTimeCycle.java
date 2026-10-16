package androidx.constraintlayout.motion.utils;

import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import androidx.constraintlayout.core.motion.utils.CurveFit;
import androidx.constraintlayout.core.motion.utils.KeyCache;
import androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.ConstraintAttribute;
import com.applovin.exoplayer2.common.base.Ascii;
import java.lang.reflect.Array;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
/* JADX INFO: loaded from: classes3.dex */
public abstract class ViewTimeCycle extends TimeCycleSplineSet {

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class AlphaSet extends ViewTimeCycle {
        AlphaSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setAlpha(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class CustomSet extends ViewTimeCycle {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        String f32569l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        SparseArray f32570m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        SparseArray f32571n = new SparseArray();

        /* JADX INFO: renamed from: o, reason: collision with root package name */
        float[] f32572o;

        /* JADX INFO: renamed from: p, reason: collision with root package name */
        float[] f32573p;

        public CustomSet(String str, SparseArray sparseArray) {
            this.f32569l = str.split(",")[1];
            this.f32570m = sparseArray;
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void b(int i3, float f3, float f4, int i4, float f5) {
            throw new RuntimeException("don't call for custom attribute call setPoint(pos, ConstraintAttribute,...)");
        }

        @Override // androidx.constraintlayout.core.motion.utils.TimeCycleSplineSet
        public void e(int i3) {
            int size = this.f32570m.size();
            int iH = ((ConstraintAttribute) this.f32570m.valueAt(0)).h();
            double[] dArr = new double[size];
            int i4 = iH + 2;
            this.f32572o = new float[i4];
            this.f32573p = new float[iH];
            double[][] dArr2 = (double[][]) Array.newInstance((Class<?>) Double.TYPE, size, i4);
            for (int i5 = 0; i5 < size; i5++) {
                int iKeyAt = this.f32570m.keyAt(i5);
                ConstraintAttribute constraintAttribute = (ConstraintAttribute) this.f32570m.valueAt(i5);
                float[] fArr = (float[]) this.f32571n.valueAt(i5);
                dArr[i5] = ((double) iKeyAt) * 0.01d;
                constraintAttribute.f(this.f32572o);
                int i6 = 0;
                while (true) {
                    if (i6 < this.f32572o.length) {
                        dArr2[i5][i6] = r8[i6];
                        i6++;
                    }
                }
                double[] dArr3 = dArr2[i5];
                dArr3[iH] = fArr[0];
                dArr3[iH + 1] = fArr[1];
            }
            this.f31863a = CurveFit.a(i3, dArr, dArr2);
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            this.f31863a.e(f3, this.f32572o);
            float[] fArr = this.f32572o;
            float f4 = fArr[fArr.length - 2];
            float f5 = fArr[fArr.length - 1];
            long j4 = j3 - this.last_time;
            if (Float.isNaN(this.last_cycle)) {
                this.last_cycle = keyCache.a(view, this.f32569l, 0);
                if (Float.isNaN(this.last_cycle)) {
                    this.last_cycle = 0.0f;
                }
            }
            this.last_cycle = (float) ((((double) this.last_cycle) + ((j4 * 1.0E-9d) * ((double) f4))) % 1.0d);
            this.last_time = j3;
            float fA = a(this.last_cycle);
            this.f31870h = false;
            int i3 = 0;
            while (true) {
                float[] fArr2 = this.f32573p;
                if (i3 >= fArr2.length) {
                    break;
                }
                boolean z2 = this.f31870h;
                float f6 = this.f32572o[i3];
                this.f31870h = z2 | (((double) f6) != 0.0d);
                fArr2[i3] = (f6 * fA) + f5;
                i3++;
            }
            CustomSupport.b((ConstraintAttribute) this.f32570m.valueAt(0), view, this.f32573p);
            if (f4 != 0.0f) {
                this.f31870h = true;
            }
            return this.f31870h;
        }

        public void j(int i3, ConstraintAttribute constraintAttribute, float f3, int i4, float f4) {
            this.f32570m.append(i3, constraintAttribute);
            this.f32571n.append(i3, new float[]{f3, f4});
            this.f31864b = Math.max(this.f31864b, i4);
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ElevationSet extends ViewTimeCycle {
        ElevationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setElevation(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    public static class PathRotate extends ViewTimeCycle {
        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            return this.f31870h;
        }

        public boolean j(View view, KeyCache keyCache, float f3, long j3, double d3, double d4) {
            view.setRotation(f(f3, j3, view, keyCache) + ((float) Math.toDegrees(Math.atan2(d4, d3))));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ProgressSet extends ViewTimeCycle {

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        boolean f32574l = false;

        ProgressSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            ProgressSet progressSet;
            Method method;
            if (view instanceof MotionLayout) {
                progressSet = this;
                ((MotionLayout) view).setProgress(f(f3, j3, view, keyCache));
            } else {
                progressSet = this;
                if (progressSet.f32574l) {
                    return false;
                }
                try {
                    method = view.getClass().getMethod("setProgress", Float.TYPE);
                } catch (NoSuchMethodException unused) {
                    progressSet.f32574l = true;
                    method = null;
                }
                if (method != null) {
                    try {
                        method.invoke(view, Float.valueOf(progressSet.f(f3, j3, view, keyCache)));
                    } catch (IllegalAccessException e3) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e3);
                    } catch (InvocationTargetException e4) {
                        Log.e("ViewTimeCycle", "unable to setProgress", e4);
                    }
                }
            }
            return progressSet.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RotationSet extends ViewTimeCycle {
        RotationSet() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setRotation(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RotationXset extends ViewTimeCycle {
        RotationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setRotationX(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class RotationYset extends ViewTimeCycle {
        RotationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setRotationY(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ScaleXset extends ViewTimeCycle {
        ScaleXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setScaleX(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class ScaleYset extends ViewTimeCycle {
        ScaleYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setScaleY(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TranslationXset extends ViewTimeCycle {
        TranslationXset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setTranslationX(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TranslationYset extends ViewTimeCycle {
        TranslationYset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setTranslationY(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    /* JADX INFO: compiled from: r8-map-id-aeed946b5c08d53ab1183f044697ed0198ed68911f04ca2b3020ab9523212320 */
    static class TranslationZset extends ViewTimeCycle {
        TranslationZset() {
        }

        @Override // androidx.constraintlayout.motion.utils.ViewTimeCycle
        public boolean i(View view, float f3, long j3, KeyCache keyCache) {
            view.setTranslationZ(f(f3, j3, view, keyCache));
            return this.f31870h;
        }
    }

    public static ViewTimeCycle g(String str, SparseArray sparseArray) {
        return new CustomSet(str, sparseArray);
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    public static ViewTimeCycle h(String str, long j3) {
        ViewTimeCycle rotationXset;
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
            case -40300674:
                if (str.equals("rotation")) {
                    b3 = 8;
                }
                break;
            case -4379043:
                if (str.equals("elevation")) {
                    b3 = 9;
                }
                break;
            case 37232917:
                if (str.equals("transitionPathRotate")) {
                    b3 = 10;
                }
                break;
            case 92909918:
                if (str.equals("alpha")) {
                    b3 = Ascii.VT;
                }
                break;
        }
        switch (b3) {
            case 0:
                rotationXset = new RotationXset();
                break;
            case 1:
                rotationXset = new RotationYset();
                break;
            case 2:
                rotationXset = new TranslationXset();
                break;
            case 3:
                rotationXset = new TranslationYset();
                break;
            case 4:
                rotationXset = new TranslationZset();
                break;
            case 5:
                rotationXset = new ProgressSet();
                break;
            case 6:
                rotationXset = new ScaleXset();
                break;
            case 7:
                rotationXset = new ScaleYset();
                break;
            case 8:
                rotationXset = new RotationSet();
                break;
            case 9:
                rotationXset = new ElevationSet();
                break;
            case 10:
                rotationXset = new PathRotate();
                break;
            case 11:
                rotationXset = new AlphaSet();
                break;
            default:
                return null;
        }
        rotationXset.c(j3);
        return rotationXset;
    }

    public float f(float f3, long j3, View view, KeyCache keyCache) {
        this.f31863a.e(f3, this.f31869g);
        float[] fArr = this.f31869g;
        float f4 = fArr[1];
        if (f4 == 0.0f) {
            this.f31870h = false;
            return fArr[2];
        }
        if (Float.isNaN(this.last_cycle)) {
            this.last_cycle = keyCache.a(view, this.f31868f, 0);
            if (Float.isNaN(this.last_cycle)) {
                this.last_cycle = 0.0f;
            }
        }
        this.last_cycle = (float) ((((double) this.last_cycle) + (((j3 - this.last_time) * 1.0E-9d) * ((double) f4))) % 1.0d);
        keyCache.b(view, this.f31868f, 0, this.last_cycle);
        this.last_time = j3;
        float f5 = this.f31869g[0];
        float fA = (a(this.last_cycle) * f5) + this.f31869g[2];
        this.f31870h = (f5 == 0.0f && f4 == 0.0f) ? false : true;
        return fA;
    }

    public abstract boolean i(View view, float f3, long j3, KeyCache keyCache);
}
